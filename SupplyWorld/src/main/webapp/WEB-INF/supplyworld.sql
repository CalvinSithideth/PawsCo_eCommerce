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
('Kirkland Signature Dental Chews, 72-count', 1000);

create table Orders (
OrderID int primary key auto_increment,
Customer nvarchar(50) not null,
Date date not null,
FulfilledStatus boolean not null);

create table OrderDetails (
OrderID int not null,
ProductID int not null,
Quantity int not null,
primary key (OrderID, ProductID),
foreign key (OrderID) references Orders(OrderID),
foreign key (ProductID) references Products(ProductID));