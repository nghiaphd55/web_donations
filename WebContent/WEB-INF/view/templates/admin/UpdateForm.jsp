<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html  lang="en">

<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>Quản trị</title>
  <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
  <link href="${pageContext.request.contextPath}/resources/admin1/assets/css/styles.css" rel="stylesheet" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
          crossorigin="anonymous"></script>
  <script src="${pageContext.request.contextPath}/resources/admin1/assets/js/scripts.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>

  <script src="${pageContext.request.contextPath}/resources/admin1/assets/js/datatables-simple-demo.js"></script>

  <script src="https://cdn.ckeditor.com/ckeditor5/29.0.0/classic/ckeditor.js"></script>
</head>
<body>
<div style="width: 50%;height: 150px; margin: 50px 50px">
   <h2>Cập nhật</h2>
   <form action="update" method="post">
     <input type="hidden" name="id" value="<c:out value='${donations.id}' />">
     <div class="row">
       <div class="col-6">
         <label for="addname"
                class="col-form-label">Mã đợt quyên góp:</label>
         <input type="text" class="form-control"
                id="addname" name="code" required
                 value="<c:out value="${donations.code}" />" >
       </div>
       <div class="col-6">
         <label for="addcost"
                class="col-form-label">Tên đợt quyên góp:</label>
         <input type="text" class="form-control"
         		value="<c:out value="${donations.name}" />"
                id="addcost" name="name" required>
       </div>
     </div>
     <div class="row">
       <div class="col-6">
         <label for="addname"
                class="col-form-label">Ngày bắt đầu:</label>
         <input type="text" class="form-control"
         		value="<c:out value="${donations.startDate}" />"
                id="addname" name="startDate" required>
       </div>
       <div class="col-6">
         <label for="addcost"
                class="col-form-label">Ngày kết thúc:</label>
         <input type="text" class="form-control"
         		value="${donations.end_date}"
                name="end_date" required>
       </div>
     </div>
     <div class="row">
       <div class="col-6">
         <label for="addname"
                class="col-form-label">Tổ chức:</label>
         <input type="text" class="form-control"
         		value="<c:out value="${donations.organizationName}" />"
                id="addname" name="organizationName" required>
       </div>
       <div class="col-6">
         <label for="addcost"
                class="col-form-label">Số điện thoại:</label>
         <input type="number" class="form-control"
         		value="<c:out value="${donations.phoneNumber}" />"
                id="addcost" name="phoneNumber" required>
       </div>
       <div class="col-12">
         <label for="addcost" class="col-form-label">Trạng thái:</label>
         <select name="status" class="form-control" id="addcost">
         	<option value="0">Mới tạo</option>
         	<option value="1">Đang quyên góp</option>
         	<option value="2">Kết thúc quyên góp</option>
         	<option value="3">Đóng quyên góp</option>
         </select>
       </div>       
       <div class="col-12">
         <label for="ct_id" class="col-form-label">Nội dung:</label>
        <textarea name="description" class="form-control" cols="50" rows="5">
		    <c:out value="${donations.description}" />
		</textarea>
       </div>
     </div>
     <div class="modal-footer">
       <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
       		<a href="listDonation">Đóng</a>
       	</button>
       <button type="submit" class="btn btn-primary">Lưu </button>
     </div>
   </form>
 </div>
</body>
</html>