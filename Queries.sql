-- LIST OF ALL STUDENTS (order by their first name)
select firstName as Students_First_Name, lastName as Students_Last_Name from students
order by firstName;
 -- GENERALLY LIST OF ALL STUDENTS
select * from students;

-- LIST OF ALL TRAINERS (order by their first name)
select firstName as Trainers_First_Name, lastName as Trainers_Last_Name from trainers
order by firstName;
 -- GENERALLY LIST OF ALL TRAINERS
select * from trainers;

-- LIST OF ALL ASSIGNMENTS
select * from assignments;

-- LIST OF ALL COURSES
select * from courses;

-- LIST OF ASSIGNMENTS PER COURSE
-- Α Τρόπος
select Title, Course_Type, Course_Stream, as_description, SubDateTime, TotalMark, OralMark from courses
join assignments on courses.C_ID=assignments.Course_ID
order by Title;

-- LIST OF STUDENTS PER COURSE
-- A Τρόπος
select courses.*, students.* from student_per_course, courses, students 
where courses.C_ID=student_per_course.Cour_ID and student_per_course.Stud_ID=students.St_ID
order by Title;
-- Β Τρόπος
select courses.*, students.* 
from students 
join student_per_course
on student_per_course.Stud_ID=students.St_ID
join courses
on courses.C_ID=student_per_course.Cour_ID
order by Title;

-- LIST OF TRAINERS PER COURSE
-- A Τρόπος
select courses.*, trainers.* from trainer_per_course, courses, trainers
where courses.C_ID=trainer_per_course.Cor_ID and trainer_per_course.Train_ID=trainers.T_ID
order by Title;
-- B Τρόπος
select courses.*, trainers.* from trainers
join trainer_per_course on trainer_per_course.Train_ID=trainers.T_ID
join courses on courses.C_ID=trainer_per_course.Cor_ID
order by Title;

-- LIST OF ASSIGNMENTS PER COURSE PER STUDENT
-- A Τρόπος
create view Assignment_per_course_per_student as
select students.*, C_ID, Title, Course_Stream, Course_Type,StartDate,EndDate, assignments.*  from student_per_course, courses, students, assignments 
where courses.C_ID=student_per_course.Cour_ID and student_per_course.Stud_ID=students.St_ID and assignments.Course_ID=student_per_course.Cour_ID
order by firstName;
-- B Τρόπος
select students.*, C_ID, Title, Course_Stream, Course_Type,StartDate,EndDate, assignments.*  from assignments 
join courses on assignments.Course_ID=courses.C_ID
join student_per_course on student_per_course.Cour_ID=courses.C_ID
join students on student_per_course.Stud_ID=students.St_ID
order by firstName;

-- LIST OF STUDENTS THAT BELONG TO MANY COURSES
select Stud_ID as Μαθητες, students.firstName,students.lastName,COUNT(Stud_ID) 
as Πληθος_Μαθημάτων,courses.Title, courses.Course_Type  
FROM student_per_course
join students on students.St_ID=Stud_ID
join courses on courses.C_ID=Cour_ID
GROUP BY Stud_ID
HAVING COUNT(Stud_ID) > 1
order by St_ID;

