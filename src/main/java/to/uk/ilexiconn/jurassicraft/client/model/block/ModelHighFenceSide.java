package to.uk.ilexiconn.jurassicraft.client.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHighFenceSide extends ModelBase
{
    ModelRenderer side;

    public ModelHighFenceSide()
    {
        this(0.0F);
    }

    public ModelHighFenceSide( float par1 )
    {
        side = new ModelRenderer( this, 2, 31 );
        side.setTextureSize( 256, 128 );
        side.addBox( -3.5F, -31.5F, -3F, 7, 63, 6);
        side.setRotationPoint( 0F, -13F, 0F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        side.rotateAngleX = 0F;
        side.rotateAngleY = 0F;
        side.rotateAngleZ = 0F;
        side.renderWithRotation(par7);
    }
}