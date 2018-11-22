CREATE TABLE FLIGHT (
  ID NUMBER,
  CONSTRAINT FLIGHT_PK PRIMARY KEY(ID),
  PLANE_ID NUMBER,
  CONSTRAINT PLANE_FK_FK FOREIGN KEY(PLANE_ID) REFERENCES PLANE(ID),
  DATE_FLIGHT TIMESTAMP,
  CITY_FROM NVARCHAR2(50),
  CITY_TO NVARCHAR2(50)
);

CREATE SEQUENCE FLIGHT_ID_SEQ
  MINVALUE 1
  INCREMENT BY 1;