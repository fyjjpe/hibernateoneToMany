package com.entity;

import java.io.Serializable;

/**
 * Created by yuanjie.fang on 2018/2/28.
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -5350994043280204179L;
    private int sid;
    private String sname;
    private String sex;
    //学生是多方，可在多的一方配置一个一方的引用
    private Grade grade;

    public Student() {
    }

    public Student(String sname, String sex) {
        this.sname = sname;
        this.sex = sex;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
