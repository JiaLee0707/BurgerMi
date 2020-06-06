USE burgermi;
drop TABLE menu;

CREATE TABLE menu (NAME VARCHAR(20) NOT NULL PRIMARY key, ingredients VARCHAR(20), price INT(5) NOT NULL, sort VARCHAR(10) not NULL);

INSERT INTO menu ("디폴트 버거", "", 2000, "단품"),
					  ("함박 버거", "", 2000, "단품"),
					  ("치즈 버거", "", 2000,  "단품"),
					  ("불고기 버거","", 2000, "단품"),
					  ("더블치즈 버거", "" 4500, "단품"),
					  ("");,