create database
    if not exists solutions
DEFAULT CHARACTER SET utf8
        DEFAULT COLLATE utf8_general_ci;

create table if not exists solutions.products
(
    id                   int auto_increment
        primary key,
    name                 varchar(30) not null,
    price                double      not null,
    manufacturer         varchar(60) not null,
    year_of_manufacturer int         not null,
    category             varchar(30) not null
);

create table if not exists solutions.phones
(
    id              int auto_increment
        primary key,
    screen_diagonal double not null,
    ram             double not null,
    internal_memory double not null,
    id_category     int    not null,
    constraint phones_products_id_fk
        foreign key (id_category) references products (id)
            on delete cascade
);

create table if not exists solutions.televisions
(
    id              int auto_increment
        primary key,
    screen_diagonal double not null,
    id_category     int    not null,
    constraint televisions_products_id_fk
        foreign key (id_category) references products (id)
            on delete cascade
);

