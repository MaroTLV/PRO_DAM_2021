<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
    <head>
        <title>The master of Ajax</title>
        <!-- Include one of jTable styles. -->
        <link href="${pageContext.request.contextPath}/jTable/css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/jTable/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
        <!-- Include jTable script file. -->
        <script src="${pageContext.request.contextPath}/jTable/js/jquery-1.8.2.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/jTable/js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/jTable/js/jquery.jtable.js" type="text/javascript"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('#StudentTableContainer').jtable({
                    title: 'Students List',
                    paging: true,
                    pageSize: 3,
                    actions: {
                        listAction: '../Controller?action=list',
                        createAction: '../Controller?action=create',
                        updateAction: '../Controller?action=update',
                        deleteAction: '../Controller?action=delete'
                    },
                    fields: {
                        studentId: {
                            title: 'Student Id',
                            width: '30%',
                            key: true,
                            list: true,
                            edit: false,
                            create: true
                        },
                        name: {
                            title: 'Name',
                            width: '30%',
                            edit: true
                        },
                        department: {
                            title: 'Department',
                            width: '30%',
                            type: 'radiobutto',
                            options: {'1':'Contabilidad','2':'Desarrollo'},
                            edit: true
                        },
                        emailId: {
                            title: 'Email',
                            width: '20%',
                            edit: true
                        }
                    }
                });
                $('#StudentTableContainer').jtable('load');
            });
        </script>

    </head>
    <body>
        <div style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">

            <h4>EASY</h4>
            <div id="StudentTableContainer"></div>
        </div>
    </body>
</html>