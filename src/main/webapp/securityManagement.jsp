<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" type="text/css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>


    <title>Manage Security Records</title>
</head>
<body>
<script type="text/javascript" src="resources/js/security.js" defer></script>
<h2>Security records</h2>
<table id="securityList" class="display" style="width:100%"></table>
<br><br><br><br><br>
<jsp:useBean id="sec" class="com.javajunior.testtask.model.Security" scope="request"/>
<h3>Add or update security record</h3>
<form id="saveSec" method="post" action="${pageContext.request.contextPath}/securities">
    <label for="id">Id</label><br>
    <input type="number" value="${sec.id}" id="id" name="id" required><br><br>
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
    <button onclick="saveSecurity()">Save</button>
    <button onclick="reset()">Reset</button>
</form>
<br><br><br>
<a href="index.jsp">Home</a>
</body>
</html>
