#MVC Сервиса по обслуживанию типографской техники

##Основная суть проекта:
1. Клиент в браузере оставляет заявку.  
Описывает проблему, указывает модель станка, его серийный номер, телефон связи.
2. Ведущий инженер видит заявку, связывается по телефону, уточняет детали, корректирует описание проблемы.
3. Оценивает сложность ремонта оборудования от 1 до 10.
4. Дальше в зависимости от типа станка и сложности выводиться список сотрудников, которые способны этот ремонт осуществить.
5. Инженер назначает на работу выбранного сотрудника. 

##Ради чего проект был создан:
1. Написать условно полезно-применимое приложение MVC с использование Spring.
2. Поработать с Hibernate
3. Умереть, пытаясь работать с jstl в jsp страницах(получилось).
4. Проработать рабочую бизнес логику для базы данных
5. Разработать фичу и внедрить ее в mvc приложение.  
Основная фича - вывод способных на ремонт сотрудников, учитывая их занятость. А так же показ возможности выполнить заказ  
10 дней до желаемой даты и 10 дней после желаемой даты, на тот случай если в день когда удобно клиенту, выбранный инженер  
не сможет приехать. Если это ближайшие даты, то показывается 20 дней вперед. 
6. Потрогать Spring-Security
7. Потрогать логирование. Его я сделал в самом конце, когда от него уже не было никакого по сути смысла :(.  
Ведь все уже было отлажено и работоспособно.

##P.S.  
Проект был причиной моего выгорания, я вылетел из обучения на 3 месяца.  
Каждый день я сталкивался с проблемами, которые не давали проекту работать, всех победил конечно, но кусочек  
своей души я там оставил навсегда.
Очень больно без куратора или команды такие проекты делать самостоятельно.