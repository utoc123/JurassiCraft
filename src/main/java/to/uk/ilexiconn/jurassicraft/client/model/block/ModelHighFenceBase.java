package to.uk.ilexiconn.jurassicraft.client.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHighFenceBase extends ModelBase
{
    ModelRenderer Side1;
    ModelRenderer Side2;
    ModelRenderer Side3;
    ModelRenderer Side4;
    ModelRenderer Bottom;
    ModelRenderer Bottom1;
    ModelRenderer Side6;
    ModelRenderer Side5;
    ModelRenderer Side7;
    ModelRenderer Side8;

    public ModelHighFenceBase()
    {
        this(0.0F);
    }

    public ModelHighFenceBase( float par1 )
    {
        Side1 = new ModelRenderer( this, 93, 5 );
        Side1.setTextureSize( 256, 128 );
        Side1.addBox( -39F, -1.5F, -1.5F, 78, 3, 3);
        Side1.setRotationPoint( 0F, 18F, -14F );
        Side2 = new ModelRenderer( this, 91, 5 );
        Side2.setTextureSize( 256, 128 );
        Side2.addBox( -40F, -1.5F, -1.5F, 80, 3, 3);
        Side2.setRotationPoint( 0F, 18F, -22F );
        Side3 = new ModelRenderer( this, 47, 40 );
        Side3.setTextureSize( 256, 128 );
        Side3.addBox( -1.5F, -1.5F, -7F, 3, 3, 14);
        Side3.setRotationPoint( -37F, 17F, -11F );
        Side4 = new ModelRenderer( this, 47, 40 );
        Side4.setTextureSize( 256, 128 );
        Side4.addBox( -1.5F, -1.5F, -7F, 3, 3, 14);
        Side4.setRotationPoint( 37F, 17F, -11F );
        Bottom = new ModelRenderer( this, 109, 58 );
        Bottom.setTextureSize( 256, 128 );
        Bottom.addBox( -31.5F, -3.5F, -3F, 63, 7, 6);
        Bottom.setRotationPoint( 0F, 18F, 3F );
        Bottom1 = new ModelRenderer( this, 109, 58 );
        Bottom1.setTextureSize( 256, 128 );
        Bottom1.addBox( -22.5F, -3.5F, -3F, 45, 7, 6);
        Bottom1.setRotationPoint( 0F, 22F, 3F );
        Side6 = new ModelRenderer( this, 93, 5 );
        Side6.setTextureSize( 256, 128 );
        Side6.addBox( -39F, -1.5F, -1.5F, 78, 3, 3);
        Side6.setRotationPoint( 0F, 18F, 20F );
        Side5 = new ModelRenderer( this, 91, 5 );
        Side5.setTextureSize( 256, 128 );
        Side5.addBox( -40F, -1.5F, -1.5F, 80, 3, 3);
        Side5.setRotationPoint( 0F, 18F, 28F );
        Side7 = new ModelRenderer( this, 47, 40 );
        Side7.setTextureSize( 256, 128 );
        Side7.addBox( -1.5F, -1.5F, -7F, 3, 3, 14);
        Side7.setRotationPoint( -37F, 17F, 17F );
        Side8 = new ModelRenderer( this, 47, 40 );
        Side8.setTextureSize( 256, 128 );
        Side8.addBox( -1.5F, -1.5F, -7F, 3, 3, 14);
        Side8.setRotationPoint( 37F, 17F, 17F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Side1.rotateAngleX = 0F;
        Side1.rotateAngleY = 0F;
        Side1.rotateAngleZ = 0F;
        Side1.renderWithRotation(par7);

        Side2.rotateAngleX = 0F;
        Side2.rotateAngleY = 0F;
        Side2.rotateAngleZ = 0F;
        Side2.renderWithRotation(par7);

        Side3.rotateAngleX = 0.1264845F;
        Side3.rotateAngleY = 0.285852F;
        Side3.rotateAngleZ = 0.03705791F;
        Side3.renderWithRotation(par7);

        Side4.rotateAngleX = 0.1264845F;
        Side4.rotateAngleY = -0.285852F;
        Side4.rotateAngleZ = -0.03705791F;
        Side4.renderWithRotation(par7);

        Bottom.rotateAngleX = 0F;
        Bottom.rotateAngleY = 0F;
        Bottom.rotateAngleZ = 0F;
        Bottom.renderWithRotation(par7);

        Bottom1.rotateAngleX = 0F;
        Bottom1.rotateAngleY = 0F;
        Bottom1.rotateAngleZ = 0F;
        Bottom1.renderWithRotation(par7);

        Side6.rotateAngleX = 0F;
        Side6.rotateAngleY = 0F;
        Side6.rotateAngleZ = 0F;
        Side6.renderWithRotation(par7);

        Side5.rotateAngleX = 0F;
        Side5.rotateAngleY = 0F;
        Side5.rotateAngleZ = 0F;
        Side5.renderWithRotation(par7);

        Side7.rotateAngleX = -0.1264845F;
        Side7.rotateAngleY = -0.285852F;
        Side7.rotateAngleZ = 0.03705791F;
        Side7.renderWithRotation(par7);

        Side8.rotateAngleX = -0.1264845F;
        Side8.rotateAngleY = 0.285852F;
        Side8.rotateAngleZ = -0.03705791F;
        Side8.renderWithRotation(par7);
    }
}