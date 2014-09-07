package to.uk.ilexiconn.jurassicraft.data.entity.model;

import ilexiconn.llib.client.model.MowzieModelBase;
import ilexiconn.llib.client.model.MowzieModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelOviraptor extends MowzieModelBase
{
  //fields
    MowzieModelRenderer Head;
    MowzieModelRenderer Beak;
    MowzieModelRenderer Crest;
    MowzieModelRenderer Jaw;
    MowzieModelRenderer Neck;
    MowzieModelRenderer UpperBody;
    MowzieModelRenderer LowerBody;
    MowzieModelRenderer Tail1;
    MowzieModelRenderer Tail2;
    MowzieModelRenderer Thigh1;
    MowzieModelRenderer Thigh2;
    MowzieModelRenderer Calves1;
    MowzieModelRenderer Calves2;
    MowzieModelRenderer Foot1;
    MowzieModelRenderer Foot2;
    MowzieModelRenderer Arm1;
    MowzieModelRenderer Arm3;
    MowzieModelRenderer Arm2;
    MowzieModelRenderer Arm4;
    MowzieModelRenderer FeatherArm1;
    MowzieModelRenderer FeatherArm2;
    MowzieModelRenderer TailFeather;
  
  public ModelOviraptor()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Head = new MowzieModelRenderer(this, 0, 33);
      Head.addBox(0F, 0F, 0F, 5, 5, 7);
      Head.setRotationPoint(-1.5F, -6F, -7F);
      Head.setTextureSize(64, 64);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Beak = new MowzieModelRenderer(this, 0, 19);
      Beak.addBox(0F, 0F, 0F, 5, 1, 1);
      Beak.setRotationPoint(-1.5F, -1F, -7F);
      Beak.setTextureSize(64, 64);
      Beak.mirror = true;
      setRotation(Beak, 0.4363323F, 0F, 0F);
      Crest = new MowzieModelRenderer(this, 0, 7);
      Crest.addBox(0F, 0F, 0F, 2, 6, 6);
      Crest.setRotationPoint(0F, -8.5F, -9.5F);
      Crest.setTextureSize(64, 64);
      Crest.mirror = true;
      setRotation(Crest, 0.4363323F, 0F, 0F);
      Jaw = new MowzieModelRenderer(this, 0, 0);
      Jaw.addBox(0F, 0F, 0F, 4, 1, 5);
      Jaw.setRotationPoint(-1F, -1F, -6F);
      Jaw.setTextureSize(64, 64);
      Jaw.mirror = true;
      setRotation(Jaw, 0F, 0F, 0F);
      Neck = new MowzieModelRenderer(this, 30, 0);
      Neck.addBox(0F, 0F, 0F, 2, 10, 3);
      Neck.setRotationPoint(0F, -3F, -1.5F);
      Neck.setTextureSize(64, 64);
      Neck.mirror = true;
      setRotation(Neck, -0.0872665F, 0F, 0F);
      UpperBody = new MowzieModelRenderer(this, 40, 0);
      UpperBody.addBox(0F, 0F, -1F, 6, 6, 6);
      UpperBody.setRotationPoint(-2F, 5F, 0F);
      UpperBody.setTextureSize(64, 64);
      UpperBody.mirror = true;
      setRotation(UpperBody, -0.0872665F, 0F, 0F);
      LowerBody = new MowzieModelRenderer(this, 34, 12);
      LowerBody.addBox(0F, 0F, -1F, 8, 8, 7);
      LowerBody.setRotationPoint(-3F, 5.4F, 5F);
      LowerBody.setTextureSize(64, 64);
      LowerBody.mirror = true;
      setRotation(LowerBody, 0F, 0F, 0F);
      Tail1 = new MowzieModelRenderer(this, 42, 27);
      Tail1.addBox(0F, 0F, -1F, 4, 4, 7);
      Tail1.setRotationPoint(-1F, 6.4F, 11F);
      Tail1.setTextureSize(64, 64);
      Tail1.mirror = true;
      setRotation(Tail1, -0.0872665F, 0F, 0F);
      Tail2 = new MowzieModelRenderer(this, 20, 17);
      Tail2.addBox(1F, 0.6F, 5F, 2, 2, 10);
      Tail2.setRotationPoint(-1F, 6.4F, 11F);
      Tail2.setTextureSize(64, 64);
      Tail2.mirror = true;
      setRotation(Tail2, 0F, 0F, 0F);
      Thigh1 = new MowzieModelRenderer(this, 26, 29);
      Thigh1.addBox(0F, 0F, -1F, 3, 5, 5);
      Thigh1.setRotationPoint(5F, 10F, 7F);
      Thigh1.setTextureSize(64, 64);
      Thigh1.mirror = true;
      setRotation(Thigh1, -0.0872665F, 0F, 0F);
      Thigh2 = new MowzieModelRenderer(this, 26, 29);
      Thigh2.addBox(0F, 0F, -1F, 3, 5, 5);
      Thigh2.setRotationPoint(-6F, 10F, 7F);
      Thigh2.setTextureSize(64, 64);
      Thigh2.mirror = true;
      setRotation(Thigh2, -0.0872665F, 0F, 0F);
      Calves1 = new MowzieModelRenderer(this, 18, 29);
      Calves1.addBox(0F, 3.4F, 3.8F, 2, 9, 2);
      Calves1.setRotationPoint(5F, 10F, 7F);
      Calves1.setTextureSize(64, 64);
      Calves1.mirror = true;
      setRotation(Calves1, -0.1396263F, 0F, 0F);
      Calves2 = new MowzieModelRenderer(this, 18, 29);
      Calves2.addBox(1F, 3.4F, 3.8F, 2, 9, 2);
      Calves2.setRotationPoint(-6F, 10F, 7F);
      Calves2.setTextureSize(64, 64);
      Calves2.mirror = true;
      setRotation(Calves2, -0.1396263F, 0F, 0F);
      Foot1 = new MowzieModelRenderer(this, 32, 39);
      Foot1.addBox(0F, 12F, 0F, 3, 2, 4);
      Foot1.setRotationPoint(5F, 10F, 7F);
      Foot1.setTextureSize(64, 64);
      Foot1.mirror = true;
      setRotation(Foot1, 0F, 0F, 0F);
      Foot2 = new MowzieModelRenderer(this, 32, 39);
      Foot2.addBox(0F, 12F, 0F, 3, 2, 4);
      Foot2.setRotationPoint(-6F, 10F, 7F);
      Foot2.setTextureSize(64, 64);
      Foot2.mirror = true;
      setRotation(Foot2, 0F, 0F, 0F);
      Arm1 = new MowzieModelRenderer(this, 22, 0);
      Arm1.addBox(0F, 0F, -1F, 2, 4, 2);
      Arm1.setRotationPoint(4F, 8.4F, 0F);
      Arm1.setTextureSize(64, 64);
      Arm1.mirror = true;
      setRotation(Arm1, 0.1396263F, 0F, 0F);
      Arm3 = new MowzieModelRenderer(this, 22, 0);
      Arm3.addBox(0F, 0F, -1F, 2, 4, 2);
      Arm3.setRotationPoint(-4F, 8.4F, 0F);
      Arm3.setTextureSize(64, 64);
      Arm3.mirror = true;
      setRotation(Arm3, 0.1396263F, 0F, 0F);
      Arm2 = new MowzieModelRenderer(this, 22, 6);
      Arm2.addBox(0F, 0F, -1F, 2, 5, 2);
      Arm2.setRotationPoint(4F, 12.2F, 1.8F);
      Arm2.setTextureSize(64, 64);
      Arm2.mirror = true;
      setRotation(Arm2, -0.7853982F, 0F, 0F);
      Arm4 = new MowzieModelRenderer(this, 22, 6);
      Arm4.addBox(0F, 0F, -1F, 2, 5, 2);
      Arm4.setRotationPoint(-4F, 12.2F, 1.8F);
      Arm4.setTextureSize(64, 64);
      Arm4.mirror = true;
      setRotation(Arm4, -0.7853982F, 0F, 0F);
      FeatherArm1 = new MowzieModelRenderer(this, 18, 17);
      FeatherArm1.addBox(0F, 0F, -1F, 1, 5, 5);
      FeatherArm1.setRotationPoint(4F, 13F, 3.3F);
      FeatherArm1.setTextureSize(64, 64);
      FeatherArm1.mirror = true;
      setRotation(FeatherArm1, -0.7853982F, 0F, 0F);
      FeatherArm2 = new MowzieModelRenderer(this, 18, 17);
      FeatherArm2.addBox(0F, 0F, -1F, 1, 5, 5);
      FeatherArm2.setRotationPoint(-3F, 13F, 3.3F);
      FeatherArm2.setTextureSize(64, 64);
      FeatherArm2.mirror = true;
      setRotation(FeatherArm2, -0.7853982F, 0F, 0F);
      TailFeather = new MowzieModelRenderer(this, 36, 38);
      TailFeather.addBox(0F, 1F, 11F, 4, 1, 10);
      TailFeather.setRotationPoint(-1F, 6.4F, 11F);
      TailFeather.setTextureSize(64, 64);
      TailFeather.mirror = true;
      setRotation(TailFeather, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Head.render(f5);
    Beak.render(f5);
    Crest.render(f5);
    Jaw.render(f5);
    Neck.render(f5);
    UpperBody.render(f5);
    LowerBody.render(f5);
    Tail1.render(f5);
    Tail2.render(f5);
    Thigh1.render(f5);
    Thigh2.render(f5);
    Calves1.render(f5);
    Calves2.render(f5);
    Foot1.render(f5);
    Foot2.render(f5);
    Arm1.render(f5);
    Arm3.render(f5);
    Arm2.render(f5);
    Arm4.render(f5);
    FeatherArm1.render(f5);
    FeatherArm2.render(f5);
    TailFeather.render(f5);
  }
  
  private void setRotation(MowzieModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
    this.Tail1.rotateAngleX = MathHelper.cos(f * 0.3332F) * 0.2F * f1;
    this.Tail2.rotateAngleX = MathHelper.cos(f * 0.3332F) * 0.4F * f1;
    this.TailFeather.rotateAngleX = MathHelper.cos(f * 0.3332F) * 0.5F * f1;
    
    this.Thigh1.rotateAngleX = MathHelper.cos(f * 0.3332F) * 0.8F * f1;
    this.Calves1.rotateAngleX = MathHelper.cos(f * 0.3332F) * 0.8F * f1;
    this.Foot1.rotateAngleX = MathHelper.cos(f * 0.3332F) * 0.8F * f1;

    this.Thigh2.rotateAngleX = MathHelper.cos(f * 0.3332F+ (float)Math.PI) * 0.8F * f1;
    this.Calves2.rotateAngleX = MathHelper.cos(f * 0.3332F+ (float)Math.PI) * 0.8F * f1;
    this.Foot2.rotateAngleX = MathHelper.cos(f * 0.3332F+ (float)Math.PI) * 0.8F * f1;

  }

}
