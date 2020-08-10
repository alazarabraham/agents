<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <a class="nav-link active bg-danger text-white"" href="policyholderlist">Home</a>
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
        <h1>Policy Holder Manager</h1>
        <h2>
            <a href="/Capstoneproject2/newpolicyholder">Add New Policy Holder</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Capstoneproject2/listpolicy_holder">List All Policy Holders</a>
             
        </h2>
        <c:if test="${policy_holder != null}">
            <form action="/Capstoneproject2/updatepolicyholder" method="post">
        </c:if>
        <c:if test="${policy_holder == null}">
            <form action="/Capstoneproject2/insertpolicyholder" method="post">
        </c:if>
        <table class="table table-bordered" border="1" cellpadding="5">
        
            <caption>
                <h2>
                    <c:if test="${policy_holder != null}">
                    </c:if>
                    <c:if test="${policy_holder == null}">
                        
                    </c:if>
                </h2>
            </caption>
                <c:if test="${policy_holder != null}">
                    <input type="hidden" name="PH_key" value="<c:out value='${policy_holder.PH_key}' />" />
                </c:if> 
                          
            <tr>
                <th scope="col">First Name: </th>
                <td>
                    <input type="text" name="firstName" size="45"
                            value="<c:out value='${policy_holder.firstName}' />"
                        />
                </td>
            </tr>
              <tr>
                <th>Middle Name: </th>
                <td>
                    <input type="text" name="middleName" size="45"
                            value="<c:out value='${policy_holder.middleName}' />"
                        />
                </td>
            </tr>
              <tr>
                <th>Last Name: </th>
                <td>
                    <input type="text" name="lastName" size="45"
                            value="<c:out value='${policy_holder.lastName}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Date of Birth: </th>
                <td>
                    <input type="text" name="DOB" size="45"
                            value="<c:out value='${policy_holder.DOB}' />"
                        />
                </td>
            </tr>
          <tr>
                <th>Password: </th>
                <td>
                    <input type="text" name="password" size="45"
                            value="<c:out value='${policy_holder.password}' />"
                        />
                </td>
            </tr>
              
              <tr>
                <th>Email Address: </th>
                <td>
                    <input type="text" name="emailAddress" size="45"
                            value="<c:out value='${policy_holder.emailAddress}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Policy Key: </th>
                <td>
                    <input type="text" name="policy_key" size="45"
                            value="<c:out value='${policy_holder.policy_key}' />"
                        />
                </td>
            </tr>
            
            
          
            <tr>
                <td colspan="2" align="center">
                <input class="btn btn-outline-danger" type="submit" value="Save" />
                
                </td>
            </tr>
        </table>
        </form>
        </main>


</body>
<script src="js.js">console.log(policy_key)</script>

</html>