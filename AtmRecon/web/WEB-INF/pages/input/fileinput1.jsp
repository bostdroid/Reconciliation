<%-- 
    Document   : fileinput
    Created on : Oct 6, 2017, 1:54:52 PM
    Author     : TechDev
--%>

<%-- 
    Document   : roleinput
    Created on : Oct 3, 2017, 9:47:18 AM
    Author     : TechDev
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>ATM Reconciliation Tool</title>

		<meta name="description" content="Common form elements and layouts" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="assets/css/chosen.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-datepicker3.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-timepicker.min.css" />
		<link rel="stylesheet" href="assets/css/daterangepicker.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-colorpicker.min.css" />

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
			
                        <!--Sidebar-->
                        <%@include file="/WEB-INF/jspf/sidebar.jspf" %>
                        <!--End Sidebar-->
		

			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>

							<li>
								<a href="#">User</a>
							</li>
							<li class="active">Create User</li>
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
                            
                            
						<div class="page-header">
<!--							<h1>
								User
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									Create new user
								</small>
							</h1>-->
						</div><!-- /.page-header -->
                                                
						<div class="row">
							<div class="col-xs-12">
                                                            
								<!-- PAGE CONTENT BEGINS -->
                                                                <s:form action="invent" method="post" id="theForm">
                    
                    
                            <br/>
                            <br>
                            <div class="form-group">
                        <div class="col-sm-11">
                            <div class="col-xs-3"> 
                                <span style="font-family: calibri; font-size: 12px;
                                      font-weight: bolder; color:#0059b3;"> 
                                    Terminal ID<br></span><input type = "text"  id="terminalID" name="terminalID" required="required" placeholder="Terminal ID"
                                          style="font-family: calibri; font-size: 15px; height: 30px;"/>
                            </div>
                            <div class="col-xs-3"> 
                                <span style="font-family: calibri; font-size: 12px;
                                      font-weight: bolder; color:#0059b3;"> 
                                    Journal Date<br></span>
                            <input class="date-picker" style="font-family: calibri; font-size: 15px;" 
                                  name="journalDate" value="${file.journalDate}" id ="inputField" 
                                  type="text" placeholder="Click to select date" />
                                  <!--<input class="form-control date-picker" id="id-date-picker-1" type="text" data-date-format="dd-mm-yyyy" />-->
<!--                            <span class="input-group-addon">
				<i class="fa fa-calendar bigger-110"></i>
                            </span>-->
                            </div>
                            <ol class="breadcrumb">
                            <div class="row">
                        <div class="col-sm-3" >
                            <button type="submit" onclick="doSubmit()" class="btn btn-primary btn-sm" style="font-family: Calibri; 
                                            font-weight: bolder;  font-size: 11px;"><a href="javascript:doSearch();">Search</a></button> 
                        </div> 
                            </div>
                            </ol>
                            
                        </div>
                            </div>

                    
                    </s:form>
                            
            </div>

                        
                            
                        <div class="row">
 

                            <div class="col-md-12">
                                <br><br>
                                
                <table id="myTable" class="display table table-bordered">

                    <thead>
<tr>
   <th><label for=e1>ID</label></th>
   <th><label for=e2>Name</label></th>
   <th><label for=e3>Size (Kb)</label></th>
   <th><label for=e4>Create Date</label></th>
   <th><label for=e4>Action</label></th>
</tr>

                        
                        
                    </thead>
					<tbody>

         <s:iterator value="myList" >

            <tr>
                <td><s:property value="id" /></td>                
                
                <td><s:property value="name" /></td>
                <td><s:property value="fileSize" /></td>   
                <td><s:property value="createDate" /></td>
                <td>    
                <s:url id="url" action="downloadFile">
                    <s:param name="file"><s:property value="name" /></s:param>
                    <s:param name="fileDirectory"><s:property value="fileDirectory" /></s:param>

                </s:url>
                <s:a href="%{url}">Download</s:a>
                
                
                </td>
            </tr>

        </s:iterator> 
		</tbody>
            </table>
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

		<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
                <link rel="stylesheet" type="text/css" media="all" href="plugins/medate/jsDatePick_ltr.min.css" />

                <script type="text/javascript" src="plugins/medate/jsDatePick.min.1.3.js"></script>

             

                
                
		<script src="assets/js/jquery-ui.custom.min.js"></script>
		<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="assets/js/chosen.jquery.min.js"></script>
		<script src="assets/js/spinbox.min.js"></script>
		<script src="assets/js/bootstrap-datepicker.min.js"></script>
		<script src="assets/js/bootstrap-timepicker.min.js"></script>
		<script src="assets/js/moment.min.js"></script>
		<script src="assets/js/daterangepicker.min.js"></script>
		<script src="assets/js/bootstrap-datetimepicker.min.js"></script>
		<script src="assets/js/bootstrap-colorpicker.min.js"></script>
		<script src="assets/js/jquery.knob.min.js"></script>
		<script src="assets/js/autosize.min.js"></script>
		<script src="assets/js/jquery.inputlimiter.min.js"></script>
		<script src="assets/js/jquery.maskedinput.min.js"></script>
		<script src="assets/js/bootstrap-tag.min.js"></script>
                
                <script src="assets/js/jquery.bootstrap-duallistbox.min.js"></script>
		<script src="assets/js/jquery.raty.min.js"></script>
		<script src="assets/js/bootstrap-multiselect.min.js"></script>
		<script src="assets/js/select2.min.js"></script>
		<script src="assets/js/jquery-typeahead.js"></script>
		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
<script type="text/javascript" class="init">
            window.onload = function() {
            new JsDatePick({
            useMode: 2,
            target: "inputField",
            yearsRange: [1998, 2040],
            dateFormat: "%Y-%m-%d"
            });
    };
    function doSearch(){
        if (document.getElementById('inputField').value != "") {
           var terminalID = document.getElementById('terminalID').value;
           if (terminalID != "" )
           {
               terminalID = terminalID + ".*";
               document.getElementById('terminalID').value = terminalID;
           }
           
           
           document.getElementById('theForm').submit(); 
        }
        else
        {
            alert("Please specify the journal date.");
        }
    }
    function doBack(){
        window.location = "rp";
    }
</script>
 
    <script>
    function doSubmit()    
    {
        document.body.style.cursor = 'wait';

    }      
    </script>

	</body>
</html>

