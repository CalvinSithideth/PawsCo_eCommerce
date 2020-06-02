drop database if exists supplyworld;
create database supplyworld;
use supplyworld;

create table Users (
Username nvarchar(50) primary key,
Password nvarchar(50) not null);

insert into Users (Username, Password) values 
('admin', 'supplyworld');

create table Products (
ProductID int primary key auto_increment,
Name nvarchar(50) not null,
Stock int not null);

insert into Products (Name, Stock) values 
('Nulo FreeStyle Limited+', 1000),
('Blue Buffalo', 1000),
('Kirkland Signature Dental Chews, 72-count', 1000),
('KONG Classic Dog Toy, X-Large', 1000),
('STAR WARS Darth Vader Rope Dog Toy, Large', 1000),
('Marvel Deadpool Rubber Dog Toy, Small', 1000),
('Elegant Wooden Pet Bed', 1000),
('Orthopedic Dog Bed', 1000),
('Studio Dog Crate', 1000),
('Nail Clipper', 1000),
('FURminator Fur Brush', 1000),
('Burt\'s Bee Shampoo', 1000),
('Rain Coat', 1000),
('Sweater', 1000),
('Winter Jacket', 1000);

create table Orders (
OrderID int primary key auto_increment,
Customer nvarchar(50) not null,
Date date not null,
ProductID int not null,
Quantity int not null,
FulfilledStatus boolean not null,
foreign key (ProductID) references Products(ProductID));

#create table OrderDetails (
#OrderID int not null,
#ProductID int not null,
#Quantity int not null,
#primary key (OrderID, ProductID),
#foreign key (OrderID) references Orders(OrderID),
#foreign key (ProductID) references Products(ProductID));

#create user 'supplyworld_admin'@'localhost' identified by 'supplyworld';
#grant all privileges on supplyworld.* to 'supplyworld_admin'@'localhost';