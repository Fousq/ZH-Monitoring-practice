package kz.zhanbolat.monitoring.mbean;

public class HealthEntity implements EntityMXBean {
    private boolean isHealth;

    @Override
    public boolean isHealth() {
        return isHealth;
    }

    @Override
    public void setHealth(boolean health) {
        isHealth = health;
    }
}
