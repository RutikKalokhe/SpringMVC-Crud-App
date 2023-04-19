<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Data</title>
</head>
<body>

    <h5>
        <a href="insert">Insert Student Data</a>
    </h5>

    <table style="border: 1px solid black;">

        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Delete</th>
                <th>Update</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>
                        <form method="POST" action="deleteStudent">
                            <input type="hidden" name="id" value="${student.id}" />
                            <button type="submit" onclick="return confirm('Are you sure you want to delete this student?')">Delete</button>
                        </form>
                    </td>
                    <td>
                        <form action="updateStudent" method="GET">
                            <input type="hidden" name="id" value="${student.id}" />
                            <button type="submit">Update</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
