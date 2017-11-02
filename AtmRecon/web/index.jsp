<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Essential Studio for JavaScript">
    <meta name="author" content="Syncfusion">
    <title></title>
    <!-- Essential Studio for JavaScript  theme reference -->
    <link rel="stylesheet" href="http://cdn.syncfusion.com/13.2.0.29/js/web/flat-azure/ej.web.all.min.css" />

    <!-- Essential Studio for JavaScript  script references -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="http://cdn.syncfusion.com/js/assets/external/jquery.easing.1.3.min.js"> </script>
    <script src="http://cdn.syncfusion.com/js/assets/external/jquery.globalize.min.js"></script>
    <script src="http://cdn.syncfusion.com/js/assets/external/jsrender.min.js"></script>
    <script src="http://cdn.syncfusion.com/13.2.0.29/js/web/ej.web.all.min.js"> </script>

    <!-- Add your custom scripts here -->

</head>
<body>
<div id='Grid'></div>
</body>
</html>



<script>
    


    $(function () {
        $('#Grid').ejGrid({
            dataSource: shipDetails
        });
    });

    var shipDetails = [
          { Name: 'Hanari Carnes', City: 'Brazil' },
          { Name: 'Split Rail Beer & Ale', City: 'USA' },
          { Name: 'Ricardo Adocicados', City: 'Brazil' }
    ];

</script>



