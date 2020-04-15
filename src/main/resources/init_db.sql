create database
    if not exists solutions
DEFAULT CHARACTER SET utf8
        DEFAULT COLLATE utf8_general_ci;

create table if not exists products
(
    id_category int auto_increment,
    name varchar(30) not null,
    price double not null,
    manufacturer varchar(60) not null,
    year_of_manufacturer int not null,
    category varchar(30) not null,
    constraint products_pk
        primary key (id_category)
);

create table if not exists televisions
(
    id_category int not null,
    screen_diagonal double not null,
    constraint televisions_pk
        primary key (id_category),
    constraint television_products_id_category_fk
        foreign key (id_category) references products (id_category)
);

create table if not exists phones
(
    id_category int not null,
    screen_diagonal double not null,
    ram double not null,
    internal_memory double not null,
    constraint phones_pk
        primary key (id_category),
    constraint phones_products_id_category_fk
        foreign key (id_category) references products (id_category)
);

