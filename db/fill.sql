start transaction;

insert into EDUCATION values (1, "Дошкольное");
insert into EDUCATION values (2, "Начальное");
insert into EDUCATION values (3, "Основное общее");
insert into EDUCATION values (4, "Среднее общее");
insert into EDUCATION values (5, "Среднее профессиональное");
insert into EDUCATION values (6, "Высшее");

insert into POSITIONS values (1, "Фулл стек разработчик");
insert into DUTY values (1, "Кофечист", "Чистить кофеварку раз в несколько дней");
insert into DUTY values (2, "Бэкенд разработка", "Разработка бэкенд части приложений");
insert into DUTY values (3, "Фронтенд разработка", "Разработка фронтенд части приложений");
insert into POSITION_DUTY(position_id, duty_id) values (1, 1);
insert into POSITION_DUTY(position_id, duty_id) values (1, 2);
insert into POSITION_DUTY(position_id, duty_id) values (1, 3);

insert into POSITIONS values (4, "Бэкенд разработчик");
insert into DUTY values (9, "Тестирование", "Тестирование кода");
insert into POSITION_DUTY(position_id, duty_id) values (4, 2);
insert into POSITION_DUTY(position_id, duty_id) values (4, 9);

insert into POSITIONS values (5, "Фронтенд разработчик");
insert into POSITION_DUTY(position_id, duty_id) values (5, 3);
insert into POSITION_DUTY(position_id, duty_id) values (5, 9);

insert into POSITIONS values (2, "Уборщик");
insert into DUTY values (4, "Уборка кабинетов", "Уборка кабинетов каждое утро");
insert into DUTY values (5, "Открытие офиса", "Открыть офис утром");
insert into DUTY values (6, "Закрытие офиса", "Закрыть офис вечером");
insert into POSITION_DUTY(position_id, duty_id) values (2, 4);
insert into POSITION_DUTY(position_id, duty_id) values (2, 5);
insert into POSITION_DUTY(position_id, duty_id) values (2, 6);

insert into POSITIONS values (3, "Повар");
insert into DUTY values (7, "Готовка еды", "Готовка еды");
insert into DUTY values (8, "Закупка продуктов", "Раз в несколько дней закупить продукты");
insert into POSITION_DUTY(position_id, duty_id) values (3, 7);
insert into POSITION_DUTY(position_id, duty_id) values (3, 8);

insert into POSITIONS values (6, "Менеджер");
insert into DUTY values (10, "Управление персоналом", NULL);
insert into DUTY values (11, "Переговоры с клиентами", NULL);
insert into POSITION_DUTY(position_id, duty_id) values (6, 10);
insert into POSITION_DUTY(position_id, duty_id) values (6, 11);

insert into POSITIONS values (7, "Глава компании");
insert into DUTY values (12, "Сидеть в кресле", NULL);
insert into DUTY values (13, "Гендзюцу", "Создавать видимость активной деятельности");
insert into POSITION_DUTY(position_id, duty_id) values (7, 12);
insert into POSITION_DUTY(position_id, duty_id) values (7, 13);

insert into POSITIONS values (8, "Шпийон");
insert into DUTY values (14, "Шпийонить за хохлами", NULL);
insert into DUTY values (15, "Шпийонить за омерикосами", NULL);
insert into POSITION_DUTY(position_id, duty_id) values (8, 14);
insert into POSITION_DUTY(position_id, duty_id) values (8, 15);

insert into POSITIONS values (9, "Хороший человек");
insert into DUTY values (16, "Переговорщик", "Рассказывать скучающим интересные истории");
insert into POSITION_DUTY(position_id, duty_id) values (9, 16);
insert into POSITION_DUTY(position_id, duty_id) values (9, 1);

insert into EMPLOYEE values (1, "Узумаки", "Наруто", NULL, "Коноха", 3);
insert into EMPLOYEE values (2, "Путин", "Владимир", "Владимирович", "Москва", 6);
insert into EMPLOYEE values (3, "Кулис", "Павел", "Владимирович", "Балашиха", 6);
insert into EMPLOYEE values (4, "Торвальдс", "Линус", NULL, "Швеция", 6);
insert into EMPLOYEE values (5, "Гейтс", "Билл", NULL, "США", 4);
insert into EMPLOYEE values (6, "Канунникова", "Бронислава", "Давидовна", "Улица Пушкина дом Калатушкина", 5);
insert into EMPLOYEE values (7, "Чельберг", "Феликс", NULL, "Швеция", 5);
insert into EMPLOYEE values (8, "Трушевская", "Берта", "Олеговна", "Подмосквинск", 6);
insert into EMPLOYEE values (9, "Оленева", "Марта", "Харитоновна", "Подпитерск", 6);
insert into EMPLOYEE values (10, "Курнаков", "Мирослав", "Венедиктович", "Подекатерибурск", 6);
insert into EMPLOYEE values (11, "Рябов", "Лукьян", "Тарасович", "Саратов", 6);


insert into DIVISION values (1, NULL, "The best company", 3);
insert into DIVISION values (2, 1, "Pear", 9);
insert into DIVISION values (3, 1, "Huarei", 10);
insert into DIVISION values (4, 2, "Samhung", 11);

insert into JOB_HISTORY values (1, 3, 1, 7, '1970-01-01', NULL);
insert into DIVISION_POSITION values (1, 1, 7);
insert into DIVISION_POSITION_EMPLOYEE values (1, 1);

insert into JOB_HISTORY values (2, 1, 1, 6, '2000-05-03', NULL);
insert into DIVISION_POSITION values (2, 1, 6);
insert into DIVISION_POSITION_EMPLOYEE values (2, 2);

insert into JOB_HISTORY values (3, 4, 1, 1, '1997-11-29', NULL);
insert into JOB_HISTORY values (4, 5, 1, 1, '1997-11-29', NULL);
insert into DIVISION_POSITION values (3, 1, 1);
insert into DIVISION_POSITION_EMPLOYEE values (3, 3);
insert into DIVISION_POSITION_EMPLOYEE values (3, 4);

insert into JOB_HISTORY values (5, 1, 2, 7, '1970-01-01', NULL);
insert into DIVISION_POSITION values (4, 2, 7);
insert into DIVISION_POSITION_EMPLOYEE values (4, 5);

insert into JOB_HISTORY values (6, 7, 2, 8, '2019-03-03', NULL);
insert into DIVISION_POSITION values (5, 2, 8);
insert into DIVISION_POSITION_EMPLOYEE values (5, 6);

insert into JOB_HISTORY values (7, 1, 3, 7, '1970-01-01', NULL);
insert into DIVISION_POSITION values (6, 3, 7);
insert into DIVISION_POSITION_EMPLOYEE values (6, 7);

insert into JOB_HISTORY values (8, 8, 3, 9, '1999-12-31', NULL);
insert into DIVISION_POSITION values (7, 3, 9);
insert into DIVISION_POSITION_EMPLOYEE values (7, 8);

insert into JOB_HISTORY values (9, 1, 4, 7, '1970-01-01', NULL);
insert into DIVISION_POSITION values (8, 4, 7);
insert into DIVISION_POSITION_EMPLOYEE values (8, 9);

insert into JOB_HISTORY values (10, 9, 4, 3, '2005-05-05', NULL);
insert into DIVISION_POSITION values (9, 4, 3);
insert into DIVISION_POSITION_EMPLOYEE values (9, 10);

commit;
