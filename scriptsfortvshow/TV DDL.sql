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



