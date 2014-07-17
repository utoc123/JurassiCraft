package com.ilexiconn.jurassicraft.data.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

import com.ilexiconn.jurassicraft.data.entity.entity.EntityDilophosaurus;

public class ModelDilophosaurus extends ModelBase
{
  //fields
    ModelRenderer Left_Upper_Foot;
    ModelRenderer Right_Upper_Foot;
    ModelRenderer Left_Calf_1;
    ModelRenderer Right_Calf_1;
    ModelRenderer Left_Thigh;
    ModelRenderer Right_Thigh;
    ModelRenderer Body_1;
    ModelRenderer Body_2;
    ModelRenderer Neck;
    ModelRenderer Head;
    ModelRenderer Upper_Jaw;
    ModelRenderer Lower_Jaw;
    ModelRenderer Upper_Jaw_Ridge;
    ModelRenderer Crest_Left_1;
    ModelRenderer Crest_Right_1;
    ModelRenderer Tail_1;
    ModelRenderer Tail_2;
    ModelRenderer Tail_3;
    ModelRenderer Tail_4;
    ModelRenderer Tail_5;
    ModelRenderer Upper_Arm_Right;
    ModelRenderer Upper_Arm_Left;
    ModelRenderer Lower_Arm_Left;
    ModelRenderer Lower_Arm_Right;
    ModelRenderer Hand_Left;
    ModelRenderer Hand_Right;
    ModelRenderer Hand_Left_Claw_Left;
    ModelRenderer Hand_Left_Claw_Right;
    ModelRenderer Hand_Left_Claw_Middle;
    ModelRenderer Hand_Right_Claw_Right;
    ModelRenderer Hand_Right_Claw_Left;
    ModelRenderer Hand_Right_Claw_Middle;
    ModelRenderer Foot_Right;
    ModelRenderer Foot_Left;
    
    //ANGRY
    ModelRenderer Left_Upper_Foot1;
    ModelRenderer Right_Upper_Foot1;
    ModelRenderer Left_Calf_11;
    ModelRenderer Right_Calf_11;
    ModelRenderer Left_Thigh1;
    ModelRenderer Right_Thigh1;
    ModelRenderer Body_11;
    ModelRenderer Body_21;
    ModelRenderer Neck1;
    ModelRenderer Head1;
    ModelRenderer Upper_Jaw1;
    ModelRenderer Lower_Jaw1;
    ModelRenderer Upper_Jaw_Ridge1;
    ModelRenderer Crest_Left_11;
    ModelRenderer Crest_Right_11;
    ModelRenderer Tail_11;
    ModelRenderer Tail_21;
    ModelRenderer Tail_31;
    ModelRenderer Tail_41;
    ModelRenderer Tail_51;
    ModelRenderer Upper_Arm_Right1;
    ModelRenderer Upper_Arm_Left1;
    ModelRenderer Lower_Arm_Left1;
    ModelRenderer Lower_Arm_Right1;
    ModelRenderer Hand_Left1;
    ModelRenderer Hand_Right1;
    ModelRenderer Hand_Left_Claw_Left1;
    ModelRenderer Hand_Left_Claw_Right1;
    ModelRenderer Hand_Left_Claw_Middle1;
    ModelRenderer Hand_Right_Claw_Right1;
    ModelRenderer Hand_Right_Claw_Left1;
    ModelRenderer Hand_Right_Claw_Middle1;
    ModelRenderer Foot_Right1;
    ModelRenderer Foot_Left1;
    ModelRenderer Shape11;
  
