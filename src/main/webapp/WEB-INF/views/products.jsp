<%--
  Created by IntelliJ IDEA.
  User: karen
  Date: 9/27/17
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>E-commerce</title>

    <script src="<%=request.getContextPath()%>/js/lib/jquery-3.2.1.js"></script>
    <script src="<%=request.getContextPath()%>/js/main.js"></script>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
</head>
<body>

<div class="header">
    <ul class="navbar">
        <li><a href="#">Motors</a></li>
        <li><a href="#">Fashion</a></li>
        <li><a href="#">Electronics</a></li>
        <li><a href="#">Collectibles&Art</a></li>
        <li><a href="#">Home&Garden</a></li>
        <li><a href="#">Sporting Goods</a></li>
        <li><a href="#">Toys</a></li>
        <li><a href="#">Business&Industrial</a></li>
        <li><a href="#">Music</a></li>
        <li><a href="#">Deals</a></li>
    </ul>
</div>

<div class="content">

    <c:forEach items="${productList}" var="product">
        <p>${product._name}</p>
    </c:forEach>

</div>

<div class="footer">
    Etiam eu faucibus lacus. Cras at purus diam. Morbi rhoncus, lectus vitae tincidunt congue, quam est vehicula risus, at interdum dui lacus eu odio. Duis nec quam nec purus semper tincidunt. Sed pulvinar eu nisi quis condimentum. Etiam dolor purus, consectetur non facilisis ac, fringilla sit amet elit. Proin vitae laoreet neque, nec congue erat. Curabitur urna quam, lacinia quis scelerisque malesuada, ornare id est.
</div>

</body>
</html>
