<%-- 
    Document   : atmHome
    Created on : Sep 18, 2017, 1:53:24 PM
    Author     : Taiwo
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title>ATM Reconciliation Tool</title>
        
        <meta name="description" content="overview &amp; stats" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
        
        <!-- bootstrap & fontawesome -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
        <link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />
        
        <!-- page specific plugin styles -->
        
        <!-- text fonts -->
        <link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />
        
        <!-- ace styles -->
        <link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
        <link rel="stylesheet" href="assets/css/ace-skins.min.css" />
        <link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
        <script src="assets/js/ace-extra.min.js"></script>
        
        <!-- animate.css -->
        <link rel="stylesheet" href="assets/animate/animate.css" />
        <link rel="stylesheet" href="assets/animate/set.css" />
        
        <!-- gallery -->
        <link rel="stylesheet" href="assets/gallery/blueimp-gallery.min.css">
        
    </head>
    
    <body class="no-skin">
        <!-- Nav Bar -->
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <!-- End Nav Bar -->
        <div class="main-container ace-save-state" id="main-container">
            
            <!--Sidebar-->
            <%@include file="/WEB-INF/jspf/sidebar.jspf" %>
            <!--End Sidebar-->
            <div class="main-content">
                <div id="page-wrapper">
                    
                    
                    <div id="works"  class=" clearfix grid"> 
                        <figure class="effect-oscar  wowload fadeInUp">
                            <img src="analysis.jpg" alt="img01"/>
                            <figcaption>
                                <h2>Report &nbsp; Portal</h2>
                                <p><br>
                                    <a href="initReport" style=" color: white;">Open</a></p>            
                            </figcaption>
                        </figure>
                        <figure class="effect-oscar  wowload fadeInUp">
                            <img src="big-data.jpg" alt="img01"/>
                            <figcaption>
                                <h2>Journal Viewer</h2>
                                <p><br>
                                    <a href="initJournalViewer" style="color: white;">Open</a></p>            
                            </figcaption>
                        </figure>
                        <figure class="effect-oscar  wowload fadeInUp">
                            <img src="chart.jpg" alt="img01"/>
                            <figcaption>
                                <h2>Journal Download</h2>
                                <p><br>
                                    <a href="initFile" style="color: white;">Open</a></p>            
                            </figcaption>
                        </figure>
                        
                    </div>
                    <hr>
                    
                    <!-- Workflow and Messages -->
                    
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="widget-box transparent" id="recent-box">
                                <div class="widget-header">
                                    
                                    
                                    <div class="widget-toolbar no-border">
                                        <ul class="nav nav-tabs" id="recent-tab">
                                            <li class="active">
                                                <a data-toggle="tab" href="#task-tab">${workflowSize} Tasks</a>
                                            </li>
                                            
                                            <li>
                                                <a data-toggle="tab" href="#member-tab">Users</a>
                                            </li>
                                            
                                        </ul>
                                    </div>
                                </div>
                                
                                <div class="widget-body">
                                    <div class="widget-main padding-4">
                                        <div class="tab-content padding-8">
                                            <div id="task-tab" class="tab-pane active">
                                                <h4 class="smaller lighter green">
                                                    <i class="ace-icon fa fa-list"></i>
                                                    Workflow Items
                                                </h4>
                                                
                                                <ul id="tasks" class="item-list">
                                                    <s:iterator value="workflows">
                                                    <li class="item-default clearfix">
                                                        <label class="inline">
                                                            <input type="checkbox" class="ace" />
                                                            <a href="viewWorkflow?editMode=V&workflow.id=<s:property value='id'/>">
                                                            <span class="lbl"><s:property value="nextActivity"/></span>
                                                            </a>
                                                        </label>
                                                        
                                                        <div class="pull-right pos-rel dropdown-hover">
                                                            <button class="btn btn-minier bigger btn-primary">
                                                                <i class="ace-icon fa fa-cog icon-only bigger-120"></i>
                                                            </button>
                                                            
                                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-caret dropdown-close dropdown-menu-right">
                                                                <li>
                                                                    <a href="#" class="tooltip-success" data-rel="tooltip" title="Mark&nbsp;as&nbsp;done">
                                                                        <span class="green">
                                                                            <i class="ace-icon fa fa-check bigger-110"></i>
                                                                        </span>
                                                                    </a>
                                                                </li>
                                                                
                                                                <li>
                                                                    <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
                                                                        <span class="red">
                                                                            <i class="ace-icon fa fa-trash-o bigger-110"></i>
                                                                        </span>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </li>
                                                    </s:iterator>
                                                </ul>
                                            </div>
                                            
                                            <div id="member-tab" class="tab-pane">
                                                <div class="clearfix">
                                                    <div class="itemdiv memberdiv">
                                                        <div class="user">
                                                            <img alt="Bob Doe's avatar" src="assets/images/avatars/user.jpg" />
                                                        </div>
                                                        
                                                        <div class="body">
                                                            <div class="name">
                                                                <a href="#">Bob Doe</a>
                                                            </div>
                                                            
                                                            <div class="time">
                                                                <i class="ace-icon fa fa-clock-o"></i>
                                                                <span class="green">20 min</span>
                                                            </div>
                                                            
                                                            <div>
                                                                <span class="label label-warning label-sm">pending</span>
                                                                
                                                                <div class="inline position-relative">
                                                                    <button class="btn btn-minier btn-yellow btn-no-border dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                        <i class="ace-icon fa fa-angle-down icon-only bigger-120"></i>
                                                                    </button>
                                                                    
                                                                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                        <li>
                                                                            <a href="#" class="tooltip-success" data-rel="tooltip" title="Approve">
                                                                                <span class="green">
                                                                                    <i class="ace-icon fa fa-check bigger-110"></i>
                                                                                </span>
                                                                            </a>
                                                                        </li>
                                                                        
                                                                        <li>
                                                                            <a href="#" class="tooltip-warning" data-rel="tooltip" title="Reject">
                                                                                <span class="orange">
                                                                                    <i class="ace-icon fa fa-times bigger-110"></i>
                                                                                </span>
                                                                            </a>
                                                                        </li>
                                                                        
                                                                        <li>
                                                                            <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
                                                                                <span class="red">
                                                                                    <i class="ace-icon fa fa-trash-o bigger-110"></i>
                                                                                </span>
                                                                            </a>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="itemdiv memberdiv">
                                                        <div class="user">
                                                            <img alt="Joe Doe's avatar" src="assets/images/avatars/avatar2.png" />
                                                        </div>
                                                        
                                                        <div class="body">
                                                            <div class="name">
                                                                <a href="#">Joe Doe</a>
                                                            </div>
                                                            
                                                            <div class="time">
                                                                <i class="ace-icon fa fa-clock-o"></i>
                                                                <span class="green">1 hour</span>
                                                            </div>
                                                            
                                                            <div>
                                                                <span class="label label-warning label-sm">pending</span>
                                                                
                                                                <div class="inline position-relative">
                                                                    <button class="btn btn-minier btn-yellow btn-no-border dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                        <i class="ace-icon fa fa-angle-down icon-only bigger-120"></i>
                                                                    </button>
                                                                    
                                                                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                        <li>
                                                                            <a href="#" class="tooltip-success" data-rel="tooltip" title="Approve">
                                                                                <span class="green">
                                                                                    <i class="ace-icon fa fa-check bigger-110"></i>
                                                                                </span>
                                                                            </a>
                                                                        </li>
                                                                        
                                                                        <li>
                                                                            <a href="#" class="tooltip-warning" data-rel="tooltip" title="Reject">
                                                                                <span class="orange">
                                                                                    <i class="ace-icon fa fa-times bigger-110"></i>
                                                                                </span>
                                                                            </a>
                                                                        </li>
                                                                        
                                                                        <li>
                                                                            <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
                                                                                <span class="red">
                                                                                    <i class="ace-icon fa fa-trash-o bigger-110"></i>
                                                                                </span>
                                                                            </a>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="itemdiv memberdiv">
                                                        <div class="user">
                                                            <img alt="Jim Doe's avatar" src="assets/images/avatars/avatar.png" />
                                                        </div>
                                                        
                                                        <div class="body">
                                                            <div class="name">
                                                                <a href="#">Jim Doe</a>
                                                            </div>
                                                            
                                                            <div class="time">
                                                                <i class="ace-icon fa fa-clock-o"></i>
                                                                <span class="green">2 hour</span>
                                                            </div>
                                                            
                                                            <div>
                                                                <span class="label label-warning label-sm">pending</span>
                                                                
                                                                <div class="inline position-relative">
                                                                    <button class="btn btn-minier btn-yellow btn-no-border dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                        <i class="ace-icon fa fa-angle-down icon-only bigger-120"></i>
                                                                    </button>
                                                                    
                                                                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                        <li>
                                                                            <a href="#" class="tooltip-success" data-rel="tooltip" title="Approve">
                                                                                <span class="green">
                                                                                    <i class="ace-icon fa fa-check bigger-110"></i>
                                                                                </span>
                                                                            </a>
                                                                        </li>
                                                                        
                                                                        <li>
                                                                            <a href="#" class="tooltip-warning" data-rel="tooltip" title="Reject">
                                                                                <span class="orange">
                                                                                    <i class="ace-icon fa fa-times bigger-110"></i>
                                                                                </span>
                                                                            </a>
                                                                        </li>
                                                                        
                                                                        <li>
                                                                            <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
                                                                                <span class="red">
                                                                                    <i class="ace-icon fa fa-trash-o bigger-110"></i>
                                                                                </span>
                                                                            </a>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="itemdiv memberdiv">
                                                        <div class="user">
                                                            <img alt="Alex Doe's avatar" src="assets/images/avatars/avatar5.png" />
                                                        </div>
                                                        
                                                        <div class="body">
                                                            <div class="name">
                                                                <a href="#">Alex Doe</a>
                                                            </div>
                                                            
                                                            <div class="time">
                                                                <i class="ace-icon fa fa-clock-o"></i>
                                                                <span class="green">3 hour</span>
                                                            </div>
                                                            
                                                            <div>
                                                                <span class="label label-danger label-sm">blocked</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="itemdiv memberdiv">
                                                        <div class="user">
                                                            <img alt="Bob Doe's avatar" src="assets/images/avatars/avatar2.png" />
                                                        </div>
                                                        
                                                        <div class="body">
                                                            <div class="name">
                                                                <a href="#">Bob Doe</a>
                                                            </div>
                                                            
                                                            <div class="time">
                                                                <i class="ace-icon fa fa-clock-o"></i>
                                                                <span class="green">6 hour</span>
                                                            </div>
                                                            
                                                            <div>
                                                                <span class="label label-success label-sm arrowed-in">approved</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="itemdiv memberdiv">
                                                        <div class="user">
                                                            <img alt="Susan's avatar" src="assets/images/avatars/avatar3.png" />
                                                        </div>
                                                        
                                                        <div class="body">
                                                            <div class="name">
                                                                <a href="#">Susan</a>
                                                            </div>
                                                            
                                                            <div class="time">
                                                                <i class="ace-icon fa fa-clock-o"></i>
                                                                <span class="green">yesterday</span>
                                                            </div>
                                                            
                                                            <div>
                                                                <span class="label label-success label-sm arrowed-in">approved</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="itemdiv memberdiv">
                                                        <div class="user">
                                                            <img alt="Phil Doe's avatar" src="assets/images/avatars/avatar4.png" />
                                                        </div>
                                                        
                                                        <div class="body">
                                                            <div class="name">
                                                                <a href="#">Phil Doe</a>
                                                            </div>
                                                            
                                                            <div class="time">
                                                                <i class="ace-icon fa fa-clock-o"></i>
                                                                <span class="green">2 days ago</span>
                                                            </div>
                                                            
                                                            <div>
                                                                <span class="label label-info label-sm arrowed-in arrowed-in-right">online</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="itemdiv memberdiv">
                                                        <div class="user">
                                                            <img alt="Alexa Doe's avatar" src="assets/images/avatars/avatar1.png" />
                                                        </div>
                                                        
                                                        <div class="body">
                                                            <div class="name">
                                                                <a href="#">Alexa Doe</a>
                                                            </div>
                                                            
                                                            <div class="time">
                                                                <i class="ace-icon fa fa-clock-o"></i>
                                                                <span class="green">3 days ago</span>
                                                            </div>
                                                            
                                                            <div>
                                                                <span class="label label-success label-sm arrowed-in">approved</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                
                                                <div class="space-4"></div>
                                                
                                                <div class="center">
                                                    <i class="ace-icon fa fa-users fa-2x green middle"></i>
                                                    
                                                    &nbsp;
                                                    <a href="#" class="btn btn-sm btn-white btn-info">
                                                        See all members &nbsp;
                                                        <i class="ace-icon fa fa-arrow-right"></i>
                                                    </a>
                                                </div>
                                                
                                                <div class="hr hr-double hr8"></div>
                                            </div><!-- /.#member-tab -->
                                            
                                        </div>
                                    </div><!-- /.widget-main -->
                                </div><!-- /.widget-body -->
                            </div><!-- /.widget-box -->
                        </div><!-- /.col -->
                        
                        <div class="col-sm-6">
                            <div class="widget-box">
                                <div class="widget-header">
                                    <h4 class="widget-title lighter smaller">
                                        <i class="ace-icon fa fa-comment blue"></i>
                                        ${messageSize} Messages
                                    </h4>
                                </div>
                                
                                <div class="widget-body">
                                    <div class="widget-main no-padding">
                                        <div class="dialogs">
                                            <s:iterator value="messages">
                                            <div class="itemdiv dialogdiv">
                                                <div class="user">
                                                    <img alt="Alexa's Avatar" src="assets/images/avatars/avatar1.png" />
                                                </div>
                                                
                                                <div class="body">
                                                    <div class="time">
                                                        <i class="ace-icon fa fa-clock-o"></i>
                                                        <span class="green">4 sec</span>
                                                    </div>
                                                    
                                                    <div class="name">
                                                        <a href="#"><s:property value="fromUserId"/></a>
                                                    </div>
                                                    <a href="viewMessage?editMode=V&message.id=<s:property value='id'/>" class="clearfix">
                                                    <div class="text"><s:property value="message"/></div>
                                                    </a>
                                                    <div class="tools">
                                                        <a href="#" class="btn btn-minier btn-info">
                                                            <i class="icon-only ace-icon fa fa-share"></i>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                            </s:iterator>
                                        </div>
                                        
                                        <form>
                                            <div class="form-actions">
                                                <div class="input-group">
                                                    <input placeholder="Type your message here ..." type="text" class="form-control" name="message" />
                                                    <span class="input-group-btn">
                                                        <button class="btn btn-sm btn-info no-radius" type="button">
                                                            <i class="ace-icon fa fa-share"></i>
                                                            Send
                                                        </button>
                                                    </span>
                                                </div>
                                            </div>
                                        </form>
                                    </div><!-- /.widget-main -->
                                </div><!-- /.widget-body -->
                            </div><!-- /.widget-box -->
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                    
                    
                </div><!-- /.page-wrapper -->
                
            </div><!-- /.main-content -->
            
            <!--Footer-->
            <%@include file="/WEB-INF/jspf/footer.jspf" %>
            <!--End Footer-->
            
            <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
                <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
            </a>
        </div><!-- /.main-container -->
        
        <!-- basic scripts -->
        <!-- gallery -->
        <script src="assets/gallery/jquery.blueimp-gallery.min.js"></script>
        
        
        
        
        <!-- custom script -->
        <script src="assets/script.js"></script>
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
        
        <!--[if lte IE 8]>
          <script src="assets/js/excanvas.min.js"></script>
        <![endif]-->
        <script src="assets/js/jquery-ui.custom.min.js"></script>
        <script src="assets/js/jquery.ui.touch-punch.min.js"></script>
        <script src="assets/js/jquery.easypiechart.min.js"></script>
        <script src="assets/js/jquery.sparkline.index.min.js"></script>
        <script src="assets/js/jquery.flot.min.js"></script>
        <script src="assets/js/jquery.flot.pie.min.js"></script>
        <script src="assets/js/jquery.flot.resize.min.js"></script>
        
        <!-- ace scripts -->
        <script src="assets/js/ace-elements.min.js"></script>
        <script src="assets/js/ace.min.js"></script>
        
        <!-- inline scripts related to this page -->
        <script type="text/javascript">
            jQuery(function($) {
                $('.easy-pie-chart.percentage').each(function(){
                    var $box = $(this).closest('.infobox');
                    var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
                    var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
                    var size = parseInt($(this).data('size')) || 50;
                    $(this).easyPieChart({
                        barColor: barColor,
                        trackColor: trackColor,
                        scaleColor: false,
                        lineCap: 'butt',
                        lineWidth: parseInt(size/10),
                        animate: ace.vars['old_ie'] ? false : 1000,
                        size: size
                    });
                })
			
                $('.sparkline').each(function(){
                    var $box = $(this).closest('.infobox');
                    var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
                    $(this).sparkline('html',
                    {
                        tagValuesAttribute:'data-values',
                        type: 'bar',
                        barColor: barColor ,
                        chartRangeMin:$(this).data('min') || 0
                    });
                });
			
			
                //flot chart resize plugin, somehow manipulates default browser resize event to optimize it!
                //but sometimes it brings up errors with normal resize event handlers
                $.resize.throttleWindow = false;
			
                var placeholder = $('#piechart-placeholder').css({'width':'90%' , 'min-height':'150px'});
                var data = [
                    { label: "social networks",  data: 38.7, color: "#68BC31"},
                    { label: "search engines",  data: 24.5, color: "#2091CF"},
                    { label: "ad campaigns",  data: 8.2, color: "#AF4E96"},
                    { label: "direct traffic",  data: 18.6, color: "#DA5430"},
                    { label: "other",  data: 10, color: "#FEE074"}
                ]
                function drawPieChart(placeholder, data, position) {
                    $.plot(placeholder, data, {
                        series: {
                            pie: {
                                show: true,
                                tilt:0.8,
                                highlight: {
                                    opacity: 0.25
                                },
                                stroke: {
                                    color: '#fff',
                                    width: 2
                                },
                                startAngle: 2
                            }
                        },
                        legend: {
                            show: true,
                            position: position || "ne", 
                            labelBoxBorderColor: null,
                            margin:[-30,15]
                        }
                        ,
                        grid: {
                            hoverable: true,
                            clickable: true
                        }
                    })
                }
                drawPieChart(placeholder, data);
			
                /**
                 we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
                 so that's not needed actually.
                 */
                placeholder.data('chart', data);
                placeholder.data('draw', drawPieChart);
			
			
                //pie chart tooltip example
                var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
                var previousPoint = null;
			
                placeholder.on('plothover', function (event, pos, item) {
                    if(item) {
                        if (previousPoint != item.seriesIndex) {
                            previousPoint = item.seriesIndex;
                            var tip = item.series['label'] + " : " + item.series['percent']+'%';
                            $tooltip.show().children(0).text(tip);
                        }
                        $tooltip.css({top:pos.pageY + 10, left:pos.pageX + 10});
                    } else {
                        $tooltip.hide();
                        previousPoint = null;
                    }
				
                });
			
                /////////////////////////////////////
                $(document).one('ajaxloadstart.page', function(e) {
                    $tooltip.remove();
                });
			
			
			
			
                var d1 = [];
                for (var i = 0; i < Math.PI * 2; i += 0.5) {
                    d1.push([i, Math.sin(i)]);
                }
			
                var d2 = [];
                for (var i = 0; i < Math.PI * 2; i += 0.5) {
                    d2.push([i, Math.cos(i)]);
                }
			
                var d3 = [];
                for (var i = 0; i < Math.PI * 2; i += 0.2) {
                    d3.push([i, Math.tan(i)]);
                }
				
			
                var sales_charts = $('#sales-charts').css({'width':'100%' , 'height':'220px'});
                $.plot("#sales-charts", [
                    { label: "Domains", data: d1 },
                    { label: "Hosting", data: d2 },
                    { label: "Services", data: d3 }
                ], {
                    hoverable: true,
                    shadowSize: 0,
                    series: {
                        lines: { show: true },
                        points: { show: true }
                    },
                    xaxis: {
                        tickLength: 0
                    },
                    yaxis: {
                        ticks: 10,
                        min: -2,
                        max: 2,
                        tickDecimals: 3
                    },
                    grid: {
                        backgroundColor: { colors: [ "#fff", "#fff" ] },
                        borderWidth: 1,
                        borderColor:'#555'
                    }
                });
			
			
                $('#recent-box [data-rel="tooltip"]').tooltip({placement: tooltip_placement});
                function tooltip_placement(context, source) {
                    var $source = $(source);
                    var $parent = $source.closest('.tab-content')
                    var off1 = $parent.offset();
                    var w1 = $parent.width();
			
                    var off2 = $source.offset();
                    //var w2 = $source.width();
			
                    if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
                    return 'left';
                }
			
			
                $('.dialogs,.comments').ace_scroll({
                    size: 300
                });
				
				
                //Android's default browser somehow is confused when tapping on label which will lead to dragging the task
                //so disable dragging when clicking on label
                var agent = navigator.userAgent.toLowerCase();
                if(ace.vars['touch'] && ace.vars['android']) {
                    $('#tasks').on('touchstart', function(e){
                        var li = $(e.target).closest('#tasks li');
                        if(li.length == 0)return;
                        var label = li.find('label.inline').get(0);
                        if(label == e.target || $.contains(label, e.target)) e.stopImmediatePropagation() ;
                    });
                }
			
                $('#tasks').sortable({
                    opacity:0.8,
                    revert:true,
                    forceHelperSize:true,
                    placeholder: 'draggable-placeholder',
                    forcePlaceholderSize:true,
                    tolerance:'pointer',
                    stop: function( event, ui ) {
                        //just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
                        $(ui.item).css('z-index', 'auto');
                    }
                }
                        );
                $('#tasks').disableSelection();
                $('#tasks input:checkbox').removeAttr('checked').on('click', function(){
                    if(this.checked) $(this).closest('li').addClass('selected');
                    else $(this).closest('li').removeClass('selected');
                });
			
			
                //show the dropdowns on top or bottom depending on window height and menu position
                $('#task-tab .dropdown-hover').on('mouseenter', function(e) {
                    var offset = $(this).offset();
			
                    var $w = $(window)
                    if (offset.top > $w.scrollTop() + $w.innerHeight() - 100) 
                        $(this).addClass('dropup');
                    else $(this).removeClass('dropup');
                });
			
            })
        </script>
    </body>
</html>
