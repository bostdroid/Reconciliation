<%-- 
    Document   : branchlist
    Created on : Jan 5, 2017, 1:56:27 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html ng-app="syncApp">
    <head>
        
    <script type="text/javascript" src="http://cdn.syncfusion.com/js/assets/external/jquery-2.1.4.min.js"></script>
    <script src="http://cdn.syncfusion.com/js/assets/external/angular.min.js"></script>
    <script src="https://cdn.syncfusion.com/15.1.0.41/js/web/ej.web.all.min.js"></script>
	<script src="https://cdn.syncfusion.com/15.1.0.41/js/common/ej.widget.angular.min.js"></script>
        
        <meta charset="utf-8">

        <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
        <META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
        <meta http-equiv="expires" content="FRI, 13 APR 1999 01:00:00 GMT">
        <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
        <title>ATM Report Portal</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="viewport" content="width=device-width">        
        <link rel="stylesheet" href="css/templatemo_main.css"/>
        <link rel="stylesheet" href="dist/css/sb-admin-2.min.css"/>
        <link rel="stylesheet" href="dist/css/sb-admin-2.css"/>

    <script src="http://cdn.syncfusion.com/js/assets/external/jquery-1.10.2.min.js"></script>
        <script src="http://cdn.syncfusion.com/15.1.0.41/js/web/ej.web.all.min.js"></script>
        <!--<link href="http://cdn.syncfusion.com/15.1.0.41/js/web/flat-azure/ej.web.all.min.css" rel="stylesheet"/>-->
        
        <link 
        href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" 
        rel="stylesheet"  type='text/css'>

        <!--link rel="stylesheet" href="http://cdn.syncfusion.com/13.2.0.29/js/web/flat-azure/ej.web.all.min.css" /-->
        <!--<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>-->
<!--        <script src="syncfusion/jsrender.min.js"></script>
        <script src="syncfusion/ej.web.all.min.js"> </script>-->
        <style>
    .navbar-inverse {
    background-color: #EAEDED;
    }
    
    .m3d {
                text-shadow: 0 1px 0 #ccc,
                    0 2px 0 #c9c9c9,
                    0 3px 0 #bbb,
                    0 4px 0 #b9b9b9,
                    0 5px 0 #aaa,
                    0 6px 1px rgba(0,0,0,.1),
                    0 0 5px rgba(0,0,0,.1),
                    0 1px 3px rgba(0,0,0,.3),
                    0 3px 5px rgba(0,0,0,.2),
                    0 5px 10px rgba(0,0,0,.25),
                    0 10px 10px rgba(0,0,0,.2),
                    0 15px 15px rgba(0,0,0,.15);
            }
            
/*.panel-green>.panel-heading {
    color: #fff;
    background-color: #01ff70;
    border-color: #00e765;
}

.panel-red>.panel-heading {
    color: #fff;
    background-color: #ff0000;
    border-color: #f22;
}

.panel-yellow>.panel-heading {
    color: #fff;
    background-color: #ff0;
    border-color: #e3c300;
}*/
        </style>
    </head>
    <body ng-controller="Chart">
        
        <div class="navbar navbar-inverse" role="navigation">
            <div class="navbar-header">
                <div class="logo">
                <a target="_blank" class="logo" href="http://www.activedgetechnologies.com"> 
                    <img src="logo3.png"> 
                </a>
<!--                <a target="_blank" class="logo" href="https://www.firstbanknigeria.com">
                    <img src="fbn.png"> 
                </a>-->
                </div>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp
                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                        <span class="sr-only">Toggle navigation</span>
                        <span class = "label label-primary" style="font-family: monospace; 
                              font-weight: bolder;  font-size: 18px;">ATM Dispense Error Report</span>
                    </a>

                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button> 
            </div>   
        </div>    

        <div id="main-wrapper">
            
            
            
            <div class="template-page-wrapper">
                <div class="navbar-collapse collapse templatemo-sidebar">
                   <ul class="templatemo-sidebar-menu">
                            <!--li class="dropdown">
                                <a href="#" class="dropdown-toggle" role="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fa fa-home"></i>Main Menu
                                <span class="caret"></span></a>
                                 <ul class="dropdown-menu templatemo-sidebar-menu"-->
                                <li><a href="rp" style="font-size: 14px;font-family: Calibri; font-weight: bolder;"><i class="fa fa-database text-orange"></i> Report</a></li>
                                <li><a href="initFile" style="font-size: 14px;font-family: Calibri; font-weight: bolder;"><i class="fa fa-download text-orange"></i> Download</a></li>
                                <li><a href="initJournalViewer" style="font-size: 14px;font-family: Calibri; font-weight: bolder;"><i class="fa fa-binoculars text-orange"></i> Journal Viewer</a></li>
                                <li class="active"><a href="initReport" style="font-size: 14px;font-family: Calibri; font-weight: bolder;"><i class="fa fa-android text-orange"></i>Dashboard</a></li>
                                 </ul>
                            

                   </ul>
                </div><!--/.navbar-collapse -->

                <div class="templatemo-content-wrapper">
                    <div class="templatemo-content">
                        <ol class="breadcrumb">
                            <li><a href="rp">Home</a></li>
                            <li class="active"><a href="#">Report Dashboard</a></li>
                        </ol>
                  

                                   

                        <div class="row">
                            <div class="col-md-5">
