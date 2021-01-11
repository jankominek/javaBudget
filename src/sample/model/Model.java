package sample.model;

import com.google.gson.Gson;
import com.sun.javafx.iio.ios.IosDescriptor;
import sample.helpers.CreateExampleData;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Model {

    private static final String pathToData = "C:\\Users\\Janek\\Desktop\\javaBudget\\src\\data.json";
    private Database database;
    Gson gson = new Gson();
    Date date = new Date();
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();


    private static String currentUser;
    private int currentMonth = localDate.getMonthValue();
    private int currentYear = localDate.getYear();


    static Model instance;
    public static Model getInstance(){
        if(instance == null){
            instance = new Model();
        }
        return instance;
    }

    public void createExampleDataForUser(List<ObjectToAdd> list){
        for(ObjectToAdd objectToAdd : list){
            addObjectToList(objectToAdd);
        }
    }

    public Map<String, ObjectToAdd> getCurrentUserList(){
        return database.getUsersObjects().get(currentUser).getTreeMapUserData();
    }
    public void showCurrentUserList(){
        database.getUsersObjects().get(currentUser).showListToString();
    }

    public void addObjectToList(ObjectToAdd objectToAdd) {
        String keyObject = this.convertDateToString(objectToAdd.getDay(), objectToAdd.getMonth(), objectToAdd.getYear());
        System.out.println(keyObject);
        if(database.getUsersObjects().get(currentUser).getTreeMapUserData().containsKey(keyObject)){
            ObjectToAdd currentObject = database.getUsersObjects().get(currentUser).getTreeMapUserData().get(keyObject);
            currentObject.setIncome(currentObject.getIncome() + objectToAdd.getIncome());
            currentObject.setExpense(currentObject.getExpense() + objectToAdd.getExpense());
        }
        else{
            database.getUsersObjects().get(currentUser).getTreeMapUserData().put(keyObject, objectToAdd);
        }
        try {
            saveDataToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String convertDateToString(int day, int month, int year){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day, 0, 0);
        Date date = calendar.getTime();
        String dateToString = simpleDateFormat.format(date);
        return dateToString;
    }

    public boolean modelLogIn(String login, String password){
            if(database.logIn(login, password)){
                return true;
            }
            return false;
    }
    public void modelRegister(String username, String password, List<ObjectToAdd> list) throws IOException {
        database.registerUser(username, password, list);
    }

    public void readDataFromFile() throws IOException {
        try(FileReader fileReader = new FileReader(pathToData)){
            this.database = gson.fromJson(fileReader, Database.class);
        }
        System.out.println("Hashmap size : " + this.database.getUsersObjects().size());
    }

    public void saveDataToFile() throws IOException{
        String jsonFile = gson.toJson(this.database);
        try(FileWriter fileWriter = new FileWriter(pathToData)){
            fileWriter.write(jsonFile);
            fileWriter.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void setCurrentUser(String currentUser) {
        Model.currentUser = currentUser;
    }

    public int getCurrentMonth() {
        return currentMonth;
    }

    public int getCurrentYear() {
        return currentYear;
    }
}
