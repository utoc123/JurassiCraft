package to.uk.ilexiconn.jurassicraft.client.model.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import to.uk.ilexiconn.llib.client.model.MowzieModelBase;
import to.uk.ilexiconn.llib.client.model.MowzieModelRenderer;

@SideOnly(Side.CLIENT)
public class ModelStegosaur extends MowzieModelBase
{
    MowzieModelRenderer body_1;
    MowzieModelRenderer leg_left_1;
    MowzieModelRenderer leg_right_1;
    MowzieModelRenderer neck_1;
    MowzieModelRenderer tail_1;
    MowzieModelRenderer tail_2;
    MowzieModelRenderer tail_3;
    MowzieModelRenderer tail_4;
    MowzieModelRenderer leg_left_2;
    MowzieModelRenderer leg_right_2;
    MowzieModelRenderer leg_right_back_3;
    MowzieModelRenderer leg_left_back_3;
    MowzieModelRenderer foot_left;
    MowzieModelRenderer arm_right_1;
    MowzieModelRenderer arm_left_1;
    MowzieModelRenderer arm_left_2;
    MowzieModelRenderer arm_right_2;
    MowzieModelRenderer head_back;
    MowzieModelRenderer upper_jaw_1;
    MowzieModelRenderer head_;
    MowzieModelRenderer tail_end;
    MowzieModelRenderer lower_jaw;
    MowzieModelRenderer plate_1;
    MowzieModelRenderer plate_2;
    MowzieModelRenderer plate_3;
    MowzieModelRenderer plate_4;
    MowzieModelRenderer plate_5;
    MowzieModelRenderer plate_6;
    MowzieModelRenderer plate_7;
    MowzieModelRenderer front_left_spike;
    MowzieModelRenderer front_right_spike;
    MowzieModelRenderer back_right_spike;
    MowzieModelRenderer back_left_spike;
    MowzieModelRenderer plate_8;
    MowzieModelRenderer plate_9;
    MowzieModelRenderer plate_10;
    MowzieModelRenderer plate_11;
    MowzieModelRenderer upper_jaw_2;
    MowzieModelRenderer leg_left_front_3;
    MowzieModelRenderer leg_right_front_3;

