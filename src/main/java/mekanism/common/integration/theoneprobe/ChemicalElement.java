package mekanism.common.integration.theoneprobe;

import javax.annotation.Nonnull;
import mekanism.api.chemical.ChemicalStack;
import mekanism.api.chemical.ChemicalUtils;
import mekanism.api.math.MathUtils;
import mekanism.client.render.MekanismRenderer;
import mekanism.common.MekanismLang;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;

public abstract class ChemicalElement extends TOPElement {

    @Nonnull
    protected final ChemicalStack<?> stored;
    protected final long capacity;

    protected ChemicalElement(@Nonnull ChemicalStack<?> stored, long capacity) {
        super(0xFF000000, 0xFFFFFF);
        this.stored = stored;
        this.capacity = capacity;
    }

    @Override
    public void toBytes(PacketBuffer buf) {
        ChemicalUtils.writeChemicalStack(buf, stored);
        buf.writeVarLong(capacity);
    }

    @Override
    public int getScaledLevel(int level) {
        if (capacity == 0 || stored.getAmount() == Long.MAX_VALUE) {
            return level;
        }
        return MathUtils.clampToInt(level * (double) stored.getAmount() / capacity);
    }

    @Override
    public TextureAtlasSprite getIcon() {
        return stored.isEmpty() ? null : MekanismRenderer.getChemicalTexture(stored.getType());
    }

    @Override
    public ITextComponent getText() {
        long amount = stored.getAmount();
        if (amount == Long.MAX_VALUE) {
            return MekanismLang.GENERIC_STORED.translate(stored.getType(), MekanismLang.INFINITE);
        }
        return MekanismLang.GENERIC_STORED_MB.translate(stored.getType(), amount);
    }

    @Override
    protected boolean applyRenderColor() {
        MekanismRenderer.color(stored.getType());
        return true;
    }
}