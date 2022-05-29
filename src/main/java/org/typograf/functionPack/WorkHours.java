package org.typograf.functionPack;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class WorkHours {

    public LinkedHashMap<LocalTime,String> fillHours(WorkDay selectHourseDay,Integer timeForecast){

        LinkedHashMap<LocalTime,String> hours=new LinkedHashMap<>();
        int tempIncrement = 0;
        int startPos=-1;

        for (int i = 0; i < 10; i++){
            if (selectHourseDay.work[i]==1) {
                if (startPos==-1)
                {
                    startPos=i;
                }

                tempIncrement += 1;
                if (tempIncrement == timeForecast) {
                        hours.put(LocalTime.parse((10 + (i+1)-tempIncrement +":00")), (10 + (i+1)-tempIncrement +":00"));
                        i=startPos;
                        tempIncrement=0;
                        startPos=-1;
                }
                // если нет, то обнуляем инкремент и начинаем его копить заново

            }else {
                tempIncrement = 0;
                startPos=-1;
            }
        }

        return hours;
    }
}

//    public String ReturnDayForWorkStatus(int timeForecast) {
//        byte tempIncrement = 0;
//        for (int i = 0; i < 10; i++) {
//            if (work[i] == 1) {
//                //копим инкремент
//                tempIncrement += 1;
//                //если совпадает с требуемым временем, то "+"
//                if (tempIncrement == timeForecast) return "(+)";
//                // если нет, то обнуляем инкремент и начинаем его копить заново
//            } else tempIncrement = 0;
//        }
//        return "(-)";
//    }
