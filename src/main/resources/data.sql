DROP TABLE PHONE;

CREATE TABLE PHONE (
   id LONG  PRIMARY KEY AUTO_INCREMENT,
   exist BOOLEAN,
   model VARCHAR(50),
   brand VARCHAR(50),
   person VARCHAR(50),
   availability BOOLEAN,
   booked_out DATE,
   technology VARCHAR(50),
   twoGBang VARCHAR(50),
   threeGBang VARCHAR(50),
   fourGBang VARCHAR(50)
);