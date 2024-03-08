<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title></title>

	<c:import url="../temp/css.jsp"></c:import>

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
		<c:import url="../temp/sidebar.jsp"></c:import>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
				<c:import url="../temp/topbar.jsp"></c:import>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>

                    <!-- Content Row -->
                    <div class="row">

						<div class="container">
						
						        <!-- Outer Row -->
						        <div class="row justify-content-center">
						
						            <div class="col-xl-10 col-lg-12 col-md-9">
						
						                <div class="card o-hidden border-0 shadow-lg my-5">
						                    <div class="card-body p-0">
						                        <!-- Nested Row within Card Body -->
						                        <div class="row">
						                            <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
						                            <div class="col-lg-6">
						                                <div class="p-5">
						                                    <div class="text-center">
						                                        <h1 class="h4 text-gray-900 mb-4">Member Join!</h1>
						                                    </div>
						                                    <form:form cssClass="user" modelAttribute="memberVO">
						                                        <div class="form-group">
						                                            <form:input path="username"  cssClass="form-control form-control-user"
						                                                id="username"></form:input>
						                                             <form:errors path="username"></form:errors>   
						                                        </div>
						                                        <div class="form-group">
						                                            <form:password path="password" cssClass="form-control form-control-user"
						                                                id="password" ></form:password>
						                                            <form:errors path="password"></form:errors>    
																	
						                                        </div>
						                                        <div class="form-group">
						                                            <form:password path="passwordCheck" cssClass="form-control form-control-user"
						                                                id="passwordCheck" ></form:password>
						                                            <form:errors path="passwordCheck"></form:errors>
																	
						                                        </div>

						                                        <div class="form-group">
						                                            <form:input path="phone" cssClass="form-control form-control-user"
						                                                id="phone" ></form:input>
						                                            <form:errors path="phone"></form:errors>
																	
						                                        </div>
																<div class="form-group">
						                                            <form:input path="email" cssClass="form-control form-control-user"
						                                                id="email" ></form:input>
						                                            <form:errors path="email"></form:errors>    
						                                        </div>
																<div class="form-group">
						                                            <form:input path="address" cssClass="form-control form-control-user"
						                                                id="address" ></form:input>
						                                            <form:errors path="address"></form:errors>
																	
						                                        </div>						
																<div class="form-group">
						                                            <form:input path="name" cssClass="form-control form-control-user"
						                                                id="name" ></form:input>
						                                            <form:errors path="name"></form:errors>    
																	
						                                        </div>										

																<button class="btn btn-primary btn-user btn-block">Join</button>

						                           
						                                        <hr>
						                                        <a href="index.html" class="btn btn-google btn-user btn-block">
						                                            <i class="fab fa-google fa-fw"></i> Login with Google
						                                        </a>
						                                        <a href="index.html" class="btn btn-facebook btn-user btn-block">
						                                            <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
						                                        </a>
						                                    </form:form>
						                      
						                                </div>
						                            </div>
						                        </div>
						                    </div>
						                </div>
						
						            </div>
						
						        </div>
						
						    </div>
                    
		
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
			
            <!-- Footer -->
			<c:import url="../temp/footer.jsp"></c:import>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

	<c:import url="../temp/script.jsp"></c:import>

</body>

</html>    