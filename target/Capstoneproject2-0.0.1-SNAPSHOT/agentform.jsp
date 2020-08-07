<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
    <center>
        <h1>Agent Management</h1>
        <h2>
            <a href="/new">Add New Agent</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/agentlist">List All Agents</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${agent != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${agent == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${agent != null}">
                        Edit Agent
                    </c:if>
                    <c:if test="${agent == null}">
                        Add New agent
                    </c:if>
                </h2>
            </caption>
                <c:if test="${agent != null}">
                    <input type="hidden" name="agent_id" value="<c:out value='${agent.agent_id}' />" />
                </c:if>           
            <tr>
                <th>First Name: </th>
                <td>
                    <input type="text" name="firstName" size="45"
                            value="<c:out value='${agent.firstName}' />"
                        />
                </td>
            </tr>
              <tr>
                <th>Middle Name: </th>
                <td>
                    <input type="text" name="middleName" size="45"
                            value="<c:out value='${agent.middleName}' />"
                        />
                </td>
            </tr>
              <tr>
                <th>Last Name: </th>
                <td>
                    <input type="text" name="lastName" size="45"
                            value="<c:out value='${agent.lastName}' />"
                        />
                </td>
            </tr>
          <tr>
                <th>Password: </th>
                <td>
                    <input type="text" name="password" size="45"
                            value="<c:out value='${agent.password}' />"
                        />
                </td>
            </tr>
              <tr>
                <th>Phone Number: </th>
                <td>
                    <input type="text" name="phone" size="45"
                            value="<c:out value='${agent.phone}' />"
                        />
                </td>
            </tr>
              <tr>
                <th>Email Address: </th>
                <td>
                    <input type="text" name="emailAddress" size="45"
                            value="<c:out value='${agent.emailAddress}' />"
                        />
                </td>
            </tr>
          
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>