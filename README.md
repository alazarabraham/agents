create table agent (
`Agent_ID` int not null auto_increment,
state_key int not null,
firstname varchar(25) not null , 
middlename varchar(25) not null , 
lastname varchar(25) not null , 
password varchar(25)not null, 
phone varchar(15) not null,
emailaddress varchar(200) not null ,
primary key (Agent_ID),
FOREIGN KEY (state_key) REFERENCES states(state_key)
);


Create table policy (
Policy_key int not null auto_increment,
Type varchar(100) not null,
Time_Period varchar(100) not null,
primary key (Policy_key)
);


Create table Policy_Holder(
PH_key int not null auto_increment,
state_key int not null,
firstName varchar(25) not null , 
middleName varchar(25) not null , 
lastName varchar(25) not null ,
DOB varchar(25) not null,
password varchar(200) not null,
emailaddress varchar(200) not null,
Policy_key int not null,
primary key (PH_key),
FOREIGN KEY (policy_key) REFERENCES Policy(policy_key),
FOREIGN KEY (state_key) REFERENCES states(state_key)

);

create table states(
state_key int not null auto_increment,
statename varchar(40),
statepicture varchar(300),
primary key(state_key)
);
SELECT 
    orderNumber,
    orderDate,
    orderLineNumber,
    productName,
    quantityOrdered,
    priceEach
FROM
    orders
INNER JOIN
    orderdetails USING (orderNumber)
INNER JOIN
    products USING (productCode)

SELECT policy_holder.PH_key,policy_holder.firstname,policy_holder.middlename,policy_holder.lastname,policy_holder.dob,policy_holder.password,policy_holder.emailaddress,policy.type from policy_holder inner join policy on policy_holder.policy_key=policy.policy_key
create table claimer (
PH_key int not null auto_increment,
name varchar(100) not null,
address varchar(200) not null,
age int not null,
Policy_key int not null,
primary key (PH_key),
foreign key (Policy_key) references policy(Policy_key)
);


CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `fullname` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;



create table admin (
id int not null auto_increment, 
email varchar(100),
password varchar(20),
fullName varchar (100),
primary key (id));

*******************************

create table agent (
Agent_ID int not null auto_increment,
firstname varchar(25) not null , 
middlename varchar(25) not null , 
lastname varchar(25) not null , 
password varchar(25)not null, 
phone varchar(15) not null,
emailaddress varchar(200) not null ,
primary key (Agent_ID)

);


Create table policy (
Policy_key int not null auto_increment,
Type varchar(100) not null,
Time_Period varchar(100) not null,
primary key (Policy_key)
);

Create table PolicyHolder(
PH_key int not null auto_increment,
firstName varchar(25) not null , 
middleinitial varchar(25) not null , 
lastName varchar(25) not null ,
dateOfBirth varchar(25) not null,
password varchar(200) not null,
emailaddress varchar(200) not null,
policy_key varchar(200) not null,
primary key (PH_key),

);

