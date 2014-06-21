package com.ilexiconn.jurassicraft.data.entity.model;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.MathHelper;
@SideOnly(Side.CLIENT)

public class MowzieModelBase extends ModelBase {
	
	//Attach child to parent boxes to make the child move to match parent rotation and translation. Use this on the ends of parenting chains first. (I.E. Attach snout to head before attaching head to neck.) Make sure you delete that part from the render method!
	protected void addChildTo(ModelRenderer child, ModelRenderer parent) {
		float distance = (float)Math.sqrt(Math.pow((child.rotationPointZ - parent.rotationPointZ), 2) + Math.pow((child.rotationPointY - parent.rotationPointY), 2));
		float oldRotateAngleX = parent.rotateAngleX;
		float parentToChildAngle = (float) Math.atan((child.rotationPointZ - parent.rotationPointZ)/(child.rotationPointY - parent.rotationPointY));
		float childRelativeRotation = parentToChildAngle - parent.rotateAngleX;
		float newRotationPointY = (float) (distance*(Math.cos(childRelativeRotation)));
		float newRotationPointZ = (float) (distance*(Math.sin(childRelativeRotation)));
		parent.rotateAngleX = 0F;
		child.setRotationPoint(child.rotationPointX - parent.rotationPointX, newRotationPointY, newRotationPointZ);
	  	parent.addChild(child);
	  	parent.rotateAngleX = oldRotateAngleX;
	  	child.rotateAngleX -= parent.rotateAngleX;
	  	child.rotateAngleY -= parent.rotateAngleY;
	  	child.rotateAngleZ -= parent.rotateAngleZ;
	 }
	
	//Makes the specified box face the mob's target. Leave "f3" and "f4" as "f3" and "f4". Divider specifies the number of parts that the box is rotating with. (I.E. Set to 3 for 3-segmented necks, 2 for 2, etc.)
	public void faceTarget(MowzieModelRenderer box, int divider, float f3, float f4) {
		box.rotateAngleY = (f3 / (180F / (float)Math.PI))/divider + box.initRotateAngleY;
		box.rotateAngleX = (f4 / (180F / (float)Math.PI))/divider + box.initRotateAngleX;
	}
	
	//Swings the specified box back and forth while the mob is moving. Degree is the length of the arc that the box will follow. Invert will make the box swing the other way first, used for alternating leg movements. Offset will offset it from other part's rotations by the given amount. Leave "f" and "f1" as "f" and "f1".
	public void walk(MowzieModelRenderer box, float speed, float degree, boolean invert, float offset, float f, float f1) {
		int intinvert = 1;
		if (invert) intinvert = -1;
    		box.rotateAngleX = MathHelper.cos(f * speed + offset) * degree * intinvert * f1 + box.initRotateAngleX;
	}
	
	public void flap(MowzieModelRenderer box, float speed, float degree, boolean invert, float offset, float f, float f1) {
		int intinvert = 1;
		if (invert) intinvert = -1;
    		box.rotateAngleZ = MathHelper.cos(f * speed + offset) * degree * intinvert * f1 + box.initRotateAngleZ;
	}
	
	//Makes all boxes in the array do a snake-like motion at the specified speed and to the specified degree. rootOffset is basically the type of movment (3 gives a snake-like movement, 0 wags it back and forth, etc. This can be any value, though higher than 4 give some strange effects. Experiment!) Leave "frame" as "frame".
	public void tailSwing(MowzieModelRenderer[] boxes, float speed, float degree, double rootOffset, float frame) {
		int numberOfSegments = boxes.length;
		float offset = (float) ((rootOffset*Math.PI)/(2*numberOfSegments));
		for (int i = 0; i < numberOfSegments; i++) {
			boxes[i].rotateAngleY = MathHelper.cos(frame * speed + offset*i) * degree + boxes[i].initRotateAngleY;
		}
	}
	
	public void transitionBox(MowzieModelRenderer box, float desiredrotateAngleX, float desiredrotateAngleY, float desiredrotateAngleZ, float animationSpeed, int animationCounter) {
		if (animationCounter == 0) {
			box.initRotateAngleY = box.rotateAngleY;
			box.initRotateAngleX = box.rotateAngleX;
		}
		box.rotateAngleY = box.initRotateAngleY-((box.initRotateAngleY-desiredrotateAngleY)/2) + ((box.initRotateAngleY-desiredrotateAngleY)/2)*(MathHelper.cos((float) ((animationCounter * Math.PI)/animationSpeed)));
		box.rotateAngleY = box.initRotateAngleX-((box.initRotateAngleX-desiredrotateAngleX)/2) + ((box.initRotateAngleX-desiredrotateAngleX)/2)*(MathHelper.cos((float) ((animationCounter * Math.PI)/animationSpeed)));
	}
	
	public void simpleParent(ModelRenderer child, ModelRenderer parent) {
		float offsetX = parent.rotationPointX - child.rotationPointX;
		float offsetY = parent.rotationPointY - child.rotationPointY;
		float offsetZ = parent.rotationPointZ - child.rotationPointZ;

		child.setRotationPoint(parent.rotationPointX, parent.rotationPointY, parent.rotationPointZ);
		
		child.offsetX -= offsetX;
		child.offsetY -= offsetY;
		child.offsetZ -= offsetZ;
	}
}
