package org.typograf.functionPack;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class WorkHours {

    public LinkedHashMap<LocalTime,String> fillHours(WorkDay selectHourseDay){
        LinkedHashMap<LocalTime,String> hours=new LinkedHashMap<>();

        for (int i=0;i<10;i++){
            if (selectHourseDay.work[i]==1) {
                hours.put(LocalTime.parse((String.valueOf(10+i)+":00")),String.valueOf(10+i)+":00");
            }
        }
        return hours;
    }
}
