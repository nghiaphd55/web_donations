<% 
	String publicUrl = request.getContextPath() + "/public/home";
	String listUrl = request.getContextPath() + "/user/home";
	String listUrlDonation = request.getContextPath() + "/donation/listDonation";
	
	response.sendRedirect(listUrl);

%>

