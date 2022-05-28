package org.typograf.functionPack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.LinkedHashMap;

// Вычисляем и заполняем мапу днями и пустыми значениями WorkDay(из мы будем изменять позже)
public class EmployeeLinkedHashMap {
    private static final Logger log= LoggerFactory.getLogger(EmployeeLinkedHashMap.class);
    //для вычисления количества дней до желаемой даты
    public int incrSearch = 0;

    public LinkedHashMap<LocalDate, WorkDay> workSession = new LinkedHashMap<>();
    LocalDate now = LocalDate.now();


    public EmployeeLinkedHashMap(LocalDate wishDate) {

        LocalDate copyNow = now;
        log.info("текущая дата:{}",now);
        // Желаемая дата выходит за центр(больше чем 10 дней от текущего дня)?
        while (copyNow.isBefore(wishDate)) {
            incrSearch += 1;
            copyNow = copyNow.plusDays(1);
            if (incrSearch > 10) {
                log.info("От текущего дня, более 10 дней, а {}",incrSearch);
                break;
            }
            log.info("От текущего дня, менее 10 дней, а именно: {}",incrSearch);
        }
        // Если не больше 10 дней, то начинаем заполнят мапу от текущего дня
        if (incrSearch <= 10) {
            copyNow = now;
            for (int i = 0; i < 20; i++) {
                workSession.put(copyNow, new WorkDay(copyNow.getDayOfMonth()));
                copyNow = copyNow.plusDays(1);
            }
            log.info("Мапа успешно заполнилась, начиная с текущего дня");
        }
        // Если нет, то отнимает от желаем даты 10 дней, чтобы до желаемой даты были дни(10) и после(тоже 10)
        else {
            copyNow = wishDate.minusDays(10);

            for (int i = 0; i < 20; i++) {
                workSession.put(copyNow, new WorkDay(copyNow.getDayOfMonth()));
                copyNow = copyNow.plusDays(1);
            }
            log.info("Мапа успешно заполнилась, от желаемой даты");
        }
        
    }
// геттер, чтобы во view можно было вытащить
    public LinkedHashMap<LocalDate, WorkDay> getWorkSession() {
        return workSession;
    }
}
