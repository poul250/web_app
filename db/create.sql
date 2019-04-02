create database if not exists WEB;
use WEB;

create table if not exists EDUCATION (
    education_id int not null auto_increment unique,
    education_name nvarchar(20) not null unique,

    primary key(education_id)
);

create table if not exists DUTY (
    duty_id int not null auto_increment unique,
    duty_name nvarchar(20) not null,
    description nvarchar(20),

    primary key(duty_id)
);

create table if not exists POSITION (
    position_id int not null auto_increment unique,
    position_name nvarchar(20) not null,

    primary key(position_id)
);

create table if not exists POSITION_DUTY (
    position_id int not null,
    duty_id int not null,

    foreign key (position_id)
        references POSITIONS(position_id)
        on delete cascade,
    foreign key (duty_id)
        references DUTIES(duty_id)
        on delete cascade
);

create table if not exists EMPLOYEE (
    employee_id int not null auto_increment unique,
    name nvarchar(10) not null,
    surname nvarchar(10) not null,
    patronymic nvarchar(10),
    address nvarchar(50),
    education_id int not null,

    primary key(employee_id)
);

create table if not exists DIVISION (
    division_id int not null auto_increment unique,
    parent_division_id int,
    division_name nvarchar(20) not null,
    director_id int,

    primary key(division_id),
    foreign key(director_id)
        references EMPLOYEES(employee_id)
        on delete set NULL,
    foreign key(parent_division_id)
        references DIVISIONS(division_id)
        on delete set NULL
);

create table if not exists JOB_HISTORY (
    job_history_id int not null auto_increment unique,
    employee_id int not null,
    division_id int not null,
    position_id int,
    date_start date not null,
    date_finish date,

    primary key(job_history_id),
    foreign key (employee_id)
        references EMPLOYEES(employee_id)
        on delete cascade,
    foreign key (division_id)
        references DIVISIONS(division_id)
        on delete cascade,
    foreign key (position_id)
        references POSITIONS(position_id)
        on delete set null
);

create table if not exists DIVISION_POSITION (
    div_pos_id int not null auto_increment unique,
    division_id int not null,
    position_id int not null,

    primary key(div_pos_id),
    foreign key(division_id)
        references DIVISIONS(division_id)
        on delete cascade,
    foreign key(position_id)
        references POSITIONS(position_id)
        on delete cascade
);

create table if not exists DIVISION_POSITION_EMPLOYEE (
    div_pos_id int not null,
    job_history_id int not null,

    foreign key (division_id, position_id)
        references DIVISION_POSITION(division_id, position_id)
        on delete cascade,
    foreign key (job_history_id)
        references JOB_HISTORY(job_history_id)
        on delete cascade
);

create trigger delete_employee before delete on EMPLOYEE
for each row begin
    delete from DIVISION_POSITION_EMPLOYEE where job_history_id in
        (select job_history_id from JOB_HISTORY where employee_id = old.employee_id);
    delete from JOB_HISTORY h where h.employee_id = old.employee_id;
end;
