<%-- 
    Document   : analyticsinput
    Created on : Oct 20, 2017, 4:35:43 PM
    Author     : TechDev
--%>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title>ATM Reconciliation Tool</title>

        <meta name="description" content="overview &amp; stats" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        <!-- bootstrap & fontawesome -->
        

        <!-- page specific plugin styles -->

        <!-- text fonts -->
        

        <!-- ace styles -->
       
       
        <script src="chart/Chart.bundle.js" type="text/javascript"></script>
        <script src="chart/utils.js" type="text/javascript"></script>
       




        <style type="text/css">
            canvas{
                -moz-user-select: none;
                -webkit-user-select: none;
                -ms-user-select: none;
            }
        </style>
    <div>
        <!-- animate.css -->
        
        </head>
        <body class="no-skin">

            <!-- End Nav Bar -->
            <div class="main-container ace-save-state" id="main-container">
                <script type="text/javascript">
                    try {
                        ace.settings.loadState('main-container')
                    } catch (e) {
                    }
                </script>
                <!--Sidebar-->

                <!--End Sidebar-->
            </div>
    <div id="container" style="width: 25%;">
        <canvas id="myChart" width="300" height="300"></canvas>
    </div>
        <script>
            var ctx = document.getElementById("myChart").getContext('2d');
            var myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                        labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
                            
            
                            
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255,99,132,1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1
                        }]
                },
                options: {
                    scales: {
                        yAxes: [{
                                ticks: {
                                    beginAtZero: true
                                }
                            }]
                    }
                }
            });
</script>
        
             
             
    </body>
</html>

