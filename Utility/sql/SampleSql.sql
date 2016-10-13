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


-- To find student name who secured max grade in 'maths' subject
select 
	st.student_id, st.student_name, a.grade 
from
	student st,
	(select max(grade) maxgrade, subject_id subid
	from grade
	group by subject_id) a,
	grade gr,
	subject sb
where
	st.student_id = gr.student_id
	and a.subid = gr.subject_id
	and a.maxgrade = gr.grade
	and sb.subject_name = 'maths'
	and sb.subject_id = a.subid
	

-- Delete duplicate rows
select x.*
from employee x
where
rowid not in (select min(rowid) from  employee y where x.empid= y.empid and x.empname = y.empname)


select x.* from employee x
where rowid not in (select min(rowid) from employee y group by empid, empname,....)


-- Find the name of the student whose sum of marks secured for english, match and science is high?
select stud4.name
from
(select max(stud2.tot) total from (select name, english+maths+scient tot from student) stud2 ) stud3,
(select name, english+maths+science tot from student) stud4
where
stud3.total = stud4.tot


	
	