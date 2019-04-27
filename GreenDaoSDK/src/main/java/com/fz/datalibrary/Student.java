package com.fz.datalibrary;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;


public class Student {
    //不能用int
    @Id(autoincrement = true)
    private Long id;
    //姓名
    @NotNull
    private String name;
    //学号
    @Unique
    private String number;
    //性别
    private int sex;
    @Generated(hash = 845291139)
    public Student(Long id, @NotNull String name, String number, int sex) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.sex = sex;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    /*public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNumber() {
        return this.number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public int getSex() {
        return this.sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }*/
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNumber() {
        return this.number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public int getSex() {
        return this.sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
}
