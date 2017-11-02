<%-- 
    Document   : roleinput
    Created on : Oct 3, 2017, 9:47:18 AM
    Author     : TechDev
--%>
<%try
{
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Form Elements - Ace Admin</title>

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
								<a href="#">User Role</a>
							</li>
							<!--<li class="active">Create User</li>-->
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
                            
                            <s:if test='editMode== "C"'>
                            <h1>Role<small><i class="ace-icon fa fa-angle-double-right"></i>
					View role
					</small>
                                </h1>
                            </s:if>   
                            <s:elseif test='editMode== "V"'>
                               
                                <h1>Role<small><i class="ace-icon fa fa-angle-double-right"></i>
					Add new role
					</small>
                                </h1>
                            </s:elseif>  
                            <s:elseif test='editMode== "U"'>
                               <h1>Role<small><i class="ace-icon fa fa-angle-double-right"></i>
					Update role
					</small>
                                </h1>
                            </s:elseif>  
                            <s:elseif test='editMode== "R"'>
                               <h1>Role<small><i class="ace-icon fa fa-angle-double-right"></i>
					Deactivate role
					</small>
                                </h1>
                            </s:elseif>
                            <s:elseif test='editMode== "A"'>
                               <h1>Role<small><i class="ace-icon fa fa-angle-double-right"></i>
					Assign Task to Role
					</small>
                                </h1>
                            </s:elseif>
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
                                                                <s:if test='editMode=="C"'>
                                                                    <form class="form-horizontal" role="form" action="" method="POST">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Code </label>

										<div class="col-sm-9"><input type="hidden" name="role.id" value="${role.id}"/>
                                                                                    ${role.code}
										</div>
									</div>
                                                                                    
                                                                        <div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Description </label>

										<div class="col-sm-9">
                                                                                    ${role.description}
										</div>
									</div>
                                                                                
                                                                        <div class="clearfix form-actions">
                                                                            <div class="col-md-offset-3 col-md-9">
                                                                                <button class="btn btn-info" type="submit" formaction="findAllRoles">
                                                                                    <i class="ace-icon fa fa-check bigger-110"></i>
                                                                                            Done
                                                                                </button>


                                                                             </div>
                                                                        </div>
                                                                </form>
								
                                                                </s:if>          
                                                                         
                                                                <s:if test='editMode=="V"'>
								<form class="form-horizontal" role="form" action="createRole" method="POST">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Code </label>

										<div class="col-sm-9">
                                                                                    <input name="role.code" required="required" type="text" value="${role.code}" id="form-field-1" placeholder="Code" class="col-xs-10 col-sm-5" />
										</div>
									</div>
                                                                                    
                                                                        <div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Description </label>

										<div class="col-sm-9">
                                                                                    <textarea class="limited" id="form-field-9" rows="5" cols="40" maxlength="50" name="role.description" value="${role.description}"></textarea>
                                                                                    
										</div>
									</div>
     
									
                                                                        <div class="clearfix form-actions">
                                                                            <div class="col-md-offset-3 col-md-9">
                                                                                <button class="btn btn-info" type="submit">
                                                                                    <i class="ace-icon fa fa-check bigger-110"></i>
                                                                                            Submit
                                                                                </button>
                                                                                <button class="btn btn-info" type="submit" formaction="initRole">
                                                                                    <i class="ace-icon fa fa-error bigger-110"></i>
                                                                                            Cancel
                                                                                </button>


                                                                             </div>
                                                                        </div>
                                                                </form>
                                                                </s:if>
                                                                
                                                                <s:if test='editMode=="R"'>
								<form class="form-horizontal" role="form" action="deleteRole" method="POST">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Code </label>

										<div class="col-sm-9"><input type="hidden" name="role.id" value="${role.id}"/>
                                                                                    ${role.code}
										</div>
									</div>
                                                                                    
                                                                        <div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Description</label>

										<div class="col-sm-9">
                                                                                    ${role.description}
										</div>
									</div>
                                                                                
                                                                        
                                                                        <div class="clearfix form-actions">
                                                                            <div class="col-md-offset-3 col-md-9">
                                                                                <button class="btn btn-info" type="submit">
                                                                                    <i class="ace-icon fa fa-check bigger-110"></i>
                                                                                            Delete
                                                                                </button>
                                                                                <button class="btn btn-info" type="submit" formaction="findAllRoles">
                                                                                    <i class="ace-icon fa fa-error bigger-110"></i>
                                                                                            Cancel
                                                                                </button>

                                                                             </div>
                                                                        </div>
                                                                </form>
                                                                </s:if>
									
                                                                <s:if test='editMode=="U"'>
								<form class="form-horizontal" role="form" action="updateRole" method="POST">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Code </label>

										<div class="col-sm-9"><input type="hidden" name="role.id" value="${role.id}"/>
                                                                                    <input name="role.code" required="required" type="text" value="${role.code}" id="form-field-1" class="col-xs-10 col-sm-5" />
										</div>
									</div>
                                                                                
                                                                        <div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Description</label>

										<div class="col-sm-9">
                                                                                    <!--<textarea class="limited" id="form-field-9" rows="5" cols="40" maxlength="50" name="role.description" value="${role.description}"></textarea>-->
                                                                                    <s:textarea rows="5" cols="30" theme="simple" name="role.description" value="%{role.description}" label="Description"></s:textarea>
										</div>
									</div>       
									
                                                                        <div class="clearfix form-actions">
                                                                            <div class="col-md-offset-3 col-md-9">
                                                                                <button class="btn btn-info" type="submit">
                                                                                    <i class="ace-icon fa fa-check bigger-110"></i>
                                                                                            Update
                                                                                </button>
                                                                                <button class="btn btn-info" type="submit" formaction="findAllRoles">
                                                                                    <i class="ace-icon fa fa-error bigger-110"></i>
                                                                                            Cancel
                                                                                </button>


                                                                             </div>
                                                                        </div>
                                                                </form>
                                                                </s:if>
                                                                
                                                                <s:if test='editMode=="A"'>
								<form class="form-horizontal" role="form" action="createRoleTask" method="POST">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-top" for="duallist"> Role ID </label>
                                                                                <input name="role.roleID" value="${role.roleID}" type="hidden" /><input name="role.code" type="text" value="${role.code}" readonly="true" size="20" id="getCode">
                                                                                <div class="row">
                                                                                    <div class="col-sm-4">
                                                                                        <h5><strong>Assign</strong></h5>
                                                                                    </div>
                                                                                    <div class="col-sm-4">

                                                                                    </div>
                                                                                    <div class="col-sm-4">
                                                                                        <h5><strong>Available</strong></h5>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="col-md-8">
                                                                                    <div class="col-sm-4">
                                                                                        <!--here-->
                                                                                        <%--<s:iterator value="roles">--%>
                                                                                        <%--<s:select multiple="multiple" size="10" name="duallistbox_demo1[]" id="duallist" list="roles" listValue="listDescription" listKey="taskCode"></s:select>--%>
                                                                                        <s:select multiple="true" size="10" name="assignedTask" id="myForm" list="roles" listValue="listDescription" listKey="taskCode"></s:select>
                                                                                        </div>
                                                                                        <div class="col-sm-4">
                                                                                            <a href="javascript:availMulti();" class="btn btn-primary fa fa-angle-double-right" style="width: 50px; height: 30px;"></a><br><br>
                                                                                            <a href="javascript:avail();" class="btn btn-primary fa fa-angle-right" style="width: 50px; height: 30px;"></a><br><br>
                                                                                            <a href="javascript:assign();" class="btn btn-primary fa fa-angle-left" style="width: 50px; height: 30px;"></a><br><br>
                                                                                            <a href="javascript:assignMulti();" class="btn btn-primary fa fa-angle-double-left" style="width: 50px; height: 30px;"></a>

                                                                                        </div>
                                                                                        <div class="col-sm-4">
                                                                                        <s:select multiple="true" size="10" name="myList" id="myForma" listValue="listDescription" list="roleAvailableTasks" listKey="code"></s:select>
                                                                                    </div>
                                                                                    <div class="col-md-4">
                                                                                        <input type="submit" value="Save" class="btn btn-primary"/>
                                                                                    </div>
                                                                                </div>
                                                                                    
                                                                                
                                                                                    <%--</s:iterator>--%>
                                                                            <%--<s:select name="role.code" listValue="listDescription" list="roles" listKey="taskCode"   size="9" multiple="true" >wwws</s:select>--%>  
<!--												<option value="option1">Option 1</option>
												<option value="option2">Option 2</option>
												<option value="option3" selected="selected">Option 3</option>
												<option value="option4">Option 4</option>
												<option value="option5">Option 5</option>
												<option value="option6" selected="selected">Option 6</option>
												<option value="option7">Option 7</option>
												<option value="option8">Option 8</option>
												<option value="option9">Option 9</option>
												<option value="option0">Option 10</option>

                                                                                                
											</select>
                                                                                    <input name="role.roleID" id="getRoleID" value="${role.roleID}" type="hidden" />
                                                                                    
											<div class="hr hr-16 hr-dotted"></div>
										</div>
									</div>
                                                                        <!--</div>-->
                                                                </form>
                                                                </s:if>             
<!--                                    <form action="createRoleTask" method="POST" name="myform">
                                        <table class="table table-striped table-hover">
                                            <tbody>
                                                <tr class="success">
                                                    <td colspan="2">
                                                        <h5 style="font-weight: bold">Assign Task to Role </h5>
                                                    </td>
                                                </tr>
                                                        <tr>
                                                            <td class="col-md-3">Role ID</td>
                                                                
                                                            <td> <input name="roleatask.roleID" id="getRoleID" value="${role.roleID}" type="hidden" /><input name="roletask.code" type="text" value="${role.code}" readonly="true" size="30" id="getCode">input class="btn btn-default" type="button" onclick="javascript:openWindow();" value='Get Role'/
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
                                                        <%--<s:select name="assignedTask" id="myForm" listValue="listDescription" list="roleTasks" listKey="taskCode" size="9" multiple="true" ></s:select>--%>  
                                                            </div>
                                                        <div class="col-md-3">
                                                            <a href="javascript:availMulti();" class="btn btn-primary fa fa-angle-double-right" style="width: 50px; height: 30px;"></a><br><br>
                                                            <a href="javascript:avail();" class="btn btn-primary fa fa-angle-right" style="width: 50px; height: 30px;"></a><br><br>
                                                            <a href="javascript:assign();" class="btn btn-primary fa fa-angle-left" style="width: 50px; height: 30px;"></a><br><br>
                                                            <a href="javascript:assignMulti();" class="btn btn-primary fa fa-angle-double-left" style="width: 50px; height: 30px;"></a>
                                                    
                                                        </div>
                                                        <div class="col-md-4">
                                                        <%--<s:select name="myList" multiple="true" id="myForma" listValue="listDescription" list="roleAvailableTasks" listKey="code" size="9"></s:select>--%>
                                                            
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
                                        </form>                     -->
                                                               
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<!--Footer-->
            <%@include file="/WEB-INF/jspf/footer.jspf" %>
            <!--End Footer-->

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
		<script type="text/javascript">
			jQuery(function($) {
				$('#id-disable-check').on('click', function() {
					var inp = $('#form-input-readonly').get(0);
					if(inp.hasAttribute('disabled')) {
						inp.setAttribute('readonly' , 'true');
						inp.removeAttribute('disabled');
						inp.value="This text field is readonly!";
					}
					else {
						inp.setAttribute('disabled' , 'disabled');
						inp.removeAttribute('readonly');
						inp.value="This text field is disabled!";
					}
				});
			
			
				if(!ace.vars['touch']) {
					$('.chosen-select').chosen({allow_single_deselect:true}); 
					//resize the chosen on window resize
			
					$(window)
					.off('resize.chosen')
					.on('resize.chosen', function() {
						$('.chosen-select').each(function() {
							 var $this = $(this);
							 $this.next().css({'width': $this.parent().width()});
						})
					}).trigger('resize.chosen');
					//resize chosen on sidebar collapse/expand
					$(document).on('settings.ace.chosen', function(e, event_name, event_val) {
						if(event_name != 'sidebar_collapsed') return;
						$('.chosen-select').each(function() {
							 var $this = $(this);
							 $this.next().css({'width': $this.parent().width()});
						})
					});
			
			
					$('#chosen-multiple-style .btn').on('click', function(e){
						var target = $(this).find('input[type=radio]');
						var which = parseInt(target.val());
						if(which == 2) $('#form-field-select-4').addClass('tag-input-style');
						 else $('#form-field-select-4').removeClass('tag-input-style');
					});
				}
			
			
				$('[data-rel=tooltip]').tooltip({container:'body'});
				$('[data-rel=popover]').popover({container:'body'});
			
				autosize($('textarea[class*=autosize]'));
				
				$('textarea.limited').inputlimiter({
					remText: '%n character%s remaining...',
					limitText: 'max allowed : %n.'
				});
			
				$.mask.definitions['~']='[+-]';
				$('.input-mask-date').mask('99/99/9999');
				$('.input-mask-phone').mask('(999) 999-9999');
				$('.input-mask-eyescript').mask('~9.99 ~9.99 999');
				$(".input-mask-product").mask("a*-999-a999",{placeholder:" ",completed:function(){alert("You typed the following: "+this.val());}});
			
			
			
				$( "#input-size-slider" ).css('width','200px').slider({
					value:1,
					range: "min",
					min: 1,
					max: 8,
					step: 1,
					slide: function( event, ui ) {
						var sizing = ['', 'input-sm', 'input-lg', 'input-mini', 'input-small', 'input-medium', 'input-large', 'input-xlarge', 'input-xxlarge'];
						var val = parseInt(ui.value);
						$('#form-field-4').attr('class', sizing[val]).attr('placeholder', '.'+sizing[val]);
					}
				});
			
				$( "#input-span-slider" ).slider({
					value:1,
					range: "min",
					min: 1,
					max: 12,
					step: 1,
					slide: function( event, ui ) {
						var val = parseInt(ui.value);
						$('#form-field-5').attr('class', 'col-xs-'+val).val('.col-xs-'+val);
					}
				});
			
			
				
				//"jQuery UI Slider"
				//range slider tooltip example
				$( "#slider-range" ).css('height','200px').slider({
					orientation: "vertical",
					range: true,
					min: 0,
					max: 100,
					values: [ 17, 67 ],
					slide: function( event, ui ) {
						var val = ui.values[$(ui.handle).index()-1] + "";
			
						if( !ui.handle.firstChild ) {
							$("<div class='tooltip right in' style='display:none;left:16px;top:-6px;'><div class='tooltip-arrow'></div><div class='tooltip-inner'></div></div>")
							.prependTo(ui.handle);
						}
						$(ui.handle.firstChild).show().children().eq(1).text(val);
					}
				}).find('span.ui-slider-handle').on('blur', function(){
					$(this.firstChild).hide();
				});
				
				
				$( "#slider-range-max" ).slider({
					range: "max",
					min: 1,
					max: 10,
					value: 2
				});
				
				$( "#slider-eq > span" ).css({width:'90%', 'float':'left', margin:'15px'}).each(function() {
					// read initial values from markup and remove that
					var value = parseInt( $( this ).text(), 10 );
					$( this ).empty().slider({
						value: value,
						range: "min",
						animate: true
						
					});
				});
				
				$("#slider-eq > span.ui-slider-purple").slider('disable');//disable third item
			
				
				$('#id-input-file-1 , #id-input-file-2').ace_file_input({
					no_file:'No File ...',
					btn_choose:'Choose',
					btn_change:'Change',
					droppable:false,
					onchange:null,
					thumbnail:false //| true | large
					//whitelist:'gif|png|jpg|jpeg'
					//blacklist:'exe|php'
					//onchange:''
					//
				});
				//pre-show a file name, for example a previously selected file
				//$('#id-input-file-1').ace_file_input('show_file_list', ['myfile.txt'])
			
			
				$('#id-input-file-3').ace_file_input({
					style: 'well',
					btn_choose: 'Drop files here or click to choose',
					btn_change: null,
					no_icon: 'ace-icon fa fa-cloud-upload',
					droppable: true,
					thumbnail: 'small'//large | fit
					//,icon_remove:null//set null, to hide remove/reset button
					/**,before_change:function(files, dropped) {
						//Check an example below
						//or examples/file-upload.html
						return true;
					}*/
					/**,before_remove : function() {
						return true;
					}*/
					,
					preview_error : function(filename, error_code) {
						//name of the file that failed
						//error_code values
						//1 = 'FILE_LOAD_FAILED',
						//2 = 'IMAGE_LOAD_FAILED',
						//3 = 'THUMBNAIL_FAILED'
						//alert(error_code);
					}
			
				}).on('change', function(){
					//console.log($(this).data('ace_input_files'));
					//console.log($(this).data('ace_input_method'));
				});
				
				
				//$('#id-input-file-3')
				//.ace_file_input('show_file_list', [
					//{type: 'image', name: 'name of image', path: 'http://path/to/image/for/preview'},
					//{type: 'file', name: 'hello.txt'}
				//]);
			
				
				
			
				//dynamically change allowed formats by changing allowExt && allowMime function
				$('#id-file-format').removeAttr('checked').on('change', function() {
					var whitelist_ext, whitelist_mime;
					var btn_choose
					var no_icon
					if(this.checked) {
						btn_choose = "Drop images here or click to choose";
						no_icon = "ace-icon fa fa-picture-o";
			
						whitelist_ext = ["jpeg", "jpg", "png", "gif" , "bmp"];
						whitelist_mime = ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"];
					}
					else {
						btn_choose = "Drop files here or click to choose";
						no_icon = "ace-icon fa fa-cloud-upload";
						
						whitelist_ext = null;//all extensions are acceptable
						whitelist_mime = null;//all mimes are acceptable
					}
					var file_input = $('#id-input-file-3');
					file_input
					.ace_file_input('update_settings',
					{
						'btn_choose': btn_choose,
						'no_icon': no_icon,
						'allowExt': whitelist_ext,
						'allowMime': whitelist_mime
					})
					file_input.ace_file_input('reset_input');
					
					file_input
					.off('file.error.ace')
					.on('file.error.ace', function(e, info) {
						//console.log(info.file_count);//number of selected files
						//console.log(info.invalid_count);//number of invalid files
						//console.log(info.error_list);//a list of errors in the following format
						
						//info.error_count['ext']
						//info.error_count['mime']
						//info.error_count['size']
						
						//info.error_list['ext']  = [list of file names with invalid extension]
						//info.error_list['mime'] = [list of file names with invalid mimetype]
						//info.error_list['size'] = [list of file names with invalid size]
						
						
						/**
						if( !info.dropped ) {
							//perhapse reset file field if files have been selected, and there are invalid files among them
							//when files are dropped, only valid files will be added to our file array
							e.preventDefault();//it will rest input
						}
						*/
						
						
						//if files have been selected (not dropped), you can choose to reset input
						//because browser keeps all selected files anyway and this cannot be changed
						//we can only reset file field to become empty again
						//on any case you still should check files with your server side script
						//because any arbitrary file can be uploaded by user and it's not safe to rely on browser-side measures
					});
					
					
					/**
					file_input
					.off('file.preview.ace')
					.on('file.preview.ace', function(e, info) {
						console.log(info.file.width);
						console.log(info.file.height);
						e.preventDefault();//to prevent preview
					});
					*/
				
				});
			
				$('#spinner1').ace_spinner({value:0,min:0,max:200,step:10, btn_up_class:'btn-info' , btn_down_class:'btn-info'})
				.closest('.ace-spinner')
				.on('changed.fu.spinbox', function(){
					//console.log($('#spinner1').val())
				}); 
				$('#spinner2').ace_spinner({value:0,min:0,max:10000,step:100, touch_spinner: true, icon_up:'ace-icon fa fa-caret-up bigger-110', icon_down:'ace-icon fa fa-caret-down bigger-110'});
				$('#spinner3').ace_spinner({value:0,min:-100,max:100,step:10, on_sides: true, icon_up:'ace-icon fa fa-plus bigger-110', icon_down:'ace-icon fa fa-minus bigger-110', btn_up_class:'btn-success' , btn_down_class:'btn-danger'});
				$('#spinner4').ace_spinner({value:0,min:-100,max:100,step:10, on_sides: true, icon_up:'ace-icon fa fa-plus', icon_down:'ace-icon fa fa-minus', btn_up_class:'btn-purple' , btn_down_class:'btn-purple'});
			
				//$('#spinner1').ace_spinner('disable').ace_spinner('value', 11);
				//or
				//$('#spinner1').closest('.ace-spinner').spinner('disable').spinner('enable').spinner('value', 11);//disable, enable or change value
				//$('#spinner1').closest('.ace-spinner').spinner('value', 0);//reset to 0
			
			
				//datepicker plugin
				//link
				$('.date-picker').datepicker({
					autoclose: true,
					todayHighlight: true
				})
				//show datepicker when clicking on the icon
				.next().on(ace.click_event, function(){
					$(this).prev().focus();
				});
			
				//or change it into a date range picker
				$('.input-daterange').datepicker({autoclose:true});
			
			
				//to translate the daterange picker, please copy the "examples/daterange-fr.js" contents here before initialization
				$('input[name=date-range-picker]').daterangepicker({
					'applyClass' : 'btn-sm btn-success',
					'cancelClass' : 'btn-sm btn-default',
					locale: {
						applyLabel: 'Apply',
						cancelLabel: 'Cancel',
					}
				})
				.prev().on(ace.click_event, function(){
					$(this).next().focus();
				});
			
			
				$('#timepicker1').timepicker({
					minuteStep: 1,
					showSeconds: true,
					showMeridian: false,
					disableFocus: true,
					icons: {
						up: 'fa fa-chevron-up',
						down: 'fa fa-chevron-down'
					}
				}).on('focus', function() {
					$('#timepicker1').timepicker('showWidget');
				}).next().on(ace.click_event, function(){
					$(this).prev().focus();
				});
				
				
			
				
				if(!ace.vars['old_ie']) $('#date-timepicker1').datetimepicker({
				 //format: 'MM/DD/YYYY h:mm:ss A',//use this option to display seconds
				 icons: {
					time: 'fa fa-clock-o',
					date: 'fa fa-calendar',
					up: 'fa fa-chevron-up',
					down: 'fa fa-chevron-down',
					previous: 'fa fa-chevron-left',
					next: 'fa fa-chevron-right',
					today: 'fa fa-arrows ',
					clear: 'fa fa-trash',
					close: 'fa fa-times'
				 }
				}).next().on(ace.click_event, function(){
					$(this).prev().focus();
				});
				
			
				$('#colorpicker1').colorpicker();
				//$('.colorpicker').last().css('z-index', 2000);//if colorpicker is inside a modal, its z-index should be higher than modal'safe
			
				$('#simple-colorpicker-1').ace_colorpicker();
				//$('#simple-colorpicker-1').ace_colorpicker('pick', 2);//select 2nd color
				//$('#simple-colorpicker-1').ace_colorpicker('pick', '#fbe983');//select #fbe983 color
				//var picker = $('#simple-colorpicker-1').data('ace_colorpicker')
				//picker.pick('red', true);//insert the color if it doesn't exist
			
			
				$(".knob").knob();
				
				
				var tag_input = $('#form-field-tags');
				try{
					tag_input.tag(
					  {
						placeholder:tag_input.attr('placeholder'),
						//enable typeahead by specifying the source array
						source: ace.vars['US_STATES'],//defined in ace.js >> ace.enable_search_ahead
						/**
						//or fetch data from database, fetch those that match "query"
						source: function(query, process) {
						  $.ajax({url: 'remote_source.php?q='+encodeURIComponent(query)})
						  .done(function(result_items){
							process(result_items);
						  });
						}
						*/
					  }
					)
			
					//programmatically add/remove a tag
					var $tag_obj = $('#form-field-tags').data('tag');
					$tag_obj.add('Programmatically Added');
					
					var index = $tag_obj.inValues('some tag');
					$tag_obj.remove(index);
				}
				catch(e) {
					//display a textarea for old IE, because it doesn't support this plugin or another one I tried!
					tag_input.after('<textarea id="'+tag_input.attr('id')+'" name="'+tag_input.attr('name')+'" rows="3">'+tag_input.val()+'</textarea>').remove();
					//autosize($('#form-field-tags'));
				}
				
				
				/////////
				$('#modal-form input[type=file]').ace_file_input({
					style:'well',
					btn_choose:'Drop files here or click to choose',
					btn_change:null,
					no_icon:'ace-icon fa fa-cloud-upload',
					droppable:true,
					thumbnail:'large'
				})
				
				//chosen plugin inside a modal will have a zero width because the select element is originally hidden
				//and its width cannot be determined.
				//so we set the width after modal is show
				$('#modal-form').on('shown.bs.modal', function () {
					if(!ace.vars['touch']) {
						$(this).find('.chosen-container').each(function(){
							$(this).find('a:first-child').css('width' , '210px');
							$(this).find('.chosen-drop').css('width' , '210px');
							$(this).find('.chosen-search input').css('width' , '200px');
						});
					}
				})
				/**
				//or you can activate the chosen plugin after modal is shown
				//this way select element becomes visible with dimensions and chosen works as expected
				$('#modal-form').on('shown', function () {
					$(this).find('.modal-chosen').chosen();
				})
				*/
			
				
				
				$(document).one('ajaxloadstart.page', function(e) {
					autosize.destroy('textarea[class*=autosize]')
					
					$('.limiterBox,.autosizejs').remove();
					$('.daterangepicker.dropdown-menu,.colorpicker.dropdown-menu,.bootstrap-datetimepicker-widget.dropdown-menu').remove();
				});
			
			});
		</script>
                
		<script type="text/javascript">
			jQuery(function($){
			    var demo1 = $('select[name="duallistbox_demo1[]"]').bootstrapDualListbox({infoTextFiltered: '<span class="label label-purple label-lg">Filtered</span>'});
				var container1 = demo1.bootstrapDualListbox('getContainer');
				container1.find('.btn').addClass('btn-white btn-info btn-bold');
			
				/**var setRatingColors = function() {
					$(this).find('.star-on-png,.star-half-png').addClass('orange2').removeClass('grey');
					$(this).find('.star-off-png').removeClass('orange2').addClass('grey');
				}*/
				$('.rating').raty({
					'cancel' : true,
					'half': true,
					'starType' : 'i'
					/**,
					
					'click': function() {
						setRatingColors.call(this);
					},
					'mouseover': function() {
						setRatingColors.call(this);
					},
					'mouseout': function() {
						setRatingColors.call(this);
					}*/
				})//.find('i:not(.star-raty)').addClass('grey');
				
				
				
				//////////////////
				//select2
				$('.select2').css('width','200px').select2({allowClear:true})
				$('#select2-multiple-style .btn').on('click', function(e){
					var target = $(this).find('input[type=radio]');
					var which = parseInt(target.val());
					if(which == 2) $('.select2').addClass('tag-input-style');
					 else $('.select2').removeClass('tag-input-style');
				});
				
				//////////////////
				$('.multiselect').multiselect({
				 enableFiltering: true,
				 enableHTML: true,
				 buttonClass: 'btn btn-white btn-primary',
				 templates: {
					button: '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown"><span class="multiselect-selected-text"></span> &nbsp;<b class="fa fa-caret-down"></b></button>',
					ul: '<ul class="multiselect-container dropdown-menu"></ul>',
					filter: '<li class="multiselect-item filter"><div class="input-group"><span class="input-group-addon"><i class="fa fa-search"></i></span><input class="form-control multiselect-search" type="text"></div></li>',
					filterClearBtn: '<span class="input-group-btn"><button class="btn btn-default btn-white btn-grey multiselect-clear-filter" type="button"><i class="fa fa-times-circle red2"></i></button></span>',
					li: '<li><a tabindex="0"><label></label></a></li>',
			        divider: '<li class="multiselect-item divider"></li>',
			        liGroup: '<li class="multiselect-item multiselect-group"><label></label></li>'
				 }
				});
			
				
				///////////////////
					
				//typeahead.js
				//example taken from plugin's page at: https://twitter.github.io/typeahead.js/examples/
				var substringMatcher = function(strs) {
					return function findMatches(q, cb) {
						var matches, substringRegex;
					 
						// an array that will be populated with substring matches
						matches = [];
					 
						// regex used to determine if a string contains the substring `q`
						substrRegex = new RegExp(q, 'i');
					 
						// iterate through the pool of strings and for any string that
						// contains the substring `q`, add it to the `matches` array
						$.each(strs, function(i, str) {
							if (substrRegex.test(str)) {
								// the typeahead jQuery plugin expects suggestions to a
								// JavaScript object, refer to typeahead docs for more info
								matches.push({ value: str });
							}
						});
			
						cb(matches);
					}
				 }
			
				 $('input.typeahead').typeahead({
					hint: true,
					highlight: true,
					minLength: 1
				 }, {
					name: 'states',
					displayKey: 'value',
					source: substringMatcher(ace.vars['US_STATES']),
					limit: 10
				 });
					
					
				///////////////
				
				
				//in ajax mode, remove remaining elements before leaving page
				$(document).one('ajaxloadstart.page', function(e) {
					$('[class*=select2]').remove();
					$('select[name="duallistbox_demo1[]"]').bootstrapDualListbox('destroy');
					$('.rating').raty('destroy');
					$('.multiselect').multiselect('destroy');
				});
			
			});
		</script>
                
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
      </script>
	</body>
</html>
<%}
catch(Exception e)
{
    e.printStackTrace();
}
%>