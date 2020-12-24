create database exampleproj26;
use exampleproj26;

create table accounts (
                        id int primary key auto_increment,
                        username varchar(50) not null unique,
                        password varchar(50) not null,
                        money int not null check (money >= 0 )
);

create table transactions (
                            id int primary key auto_increment,
                            sender int not null,
                            receiver int not null,
                            time datetime not null default now(),
                            amount int check (amount > 0),
                            foreign key (sender) references accounts(id),
                            foreign key (receiver) references accounts(id)
);

insert into accounts values
(null, 'Vasily', '123', 1000),
(null, 'Tatyana', '123', 1000),
(null, 'Igor', '123', 3000),
(null, 'Oleg', '123', 0);

select * from accounts;