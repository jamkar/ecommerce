<%--
  Created by IntelliJ IDEA.
  User: karen
  Date: 12/24/17
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <%--<link rel="icon" href="../../favicon.ico">--%>

    <title>Fixed Top Navbar Example for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/css/lib/bootstrap.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <%--<link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">--%>

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/css/lib/navbar-fixed-top.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/users.css">
</head>

<body>

<div class="container">
    <div id="buttons" class="row">
        <button type="button" id="allUsers" class="btn btn-default">List All Users</button>
    </div>
    <div class="row">
        <div class="fl">
            <label for="first_name">First Name</label>
            <input type="text" class="form-control" id="first_name">
        </div>
        <div class="fl">
            <label for="last_name">Last Name</label>
            <input type="text" class="form-control" id="last_name">
        </div>
        <div class="fl">
            <label for="avatar">Avatar</label>
            <input type="text" class="form-control" id="avatar">
        </div>
        <div class="fl" style="vertical-align: bottom">
            <button type="button" id="addUser" class="btn btn-default">Add New User</button>
        </div>
    </div>
    <div class="row">
        <table id="usersTable" class="table table-bordered">
            <caption>Users</caption>
            <thead>
                <tr id="head">
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Avatar</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>


    <p id="p"></p>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="<%=request.getContextPath()%>/js/lib/jquery-3.2.1.js"><\/script>')</script>
<script src="<%=request.getContextPath()%>/js/lib/bootstrap.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<%--<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>--%>


    <script>
        var contextPath = "<%=request.getContextPath()%>";

        $(document).ready(function () {
            Request.sendGET(contextPath + "/users", getAllUsersHandler);

            $("#allUsers").on("click", function (event) {
                event.preventDefault();
                Request.sendGET(contextPath + "/users", getAllUsersHandler);
            });

            $("#addUser").on("click", function (event) {
                event.preventDefault();
            });

        });

        function getAllUsersHandler(req, data) {
            console.log(req.responseText);
            var usersArray = JSON.parse(req.responseText);

            var i, rows = [];
            for (i = 0; i < usersArray.length; i++) {
                rows.push("<tr><td class='id'>" + usersArray[i].id + "</td><td class='first_name'>"
                    + usersArray[i].first_name + "</td><td class='last_name'>"
                    + usersArray[i].last_name + "</td><td class='avatar'>"
                    + usersArray[i].avatar + "</td><td>"
                    + "<button type=\"button\" class=\"btn btn-warning editUser\" style='margin-right: 5px'>Edit</button>"
                    + "<button type=\"button\" class=\"btn btn-danger deleteUser\">Delete</button></td></tr>");
            }
            var usersTable = $("#usersTable");
            usersTable.find("tbody").html(rows.join(""));
            addEventListenersToTable(usersTable);
        }
        
        function addEventListenersToTable(usersTable) {
            $(".editUser").on("click", function (event) {
                event.preventDefault();

            })
        }

        var Request = {};

        Request.send = function (url, method, handler, data) {
            var req = new XMLHttpRequest();

            req.onreadystatechange = function () {
                if (req.readyState == 4) {
                    if(req.status < 400) {
                        console.log(req.statusText);
                        handler(req, data);
                    } else {
                        console.log("There was a problem loading data :\n" + req.status+ "/" + req.statusText)
                    }
                }
            };

            if (method == "POST") {
                req.open("POST", url, true);
                req.send("" + data);
            }
            else if (method == "PUT") {
                req.open("PUT", url, true);
                req.send("" + data);
            }
            else if (method == "DELETE") {
                req.open("DELETE", url, true);
                req.send(null);
            }
            else if(method == "GET") {
                req.open("GET", url, true);
                req.send(null);
            }

            return req;
        };

        Request.sendPOST = function (url, data, handler) {
            if (data === undefined) {
                data = "";
            }
            return Request.send(url, "POST", handler, data);
        };

        Request.sendPUT = function (url, data, handler) {
            if (data === undefined) {
                data = "";
            }
            return Request.send(url, "PUT", handler, data);
        };

        Request.sendGET = function (url, handler) {
            return Request.send(url, "GET", handler);
        };

        Request.sendDELETE = function (url, handler) {
            return Request.send(url, "DELETE", handler);
        };


    </script>


</body>
</html>
