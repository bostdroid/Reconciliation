<%-- 
    Document   : report
    Created on : Sep 20, 2017, 12:02:00 PM
    Author     : bost
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>ATM Reconciliation Tool</title>

		<meta name="description" content="Static &amp; Dynamic Tables" />
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
        <%
        String tableTitle= "Dispense Error Report";
        %>
	<body class="no-skin">
          

			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="initHome">Home</a>
							</li>                                   
							<li class="active">Report Viewer</li>
						</ul><!-- /.breadcrumb -->

						

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

						<div class="page-header">
							
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								

								<div class="row">
									<div class="col-xs-12">
										

										<div class="clearfix">
											<div class="pull-right tableTools-container"></div>
										</div>
										<s:form id="myForm" method="post" action="findReportsByCriteria">     
                    <div class="form-group"> 
                        <div class="col-sm-11" >
                            
                            <div class="col-xs-3" > 
                                <span style="font-family: calibri; font-size: 12px;
                                      font-weight: bolder; color:#0059b3;"> 
                                   Transaction Start Date:</span><input type="text" name="report.startDate" required="required" id="startDatePicker"
                                                                     style="font-family: calibri; font-size: 15px;"/>
                            </div>
                            <div class="col-xs-3" > 
                                <span style="font-family: calibri; font-size: 12px;
                                      font-weight: bolder; color:#0059b3;"> 
                                    Transaction  End Date:</span><input type="text" name="report.endDate" required="required" id="endDatePicker"
                                                                     style="font-family: calibri; font-size: 15px;"/>
                            </div>        

                            
                            <div class="col-xs-3" > 
                                <span style="font-family: calibri; font-size: 12px;
                                      font-weight: bolder; color:#0059b3;"> 
                                    Terminals:</span><br>
                                <input type="text" name="report.terminal" id="terminalID" required="required" title="Enter a terminal ID or enter the word 'ALL'" 
                                                                     style="font-family: calibri; font-size: 15px; height: 30px;"/>
                                 
                            </div>
<!--
                            <div class="col-xs-3" >
                                <span style="font-family: calibri; font-size: 12px;
                                      font-weight: bolder; color:#0059b3;"> 
                                    Report Title</span>
                                <input type="text" name="tabletitle" class="minput"  data-toggle="tooltip" data-placement="left" title="Report Title" 
                                       style="font-family: calibri; font-size: 11px; " placeholder="Enter Your Report Title Here"    required="required"  value="<%= tableTitle%>">


                            </div>-->



                        <div class="col-sm-3" >
                            <button type="submit" onclick="doSubmit()" class="btn btn-primary btn-sm" style="font-family: Calibri; 
                                            font-weight: bolder;  font-size: 11px;"><a href="javascript:doSearch();">Search</a></button> 
                        </div> 




                                    
<!--                                        <table class="table">
                                            <tr>
                                                <td>Transaction Start Date</td>
                                                <td><input type="text" name="report.startDate" required="required" id="startDatePicker"
                                                                     style="font-family: calibri; font-size: 11px;"/></td>
                                            </tr>
                                            <tr>
                                                <td>Transaction End Date</td>
                                                <td><input type="text" name="report.endDate" required="required" id="endDatePicker"
                                                                     style="font-family: calibri; font-size: 11px;"/></td>
                                            </tr>
                                            <tr>
                                                <td>Terminals</td>
                                                <td><input type="text" name="report.terminal" id="terminalID" required="required"
                                                                     style="font-family: calibri; font-size: 11px;"/></td>
                                            </tr>
                                            <tr>
                                                <td colspan="2" rowspan="2">Report Title</td>
                                                <td><input type="label" name="tabletitle" class="minput"  data-toggle="tooltip" data-placement="left" title="Report Title" 
                                       style="font-family: calibri; font-size: 11px; " placeholder="Dispense Error Report" readonly="true" value="<%= tableTitle%>"></td>
                                            </tr>
                                            <tr>
                                                <td colspan="2"><button type="submit" onclick="doSubmit()" class="btn btn-primary btn-sm" style="font-family: Calibri; 
                                            font-weight: bolder;  font-size: 11px;"><a href="javascript:doSearch();">Search</a></button></td>
                                            </tr>  
                                 
                                        </table>-->
                                        
                    </div>
                                    </div>
                </s:form>
