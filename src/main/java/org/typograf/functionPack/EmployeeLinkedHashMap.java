package org.typograf.functionPack;

import java.time.LocalDate;
import java.util.LinkedHashMap;

public class EmployeeLinkedHashMap {
    //для вычисления количества дней до желаемой даты
    public int incrSearch = 0;

    public LinkedHashMap<Integer, WorkDay> workSession = new LinkedHashMap<>();
    LocalDate now = LocalDate.now();


    public EmployeeLinkedHashMap(LocalDate wishDate) {

        LocalDate copyNow = now;
        // Желаемая дата выходит за центр(больше чем 10 дней от текущего дня)?
        while (copyNow.isBefore(wishDate)) {
            incrSearch += 1;
            copyNow = copyNow.plusDays(1);
            if (incrSearch > 10) {
                break;
            }
        }
        // Если не больше 10 дней, то начинаем заполнят мапу от текущего дня
        if (incrSearch <= 10) {
            copyNow = now;
            for (int i = 0; i < 20; i++) {
                workSession.put(copyNow.getDayOfMonth(), new WorkDay(copyNow.getDayOfMonth()));
                copyNow = copyNow.plusDays(1);
            }
        }
        // Если нет, то отнимает от желаем даты 10 дней, чтобы до желаемой даты были дни(10) и после(тоже 10)
        else {
            copyNow = wishDate.minusDays(10);

            for (int i = 0; i < 20; i++) {
                workSession.put(copyNow.getDayOfMonth(), new WorkDay(copyNow.getDayOfMonth()));
                copyNow = copyNow.plusDays(1);
            }
        }
    }

}
