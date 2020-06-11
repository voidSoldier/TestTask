<%--
  Created by IntelliJ IDEA.
  User: NOIR-SAN
  Date: 11.06.2020
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" type="text/css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

    <script type='text/javascript'>
        $(document).ready(function () {
            $('#historyList').DataTable({
                pageLength: 16,
                ajax: {
                    url: '/testtask/histories',
                    dataSrc: ''
                },
                columns: [
                    {
                        title: 'BoardId',
                        data: 'boardId'
                    },
                    {
                        title: 'TradeDate',
                        data: 'tradeDate'
                    },
                    {
                        title: 'ShortName',
                        data: 'shortName'
                    },
                    {
                        title: 'Secid',
                        data: 'secid'
                    },
                    {
                        title: 'NumTrades',
                        data: 'numTrades'
                    },
                    {
                        title: 'Value',
                        data: 'value'
                    },
                    {
                        title: 'Open',
                        data: 'open'
                    },
                    {
                        title: 'Low',
                        data: 'low'
                    },
                    {
                        title: 'High',
                        data: 'high'
                    },
                    {
                        title: 'LegalClosePrice',
                        data: 'legalClosePrice'
                    },
                    {
                        title: 'WaPrice',
                        data: 'waPrice'
                    },
                    {
                        title: 'Close',
                        data: 'close'
                    },
                    {
                        title: 'Volume',
                        data: 'volume'
                    }, {
                        title: 'MarketPrice2',
                        data: 'marketPrice2'
                    }, {
                        title: 'MarketPrice3',
                        data: 'marketPrice3'
                    }, {
                        title: 'AdmittedQuote',
                        data: 'admittedQuote'
                    },
                    {
                        title: 'Mp2ValTrd',
                        data: 'mp2ValTrd'
                    },
                    {
                        title: 'MarketPrice3TradesValue',
                        data: 'marketPrice3TradesValue'
                    },
                    {
                        title: 'AdmittedValue',
                        data: 'admittedValue'
                    },
                    {
                        title: 'WaVal',
                        data: 'waVal'
                    },
                ]
            });
            // updateTable: updateFilteredTable
        });
    </script>

    <title>Title</title>
</head>
<body>
<h2>History record</h2>
<table id="historyList" class="display" style="width:100%"></table>
</body>
</html>