<!--                                <div class="alert alert-info alert-dismissable pull-right">
                                  
                                    
                                </div>-->
                            </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-signal fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${transactionSize} </div>
                                        <div><h5>Total Transactions</h5></div>
                                    </div>
                                </div>
                            </div>
                            <a href="findAllJournalViewers">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                                        
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-2">
                                        <i class="fa fa-warning fa-5x"></i>
                                    </div>
                                    <div class="col-xs-10 text-right">
                                        <div class="huge">${dispenseErrorSize} </div>
                                        <div><h5>Dispense Error Transactions</h5></div>
                                    </div>
                                </div>
                            </div>
                            <a href="findAllDispenseErrors">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
<!--                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-tasks fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">TerminalID ${dispenseSize}</div>
                                        <div>Busiest Terminals</div>
                                    </div>
                                </div>
                            </div>
                            <s:form id="myFForm" action="findAllBusiestTerminal">
                                <input type="hidden" id="max" name="viewer.terminalID"/>
                            </s:form>
                            <a href="javascript:doFind();">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>-->
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-credit-card fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${successSize}</div>
                                        <div><h5>Successful Transactions</h5></div>
                                    </div>
                                </div>
                            </div>
                            <a href="findAllSuccessfulTrans">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-support fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">&nbsp ${failedSize}</div>
                                        <div><h5>Failed Transactions</h5></div>
                                    </div>
                                </div>
                            </div>
                            <a href="findAllFailedTrans">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- /.row -->


                <div class="row">
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-bar-chart-o fa-fw"></i> Top 5 Terminals with highest number of dispense errors</h3>
                            </div>
                            <div class="panel-body">
                                <%--<s:form id="myForm" action="findAllDashboardViewers">--%>
                                    <!--<div id="searchcontainer" style="width: 810px; height: 500px;"></div>-->
                                <%--</s:form>--%>
                                    <div id="dispenseErrorChart"></div>
                                
                            </div>
                        </div>
                    </div>
                
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-bar-chart-o fa-fw"></i> Top 5 busiest terminals</h3>
                            </div>
                            <div class="panel-body">
                               
                                    <div id="busiestChart"></div>
                                
                                
                            </div>
                        </div>
                    </div>
               
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-bar-chart-o fa-fw"></i> Top 5 Terminals with highest number of unimpacted errors</h3>
                            </div>
                            <div class="panel-body">
                                <%--<s:form id="myForm" action="findAllDashboardViewers">--%>
                                    <!--<div id="searchcontainer" style="width: 810px; height: 500px;"></div>-->
                                <%--</s:form>--%>
                                    <div id="unimpactedChart"></div>
                                
                            </div>
                        </div>
                    </div>
<!--                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-bar-chart-o fa-fw"></i> Transaction Types on Terminals</h3>
                            </div>
                            <div class="panel-body">
                                <%--<s:form id="myForm" action="findAllDashboardViewers">--%>
                                    <div id="searchcontainer" style="width: 810px; height: 500px;"></div>
                                <%--</s:form>--%>
                                    <div id="tranTypeChart"></div>
                                
                            </div>
                        </div>
                    </div>             -->
                </div>

<!--  <div id="chartContainer" style="width:100%" ej-chart
               e-size-width="800px" e-size-height="600px" 
                             e-title-text="Transaction Type Chart" >				           
    <e-series>              
      <e-series e-name="Count" e-dataSource=dataSource e-xName="Terminal" e-yName="Count">					 
	  </e-series>
    <e-series e-name="Type"  e-dataSource=dataSource e-xName="Terminal" e-yName="Type">					   
	  </e-series>
    </e-series>
 </div>-->
                
                <!-- /.row -->

