package mekanism.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import javax.annotation.Nonnull;
import mekanism.client.render.MekanismRenderer;
import mekanism.client.render.MekanismRenderer.GlowInfo;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.MekanismUtils.ResourceType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ModelQuantumEntangloporter extends Model {

    private static final ResourceLocation OVERLAY = MekanismUtils.getResource(ResourceType.RENDER, "quantum_entangloporter_overlay.png");

    private final ModelRenderer portTop;
    private final ModelRenderer portBottom;
    private final ModelRenderer portLeft;
    private final ModelRenderer portRight;
    private final ModelRenderer portBack;
    private final ModelRenderer portFront;
    private final ModelRenderer energyCubeCore;
    private final ModelRenderer frameEdge1;
    private final ModelRenderer frameEdge2;
    private final ModelRenderer frameEdge3;
    private final ModelRenderer frameEdge4;
    private final ModelRenderer frameEdge5;
    private final ModelRenderer frameEdge6;
    private final ModelRenderer frameEdge7;
    private final ModelRenderer frameEdge8;
    private final ModelRenderer frameEdge9;
    private final ModelRenderer frameEdge10;
    private final ModelRenderer frameEdge11;
    private final ModelRenderer frameEdge12;
    private final ModelRenderer frame1;
    private final ModelRenderer frame2;
    private final ModelRenderer frame3;
    private final ModelRenderer frame4;
    private final ModelRenderer frame5;
    private final ModelRenderer frame6;
    private final ModelRenderer frame7;
    private final ModelRenderer frame8;
    private final ModelRenderer frame9;
    private final ModelRenderer frame10;
    private final ModelRenderer frame11;
    private final ModelRenderer frame12;
    private final ModelRenderer corner1;
    private final ModelRenderer corner2;
    private final ModelRenderer corner3;
    private final ModelRenderer corner4;
    private final ModelRenderer corner5;
    private final ModelRenderer corner6;
    private final ModelRenderer corner7;
    private final ModelRenderer corner8;
    private final ModelRenderer portRightLarge;
    private final ModelRenderer portLeftLarge;

    public ModelQuantumEntangloporter() {
        textureWidth = 128;
        textureHeight = 64;

        portTop = new ModelRenderer(this, 36, 0);
        portTop.func_228304_a_(0F, 0F, 0F, 8, 1, 8, false);
        portTop.setRotationPoint(-4F, 8F, -4F);
        portTop.setTextureSize(128, 64);
        portTop.mirror = true;
        setRotation(portTop, 0F, 0F, 0F);
        portBottom = new ModelRenderer(this, 36, 9);
        portBottom.func_228304_a_(0F, 0F, 0F, 8, 1, 8, false);
        portBottom.setRotationPoint(-4F, 23F, -4F);
        portBottom.setTextureSize(128, 64);
        portBottom.mirror = true;
        setRotation(portBottom, 0F, 0F, 0F);
        portLeft = new ModelRenderer(this, 0, 0);
        portLeft.func_228304_a_(0F, 0F, 0F, 1, 8, 8, false);
        portLeft.setRotationPoint(-8F, 12F, -4F);
        portLeft.setTextureSize(128, 64);
        portLeft.mirror = true;
        setRotation(portLeft, 0F, 0F, 0F);
        portRight = new ModelRenderer(this, 0, 0);
        portRight.mirror = true;
        portRight.func_228304_a_(0F, 0F, 0F, 1, 8, 8, false);
        portRight.setRotationPoint(7F, 12F, -4F);
        portRight.setTextureSize(128, 64);
        setRotation(portRight, 0F, 0F, 0F);
        portBack = new ModelRenderer(this, 18, 9);
        portBack.func_228304_a_(0F, 0F, 0F, 8, 8, 1, false);
        portBack.setRotationPoint(-4F, 12F, 7F);
        portBack.setTextureSize(128, 64);
        portBack.mirror = true;
        setRotation(portBack, 0F, 0F, 0F);
        portFront = new ModelRenderer(this, 18, 0);
        portFront.func_228304_a_(0F, 0F, 0F, 8, 8, 1, false);
        portFront.setRotationPoint(-4F, 12F, -8F);
        portFront.setTextureSize(128, 64);
        portFront.mirror = true;
        setRotation(portFront, 0F, 0F, 0F);
        energyCubeCore = new ModelRenderer(this, 0, 41);
        energyCubeCore.func_228304_a_(-2F, -2F, -2F, 4, 4, 4, false);
        energyCubeCore.setRotationPoint(0F, 16F, 0F);
        energyCubeCore.setTextureSize(128, 64);
        energyCubeCore.mirror = true;
        setRotation(energyCubeCore, 0.7132579F, 0.403365F, 0.645384F);
        frameEdge1 = new ModelRenderer(this, 0, 16);
        frameEdge1.func_228304_a_(0F, 0F, 0F, 1, 10, 1, false);
        frameEdge1.setRotationPoint(-7.5F, 11F, -7.5F);
        frameEdge1.setTextureSize(128, 64);
        frameEdge1.mirror = true;
        setRotation(frameEdge1, 0F, 0F, 0F);
        frameEdge2 = new ModelRenderer(this, 0, 16);
        frameEdge2.func_228304_a_(0F, 0F, 0F, 1, 10, 1, false);
        frameEdge2.setRotationPoint(6.5F, 11F, -7.5F);
        frameEdge2.setTextureSize(128, 64);
        frameEdge2.mirror = true;
        setRotation(frameEdge2, 0F, 0F, 0F);
        frameEdge3 = new ModelRenderer(this, 0, 16);
        frameEdge3.func_228304_a_(0F, 0F, 0F, 1, 10, 1, false);
        frameEdge3.setRotationPoint(-7.5F, 11F, 6.5F);
        frameEdge3.setTextureSize(128, 64);
        frameEdge3.mirror = true;
        setRotation(frameEdge3, 0F, 0F, 0F);
        frameEdge4 = new ModelRenderer(this, 0, 16);
        frameEdge4.func_228304_a_(0F, 0F, 0F, 1, 10, 1, false);
        frameEdge4.setRotationPoint(6.5F, 11F, 6.5F);
        frameEdge4.setTextureSize(128, 64);
        frameEdge4.mirror = true;
        setRotation(frameEdge4, 0F, 0F, 0F);
        frameEdge5 = new ModelRenderer(this, 4, 27);
        frameEdge5.func_228304_a_(0F, 0F, 0F, 10, 1, 1, false);
        frameEdge5.setRotationPoint(-5F, 22.5F, -7.5F);
        frameEdge5.setTextureSize(128, 64);
        frameEdge5.mirror = true;
        setRotation(frameEdge5, 0F, 0F, 0F);
        frameEdge6 = new ModelRenderer(this, 4, 16);
        frameEdge6.func_228304_a_(0F, 0F, 0F, 1, 1, 10, false);
        frameEdge6.setRotationPoint(-7.5F, 22.5F, -5F);
        frameEdge6.setTextureSize(128, 64);
        frameEdge6.mirror = true;
        setRotation(frameEdge6, 0F, 0F, 0F);
        frameEdge7 = new ModelRenderer(this, 4, 16);
        frameEdge7.func_228304_a_(0F, 0F, 0F, 1, 1, 10, false);
        frameEdge7.setRotationPoint(6.5F, 22.5F, -5F);
        frameEdge7.setTextureSize(128, 64);
        frameEdge7.mirror = true;
        setRotation(frameEdge7, 0F, 0F, 0F);
        frameEdge8 = new ModelRenderer(this, 4, 27);
        frameEdge8.func_228304_a_(0F, 0F, 0F, 10, 1, 1, false);
        frameEdge8.setRotationPoint(-5F, 22.5F, 6.5F);
        frameEdge8.setTextureSize(128, 64);
        frameEdge8.mirror = true;
        setRotation(frameEdge8, 0F, 0F, 0F);
        frameEdge9 = new ModelRenderer(this, 4, 27);
        frameEdge9.func_228304_a_(0F, 0F, 0F, 10, 1, 1, false);
        frameEdge9.setRotationPoint(-5F, 8.5F, -7.5F);
        frameEdge9.setTextureSize(128, 64);
        frameEdge9.mirror = true;
        setRotation(frameEdge9, 0F, 0F, 0F);
        frameEdge10 = new ModelRenderer(this, 4, 16);
        frameEdge10.func_228304_a_(0F, 0F, 0F, 1, 1, 10, false);
        frameEdge10.setRotationPoint(-7.5F, 8.5F, -5F);
        frameEdge10.setTextureSize(128, 64);
        frameEdge10.mirror = true;
        setRotation(frameEdge10, 0F, 0F, 0F);
        frameEdge11 = new ModelRenderer(this, 4, 16);
        frameEdge11.func_228304_a_(0F, 0F, 0F, 1, 1, 10, false);
        frameEdge11.setRotationPoint(6.5F, 8.5F, -5F);
        frameEdge11.setTextureSize(128, 64);
        frameEdge11.mirror = true;
        setRotation(frameEdge11, 0F, 0F, 0F);
        frameEdge12 = new ModelRenderer(this, 4, 27);
        frameEdge12.func_228304_a_(0F, 0F, 0F, 10, 1, 1, false);
        frameEdge12.setRotationPoint(-5F, 8.5F, 6.5F);
        frameEdge12.setTextureSize(128, 64);
        frameEdge12.mirror = true;
        setRotation(frameEdge12, 0F, 0F, 0F);
        frame1 = new ModelRenderer(this, 0, 29);
        frame1.func_228304_a_(0F, 0F, 0F, 2, 10, 2, false);
        frame1.setRotationPoint(-7F, 11F, -7F);
        frame1.setTextureSize(128, 64);
        frame1.mirror = true;
        setRotation(frame1, 0F, 0F, 0F);
        frame2 = new ModelRenderer(this, 0, 29);
        frame2.mirror = true;
        frame2.func_228304_a_(0F, 0F, 0F, 2, 10, 2, false);
        frame2.setRotationPoint(5F, 11F, -7F);
        frame2.setTextureSize(128, 64);
        setRotation(frame2, 0F, 0F, 0F);
        frame3 = new ModelRenderer(this, 8, 29);
        frame3.func_228304_a_(0F, 0F, 0F, 2, 10, 2, false);
        frame3.setRotationPoint(-7F, 11F, 5F);
        frame3.setTextureSize(128, 64);
        frame3.mirror = true;
        setRotation(frame3, 0F, 0F, 0F);
        frame4 = new ModelRenderer(this, 8, 29);
        frame4.mirror = true;
        frame4.func_228304_a_(0F, 0F, 0F, 2, 10, 2, false);
        frame4.setRotationPoint(5F, 11F, 5F);
        frame4.setTextureSize(128, 64);
        setRotation(frame4, 0F, 0F, 0F);
        frame5 = new ModelRenderer(this, 16, 45);
        frame5.func_228304_a_(0F, 0F, 0F, 10, 2, 2, false);
        frame5.setRotationPoint(-5F, 21F, -7F);
        frame5.setTextureSize(128, 64);
        frame5.mirror = true;
        setRotation(frame5, 0F, 0F, 0F);
        frame6 = new ModelRenderer(this, 40, 29);
        frame6.func_228304_a_(0F, 0F, 0F, 2, 2, 10, false);
        frame6.setRotationPoint(-7F, 21F, -5F);
        frame6.setTextureSize(128, 64);
        frame6.mirror = true;
        setRotation(frame6, 0F, 0F, 0F);
        frame7 = new ModelRenderer(this, 40, 29);
        frame7.mirror = true;
        frame7.func_228304_a_(0F, 0F, 0F, 2, 2, 10, false);
        frame7.setRotationPoint(5F, 21F, -5F);
        frame7.setTextureSize(128, 64);
        setRotation(frame7, 0F, 0F, 0F);
        frame8 = new ModelRenderer(this, 16, 49);
        frame8.func_228304_a_(0F, 0F, 0F, 10, 2, 2, false);
        frame8.setRotationPoint(-5F, 21F, 5F);
        frame8.setTextureSize(128, 64);
        frame8.mirror = true;
        setRotation(frame8, 0F, 0F, 0F);
        frame9 = new ModelRenderer(this, 16, 41);
        frame9.func_228304_a_(0F, 0F, 0F, 10, 2, 2, false);
        frame9.setRotationPoint(-5F, 9F, -7F);
        frame9.setTextureSize(128, 64);
        frame9.mirror = true;
        setRotation(frame9, 0F, 0F, 0F);
        frame10 = new ModelRenderer(this, 16, 29);
        frame10.func_228304_a_(0F, 0F, 0F, 2, 2, 10, false);
        frame10.setRotationPoint(-7F, 9F, -5F);
        frame10.setTextureSize(128, 64);
        frame10.mirror = true;
        setRotation(frame10, 0F, 0F, 0F);
        frame11 = new ModelRenderer(this, 16, 29);
        frame11.mirror = true;
        frame11.func_228304_a_(0F, 0F, 0F, 2, 2, 10, false);
        frame11.setRotationPoint(5F, 9F, -5F);
        frame11.setTextureSize(128, 64);
        setRotation(frame11, 0F, 0F, 0F);
        frame12 = new ModelRenderer(this, 16, 53);
        frame12.func_228304_a_(0F, 0F, 0F, 10, 2, 2, false);
        frame12.setRotationPoint(-5F, 9F, 5F);
        frame12.setTextureSize(128, 64);
        frame12.mirror = true;
        setRotation(frame12, 0F, 0F, 0F);
        corner1 = new ModelRenderer(this, 0, 49);
        corner1.func_228304_a_(0F, 0F, 0F, 3, 3, 3, false);
        corner1.setRotationPoint(-8F, 8F, -8F);
        corner1.setTextureSize(128, 64);
        corner1.mirror = true;
        setRotation(corner1, 0F, 0F, 0F);
        corner2 = new ModelRenderer(this, 0, 49);
        corner2.func_228304_a_(0F, 0F, 0F, 3, 3, 3, false);
        corner2.setRotationPoint(5F, 8F, -8F);
        corner2.setTextureSize(128, 64);
        corner2.mirror = true;
        setRotation(corner2, 0F, 0F, 0F);
        corner3 = new ModelRenderer(this, 0, 49);
        corner3.func_228304_a_(0F, 0F, 0F, 3, 3, 3, false);
        corner3.setRotationPoint(-8F, 8F, 5F);
        corner3.setTextureSize(128, 64);
        corner3.mirror = true;
        setRotation(corner3, 0F, 0F, 0F);
        corner4 = new ModelRenderer(this, 0, 49);
        corner4.func_228304_a_(0F, 0F, 0F, 3, 3, 3, false);
        corner4.setRotationPoint(5F, 8F, 5F);
        corner4.setTextureSize(128, 64);
        corner4.mirror = true;
        setRotation(corner4, 0F, 0F, 0F);
        corner5 = new ModelRenderer(this, 0, 49);
        corner5.func_228304_a_(0F, 0F, 0F, 3, 3, 3, false);
        corner5.setRotationPoint(-8F, 21F, -8F);
        corner5.setTextureSize(128, 64);
        corner5.mirror = true;
        setRotation(corner5, 0F, 0F, 0F);
        corner6 = new ModelRenderer(this, 0, 49);
        corner6.func_228304_a_(0F, 0F, 0F, 3, 3, 3, false);
        corner6.setRotationPoint(5F, 21F, -8F);
        corner6.setTextureSize(128, 64);
        corner6.mirror = true;
        setRotation(corner6, 0F, 0F, 0F);
        corner7 = new ModelRenderer(this, 0, 49);
        corner7.func_228304_a_(0F, 0F, 0F, 3, 3, 3, false);
        corner7.setRotationPoint(-8F, 21F, 5F);
        corner7.setTextureSize(128, 64);
        corner7.mirror = true;
        setRotation(corner7, 0F, 0F, 0F);
        corner8 = new ModelRenderer(this, 0, 49);
        corner8.func_228304_a_(0F, 0F, 0F, 3, 3, 3, false);
        corner8.setRotationPoint(5F, 21F, 5F);
        corner8.setTextureSize(128, 64);
        corner8.mirror = true;
        setRotation(corner8, 0F, 0F, 0F);
        portRightLarge = new ModelRenderer(this, 68, 0);
        portRightLarge.mirror = true;
        portRightLarge.func_228304_a_(0F, 0F, 0F, 1, 10, 10, false);
        portRightLarge.setRotationPoint(7F, 11F, -5F);
        portRightLarge.setTextureSize(128, 64);
        setRotation(portRightLarge, 0F, 0F, 0F);
        portLeftLarge = new ModelRenderer(this, 68, 0);
        portLeftLarge.func_228304_a_(0F, 0F, 0F, 1, 10, 10, false);
        portLeftLarge.setRotationPoint(-8F, 11F, -5F);
        portLeftLarge.setTextureSize(128, 64);
        portLeftLarge.mirror = true;
        setRotation(portLeftLarge, 0F, 0F, 0F);
    }

    @Override
    public void func_225598_a_(@Nonnull MatrixStack matrix, @Nonnull IVertexBuilder vertexBuilder, int light, int otherLight, float red, float green, float blue, float alpha) {
        //public void render(float size, TextureManager manager, boolean renderMain) {
        RenderSystem.pushMatrix();
        RenderSystem.shadeModel(GL11.GL_SMOOTH);
        RenderSystem.disableAlphaTest();
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);

        if (renderMain) {
            doRender(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        }

        manager.bindTexture(OVERLAY);
        RenderSystem.scalef(1.001F, 1.001F, 1.001F);
        RenderSystem.translatef(0, -0.0011F, 0);
        GlowInfo glowInfo = MekanismRenderer.enableGlow();

        doRender(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);

        MekanismRenderer.disableGlow(glowInfo);
        RenderSystem.disableBlend();
        RenderSystem.enableAlphaTest();
        RenderSystem.popMatrix();
    }

    public void doRender(@Nonnull MatrixStack matrix, @Nonnull IVertexBuilder vertexBuilder, int light, int otherLight, float red, float green, float blue, float alpha) {
        portTop.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        portBottom.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        portLeft.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        portRight.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        portBack.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        portFront.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        energyCubeCore.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frameEdge1.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frameEdge2.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frameEdge3.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frameEdge4.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frameEdge5.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frameEdge6.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frameEdge7.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frameEdge8.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frameEdge9.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frameEdge10.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frameEdge11.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frameEdge12.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frame1.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frame2.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frame3.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frame4.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frame5.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frame6.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frame7.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frame8.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frame9.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frame10.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frame11.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        frame12.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        corner1.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        corner2.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        corner3.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        corner4.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        corner5.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        corner6.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        corner7.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        corner8.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        //portRightLarge.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
        //portLeftLarge.func_228309_a_(matrix, vertexBuilder, light, otherLight, red, green, blue, alpha);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}