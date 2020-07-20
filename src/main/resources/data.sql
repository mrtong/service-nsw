insert into INSURER(`name`, code) values('Allianz',32);
insert into INSURER(`name`, code) values('AAMI',17);
insert into INSURER(`name`, code) values('GIO',13);
insert into INSURER(`name`, code) values('NRMA',27);

insert into vehicle( colour , make , model , tare_weight , `type` , vin )  values ('Blue','BMW','X4 M40i', 1700,'Wagon','12389347324');
insert into vehicle( colour , make , model , gross_mass ,tare_weight , `type` , vin )  values ('Silver','Toyota','Corolla', 1500, 1432,'Hatch','54646546313');
insert into vehicle( colour , make , model ,tare_weight , `type` , vin )  values ('Blue','Mercedes','X4 M40i', 1700,'Sedan','87676676762');
insert into vehicle( colour , make , model ,tare_weight , `type` , vin )  values ('Green','Jaguar','F pace', 1620,'SUV','65465466541');

insert into registrations (EXPIRY_DATE,EXPIRED ) values('2021-02-05T23:15:30.000Z',false);
insert into registrations (EXPIRY_DATE,EXPIRED ) values('2020-03-01T23:15:30.000Z',true);
insert into registrations (EXPIRY_DATE,EXPIRED ) values('2020-12-08T23:15:30.000Z',false);
insert into registrations (EXPIRY_DATE,EXPIRED ) values('2021-07-20T23:15:30.000Z',false);


insert into REG_INFO(PLATE_NUMBER ,INSURER_ID ,REG_ID ,VEHICLE_ID ) values('EBF28E',1,1,1);
insert into REG_INFO(PLATE_NUMBER ,INSURER_ID ,REG_ID ,VEHICLE_ID ) values('CXD82F',2,2,2);
insert into REG_INFO(PLATE_NUMBER ,INSURER_ID ,REG_ID ,VEHICLE_ID ) values('WOP29P',3,3,3);
insert into REG_INFO(PLATE_NUMBER ,INSURER_ID ,REG_ID ,VEHICLE_ID ) values('QWX55Z',4,4,4);



