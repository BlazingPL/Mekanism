package mekanism.additions.client.render.entity;

import com.mojang.blaze3d.systems.RenderSystem;
import javax.annotation.Nonnull;
import mekanism.additions.client.model.ModelBalloon;
import mekanism.additions.common.entity.EntityBalloon;
import mekanism.api.text.EnumColor;
import mekanism.client.render.MekanismRenderer;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.MekanismUtils.ResourceType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class RenderBalloon extends EntityRenderer<EntityBalloon> {

    public ModelBalloon model = new ModelBalloon();

    public RenderBalloon(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(@Nonnull EntityBalloon entity) {
        return MekanismUtils.getResource(ResourceType.RENDER, "balloon.png");
    }

    @Override
    public void doRender(@Nonnull EntityBalloon balloon, double x, double y, double z, float f, float partialTick) {
        double renderPosX = x - (balloon.lastTickPosX + (balloon.func_226277_ct_() - balloon.lastTickPosX) * partialTick);
        double renderPosY = y - (balloon.lastTickPosY + (balloon.func_226277_ct_() - balloon.lastTickPosY) * partialTick);
        double renderPosZ = z - (balloon.lastTickPosZ + (balloon.func_226281_cx_() - balloon.lastTickPosZ) * partialTick);

        if (balloon.isLatchedToEntity()) {
            x = balloon.latchedEntity.lastTickPosX + (balloon.latchedEntity.func_226277_ct_() - balloon.latchedEntity.lastTickPosX) * partialTick;
            y = balloon.latchedEntity.lastTickPosY + (balloon.latchedEntity.func_226277_ct_() - balloon.latchedEntity.lastTickPosY) * partialTick;
            z = balloon.latchedEntity.lastTickPosZ + (balloon.latchedEntity.func_226281_cx_() - balloon.latchedEntity.lastTickPosZ) * partialTick;

            x += renderPosX;
            y += renderPosY;
            z += renderPosZ;

            y += balloon.getAddedHeight();
        }

        render(balloon.color, x, y, z);
    }

    public void render(EnumColor color, double x, double y, double z) {
        RenderSystem.pushMatrix();
        RenderSystem.translatef((float) x, (float) y, (float) z);
        RenderSystem.rotatef(180, 1, 0, 0);
        MekanismRenderer.bindTexture(MekanismUtils.getResource(ResourceType.RENDER, "balloon.png"));
        model.render(0.0625F, color);
        RenderSystem.popMatrix();
    }
}