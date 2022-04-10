package kz.zhanbolat.monitoring.mbean;

public interface EntityMXBean {
    void setHealth(boolean isHealth);
    boolean isHealth();
}