<!--                <div class="row">
                    <div class="col-lg-8">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div id="chartcontainer" style="width: 810px; height: 500px;"></div>
                            </div>
                            <div class="panel-body">
                                <div id="morris-donut-chart"></div>
                                <div class="text-right">
                                    <a href="#">View Details <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-clock-o fa-fw"></i> Tasks Panel</h3>
                            </div>
                            <div class="panel-body">
                                <div class="list-group">
                                    <a href="#" class="list-group-item">
                                        <span class="badge">just now</span>
                                        <i class="fa fa-fw fa-calendar"></i> Calendar updated
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">4 minutes ago</span>
                                        <i class="fa fa-fw fa-comment"></i> Commented on a post
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">23 minutes ago</span>
                                        <i class="fa fa-fw fa-truck"></i> Order 392 shipped
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">46 minutes ago</span>
                                        <i class="fa fa-fw fa-money"></i> Invoice 653 has been paid
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">1 hour ago</span>
                                        <i class="fa fa-fw fa-user"></i> A new user has been added
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">2 hours ago</span>
                                        <i class="fa fa-fw fa-check"></i> Completed task: "pick up dry cleaning"
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">yesterday</span>
                                        <i class="fa fa-fw fa-globe"></i> Saved the world
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">two days ago</span>
                                        <i class="fa fa-fw fa-check"></i> Completed task: "fix error on sales page"
                                    </a>
                                </div>
                                <div class="text-right">
                                    <a href="#">View All Activity <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-money fa-fw"></i> Transactions Panel</h3>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                            <tr>
                                                <th>Order #</th>
                                                <th>Order Date</th>
                                                <th>Order Time</th>
                                                <th>Amount (USD)</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>3326</td>
                                                <td>10/21/2013</td>
                                                <td>3:29 PM</td>
                                                <td>$321.33</td>
                                            </tr>
                                            <tr>
                                                <td>3325</td>
                                                <td>10/21/2013</td>
                                                <td>3:20 PM</td>
                                                <td>$234.34</td>
                                            </tr>
                                            <tr>
                                                <td>3324</td>
                                                <td>10/21/2013</td>
                                                <td>3:03 PM</td>
                                                <td>$724.17</td>
                                            </tr>
                                            <tr>
                                                <td>3323</td>
                                                <td>10/21/2013</td>
                                                <td>3:00 PM</td>
                                                <td>$23.71</td>
                                            </tr>
                                            <tr>
                                                <td>3322</td>
                                                <td>10/21/2013</td>
                                                <td>2:49 PM</td>
                                                <td>$8345.23</td>
                                            </tr>
                                            <tr>
                                                <td>3321</td>
                                                <td>10/21/2013</td>
                                                <td>2:23 PM</td>
                                                <td>$245.12</td>
                                            </tr>
                                            <tr>
                                                <td>3320</td>
                                                <td>10/21/2013</td>
                                                <td>2:15 PM</td>
                                                <td>$5663.54</td>
                                            </tr>
                                            <tr>
                                                <td>3319</td>
                                                <td>10/21/2013</td>
                                                <td>2:13 PM</td>
                                                <td>$943.45</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="text-right">
                                    <a href="#">View All Transactions <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div> 
                            </div>
                        
                            
                         
        
                            
                        </div>


                    </div>-->
                </div>

                <!-- Delete Modal -->

                
      
                                        </div>
                        
        
        
        
                        

   

          
                <!--End Sign Out Modal-->
                    <footer class="templatemo-footer">
                      <div class="templatemo-copyright">
                        <p>Copyright &copy; 2017 ActivEdge Technology Ltd</p>
                      </div>
                    </footer>
                  </div>
                                    

        </div>



        <script src="js/templatemo_script.js"></script>                      
    </body>
<!--    <script type="text/javascript" language="javascript ">
        BAR DATA
       $("#chartcontainer").ejChart({

            // ...

           //Initializing Series
           series: [{
               //Adding data points using x and y field of points
               points: [{ x: "John", y: 1000 }, { x: "Jake", y: 1900 }, { x: "Peter", y: 700 },
                        { x: "James", y: 2000 }, { x: "Mary", y: 1700 }]
               // ...
           }]
            // ...

      });
            
            CHART TYPE
            $("#chartcontainer").ejChart({
              // ...
            series: [{
                //Change type and color of the series.
                 type: 'bar',         
                 fill: "#E94649",
               // ...         
            }],
              // ...
       });
            
     

    CHART TITLE
    $("#chartcontainer").ejChart({
            // ...      
            title: {
	           //Add chart title
               text: 'Sales Analysis'			
	        },
           // ....
    });
    
        LINE DATA
       $("#linecontainer").ejChart({

            // ...

           //Initializing Series
           series: [{
               //Adding data points using x and y field of points
               points: [{ x: "John", y: 1000 }, { x: "Jake", y: 1900 }, { x: "Peter", y: 700 },
                        { x: "James", y: 2000 }, { x: "Mary", y: 1700 }]
               // ...
           }]
            // ...

      });
            
            CHART TYPE
            $("#linecontainer").ejChart({
              // ...
            series: [{
                //Change type and color of the series.
                 type: 'line',         
                 fill: "#E94649",
               // ...         
            }],
              // ...
       });
            
     

    CHART TITLE
    $("#linecontainer").ejChart({
            // ...      
            title: {
	           //Add chart title
               text: 'Journal Analysis'			
	        },
           // ....
    });
    
    </script>-->
    
