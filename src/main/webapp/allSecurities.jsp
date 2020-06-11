<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" type="text/css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

        <script type='text/javascript'>
            $(document).ready(function () {
                $('#securityList').DataTable({
                    pageLength: 16,
                    ajax: {
                        url: '/testtask/securities/full',
                        dataSrc: ''
                    },
                    columns: [
                        {
                            title: 'Secid',
                            data: 'secid'
                        },
                        {
                            title: 'ShortName',
                            data: 'shortName'
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
                            title: 'Isin',
                            data: 'isin'
                        },
                        {
                            title: 'IsTraded',
                            data: 'isTraded'
                        },
                        {
                            title: 'EmitentId',
                            data: 'emitentId'
                        },
                        {
                            title: 'EmitentTitle',
                            data: 'emitentTitle'
                        },
                        {
                            title: 'EmitentInn',
                            data: 'emitentInn'
                        },
                        {
                            title: 'EmitentOkpo',
                            data: 'emitentOkpo'
                        },
                        {
                            title: 'GosReg',
                            data: 'gosReg'
                        },
                        {
                            title: 'Type',
                            data: 'type'
                        },
                        {
                            title: 'Group',
                            data: 'group'
                        },
                        {
                            title: 'PrimaryBoardId',
                            data: 'primaryBoardId'
                        },
                        {
                            title: 'MarketPriceBoardId',
                            data: 'marketPriceBoardId'
                        }
                    ]
                });
                // updateTable: updateFilteredTable
            });
        </script>

    <title>Title</title>
</head>
<body>
<h2>Full security record</h2>
<table id="securityList" class="display" style="width:100%"></table>
</body>
</html>
