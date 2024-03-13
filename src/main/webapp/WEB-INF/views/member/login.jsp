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
						                                        <h1 class="h4 text-gray-900 mb-4">Member Login!</h1>
						                                        
						                                        <div>
						                                        	<h3>${param.message}</h3>
						                                        </div>
						                                        
						                                    </div>
						                                    <form:form cssClass="user" modelAttribute="memberVO">
						                                        <div class="form-group">
						                                            <form:input path="username" value="${cookie.rememberId.value}"  cssClass="form-control form-control-user"
						                                                id="username"></form:input>
						                                             <form:errors path="username"></form:errors>   
						                                        </div>
						                                        <div class="form-group">
						                                            <form:password path="password" value="123456" cssClass="form-control form-control-user"
						                                                id="password" ></form:password>
						                                            <form:errors path="password"></form:errors>    
																	
						                                        </div>
						                                        
																<div class="mb-3 form-check">
																	<input type="checkbox" name="rememberMe" class="form-check-input" id="remember-me">
																	<label class="form-check-label" for="remember-me">remember-me</label>
																</div>
																
																<div class="mb-3 form-check">
																	<input type="checkbox" checked name="rememberId" class="form-check-input" id="remember-id">
																	<label class="form-check-label" for="remember-me">ID 기억하기</label>
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

    

	<c:import url="../temp/script.jsp"></c:import>
	
	<script type="text/javascript">
		history.replaceState({}, null, location.pathname);
	</script>

</body>

</html>    