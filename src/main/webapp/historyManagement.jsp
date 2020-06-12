<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" type="text/css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

    <title>Manage History Records</title>
</head>
<body>
<script type="text/javascript" src="resources/js/history.js" defer></script>
<h2>History records</h2>
<table id="historyList" class="display" style="width:100%"></table>
<jsp:useBean id="hist" class="com.javajunior.testtask.model.History" scope="request"/>
<br><br><br>
<h3>Create new history</h3>
<form method="post" action="${pageContext.request.contextPath}/histories">
    <input type="hidden" value="${hist.id}" id="id" name="id" required><br><br>
    <label for="boardId">boardId</label><br>
    <input type="text" value="${hist.boardId}" id="boardId" name="boardId" required><br><br>
    <label for="tradeDate">tradeDate</label><br>
    <input type="date" value="${hist.tradeDate}" id="tradeDate" name="tradeDate" required><br><br>
    <label for="shortName">regNumber</label><br>
    <input type="text" value="${hist.shortName}" id='shortName' name="shortName" required><br><br>
    <label for="secid">secid</label><br>
    <input type="text" value="${hist.secid}" id='secid' name="secid" required><br><br>
    <label for="numTrades">numTrades</label><br>
    <input type="text" value="${hist.numTrades}" id='numTrades' name="numTrades" required><br><br>
    <label for="value">value</label><br>
    <input type="text" value="${hist.value}" id='value' name="value" required><br><br>
    <label for="open">open</label><br>
    <input type="text" value="${hist.open}" id='open' name="open" required><br><br>
    <label for="low">low</label><br>
    <input type="text" value="${hist.low}" id='low' name="low" required><br><br>
    <label for="high">high</label><br>
    <input type="text" value="${hist.high}" id='high' name="high" required><br><br>
    <label for="waPrice">waPrice</label><br>
    <input type="text" value="${hist.waPrice}" id='waPrice' name="waPrice" required><br><br>
    <label for="close">close</label><br>
    <input type="text" value="${hist.close}" id='close' name="close" required><br><br>
    <label for="volume">volume</label><br>
    <input type="text" value="${hist.volume}" id='volume' name="volume" required><br><br>
    <label for="marketPrice2">marketPrice2</label><br>
    <input type="text" value="${hist.marketPrice2}" id='marketPrice2' name="marketPrice2" required><br><br>
    <label for="marketPrice3">marketPrice3</label><br>
    <input type="text" value="${hist.marketPrice3}" id='marketPrice3' name="marketPrice3" required><br><br>
    <label for="mp2ValTrd">mp2ValTrd</label><br>
    <input type="text" value="${hist.mp2ValTrd}" id='mp2ValTrd' name="mp2ValTrd" required><br><br>
    <label for="marketPrice3TradesValue">marketPrice3TradesValue</label><br>
    <input type="text" value="${hist.marketPrice3TradesValue}" id='marketPrice3TradesValue' name="marketPrice3TradesValue" required><br><br>
    <label for="admittedValue">admittedValue</label><br>
    <input type="text" value="${hist.admittedValue}" id='admittedValue' name="admittedValue" required><br><br>
    <label for="waVal">waVal</label><br>
    <input type="text" value="${hist.waVal}" id='waVal' name="waVal" required><br><br>
    <button onclick="saveHistory()">Save</button>
    <button onclick="reset()">Reset</button>
</form>
<br><br><br>
<a href="index.jsp">Home</a>
</body>
</html>