  public ModelDilophosaurus()
  {
    textureWidth = 256;
    textureHeight = 256;
    
      Left_Upper_Foot = new ModelRenderer(this, 77, 3);
      Left_Upper_Foot.addBox(-1.5F, 0F, -3F, 3, 6, 3);
      Left_Upper_Foot.setRotationPoint(7F, 19F, 5F);
      Left_Upper_Foot.setTextureSize(256, 256);
      Left_Upper_Foot.mirror = true;
      setRotation(Left_Upper_Foot, -0.6108652F, 0F, 0F);
      Right_Upper_Foot = new ModelRenderer(this, 77, 3);
      Right_Upper_Foot.addBox(-1.5F, 0F, -3F, 3, 6, 3);
      Right_Upper_Foot.setRotationPoint(-7.2F, 19F, 4.933333F);
      Right_Upper_Foot.setTextureSize(256, 256);
      Right_Upper_Foot.mirror = true;
      setRotation(Right_Upper_Foot, -0.6108652F, 0F, 0F);
      Left_Calf_1 = new ModelRenderer(this, 65, 0);
      Left_Calf_1.addBox(-1.5F, 0F, 0F, 3, 12, 3);
      Left_Calf_1.setRotationPoint(7F, 11.7F, -5F);
      Left_Calf_1.setTextureSize(256, 256);
      Left_Calf_1.mirror = true;
      setRotation(Left_Calf_1, 0.7063936F, 0F, 0F);
      Right_Calf_1.mirror = true;
      Right_Calf_1 = new ModelRenderer(this, 65, 0);
      Right_Calf_1.addBox(-1.5F, 0F, 0F, 3, 12, 3);
      Right_Calf_1.setRotationPoint(-7F, 11.7F, -5F);
      Right_Calf_1.setTextureSize(256, 256);
      Right_Calf_1.mirror = true;
      setRotation(Right_Calf_1, 0.7238469F, 0F, 0F);
      Right_Calf_1.mirror = false;
      Left_Thigh = new ModelRenderer(this, 27, 57);
      Left_Thigh.addBox(0F, 0F, -12F, 5, 6, 12);
      Left_Thigh.setRotationPoint(4.5F, 2.2F, 2.7F);
      Left_Thigh.setTextureSize(256, 256);
      Left_Thigh.mirror = true;
      setRotation(Left_Thigh, 0.669215F, 0F, 0F);
      Right_Thigh.mirror = true;
      Right_Thigh = new ModelRenderer(this, 27, 57);
      Right_Thigh.addBox(-5F, 0F, -12F, 5, 6, 12);
      Right_Thigh.setRotationPoint(-4.5F, 2.2F, 2.7F);
      Right_Thigh.setTextureSize(256, 256);
      Right_Thigh.mirror = true;
      setRotation(Right_Thigh, 0.669215F, 0F, 0F);
      Right_Thigh.mirror = false;
      Body_1 = new ModelRenderer(this, 118, 0);
      Body_1.addBox(-4.5F, -4.3F, -13F, 9, 9, 21);
      Body_1.setRotationPoint(0F, 4.5F, 0F);
      Body_1.setTextureSize(256, 256);
      Body_1.mirror = true;
      setRotation(Body_1, -0.0371786F, 0F, 0F);
      Body_2 = new ModelRenderer(this, 182, 0);
      Body_2.addBox(-4F, 0F, -8F, 8, 8, 8);
      Body_2.setRotationPoint(0F, 0.7F, -6.8F);
      Body_2.setTextureSize(256, 256);
      Body_2.mirror = true;
      setRotation(Body_2, -0.1858931F, 0F, 0F);
      Neck = new ModelRenderer(this, 217, 0);
      Neck.addBox(-2.5F, 0F, -11F, 5, 5, 11);
      Neck.setRotationPoint(0F, 1F, -12F);
      Neck.setTextureSize(256, 256);
      Neck.mirror = true;
      setRotation(Neck, -0.5576792F, 0F, 0F);
      Head = new ModelRenderer(this, 0, 92);
      Head.addBox(-3.5F, 0F, -6F, 7, 7, 6);
      Head.setRotationPoint(0F, -5F, -21F);
      Head.setTextureSize(256, 256);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Upper_Jaw = new ModelRenderer(this, 30, 26);
      Upper_Jaw.addBox(-2F, 0F, 0F, 4, 3, 7);
      Upper_Jaw.setRotationPoint(0F, 0F, -26F);
      Upper_Jaw.setTextureSize(256, 256);
      Upper_Jaw.mirror = true;
      setRotation(Upper_Jaw, -3.141593F, 0F, 0F);
      Lower_Jaw = new ModelRenderer(this, 71, 27);
      Lower_Jaw.addBox(-1.5F, -1F, 0F, 3, 1, 6);
      Lower_Jaw.setRotationPoint(0F, 0F, -26F);
      Lower_Jaw.setTextureSize(256, 256);
      Lower_Jaw.mirror = true;
      setRotation(Lower_Jaw, -3.141593F, 0F, 0F);
      Upper_Jaw_Ridge = new ModelRenderer(this, 53, 27);
      Upper_Jaw_Ridge.addBox(-1.5F, -1.1F, 5.1F, 3, 2, 6);
      Upper_Jaw_Ridge.setRotationPoint(0F, -5F, -21F);
      Upper_Jaw_Ridge.setTextureSize(256, 256);
      Upper_Jaw_Ridge.mirror = true;
      setRotation(Upper_Jaw_Ridge, -2.881342F, 0F, 0F);
      Crest_Left_1 = new ModelRenderer(this, 0, 40);
      Crest_Left_1.addBox(-9.3F, -3.5F, -2F, 8, 6, 0);
      Crest_Left_1.setRotationPoint(0F, -5F, -21F);
      Crest_Left_1.setTextureSize(256, 256);
      Crest_Left_1.mirror = true;
      setRotation(Crest_Left_1, 0.2617994F, -1.570796F, 0F);
      Crest_Right_1 = new ModelRenderer(this, 0, 40);
      Crest_Right_1.addBox(-9.3F, -3.5F, 2F, 8, 6, 0);
      Crest_Right_1.setRotationPoint(0F, -5F, -21F);
      Crest_Right_1.setTextureSize(256, 256);
      Crest_Right_1.mirror = true;
      setRotation(Crest_Right_1, -0.2617994F, -1.570796F, 0F);
      Tail_1 = new ModelRenderer(this, 118, 39);
      Tail_1.addBox(-4.5F, 0F, 0F, 9, 8, 10);
      Tail_1.setRotationPoint(0F, 0.6F, 5F);
      Tail_1.setTextureSize(256, 256);
      Tail_1.mirror = true;
      setRotation(Tail_1, -0.1858931F, 0F, 0F);
      Tail_2 = new ModelRenderer(this, 118, 61);
      Tail_2.addBox(-4F, 0F, 0F, 8, 6, 8);
      Tail_2.setRotationPoint(0F, 3F, 13F);
      Tail_2.setTextureSize(256, 256);
      Tail_2.mirror = true;
      setRotation(Tail_2, -0.0743572F, 0F, 0F);
      Tail_3 = new ModelRenderer(this, 118, 80);
      Tail_3.addBox(-3F, 0F, 0F, 6, 5, 8);
      Tail_3.setRotationPoint(0F, 4F, 18F);
      Tail_3.setTextureSize(256, 256);
      Tail_3.mirror = true;
      setRotation(Tail_3, 0F, 0F, 0F);
      Tail_4 = new ModelRenderer(this, 119, 79);
      Tail_4.addBox(-2F, 0F, 0F, 4, 4, 9);
      Tail_4.setRotationPoint(0F, 4.5F, 23F);
      Tail_4.setTextureSize(256, 256);
      Tail_4.mirror = true;
      setRotation(Tail_4, 0.0371786F, 0F, 0F);
      Tail_5 = new ModelRenderer(this, 118, 100);
      Tail_5.addBox(-1.5F, 0F, 0F, 3, 3, 11);
      Tail_5.setRotationPoint(0F, 5F, 29F);
      Tail_5.setTextureSize(256, 256);
      Tail_5.mirror = true;
      setRotation(Tail_5, 0.0743572F, 0F, 0F);
      Upper_Arm_Right = new ModelRenderer(this, 0, 56);
      Upper_Arm_Right.addBox(-3F, 0F, 0F, 3, 3, 7);
      Upper_Arm_Right.setRotationPoint(-4.5F, 2F, -11F);
      Upper_Arm_Right.setTextureSize(256, 256);
      Upper_Arm_Right.mirror = true;
      setRotation(Upper_Arm_Right, -1.07818F, 0F, 0F);
      Upper_Arm_Left = new ModelRenderer(this, 0, 56);
      Upper_Arm_Left.addBox(0F, 0F, 0F, 3, 3, 7);
      Upper_Arm_Left.setRotationPoint(4.5F, 2F, -11F);
      Upper_Arm_Left.setTextureSize(256, 256);
      Upper_Arm_Left.mirror = true;
      setRotation(Upper_Arm_Left, -1.07818F, 0F, 0F);
      Lower_Arm_Left = new ModelRenderer(this, 0, 68);
      Lower_Arm_Left.addBox(-1F, 0F, -2F, 2, 5, 2);
      Lower_Arm_Left.setRotationPoint(6F, 8F, -8.5F);
      Lower_Arm_Left.setTextureSize(256, 256);
      Lower_Arm_Left.mirror = true;
      setRotation(Lower_Arm_Left, -0.6320364F, 0F, 0F);
      Lower_Arm_Right = new ModelRenderer(this, 0, 68);
      Lower_Arm_Right.addBox(-1F, 0F, -2F, 2, 5, 2);
      Lower_Arm_Right.setRotationPoint(-6F, 8F, -8.5F);
      Lower_Arm_Right.setTextureSize(256, 256);
      Lower_Arm_Right.mirror = true;
      setRotation(Lower_Arm_Right, -0.6320364F, 0F, 0F);
      Hand_Left = new ModelRenderer(this, 81, 54);
      Hand_Left.addBox(-1F, 0F, -1F, 2, 2, 1);
      Hand_Left.setRotationPoint(5.9F, 11F, -12.3F);
      Hand_Left.setTextureSize(256, 256);
      Hand_Left.mirror = true;
      setRotation(Hand_Left, 0F, -0.3490659F, 0F);
      Hand_Right = new ModelRenderer(this, 81, 54);
      Hand_Right.addBox(-1F, 0F, -1F, 2, 2, 1);
      Hand_Right.setRotationPoint(-5.9F, 11F, -12.3F);
      Hand_Right.setTextureSize(256, 256);
      Hand_Right.mirror = true;
      setRotation(Hand_Right, 0F, 0.3490659F, 0F);
      Hand_Left_Claw_Left = new ModelRenderer(this, 81, 45);
      Hand_Left_Claw_Left.addBox(-0.8F, 1F, -0.5F, 1, 2, 1);
      Hand_Left_Claw_Left.setRotationPoint(5.9F, 11F, -12.3F);
      Hand_Left_Claw_Left.setTextureSize(256, 256);
      Hand_Left_Claw_Left.mirror = true;
      setRotation(Hand_Left_Claw_Left, -0.4712389F, -1.919862F, 0F);
      Hand_Left_Claw_Right = new ModelRenderer(this, 81, 45);
      Hand_Left_Claw_Right.addBox(-1.2F, 1F, -0.5F, 1, 2, 1);
      Hand_Left_Claw_Right.setRotationPoint(5.9F, 11F, -12.3F);
      Hand_Left_Claw_Right.setTextureSize(256, 256);
      Hand_Left_Claw_Right.mirror = true;
      setRotation(Hand_Left_Claw_Right, 0F, -1.919862F, 0F);
      Hand_Left_Claw_Middle = new ModelRenderer(this, 81, 45);
      Hand_Left_Claw_Middle.addBox(-0.8F, 1F, -0.5F, 1, 2, 1);
      Hand_Left_Claw_Middle.setRotationPoint(5.9F, 11F, -12.3F);
      Hand_Left_Claw_Middle.setTextureSize(256, 256);
      Hand_Left_Claw_Middle.mirror = true;
      setRotation(Hand_Left_Claw_Middle, 0.4712389F, -1.919862F, 0F);
      Hand_Right_Claw_Right = new ModelRenderer(this, 81, 45);
      Hand_Right_Claw_Right.addBox(0.2F, 1F, -0.5F, 1, 2, 1);
      Hand_Right_Claw_Right.setRotationPoint(-5.9F, 11F, -12.3F);
      Hand_Right_Claw_Right.setTextureSize(256, 256);
      Hand_Right_Claw_Right.mirror = true;
      setRotation(Hand_Right_Claw_Right, 0F, 1.919862F, 0F);
      Hand_Right_Claw_Left = new ModelRenderer(this, 81, 45);
      Hand_Right_Claw_Left.addBox(-0.2F, 1F, -0.5F, 1, 2, 1);
      Hand_Right_Claw_Left.setRotationPoint(-5.9F, 11F, -12.3F);
      Hand_Right_Claw_Left.setTextureSize(256, 256);
      Hand_Right_Claw_Left.mirror = true;
      setRotation(Hand_Right_Claw_Left, 0.4712389F, 1.919862F, 0F);
      Hand_Right_Claw_Middle = new ModelRenderer(this, 81, 45);
      Hand_Right_Claw_Middle.addBox(-0.2F, 1F, -0.5F, 1, 2, 1);
      Hand_Right_Claw_Middle.setRotationPoint(-5.9F, 11F, -12.3F);
      Hand_Right_Claw_Middle.setTextureSize(256, 256);
      Hand_Right_Claw_Middle.mirror = true;
      setRotation(Hand_Right_Claw_Middle, -0.4712389F, 1.919862F, 0F);
      Foot_Right = new ModelRenderer(this, 0, 0);
      Foot_Right.addBox(-2F, 0F, -3F, 4, 2, 6);
      Foot_Right.setRotationPoint(-7.2F, 22F, 0F);
      Foot_Right.setTextureSize(256, 256);
      Foot_Right.mirror = true;
      setRotation(Foot_Right, 0F, 0F, 0F);
      Foot_Left = new ModelRenderer(this, 0, 0);
      Foot_Left.addBox(-2F, 0F, -3F, 4, 2, 6);
      Foot_Left.setRotationPoint(7F, 22F, 0F);
      Foot_Left.setTextureSize(256, 256);
      Foot_Left.mirror = true;
      setRotation(Foot_Left, 0F, 0F, 0F);
      
      
      //ANGRY
      Left_Upper_Foot1 = new ModelRenderer(this, 77, 3);
      Left_Upper_Foot1.addBox(-1.5F, 0F, -3F, 3, 6, 3);
      Left_Upper_Foot1.setRotationPoint(7F, 19F, 5F);
      Left_Upper_Foot1.setTextureSize(256, 256);
      Left_Upper_Foot1.mirror = true;
      setRotation(Left_Upper_Foot1, -0.6108652F, 0F, 0F);
      Right_Upper_Foot1 = new ModelRenderer(this, 77, 3);
      Right_Upper_Foot1.addBox(-1.5F, 0F, -3F, 3, 6, 3);
      Right_Upper_Foot1.setRotationPoint(-7.2F, 19F, 4.933333F);
      Right_Upper_Foot1.setTextureSize(256, 256);
      Right_Upper_Foot1.mirror = true;
      setRotation(Right_Upper_Foot1, -0.6108652F, 0F, 0F);
      Left_Calf_11 = new ModelRenderer(this, 65, 0);
      Left_Calf_11.addBox(-1.5F, 0F, 0F, 3, 12, 3);
      Left_Calf_11.setRotationPoint(7F, 11.7F, -5F);
      Left_Calf_11.setTextureSize(256, 256);
      Left_Calf_11.mirror = true;
      setRotation(Left_Calf_11, 0.7063936F, 0F, 0F);
      Right_Calf_11.mirror = true;
      Right_Calf_11 = new ModelRenderer(this, 65, 0);
      Right_Calf_11.addBox(-1.5F, 0F, 0F, 3, 12, 3);
      Right_Calf_11.setRotationPoint(-7F, 11.7F, -5F);
      Right_Calf_11.setTextureSize(256, 256);
      Right_Calf_11.mirror = true;
      setRotation(Right_Calf_11, 0.7238469F, 0F, 0F);
      Right_Calf_11.mirror = false;
      Left_Thigh1 = new ModelRenderer(this, 27, 57);
      Left_Thigh1.addBox(0F, 0F, -12F, 5, 6, 12);
      Left_Thigh1.setRotationPoint(4.5F, 2.2F, 2.7F);
      Left_Thigh1.setTextureSize(256, 256);
      Left_Thigh1.mirror = true;
      setRotation(Left_Thigh1, 0.669215F, 0F, 0F);
      Right_Thigh1.mirror = true;
      Right_Thigh1 = new ModelRenderer(this, 27, 57);
      Right_Thigh1.addBox(-5F, 0F, -12F, 5, 6, 12);
      Right_Thigh1.setRotationPoint(-4.5F, 2.2F, 2.7F);
      Right_Thigh1.setTextureSize(256, 256);
      Right_Thigh1.mirror = true;
      setRotation(Right_Thigh1, 0.669215F, 0F, 0F);
      Right_Thigh1.mirror = false;
      Body_11 = new ModelRenderer(this, 118, 0);
      Body_11.addBox(-4.5F, -4.3F, -13F, 9, 9, 21);
      Body_11.setRotationPoint(0F, 4.5F, 0F);
      Body_11.setTextureSize(256, 256);
      Body_11.mirror = true;
      setRotation(Body_11, -0.0371786F, 0F, 0F);
      Body_21 = new ModelRenderer(this, 182, 0);
      Body_21.addBox(-4F, 0F, -8F, 8, 8, 8);
      Body_21.setRotationPoint(0F, 0.7F, -6.8F);
      Body_21.setTextureSize(256, 256);
      Body_21.mirror = true;
      setRotation(Body_21, -0.1858931F, 0F, 0F);
      Neck1 = new ModelRenderer(this, 217, 0);
      Neck1.addBox(-2.5F, 0F, -11F, 5, 5, 11);
      Neck1.setRotationPoint(0F, 1F, -12F);
      Neck1.setTextureSize(256, 256);
      Neck1.mirror = true;
      setRotation(Neck1, -0.1038936F, 0F, 0F);
      Head1 = new ModelRenderer(this, 0, 92);
      Head1.addBox(-3.5F, 0F, -6F, 7, 7, 6);
      Head1.setRotationPoint(0F, -1F, -21F);
      Head1.setTextureSize(256, 256);
      Head1.mirror = true;
      setRotation(Head1, 0F, 0F, 0F);
      Upper_Jaw1 = new ModelRenderer(this, 30, 26);
      Upper_Jaw1.addBox(-2F, 0F, 0F, 4, 3, 7);
      Upper_Jaw1.setRotationPoint(0F, 4F, -26F);
      Upper_Jaw1.setTextureSize(256, 256);
      Upper_Jaw1.mirror = true;
      setRotation(Upper_Jaw1, 3.054326F, 0F, 0F);
      Lower_Jaw1 = new ModelRenderer(this, 71, 27);
      Lower_Jaw1.addBox(-1.5F, -1F, 0F, 3, 1, 6);
      Lower_Jaw1.setRotationPoint(0F, 4F, -26F);
      Lower_Jaw1.setTextureSize(256, 256);
      Lower_Jaw1.mirror = true;
      setRotation(Lower_Jaw1, -2.6529F, 0F, 0F);
      Upper_Jaw_Ridge1 = new ModelRenderer(this, 53, 27);
      Upper_Jaw_Ridge1.addBox(-1.5F, -1.1F, 5.1F, 3, 2, 6);
      Upper_Jaw_Ridge1.setRotationPoint(0F, -1F, -21F);
      Upper_Jaw_Ridge1.setTextureSize(256, 256);
      Upper_Jaw_Ridge1.mirror = true;
      setRotation(Upper_Jaw_Ridge1, -2.881342F, 0F, 0F);
      Crest_Left_11 = new ModelRenderer(this, 0, 40);
      Crest_Left_11.addBox(-9.3F, -3.5F, -2F, 8, 6, 0);
      Crest_Left_11.setRotationPoint(0F, -1F, -21F);
      Crest_Left_11.setTextureSize(256, 256);
      Crest_Left_11.mirror = true;
      setRotation(Crest_Left_11, 0.2617994F, -1.570796F, 0F);
      Crest_Right_11 = new ModelRenderer(this, 0, 40);
      Crest_Right_11.addBox(-9.3F, -3.5F, 2F, 8, 6, 0);
      Crest_Right_11.setRotationPoint(0F, -1F, -21F);
      Crest_Right_11.setTextureSize(256, 256);
      Crest_Right_11.mirror = true;
      setRotation(Crest_Right_11, -0.2617994F, -1.570796F, 0F);
      Tail_11 = new ModelRenderer(this, 118, 39);
      Tail_11.addBox(-4.5F, 0F, 0F, 9, 8, 10);
      Tail_11.setRotationPoint(0F, 0.6F, 5F);
      Tail_11.setTextureSize(256, 256);
      Tail_11.mirror = true;
      setRotation(Tail_11, -0.1858931F, 0F, 0F);
      Tail_21 = new ModelRenderer(this, 118, 61);
      Tail_21.addBox(-4F, 0F, 0F, 8, 6, 8);
      Tail_21.setRotationPoint(0F, 3F, 13F);
      Tail_21.setTextureSize(256, 256);
      Tail_21.mirror = true;
      setRotation(Tail_21, -0.0743572F, 0F, 0F);
      Tail_31 = new ModelRenderer(this, 118, 80);
      Tail_31.addBox(-3F, 0F, 0F, 6, 5, 8);
      Tail_31.setRotationPoint(0F, 4F, 18F);
      Tail_31.setTextureSize(256, 256);
      Tail_31.mirror = true;
      setRotation(Tail_31, 0F, 0F, 0F);
      Tail_41 = new ModelRenderer(this, 119, 79);
      Tail_41.addBox(-2F, 0F, 0F, 4, 4, 9);
      Tail_41.setRotationPoint(0F, 4.5F, 23F);
      Tail_41.setTextureSize(256, 256);
      Tail_41.mirror = true;
      setRotation(Tail_41, 0.0371786F, 0F, 0F);
      Tail_51 = new ModelRenderer(this, 118, 100);
      Tail_51.addBox(-1.5F, 0F, 0F, 3, 3, 11);
      Tail_51.setRotationPoint(0F, 5F, 29F);
      Tail_51.setTextureSize(256, 256);
      Tail_51.mirror = true;
      setRotation(Tail_51, 0.0743572F, 0F, 0F);
      Upper_Arm_Right1 = new ModelRenderer(this, 0, 56);
      Upper_Arm_Right1.addBox(-3F, 0F, 0F, 3, 3, 7);
      Upper_Arm_Right1.setRotationPoint(-4.5F, 2F, -11F);
      Upper_Arm_Right1.setTextureSize(256, 256);
      Upper_Arm_Right1.mirror = true;
      setRotation(Upper_Arm_Right1, -1.07818F, 0F, 0F);
      Upper_Arm_Left1 = new ModelRenderer(this, 0, 56);
      Upper_Arm_Left1.addBox(0F, 0F, 0F, 3, 3, 7);
      Upper_Arm_Left1.setRotationPoint(4.5F, 2F, -11F);
      Upper_Arm_Left1.setTextureSize(256, 256);
      Upper_Arm_Left1.mirror = true;
      setRotation(Upper_Arm_Left1, -1.07818F, 0F, 0F);
      Lower_Arm_Left1 = new ModelRenderer(this, 0, 68);
      Lower_Arm_Left1.addBox(-1F, 0F, -2F, 2, 5, 2);
      Lower_Arm_Left1.setRotationPoint(6F, 8F, -8.5F);
      Lower_Arm_Left1.setTextureSize(256, 256);
      Lower_Arm_Left1.mirror = true;
      setRotation(Lower_Arm_Left1, -0.6320364F, 0F, 0F);
      Lower_Arm_Right1 = new ModelRenderer(this, 0, 68);
      Lower_Arm_Right1.addBox(-1F, 0F, -2F, 2, 5, 2);
      Lower_Arm_Right1.setRotationPoint(-6F, 8F, -8.5F);
      Lower_Arm_Right1.setTextureSize(256, 256);
      Lower_Arm_Right1.mirror = true;
      setRotation(Lower_Arm_Right1, -0.6320364F, 0F, 0F);
      Hand_Left1 = new ModelRenderer(this, 81, 54);
      Hand_Left1.addBox(-1F, 0F, -1F, 2, 2, 1);
      Hand_Left1.setRotationPoint(5.9F, 11F, -12.3F);
      Hand_Left1.setTextureSize(256, 256);
      Hand_Left1.mirror = true;
      setRotation(Hand_Left1, 0F, -0.3490659F, 0F);
      Hand_Right1 = new ModelRenderer(this, 81, 54);
      Hand_Right1.addBox(-1F, 0F, -1F, 2, 2, 1);
      Hand_Right1.setRotationPoint(-5.9F, 11F, -12.3F);
      Hand_Right1.setTextureSize(256, 256);
      Hand_Right1.mirror = true;
      setRotation(Hand_Right1, 0F, 0.3490659F, 0F);
      Hand_Left_Claw_Left1 = new ModelRenderer(this, 81, 45);
      Hand_Left_Claw_Left1.addBox(-0.8F, 1F, -0.5F, 1, 2, 1);
      Hand_Left_Claw_Left1.setRotationPoint(5.9F, 11F, -12.3F);
      Hand_Left_Claw_Left1.setTextureSize(256, 256);
      Hand_Left_Claw_Left1.mirror = true;
      setRotation(Hand_Left_Claw_Left1, -0.4712389F, -1.919862F, 0F);
      Hand_Left_Claw_Right1 = new ModelRenderer(this, 81, 45);
      Hand_Left_Claw_Right1.addBox(-1.2F, 1F, -0.5F, 1, 2, 1);
      Hand_Left_Claw_Right1.setRotationPoint(5.9F, 11F, -12.3F);
      Hand_Left_Claw_Right1.setTextureSize(256, 256);
      Hand_Left_Claw_Right1.mirror = true;
      setRotation(Hand_Left_Claw_Right1, 0F, -1.919862F, 0F);
      Hand_Left_Claw_Middle1 = new ModelRenderer(this, 81, 45);
      Hand_Left_Claw_Middle1.addBox(-0.8F, 1F, -0.5F, 1, 2, 1);
      Hand_Left_Claw_Middle1.setRotationPoint(5.9F, 11F, -12.3F);
      Hand_Left_Claw_Middle1.setTextureSize(256, 256);
      Hand_Left_Claw_Middle1.mirror = true;
      setRotation(Hand_Left_Claw_Middle1, 0.4712389F, -1.919862F, 0F);
      Hand_Right_Claw_Right1 = new ModelRenderer(this, 81, 45);
      Hand_Right_Claw_Right1.addBox(0.2F, 1F, -0.5F, 1, 2, 1);
      Hand_Right_Claw_Right1.setRotationPoint(-5.9F, 11F, -12.3F);
      Hand_Right_Claw_Right1.setTextureSize(256, 256);
      Hand_Right_Claw_Right1.mirror = true;
      setRotation(Hand_Right_Claw_Right1, 0F, 1.919862F, 0F);
      Hand_Right_Claw_Left1 = new ModelRenderer(this, 81, 45);
      Hand_Right_Claw_Left1.addBox(-0.2F, 1F, -0.5F, 1, 2, 1);
      Hand_Right_Claw_Left1.setRotationPoint(-5.9F, 11F, -12.3F);
      Hand_Right_Claw_Left1.setTextureSize(256, 256);
      Hand_Right_Claw_Left1.mirror = true;
      setRotation(Hand_Right_Claw_Left1, 0.4712389F, 1.919862F, 0F);
      Hand_Right_Claw_Middle1 = new ModelRenderer(this, 81, 45);
      Hand_Right_Claw_Middle1.addBox(-0.2F, 1F, -0.5F, 1, 2, 1);
      Hand_Right_Claw_Middle1.setRotationPoint(-5.9F, 11F, -12.3F);
      Hand_Right_Claw_Middle1.setTextureSize(256, 256);
      Hand_Right_Claw_Middle1.mirror = true;
      setRotation(Hand_Right_Claw_Middle1, -0.4712389F, 1.919862F, 0F);
      Foot_Right1 = new ModelRenderer(this, 0, 0);
      Foot_Right1.addBox(-2F, 0F, -3F, 4, 2, 6);
      Foot_Right1.setRotationPoint(-7.2F, 22F, 0F);
      Foot_Right1.setTextureSize(256, 256);
      Foot_Right1.mirror = true;
      setRotation(Foot_Right1, 0F, 0F, 0F);
      Foot_Left1 = new ModelRenderer(this, 0, 0);
      Foot_Left1.addBox(-2F, 0F, -3F, 4, 2, 6);
      Foot_Left1.setRotationPoint(7F, 22F, 0F);
      Foot_Left1.setTextureSize(256, 256);
      Foot_Left1.mirror = true;
      setRotation(Foot_Left1, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 55, 79);
      Shape11.addBox(-10F, -5F, 0F, 20, 17, 0);
      Shape11.setRotationPoint(0F, -1F, -21F);
      Shape11.setTextureSize(256, 256);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    
    EntityDilophosaurus dilo = (EntityDilophosaurus)entity;

    if(!dilo.isAngry())
    {
    	if(this.isChild)
    	{
            float var8 = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 5.0F * f5, 2.0F * f5);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
            GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
            Left_Upper_Foot.render(f5);
            Right_Upper_Foot.render(f5);
            Left_Calf_1.render(f5);
            Right_Calf_1.render(f5);
            Left_Thigh.render(f5);
            Right_Thigh.render(f5);
            Body_1.render(f5);
            Body_2.render(f5);
            Neck.render(f5);
            Head.render(f5);
            Upper_Jaw.render(f5);
            Lower_Jaw.render(f5);
            Upper_Jaw_Ridge.render(f5);
            Crest_Left_1.render(f5);
            Crest_Right_1.render(f5);
            Tail_1.render(f5);
            Tail_2.render(f5);
            Tail_3.render(f5);
            Tail_4.render(f5);
            Tail_5.render(f5);
            Upper_Arm_Right.render(f5);
            Upper_Arm_Left.render(f5);
            Lower_Arm_Left.render(f5);
            Lower_Arm_Right.render(f5);
            Hand_Left.render(f5);
            Hand_Right.render(f5);
            Hand_Left_Claw_Left.render(f5);
            Hand_Left_Claw_Right.render(f5);
            Hand_Left_Claw_Middle.render(f5);
            Hand_Right_Claw_Right.render(f5);
            Hand_Right_Claw_Left.render(f5);
            Hand_Right_Claw_Middle.render(f5);
            Foot_Right.render(f5);
            Foot_Left.render(f5);
            GL11.glPopMatrix();
    	}
    	else{
    Left_Upper_Foot.render(f5);
    Right_Upper_Foot.render(f5);
    Left_Calf_1.render(f5);
    Right_Calf_1.render(f5);
    Left_Thigh.render(f5);
    Right_Thigh.render(f5);
    Body_1.render(f5);
    Body_2.render(f5);
    Neck.render(f5);
    Head.render(f5);
    Upper_Jaw.render(f5);
    Lower_Jaw.render(f5);
    Upper_Jaw_Ridge.render(f5);
    Crest_Left_1.render(f5);
    Crest_Right_1.render(f5);
    Tail_1.render(f5);
    Tail_2.render(f5);
    Tail_3.render(f5);
    Tail_4.render(f5);
    Tail_5.render(f5);
    Upper_Arm_Right.render(f5);
    Upper_Arm_Left.render(f5);
    Lower_Arm_Left.render(f5);
    Lower_Arm_Right.render(f5);
    Hand_Left.render(f5);
    Hand_Right.render(f5);
    Hand_Left_Claw_Left.render(f5);
    Hand_Left_Claw_Right.render(f5);
    Hand_Left_Claw_Middle.render(f5);
    Hand_Right_Claw_Right.render(f5);
    Hand_Right_Claw_Left.render(f5);
    Hand_Right_Claw_Middle.render(f5);
    Foot_Right.render(f5);
    Foot_Left.render(f5);
    }
    }
    else
    {
    	if(this.isChild)
    	{
            float var8 = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 5.0F * f5, 2.0F * f5);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
            GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
            Left_Upper_Foot1.render(f5);
            Right_Upper_Foot1.render(f5);
            Left_Calf_11.render(f5);
            Right_Calf_11.render(f5);
            Left_Thigh1.render(f5);
            Right_Thigh1.render(f5);
            Body_11.render(f5);
            Body_21.render(f5);
            Neck1.render(f5);
            Head1.render(f5);
            Upper_Jaw1.render(f5);
            Lower_Jaw1.render(f5);
            Upper_Jaw_Ridge1.render(f5);
            Crest_Left_11.render(f5);
            Crest_Right_11.render(f5);
            Tail_11.render(f5);
            Tail_21.render(f5);
            Tail_31.render(f5);
            Tail_41.render(f5);
            Tail_51.render(f5);
            Upper_Arm_Right1.render(f5);
            Upper_Arm_Left1.render(f5);
            Lower_Arm_Left1.render(f5);
            Lower_Arm_Right1.render(f5);
            Hand_Left1.render(f5);
            Hand_Right1.render(f5);
            Hand_Left_Claw_Left1.render(f5);
            Hand_Left_Claw_Right1.render(f5);
            Hand_Left_Claw_Middle1.render(f5);
            Hand_Right_Claw_Right1.render(f5);
            Hand_Right_Claw_Left1.render(f5);
            Hand_Right_Claw_Middle1.render(f5);
            Foot_Right1.render(f5);
            Foot_Left1.render(f5);
            Shape11.render(f5);
            GL11.glPopMatrix();
    	}
    	else{
    	    Left_Upper_Foot1.render(f5);
    	    Right_Upper_Foot1.render(f5);
    	    Left_Calf_11.render(f5);
    	    Right_Calf_11.render(f5);
    	    Left_Thigh1.render(f5);
    	    Right_Thigh1.render(f5);
    	    Body_11.render(f5);
    	    Body_21.render(f5);
    	    Neck1.render(f5);
    	    Head1.render(f5);
    	    Upper_Jaw1.render(f5);
    	    Lower_Jaw1.render(f5);
    	    Upper_Jaw_Ridge1.render(f5);
    	    Crest_Left_11.render(f5);
    	    Crest_Right_11.render(f5);
    	    Tail_11.render(f5);
    	    Tail_21.render(f5);
    	    Tail_31.render(f5);
    	    Tail_41.render(f5);
    	    Tail_51.render(f5);
    	    Upper_Arm_Right1.render(f5);
    	    Upper_Arm_Left1.render(f5);
    	    Lower_Arm_Left1.render(f5);
    	    Lower_Arm_Right1.render(f5);
    	    Hand_Left1.render(f5);
    	    Hand_Right1.render(f5);
    	    Hand_Left_Claw_Left1.render(f5);
    	    Hand_Left_Claw_Right1.render(f5);
    	    Hand_Left_Claw_Middle1.render(f5);
    	    Hand_Right_Claw_Right1.render(f5);
    	    Hand_Right_Claw_Left1.render(f5);
    	    Hand_Right_Claw_Middle1.render(f5);
    	    Foot_Right1.render(f5);
    	    Foot_Left1.render(f5);
    	    Shape11.render(f5);
    }
    }
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}