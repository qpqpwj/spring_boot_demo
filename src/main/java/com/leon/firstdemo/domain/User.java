package com.leon.firstdemo.domain;

/**
 * ${DESCRIPTION}
 *
 * @author jian.wang03@owitho.com
 * @create 2018-04-02 下午4:08
 * ${DESCRIPTION}
 **/
public class User {
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}