<%-- 
Document : assetSelect
Created on : Jan 5, 2017, 1:56:27 PM
Author : Efe Akpofure
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        
        <meta charset="utf-8">
        <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
        <title>User Select</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="viewport" content="width=device-width"> 
        <link rel="stylesheet" href="css/templatemo_main.css">
        
        <link rel="stylesheet" href="http://cdn.syncfusion.com/13.2.0.29/js/web/flat-azure/ej.web.all.min.css" />
        <script src="syncfusion/jquery-1.11.3.min.js"></script>
        <script src="syncfusion/jsrender.min.js"></script>
        <script src="syncfusion/ej.web.all.min.js"> </script>
        
        
        
        
    </head>
    <body>
        
        <div id="main-wrapper">
            
            
            <div class="template-page-wrapper">
                
                <div class="templatemo-content-wrapper">
                    <div class="templatemo-content">
                        
                        
                        <ol class="breadcrumb">
                            <div class="row ">
                                <div class="col-md-12">
                                    <div class="navbar-right form-group">
                                        
                                        <ul class="nav nav-pills">
                                            <li class="active" style='background-color: white'><a href="javascript:findAssetsByCriteria();"><i class="fa fa-refresh"></i>&nbsp; Refresh</a></li>
                                            <li style='background-color: white'><a id="updateEdit" href="javascript:changeParent();" disabled="true"><i class="fa fa-edit"></i>&nbsp; Select</a></li>
                                            <!-- <li style='background-color: white'><a id="viewEdit" href="javascript:doUrl('view');" disabled="true"><i class="fa fa-th-list"></i>&nbsp; View</a></li>-->
                                        </ul> 
                                    </div>
                                </div>
                        </ol>
                        
                        <div class="row">
                            <div class="col-md-12">
                                <div id='Grid'></div> 
                                
                            </div>
                        </div>
                    </div>
                </div>
                
                <!-- Delete Modal -->
                
                
                <div class="modal fade" id="confirmDeleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">Are you sure you want to delete this record?</h4>
                            </div>
                            <div class="modal-footer">
                                <a href="javascript:doUrl('delete');" class="btn btn-primary">Yes</a>
                                <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Sign Out Modal -->
                <div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">Are you sure you want to sign out?</h4>
                            </div>
                            <div class="modal-footer">
                                <a href="logOffHome" class="btn btn-primary">Yes</a>
                                <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                            </div>
                        </div>
                    </div>
                </div>
                <footer class="templatemo-footer">
                    <div class="templatemo-copyright">
                        <p>Copyright &copy; 2017 ActivEdge Technology Ltd</p>
                    </div>
                </footer>
            </div>
            
        </div>
        
        
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>

<script lang="Javascript" >

    var currentId =-1;
    var currentrow = "";
    var currentName = "";


    // var frm = document.getElementById("hiddenform");
    var frm = document.createElement("form");
    //var path = "viewUser?editMode=U&user.id="+ currentId; 



    function findNewUsersByCriteria() { 
        var name = document.getElementById("name").value;
        //alert("here" + name);

        var hiddenField3 = document.createElement("input");
        hiddenField3.setAttribute("type", "hidden");
        hiddenField3.setAttribute("name", "user.loginId");
        hiddenField3.setAttribute("value", name);
        frm.appendChild(hiddenField3); 
        frm.setAttribute("method", "POST");
        frm.setAttribute("action", "findNewUsersByCriteria");

        //alert(frm.action);

        frm.submit(); 

        var url = '<%=request.getContextPath()%>' + "\\findNewUsersByCriteria";
        //document.location.replace(url);
        //alert("here5");

    }

    function changeParent() { 


        var obj = $("#Grid").data("ejGrid");
        // var id = obj.getSelectedRecords()[0];
        // var colum = obj.getCurrentViewData();
        var recs = obj.getSelectedRecords();
        currentId = recs[0]["SN"];
        currentName = recs[0]["User ID"];
        if (currentId == -1 || currentId == "")
        {
            alert("Select a user from the List");
            return;
        } 

        // alert(currentName);


        window.opener.doSelectUser(currentId, currentName);
        window.close();

    } 


</script>
<script>
    
    $(function () {
        $('#Grid').ejGrid({
            dataSource: shipDetails,
            allowPaging: true,
            pageSettings: { pageCount: 3 , pageSize: 8},
            allowSorting: true,
            allowReordering : true,
            isResponsive: true,

            columns : [ 
                { field: "SN" },
                { field: "User ID"},
                { field: "Employee No" },
                { field: "Last Activity Date" },
                { field: "Status" }
                      
            ]                
        });
        
    });



    var shipDetails = [        
        <s:iterator value="users">                      
                { "SN": '<s:property value="id"/>',
                    "User ID": '<s:property value="loginId"/>',
                    "Employee No": '<s:property value="employeeNo"/>', 
                    "Last Activity Date": '<s:property value="lastActivityDate"/>',
                    "Status": '<s:property value="status"/>'
                },
    </s:iterator> 
            ];
    
</script>










