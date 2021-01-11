package sample.model;

import java.util.Comparator;
import java.util.stream.Collector;

public class SortGeneralData implements Comparator<ObjectToAdd>
{
    @Override
    public int compare(ObjectToAdd objectToAdd1, ObjectToAdd objectToAdd2) {
        int YearCompare = compareTo(objectToAdd1.getYear(), objectToAdd2.getYear());
        int MonthCompare = compareTo(objectToAdd1.getMonth(), objectToAdd2.getMonth());

        if(YearCompare == 0){
            return ((MonthCompare == 0) ? YearCompare : MonthCompare);
        } else {
            return YearCompare;
        }

    }
    public int compareTo(int a, int b){
        return a - b;
    }
}
