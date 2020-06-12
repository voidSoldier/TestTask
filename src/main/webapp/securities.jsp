<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" type="text/css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>


    <%--    <script type="text/javascript" src="../resources/js/js.js" defer></script>--%>

    <script type='text/javascript'>
        $(document).ready(function () {
            getAll();
        });

        function getAll() {
            $('#securityToList').DataTable({
                pageLength: 16,
                ajax: {
                    url: '/testtask/securities/with-history',
                    dataSrc: ''
                },
                columns: [
                    {
                        title: 'Secid',
                        data: 'secid'
                    },
                    {
                        title: 'RegNumber',
                        data: 'regNumber'
                    },
                    {
                        title: 'Name',
                        data: 'name'
                    },
                    {
                        title: 'EmitentTitle',
                        data: 'emitentTitle'
                    },
                    {
                        title: 'TradeDate',
                        data: 'tradeDate'
                    },
                    {
                        title: 'NumTrades',
                        data: 'regNumber'
                    },
                    {
                        title: 'Open',
                        data: 'open'
                    },
                    {
                        title: 'Close',
                        data: 'close'
                    }
                ]
            });
        }

        function destroyTable() {
            var table = $('#securityToList').DataTable();
            table.destroy();
            getAll();
        }
    </script>
    <title>Title</title>
</head>
<body>
<script type="text/javascript" src="resources/js/js.js" defer></script>
<section>
    <hr/>
    <h2>Securities</h2>
    <br><br>
    <div>
        <form id="filter">
            <div>
                <div>
                    <label for="emitentTitle">Emitent Title</label>
                    <input name="emitentTitle" id="emitentTitle">
                </div>
                <div>
                    <label for="tradeDate">Trade Date</label>
                    <input name="tradeDate" id="tradeDate">
                </div>
            </div>
        </form>
    </div>
    <div>
        <button onclick="clearFilter()">Clear filter</button>
        <button onclick="updateFilteredTable()">Filter</button>
    </div>
    <br>
    <br>
    <br>
    <table id="securityToList" class="display" style="width:100%">

    </table>
    <button onclick="destroyTable()">Update table</button>
    <%--    <table border="1" cellpadding="8" cellspacing="0">--%>
    <%--        <thead>--%>
    <%--        <tr>--%>
    <%--            <th>regNumber</th>--%>
    <%--            <th>name</th>--%>
    <%--            <th>emitentTitle</th>--%>
    <%--            <th>tradeDate</th>--%>
    <%--            <th>numTrades</th>--%>
    <%--            <th>open</th>--%>
    <%--            <th>close</th>--%>
    <%--            <th></th>--%>
    <%--            <th></th>--%>
    <%--        </tr>--%>
    <%--        </thead>--%>
    <%--        <c:forEach items="${securities}" var="secto">--%>
    <%--            <jsp:useBean id="secto" type="com.javajunior.testtask.to.SecurityTo"/>--%>
    <%--            <tr>--%>
    <%--                <td></td>--%>
    <%--                <td>${secto.regNumber}</td>--%>
    <%--                <td>${secto.name}</td>--%>
    <%--                <td>${secto.emitentTitle}</td>--%>
    <%--                <td>${secto.tradeDate}</td>--%>
    <%--                <td>${secto.numTrades}</td>--%>
    <%--                <td>${secto.open}</td>--%>
    <%--                <td>${secto.close}</td>--%>
    <%--                <td><a href="securities/update?id=${secto.id}">Update Security</a></td>--%>
    <%--                <td><a href="securities/delete?id=${secto.id}">Delete Security</a></td>--%>
    <%--            </tr>--%>
    <%--        </c:forEach>--%>
    <%--    </table>--%>
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
