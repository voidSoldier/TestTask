<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" type="text/css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>


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
        }

        function updateFilteredTable() {
            $.ajax({
                type: "GET",
                url: "/testtask/securities" + "/filter",
                data: $("#filter").serialize(),

                success: function (data) {
                    var table = $('#securityToList').DataTable();
                    table.clear();
                    table.rows.add(data).draw();
                }
            })
        }

        function resetFilter() {
            $("#emitentTitle").val('');
            $("#tradeDate").val('');
            destroyTable();
            getAll();
        }


    </script>
    <title>Title</title>
</head>
<body>
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
                    <input type="date" name="tradeDate" id="tradeDate">
                </div>
            </div>
        </form>
    </div>
    <div>
        <button onclick="resetFilter()">Clear filter</button>
        <button onclick="updateFilteredTable()">Filter</button>
    </div>
    <br>
    <br>
    <br>
    <table id="securityToList" class="display" style="width:100%">

    </table>
    <button onclick="destroyTable()">Update table</button>

    <br>
    <br>
    <br>
    <a href="index.jsp">Home</a>
</section>
</body>
</html>