<div> <span style="color: red">${verify}</span></div>
										<!-- div.table-responsive -->
                                                                                
										<!-- div.dataTables_borderWrap -->
										<div>
                                                                                    <table id="user-table" class="table table-striped table-bordered table-hover">
                                                                                        <thead>
                                                                                            <tr>
                                                                                                <th class="center">
                                                                                                    <label class="pos-rel">
                                                                                                        <input type="checkbox" class="ace" /><span class="lbl"></span>
                                                                                                    </label>
                                                                                                </th>
                                                                                               
                                                                                                <th>Terminal</th>
                                                                                                <th>Source</th>
                                                                                                <th>Display</th>
                                                                                                <th>Card Number</th>
                                                                                                <th>STAN</th>
                                                                                                <th>Amount</th>
                                                                                                <th>RRN</th>
                                                                                                <th>Status</th>
                                                                                                <th>Date</th>
                                                                                                <th>Time</th>
                                                                                                
                                                                                            </tr>
                                                                                        </thead>
                                                                                        <tbody>
                                                                                            <s:iterator value="reports">                      
                                                                                                <tr>
                                                                                                    <td class="center">
                                                                                                        <label class="pos-rel"><input type="checkbox" class="ace" /><span class="lbl"></span></label>
                                                                                                    </td>
                                                                                                    
                                                                                                    
                                                                                                    <td class="hidden-480">
                                                                                                    <s:property value="terminal"/>
                                                                                                    </td>
                                                                                                   
                                                                                                    <td class="hidden-480">
                                                                                                        <s:property value="source"/>
                                                                                                    </td>
                                                                                                    
                                                                                                    <td class="hidden-480">
                                                                                                        <s:property value="display"/>
                                                                                                    </td>
                                                                                                    <td class="hidden-480">
                                                                                                        <s:property value="cardNumber"/>
                                                                                                    </td>
                                                                                                    <td class="hidden-480">
                                                                                                        <s:property value="stan"/>
                                                                                                    </td>
                                                                                                    <td class="hidden-480">
                                                                                                        <s:property value="amount"/>
                                                                                                    </td>
                                                                                                    <td class="hidden-480">
                                                                                                        <s:property value="rrn"/>
                                                                                                    </td>
                                                                                                    <td class="hidden-480">
                                                                                                        <s:property value="status"/>
                                                                                                    </td>
                                                                                                    <td class="hidden-480">
                                                                                                        <s:property value="startDate"/>
                                                                                                    </td>
                                                                                                    <td class="hidden-480">
                                                                                                        <s:property value="time"/>
                                                                                                    </td>
                                                                                                    
                                                                                                </tr>
                                                                                            </s:iterator>
                                                                                        </tbody>
                                                                                    </table>
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
		<script src="assets/js/jquery.dataTables.min.js"></script>
		<script src="assets/js/jquery.dataTables.bootstrap.min.js"></script>
		<script src="assets/js/dataTables.buttons.min.js"></script>
		<script src="assets/js/buttons.flash.min.js"></script>
		<script src="assets/js/buttons.html5.min.js"></script>
		<script src="assets/js/buttons.print.min.js"></script>
		<script src="assets/js/buttons.colVis.min.js"></script>
		<script src="assets/js/dataTables.select.min.js"></script>

		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
				//initiate dataTables plugin
				var myTable = 
				$('#user-table')
				//.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
				.DataTable( {
					bAutoWidth: false,
					"aoColumns": [
					  { "bSortable": false },
					  null, null,null, null, null,
					  { "bSortable": false }
					],
					"aaSorting": [],
					
					
					//"bProcessing": true,
			        //"bServerSide": true,
			        //"sAjaxSource": "http://127.0.0.1/table.php"	,
			
					//,
					//"sScrollY": "200px",
					//"bPaginate": false,
			
					//"sScrollX": "100%",
					//"sScrollXInner": "120%",
					//"bScrollCollapse": true,
					//Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
					//you may want to wrap the table inside a "div.dataTables_borderWrap" element
			
					//"iDisplayLength": 50
			
			
					select: {
						style: 'multi'
					}
			    } );
			
				
				
				$.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';
				
				new $.fn.dataTable.Buttons( myTable, {
					buttons: [
					  {
						"extend": "colvis",
						"text": "<i class='fa fa-search bigger-110 blue'></i> <span class='hidden'>Show/hide columns</span>",
						"className": "btn btn-white btn-primary btn-bold",
						columns: ':not(:first):not(:last)'
					  },
					  {
						"extend": "copy",
						"text": "<i class='fa fa-copy bigger-110 pink'></i> <span class='hidden'>Copy to clipboard</span>",
						"className": "btn btn-white btn-primary btn-bold"
					  },
					  {
						"extend": "csv",
						"text": "<i class='fa fa-database bigger-110 orange'></i> <span class='hidden'>Export to CSV</span>",
						"className": "btn btn-white btn-primary btn-bold"
					  },
					  {
						"extend": "excel",
						"text": "<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='hidden'>Export to Excel</span>",
						"className": "btn btn-white btn-primary btn-bold"
					  },
					  {
						"extend": "pdf",
						"text": "<i class='fa fa-file-pdf-o bigger-110 red'></i> <span class='hidden'>Export to PDF</span>",
						"className": "btn btn-white btn-primary btn-bold"
					  },
					  {
						"extend": "print",
						"text": "<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>Print</span>",
						"className": "btn btn-white btn-primary btn-bold",
						autoPrint: false,
						message: 'This print was produced using the Print button for DataTables'
					  }		  
					]
				} );
				myTable.buttons().container().appendTo( $('.tableTools-container') );
				
				//style the message box
				var defaultCopyAction = myTable.button(1).action();
				myTable.button(1).action(function (e, dt, button, config) {
					defaultCopyAction(e, dt, button, config);
					$('.dt-button-info').addClass('gritter-item-wrapper gritter-info gritter-center white');
				});
				
				
				var defaultColvisAction = myTable.button(0).action();
				myTable.button(0).action(function (e, dt, button, config) {
					
					defaultColvisAction(e, dt, button, config);
					
					
					if($('.dt-button-collection > .dropdown-menu').length == 0) {
						$('.dt-button-collection')
						.wrapInner('<ul class="dropdown-menu dropdown-light dropdown-caret dropdown-caret" />')
						.find('a').attr('href', '#').wrap("<li />")
					}
					$('.dt-button-collection').appendTo('.tableTools-container .dt-buttons')
				});
			
				////
			
				setTimeout(function() {
					$($('.tableTools-container')).find('a.dt-button').each(function() {
						var div = $(this).find(' > div').first();
						if(div.length == 1) div.tooltip({container: 'body', title: div.parent().text()});
						else $(this).tooltip({container: 'body', title: $(this).text()});
					});
				}, 500);
				
				
				
				
				
				myTable.on( 'select', function ( e, dt, type, index ) {
					if ( type === 'row' ) {
						$( myTable.row( index ).node() ).find('input:checkbox').prop('checked', true);
					}
				} );
				myTable.on( 'deselect', function ( e, dt, type, index ) {
					if ( type === 'row' ) {
						$( myTable.row( index ).node() ).find('input:checkbox').prop('checked', false);
					}
				} );
			
			
			
			
				/////////////////////////////////
				//table checkboxes
				$('th input[type=checkbox], td input[type=checkbox]').prop('checked', false);
				
				//select/deselect all rows according to table header checkbox
				$('#user-table > thead > tr > th input[type=checkbox], #user-table_wrapper input[type=checkbox]').eq(0).on('click', function(){
					var th_checked = this.checked;//checkbox inside "TH" table header
					
					$('#user-table').find('tbody > tr').each(function(){
						var row = this;
						if(th_checked) myTable.row(row).select();
						else  myTable.row(row).deselect();
					});
				});
				
				//select/deselect a row when the checkbox is checked/unchecked
				$('#user-table').on('click', 'td input[type=checkbox]' , function(){
					var row = $(this).closest('tr').get(0);
					if(this.checked) myTable.row(row).deselect();
					else myTable.row(row).select();
				});
			
			
			
				$(document).on('click', '#user-table .dropdown-toggle', function(e) {
					e.stopImmediatePropagation();
					e.stopPropagation();
					e.preventDefault();
				});
				
				
				
				//And for the first simple table, which doesn't have TableTools or dataTables
				//select/deselect all rows according to table header checkbox
				var active_class = 'active';
				$('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function(){
					var th_checked = this.checked;//checkbox inside "TH" table header
					
					$(this).closest('table').find('tbody > tr').each(function(){
						var row = this;
						if(th_checked) $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
						else $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
					});
				});
				
				//select/deselect a row when the checkbox is checked/unchecked
				$('#simple-table').on('click', 'td input[type=checkbox]' , function(){
					var $row = $(this).closest('tr');
					if($row.is('.detail-row ')) return;
					if(this.checked) $row.addClass(active_class);
					else $row.removeClass(active_class);
				});
			
				
			
				/********************************/
				//add tooltip for small view action buttons in dropdown menu
				$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				
				//tooltip placement on right or left
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('table')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					//var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
	
				/***************/
				$('.show-details-btn').on('click', function(e) {
					e.preventDefault();
					$(this).closest('tr').next().toggleClass('open');
					$(this).find(ace.vars['.icon']).toggleClass('fa-angle-double-down').toggleClass('fa-angle-double-up');
				});
				/***************/
				
				
				
				
				
				/**
				//add horizontal scrollbars to a simple table
				$('#simple-table').css({'width':'2000px', 'max-width': 'none'}).wrap('<div style="width: 1000px;" />').parent().ace_scroll(
				  {
					horizontal: true,
					styleClass: 'scroll-top scroll-dark scroll-visible',//show the scrollbars on top(default is bottom)
					size: 2000,
					mouseWheelLock: true
				  }
				).css('padding-top', '12px');
				*/
			
			
			})
		</script>
                
<script type="text/javascript" class="init">


    function doSearch(){
        if (document.getElementById('startDatePicker').value == "" || document.getElementById('endDatePicker').value == "" || document.getElementById('terminalID').value==""){
            alert("Please specify the journal date or the terminal."); 
        }
        else if (document.getElementById('startDatePicker').value != "" &&document.getElementById('endDatePicker').value != "" && document.getElementById('terminalID').value=="ALL") {
           document.getElementById('myForm').action="findReportsByDate";
           document.getElementById('myForm').submit();
        }
        else
        {
            document.getElementById('myForm').submit();
//            alert("Please specify the journal date or the terminal.");
        }
        
    }
    function doBack(){
        window.location = "rp";
    }
    
    
</script>

    <script type="text/javascript">
        $(function () {
            // declaration of ejDatePicker
            $("#startDatePicker").ejDatePicker({

                dateFormat: "yyyy-MM-dd"
        });

            
        });
        
    </script>


    <script type="text/javascript">
        
                $(function () {
            // declaration of ejDatePicker
            $("#endDatePicker").ejDatePicker({

                dateFormat: "yyyy-MM-dd"
        });

            
        });
        
        
    </script>
               
                
        </body>
</html>
