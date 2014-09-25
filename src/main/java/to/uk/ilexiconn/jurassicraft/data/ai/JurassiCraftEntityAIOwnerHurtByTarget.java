package to.uk.ilexiconn.jurassicraft.data.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import to.uk.ilexiconn.jurassicraft.data.entity.EntityJurassiCraftTameable;

public class JurassiCraftEntityAIOwnerHurtByTarget extends EntityAITarget
{
    EntityJurassiCraftTameable defendingTameable;
    EntityLivingBase howTheOwnerIsAttacking;
    private int revengeTime;

    public JurassiCraftEntityAIOwnerHurtByTarget(EntityJurassiCraftTameable entityTameable)
    {
        super(entityTameable, false);
        this.defendingTameable = entityTameable;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute()
    {
        if (!this.defendingTameable.isTamed())
        {
            return false;
        }
        else
        {
            EntityLivingBase entitylivingbase = this.defendingTameable.getOwner();
            if (entitylivingbase == null)
            {
                return false;
            }
            else
            {
                this.howTheOwnerIsAttacking = entitylivingbase.getAITarget();
                int i = entitylivingbase.func_142015_aE();
                if (this.howTheOwnerIsAttacking instanceof EntityJurassiCraftTameable)
                {
                    return i != this.revengeTime && this.isSuitableTarget(this.howTheOwnerIsAttacking, false) && (this.howTheOwnerIsAttacking.getClass() != this.defendingTameable.getClass() || ((EntityJurassiCraftTameable) this.howTheOwnerIsAttacking).getOwner() != this.defendingTameable.getOwner());
                }
                else
                {
                    return i != this.revengeTime && this.isSuitableTarget(this.howTheOwnerIsAttacking, false);
                }
            }
        }
    }

    @Override
    public void startExecuting()
    {
        this.taskOwner.setAttackTarget(this.howTheOwnerIsAttacking);
        EntityLivingBase defenderCreature = this.defendingTameable.getOwner();
        if (defenderCreature != null)
        {
            this.revengeTime = defenderCreature.func_142015_aE();
        }
        super.startExecuting();
    }
}