<script>
        

        jQuery(function ($) {
        $('#busiestChart').ejGrid({
            dataSource: shipDetails,
                
		
            columns : [ 
                        { field: "Terminal" },
                        { field: "Count"}
                    
                      ]
         
    });
        
    });



    var shipDetails = [        
        <s:iterator value="busiest">   
            { "ID": '<s:property value="id"/>',
              "Terminal": '<s:property value="terminal"/>',
              "Count": '<s:property value="amount"/>'
             },
        </s:iterator>
    ];  
    $("#busiestChart").ejChart({
                    
          series: [{
                // ... 
         	//Add datasource and set xName and yName 
                dataSource: shipDetails, 

                xName: "Terminal", 
                yName: "Count"		
             }]


             // ...
        });
        
            <!--CHART TYPE-->
            $("#busiestChart").ejChart({
              // ...
            series: [{
                //Change type and color of the series.
                 type: 'column',         
                 fill: "#0000FF",
                 textPosition: 'middle',
                 tooltip: {visible: true,
                 format: "Terminal #point.x# has <br/> #point.y# total transactions",
//                 enableAnimation: true, 
//                 duration: "1000ms",
                 fill: '#FF9933',
                 border: { width: 1, color: "#993300" },
                 
            },
   
            }],
              // ...
       });
       
       $("#busiestChart").ejChart({
            // ...      
//            title: {
//	           //Add chart title
//               text: 'Busiest Terminals'			
//	        },
                isResponsive: True
           // ....
    });
    </script>
    
<script>
        

        jQuery(function ($) {
        $('#unimpactedChart').ejGrid({
            dataSource: shipDetails,
                
		
            columns : [ 
                        { field: "Terminal" },
                        { field: "Count"}
                    
                      ]
         
    });
        
    });



    var shipDetails = [        
        <s:iterator value="unimpacted">   
            { "ID": '<s:property value="id"/>',
              "Terminal": '<s:property value="terminal"/>',
              "Count": '<s:property value="display"/>'
             },
        </s:iterator>
    ];  
    $("#unimpactedChart").ejChart({
                    
          series: [{
                // ... 
         	//Add datasource and set xName and yName 
                dataSource: shipDetails, 

                xName: "Terminal", 
                yName: "Count"		
             }]


             // ...
        });
        
            <!--CHART TYPE-->
            $("#unimpactedChart").ejChart({
              // ...
            series: [{
                //Change type and color of the series.
                 type: 'doughnut', 
                 textPosition: 'middle',
                 tooltip: {visible: true,
                 format: "Terminal #point.x# has <br/> #point.y# unimpacted errors",
                 enableAnimation: true, 
                 duration: "1000ms",
                 fill: '#FF9933',
                 border: { width: 1, color: "#993300" },
//                 zooming:{	
//			   enable: true,
//               toolbarItems: ["reset", "zoomIn", "zoomOut"]
//			},
            },
                 fill: "#E94649",
                 explode: true,
            marker: {
                       dataLabel: {
                       visible: true,
                       shape: 'rectangle',
                       font: {color: "white"}
                       }
                   },       
            }],
              // ...
       });

       $("#unimpactedChart").ejChart({
            // ...      
            title: {
	           //Add chart title
               text: 'Unimpacted error Terminals'			
	        },
                isResponsive: True
           // ....
    });
    
        function animateChart(){

           //Calling the animate method for dynamic animation
           $("#unimpactedChart").ejChart("animate");      
        
      }
    </script>   
    
