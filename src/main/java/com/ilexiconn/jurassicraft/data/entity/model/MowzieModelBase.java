package com.ilexiconn.jurassicraft.data.entity.model;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.MathHelper;
@SideOnly(Side.CLIENT)

public class MowzieModelBase extends ModelBase {
	
	//Attach child to parent boxes to make the child move to match parent rotation and translation. Use this on the ends of parenting chains first. (I.E. Attach snout to head before attaching head to neck.)
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
}
