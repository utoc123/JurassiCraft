// Date: 13.06.2014 13:30:47
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package to.uk.ilexiconn.jurassicraft.data.entity.model;

import ilexiconn.llib.client.model.MowzieModelBase;
import ilexiconn.llib.client.model.MowzieModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityMeganeura;

public class ModelMeganeura extends MowzieModelBase
{
  //fields
	MowzieModelRenderer Body;
    MowzieModelRenderer Tail;
    MowzieModelRenderer WingRightFront;
    MowzieModelRenderer WingRightBack;
    MowzieModelRenderer Head;
    MowzieModelRenderer WingLeftFront;
    MowzieModelRenderer WingLeftBack;
    MowzieModelRenderer LegLeftFront;
    MowzieModelRenderer LegLeftMid;
    MowzieModelRenderer LegLeftBack;
    MowzieModelRenderer LegRightFront;
    MowzieModelRenderer LegRightMid;
    MowzieModelRenderer LegRightBack;
    
    MowzieModelRenderer babyBody;
    MowzieModelRenderer babyTail;
    MowzieModelRenderer babyHead;
    MowzieModelRenderer babyLegLeftFront;
    MowzieModelRenderer babyLegLeftBack;
    MowzieModelRenderer babyLegLeftMid;
    MowzieModelRenderer babyLegRightFront;
    MowzieModelRenderer babyLegRightMid;
    MowzieModelRenderer babyLegRightBack;
    
    int frame = 0;
  
