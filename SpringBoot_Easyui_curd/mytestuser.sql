use mytestuser;
create table users(
uid int AUTO_INCREMENT primary key,
username varchar(20),
realname varchar(20),
password varchar(20),
usalary int,
udate varchar(20)
);
insert into users value(0,"das","中国","aa",120,"2017-12-15");
select * from users;