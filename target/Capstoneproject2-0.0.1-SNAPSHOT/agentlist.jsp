<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Agent</title>
</head>
<body>
    <center>
        <h1>Agent Management</h1>
        <h2>
            <a href="/newagent">Add New Agent</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/listagent">List All Agents</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Agents</h2></caption>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="agent" items="${listAgent}">
                <tr>
                    <td><c:out value="${agent.agent_id}" /></td>
                    <td><c:out value="${agent.firstName}" /></td>
                    <td><c:out value="${agent.middleName}" /></td>
                    <td><c:out value="${agent.lastName}" /></td>
                    <td><c:out value="${agent.password}" /></td>
                    <td><c:out value="${agent.phone}" /></td>
                    <td><c:out value="${agent.emailAddress}" /></td>
                    <td>
                        <a href="/edit?agent_id=<c:out value='${agent.agent_id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?agent_id=<c:out value='${agent.agent_id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>