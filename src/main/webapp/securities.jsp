<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <link rel="stylesheet" href="../resources/css/jquery.dataTables.min.css">--%>
<%--    <script type="text/javascript" src="webjars/datatables/1.10.21/js/jquery.dataTables.min.js" defer></script>--%>
<%--    <script type="text/javascript" src="webjars/jquery/3.4.1/jquery.min.js"></script>--%>

<%--    <script type="text/javascript" src="../resources/js/js.js" defer></script>--%>
    <title>Title</title>
</head>
<body>
<section>
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
        <c:forEach items="${securities}" var="secto">
            <jsp:useBean id="secto" type="com.javajunior.testtask.to.SecurityTo"/>
            <tr>
                <td></td>
                <td>${secto.regNumber}</td>
                <td>${secto.name}</td>
                <td>${secto.emitentTitle}</td>
                <td>${secto.tradeDate}</td>
                <td>${secto.numTrades}</td>
                <td>${secto.open}</td>
                <td>${secto.close}</td>
                <td><a href="securities/update?id=${secto.id}">Update Security</a></td>
                <td><a href="securities/delete?id=${secto.id}">Delete Security</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <br>
    <br>
    <a href="newSec.jsp">Create new security</a>
    <br>
    <br>
    <br>
    <a href="newHist.jsp">Create new history</a>

</section>
</body>
</html>
