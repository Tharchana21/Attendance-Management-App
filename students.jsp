<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.besant.model.Student" %>
<!DOCTYPE html>
<html>
<head>
   <title>Student List</title>
   <style>
   body {
	background-image:
		url("https://media.istockphoto.com/id/1162301293/photo/blurred-august-calendar-on-blue-tone.jpg?s=612x612&w=0&k=20&c=VXcSEVN6Qub7ufw5Q340vPhsQyBos-uzEwhM7ER_f3k=");
	background-size: 100% 600%;
	background-repeat: no-repeat;
}
       table {
           width: 100%;



padding:40px;
box-shadow: 0px 15px 35px rgba(0, 0, 0, 0.3);
border-radius:30px;
}

       
       th, td {
           border: 1px solid black;
           padding: 8px;
           text-align: left;
       }
       input[type="submit"]
       {
       height:25px;
	   width:80px;
	   cursor:pointer;
}
input[type="submit"]:hover
{
color:white;
background-color:black;
}
   </style>
</head>
<body>
<h1 align=center>ATTENDANCE DATA</h1>
<table>
   <tr>
       <th>ID</th>
       <th>ROLLNUMBER</th>
       <th>STUDENTNAME</th>
       <th>COURSE</th>
       <th>ATTENDANCESTATUS</th>
       <th>ATTENDANCEDATE</th>
       <th>CREATOR_ID</th>
       <th>CREATED_AT</th>
       <th>ACTIONS</th>
   </tr>
   <%
       List<Student> students = (List<Student>) request.getAttribute("students");
       for (Student student : students) {
   %>
   <tr>
       <td><%= student.getID() %></td>
       <td><%= student.getROLLNUMBER() %></td>
       <td><%= student.getSTUDENTNAME() %></td>
       <td><%= student.getCOURSE() %></td>
       <td><%= student.getATTENDANCESTATUS() %></td>
       <td><%= student.getATTENDANCEDATE() %></td>
       <td><%= student.getCREATOR_ID() %></td>
       <td><%= student.getCREATED_AT() %></td>
       <td>
           <form action="delete" method="POST">
               <input type="hidden" name="id" value="<%= student.getID() %>">
               <input type="submit" value="DELETE">
           </form>
          <br>
				<form action="edit" method="GET" style="display: inline;">
					<input type="hidden" name="id" value="<%=student.getID()%>">
					<input type="submit" value="EDIT">
				</form>
				
           
       </td>
   </tr>
   <%
       }
   %>
</table>
</body>
</html>
 
