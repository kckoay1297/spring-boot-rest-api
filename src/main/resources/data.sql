DROP TABLE IF EXISTS TRANSACTION;

CREATE TABLE TRANSACTION (
   transaction_id bigint auto_increment not null,
   account_number VARCHAR(50) not null,
   trx_amount DECIMAL(20, 2),
   description VARCHAR(500) not null,
   trx_date Date,
   customer_id VARCHAR(50) not null
); 
alter table transaction add constraint trx_id_unique unique(transaction_id);

insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838283','FUND TRANSFER',PARSEDATETIME( '2019-09-12 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 123.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838283','ATM WITHDRWAL',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1123.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838283','FUND TRANSFER',PARSEDATETIME( '2019-10-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1223.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838283','3rd Party FUND TRANSFER',PARSEDATETIME( '2019-11-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1233.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838283','3rd Party FUND TRANSFER',PARSEDATETIME( '2019-08-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1243.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838283','3rd Party FUND TRANSFER',PARSEDATETIME( '2019-07-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 12553.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838283','BILL PAYMENT',PARSEDATETIME( '2019-08-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 12113.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838283','BILL PAYMENT',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1222.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838283','FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 2123.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838283','FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1323.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838283','FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 12443.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838283','FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 125553.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838283','FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 126663.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838283','FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1266663.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838299','FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1121223.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838299','FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 12231233.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838299','FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 111123.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838299','BILL PAYMENT',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 12223.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838299','BILL PAYMENT',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1223233.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838299','ATM WITHDRWAL',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1223233.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838299','ATM WITHDRWAL',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1223123233.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838299','3rd Party FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1223233.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838299','3rd Party FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 12232133.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838299','3rd Party FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1223233.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838299','BILL PAYMENT',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1111123.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838299','BILL PAYMENT',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 122223.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838299','BILL PAYMENT',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1222223.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838299','FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1223233.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838299','FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 11123.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838299','FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1223233.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('8872838299','FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 123666.00,'222');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('6872838260','BILL PAYMENT',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1.00,'333');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('6872838260','BILL PAYMENT',PARSEDATETIME( '2019-09-12 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1223.00,'333');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('6872838260','BILL PAYMENT',PARSEDATETIME( '2019-09-13 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 12323.00,'333');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('6872838260','BILL PAYMENT',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 12323.00,'333');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('6872838260','BILL PAYMENT',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 121233.00,'333');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('6872838260','BILL PAYMENT',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 19923.00,'333');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('6872838260','BILL PAYMENT',PARSEDATETIME( '2019-09-13 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 12893.00,'333');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('6872838260','FUND TRANSFER',PARSEDATETIME( '2019-09-14 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 99123.00,'333');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('6872838260','FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 19923.00,'333');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('6872838260','FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 12993.00,'333');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('6872838260','FUND TRANSFER',PARSEDATETIME( '2019-09-15 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 12993.00,'333');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('6872838260','FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 12993.00,'333');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('6872838260','FUND TRANSFER',PARSEDATETIME( '2019-09-16 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 12993.00,'333');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('6872838260','FUND TRANSFER',PARSEDATETIME( '2019-09-17 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 12993.00,'333');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('6872838260','FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 9123.00,'333');
insert into transaction (account_number, description, trx_date, trx_amount, customer_id) values ('6872838260','FUND TRANSFER',PARSEDATETIME( '2019-09-11 11:11:11:00','yyyy-MM-dd HH:mm:ss:SS'), 1923.00,'333');


DROP TABLE IF EXISTS CUSTOMER_INFO;
CREATE TABLE CUSTOMER_INFO(
   customer_id VARCHAR(50) not null,
   TEL_PHONE VARCHAR(20) not null,
   HAND_PHONE VARCHAR(20),
   NRIC VARCHAR(20) NOT NULL, 
   EMAIL VARCHAR(50) NOT NULL,
   FIRST_NAME VARCHAR(100) NOT NULL,
   LAST_NAME VARCHAR(100) NOT NULL,
   GENDER VARCHAR(10), 
   JOIN_DATE TIMESTAMP, 
   HOME_ADDRESS1 VARCHAR(100) NOT NULL,
   HOME_ADDRESS2 VARCHAR(100),
   HOME_ZIP VARCHAR(10) NOT NULL, 
   HOME_CITY VARCHAR(30) NOT NULL, 
   HOME_STATE VARCHAR(30) NOT NULL,
   HOME_COUNTRY VARCHAR(50) NOT NULL,
   CUSTOMER_TYPE VARCHAR(30),
   STATUS VARCHAR(30)
); 

alter table CUSTOMER_INFO add constraint customer_id_unique unique(customer_id);

insert into CUSTOMER_INFO(customer_id ,TEL_PHONE ,HAND_PHONE ,NRIC,EMAIL,FIRST_NAME,LAST_NAME,GENDER,JOIN_DATE,HOME_ADDRESS1,HOME_ADDRESS2,HOME_ZIP,HOME_CITY,HOME_STATE, HOME_COUNTRY,CUSTOMER_TYPE,STATUS )
values ('111','+60331823214','+60122182321','930827105321','111@email.com','Koay','Johnny','male',parsedatetime('2019-01-11 12:12:21','yyyy-MM-dd HH:mm:ss'),'No. 30, Jalan Bahagia',null,'43500','Bandar Kebun','Selangor','Malaysia','personal','active');
insert into CUSTOMER_INFO(customer_id ,TEL_PHONE ,HAND_PHONE ,NRIC,EMAIL,FIRST_NAME,LAST_NAME,GENDER,JOIN_DATE,HOME_ADDRESS1,HOME_ADDRESS2,HOME_ZIP,HOME_CITY,HOME_STATE, HOME_COUNTRY,CUSTOMER_TYPE,STATUS )
values ('222','+60431823214','+60162182321','830225105321','222@email.com','Ng','Jenny','female',parsedatetime('2009-02-11 09:15:31','yyyy-MM-dd HH:mm:ss'),'No. 35, Jalan Bumi',null,'53500','Taiping','Perak','Malaysia','corporate','active');
insert into CUSTOMER_INFO(customer_id ,TEL_PHONE ,HAND_PHONE ,NRIC,EMAIL,FIRST_NAME,LAST_NAME,GENDER,JOIN_DATE,HOME_ADDRESS1,HOME_ADDRESS2,HOME_ZIP,HOME_CITY,HOME_STATE, HOME_COUNTRY,CUSTOMER_TYPE,STATUS )
values ('333','+60531823214','+60103182926','900415110321','333@email.com','Ali','Muhammad','male',parsedatetime('2012-12-12 15:55:31','yyyy-MM-dd HH:mm:ss'),'No. 15, Jalan Taklimat',null,'43500','Petaling Jaya','Selangor','Malaysia','corporate','active');

DROP TABLE IF EXISTS BANK_ACCOUNT;
CREATE TABLE BANK_ACCOUNT (
   account_number VARCHAR(50) NOT NULL,
   AVAILABLE_BALANCE DECIMAL(20, 2),
   PENDING_BALANCE DECIMAL(20, 2),
   ACCOUNT_TYPE VARCHAR(30),
   ACCT_STATUS VARCHAR(30),
   customer_id VARCHAR(50) not null
); 

alter table BANK_ACCOUNT add constraint ACCT_NO_unique unique(account_number);
INSERT INTO BANK_ACCOUNT(account_number ,AVAILABLE_BALANCE,PENDING_BALANCE ,ACCOUNT_TYPE ,ACCT_STATUS,customer_id ) values ('8872838283',300000,0,'Savings','active','222');
INSERT INTO BANK_ACCOUNT(account_number ,AVAILABLE_BALANCE,PENDING_BALANCE ,ACCOUNT_TYPE ,ACCT_STATUS,customer_id ) values ('8872838299',500000,55,'Savings','active','222');
INSERT INTO BANK_ACCOUNT(account_number ,AVAILABLE_BALANCE,PENDING_BALANCE ,ACCOUNT_TYPE ,ACCT_STATUS,customer_id ) values ('6872838260',30125,0,'Savings','active','333');
   