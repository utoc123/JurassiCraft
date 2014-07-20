package to.uk.ilexiconn.jurassicraft.data.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class MowzieModelRenderer extends ModelRenderer
{
    public float initRotateAngleX;
    public float initRotateAngleY;
    public float initRotateAngleZ;

    public float initRotationPointX;
    public float initRotationPointY;
    public float initRotationPointZ;

    public MowzieModelRenderer(ModelBase par1ModelBase, String par2Str)
    {
        super(par1ModelBase, par2Str);
    }

    public MowzieModelRenderer(ModelBase par1ModelBase, int par2, int par3)
    {
        super(par1ModelBase, par2, par3);
    }

    public MowzieModelRenderer(ModelBase par1ModelBase)
    {
        super(par1ModelBase);
    }

    public void setInitValuesToCurrentPose()
    {
        initRotateAngleX = this.rotateAngleX;
        initRotateAngleY = this.rotateAngleY;
        initRotateAngleZ = this.rotateAngleZ;

        initRotationPointX = this.rotationPointX;
        initRotationPointY = this.rotationPointY;
        initRotationPointZ = this.rotationPointZ;
    }

    public void setCurrentPoseToInitValues()
    {
        this.rotateAngleX = initRotateAngleX;
        this.rotateAngleY = initRotateAngleY;
        this.rotateAngleZ = initRotateAngleZ;

        this.rotationPointX = initRotationPointX;
        this.rotationPointY = initRotationPointY;
        this.rotationPointZ = initRotationPointZ;
    }
}
