package sample.model;

import com.google.gson.Gson;
import sample.helpers.CreateExampleData;
import sample.model.ObjectToAdd;

import java.util.ArrayList;
import java.util.List;


public class Habitant{

    private String fname;
    private String lname;
    private char sex;
    private int age;

    public Habitant(){}
    public Habitant(String fname, String lname, int age, char sex) {

        this.fname = fname;
        this.lname = lname;
        this.sex = sex;
        this.age = age;

        System.out.println(fname + " " + lname + " " + age + " " + sex);
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
