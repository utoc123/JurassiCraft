package to.uk.ilexiconn.jurassicraft.entity.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.EntitySwimming;
import to.uk.ilexiconn.jurassicraft.utility.ControlledParam;

public class EntityTylosaurus extends EntitySwimming {
public int frame = 0;
public float angle = 0;
public float deltaAngle = 4;
public float maxSpeed = 0.4F;
public float currentSpeed = 0.2F;
private int timeUntilDeltaAngleChange = 0;

    public EntityTylosaurus(World world)
    {
        super(world, (byte) 14);
        
        Dinosaur dino = Util.getDinoByID(14);
        //this.setSize(dino.xzHitbox, dino.yHitbox);
        this.setSize(1.0F, 1.0F);

        this.swimRadius = 16.0F;
        this.swimRadiusHeight = 10.0F;

        this.swimSpeed = 0.6F;

        this.jumpOnLand = false;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        Dinosaur dino = Util.getDinoByID(14);
        //this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(dino.health);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10);
    }

    @Override
    public Item getDropItem()
    {
        return Util.getMeat(14);
    }

    @Override
    protected Entity findEntityToAttack()
    {
        AxisAlignedBB area = this.boundingBox.expand(16.0D, 16.0D, 16.0D);

        EntityPlayer player = (EntityPlayer) super.findEntityToAttack();
        if (player != null)
            return player;

        return this.worldObj.findNearestEntityWithinAABB(EntityAnimal.class, area, this);
    }
    
    public void onUpdate() {
    	super.onUpdate();
    	frame ++;
       	if (this.inWater == true) {
       		float vx = (float) (currentSpeed*Math.cos(angle*(Math.PI/180)));
       		float vz = (float) (currentSpeed*Math.sin(angle*(Math.PI/180)));
       		this.motionX = vx;
       		this.motionZ = vz;
       		this.angle += deltaAngle;
       		if(timeUntilDeltaAngleChange <= 0){
       			int I = rand.nextInt(20) + 1;
    			if (I == 1)
    			{
    				deltaAngle = -1*deltaAngle;
    				timeUntilDeltaAngleChange = 40;
    			}
       		}
       		timeUntilDeltaAngleChange -= 1;
       	}
    }
}
