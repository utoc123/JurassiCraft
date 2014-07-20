package to.uk.ilexiconn.jurassicraft.data.entity.model;

//import thehippomaster.AnimationAPI.IAnimatedEntity;
//import thehippomaster.AnimationAPI.client.Animator;

import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityAnkylosaur;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAnkylosaur extends MowzieModelBase
{
    MowzieModelRenderer Head;
    MowzieModelRenderer Mouth;
    MowzieModelRenderer Head_Block;
    MowzieModelRenderer HeadHorn1;
    MowzieModelRenderer HeadHorn2;
    MowzieModelRenderer HeadHorn3;
    MowzieModelRenderer HeadHorn4;
    MowzieModelRenderer Body;
    MowzieModelRenderer BodySpikes;
    MowzieModelRenderer Neck;
    MowzieModelRenderer Tail;
    MowzieModelRenderer TailClub;
    MowzieModelRenderer Tail2;
    MowzieModelRenderer Thigh1;
    MowzieModelRenderer Thigh2;
    MowzieModelRenderer Thigh3;
    MowzieModelRenderer Thigh4;
    MowzieModelRenderer Leg1;
    MowzieModelRenderer Leg2;
    MowzieModelRenderer Leg3;
    MowzieModelRenderer Leg4;
    
	public static final float PI = (float)Math.PI;
//	private Animator animator;
	public int frame;

    public ModelAnkylosaur()
    {
//    	animator = new Animator(this);
    	
        textureWidth = 128;
        textureHeight = 64;

        Head = new MowzieModelRenderer(this, 0, 0);
        Head.addBox(-4F, 0F, -8F, 8, 7, 8);
        Head.setRotationPoint(0F, 10.5F, -10F);
        Head.setTextureSize(128, 64);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        Mouth = new MowzieModelRenderer(this, 0, 15);
        Mouth.addBox(-2F, 0F, -4F, 4, 6, 4);
        Mouth.setRotationPoint(0F, 12F, -18F);
        Mouth.setTextureSize(128, 64);
        Mouth.mirror = true;
        setRotation(Mouth, 0.4363323F, 0F, 0F);
        Head_Block = new MowzieModelRenderer(this, 24, 0);
        Head_Block.addBox(-3F, -1F, -5.5F, 6, 2, 5);
        Head_Block.setRotationPoint(0F, 10.5F, -10F);
        Head_Block.setTextureSize(128, 64);
        Head_Block.mirror = true;
        setRotation(Head_Block, 0.1745329F, 0F, 0F);
        HeadHorn1 = new MowzieModelRenderer(this, 32, 7);
        HeadHorn1.addBox(3F, -1F, -3.5F, 3, 3, 3);
        HeadHorn1.setRotationPoint(0F, 10.5F, -10F);
        HeadHorn1.setTextureSize(128, 64);
        HeadHorn1.mirror = true;
        setRotation(HeadHorn1, 0.1745329F, 0F, 0F);
        HeadHorn2 = new MowzieModelRenderer(this, 44, 7);
        HeadHorn2.addBox(-6F, -1F, -3.5F, 3, 3, 3);
        HeadHorn2.setRotationPoint(0F, 10.5F, -10F);
        HeadHorn2.setTextureSize(128, 64);
        HeadHorn2.mirror = true;
        setRotation(HeadHorn2, 0.1745329F, 0F, 0F);
        HeadHorn3 = new MowzieModelRenderer(this, 32, 7);
        HeadHorn3.addBox(3.5F, 3.5F, -3F, 3, 3, 3);
        HeadHorn3.setRotationPoint(0F, 10.5F, -10F);
        HeadHorn3.setTextureSize(128, 64);
        HeadHorn3.mirror = true;
        setRotation(HeadHorn3, 0F, 0F, 0.1745329F);
        HeadHorn4 = new MowzieModelRenderer(this, 44, 7);
        HeadHorn4.addBox(-6.5F, 3.5F, -3F, 3, 3, 3);
        HeadHorn4.setRotationPoint(0F, 10.5F, -10F);
        HeadHorn4.setTextureSize(128, 64);
        HeadHorn4.mirror = true;
        setRotation(HeadHorn4, 0F, 0F, -0.1745329F);
        Body = new MowzieModelRenderer(this, 68, 0);
        Body.addBox(-7F, -5F, -9F, 14, 10, 16);
        Body.setRotationPoint(0F, 14F, 0F);
        Body.setTextureSize(128, 64);
        Body.mirror = true;
        setRotation(Body, 0F, 0F, 0F);
        BodySpikes = new MowzieModelRenderer(this, 56, 26);
        BodySpikes.addBox(-9F, 0F, 0F, 18, 2, 18);
        BodySpikes.setRotationPoint(0F, 12F, -10F);
        BodySpikes.setTextureSize(128, 64);
        BodySpikes.mirror = true;
        setRotation(BodySpikes, 0F, 0F, 0F);
        Neck = new MowzieModelRenderer(this, 46, 0);
        Neck.addBox(-2F, 0F, -2F, 4, 5, 2);
        Neck.setRotationPoint(0F, 11F, -8F);
        Neck.setTextureSize(128, 64);
        Neck.mirror = true;
        setRotation(Neck, 0F, 0F, 0F);
        Tail = new MowzieModelRenderer(this, 104, 46);
        Tail.addBox(-3F, 0F, 0F, 6, 6, 6);
        Tail.setRotationPoint(0F, 10F, 6F);
        Tail.setTextureSize(128, 64);
        Tail.mirror = true;
        setRotation(Tail, -0.2617994F, 0F, 0F);
        TailClub = new MowzieModelRenderer(this, 80, 46);
        TailClub.addBox(-3F, 0F, 0F, 6, 6, 6);
        TailClub.setRotationPoint(0F, 11.5F, 17F - 13F);
        TailClub.setTextureSize(128, 64);
        TailClub.mirror = true;
        setRotation(TailClub, 0F, 0F, 0F);
        Tail2 = new MowzieModelRenderer(this, 56, 46);
        Tail2.addBox(-2F, 0F, 0F, 4, 4, 8);
        Tail2.setRotationPoint(0F, 12.5F, 10F);
        Tail2.setTextureSize(128, 64);
        Tail2.mirror = true;
        setRotation(Tail2, 0F, 0F, 0F);
        Thigh1 = new MowzieModelRenderer(this, 18, 24);
        Thigh1.addBox(-2F, 0F, -4F, 4, 4, 4);
        Thigh1.setRotationPoint(7F, 17F, -4F);
        Thigh1.setTextureSize(128, 64);
        Thigh1.mirror = true;
        setRotation(Thigh1, 0F, 0F, 0F);
        Thigh2 = new MowzieModelRenderer(this, 18, 24);
        Thigh2.addBox(-2F, 0F, -4F, 4, 4, 4);
        Thigh2.setRotationPoint(-7F, 17F, -4F);
        Thigh2.setTextureSize(128, 64);
        Thigh2.mirror = true;
        setRotation(Thigh2, 0F, 0F, 0F);
        Thigh3 = new MowzieModelRenderer(this, 0, 25);
        Thigh3.addBox(-2F, 0F, -5F, 4, 5, 5);
        Thigh3.setRotationPoint(7F, 16F, 6F);
        Thigh3.setTextureSize(128, 64);
        Thigh3.mirror = true;
        setRotation(Thigh3, 0F, 0F, 0F);
        Thigh4 = new MowzieModelRenderer(this, 0, 25);
        Thigh4.addBox(-2F, 0F, -5F, 4, 5, 5);
        Thigh4.setRotationPoint(-7F, 16F, 6F);
        Thigh4.setTextureSize(128, 64);
        Thigh4.mirror = true;
        setRotation(Thigh4, 0F, 0F, 0F);
        Leg1 = new MowzieModelRenderer(this, 0, 35);
        Leg1.addBox(-1.5F, 0F, -4F, 3, 4, 4);
        Leg1.setRotationPoint(6.5F, 20F, -3F);
        Leg1.setTextureSize(128, 64);
        Leg1.mirror = true;
        setRotation(Leg1, 0F, 0F, 0F);
        Leg2 = new MowzieModelRenderer(this, 0, 35);
        Leg2.addBox(-1.5F, 0F, -4F, 3, 4, 4);
        Leg2.setRotationPoint(-6.5F, 20F, -3F);
        Leg2.setTextureSize(128, 64);
        Leg2.mirror = true;
        setRotation(Leg2, 0F, 0F, 0F);
        Leg3 = new MowzieModelRenderer(this, 0, 35);
        Leg3.addBox(-1.5F, 0F, -4F, 3, 4, 4);
        Leg3.setRotationPoint(6.5F, 20F, 7F);
        Leg3.setTextureSize(128, 64);
        Leg3.mirror = true;
        setRotation(Leg3, 0F, 0F, 0F);
        Leg4 = new MowzieModelRenderer(this, 0, 35);
        Leg4.addBox(-1.5F, 0F, -4F, 3, 4, 4);
        Leg4.setRotationPoint(-6.5F, 20F, 7F);
        Leg4.setTextureSize(128, 64);
        Leg4.mirror = true;
        setRotation(Leg4, 0F, 0F, 0F);
        
        addChildTo(Mouth, Head);
        
        addChildTo(Leg1, Thigh1);
        addChildTo(Leg2, Thigh2);
        addChildTo(Leg3, Thigh3);
        addChildTo(Leg4, Thigh4);
        
        addChildTo(TailClub, Tail2);
        addChildTo(Tail2, Tail);
        
        //Compensation
        TailClub.rotationPointY -= 2F;

      Head.setInitValuesToCurrentPose();
      Mouth.setInitValuesToCurrentPose();
      Head_Block.setInitValuesToCurrentPose();
      HeadHorn1.setInitValuesToCurrentPose();
      HeadHorn2.setInitValuesToCurrentPose();
      HeadHorn3.setInitValuesToCurrentPose();
      HeadHorn4.setInitValuesToCurrentPose();
      Body.setInitValuesToCurrentPose();
      BodySpikes.setInitValuesToCurrentPose();
      Neck.setInitValuesToCurrentPose();
      Tail.setInitValuesToCurrentPose();
      TailClub.setInitValuesToCurrentPose();
      Tail2.setInitValuesToCurrentPose();
      Thigh1.setInitValuesToCurrentPose();
      Thigh2.setInitValuesToCurrentPose();
      Thigh3.setInitValuesToCurrentPose();
      Thigh4.setInitValuesToCurrentPose();
      Leg1.setInitValuesToCurrentPose();
      Leg2.setInitValuesToCurrentPose();
      Leg3.setInitValuesToCurrentPose();
      Leg4.setInitValuesToCurrentPose();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
//		animate((IAnimatedEntity)entity, f, f1, f2, f3, f4, f5);
        Head.render(f5);
//        Mouth.render(f5);
        Head_Block.render(f5);
        HeadHorn1.render(f5);
        HeadHorn2.render(f5);
        HeadHorn3.render(f5);
        HeadHorn4.render(f5);
        Body.render(f5);
        BodySpikes.render(f5);
        Neck.render(f5);
        Tail.render(f5);
//        TailClub.render(f5);
//        Tail2.render(f5);
        Thigh1.render(f5);
        Thigh2.render(f5);
        Thigh3.render(f5);
        Thigh4.render(f5);
 /*       Leg1.render(f5);
        Leg2.render(f5);
        Leg3.render(f5);
        Leg4.render(f5);*/
    }

/*    private void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
 //   	animator.update(entity);
    	setAngles();
        setRotationAngles(f, f1, f2, f3, f4, f5, (Entity) entity);
	}*/

	public void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
	
	public void setAngles() {
		  Head.setCurrentPoseToInitValues();
	      Mouth.setCurrentPoseToInitValues();
	      Head_Block.setCurrentPoseToInitValues();
	      HeadHorn1.setCurrentPoseToInitValues();
	      HeadHorn2.setCurrentPoseToInitValues();
	      HeadHorn3.setCurrentPoseToInitValues();
	      HeadHorn4.setCurrentPoseToInitValues();
	      Body.setCurrentPoseToInitValues();
	      BodySpikes.setCurrentPoseToInitValues();
	      Neck.setCurrentPoseToInitValues();
	      Tail.setCurrentPoseToInitValues();
	      TailClub.setCurrentPoseToInitValues();
	      Tail2.setCurrentPoseToInitValues();
	      Thigh1.setCurrentPoseToInitValues();
	      Thigh2.setCurrentPoseToInitValues();
	      Thigh3.setCurrentPoseToInitValues();
	      Thigh4.setCurrentPoseToInitValues();
	      Leg1.setCurrentPoseToInitValues();
	      Leg2.setCurrentPoseToInitValues();
	      Leg3.setCurrentPoseToInitValues();
	      Leg4.setCurrentPoseToInitValues();
	}

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        EntityAnkylosaur ankylosaur = (EntityAnkylosaur) entity;
        faceTarget(Head, 1, f3, f4);
        faceTarget(HeadHorn1, 1, f3, f4);
        faceTarget(HeadHorn2, 1, f3, f4);
        faceTarget(HeadHorn3, 1, f3, f4);
        faceTarget(HeadHorn4, 1, f3, f4);
        
        walk(Thigh1, 0.5F, 1F, false, 0F, f, f1);
        walk(Thigh2, 0.5F, 1F, true, 0F, f, f1);
        walk(Thigh3, 0.5F, 1F, true, 0F, f, f1);
        walk(Thigh4, 0.5F, 1F, false, 0F, f, f1);
        
        MowzieModelRenderer[] tailParts = {this.TailClub, this.Tail2, this.Tail};
        tailSwing(tailParts, 0.13F, 0.4F, 0, ankylosaur.frame);
    }
}
