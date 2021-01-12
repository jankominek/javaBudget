package sample.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    private Map<String, User> usersObjects = new HashMap<>();



    public boolean logIn(String login, String password){
        for(User user : usersObjects.values()){
            if(user.getLogin().equals(login) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    public boolean registerUser(String username, String password, List<ObjectToAdd> list) throws IOException {
        if(this.checkIfUserExist(username)){
            User user = new User();
            user.setLogin(username);
            user.setPassword(password);
            user.setTreeMapUserData(null);
            usersObjects.put(username, user);
            Model.getInstance().saveDataToFile();
            return true;
        }
        return false;
    }

    private boolean checkIfUserExist(String username){
        System.out.println("Usernames database: ");
        for(String key : this.usersObjects.keySet()){
            System.out.println("username: " + key);
            if( key.equals(username)){
                return false;
            }
        }
        return true;
    }



    public Map<String, User> getUsersObjects() {
        return usersObjects;
    }


    @Override
    public String toString() {
        return "Database{" +
                "usersObjects=" + usersObjects +
                '}';
    }
}
