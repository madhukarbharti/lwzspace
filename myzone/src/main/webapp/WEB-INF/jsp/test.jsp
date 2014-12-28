<%--
  Created by IntelliJ IDEA.
  User: xiaoQuan
  Date: 2014/12/21
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
${Key}
<c:forEach var="person" items="${persons}">
  <tr>
    <td>${person.id}</td>
  </tr>
</c:forEach>
</body>
</html>
