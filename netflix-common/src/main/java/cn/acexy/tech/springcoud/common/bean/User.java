package cn.acexy.tech.springcoud.common.bean;

import java.util.Random;
import java.util.UUID;

public class User {

    private static final Random random = new Random();

    private String name;
    private short age;

    public User() {
        this.name = UUID.randomUUID().toString();
        this.age = (short) random.nextInt(100);
    }

    public User(String name) {
        this.name = name;
        this.age = (short) random.nextInt(100);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }
}
