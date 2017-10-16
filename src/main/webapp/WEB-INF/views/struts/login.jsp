<%--
  Created by IntelliJ IDEA.
  User: karen
  Date: 9/29/17
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

    <h3>Welcome User, please login below</h3>

    <s:form action="login">
        <s:textfield _name="_name" label="User Name"/>
        <s:textfield _name="password" label="Password" type="password"/>
        <s:submit value="Login"/>
    </s:form>

</body>
</html>
