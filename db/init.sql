start transaction;

insert into EDUCATIONS(education_name) values ("Дошкольное");
insert into EDUCATIONS(education_name) values ("Начальное");
insert into EDUCATIONS(education_name) values ("Основное общее");
insert into EDUCATIONS(education_name) values ("Среднее общее");
insert into EDUCATIONS(education_name) values ("Среднее профессиональное");
insert into EDUCATIONS(education_name) values ("Высшее");

insert into DUTIES(duty_name, description) values ("", "");
insert into DUTIES(duty_name, description) values ("", "");
insert into DUTIES(duty_name, description) values ("", "");

rollback;
