<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>범서의 프로젝트</title>

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
                    	<form action="" method="post" enctype="multipart/form-data">
                    		<div class="mb-3">
							  <label for="title" class="form-label">제목</label>
							  <input type="text" class="form-control" id="title" name="boardTitle">
							</div>
							
							<div class="mb-3">
							  <label for="writer" class="form-label">작성자</label>
							  <input type="text" class="form-control" id="writer" name="boardWriter">
							</div>
							
							<div class="mb-3">
							  <label for="contents" class="form-label">내용</label>
							  <textarea class="form-control" id="contents" rows="3" name="boardContents"></textarea>
							</div>
							
                            <div class="mb-3">
                                <input type="file" name="attach">
                                <input type="file" name="attach">
                                <input type="file" name="attach">
                            </div>


							<div class="mb-3">
								<button class="btn btn-danger">작성</button>
							</div>
                    	</form>
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

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

	
	<c:import url="../temp/script.jsp"></c:import>

</body>

</html>