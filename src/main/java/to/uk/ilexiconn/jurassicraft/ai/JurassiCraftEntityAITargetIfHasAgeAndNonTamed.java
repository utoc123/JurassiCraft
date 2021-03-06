package to.uk.ilexiconn.jurassicraft.ai;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftTameable;

public class JurassiCraftEntityAITargetIfHasAgeAndNonTamed extends EntityAINearestAttackableTarget
{

    private EntityJurassiCraftTameable creature;
    private float age;

    public JurassiCraftEntityAITargetIfHasAgeAndNonTamed(EntityJurassiCraftTameable entityTameable, Class targetClass, int chance, float ageToAttack)
    {
        super(entityTameable, targetClass, chance, false);
        this.creature = entityTameable;
        this.age = ageToAttack;
    }

    @Override
    public boolean shouldExecute()
    {
        return this.creature.isCreatureOlderThan(this.age) && !this.creature.isTamed() && super.shouldExecute();
    }
}