  public ModelMeganeura()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Body = new MowzieModelRenderer(this, 0, 8);
      Body.addBox(-1F, 0F, 0F, 2, 3, 8);
      Body.setRotationPoint(3F, 0F, 2F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Tail = new MowzieModelRenderer(this, 0, 20);
      Tail.addBox(-1F, 0F, 0F, 2, 2, 10);
      Tail.setRotationPoint(3F, 0F, 10F);
      Tail.setTextureSize(64, 32);
      Tail.mirror = true;
      setRotation(Tail, 0F, 0F, 0F);
      WingRightFront = new MowzieModelRenderer(this, 26, 11);
      WingRightFront.addBox(-10F, 0F, 0F, 10, 0, 4);
      WingRightFront.setRotationPoint(2F, 0F, 3.2F);
      WingRightFront.setTextureSize(64, 32);
      WingRightFront.mirror = true;
      setRotation(WingRightFront, 0F, 0F, 0F);
      WingRightBack = new MowzieModelRenderer(this, 38, 3);
      WingRightBack.addBox(-6F, 0F, 0F, 6, 0, 2);
      WingRightBack.setRotationPoint(2F, 0F, 7.5F);
      WingRightBack.setTextureSize(64, 32);
      WingRightBack.mirror = true;
      setRotation(WingRightBack, 0F, 0F, 0F);
      Head = new MowzieModelRenderer(this, 0, 0);
      Head.addBox(-3F, 0F, -4F, 6, 4, 4);
      Head.setRotationPoint(3F, 0F, 2F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      WingLeftFront = new MowzieModelRenderer(this, 26, 6);
      WingLeftFront.addBox(0F, 0F, 0F, 10, 0, 4);
      WingLeftFront.setRotationPoint(4F, 0F, 3.2F);
      WingLeftFront.setTextureSize(64, 32);
      WingLeftFront.mirror = true;
      setRotation(WingLeftFront, 0F, 0F, 0F);
      WingLeftBack = new MowzieModelRenderer(this, 38, 0);
      WingLeftBack.addBox(0F, 0F, 0F, 6, 0, 2);
      WingLeftBack.setRotationPoint(4F, 0F, 7.5F);
      WingLeftBack.setTextureSize(64, 32);
      WingLeftBack.mirror = true;
      setRotation(WingLeftBack, 0F, 0F, 0F);
      LegLeftFront = new MowzieModelRenderer(this, 26, 16);
      LegLeftFront.addBox(0F, 0F, 0F, 6, 2, 2);
      LegLeftFront.setRotationPoint(4F, 0.7F, 5.2F);
      LegLeftFront.setTextureSize(64, 32);
      LegLeftFront.mirror = true;
      setRotation(LegLeftFront, 0F, 0F, 0.1978956F);
      LegLeftMid = new MowzieModelRenderer(this, 26, 21);
      LegLeftMid.addBox(0F, 0F, 0F, 6, 2, 2);
      LegLeftMid.setRotationPoint(4F, 0.7F, 3F);
      LegLeftMid.setTextureSize(64, 32);
      LegLeftMid.mirror = true;
      setRotation(LegLeftMid, 0F, 0F, 0.1978956F);
      LegLeftBack = new MowzieModelRenderer(this, 26, 26);
      LegLeftBack.addBox(0F, 0F, 0F, 6, 2, 2);
      LegLeftBack.setRotationPoint(4F, 0.7F, 7.4F);
      LegLeftBack.setTextureSize(64, 32);
      LegLeftBack.mirror = true;
      setRotation(LegLeftBack, 0F, 0F, 0.1978956F);
      LegRightFront = new MowzieModelRenderer(this, 43, 16);
      LegRightFront.addBox(-6F, 0F, 0F, 6, 2, 2);
      LegRightFront.setRotationPoint(2F, 0.7F, 3F);
      LegRightFront.setTextureSize(64, 32);
      LegRightFront.mirror = true;
      setRotation(LegRightFront, 0F, 0F, -0.1979029F);
      LegRightMid = new MowzieModelRenderer(this, 43, 21);
      LegRightMid.addBox(-6F, 0F, 0F, 6, 2, 2);
      LegRightMid.setRotationPoint(2F, 0.7F, 5.2F);
      LegRightMid.setTextureSize(64, 32);
      LegRightMid.mirror = true;
      setRotation(LegRightMid, 0F, 0F, -0.1979029F);
      LegRightBack = new MowzieModelRenderer(this, 43, 26);
      LegRightBack.addBox(-6F, 0F, 0F, 6, 2, 2);
      LegRightBack.setRotationPoint(2F, 0.7F, 7.4F);
      LegRightBack.setTextureSize(64, 32);
      LegRightBack.mirror = true;
      setRotation(LegRightBack, 0F, 0F, -0.1979029F);
      
      babyBody = new MowzieModelRenderer(this, 0, 7);
      babyBody.addBox(-0.5F, 0F, 0F, 1, 1, 4);
      babyBody.setRotationPoint(1.5F, 0F, 0F);
      babyBody.setTextureSize(64, 32);
      babyBody.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      babyTail = new MowzieModelRenderer(this, 0, 14);
      babyTail.addBox(-1.5F, 0F, 0F, 3, 1, 5);
      babyTail.setRotationPoint(1.5F, 0F, 4F);
      babyTail.setTextureSize(64, 32);
      babyTail.mirror = true;
      setRotation(Tail, 0F, 0F, 0F);
      babyHead = new MowzieModelRenderer(this, 0, 1);
      babyHead.addBox(-1.5F, 0F, -2F, 3, 2, 2);
      babyHead.setRotationPoint(1.5F, 0F, 0F);
      babyHead.setTextureSize(64, 32);
      babyHead.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      babyLegLeftFront = new MowzieModelRenderer(this, 0, 21);
      babyLegLeftFront.addBox(-0.1F, -0.6F, 0F, 3, 1, 1);
      babyLegLeftFront.setRotationPoint(2F, 0.7F, 0F);
      babyLegLeftFront.setTextureSize(64, 32);
      babyLegLeftFront.mirror = true;
      setRotation(LegLeftFront, 0F, 0F, 0.1919862F);
      babyLegLeftBack = new MowzieModelRenderer(this, 0, 27);
      babyLegLeftBack.addBox(-0.1F, -0.6F, 0F, 3, 1, 1);
      babyLegLeftBack.setRotationPoint(2F, 0.7F, 2.4F);
      babyLegLeftBack.setTextureSize(64, 32);
      babyLegLeftBack.mirror = true;
      setRotation(LegLeftBack, 0F, 0F, 0.1919862F);
      babyLegLeftMid = new MowzieModelRenderer(this, 0, 24);
      babyLegLeftMid.addBox(-0.1F, -0.6F, 0F, 3, 1, 1);
      babyLegLeftMid.setRotationPoint(2F, 0.7F, 1.2F);
      babyLegLeftMid.setTextureSize(64, 32);
      babyLegLeftMid.mirror = true;
      setRotation(LegLeftMid, 0F, 0F, 0.1919862F);
      babyLegRightFront = new MowzieModelRenderer(this, 9, 21);
      babyLegRightFront.addBox(-2.9F, -0.6F, 0F, 3, 1, 1);
      babyLegRightFront.setRotationPoint(1F, 0.7F, 0F);
      babyLegRightFront.setTextureSize(64, 32);
      babyLegRightFront.mirror = true;
      setRotation(LegRightFront, 0F, 0F, -0.1919862F);
      babyLegRightMid = new MowzieModelRenderer(this, 9, 24);
      babyLegRightMid.addBox(-2.9F, -0.6F, 0F, 3, 1, 1);
      babyLegRightMid.setRotationPoint(1F, 0.7F, 1.2F);
      babyLegRightMid.setTextureSize(64, 32);
      babyLegRightMid.mirror = true;
      setRotation(LegRightMid, 0F, 0F, -0.1919862F);
      babyLegRightBack = new MowzieModelRenderer(this, 9, 27);
      babyLegRightBack.addBox(-2.9F, -0.6F, 0F, 3, 1, 1);
      babyLegRightBack.setRotationPoint(1F, 0.7F, 2.4F);
      babyLegRightBack.setTextureSize(64, 32);
      babyLegRightBack.mirror = true;
      setRotation(LegRightBack, 0F, 0F, -0.1919862F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
	EntityMeganeura meg = (EntityMeganeura) entity;
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    if(!meg.isChild()){
    Body.render(f5);
    Tail.render(f5);
    WingRightFront.render(f5);
    WingRightBack.render(f5);
    Head.render(f5);
    WingLeftFront.render(f5);
    WingLeftBack.render(f5);
    LegLeftFront.render(f5);
    LegLeftMid.render(f5);
    LegLeftBack.render(f5);
    LegRightFront.render(f5);
    LegRightMid.render(f5);
    LegRightBack.render(f5);
    
    }
    else {
    babyBody.render(f5);
    babyTail.render(f5);
    babyHead.render(f5);
    babyLegLeftFront.render(f5);
    babyLegLeftBack.render(f5);
    babyLegLeftMid.render(f5);
    babyLegRightFront.render(f5);
    babyLegRightMid.render(f5);
    babyLegRightBack.render(f5);
    }
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    flap(WingRightFront, 1F, 0.5F, false, 0F, frame, 1);
    flap(WingLeftFront, 1F, 0.5F, true, 0F, frame, 1);
    flap(WingRightBack, 1F, 0.5F, false, 0F, frame, 1);
    flap(WingLeftBack, 1F, 0.5F, true, 0F, frame, 1);
    
    frame += 1;
  }
}
