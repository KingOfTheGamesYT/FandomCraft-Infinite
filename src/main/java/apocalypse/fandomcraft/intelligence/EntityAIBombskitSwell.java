package apocalypse.fandomcraft.intelligence;

import net.minecraft.entity.ai.*;
import apocalypse.fandomcraft.entity.*;
import net.minecraft.entity.*;

public class EntityAIBombskitSwell extends EntityAIBase
{
    EntityBombskit swellingBombskit;
    EntityLivingBase bombskitAttackTarget;
    private static final String __OBFID = "CL_00001614";
    
    public EntityAIBombskitSwell(final EntityBombskit skitter) {
        this.swellingBombskit = skitter;
        this.setMutexBits(1);
    }
    
    public boolean shouldExecute() {
        final EntityLivingBase entitylivingbase = this.swellingBombskit.getAttackTarget();
        return this.swellingBombskit.getBombskitState() > 0 || (entitylivingbase != null && this.swellingBombskit.getDistanceSqToEntity((Entity)entitylivingbase) < 9.0);
    }
    
    public void startExecuting() {
        this.swellingBombskit.getNavigator().clearPathEntity();
        this.bombskitAttackTarget = this.swellingBombskit.getAttackTarget();
    }
    
    public void resetTask() {
        this.bombskitAttackTarget = null;
    }
    
    public void updateTask() {
        if (this.bombskitAttackTarget == null) {
            this.swellingBombskit.setBombskitState(-1);
        }
        else if (this.swellingBombskit.getDistanceSqToEntity((Entity)this.bombskitAttackTarget) > 49.0) {
            this.swellingBombskit.setBombskitState(-1);
        }
        else if (!this.swellingBombskit.getEntitySenses().canSee((Entity)this.bombskitAttackTarget)) {
            this.swellingBombskit.setBombskitState(-1);
        }
        else {
            this.swellingBombskit.setBombskitState(1);
        }
    }
}
