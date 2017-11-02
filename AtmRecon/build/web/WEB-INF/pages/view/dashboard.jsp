
<!DOCTYPE html>
<html lang="en">
	<head>
        <link 
        href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" 
        rel="stylesheet"  type='text/css'>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>ATM Reconciliation Tool</title>

		<meta name="description" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->

		<!-- text fonts -->
		<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="assets/js/ace-extra.min.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body class="no-skin">
             
             <%@include file="/WEB-INF/jspf/header.jspf" %>
            <!-- End Nav Bar -->
		<div class="main-container ace-save-state" id="main-container">
<!--			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>-->
                        <!--Sidebar-->
                        <%@include file="/WEB-INF/jspf/sidebar.jspf" %>
                        <!--End Sidebar-->

			

			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="initHome">Home</a>
							</li>

							<li>
								<a href="#">Other Pages</a>
							</li>
							<li class="active">Blank Page</li>
						</ul><!-- /.breadcrumb -->

						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
							</form>
						</div><!-- /.nav-search -->
					</div>

					<div class="page-content">
						<div class="ace-settings-container" id="ace-settings-container">
							<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
								<i class="ace-icon fa fa-cog bigger-130"></i>
							</div>

							<div class="ace-settings-box clearfix" id="ace-settings-box">
								<div class="pull-left width-50">
									<div class="ace-settings-item">
										<div class="pull-left">
											<select id="skin-colorpicker" class="hide">
												<option data-skin="no-skin" value="#438EB9">#438EB9</option>
												<option data-skin="skin-1" value="#222A2D">#222A2D</option>
												<option data-skin="skin-2" value="#C6487E">#C6487E</option>
												<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
											</select>
										</div>
										<span>&nbsp; Choose Skin</span>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-navbar" autocomplete="off" />
										<label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-sidebar" autocomplete="off" />
										<label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-breadcrumbs" autocomplete="off" />
										<label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" autocomplete="off" />
										<label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-add-container" autocomplete="off" />
										<label class="lbl" for="ace-settings-add-container">
											Inside
											<b>.container</b>
										</label>
									</div>
								</div><!-- /.pull-left -->

								<div class="pull-left width-50">
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" autocomplete="off" />
										<label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" autocomplete="off" />
										<label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" autocomplete="off" />
										<label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
									</div>
								</div><!-- /.pull-left -->
							</div><!-- /.ace-settings-box -->
						</div><!-- /.ace-settings-container -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
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
                </div>
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Ace</span>
							Application &copy; 2013-2014
						</span>

						&nbsp; &nbsp;
						<span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>
					</div>
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="assets/js/jquery-2.1.4.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="assets/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->

		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
	</body>
        
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
