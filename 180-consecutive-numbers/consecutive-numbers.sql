# Write your MySQL query statement below
select l1.num as 'ConsecutiveNums' from Logs l1,Logs l2,Logs l3 where l1.num=l2.num && l2.num=l3.num && l1.id=l2.id+1 && l2.id=l3.id+1 group by l1.num;