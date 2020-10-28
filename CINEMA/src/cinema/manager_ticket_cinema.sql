drop database if exists manager_ticket_cinema;
create database manager_ticket_cinema;
use manager_ticket_cinema;

create table manager_ticket_cinema.manager(
	user_id_manager int not null primary key auto_increment,
    name_manager varchar(30) not null,
    email_manager varchar(30) not null,
    password_manager varchar(30) not null,
    type_manager TINYINT(1) not null default '1'
);
insert into manager_ticket_cinema.manager(user_id_manager,name_manager,email_manager,password_manager) values(1,'TuanKiet','tuan.kiet9616@gmail.com','123456');
insert into manager_ticket_cinema.manager(user_id_manager,name_manager,email_manager,password_manager) values(2,'TuanKiet96','tuan.kiet9617@gmail.com','123456');
update manager_ticket_cinema.manager set type_manager = 1 where user_id_manager =2;
select name_manager,password_manager from manager_ticket_cinema.manager where name_manager='TuanKiet' and password_manager='123456';
create table manager_ticket_cinema.employee(
	user_id_emp int(11) not null primary key,
    name_emp varchar(30) not null,
    email_emp varchar(30) not null,
    password_emp varchar(30) not null,
    age int(2) not null,
    phonenumber_emp varchar(10) not null,
    type_emp TINYINT(1) not null default '2',
    manager_of_emp int(11),
    foreign key(manager_of_emp) references manager(user_id_manager)
);
insert into manager_ticket_cinema.employee(user_id_emp,name_emp,email_emp,password_emp,age,phonenumber_emp) values(1,"KietTuan","kiet.huynh@gosell.vn","123456789",25,"0987654321");
select type_manager,type_emp from manager_ticket_cinema.employee,manager_ticket_cinema.manager;
create table manager_ticket_cinema.customer(
	id_custumer int(11) auto_increment primary key not null,
    name_customer varchar(30) not null,
    phone_customer varchar(10) not null,
    birth_of_day date not null,
    address_customer nvarchar(150) not null,
    employee_id int(11),
    foreign key(employee_id) references employee(user_id_emp)
);

