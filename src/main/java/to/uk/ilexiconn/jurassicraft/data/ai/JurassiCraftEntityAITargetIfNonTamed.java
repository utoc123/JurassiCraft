package to.uk.ilexiconn.jurassicraft.data.ai;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import to.uk.ilexiconn.jurassicraft.data.entity.EntityJurassiCraftTameable;

public class JurassiCraftEntityAITargetIfNonTamed extends EntityAINearestAttackableTarget
{

    private EntityJurassiCraftTameable creature;

    public JurassiCraftEntityAITargetIfNonTamed(EntityJurassiCraftTameable entityTameable, Class targetClass, int chance)
    {
        super(entityTameable, targetClass, chance, false);
        this.creature = entityTameable;
    }

    public boolean shouldExecute()
    {
        return this.creature.isCreatureAdult() && !this.creature.isTamed() && super.shouldExecute();
    }
}