    public ModelStegosaur()
    {
        textureWidth = 256;
        textureHeight = 128;

        body_1 = new MowzieModelRenderer(this, 149, 98);
        body_1.addBox(-6F, -0.5F, 0F, 12, 14, 15);
        body_1.setRotationPoint(0F, 3.3F, -4F);
        body_1.setTextureSize(256, 128);
        body_1.mirror = true;
        setRotation(body_1, 0.0523599F, 0F, 0F);
        leg_left_1 = new MowzieModelRenderer(this, 10, 91);
        leg_left_1.addBox(0F, 0F, 0F, 4, 11, 8);
        leg_left_1.setRotationPoint(6F, 2F, 6F);
        leg_left_1.setTextureSize(256, 128);
        leg_left_1.mirror = true;
        setRotation(leg_left_1, -0.2094395F, 0F, 0F);
        leg_right_1 = new MowzieModelRenderer(this, 10, 24);
        leg_right_1.addBox(-4F, 0F, 0F, 4, 11, 8);
        leg_right_1.setRotationPoint(-6F, 2F, 6F);
        leg_right_1.setTextureSize(256, 128);
        leg_right_1.mirror = true;
        setRotation(leg_right_1, -0.2094395F, 0F, 0F);
        neck_1 = new MowzieModelRenderer(this, 67, 82);
        neck_1.addBox(-3F, -0.2F, 0F, 6, 7, 5);
        neck_1.setRotationPoint(0F, 8.3F, -16.2F);
        neck_1.setTextureSize(256, 128);
        neck_1.mirror = true;
        setRotation(neck_1, 0.3148822F, 0F, 0F);
        tail_1 = new MowzieModelRenderer(this, 151, 72);
        tail_1.addBox(-5F, 0.6F, 0F, 10, 10, 8);
        tail_1.setRotationPoint(0F, 3F, 11F);
        tail_1.setTextureSize(256, 128);
        tail_1.mirror = true;
        setRotation(tail_1, -0.0523599F, 0F, 0F);
        tail_2 = new MowzieModelRenderer(this, 210, 105);
        tail_2.addBox(-4F, 1.2F, 4F, 8, 7, 10);
        tail_2.setRotationPoint(0F, 3F, 11F);
        tail_2.setTextureSize(256, 128);
        tail_2.mirror = true;
        setRotation(tail_2, -0.181349F, 0F, 0F);
        tail_3 = new MowzieModelRenderer(this, 211, 80);
        tail_3.addBox(-3F, 2.9F, 13F, 6, 5, 7);
        tail_3.setRotationPoint(0F, 3F, 11F);
        tail_3.setTextureSize(256, 128);
        tail_3.mirror = true;
        setRotation(tail_3, -0.1570796F, 0F, 0F);
        tail_4 = new MowzieModelRenderer(this, 155, 51);
        tail_4.addBox(-2F, 5.4F, 19F, 4, 3, 7);
        tail_4.setRotationPoint(0F, 3F, 11F);
        tail_4.setTextureSize(256, 128);
        tail_4.mirror = true;
        setRotation(tail_4, -0.0804504F, 0F, 0F);
        leg_left_2 = new MowzieModelRenderer(this, 22, 69);
        leg_left_2.addBox(0.5F, 8F, -7.5F, 3, 9, 4);
        leg_left_2.setRotationPoint(6F, 2F, 6F);
        leg_left_2.setTextureSize(256, 128);
        leg_left_2.mirror = true;
        setRotation(leg_left_2, 0.6108652F, 0F, 0F);
        leg_right_2 = new MowzieModelRenderer(this, 42, 69);
        leg_right_2.addBox(-3.5F, 8F, -7.5F, 3, 9, 4);
        leg_right_2.setRotationPoint(-6F, 2F, 6F);
        leg_right_2.setTextureSize(256, 128);
        leg_right_2.mirror = true;
        setRotation(leg_right_2, 0.6108652F, 0F, 0F);
        leg_right_back_3 = new MowzieModelRenderer(this, 2, 64);
        leg_right_back_3.addBox(-3.7F, 16F, 3F, 3, 6, 4);
        leg_right_back_3.setRotationPoint(-5.8F, 2F, 5.8F);
        leg_right_back_3.setTextureSize(256, 128);
        leg_right_back_3.mirror = true;
        setRotation(leg_right_back_3, 0F, 0F, 0F);
        leg_left_back_3 = new MowzieModelRenderer(this, 3, 75);
        leg_left_back_3.addBox(0.5F, 16F, 3F, 3, 6, 4);
        leg_left_back_3.setRotationPoint(6F, 2F, 5.8F);
        leg_left_back_3.setTextureSize(256, 128);
        leg_left_back_3.mirror = true;
        setRotation(leg_left_back_3, 0F, 0F, 0F);
        foot_left = new MowzieModelRenderer(this, 106, 107);
        foot_left.addBox(-5.5F, -1.5F, 0F, 11, 11, 9);
        foot_left.setRotationPoint(0F, 7F, -12F);
        foot_left.setTextureSize(256, 128);
        foot_left.mirror = true;
        setRotation(foot_left, 0.2443461F, 0F, 0F);
        arm_right_1 = new MowzieModelRenderer(this, 54, 52);
        arm_right_1.addBox(-1F, 2.5F, 3.4F, 3, 5, 4);
        arm_right_1.setRotationPoint(-6F, 12.8F, -7.7F);
        arm_right_1.setTextureSize(256, 128);
        arm_right_1.mirror = true;
        setRotation(arm_right_1, -0.3665191F, 0F, 0F);
        arm_left_1 = new MowzieModelRenderer(this, 2, 52);
        arm_left_1.addBox(-2F, 2.5F, 3.4F, 3, 5, 4);
        arm_left_1.setRotationPoint(6F, 12.8F, -7.7F);
        arm_left_1.setTextureSize(256, 128);
        arm_left_1.mirror = true;
        setRotation(arm_left_1, -0.3665191F, 0F, 0F);
        arm_left_2 = new MowzieModelRenderer(this, 26, 50);
        arm_left_2.addBox(-2F, 0F, 0F, 3, 7, 4);
        arm_left_2.setRotationPoint(6F, 12.8F, -8F);
        arm_left_2.setTextureSize(256, 128);
        arm_left_2.mirror = true;
        setRotation(arm_left_2, 0.3839724F, 0F, 0F);
        arm_right_2 = new MowzieModelRenderer(this, 40, 50);
        arm_right_2.addBox(-1.5F, 0F, 0F, 3, 7, 4);
        arm_right_2.setRotationPoint(-5.5F, 12.8F, -8F);
        arm_right_2.setTextureSize(256, 128);
        arm_right_2.mirror = true;
        setRotation(arm_right_2, 0.3839724F, 0F, 0F);
        head_back = new MowzieModelRenderer(this, 42, 101);
        head_back.addBox(-2.5F, 1F, 0F, 5, 5, 6);
        head_back.setRotationPoint(0F, 7.5F, -20F);
        head_back.setTextureSize(256, 128);
        head_back.mirror = true;
        setRotation(head_back, -0.0622742F, 0F, 0F);
        upper_jaw_1 = new MowzieModelRenderer(this, 51, 116);
        upper_jaw_1.addBox(-0.9F, -1F, -7.5F, 2, 3, 5);
        upper_jaw_1.setRotationPoint(0F, 9.8F, -22F);
        upper_jaw_1.setTextureSize(256, 128);
        upper_jaw_1.mirror = true;
        setRotation(upper_jaw_1, 0F, 0F, 0F);
        head_ = new MowzieModelRenderer(this, 78, 116);
        head_.addBox(-2F, -4F, -4F, 4, 5, 5);
        head_.setRotationPoint(0F, 12.5F, -21F);
        head_.setTextureSize(256, 128);
        head_.mirror = true;
        setRotation(head_, 0F, 0F, 0F);
        tail_end = new MowzieModelRenderer(this, 184, 51);
        tail_end.addBox(-1F, 4.7F, 26F, 2, 2, 6);
        tail_end.setRotationPoint(0F, 3F, 11F);
        tail_end.setTextureSize(256, 128);
        tail_end.mirror = true;
        setRotation(tail_end, -0.115357F, 0F, 0F);
        lower_jaw = new MowzieModelRenderer(this, 20, 121);
        lower_jaw.addBox(-1F, 1.5F, -7F, 2, 2, 4);
        lower_jaw.setRotationPoint(0F, 9.6F, -22F);
        lower_jaw.setTextureSize(256, 128);
        lower_jaw.mirror = true;
        setRotation(lower_jaw, 0F, 0F, 0F);
        plate_1 = new MowzieModelRenderer(this, 101, 2);
        plate_1.addBox(-5.5F, -13F, -1F, 1, 8, 8);
        plate_1.setRotationPoint(0F, 3F, -4F);
        plate_1.setTextureSize(256, 128);
        plate_1.mirror = true;
        setRotation(plate_1, -0.7853982F, 0F, 0F);
        plate_2 = new MowzieModelRenderer(this, 76, 1);
        plate_2.addBox(4.5F, -7.5F, -3.5F, 1, 7, 7);
        plate_2.setRotationPoint(0F, 3F, -4F);
        plate_2.setTextureSize(256, 128);
        plate_2.mirror = true;
        setRotation(plate_2, -0.715585F, 0F, 0F);
        plate_3 = new MowzieModelRenderer(this, 76, 1);
        plate_3.addBox(4.5F, -16.5F, 3F, 1, 7, 7);
        plate_3.setRotationPoint(0F, 3F, -4F);
        plate_3.setTextureSize(256, 128);
        plate_3.mirror = true;
        setRotation(plate_3, -0.8552113F, 0F, 0F);
        plate_4 = new MowzieModelRenderer(this, 52, 1);
        plate_4.addBox(-5F, -10F, -1.5F, 1, 6, 6);
        plate_4.setRotationPoint(0F, 6.5F, -12.5F);
        plate_4.setTextureSize(256, 128);
        plate_4.mirror = true;
        setRotation(plate_4, -0.6632251F, 0F, 0F);
        plate_5 = new MowzieModelRenderer(this, 23, 13);
        plate_5.addBox(1F, -3.5F, -0.5F, 1, 3, 3);
        plate_5.setRotationPoint(0F, 8.5F, -20F);
        plate_5.setTextureSize(256, 128);
        plate_5.mirror = true;
        setRotation(plate_5, -0.5850468F, 0F, 0F);
        plate_6 = new MowzieModelRenderer(this, 52, 1);
        plate_6.addBox(-4F, -7.6F, -2F, 1, 6, 6);
        plate_6.setRotationPoint(0F, 3F, 11F);
        plate_6.setTextureSize(256, 128);
        plate_6.mirror = true;
        setRotation(plate_6, -0.9424778F, 0F, 0F);
        plate_7 = new MowzieModelRenderer(this, 36, 4);
        plate_7.addBox(2.5F, -10F, 2F, 1, 5, 5);
        plate_7.setRotationPoint(0F, 3F, 11F);
        plate_7.setTextureSize(256, 128);
        plate_7.mirror = true;
        setRotation(plate_7, -1.047198F, 0F, 0F);
        front_left_spike = new MowzieModelRenderer(this, 211, 59);
        front_left_spike.addBox(-18.5F, 12.5F, 6F, 1, 1, 7);
        front_left_spike.setRotationPoint(0F, 3F, 11.5F);
        front_left_spike.setTextureSize(256, 128);
        front_left_spike.mirror = true;
        setRotation(front_left_spike, 0.5410521F, 1.047198F, 0F);
        front_right_spike = new MowzieModelRenderer(this, 211, 59);
        front_right_spike.addBox(17.5F, 12.5F, 6F, 1, 1, 7);
        front_right_spike.setRotationPoint(0F, 3F, 11.5F);
        front_right_spike.setTextureSize(256, 128);
        front_right_spike.mirror = true;
        setRotation(front_right_spike, 0.5410521F, -1.047198F, 0F);
        back_right_spike = new MowzieModelRenderer(this, 211, 45);
        back_right_spike.addBox(21.9F, 12.9F, 10.7F, 1, 1, 6);
        back_right_spike.setRotationPoint(0F, 3.6F, 11F);
        back_right_spike.setTextureSize(256, 128);
        back_right_spike.mirror = true;
        setRotation(back_right_spike, 0.3739991F, -0.997331F, 0F);
        back_left_spike = new MowzieModelRenderer(this, 211, 45);
        back_left_spike.addBox(-22.9F, 13.5F, 9.5F, 1, 1, 6);
        back_left_spike.setRotationPoint(0F, 2.9F, 11.5F);
        back_left_spike.setTextureSize(256, 128);
        back_left_spike.mirror = true;
        setRotation(back_left_spike, 0.3914524F, 1.017278F, 0F);
        plate_8 = new MowzieModelRenderer(this, 36, 4);
        plate_8.addBox(4F, -7F, -3F, 1, 5, 5);
        plate_8.setRotationPoint(0F, 7F, -12F);
        plate_8.setTextureSize(256, 128);
        plate_8.mirror = true;
        setRotation(plate_8, -0.4363323F, 0F, 0F);
        plate_9 = new MowzieModelRenderer(this, 23, 13);
        plate_9.addBox(-2.5F, -4F, -1F, 1, 3, 3);
        plate_9.setRotationPoint(0F, 8F, -16.5F);
        plate_9.setTextureSize(256, 128);
        plate_9.mirror = true;
        setRotation(plate_9, -0.5850468F, 0F, 0F);
        plate_10 = new MowzieModelRenderer(this, 139, 2);
        plate_10.addBox(1F, -13.53333F, 8F, 1, 3, 3);
        plate_10.setRotationPoint(0F, 3F, 11F);
        plate_10.setTextureSize(256, 128);
        plate_10.mirror = true;
        setRotation(plate_10, -1.191368F, 0F, 0F);
        plate_11 = new MowzieModelRenderer(this, 126, 2);
        plate_11.addBox(-3F, -11.66667F, 5F, 1, 4, 4);
        plate_11.setRotationPoint(0F, 3F, 11F);
        plate_11.setTextureSize(256, 128);
        plate_11.mirror = true;
        setRotation(plate_11, -1.191368F, 0F, 0F);
        upper_jaw_2 = new MowzieModelRenderer(this, 51, 116);
        upper_jaw_2.addBox(-1.1F, -1F, -7.5F, 2, 3, 5);
        upper_jaw_2.setRotationPoint(0F, 9.8F, -22F);
        upper_jaw_2.setTextureSize(256, 128);
        upper_jaw_2.mirror = true;
        setRotation(upper_jaw_2, 0F, 0F, 0F);
        leg_left_front_3 = new MowzieModelRenderer(this, 3, 78);
        leg_left_front_3.addBox(-1.5F, 0F, -2F, 3, 3, 4);
        leg_left_front_3.setRotationPoint(5.5F, 21F, -5.2F);
        leg_left_front_3.setTextureSize(256, 128);
        leg_left_front_3.mirror = true;
        setRotation(leg_left_front_3, 0F, 0F, 0F);
        leg_right_front_3 = new MowzieModelRenderer(this, 2, 67);
        leg_right_front_3.addBox(-1.5F, 0F, -2F, 3, 3, 4);
        leg_right_front_3.setRotationPoint(-5.5F, 21F, -5.2F);
        leg_right_front_3.setTextureSize(256, 128);
        leg_right_front_3.mirror = true;
        setRotation(leg_right_front_3, 0F, 0F, 0F);

        addChildTo(lower_jaw, head_);
        addChildTo(upper_jaw_1, head_);
        addChildTo(head_, head_back);

        addChildTo(leg_left_front_3, arm_left_1);
        addChildTo(leg_right_front_3, arm_right_1);
        addChildTo(arm_left_1, arm_left_2);
        addChildTo(arm_right_1, arm_right_2);
        
        addChildTo(leg_left_back_3, leg_left_2);
        addChildTo(leg_right_back_3, leg_right_2);
        addChildTo(leg_left_2, leg_left_1);
        addChildTo(leg_right_2, leg_right_1);

        //Corrections
        upper_jaw_1.rotationPointY -= 5.5F;
        upper_jaw_1.rotationPointZ -= 2F;

        lower_jaw.rotationPointY -= 5.2F;
        lower_jaw.rotationPointZ -= 2F;

        /*leg_left_front_3.setRotationPoint(0, 0, 0);
        leg_left_2.setRotationPoint(0, 0, 0);
        leg_right_3.setRotationPoint(0, 0, 0);
        leg_right_2.setRotationPoint(0, 0, 0);
        arm_right_1.setRotationPoint(0, 0, 0);
        arm_left_1.setRotationPoint(0, 0, 0);*/
        
        leg_left_2.setRotationPoint(0, 0, 0);
        leg_right_2.setRotationPoint(0, 0, 0);

        body_1.setInitValuesToCurrentPose();
        leg_left_1.setInitValuesToCurrentPose();
        leg_right_1.setInitValuesToCurrentPose();
        neck_1.setInitValuesToCurrentPose();
        tail_1.setInitValuesToCurrentPose();
        tail_2.setInitValuesToCurrentPose();
        tail_3.setInitValuesToCurrentPose();
        tail_4.setInitValuesToCurrentPose();
        leg_left_2.setInitValuesToCurrentPose();
        leg_right_2.setInitValuesToCurrentPose();
        leg_right_front_3.setInitValuesToCurrentPose();
        leg_left_front_3.setInitValuesToCurrentPose();
        foot_left.setInitValuesToCurrentPose();
        arm_right_1.setInitValuesToCurrentPose();
        arm_left_1.setInitValuesToCurrentPose();
        arm_left_2.setInitValuesToCurrentPose();
        arm_right_2.setInitValuesToCurrentPose();
        head_back.setInitValuesToCurrentPose();
        upper_jaw_1.setInitValuesToCurrentPose();
        head_.setInitValuesToCurrentPose();
        tail_end.setInitValuesToCurrentPose();
        lower_jaw.setInitValuesToCurrentPose();
        plate_1.setInitValuesToCurrentPose();
        plate_2.setInitValuesToCurrentPose();
        plate_3.setInitValuesToCurrentPose();
        plate_4.setInitValuesToCurrentPose();
        plate_5.setInitValuesToCurrentPose();
        plate_6.setInitValuesToCurrentPose();
        plate_7.setInitValuesToCurrentPose();
        front_left_spike.setInitValuesToCurrentPose();
        front_right_spike.setInitValuesToCurrentPose();
        back_right_spike.setInitValuesToCurrentPose();
        back_left_spike.setInitValuesToCurrentPose();
        plate_8.setInitValuesToCurrentPose();
        plate_9.setInitValuesToCurrentPose();
        plate_10.setInitValuesToCurrentPose();
        plate_11.setInitValuesToCurrentPose();
        leg_right_back_3.setInitValuesToCurrentPose();
        leg_left_back_3.setInitValuesToCurrentPose();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
            body_1.render(f5);
            leg_left_1.render(f5);
            leg_right_1.render(f5);
            neck_1.render(f5);
            tail_1.render(f5);
            tail_2.render(f5);
            tail_3.render(f5);
            tail_4.render(f5);
//            leg_left_2.render(f5);
//            leg_right_2.render(f5);
//            leg_right_back_3.render(f5);
//            leg_left_back_3.render(f5);
            foot_left.render(f5);
 //           arm_right_1.render(f5);
 //           arm_left_1.render(f5);
            arm_left_2.render(f5);
            arm_right_2.render(f5);
            head_back.render(f5);
//            upper_jaw_1.render(f5);
//            head_.render(f5);
            tail_end.render(f5);
//            lower_jaw.render(f5);
            plate_1.render(f5);
            plate_2.render(f5);
            plate_3.render(f5);
            plate_4.render(f5);
            plate_5.render(f5);
            plate_6.render(f5);
            plate_7.render(f5);
            front_left_spike.render(f5);
            front_right_spike.render(f5);
            back_right_spike.render(f5);
            back_left_spike.render(f5);
            plate_8.render(f5);
            plate_9.render(f5);
            plate_10.render(f5);
            plate_11.render(f5);
//            upper_jaw_2.render(f5);
//            leg_left_front_3.render(f5);
//            leg_right_front_3.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void resetPose()
    {
        body_1.setCurrentPoseToInitValues();
        leg_left_1.setCurrentPoseToInitValues();
        leg_right_1.setCurrentPoseToInitValues();
        neck_1.setCurrentPoseToInitValues();
        tail_1.setCurrentPoseToInitValues();
        tail_2.setCurrentPoseToInitValues();
        tail_3.setCurrentPoseToInitValues();
        tail_4.setCurrentPoseToInitValues();
        leg_left_2.setCurrentPoseToInitValues();
        leg_right_2.setCurrentPoseToInitValues();
        leg_right_front_3.setCurrentPoseToInitValues();
        leg_left_front_3.setCurrentPoseToInitValues();
        foot_left.setCurrentPoseToInitValues();
        arm_right_1.setCurrentPoseToInitValues();
        arm_left_1.setCurrentPoseToInitValues();
        arm_left_2.setCurrentPoseToInitValues();
        arm_right_2.setCurrentPoseToInitValues();
        head_back.setCurrentPoseToInitValues();
        upper_jaw_1.setCurrentPoseToInitValues();
        head_.setCurrentPoseToInitValues();
        tail_end.setCurrentPoseToInitValues();
        lower_jaw.setCurrentPoseToInitValues();
        plate_1.setCurrentPoseToInitValues();
        plate_2.setCurrentPoseToInitValues();
        plate_3.setCurrentPoseToInitValues();
        plate_4.setCurrentPoseToInitValues();
        plate_5.setCurrentPoseToInitValues();
        plate_6.setCurrentPoseToInitValues();
        plate_7.setCurrentPoseToInitValues();
        front_left_spike.setCurrentPoseToInitValues();
        front_right_spike.setCurrentPoseToInitValues();
        back_right_spike.setCurrentPoseToInitValues();
        back_left_spike.setCurrentPoseToInitValues();
        plate_8.setCurrentPoseToInitValues();
        plate_9.setCurrentPoseToInitValues();
        plate_10.setCurrentPoseToInitValues();
        plate_11.setCurrentPoseToInitValues();
        leg_left_back_3.setCurrentPoseToInitValues();
        leg_right_back_3.setCurrentPoseToInitValues();
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        resetPose();
        faceTarget(head_, 1, f3, f4);
        walk(leg_left_1, 0.5F, 0.3F, false, 0F, 0, f, f1);
        walk(leg_right_1, 0.5F, 0.3F, true, 0F, 0, f, f1);
        walk(arm_left_2, 0.5F, 0.5F, true, 0F, 0, f, f1);
        walk(arm_right_2, 0.5F, 0.5F, false, 0F, 0, f, f1);
    }
}
