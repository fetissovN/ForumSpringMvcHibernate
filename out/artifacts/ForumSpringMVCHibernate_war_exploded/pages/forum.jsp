<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Николай
  Date: 12.04.2017
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${!empty posts}">
    <table>
        <c:forEach items="${posts}" var="post">
        <tr>
            <td>${post.name}</td>
            <td>${post.message}</td>
            <td><a href="<c:url value="/remove/${post.id}"/>">delete</a></td>
            <%--<td></td>--%>
        </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
