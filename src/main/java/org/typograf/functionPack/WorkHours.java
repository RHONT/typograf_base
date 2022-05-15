package org.typograf.functionPack;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class WorkHours {

    public LinkedHashMap<Integer,String> fillHours(WorkDay selectHourseDay){
        LinkedHashMap<Integer,String> hours=new LinkedHashMap<>();

        for (int i=0;i<10;i++){
            if (selectHourseDay.work[i]==1) {
                hours.put(10+i,String.valueOf(10+i)+":00");
            }
        }
        return hours;
    }
}
