<%@ page import="com.model.Student"%>
<%@ page import="java.util.List"%>

<html>
<body>

<h2>Student List</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
</tr>

<%
List<Student> list = (List<Student>) request.getAttribute("list");

for(Student s : list){
%>
<tr>
    <td><%= s.getId() %></td>
    <td><%= s.getName() %></td>
    <td><%= s.getAge() %></td>
</tr>
<%
}
%>

</table>

</body>
</html>