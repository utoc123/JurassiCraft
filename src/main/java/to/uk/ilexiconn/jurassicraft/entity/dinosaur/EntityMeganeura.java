package to.uk.ilexiconn.jurassicraft.entity.dinosaur;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;

public class EntityMeganeura extends EntityJurassiCraftCreature implements IMob
{

    public int courseChangeCooldown = 0;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity = null;

    public EntityMeganeura(World par1World)
    {
        super(par1World, (byte) 12);
        this.isImmuneToFire = false;
        this.experienceValue = 5;
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte) 0));
    }

    protected void func_110147_ax()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
    }

    /**
     * Called to update the entityOLD's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
        byte var1 = this.dataWatcher.getWatchableObjectByte(16);

    }

    protected void updateEntityActionState()
    {

        this.despawnEntity();
        double var1 = this.waypointX - this.posX;
        double var3 = this.waypointY - this.posY;
        double var5 = this.waypointZ - this.posZ;
        double var7 = var1 * var1 + var3 * var3 + var5 * var5;

        if (var7 < 1.0D || var7 > 3600.0D)
        {
            this.waypointX = this.posX + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.waypointY = this.posY + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.waypointZ = this.posZ + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
        }

        if (this.courseChangeCooldown-- <= 0)
        {
            this.courseChangeCooldown += this.rand.nextInt(5) + 2;
            var7 = (double) MathHelper.sqrt_double(var7);

            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, var7))
            {
                this.motionX += var1 / var7 * 0.1D;
                this.motionY += var3 / var7 * 0.1D;
                this.motionZ += var5 / var7 * 0.1D;
            }
            else
            {
                this.waypointX = this.posX;
                this.waypointY = this.posY;
                this.waypointZ = this.posZ;
            }
        }
    }

    /**
     * True if the ghast has an unobstructed line of travel to the waypoint.
     */
    private boolean isCourseTraversable(double par1, double par3, double par5, double par7)
    {
        double var9 = (this.waypointX - this.posX) / par7;
        double var11 = (this.waypointY - this.posY) / par7;
        double var13 = (this.waypointZ - this.posZ) / par7;
        AxisAlignedBB var15 = this.boundingBox.copy();

        for (int var16 = 1; (double) var16 < par7; ++var16)
        {
            var15.offset(var9, var11, var13);

            if (!this.worldObj.getCollidingBoundingBoxes(this, var15).isEmpty())
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if the entityOLD's current position is a valid location to spawn
     * this entityOLD.
     */
    public boolean getCanSpawnHere()
    {
        return this.rand.nextInt(20) == 0 && super.getCanSpawnHere();
    }

    public float spiderScaleAmount()
    {
        return 1.5F;
    }
}
