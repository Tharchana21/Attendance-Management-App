create database OnlineAttendanceApp;
use OnlineAttendanceApp;

create table UsersTable(
USERNAME varchar(50),
EMAIL varchar(50),
DEPARTMENT varchar(50),
COURSE varchar(50),
PASSWORD varchar(50),
CONFIRMPASSWORD varchar(50)
);

select * from OnlineAttendanceApp.UsersTable;


CREATE TABLE attendanceData (
    ROLLNUMBER VARCHAR(20),
    STUDENTNAME VARCHAR(50),
    COURSE VARCHAR(50),
    ATTENDANCESTATUS VARCHAR(50),
    ATTENDANCEDATE VARCHAR(50)
);

select*from OnlineAttendanceApp.attendanceData;

