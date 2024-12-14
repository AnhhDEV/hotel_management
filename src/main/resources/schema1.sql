/*
 database
 */
create database qlks;

/*
 hotel
 */
create table Hotel
(
    hotel_id int primary key auto_increment,
    name     varchar(150) not null,
    address  varchar(255) not null,
    contact  varchar(255) not null,
    owner    varchar(100) not null
);

/*
 floor
 */
create table Floor
(
    floor_number int primary key,
    hotel_id     int,
    foreign key (hotel_id) references Hotel (hotel_id)
);

/*
 employee
 */
create table Employee
(
    employee_id int auto_increment primary key,
    full_name   varchar(255)   not null,
    role        varchar(20)    not null,
    salary      numeric(12, 2) not null
);

/*
 room
 */
create table Room
(
    room_number  int primary key,
    room_type    varchar(10) not null,
    description  varchar(255),
    cost         numeric(10, 2) default 0.00,
    status       varchar(10),
    floor_number int,
    hotel_id     int,
    employee_id  int,
    foreign key (floor_number) references Floor (floor_number),
    foreign key (hotel_id) references Hotel (hotel_id),
    foreign key (employee_id) references Employee (employee_id)
);

/*
 customer
 */
create table Customer
(
    customer_id int auto_increment primary key,
    firstname   varchar(255) not null,
    lastname    varchar(255) not null,
    contact     varchar(10)  not null,
    email       varchar(255),
    address     varchar(255),
    source      varchar(10)  not null,
    id_proof    varchar(15)  not null
);

/*
 reservation
 */
create table Reservation
(
    reservation_id int auto_increment primary key,
    checkin_date   timestamp not null default current_timestamp,
    checkout_date  timestamp not null default current_timestamp,
    payment        varchar(100),
    customer_id    int,
    foreign key (customer_id) references Customer (customer_id)
);

/*
 associative table
 */
create table Room_Reservation
(
    room_number    int,
    reservation_id int,
    total_cost     numeric(12, 2) default 0.00,
    foreign key (room_number) references Room (room_number),
    foreign key (reservation_id) references Reservation (reservation_id)
);
