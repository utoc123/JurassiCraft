package to.uk.ilexiconn.jurassicraft.client.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHighFenceTop extends ModelBase
{
    ModelRenderer lamp;
    ModelRenderer lamp1;
    ModelRenderer lamp2;
    ModelRenderer lamp3;
    ModelRenderer reja;
    ModelRenderer reja1;
    ModelRenderer reja2;
    ModelRenderer reja3;
    ModelRenderer side;
    ModelRenderer side1;

    public ModelHighFenceTop()
    {
        this(0.0F);
    }

    public ModelHighFenceTop( float par1 )
    {
        lamp = new ModelRenderer( this, 46, 9 );
        lamp.setTextureSize( 256, 128 );
        lamp.addBox( -1.5F, -1.5F, -1.5F, 3, 3, 3);
        lamp.setRotationPoint( -37F, 9F, 0F );
        lamp1 = new ModelRenderer( this, 63, 8 );
        lamp1.setTextureSize( 256, 128 );
        lamp1.addBox( -1.5F, -1.5F, -1.5F, 3, 3, 3);
        lamp1.setRotationPoint( -37F, 10F, 6F );
        lamp2 = new ModelRenderer( this, 46, 9 );
        lamp2.setTextureSize( 256, 128 );
        lamp2.addBox( -1.5F, -1.5F, -1.5F, 3, 3, 3);
        lamp2.setRotationPoint( 37F, 9F, 0F );
        lamp3 = new ModelRenderer( this, 63, 8 );
        lamp3.setTextureSize( 256, 128 );
        lamp3.addBox( -1.5F, -1.5F, -1.5F, 3, 3, 3);
        lamp3.setRotationPoint( 37F, 10F, 6F );
        reja = new ModelRenderer( this, 104, 40 );
        reja.setTextureSize( 256, 128 );
        reja.addBox( -33F, -0.5F, -0.5F, 66, 1, 1);
        reja.setRotationPoint( 3F, 21F, 3F );
        reja1 = new ModelRenderer( this, 104, 40 );
        reja1.setTextureSize( 256, 128 );
        reja1.addBox( -33F, -0.5F, -0.5F, 66, 1, 1);
        reja1.setRotationPoint( 3F, 18F, 3F );
        reja2 = new ModelRenderer( this, 104, 40 );
        reja2.setTextureSize( 256, 128 );
        reja2.addBox( -33F, -0.5F, -0.5F, 66, 1, 1);
        reja2.setRotationPoint( -1F, 15F, 3F );
        reja3 = new ModelRenderer( this, 104, 40 );
        reja3.setTextureSize( 256, 128 );
        reja3.addBox( -33F, -0.5F, -0.5F, 66, 1, 1);
        reja3.setRotationPoint( -3F, 24F, 3F );
        side = new ModelRenderer( this, 4, 33 );
        side.setTextureSize( 256, 128 );
        side.addBox( -2F, -6.5F, -2F, 4, 13, 4);
        side.setRotationPoint( 37F, 18F, 3F );
        side1 = new ModelRenderer( this, 4, 33 );
        side1.setTextureSize( 256, 128 );
        side1.addBox( -2F, -6.5F, -2F, 4, 13, 4);
        side1.setRotationPoint( -37F, 18F, 3F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        lamp.rotateAngleX = 0F;
        lamp.rotateAngleY = 0F;
        lamp.rotateAngleZ = 0F;
        lamp.renderWithRotation(par7);

        lamp1.rotateAngleX = 0F;
        lamp1.rotateAngleY = 0F;
        lamp1.rotateAngleZ = 0F;
        lamp1.renderWithRotation(par7);

        lamp2.rotateAngleX = 0F;
        lamp2.rotateAngleY = 0F;
        lamp2.rotateAngleZ = 0F;
        lamp2.renderWithRotation(par7);

        lamp3.rotateAngleX = 0F;
        lamp3.rotateAngleY = 0F;
        lamp3.rotateAngleZ = 0F;
        lamp3.renderWithRotation(par7);

        reja.rotateAngleX = 0F;
        reja.rotateAngleY = 0F;
        reja.rotateAngleZ = 0F;
        reja.renderWithRotation(par7);

        reja1.rotateAngleX = 0F;
        reja1.rotateAngleY = 0F;
        reja1.rotateAngleZ = 0F;
        reja1.renderWithRotation(par7);

        reja2.rotateAngleX = 0F;
        reja2.rotateAngleY = 0F;
        reja2.rotateAngleZ = 0F;
        reja2.renderWithRotation(par7);

        reja3.rotateAngleX = 0F;
        reja3.rotateAngleY = 0F;
        reja3.rotateAngleZ = 0F;
        reja3.renderWithRotation(par7);

        side.rotateAngleX = 0F;
        side.rotateAngleY = 0F;
        side.rotateAngleZ = 0F;
        side.renderWithRotation(par7);

        side1.rotateAngleX = 0F;
        side1.rotateAngleY = 0F;
        side1.rotateAngleZ = 0F;
        side1.renderWithRotation(par7);
    }
}