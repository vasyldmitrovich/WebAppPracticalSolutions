create database
    if not exists solutions
DEFAULT CHARACTER SET utf8
        DEFAULT COLLATE utf8_general_ci;

create table if not exists solutions.phone
(
    id  int auto_increment
        primary key,

    price   double  not null,
    manufacturer    varchar(30) not null,
    year_of_manufacture    int not null,
    screen_diagonal  double  not null,
    ram double  null,
    internal_memory  double       not null
);
