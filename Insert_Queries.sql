-- INSERT COURSES INTO TABLE COURSES

INSERT INTO courses(Title, Course_Stream, Course_Type, StartDate, EndDate) VALUES ('lalala', 'cb12', 'parttime', '2022-02-02', '2022-05-02');

-- INSERT ASSIGNMENTS INTO TABLE ASSIGNMENTS

INSERT INTO assignments(as_description, SubDateTime, TotalMark, OralMark, Course_ID) VALUES ('FinalProject', '2022-08-01 23:59:59', '100.00', '100.00', '6');

-- INSERT STUDENTS INTO TABLE STUDENTS

INSERT INTO students(firstName, lastName, DateOfBirth, TuitionFees) VALUES ('Aimilios', 'Raptoglou', '1997-12-02', '2500');

-- INSERT TRAINERS INTO TABLE TRAINERS

INSERT INTO trainers(firstName, lastName, Tr_Subject) VALUES ('Violeta', 'Pagoniadi', 'c');

-- INSERT STUDENTS PER COURSE INTO TABLE STUDENTS PER COURSE

INSERT INTO student_per_course(Stud_ID, Cour_ID) VALUES ('2', '3');

-- INSERT TRAINERS PER COURSE INTO TABLE TRAINERS PER COURSE

INSERT INTO trainer_per_course(Train_ID, Cor_ID) VALUES ('15', '3');


