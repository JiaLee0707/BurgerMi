USE burgermi;
DROP TABLE recipes;

CREATE TABLE recipes ( NAME VARCHAR(20) NOT NULL, ingredient VARCHAR(50) NOT NULL);

INSERT INTO menu ("디폴트 버거", "아래빵;패티;양파;윗빵"),
					  ("함박 버거", "아래빵;패티;치즈;윗빵"),
					  ("치즈 버거", "아래빵;패티;치즈;토마토;윗빵"),
					  ("불고기 버거","아래빵;패티;양상추;양파;윗빵"),
					  ("더블치즈 버거", "아래빵;패티;치즈;패티;치즈;양상추;윗빵");