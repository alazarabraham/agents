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
            <a href="/Capstoneproject2/newagent">Add New Agent</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Capstoneproject2/listagent">List All Agents</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Agents</h2></caption>
            <tr>
                <th>Agent Id</th>
                <th>First Name</th>
                <th>Middle Name</th>
                <th>Last Name</th>
                <th>Password</th>
                <th>Phone</th>
                <th>Email Address</th>
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
                        <a href="/Capstoneproject2/editagent?agent_id=<c:out value='${agent.agent_id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Capstoneproject2/deleteagent?agent_id=<c:out value='${agent.agent_id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
<script>console.log(agent.firstName)</script>
</html>