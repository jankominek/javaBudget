package sample.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class User {

    //List<ObjectToAdd> userData = new ArrayList<ObjectToAdd>();
    Map<String, ObjectToAdd> treeMapUserData = new TreeMap<String, ObjectToAdd>();
    private String login;
    private String password;


    public User(){}

    public Map<String, ObjectToAdd> getTreeMapUserData() {
        return treeMapUserData;
    }

    public void setTreeMapUserData(Map<String, ObjectToAdd> treeMapUserData) {
        this.treeMapUserData = treeMapUserData;
    }
    public void showListToString(){
        System.out.println("----- DATABASE -----");
        for(Map.Entry<String, ObjectToAdd> element : treeMapUserData.entrySet()){
            System.out.println("Key : " + element.getKey()
                    + "   " + "income : " + element.getValue().getIncome()
                    + "   " + "expense : " + element.getValue().getExpense()
                    + "   " + "date added : " + element.getValue().getDateAdded());
        }
    }

    public int getUserDataSize(){
        return treeMapUserData.size();
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
