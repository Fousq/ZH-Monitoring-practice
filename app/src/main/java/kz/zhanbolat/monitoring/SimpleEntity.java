package kz.zhanbolat.monitoring;

public class SimpleEntity implements EntityMXBean {
    private int status;
    private String name;

    public SimpleEntity(int status, String name) {
        this.status = status;
        this.name = name;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void state() {
        System.out.println("State of entity: status - " + status + "; name - " + name);
    }
}
