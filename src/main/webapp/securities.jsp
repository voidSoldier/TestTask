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
                <td><a href="securities/update?id=${secto.id}">Update</a></td>
                <td><a href="securities/delete?id=${secto.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <jsp:useBean id="sec" class="com.javajunior.testtask.model.Security" scope="request"/>
    <br><br><br>
    <h3>Create new security</h3>
    <form method="post" action="${pageContext.request.contextPath}/securities" enctype="application/x-www-form-urlencoded">
        <label for="secid">secid</label><br>
        <input type="text" value="${sec.secid}" id="secid" name="secid" required><br><br>
        <label for="shortName">shortName</label><br>
        <input type="text" value="${sec.shortName}" id="shortName" name="shortName" required><br><br>
        <label for="regNumber">regNumber</label><br>
        <input type="text" value="${sec.regNumber}" id='regNumber' name="regNumber" required><br><br>
        <label for="name">name</label><br>
        <input type="text" value="${sec.name}" id='name' name="name" required><br><br>
        <label for="isin">isin</label><br>
        <input type="text" value="${sec.isin}" id='isin' name="isin" required><br><br>
        <label for="isTraded">isTraded</label><br>
        <input type="number" value="${sec.isTraded}" id='isTraded' name="isTraded" required><br><br>
        <label for="emitentId">emitentId</label><br>
        <input type="number" value="${sec.emitentId}" id='emitentId' name="emitentId" required><br><br>
        <label for="emitentTitle">emitentTitle</label><br>
        <input type="text" value="${sec.emitentTitle}" id='emitentTitle' name="emitentTitle" required><br><br>
        <label for="emitentInn">emitentInn</label><br>
        <input type="text" value="${sec.emitentInn}" id='emitentInn' name="emitentInn" required><br><br>
        <label for="emitentOkpo">emitentOkpo</label><br>
        <input type="text" value="${sec.emitentOkpo}" id='emitentOkpo' name="emitentOkpo" required><br><br>
        <label for="gosReg">gosReg</label><br>
        <input type="text" value="${sec.gosReg}" id='gosReg' name="gosReg" required><br><br>
        <label for="type">type</label><br>
        <input type="text" value="${sec.type}" id='type' name="type" required><br><br>
        <label for="group">group</label><br>
        <input type="text" value="${sec.group}" id='group' name="group" required><br><br>
        <label for="primaryBoardId">primaryBoardId</label><br>
        <input type="text" value="${sec.primaryBoardId}" id='primaryBoardId' name="primaryBoardId" required><br><br>
        <label for="marketPriceBoardId">marketPriceBoardId</label><br>
        <input type="text" value="${sec.marketPriceBoardId}" id='marketPriceBoardId' name="marketPriceBoardId" required><br><br>
        <button type="submit">Save</button>
    </form>
</section>
</body>
</html>
