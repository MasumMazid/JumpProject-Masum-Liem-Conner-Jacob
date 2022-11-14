DROP DATABASE IF EXISTS TVShowTracker;
create database TVShowTracker;
use TVShowTracker;

create table user_login(
user_id INT NOT NULL,
PRIMARY KEY (user_id),
user_name VARCHAR(45) NOT NULL,
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
show_name VARCHAR(45) NOT NULL,
show_prog INT,
FOREIGN KEY (user_id) references user_login(user_id), 
FOREIGN KEY (tv_id) references TVShow(tv_id),
Primary key(user_id, tv_id)
);


INSERT INTO `tvshowtracker`.`tvshow`(`tv_id`,`show_name`)
	VALUES('1','Star Wars'),
			('2','Game of Thrones'),
            ('3','The Boys'),
            ('4','Re:Zero'),
            ('5','The Witcher'),
            ('6','Gundam'),
            ('7','Castlevania'),
            ('8','Spiderman'),
            ('9','Lucifer'),
            ('10','Wall-E');

INSERT INTO user_login VALUES
	(1, "jacob", "abc"),
	(2, "masum", "def"),
	(3, "conner", "ghi"),
	(4, "liem", "jkl"),
	(5, "bob", "mno");

INSERT INTO user_show VALUES(1, 1, 'Star Wars', 0);
INSERT INTO user_show VALUES(1, 2, 'Game of Thrones', 0);
INSERT INTO user_show VALUES(1, 3, 'The Boys', 0);
INSERT INTO user_show VALUES(1, 4, 'Re:Zero', 0);
INSERT INTO user_show VALUES(1, 5, 'The Witcher', 0);
INSERT INTO user_show VALUES(1, 6, 'Gundam', 0);
INSERT INTO user_show VALUES(1, 7, 'Castlevania', 0);
INSERT INTO user_show VALUES(1, 8, 'Spiderman', 0);
INSERT INTO user_show VALUES(1, 9, 'Lucifer', 0);
INSERT INTO user_show VALUES(1, 10, 'Wall-E', 0);
INSERT INTO user_show VALUES(2, 1, 'Star Wars', 0);
INSERT INTO user_show VALUES(2, 2, 'Game of Thrones', 0);
INSERT INTO user_show VALUES(2, 3, 'The Boys', 0);
INSERT INTO user_show VALUES(2, 4, 'Re:Zero', 0);
INSERT INTO user_show VALUES(2, 5, 'The Witcher', 0);
INSERT INTO user_show VALUES(2, 6, 'Gundam', 0);
INSERT INTO user_show VALUES(2, 7, 'Castlevania', 0);
INSERT INTO user_show VALUES(2, 8, 'Spiderman', 0);
INSERT INTO user_show VALUES(2, 9, 'Lucifer', 0);
INSERT INTO user_show VALUES(2, 10, 'Wall-E', 0);
INSERT INTO user_show VALUES(3, 1, 'Star Wars', 0);
INSERT INTO user_show VALUES(3, 2, 'Game of Thrones', 0);
INSERT INTO user_show VALUES(3, 3, 'The Boys', 0);
INSERT INTO user_show VALUES(3, 4, 'Re:Zero', 0);
INSERT INTO user_show VALUES(3, 5, 'The Witcher', 0);
INSERT INTO user_show VALUES(3, 6, 'Gundam', 0);
INSERT INTO user_show VALUES(3, 7, 'Castlevania', 0);
INSERT INTO user_show VALUES(3, 8, 'Spiderman', 0);
INSERT INTO user_show VALUES(3, 9, 'Lucifer', 0);
INSERT INTO user_show VALUES(3, 10, 'Wall-E', 0);

select * from user_show;