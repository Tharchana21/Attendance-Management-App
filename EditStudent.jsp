<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.List" %>
<%@ page import="com.besant.model.Student" %>
<!DOCTYPE html>
<html>
<head>
<style>
input[type="text"],select,input[type="date"]
{
height:25px;
width:300px;
border-radius:20px;
border: 1px solid black;
background: rgba(255, 255, 255, 0.1); 
backdrop-filter: blur(10px); 
color: black;
}
input[type="submit"]
{
border-radius:10px;
height:20px;
width:150px;
cursor:pointer;
}
input[type="submit"]:hover
{
color:white;
background-color:black;
}
 body {
	background-image:
		url("https://media.istockphoto.com/id/1162301293/photo/blurred-august-calendar-on-blue-tone.jpg?s=612x612&w=0&k=20&c=VXcSEVN6Qub7ufw5Q340vPhsQyBos-uzEwhM7ER_f3k=");
	background-size: 100% 600%;
	background-repeat: no-repeat;
}
 table {
           width: 50%;
padding:40px;
box-shadow: 0px 15px 35px rgba(0, 0, 0, 0.3);
border-radius:30px;

}
       th, td {
          
           padding: 8px;
           text-align: center;
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align=center>UPDATE STUDENT INFORMATION</h2>

<%
    List<Student> students = (List<Student>) request.getAttribute("students");
    for(Student student : students) {
%>
    <form action="update" method="POST">
   <table align=center>
<tr>
<td>ID</td>
<td>:</td>
<td><input type="hidden" name="ID" value="<%= student.getID() %>"></td>
<tr>
<td>ROLLNUMBER</td>
<td>:</td>
<td><input type="text" name="ROLLNUMBER" value="<%= student.getROLLNUMBER() %>"></td>
</tr>
<tr>
<td>STUDENTNAME</td>
<td>:</td>
<td><input type="text" name="STUDENTNAME" value="<%= student.getSTUDENTNAME() %>"></td>
</tr>
<tr>
<td>COURSE</td>
<td>:</td>
<td><select name="COURSE" value="<%= student.getCOURSE() %>">
<option></option>
<option>INFORMATION TECHNOLOGY</option>
<option>COMPUTER SCIENCE</option>
<option>MECHANICAL ENGINEERING</option>
<option>CIVIL ENGINEERING</option>
<option>ELECTRICAL AND ELECTRONICS ENGINEERING</option>
</select>
</td>
</tr>
<tr>
<td>ATTENDACESTATUS</td>
<td>:</td>
<td><select name="ATTENDANCESTATUS" value="<%= student.getATTENDANCESTATUS() %>">
<option></option>
<option>PRESENT</option>
<option>ABSENT</option>
</select>
</td>
</tr>
<tr>
<td>ATTENDANCEDATE</td>
<td>:</td>
<td><input type="date" name="ATTENDANCEDATE" value="<%= student.getATTENDANCEDATE() %>"></td>
</tr>
<tr>
<td>SAVEATTENDANCE</td>
<td>:</td>
<td><input type="SUBMIT" value="UPDATE"></td>
</tr>
</table>
</form>

<%
    }
%>
</body>
</html>
