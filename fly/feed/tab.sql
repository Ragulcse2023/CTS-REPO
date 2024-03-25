
CREATE TABLE flight
(
flightid varchar(255) primary key,
childfare double,
adultfare double
);



 CREATE TABLE Passenger (
   PassengerID varchar(255) NOT NULL,
    PassengerName varchar(255) NOT NULL,
    PassengerType varchar(255) NOT NULL,
    FlightID varchar(255),
    PRIMARY KEY (PassengerID),
    CONSTRAINT FK_Passenger_flight FOREIGN KEY (FlightID)
    REFERENCES Flight(FlightID)
);

insert into flight values("F001",245.6,567.8);
insert into flight values("F002",1245.6,1567.8);

insert into passenger values("P001","Kiran","child","F001");
insert into passenger values("P002","Sanjay","adult","F001");


insert into passenger values("P003","Pawan","child","F002");
insert into passenger values("P004","Sanjay","adult","F002");





