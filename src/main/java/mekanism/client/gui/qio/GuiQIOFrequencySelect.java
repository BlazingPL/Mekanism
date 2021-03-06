package mekanism.client.gui.qio;

import com.mojang.blaze3d.matrix.MatrixStack;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nonnull;
import mekanism.api.text.EnumColor;
import mekanism.client.gui.GuiMekanism;
import mekanism.client.gui.element.GuiConfirmationDialog;
import mekanism.client.gui.element.GuiConfirmationDialog.DialogType;
import mekanism.client.gui.element.button.ColorButton;
import mekanism.client.gui.element.button.MekanismButton;
import mekanism.client.gui.element.button.TranslationButton;
import mekanism.client.gui.element.scroll.GuiTextScrollList;
import mekanism.client.gui.element.slot.GuiSlot;
import mekanism.client.gui.element.slot.SlotType;
import mekanism.client.gui.element.text.BackgroundType;
import mekanism.client.gui.element.text.GuiTextField;
import mekanism.client.gui.element.text.InputValidator;
import mekanism.common.MekanismLang;
import mekanism.common.content.qio.QIOFrequency;
import mekanism.common.lib.frequency.Frequency;
import mekanism.common.lib.frequency.Frequency.FrequencyIdentity;
import mekanism.common.lib.frequency.FrequencyManager;
import mekanism.common.util.text.OwnerDisplay;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.text.ITextComponent;

public abstract class GuiQIOFrequencySelect<CONTAINER extends Container> extends GuiMekanism<CONTAINER> {

    private MekanismButton publicButton;
    private MekanismButton privateButton;
    private MekanismButton setButton;
    private MekanismButton deleteButton;
    private GuiTextScrollList scrollList;
    private GuiTextField frequencyField;
    private boolean privateMode;

    private boolean init = false;

    public GuiQIOFrequencySelect(CONTAINER container, PlayerInventory inv, ITextComponent title) {
        super(container, inv, title);
        ySize -= 6;
    }

    @Override
    public void func_231160_c_() {
        super.func_231160_c_();
        func_230480_a_(scrollList = new GuiTextScrollList(this, 27, 39, 122, 42));

        func_230480_a_(publicButton = new TranslationButton(this, getGuiLeft() + 27, getGuiTop() + 17, 60, 20, MekanismLang.PUBLIC, () -> {
            privateMode = false;
            updateButtons();
        }));
        func_230480_a_(privateButton = new TranslationButton(this, getGuiLeft() + 89, getGuiTop() + 17, 60, 20, MekanismLang.PRIVATE, () -> {
            privateMode = true;
            updateButtons();
        }));
        func_230480_a_(setButton = new TranslationButton(this, getGuiLeft() + 27, getGuiTop() + 120, 50, 18, MekanismLang.BUTTON_SET, () -> {
            int selection = scrollList.getSelection();
            if (selection != -1) {
                Frequency freq = privateMode ? getPrivateFrequencies().get(selection) : getPublicFrequencies().get(selection);
                setFrequency(freq.getName());
            }
            updateButtons();
        }));
        func_230480_a_(deleteButton = new TranslationButton(this, getGuiLeft() + 79, getGuiTop() + 120, 50, 18, MekanismLang.BUTTON_DELETE,
              () -> GuiConfirmationDialog.show(this, MekanismLang.FREQUENCY_DELETE_CONFIRM.translate(), () -> {
                  int selection = scrollList.getSelection();
                  if (selection != -1) {
                      Frequency freq = privateMode ? getPrivateFrequencies().get(selection) : getPublicFrequencies().get(selection);
                      sendRemoveFrequency(freq.getIdentity());
                      scrollList.clearSelection();
                  }
                  updateButtons();
              }, DialogType.DANGER)));
        func_230480_a_(new GuiSlot(SlotType.NORMAL, this, 131, 120));
        func_230480_a_(new ColorButton(this, getGuiLeft() + 132, getGuiTop() + 121, 16, 16,
              () -> getFrequency() != null ? getFrequency().getColor() : null,
              () -> sendColorUpdate(0),
              () -> sendColorUpdate(1)));
        func_230480_a_(frequencyField = new GuiTextField(this, 50, 106, 98, 11));
        frequencyField.setMaxStringLength(FrequencyManager.MAX_FREQ_LENGTH);
        frequencyField.setBackground(BackgroundType.INNER_SCREEN);
        frequencyField.setEnterHandler(this::setFrequency);
        frequencyField.setInputValidator(InputValidator.or(InputValidator.DIGIT, InputValidator.LETTER, InputValidator.FREQUENCY_CHARS));
        frequencyField.addCheckmarkButton(this::setFrequency);
        updateButtons();
    }

