<!DOCTYPE>
<html>
    <head>
        <title>The master of Ajax</title>
        <!-- Include one of jTable styles. -->
        <link href="jTable/css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
        <link href="jTable/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
        <!-- Include jTable script file. -->
        <script src="jTable/js/jquery-1.8.2.js" type="text/javascript"></script>
        <script src="jTable/js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
        <script src="jTable/js/jquery.jtable.js" type="text/javascript"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('#StudentTableContainer').jtable({
                    title: 'Students List',
                    paging: true,
                    pageSize: 3,
                    actions: {
                        listAction: 'jTableStudentController?action=list',
                        createAction: 'jTableStudentController?action=create',
                        updateAction: 'jTableStudentController?action=update',
                        deleteAction: 'jTableStudentController?action=delete'
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
                        clase: {
                            title: 'Clase',
                            width: '30%',
                            type: 'radiobutto',
                            options: {'1':'1-ESO','2':'2-2ESO','3':'3-ESO','4':'4-4ESO'},
                            edit: true
                        },
                        matricula: {
                            title: 'Matricula',
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

            <h4>Listado de Estudiantes</h4>
            <div id="StudentTableContainer"></div>
        </div>
    </body>
</html>