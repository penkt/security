package com.pengkey.security.domain;

public class User {
    private Long id;

    private Integer age;

    private String name;

    private Byte sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public User() {

    }

    public User( String name,Integer age, Byte sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public User(Long id, Integer age, String name, Byte sex) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.sex = sex;
    }
}