    public void setFrequency(String freq) {
        if (!freq.isEmpty()) {
            sendSetFrequency(new FrequencyIdentity(freq, !privateMode));
        }
    }

    public ITextComponent getSecurity(Frequency freq) {
        if (freq.isPublic()) {
            return MekanismLang.PUBLIC.translate();
        }
        return MekanismLang.PRIVATE.translateColored(EnumColor.DARK_RED);
    }

    private void updateButtons() {
        if (getOwnerUsername() == null) {
            return;
        }
        List<String> text = new ArrayList<>();
        if (privateMode) {
            for (Frequency freq : getPrivateFrequencies()) {
                text.add(freq.getName());
            }
        } else {
            for (Frequency freq : getPublicFrequencies()) {
                text.add(freq.getName() + " (" + freq.getClientOwner() + ")");
            }
        }
        scrollList.setText(text);
        if (privateMode) {
            publicButton.field_230693_o_ = true;
            privateButton.field_230693_o_ = false;
        } else {
            publicButton.field_230693_o_ = false;
            privateButton.field_230693_o_ = true;
        }
        if (scrollList.hasSelection()) {
            Frequency freq = privateMode ? getPrivateFrequencies().get(scrollList.getSelection()) :
                             getPublicFrequencies().get(scrollList.getSelection());
            setButton.field_230693_o_ = getFrequency() == null || !getFrequency().equals(freq);
            deleteButton.field_230693_o_ = getOwnerUUID().equals(freq.getOwner());
        } else {
            setButton.field_230693_o_ = false;
            deleteButton.field_230693_o_ = false;
        }
    }

    @Override
    public void func_231023_e_() {
        super.func_231023_e_();
        Frequency freq = getFrequency();
        if (!init && getFrequency() != null) {
            init = true;
            privateMode = freq.isPrivate();
        }
        updateButtons();
    }

    @Override
    public boolean func_231044_a_(double mouseX, double mouseY, int button) {
        updateButtons();
        return super.func_231044_a_(mouseX, mouseY, button);
    }

    private void setFrequency() {
        setFrequency(frequencyField.getText());
        frequencyField.setText("");
        updateButtons();
    }

    @Override
    protected void drawForegroundText(@Nonnull MatrixStack matrix, int mouseX, int mouseY) {
        drawTitleText(matrix, MekanismLang.QIO_FREQUENCY_SELECT.translate(), 5);
        drawString(matrix, OwnerDisplay.of(getOwnerUUID(), getOwnerUsername()).getTextComponent(), 8, 143, titleTextColor());
        ITextComponent frequencyComponent = MekanismLang.FREQUENCY.translate();
        drawString(matrix, frequencyComponent, 32, 84, titleTextColor());
        ITextComponent securityComponent = MekanismLang.SECURITY.translate("");
        drawString(matrix, securityComponent, 32, 94, titleTextColor());
        Frequency frequency = getFrequency();
        int frequencyOffset = getStringWidth(frequencyComponent) + 1;
        if (frequency == null) {
            drawString(matrix, MekanismLang.NONE.translateColored(EnumColor.DARK_RED), 32 + frequencyOffset, 84, 0x797979);
            drawString(matrix, MekanismLang.NONE.translateColored(EnumColor.DARK_RED), 32 + getStringWidth(securityComponent), 94, 0x797979);
        } else {
            drawTextScaledBound(matrix, frequency.getName(), 32 + frequencyOffset, 84, 0x797979, xSize - 32 - frequencyOffset - 4);
            drawString(matrix, getSecurity(frequency), 32 + getStringWidth(securityComponent), 94, 0x797979);
        }
        drawTextScaledBound(matrix, MekanismLang.SET.translate(), 27, 107, titleTextColor(), 20);
        super.drawForegroundText(matrix, mouseX, mouseY);
    }

    public abstract void sendSetFrequency(FrequencyIdentity identity);

    public abstract void sendRemoveFrequency(FrequencyIdentity identity);

    public abstract void sendColorUpdate(int extra);

    public abstract QIOFrequency getFrequency();

    public abstract String getOwnerUsername();

    public abstract UUID getOwnerUUID();

    public abstract List<QIOFrequency> getPublicFrequencies();

    public abstract List<QIOFrequency> getPrivateFrequencies();
}
