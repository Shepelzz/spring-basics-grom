CREATE TABLE PLANE (
  PLANE_ID NUMBER,
  CONSTRAINT PLANE_PK PRIMARY KEY(PLANE_ID),
  MODEL NVARCHAR2(50),
  CODE NVARCHAR2(20) UNIQUE,
  YEAR_PRODUCED NUMBER,
  AVG_FUEL_CONSUMPTION NUMERIC(9, 2)
);

CREATE SEQUENCE PLANE_ID_SEQ
  MINVALUE 1
  INCREMENT BY 1;