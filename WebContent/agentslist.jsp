<%@page import="com.capstone.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>

        #main {


            width: 1000px;
            margin-left: auto;
            margin-right: auto;
            font-family: verdana;

        }

        aside {
            float: left;
            width: 30%;
            margin-bottom: 20px;
            height: 100%;
        }


        main {
            float: right;
            width: 70%;
            margin-bottom: 20px;

        }

        h1,
        p,
        img,
        header,
        nav {

            display: block;
        }

        header {
            color: white;
            background-color: black;

        }

        nav {
            width: 1000px;
            height: 60px;
            margin: 0 auto 20px;
            bottom: 50px;
        }

        nav ul {
            list-style-type: none;

        }

        nav ul li {
            float: left;
            padding: 16px;
        }

        nav ul li a {
            text-decoration: none;
            color: inherit;
        }

      
        button:hover {
            background-color: white;
            color: rgb(255, 115, 0);
            border-bottom: 5px solid rgb(255, 115, 0);

        }

        #tab {
            list-style: none;
        }

        #tab li {
            padding: 10px 0;
        }
    </style>
</head>

<body>

    <nav class="nav ">
       <a class="nav-link active bg-danger text-white"" href="listagent">Home</a>
        <a class="nav-link bg-danger text-white"" href=" #">Account</a>
        <a class="nav-link bg-danger text-white"" href="listagent">Agents</a>
        <a class="nav-link bg-danger text-white"" href="newagent">Register Agent</a>
        <a class="nav-link bg-danger text-white"" href="policyholderlist">Policy Holders</a>
        <a class="nav-link bg-danger text-white"" href="newpolicyholder">Register Policy Holder</a>
        
    </nav>
    <div id="main">
        <aside>

            <img src="https://www.designmantic.com/logo-images/166882.png?company=Company+Name&slogan=&verify=1"
                height="100" height="100" style="padding: 10px; margin: 10 auto;">
            <h1>Cap Car Company</h1>

            <ul id="tab">


            </ul>




        </aside>
        <main>
        
           
  <h1>Agent Management</h1>
        <h2>
            <a href="/Capstoneproject2/newagent">Add New Agent</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Capstoneproject2/listagent">List All Agents</a>
             
        </h2>
         <table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Agent ID</th>
      <th scope="col">Agent First Name</th>
      <th scope="col">Agent Middle Name</th>
      <th scope="col">Agent Last Name</th> 
      <th scope="col">Password</th>
      <th scope="col">Phone Number</th>
      <th scope="col">Email Address</th>
	  <th scope="col">Make changes</th>
      
      
      
    </tr>
  </thead>
  <tbody>
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
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Capstoneproject2/deleteagent?agent_id=<c:out value='${agent.agent_id}' />">Delete</a>                     
                    </td>
      
    </tr>
    </c:forEach>
   
  </tbody>
</table>


        </main>
    </div>


</body>

</html>