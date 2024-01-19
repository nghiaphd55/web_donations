<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Quản trị</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/admin1/assets/css/styles.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<script
	src="${pageContext.request.contextPath}/resources/admin1/assets/js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
	crossorigin="anonymous"></script>

<script
	src="${pageContext.request.contextPath}/resources/admin1/assets/js/datatables-simple-demo.js"></script>

<script
	src="https://cdn.ckeditor.com/ckeditor5/29.0.0/classic/ckeditor.js"></script>
	
</head>

<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<nav th:fragment="html_nav"
			class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
			<!-- Navbar Brand-->
			<a class="navbar-brand ps-3" href="/admin/">QUẢN TRỊ</a>
			<!-- Sidebar Toggle-->
			<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
				id="sidebarToggle" href="#!">
				<i class="fas fa-bars"></i>
			</button>
			<!-- Navbar Search-->
			<form
				class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			</form>	
			
			<!-- Navbar-->
			<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
				<li class="nav-item dropdown"><a th:if="${session.admin}"
					class="nav-link dropdown-toggle" href="/admin/logout" role="button"><i
						class="fas fa-user fa-fw"></i><span> Logout</span></a>
					<ul class="dropdown-menu dropdown-menu-end"
						aria-labelledby="navbarDropdown1">
						<li><a class="dropdown-item" href="#">Settings</a></li>
						<li><a class="dropdown-item" href="#">Activity Log</a></li>
						<li>
							<hr class="dropdown-divider" />
						</li>
						<li><a class="dropdown-item" href="/logout">Logout</a></li>
					</ul></li>
			</ul>
		</nav>
	</nav>

	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<div th:fragment="html_menu" id="layoutSidenav_nav">
				<nav class="sb-sidenav accordion sb-sidenav-dark"
					id="sidenavAccordion">
					<div class="sb-sidenav-menu">
						<div class="nav">
							<a class="nav-link" href="listUser">
								<div class="sb-nav-link-icon">
									<i class="fas fa-tachometer-alt"></i>
								</div> Quản lý người dùng
							</a> <a class="nav-link" href="${pageContext.request.contextPath}/donation/listDonation">
								<div class="sb-nav-link-icon">
									<i class="fas fa-tachometer-alt"></i>
								</div> Quản lý đợt quyên góp
							</a>
						</div>
					</div>

				</nav>
			</div>
		</div>

		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">Danh sách người dùng</h1>
					<form action="${pageContext.request.contextPath}/user/search" method="post">
						<input type="text" name="searchValue" placeholder="Search" />
						<input type="submit" value="Search" />
					</form>							
					<div class="card mb-4">
						<div class="card-header">							
							<button type="button" class="btn btn-success" 
									data-bs-toggle="modal" data-bs-target="#exampleModalAdd">
								Thêm mới
							</button>
							
							<!-- Modal Add-->
							<div class="modal fade" id="exampleModalAdd" tabindex="-1"
								 aria-labelledby="exampleModalLabel" aria-hidden="true">
								<div class="modal-dialog modal-lg">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabelll">Thêm mới</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close">
											</button>
										</div>
										<div class="modal-body">
											<form method="post" action="saveUser">
												<div class="row">
													<div class="col-6">
														<label for="addname" class="col-form-label">Name:</label>
														<input type="text" class="form-control" id="addname"
															name="fullName" required>
													</div>
													<div class="col-6">
														<label for="addcost" class="col-form-label">Email:</label>
														<input type="email" class="form-control" id="addcost"
															name="email" required>
													</div>
												</div>
												<div class="row">
													<div class="col-6">
														<label for="addname" class="col-form-label">Số
															điện thoại:</label> <input type="number" class="form-control"
															id="addname" name="phoneNumber" required>
													</div>
													<div class="col-6">
														<label for="addcost" class="col-form-label">Địa
															chỉ:</label> <input type="text" class="form-control" id="addcost"
															name="address" required>
													</div>
												</div>
												<div class="row">
													<div class="col-6">
														<label for="addname" class="col-form-label">Tài
															khoản:</label> <input type="text" class="form-control"
															id="addname" name="userName" required>
													</div>
													<div class="col-6">
														<label for="addcost" class="col-form-label">Mật
															khẩu:</label> <input type="password" class="form-control"
															id="addcost" name="password" required>
													</div>
													<div class="col-6">
														<label for="ct_id" class="col-form-label">Vai trò:</label>
														<select class="form-control" id="ct_id" name="role" required>													
															<option value="1">Admin</option>
															<option value="2">User</option>
														</select>
													</div>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-bs-dismiss="modal">Đóng</button>
													<button type="submit" class="btn btn-primary">Thêm
													</button>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
							<!-- Modal Add-->							
							
						</div>				
						
						<div class="card-body">
							<table id="datatablesSimple" border="2" >
								<thead>
									<tr style="background-color: gray !important; font-size: 12px">
										<th>Họ tên</th>
										<th>Email</th>
										<th>Số điện thoại</th>
										<th>Tài khoản</th>
										<th>Vai trò</th>
										<th>Trạng thái</th>
										<th>Hành động</th>
									</tr>
								</thead>
						 <tbody>
							<!-- Dùng vòng lặp để in ra dữ  liệu -->
							<c:forEach var="user" items="${users}">
										<tr>
											<td><c:out value ="${user.fullName}" /></td>
											<td ><c:out value ="${user.email}" /></td>
											<td><c:out value ="${user.phoneNumber}" /></td>
											<td><c:out value ="${user.userName}" /></td>
											<td><c:out value="${user.role.roleName}" /></td>

											<c:choose>
											   <c:when test="${user.status == 0}">
											   	  <td style="color: #1c7430; font-weight: bold">Hoạt động</td>
											   </c:when>
											   <c:when test="${user.status == 1}">
											   	 <td style="color: red; font-weight: bold">Đã khóa</td>
											   </c:when> 
											</c:choose>																				
											
											<td style="width: 270px">					
											
												<button type="button" style="width: 80px"
													class="btn btn-success" data-bs-toggle="modal"
													th:data-bs-target="'#idModelMail'+ ${user.id}">Gửi
												</button>
																						   												
												
												<!-- Xây dựng link 'update'bằng userId -->
												<c:url var="updateLink" 
												       value="/user/showUser">
													<c:param name="userId" value="${user.id}"></c:param>
												</c:url>
												<!-- Xây dựng link 'update'bằng userId -->
													
												<!-- Nút Sửa -->
												<button type="button" style="width: 80px" class="btn btn-primary" 
													data-bs-toggle="modal" 
													data-bs-target="#exampleModal_${user.id}">
													<a href="${updateLink}" style="color: black" >Sửa</a>							
												</button>
												<!-- Nút Sửa -->
												
												<!-- Modal Update-->
												<div class="modal fade" tabindex="-1"
													id="exampleModal_${user.id}"
													aria-labelledby="exampleModalLabel"
													aria-hidden="true">
													<div class="modal-dialog modal-lg ">
														<div class="modal-content">
															<div class="modal-header">
																<h5 class="modal-title" id="exampleModalLabell">Cập nhật</h5>
																<button type="button" class="btn-close"
																	data-bs-dismiss="modal" aria-label="Close"></button>
															</div>
															<div class="modal-body">
																<form action="edit" method="post">
															
																		<input type="hidden" name="id" value="<c:out value="${user.id}" />" />											
																		<div class="row">
																			<div class="col-6">
																				<label for="addname" class="col-form-label">Họ và tên:</label> 
																				<input type="text" class="form-control" name="fullName"
																				   value="<c:out value="${user.fullName}" />" 
																				/>
																			</div>
																			<div class="col-6">
																				<label for="addcost" class="col-form-label">Email:</label>
																				<input  name="email"
																					class="form-control" 
																				    value="<c:out value="${user.email}" />"
																					id="addcost" name="email" required
																				/>
																			</div>
																		</div>
																		<div class="row">
																			<div class="col-6">
																				<label for="addname" class="col-form-label">Số điện thoại: </label>
																				<input type="number" class="form-control"
																				   id="addname" name="phoneNumber" 
																				   value="<c:out value="${user.phoneNumber}" />"
																				   required
																				/>
																			</div>
																			<div class="col-6">
																				<label for="addcost" class="col-form-label">Địa chỉ:</label> 
																					<input type="text" class="form-control" 
																					       value="<c:out value="${user.address}" />"
																					       id="addcost" name="address" required
																					/>
																			</div>
																		</div>
																		<div class="row">
																			<div class="col-6">
																				<label for="addname" class="col-form-label">Tài khoản:</label> 
																					<input type="text"
																						class="form-control" id="addname" name="userName"
																						value="<c:out value="${user.userName}" />"
																						required
																					/>
																					<!--  <input readonly type="hidden"
																					class="form-control" id="addname" name="idUser"
																					required> <input readonly type="hidden"
																					class="form-control" id="addname" name="password"
																					required> <input readonly type="hidden"
																					class="form-control" id="addname" name="status"
																					required> -->
																			</div>																																			
																			
																			<div class="col-6">
																				<label for="ct_id" class="col-form-label">Vai trò:</label> 
																				
																				<select class="form-control" id="ct_id" name="role" required value="<c:out value="${user.role}" />">													
																					<option value="1" >Admin</option>
																					<option value="2" >User</option>
																				</select>																				
																				
																			</div>
																		</div>
																		<div class="modal-footer">
																			<button type="button" class="btn btn-secondary"
																				data-bs-dismiss="modal">Đóng</button>
																			<button type="submit" class="btn btn-primary">Lưu
																			</button>
																		</div>
																
																</form>
															</div>
		
														</div>
													</div>
												</div>
												<!-- Modal Update-->													
									
												<button type="button" style="width: 80px"
													class="btn btn-warning" data-bs-toggle="modal"
													th:data-bs-target="'#idModelDetail'+${user.id}">
													Chi tiết
												</button>
												
												<c:url var="deleteLink" value="/user/delete">
													<c:param name="userId" value="${user.id}"></c:param>
												</c:url>
													
												<!-- Nút xóa  -->	
												<button type="button" style="width: 80px" class="btn btn-danger mt-1"
														data-bs-toggle="modal"
														data-bs-target="#idModelDel">
													 <a href="${deleteLink}">Xóa</a>													 
												</button>
												<!-- Nút xóa  -->
												
												<form if="${user.status == 1}"
													action="${pageContext.request.contextPath}/user/lockUp" method="post"
													style="margin-left: 85px; margin-top: -38px">										
														<input type="hidden" class="form-control" id="id"
														 name="idUser" value="${user.id}">
														<button type="submit" style="width: 80px"
														 class="btn btn-danger">Khóa</button>
												</form>
	
												<form if="${user.status == 0}"
													action="open" method="post">
													<input type="hidden" class="form-control" id="id"
														name="idUser" value="${user.id}">
													<button type="submit" style="width: 80px"
														class="btn btn-success">Mở									
													</button>
												</form>													
												
												<!-- Model Delete  -->
												<div class="modal fade" id="idModelDel"
													tabindex="-1" aria-labelledby="exampleModalLabel"
													aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header">
																<h5 class="modal-title" id="exampleModalLabel">Bạn
																	chắc chắn muốn xóa ?</h5>
																<button type="button" class="btn-close"
																	data-bs-dismiss="modal" aria-label="Close"></button>
															</div>
															<div class="modal-body"> 
																Người dùng : <span value="${user.fullName}">
																	<c:out value="${user.fullName}" />
																</span>
																<form action="/user/delete" method="get">
																	<input type="hidden" class="form-control" id="id"
																		name="idUser" th:value="${user.id}">
																	<div class="modal-footer" style="margin-top: 20px">
																		<button type="button" class="btn btn-secondary"
																			data-bs-dismiss="modal">Close</button>
																		<button type="submit" class="btn btn-danger">Xóa</button>
																	</div>
																</form>
															</div>
														</div>
													</div>
												</div>
												<!-- Model Delete -->													
														
												<div class="modal fade" th:id="'idModelMail' + ${user.id}"
													tabindex="-1" aria-labelledby="exampleModalLabel"
													aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header">
																<h5 class="modal-title" id="exampleModalLabel">
																	Gửi đến: <span th:text="${user.email}"></span>
																</h5>
																<button type="button" class="btn-close"
																	data-bs-dismiss="modal" aria-label="Close"></button>
															</div>
															<div class="modal-body">
																<form th:action="@{/ql-user/send-mail}" method="post">
																	<input type="hidden" class="form-control" id="id"
																		name="idUser" th:value="${user.id}"> <label
																		for="addname" class="col-form-label">Nội dung:</label>
																	<textarea rows="10" class="form-control" id="addname"
																		name="note"></textarea>
																	<div class="modal-footer" style="margin-top: 20px">
																		<button type="button" class="btn btn-secondary"
																			data-bs-dismiss="modal">Đóng</button>
																		<button type="submit" class="btn btn-success">Gửi</button>
																	</div>
																</form>
															</div>
														</div>
													</div>
												</div>
												<div class="modal fade" th:id="'idModelDetail' + ${user.id}"
													tabindex="-1" aria-labelledby="exampleModalLabel"
													aria-hidden="true">
													<div class="modal-dialog modal-lg">
														<div class="modal-content">
															<div class="modal-header">
																<h5 class="modal-title" id="exampleModalLabel">
																	Chi tiết : <span th:text="${user.fullName}"></span>
																</h5>
																<button type="button" class="btn-close"
																	data-bs-dismiss="modal" aria-label="Close"></button>
															</div>
															<div class="modal-body">
																<div class="row">
																	<div class="col-6">
																		<h5>Họ tên :</h5>
																		<p th:text="${user.fullName}"></p>
																		<h5>Email:</h5>
																		<p th:text="${user.email}"></p>
																		<h5>Số điện thoại:</h5>
																		<p th:text="${user.phoneNumber}"></p>
																		<h5>Tài khoản:</h5>
																		<p th:text="${user.userName}"></p>
																	</div>
 																	<%-- <div class="col-6">
																		<h5>Địa chỉ :</h5>
																		<p th:text="${user.address}"></p>
																		<h5>Vai trò:</h5>
																		<p th:text="${user.roleId}"></p>
																		<h5>Lần đăng nhập gần nhất:</h5>
																		<p th:text="${user.created}"></p>
																		<h5>Note:</h5>
																		<p th:text="${user.note}"></p>
																	</div> --%>

																</div>
															</div>
														</div>
													</div>
												</div>
											</td>
										</tr>
										
							      </c:forEach>
							    </tbody>
							</table>
							
							<!-- Hiển thị danh sách phân trang -->
						    <c:forEach var="i" begin="1" end="10">
								<a href="getAll?offset=${i}" style="text-decoration: none;" >_ ${i} » </a>				        
						    </c:forEach>									
						</div>
					</div>
				</div>
			</main>

			<script>
		

      ClassicEditor.create(document.querySelector('#editor')).then(eidt => {
        console.log("da" + eidt);
      })
              .catch(error => {
                console.error(error);
              });

    </script>
			<script>

/*       var dodai = document.getElementById("dodai").value;
      var a = parseInt(dodai);
      for(var i = 1;i<=a+10;i++){
        var name = "#editor"  + i
        ClassicEditor.create(document.querySelector(name)).then(eidt => {
          console.log("da" + eidt);
        })
                .catch(error => {
                  console.error(error);
                });
      }
 */

    </script>
			<footer th:replace="admin/fragments :: footer"
				class="py-4 bg-light mt-auto"> </footer>
		</div>
	</div>

	<script src="js/JQuery3.3.1.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>
</body>

</html>