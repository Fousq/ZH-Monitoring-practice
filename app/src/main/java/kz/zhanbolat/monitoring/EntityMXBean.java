package kz.zhanbolat.monitoring;

public interface EntityMXBean {
    int getStatus();
    void setStatus(int status);
    String getName();
    void setName(String name);
    void state();
}
