# MVC приложение для сервиса по обслуживанию типографской техники

## Основная суть проекта:
1. Клиент в браузере оставляет заявку.  Описывает проблему, оставляет данные.
2. Ведущий инженер видит заявку, связывается по телефону, уточняет детали, корректирует описание проблемы.
3. Оценивает сложность ремонта оборудования от 1 до 10.
4. Дальше в зависимости от типа станка и сложности выводиться список сотрудников, которые способны этот ремонт осуществить.
5. Инженер назначает на работу выбранного сотрудника. 

## Ради чего проект был создан:
1. Написать условно полезно-применимое приложение MVC с использование Spring.
2. Поработать с Hibernate
3. Потрограть jstl в jsp страницах.
4. Проработать рабочую бизнес логику для базы данных.
5. Разработать фичу и внедрить ее в mvc приложение.  
Основная фича - вывод способных на ремонт сотрудников, учитывая их занятость. А так же показ возможности выполнить заказ  
10 дней до желаемой даты и 10 дней после желаемой даты, на тот случай если в день когда удобно клиенту, выбранный инженер  
не сможет приехать. Если это ближайшие даты, то показывается 20 дней вперед. 
6. Потрогать Spring-Security
7. Потрогать логирование.
8. Внедрить BootStrap

## Изоражение проекта

![image](https://user-images.githubusercontent.com/96048104/215667557-cd1892ad-fcd2-49e5-a74c-82306daa1393.png)

![image](https://user-images.githubusercontent.com/96048104/215667668-60692a08-bba4-46ef-ae03-180a68849ad3.png)

![image](https://user-images.githubusercontent.com/96048104/215667793-506103ab-4b9d-4de7-8926-420a7ed23232.png)

![image](https://user-images.githubusercontent.com/96048104/215668091-348db322-1eef-41c6-a1da-3af364499312.png)






