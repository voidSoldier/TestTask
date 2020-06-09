<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <link rel="stylesheet" href="resources/css/jquery.dataTables.min.css">--%>
<%--    <script type="text/javascript" src="webjars/datatables/1.10.21/js/jquery.dataTables.min.js" defer></script>--%>
<%--    <script type="text/javascript" src="webjars/jquery/3.4.1/jquery.min.js"></script>--%>

<%--    <script type="text/javascript" src="resources/js/js.js" defer></script>--%>
    <title>Title</title>
</head>
<body>
<section>
<%--    <h3><a href="../../index.jsp">Home</a></h3>--%>
    <hr/>
    <h2>Securities</h2>
    <br><br>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>regNumber</th>
            <th>name</th>
            <th>emitentTitle</th>
            <th>tradeDate</th>
            <th>numTrades</th>
            <th>open</th>
            <th>close</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${securities}" var="sec">
            <jsp:useBean id="sec" type="com.javajunior.testtask.to.SecurityTo"/>
            <tr>
                <td></td>
                <td>${sec.regNumber}</td>
                <td>${sec.name}</td>
                <td>${sec.emitentTitle}</td>
                <td>${sec.tradeDate}</td>
                <td>${sec.numTrades}</td>
                <td>${sec.open}</td>
                <td>${sec.close}</td>
                <td><a href="securities/update?id=${sec.id}">Update</a></td>
                <td><a href="securities/delete?id=${sec.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
