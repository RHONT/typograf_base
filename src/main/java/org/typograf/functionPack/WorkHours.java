package org.typograf.functionPack;


import java.time.LocalTime;
import java.util.LinkedHashMap;

public class WorkHours {

    public LinkedHashMap<LocalTime,String> fillHours(WorkDay selectHourseDay,Integer timeForecast){

        LinkedHashMap<LocalTime,String> hours=new LinkedHashMap<>();
        // наращиваем инкремент, цель- совпадение с требуемым количеством часов для работы(timeForecast)
        int tempIncrement = 0;
        // Запоминаем стартовую позицию. "-1" произвольное значение, которого точно не будет индексе массива
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
                // если нет, то обнуляем инкремент и стартовую позицию и начинаем его копить заново

            }else {
                tempIncrement = 0;
                startPos=-1;
            }
        }

        return hours;
    }
}

