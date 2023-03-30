package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;

@Entity
@Table(name="dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(nullable = false, columnDefinition = "TINYINT(3) UNSIGNED")
    protected int age;

    @Column(nullable = false, length = 200)
    protected String name;
    @Column(columnDefinition = "CHAR(2) DEFAULT 'XX'")
    protected String resideState;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }

    public Dog(){

    }


}
