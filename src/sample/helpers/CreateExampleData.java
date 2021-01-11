package sample.helpers;

import sample.model.Database;
import sample.model.Model;
import sample.model.ObjectToAdd;
import sample.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateExampleData {

    Random rn = new Random();

    public CreateExampleData(){

    }

    public void createData(int dataRange, int yearRange, int incomeRange, int expenseRange) throws IOException {

        List<ObjectToAdd> list = new ArrayList<ObjectToAdd>();
        ObjectToAdd obj;
        int day, month, year, income, expense;
        for(int i = 0; i<dataRange; i++){
            day = (int)(Math.random() * (30 - 1 + 1) + 1);
            month = (int)(Math.random() * (12 - 1 + 1) + 1);
            year = (int)(Math.random() * (2021 - (2021 - yearRange) + 1) + (2021 - yearRange));
            income = rn.nextInt(incomeRange);
            expense = rn.nextInt(expenseRange);

            obj = new ObjectToAdd(day, month, year, income, expense);

            list.add(obj);
        }

        Model.getInstance().createExampleDataForUser(list);

    }


}
