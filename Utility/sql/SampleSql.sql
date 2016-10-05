update testtable
set firstname = 
case 
	when firstname is null then 'no value'
    else firstname
end,
lastname = 
case 
	when lastname is null then 'no value'
    else lastname
end,
fullname = 
case 
	when fullname is null then 'no value'
    else fullname
end;


select t1.firstname,
  case
	when t1.firstname = t2.reverseName then
    'polindrom'
    else
    'not polindrom'
  end as 'isPolindrom'
from
(select firstname, reverse(firstname) from testtable1) t1,
(select firstname, reverse(firstname) reverseName from testtable1) t2
where
t1.firstname = t2.firstname;

drop table audit;
create table audit(id integer primary key, account varchar(10), balance integer, version integer);
select * from audit;
insert into audit values(1, 'abc', 100, 1);
insert into audit values(2, 'bbc', 200, 1);
insert into audit values(3, 'abc', 200, 2);
insert into audit values(4, 'abc', 200, 3);
insert into audit values(5, 'xyz', 300, 1);
insert into audit values(6, '123', 500, 1);
insert into audit values(7, 'xyz', 100, 2);


select max(id), account, balance, max(version) from audit group by account, balance;