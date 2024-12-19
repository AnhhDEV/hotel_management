/*
 database
 */
create database qlks;

/*
 hotel
 */
create table Login
(
    id int primary key,
    username varchar(100),
    password varchar(100)
);

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
    hotel     int,
    foreign key (hotel) references Hotel (hotel_id)
);

/*
 room
 */
create table Room
(
    room_number  int primary key,
    room_type    varchar(50) not null,
    description  varchar(255),
    cost         numeric(50, 2) default 0.00,
    status       varchar(50),
    floor int,
    hotel    int,
    foreign key (floor) references Floor (floor_number),
    foreign key (hotel) references Hotel (hotel_id)
);

/*
 customer
 */
create table Customer
(
    customer_id int auto_increment primary key,
    firstname   varchar(255) not null,
    lastname    varchar(255) not null,
    contact     varchar(50)  not null,
    email       varchar(255),
    address     varchar(255),
    source      varchar(50)  not null,
    id_proof    varchar(55)  not null
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
    customer    int,
    foreign key (customer) references Customer (customer_id)
);

/*
 associative table
 */
create table Room_Reservation
(
    room   int,
    reservation int,
    total_cost     numeric(40, 2) default 0.00,
    foreign key (room) references Room (room_number),
    foreign key (reservation) references Reservation (reservation_id)
);

INSERT INTO Login
VALUE (1, 'admin', 'admin123');

INSERT INTO hotel(NAME, address, contact, OWNER)
    VALUE ('Khách sạn Thái Bình', 'Thanh Xuân, Hà Nội', '0123456789', 'Bùi Tuấn Anh');

INSERT INTO Customer (firstname, lastname, contact, email, address, source, id_proof)
VALUES ('Nguyen', 'Van A', '0912345678', 'vana@example.com', '123 ABC Street', 'Simply_guest', 'ID123456'),
       ('Tran', 'Thi B', '0923456789', 'thib@example.com', '456 DEF Street', 'Corporate', 'ID234567'),
       ('Le', 'Van C', '0934567890', 'vanc@example.com', '789 GHI Street', 'Corporate', 'ID345678'),
       ('Pham', 'Thi D', '0945678901', 'thid@example.com', '321 JKL Street', 'Simply_guest', 'ID456789'),
       ('Hoang', 'Van E', '0956789012', 'vane@example.com', '654 MNO Street', 'Simply_guest', 'ID567890');


INSERT INTO Floor (floor_number, hotel)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 1);

INSERT INTO Room (room_number, room_type, description, cost, status, floor, hotel)
VALUES (101, 'Normal', 'Room on floor 1 with city view', 100.00, 'Available', 1, 1),
       (102, 'Vip', 'Room on floor 1 with mountain view', 200.00, 'Available', 1, 1),
       (103, 'Luxury', 'Room on floor 1 with sea view', 300.00, 'Available', 1, 1),
       (104, 'Normal', 'Room on floor 1 with garden view', 100.00, 'Available', 1, 1),
       (105, 'Vip', 'Room on floor 1 with pool view', 200.00, 'Available', 1, 1),
       (201, 'Normal', 'Room on floor 2 with city view', 100.00, 'Available', 2, 1),
       (202, 'Vip', 'Room on floor 2 with mountain view', 200.00, 'Available', 2, 1),
       (203, 'Luxury', 'Room on floor 2 with sea view', 300.00, 'Available', 2, 1),
       (204, 'Normal', 'Room on floor 2 with garden view', 100.00, 'Available', 2, 1),
       (205, 'Vip', 'Room on floor 2 with pool view', 200.00, 'Available', 2, 1),
       (301, 'Normal', 'Room on floor 3 with city view', 100.00, 'Available', 3, 1),
       (302, 'Vip', 'Room on floor 3 with mountain view', 200.00, 'Available', 3, 1),
       (303, 'Luxury', 'Room on floor 3 with sea view', 300.00, 'Available', 3, 1),
       (304, 'Normal', 'Room on floor 3 with garden view', 100.00, 'Available', 3, 1),
       (305, 'Vip', 'Room on floor 3 with pool view', 200.00, 'Available', 3, 1),
       (401, 'Normal', 'Room on floor 4 with city view', 100.00, 'Available', 4, 1),
       (402, 'Vip', 'Room on floor 4 with mountain view', 200.00, 'Available', 4, 1),
       (403, 'Luxury', 'Room on floor 4 with sea view', 300.00, 'Available', 4, 1),
       (404, 'Normal', 'Room on floor 4 with garden view', 100.00, 'Available', 4, 1),
       (405, 'Vip', 'Room on floor 4 with pool view', 200.00, 'Available', 4, 1),
       (501, 'Normal', 'Room on floor 5 with city view', 100.00, 'Available', 5, 1),
       (502, 'Vip', 'Room on floor 5 with mountain view', 200.00, 'Available', 5, 1),
       (503, 'Luxury', 'Room on floor 5 with sea view', 300.00, 'Available', 5, 1),
       (504, 'Normal', 'Room on floor 5 with garden view', 100.00, 'Available', 5, 1),
       (505, 'Vip', 'Room on floor 5 with pool view', 200.00, 'Available', 5, 1);

