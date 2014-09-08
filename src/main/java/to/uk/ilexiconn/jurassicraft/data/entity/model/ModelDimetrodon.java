// Date: 15.06.2014 19:35:58
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package to.uk.ilexiconn.jurassicraft.data.entity.model;

import ilexiconn.llib.client.model.MowzieModelBase;
import ilexiconn.llib.client.model.MowzieModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelDimetrodon extends MowzieModelBase
{
	// fields
	MowzieModelRenderer Head;
	MowzieModelRenderer BackHead;
	MowzieModelRenderer Jaw;
	MowzieModelRenderer Neck;
	MowzieModelRenderer Torso;
	MowzieModelRenderer Lower_Body;
	MowzieModelRenderer Tail1;
	MowzieModelRenderer Tail2;
	MowzieModelRenderer Thigh1;
	MowzieModelRenderer Thigh2;
	MowzieModelRenderer Thigh3;
	MowzieModelRenderer Thigh4;
	MowzieModelRenderer Leg1;
	MowzieModelRenderer Leg2;
	MowzieModelRenderer Leg3;
	MowzieModelRenderer Leg4;
	MowzieModelRenderer MiniSail1;
	MowzieModelRenderer Sail1;
	MowzieModelRenderer Sail2;
	MowzieModelRenderer Sail3;
	MowzieModelRenderer Sail4;
	MowzieModelRenderer MiniSail2;
	MowzieModelRenderer Teeth;

	MowzieModelRenderer Head1;
	MowzieModelRenderer BackHead1;
	MowzieModelRenderer Jaw1;
	MowzieModelRenderer Neck1;
	MowzieModelRenderer Torso1;
	MowzieModelRenderer Lower_Body1;
	MowzieModelRenderer Tail11;
	MowzieModelRenderer Tail21;
	MowzieModelRenderer Thigh11;
	MowzieModelRenderer Thigh21;
	MowzieModelRenderer Thigh31;
	MowzieModelRenderer Thigh41;
	MowzieModelRenderer Leg11;
	MowzieModelRenderer Leg21;
	MowzieModelRenderer Leg31;
	MowzieModelRenderer Leg41;
	MowzieModelRenderer MiniSail11;
	MowzieModelRenderer Sail11;
	MowzieModelRenderer Sail21;
	MowzieModelRenderer Sail31;
	MowzieModelRenderer Sail41;
	MowzieModelRenderer MiniSail21;
	MowzieModelRenderer Teeth1;

	public ModelDimetrodon() {
		textureWidth = 64;
		textureHeight = 64;

		Head1 = new MowzieModelRenderer(this, 0, 0);
		Head1.addBox(0F, 0F, 0F, 5, 5, 7);
		Head1.setRotationPoint(-2F, 9F, -24F);
		Head1.setTextureSize(64, 64);
		Head1.mirror = true;
		setRotation(Head1, 0.1396263F, 0F, 0F);
		BackHead1 = new MowzieModelRenderer(this, 31, 0);
		BackHead1.addBox(0F, 0F, 0F, 6, 6, 5);
		BackHead1.setRotationPoint(-2.5F, 8F, -18F);
		BackHead1.setTextureSize(64, 64);
		BackHead1.mirror = true;
		setRotation(BackHead1, 0F, 0F, 0F);
		Jaw1 = new MowzieModelRenderer(this, 18, 5);
		Jaw1.addBox(0F, 0F, 0F, 3, 1, 7);
		Jaw1.setRotationPoint(-1F, 15F, -23F);
		Jaw1.setTextureSize(64, 64);
		Jaw1.mirror = true;
		setRotation(Jaw1, 0.4089647F, 0F, 0F);
		Neck1 = new MowzieModelRenderer(this, 0, 12);
		Neck1.addBox(0F, 0F, 0F, 5, 6, 8);
		Neck1.setRotationPoint(-2F, 9F, -14F);
		Neck1.setTextureSize(64, 64);
		Neck1.mirror = true;
		setRotation(Neck1, -0.5585054F, 0F, 0F);
		Torso1 = new MowzieModelRenderer(this, 30, 11);
		Torso1.addBox(0F, 0F, 0F, 9, 7, 8);
		Torso1.setRotationPoint(-4F, 12.5F, -11F);
		Torso1.setTextureSize(64, 64);
		Torso1.mirror = true;
		setRotation(Torso1, -0.1115358F, 0F, 0F);
		Lower_Body1 = new MowzieModelRenderer(this, 0, 26);
		Lower_Body1.addBox(0F, 0F, 0F, 7, 6, 10);
		Lower_Body1.setRotationPoint(-3F, 13.5F, -4F);
		Lower_Body1.setTextureSize(64, 64);
		Lower_Body1.mirror = true;
		setRotation(Lower_Body1, -0.5091404F, 0F, 0F);
		Tail11 = new MowzieModelRenderer(this, 34, 26);
		Tail11.addBox(0F, 0F, 0F, 4, 4, 8);
		Tail11.setRotationPoint(-1.5F, 19F, 2F);
		Tail11.setTextureSize(64, 64);
		Tail11.mirror = true;
		setRotation(Tail11, -0.1115358F, 0F, 0F);
		Tail21 = new MowzieModelRenderer(this, 36, 38);
		Tail21.addBox(0F, 0F, 0F, 2, 2, 12);
		Tail21.setRotationPoint(-0.5F, 21F, 9F);
		Tail21.setTextureSize(64, 64);
		Tail21.mirror = true;
		setRotation(Tail21, 0F, 0F, 0F);
		Thigh11 = new MowzieModelRenderer(this, 12, 42);
		Thigh11.addBox(0F, 0F, 0F, 4, 4, 4);
		Thigh11.setRotationPoint(5F, 17F, -10F);
		Thigh11.setTextureSize(64, 64);
		Thigh11.mirror = true;
		setRotation(Thigh11, 0.0698132F, 0F, 0F);
		Thigh21 = new MowzieModelRenderer(this, 12, 42);
		Thigh21.addBox(0F, 0F, 0F, 4, 4, 4);
		Thigh21.setRotationPoint(4F, 17F, -1F);
		Thigh21.setTextureSize(64, 64);
		Thigh21.mirror = true;
		setRotation(Thigh21, -0.487866F, 0F, 0F);
		Thigh31 = new MowzieModelRenderer(this, 12, 42);
		Thigh31.addBox(0F, 0F, 0F, 4, 4, 4);
		Thigh31.setRotationPoint(-7F, 17F, -1F);
		Thigh31.setTextureSize(64, 64);
		Thigh31.mirror = true;
		setRotation(Thigh31, -0.4878719F, 0F, 0F);
		Thigh41 = new MowzieModelRenderer(this, 12, 42);
		Thigh41.addBox(0F, 0F, 0F, 4, 4, 4);
		Thigh41.setRotationPoint(-8F, 17F, -10F);
		Thigh41.setTextureSize(64, 64);
		Thigh41.mirror = true;
		setRotation(Thigh41, 0.0698132F, 0F, 0F);
		Leg11 = new MowzieModelRenderer(this, 0, 42);
		Leg11.addBox(0F, 0F, 0F, 3, 4, 3);
		Leg11.setRotationPoint(7F, 20F, -8F);
		Leg11.setTextureSize(64, 64);
		Leg11.mirror = true;
		setRotation(Leg11, 0F, 0F, 0F);
		Leg21 = new MowzieModelRenderer(this, 0, 42);
		Leg21.addBox(0F, 0F, 0F, 3, 4, 3);
		Leg21.setRotationPoint(7F, 20F, -1F);
		Leg21.setTextureSize(64, 64);
		Leg21.mirror = true;
		setRotation(Leg21, -1.189716F, 0F, 0F);
		Leg31 = new MowzieModelRenderer(this, 0, 42);
		Leg31.addBox(0F, 0F, 0F, 3, 4, 3);
		Leg31.setRotationPoint(-9F, 20F, -1F);
		Leg31.setTextureSize(64, 64);
		Leg31.mirror = true;
		setRotation(Leg31, -1.189721F, 0F, 0F);
		Leg41 = new MowzieModelRenderer(this, 0, 42);
		Leg41.addBox(0F, 0F, 0F, 3, 4, 3);
		Leg41.setRotationPoint(-9F, 20F, -8F);
		Leg41.setTextureSize(64, 64);
		Leg41.mirror = true;
		setRotation(Leg41, 0F, 0F, 0F);
		MiniSail11 = new MowzieModelRenderer(this, 28, 42);
		MiniSail11.addBox(0F, 0F, 0F, 1, 9, 3);
		MiniSail11.setRotationPoint(0F, 5F, -8F);
		MiniSail11.setTextureSize(64, 64);
		MiniSail11.mirror = true;
		setRotation(MiniSail11, -0.0546319F, 0F, 0F);
		Sail11 = new MowzieModelRenderer(this, 28, 42);
		Sail11.addBox(0F, 0F, 0F, 1, 15, 3);
		Sail11.setRotationPoint(0F, 2F, -4F);
		Sail11.setTextureSize(64, 64);
		Sail11.mirror = true;
		setRotation(Sail11, -0.2230717F, 0F, 0F);
		Sail21 = new MowzieModelRenderer(this, 28, 42);
		Sail21.addBox(0F, 0F, 0F, 1, 15, 3);
		Sail21.setRotationPoint(0F, 1F, -1F);
		Sail21.setTextureSize(64, 64);
		Sail21.mirror = true;
		setRotation(Sail21, -0.2974289F, 0F, 0F);
		Sail31 = new MowzieModelRenderer(this, 28, 42);
		Sail31.addBox(0F, 0F, 0F, 1, 15, 3);
		Sail31.setRotationPoint(0F, 2F, 2F);
		Sail31.setTextureSize(64, 64);
		Sail31.mirror = true;
		setRotation(Sail31, -0.3232544F, 0F, 0F);
		Sail41 = new MowzieModelRenderer(this, 28, 42);
		Sail41.addBox(0F, 0F, 0F, 1, 15, 3);
		Sail41.setRotationPoint(0F, 3F, 5F);
		Sail41.setTextureSize(64, 64);
		Sail41.mirror = true;
		setRotation(Sail41, -0.3976116F, 0F, 0F);
		MiniSail21 = new MowzieModelRenderer(this, 28, 42);
		MiniSail21.addBox(0F, 0F, 0F, 1, 12, 3);
		MiniSail21.setRotationPoint(0F, 7F, 6F);
		MiniSail21.setTextureSize(64, 64);
		MiniSail21.mirror = true;
		setRotation(MiniSail21, -0.3976116F, 0F, 0F);
		Teeth1 = new MowzieModelRenderer(this, 0, 50);
		Teeth1.addBox(0F, 0F, 0F, 5, 1, 7);
		Teeth1.setRotationPoint(-2F, 13.9F, -23.3F);
		Teeth1.setTextureSize(64, 64);
		Teeth1.mirror = true;
		setRotation(Teeth1, 0.1396263F, 0F, 0F);
	}
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    if (isChild)
    {
        float var8 = 2.0F;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 5.0F * f5, 2.0F * f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
        GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
    Teeth.render(f5);
    GL11.glPopMatrix();
}
else
{
//    Head.render(f5);
//    BackHead.render(f5);
//    Jaw.render(f5);
    Neck1.render(f5);
    Torso.render(f5);
    Lower_Body.render(f5);
    Tail1.render(f5);
    Tail2.render(f5);
    Thigh1.render(f5);
    Thigh2.render(f5);
    Thigh3.render(f5);
    Thigh4.render(f5);
    Leg1.render(f5);
    Leg2.render(f5);
    Leg3.render(f5);
    Leg4.render(f5);
    MiniSail1.render(f5);
    Sail1.render(f5);
    Sail2.render(f5);
    Sail3.render(f5);
    Sail4.render(f5);
    MiniSail2.render(f5);
//    Teeth.render(f5);
}
  }
  
  private void setRotation(MowzieModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
        walk(this.Leg1, 0.25F, 0.5f, true, 0, 0, f, f1);
        walk(this.Leg4, 0.25F, 0.5f, true, 0, 0, f, f1);
        walk(this.Leg3, 0.25F, 0.5f, false, 0, 0, f, f1);
        walk(this.Leg2, 0.25F, 0.5f, false, 0, 0, f, f1);
	}

}
