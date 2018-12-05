CREATE TABLE CURRENCY (
  CURRENCY_ID NUMBER,
  CONSTRAINT CURRENCY_PK PRIMARY KEY(CURRENCY_ID),
  CURRENCY NVARCHAR2(50)
);

CREATE SEQUENCE CURRENCY_ID_SEQ
  MINVALUE 1
  INCREMENT BY 1;