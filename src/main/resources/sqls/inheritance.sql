---------------- Table_PER_CLASS -----------------------

---------------- All Users---------------

select u1_0.id, u1_0.clazz_, u1_0.password, u1_0.username, u1_0.staff_pass, u1_0.college_pass
from (select id, password, username, cast(null as text) as staff_pass, cast(null as text) as college_pass, 0 as clazz_
      from user_tpc
      union all
      select id, password, username, staff_pass, cast(null as text) as college_pass, 1 as clazz_
      from mentor_tpc
      union all
      select id, password, username, cast(null as text) as staff_pass, college_pass, 2 as clazz_
      from student_tpc) u1_0

--------------------SINGLE_TABLE --------------------------

---------------- All Users---------------
select u1_0.id, u1_0.user_type, u1_0.password, u1_0.username, u1_0.staff_pass, u1_0.college_pass
from user_st u1_0

---------------- All Students---------------
select s1_0.id, s1_0.password, s1_0.username, s1_0.college_pass
from user_st s1_0
where s1_0.user_type = 2

---------------- All Mentors---------------
select m1_0.id, m1_0.password, m1_0.username, m1_0.staff_pass
from user_st m1_0
where m1_0.user_type = 1


--------------------- JOINED_TABLE -------------------------

---------------- All Users---------------
select u1_0.id,
       case when u1_1.id is not null then 1 when u1_2.id is not null then 2 when u1_0.id is not null then 0 end,
       u1_0.password,
       u1_0.username,
       u1_1.staff_pass,
       u1_2.college_pass
from user_jt u1_0
         left join mentor_jt u1_1 on u1_0.id = u1_1.id
         left join student_jt u1_2 on u1_0.id = u1_2.id

---------------- All Students---------------
select s1_0.id, s1_1.password, s1_1.username, s1_0.college_pass
from student_jt s1_0
         join user_jt s1_1 on s1_0.id = s1_1.id

---------------- All Mentors---------------
select m1_0.id, m1_1.password, m1_1.username, m1_0.staff_pass
from mentor_jt m1_0
         join user_jt m1_1 on m1_0.id = m1_1.id

----------------Delete User------------------
delete from student_jt where id=?
delete from user_jt where id=?

--------------------------END--------------------------------