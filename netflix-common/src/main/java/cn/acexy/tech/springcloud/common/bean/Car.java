package cn.acexy.tech.springcloud.common.bean;

import java.util.UUID;

public class Car {

    private String name;

    private User owner;

    public Car() {
        this.name = UUID.randomUUID().toString();
    }

    public Car(User owner) {
        this.owner = owner;
        this.name = UUID.randomUUID().toString();
    }

    public Car(String name, User owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
