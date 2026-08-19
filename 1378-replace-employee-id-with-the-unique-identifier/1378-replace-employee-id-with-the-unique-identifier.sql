# Write your MySQL query statement below
SELECT empuni.unique_id, emp.name FROM Employees emp LEFT JOIN EmployeeUNI empuni ON emp.id = empuni.id; 