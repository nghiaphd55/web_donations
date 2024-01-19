<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
    <head>
        <title>Donation website &mdash; Website Donation</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <meta name="author" content="Free-Template.co" />
        <link rel="shortcut icon" href="ftco-32x32.png">
        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/assets/css/custom-bs.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/assets/css/jquery.fancybox.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/assets/css/bootstrap-select.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/assets/fonts/icomoon/style.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/assets/fonts/line-icons/style.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/assets/css/animate.min.css">
      
        <!-- MAIN CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/assets/css/style.css">
        
        <script src="${pageContext.request.contextPath}/resources/user/assets/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/user/assets/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/user/assets/js/isotope.pkgd.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/user/assets/js/stickyfill.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/user/assets/js/jquery.fancybox.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/user/assets/js/jquery.easing.1.3.js"></script>
    
        <script src="${pageContext.request.contextPath}/resources/user/assets/js/jquery.waypoints.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/user/assets/js/jquery.animateNumber.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/user/assets/js/owl.carousel.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/user/assets/js/bootstrap-select.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/user/assets/js/custom.js"></script>
    
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
                crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
      
    </head>
<body id="top">

<div id="overlayer"></div>
<div class="loader">
    <div class="spinner-border text-primary" role="status">
        <span class="sr-only">Loading...</span>
    </div>
</div>
<div th:if="${msg}" class="toast" data-delay="1000" style="position:fixed; top: 100PX; left: 40PX;z-index: 2000;width: 300px">

    <script>
        // swal({
        //     title: 'Donate Successfully!',
        //     /* text: 'Redirecting...', */
        //     icon: 'success',
        //     timer: 3000,
        //     buttons: true,
        //     type: 'success'
        // })
    </script>
</div>

<div class="site-wrap">

    <div class="site-mobile-menu site-navbar-target">
        <div class="site-mobile-menu-header">
            <div class="site-mobile-menu-close mt-3">
                <span class="icon-close2 js-menu-toggle"></span>
            </div>
        </div>
        <div class="site-mobile-menu-body"></div>
    </div> <!-- .site-mobile-menu -->


    <!-- NAVBAR -->
    <header class="site-navbar mt-3">
        <div class="container-fluid">
            <div class="row align-items-center">
              <div class="site-logo col-6"><a href="/">Website Quyên Góp</a></div>
      
            </div>
          </div>
    </header>

    <!-- HOME -->
    <section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
        <div class="container">
            <div class="row">
                <div class="col-md-7">
                    <h1 class="text-white font-weight-bold">Danh sách các đợt quyên góp</h1>

                </div>
            </div>
        </div>
    </section>
    <section class="site-section">
        <div class="container">

            <div class="row mb-5 justify-content-center">
                <div class="col-md-7 text-center">
                    <h2 class="section-title mb-2" >Các đợt quyên góp</h2>
                </div>
            </div>

            <ul class="job-listings mb-5">

	                    <!-- Modal -->
                        <div class="modal-content">
                            <div class="modal-header">
                            	
                                <h5 class="modal-title" >
                                	Quyên góp:
                                </h5> 
                                
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form method="post" action="saveUserDonation">
                                <div class="modal-body">
                                    <div class="row">
										
										<div class="col-12">
											<label for="addname"
                                                   class="col-form-label">Donation ID:</label>
											<input type="number" class="form-control" 
												   name="donationId">										
										</div>
										<div class="col-12">
											<label for="addname"
                                                   class="col-form-label">User ID:</label>
											<input type="number" name="userId" class="form-control"   >
										</div>
										<div class="col-12">
											<label for="addname"
                                                   class="col-form-label">Ngày tháng năm:</label>
											<input type= date name="created" class="form-control" >
										</div>
                                        <div class="col-12">
                                            <label for="addname"
                                                   class="col-form-label">Họ tên:</label>
                                            <input type="text" class="form-control" 
                                                   id="addname" name="name" placeholder="Họ tên" required>
                                            <label for="addname"
                                                   class="col-form-label">Số tiền quyên góp:</label>
                                            <input type="number" class="form-control" placeholder="Số tiền quyên góp:"
                                                   id="addname" name="money" required>
                                            <input type="hidden" class="form-control" placeholder=""
                                                   id="addname" name="idUser" >
                                            <input type="hidden" class="form-control" placeholder=""
                                                   id="addname" name="idDonation" required>                                            
                                            
                                            <label for="addname"
                                                   class="col-form-label">Lời nhắn:</label>
                                            <textarea rows="10" cols="3" class="form-control" name="text"></textarea>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                        	<a href="home">Đóng</a>
                                        </button>
                                        <button type="submit" class="btn btn-primary">
                                        	Quyên góp
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>   
                <script>
                    function detail(id){
                        window.location = '/donation/detail/' + id;
                    }
                </script>
            </ul>

            <div class="row pagination-wrap">
                <div class="col-md-6 text-center text-md-left mb-4 mb-md-0">

                </div>
                <div class="col-md-6 text-center text-md-right">
                    <div class="custom-pagination ml-auto">
                        <a class="prev">Prev</a>
                        <div class="d-inline-block">
                        </div>
                        <a class="next">Next</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>