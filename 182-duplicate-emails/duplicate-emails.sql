# Write your MySQL query statement below
select email from (select email,count(email) as x from Person group by email) as t where x>1;