<%--
  Created by IntelliJ IDEA.
  User: karen
  Date: 9/29/17
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${productList}" var="product">
    <p>${product._name}</p>
</c:forEach>