<script>
        

        jQuery(function ($) {
        $('#dispenseErrorChart').ejGrid({
            dataSource: shipDetails,
                
		
            columns : [ 
                        { field: "Terminal" },
                        { field: "Count"}
                    
                      ]
         
    });
        
    });



    var shipDetails = [        
        <s:iterator value="disperror">   
            { "ID": '<s:property value="id"/>',
              "Terminal": '<s:property value="terminal"/>',
              "Count": '<s:property value="display"/>'
             },
        </s:iterator>
    ];  
    $("#dispenseErrorChart").ejChart({
                    
          series: [{
                // ... 
         	//Add datasource and set xName and yName 
                dataSource: shipDetails, 

                xName: "Terminal", 
                yName: "Count"		
             }]


             // ...
        });
        
            <!--CHART TYPE-->
            $("#dispenseErrorChart").ejChart({
              // ...
            series: [{
                //Change type and color of the series.
                 type: 'pie',         
                 fill: "#E94649",
                 explode: true, 
                 
                  marker: {
                       dataLabel: {
                       visible: true,
                       shape: 'rectangle',
                       font: {color: "white"}
                       }
                    },
                    tooltip: {visible: true,
                    format: "Terminal #point.x# has <br/> #point.y# dispense errors",
                    border: { width: 1, color: "#993300" },
                    enableAnimation: true,
                    animationDuration: "2000",
                },
                        
            }],

              // ...
       });
       
$("#dispenseErrorChart").ejChart({
            // ...             
              legend: {
                //...
                title: {
                   //Add title to the chart legend
	               text: "Terminal IDs",	
		         },
                shape: 'seriesType',
                border: {color: "#FFC342", width: 2},
                
                     },

            // ...             
        });
        
        function animateChart(){

           //Calling the animate method for dynamic animation
           $("#dispenseErrorChart").ejChart("animate");      
        
      }
    </script>  
    
    
<script>
        

        jQuery(function ($) {
        $('#tranTypeChart').ejGrid({
            dataSource: shipDetails,
                
		
            columns : [ 
                        { field: "Terminal" },
                        { field: "Type"}
                    
                      ]
         
    });
        
    });



    var shipDetails = [        
        <s:iterator value="trantype">   
            { "ID": '<s:property value="id"/>',
              "Terminal": '<s:property value="terminalID"/>',
              "Type": '<s:property value="time"/>',
              "Count": '<s:property value="date"/>'
             },
        </s:iterator>
    ];  
    $("#tranTypeChart").ejChart({
                    
          series: [{
                // ... 
         	//Add datasource and set xName and yName 
                dataSource: shipDetails, 

                xName: "Type", 
                yName: "Count"		
             }]


             // ...
        });
        
            <!--CHART TYPE-->
            $("#tranTypeChart").ejChart({
              // ...
            series: [{
                //Change type and color of the series.
                 type: 'Column',  
                 points:[{ fill: 'skyblue' },
                       //  ...         
                ],

                tooltip: {visible: true,
                    format: "Terminal #point.x# has <br/> #point.y# NOT ON US tranx",
                    border: { width: 1, color: "#993300" },
                    enableAnimation: true,
                    animationDuration: "2000",
                },
             }
//                  marker: {
//                       dataLabel: {
//                       visible: true,
//                       shape: 'rectangle',
//                       font: {color: "white"}
//                       }
//                    },
//                    tooltip: {visible: true,
//                    format: "Terminal #point.x# has <br/> #point.y# dispense errors",
//                    border: { width: 1, color: "#993300" },
//                    enableAnimation: true,
//                    animationDuration: "2000",
//                },
                
                        
            ],
//            enable3D: true,
              // ...
       });
       
$("#tranTypeChart").ejChart({
            // ...             
              legend: {
                //...
                title: {
                   //Add title to the chart legend
	               text: "Terminal IDs",	
		         },
                shape: 'seriesType',
                border: {color: "#FFC342", width: 2},
                
                     },

            // ...             
        });
        
        function animateChart(){

           //Calling the animate method for dynamic animation
           $("#tranTypeChart").ejChart("animate");      
        
      }
    </script> 
    
<script type="text/javascript">
//    window.onbeforeunload = function() {
//        return "Dude, are you sure you want to leave?";
//    }
</script>

<script>
        var shipDetails = [        
        <s:iterator value="trantype">   
            { "ID": '<s:property value="id"/>',
              "Terminal": '<s:property value="terminalID"/>',
              "Type": '<s:property value="time"/>',
              "Count": '<s:property value="date"/>'
             },
        </s:iterator>
    ]; 
            angular.module('syncApp', ['ejangular'])
            .controller('Chart', function ($scope) {
                //Assigning data to the dataSource variable in the $scope object.
                $scope.dataSource = shipDetails;
            });
</script>

</html>

