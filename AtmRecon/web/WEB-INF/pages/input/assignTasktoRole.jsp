<%-- 
    Document   : assignTasktoRole
    Created on : Sep 27, 2017, 5:29:27 PM
    Author     : TechDev
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

	<body class="no-skin">
		<!-- Nav Bar -->
            <%@include file="/WEB-INF/jspf/header.jspf" %>
            <!-- End Nav Bar -->
		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>
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
								<a href="#">Admin</a>
							</li>
							<li class="active">Users</li>
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
							<h1>
								Users
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									All recent items
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								

								<div class="row">
									<div class="col-xs-12">
        <form action="createRoleActivity" method="POST" name="myform">
                                        <table class="table table-striped table-hover">
                                            <tbody>
                                                <tr class="success">
                                                    <td colspan="2">
                                                        <h5 style="font-weight: bold">Activity Role </h5>
                                                    </td>
                                                </tr>
                                                        <tr>
                                                            <td class="col-md-3">Role ID</td>
                                                                
                                                            <td> <input name="roleactivity.roleID" id="getRoleID" value="${roleactivity.roleID}" type="hidden" /><input name="roleactivity.code" type="text" value="${roleactivity.code}" readonly="true" size="30" id="getCode"><!--input class="btn btn-default" type="button" onclick="javascript:openWindow();" value='Get Role'/-->
                                                            </td>
                                                        </tr>
                                                        
                                                        
                                        </tbody>
                                            </table>   
                                                  <div class="row">
                                                        <div class="col-md-4">
                                                            <h5><strong>Assign</strong></h5>
                                                        </div>
                                                        <div class="col-md-4">
                                                            
                                                        </div>
                                                        <div class="col-md-4">
                                                            <h5><strong>Available</strong></h5>
                                                        </div>
                                                  </div>
                                                        
                                                        <div class="row">
                                                            <div class="col-md-5">
                                                        <s:select name="assignedActivity" id="myForm" listValue="listDescription" list="roleActivitys" listKey="activityCode" size="9" multiple="true" ></s:select>  
                                                            </div>
                                                        <div class="col-md-3">
                                                            <a href="javascript:availMulti();" class="btn btn-primary fa fa-angle-double-right" style="width: 50px; height: 30px;"></a><br><br>
                                                            <a href="javascript:avail();" class="btn btn-primary fa fa-angle-right" style="width: 50px; height: 30px;"></a><br><br>
                                                            <a href="javascript:assign();" class="btn btn-primary fa fa-angle-left" style="width: 50px; height: 30px;"></a><br><br>
                                                            <a href="javascript:assignMulti();" class="btn btn-primary fa fa-angle-double-left" style="width: 50px; height: 30px;"></a>
                                                    
                                                        </div>
                                                        <div class="col-md-4">
                                                        <s:select name="myList" multiple="true" id="myForma" listValue="listDescription" list="roleAvailableActivitys" listKey="code" size="9"></s:select>
                                                            
                                                        </div> 
                                                        </div>                 
                                                        <br><br>
                                                            <table>
                                                                
                                                            <tr>
                                                                <td colspan="2">
                                                                    <input type="submit" value="Save" class="btn btn-primary"/>
                                                                    <input class="btn btn-default" value='Cancel' data-toggle="modal" data-target="#confirmCloseModal" onclick='javascript:;'/>
                                                                </td>
                                                            </tr>
                                                            </table>
                                        </form>
                                                                        </div>
                                                                </div>
    </body>
    
   <script lang="Javascript" >
 
       function avail(){
           var assignlist = document.getElementById("myForm");
           var availlist = document.getElementById("myForma");
           moveRecord(assignlist, availlist);   
        }
        function availMulti()
        {
           var assignlist = document.getElementById("myForm");
           var availlist = document.getElementById("myForma");
           moveSelectedRecord(assignlist,availlist); 
        }
        function assignMulti()
        {
           var assignlist = document.getElementById("myForm");
           var availlist = document.getElementById("myForma");
           moveSelectedRecord(availlist, assignlist); 
        }
         function moveSelectedRecord(oldlist, newlist){
            //alert("here");
            var i = 0;
            for  (i = oldlist.length - 1; i >= 0; i--)
           {
               //alert(oldlist.options[i].selected);
               //alert(oldlist.options[i].value);
               if (oldlist.options[i].selected)
               {
                   var mover = oldlist.options[i].value;

                   var newoption = document.createElement("option");
                   newoption.text = mover;
                   oldlist.options.remove(i);
                   newlist.options.add(newoption);
               }
           }

        }  
          function moveRecord(oldlist, newlist){

           var selectindex = oldlist.selectedIndex;
          // alert(oldlist.options[selectindex].value);
           var mover = oldlist.options[selectindex].value;

           var newoption = document.createElement("option");
           newoption.text = mover;
           oldlist.options.remove(selectindex);
           newlist.options.add(newoption);
           
           //alert(newlist.options[1].value);
       //for (var value in newlist.options[0])
        //{
            //alert(value);
            //alert(newlist.options);
        //}
        }           
        
        function assign(){
           var assignlist = document.getElementById("myForm");
           var availlist = document.getElementById("myForma");
           moveRecord(availlist, assignlist);   
        }
      
      function GetAvails()
       {
           var assignmultilist = document.getElementById("myForm");
           var availmultilist = document.getElementById("myForma");
           moveRecord(assignmultilist, availmultilist);   
         var multilist = document.forms.myform;
         var SelMultiVal = "";
         var x = 0;

         for (x=0; x < multilist.myForm.length; x++)
         {
            if (multilist.myForm[x].selected)
            {
             //alert(multilist.myForm[x].value);
             SelMultiVal = SelMultiVal + multilist.myForm[x].value+ "," ;
            }
         }
         //alert(SelMultiVal);
       }
       
       function GetAssigns()
       {
           var assignmultilist = document.getElementById("myForm");
           var availmultilist = document.getElementById("myForma");
           moveRecord(availmultilist, assignmultilist); 
         var multilist = document.forms.myform;
         var SelMultiVal = "";
         var x = 0;

         for (x=0; x < multilist.myForma.length; x++)
         {
            if (multilist.myForma[x].selected)
            {
             //alert(multilist.myForm[x].value);
             SelMultiVal = SelMultiVal + multilist.myForma[x].value+ "," ;
            }
         }
         //alert(SelMultiVal);
       }
       
       
    var currentId =-1;
    var currentrow = "";
    var currentbgcolor = "";
    var currentfontcolor = "";
    
    var highlightrow;
    var highlightcolor = ' #4a8cf8 ';
    var fontcolor = 'white';
    
    var currentName = "";
    var newName = "";
    
    function selectRow(row, cId, cName, nName)
    {

        currentId = cId;
        currentName = cName;
        newName = nName;
        if (currentrow != "")
        {
            currentrow.style.backgroundColor = currentbgcolor;
            currentrow.style.color = currentfontcolor;
        }
        
        currentrow = row;
        currentbgcolor = row.style.backgroundColor;
        currentfontcolor = row.style.color;
        
        row.style.backgroundColor = highlightcolor;
        row.style.color = fontcolor;
       
    }
</html>
