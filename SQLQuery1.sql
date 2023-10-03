-- drop database fashionstore;-- 
create database shopbook;
go
use shopbook;
go

-- Tạo bảng
create table cart(
 id integer not null  IDENTITY(1,1), 
 count integer not null,
 product_id integer, 
 user_id varchar(255), 
 is_active_id integer,
 primary key (id)) 
 go
create table category (
id integer not null  IDENTITY(1,1),
 category_name nvarchar(1111), 
 primary key (id)) 
 go
create table orderr (
id integer not null  IDENTITY(1,1), 
address nvarchar(1111), 
booking_date date, 
country nvarchar(1111), 
email nvarchar(1111), 
fullname nvarchar(1111),
note nvarchar(1111), 
payment_method nvarchar(1111), 
phone nvarchar(1111), 
is_active_id integer, 
total integer, 
user_id varchar(255),
primary key (id))
 go
create table order_item (
id integer not null  IDENTITY(1,1), 
count integer, 
order_id integer, 
product_id integer, 
primary key (id)) 
go
create table product (
id integer not null  IDENTITY(1,1), 
created_at date, 
description_ nvarchar(1111), 
is_active integer, 
is_selling integer, 
price integer, 
product_name nvarchar(1111), 
quantity integer, 
sold integer, 
category_id integer,
author_id integer,
publisher_id integer,
producer_id integer,
is_discount_id integer,
book_jacket_id integer,
book_size_id integer,
primary key (id))
go
create table product_image (
id integer not null  IDENTITY(1,1), 
url_image nvarchar(1111), 
product_id integer, 
primary key (id))
go
create table userr (
id varchar(255) not null, 
avatar nvarchar(1111), 
email nvarchar(1111), 
login_type nvarchar(1111), 
password nvarchar(1111), 
phone_number nvarchar(1111), 
role nvarchar(1111), 
user_name nvarchar(1111), 
primary key (id))
go
create table author(
id integer not null  IDENTITY(1,1),
first_name nvarchar(1111), 
last_name nvarchar(1111),
primary key (id)) 
go
create table publisher(
id integer not null  IDENTITY(1,1),
fullname nvarchar(1111),
email nvarchar(1111),
phone nvarchar(1111),
address nvarchar(1111),
country nvarchar(1111),
primary key (id))
go
create table producer(
id integer not null  IDENTITY(1,1),
fullname nvarchar(1111),
email nvarchar(1111),
phone nvarchar(1111),
address nvarchar(1111),
country nvarchar(1111),
primary key (id))
go
create table is_discount(
id integer not null  IDENTITY(1,1),
name_sale nvarchar(1111),
create_date date,
first_date date,
last_date date,
percent_decrease int,
code_discount nvarchar(1111),
describing nvarchar(1111),
is_active nvarchar(1111),
primary key (id)) 
go
create table is_active(
id integer not null  IDENTITY(1,1),
name_active nvarchar(1111),
details nvarchar(1111),
primary key (id))
go
create table book_jacket(
id integer not null  IDENTITY(1,1),
name_jacket nvarchar(1111),
primary key (id)) 
go
create table book_size(
id integer not null  IDENTITY(1,1),
name_size nvarchar(1111),
primary key (id)) 
go

create table statistic(
id    integer not null   IDENTITY(1,1),
created_at    date,
profit   nvarchar(1111),
quantity integer,
sales    nvarchar(1111),
order_id      integer,
primary key (id)) 

create table promotion(
id    integer not null   IDENTITY(1,1),
coup_code    nvarchar(1111),
created_at   date,
discount_type integer,
discount_value  integer,
is_active      integer,
is_public      integer,
maximum_discount_value  integer,
name   nvarchar(1111),
primary key (id)) 
go
alter table product add constraint FK_id_author_123 foreign key (author_id) references author(id);
go
alter table product add constraint FK_id_publisher foreign key (publisher_id) references publisher(id);
go
alter table product add constraint FK_id_producer foreign key (producer_id) references producer(id);
go
alter table cart add constraint FK_id_is_active foreign key (is_active_id) references is_active(id);
go
alter table product add constraint FK_id_is_discount foreign key (is_discount_id) references is_discount(id);
go
alter table product add constraint FK_id_book_jacket foreign key (book_jacket_id) references book_jacket(id);
go
alter table product add constraint FK_id_book_size foreign key (book_size_id) references book_size(id);
go
alter table cart add constraint FK3d704slv66tw6x5hmbm6p2x3u foreign key (product_id) references product (id);
go
alter table cart add constraint FKl70asp4l4w0jmbm1tqyofho4o foreign key (user_id) references userr (id);
go
alter table orderr add constraint FKcpl0mjoeqhxvgeeeq5piwpd3i1 foreign key (user_id) references userr (id);
go
alter table orderr add constraint FKcpl0mjoeqhxvgeeeq5piwpd3i foreign key (is_active_id) references is_active(id);
go
alter table order_item add constraint FKs234mi6jususbx4b37k44cipy foreign key (order_id) references orderr (id);
go
alter table order_item add constraint FK551losx9j75ss5d6bfsqvijna foreign key (product_id) references product (id);
go
alter table product add constraint FK1mtsbur82frn64de7balymq9s foreign key (category_id) references category (id);
go
alter table product_image add constraint FK6oo0cvcdtb6qmwsga468uuukk foreign key (product_id) references product (id);
go
alter table statistic add constraint FKs234mi6jususbx4b37k44cipy1 foreign key (order_id) references orderr (id);
go
alter table statistic add constraint FKs234mi6jususbx4b37k44cipy11 foreign key (order_id) references orderr (id);
-- trạng thái đơn hàng (hoàn trả , hủy ,vv)
-- admin cập nhập đơn hàng 
-- login có bên thứ 3
-- thanh toán bên thứ 3 hoặc tt,
-- xuất file excel 
-- chat boot
-- khuyến mãi (theo mã)
-- tìm kiếm nhiều điều kiện 



-- khách hàng ( mua hàng phải đăng nhập )
-- có xem tt đơn hàng