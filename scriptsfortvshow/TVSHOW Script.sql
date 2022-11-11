create database TVShowTracker;
use TVShowTracker;

create table user_login(
user_id INT NOT NULL,
PRIMARY KEY (user_id),
name VARCHAR(45) NOT NULL,
password VARCHAR(45) NOT NULL
);
create table TVShow(
tv_id INT  NOT NULL,
PRIMARY KEY (tv_id),
show_name VARCHAR(45) NOT NULL
);
create table user_show(
user_id INT ,
tv_id INT,
show_prog INT,
FOREIGN KEY (user_id) references user_login(user_id), 
FOREIGN KEY (tv_id) references TVShow(tv_id),
Primary key(user_id, tv_id)
);


INSERT INTO `tvshowtracker`.`tvshow`(`tv_id`,`show_name`)VALUES('1','Star war'),('2','Game of Throne'),('3','The boys'),('4','Re:Zero'),('5','The Witcher'),('6','Gundam'),('7','Castlevania'),('8','Spiderman'),('9','Lucifer'),('10','Wall-E');
INSERT INTO user_login Values(1,"1","1");
