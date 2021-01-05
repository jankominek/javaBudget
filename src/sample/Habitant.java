package sample;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class Habitant{

    private String fname;
    private String lname;
    private char sex;
    private int age;

    Gson gson = new Gson();

    public List<ObjectToAdd> list = new ArrayList<ObjectToAdd>();

    public Habitant(){}
    public Habitant(String fname, String lname, int age, char sex) {

        this.fname = fname;
        this.lname = lname;
        this.sex = sex;
        this.age = age;

        System.out.println(fname + " " + lname + " " + age + " " + sex);
    }

    public void createList(){
        for(int i=0; i<10; i++){
            ObjectToAdd obj = new ObjectToAdd(i+1,i+1,i+1,i+1,i+1);
            list.add(obj);
        }
    }
    public void addToList(ObjectToAdd obj){
        list.add(obj);
    }
    public void getList(){
        String jsonObject;
        if(list.size() != 0){
            for( ObjectToAdd element : list){
                jsonObject = gson.toJson(element);
                System.out.println(jsonObject);
            }
        }
        else{
            System.out.println("list is empty!");
        }
    }

}
