<%@ include file="taglib.jsp"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="links.jsp"%>
<title>Fetch-Company-Contact.Jsp</title>
</head>
<body>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" id="fonty" href="#">Hello&nbsp;${pageContext.request.userPrincipal.name}</a>
	</div>
<ul class="nav navbar-nav">
  <li>
  	<c:url var="getHomeUrl" value="/"/>
    <a href="${getHomeUrl}">Home</a>
  </li>
   <li>
   	<c:url var="addCPUrl" value="/welcome-company-product"/>
   	<a href="${addCPUrl}">Add Company Products</a>
  </li>
  <li>
  	<c:url var="getCPUrl" value="/fetch-company-product"/>
  	<a href="${getCPUrl}">Fetch Company Products</a>
  </li>
  <li>
  	<c:url var="addCCUrl" value="/welcome-company-contact"/>
  	<a href="${addCCUrl}">Add Company And Contact</a>
  </li>
  <li class="active">
  	<c:url var="getCCUrl" value="/fetch-company-contact"/>
  	<a href="${getCCUrl}">Fetch Company And Contact</a>
  </li>
</ul>
<ul class="nav navbar-nav navbar-right">
		<li>
			<c:url var="outUrl" value="/logout"/>
			<a href="${outUrl}">Logout</a>
		</li>
	</ul>
</div>
</nav>
<div class="container">
	<div class="row">
		<div class="col-md-12">
		<br/><br/>
			<h1 class="show">Company And Contact List</h1>
<br/>
<table class="table table-striped table-bordered">
  <thead class="thead-dark">
    <tr>
      <th>CompanyId</th>
      <th>Name</th>
      <th>Desc</th>
      <th>Phone</th>
      <th>City</th>
      <th>Country</th>
      <th>Product</th>
      <th>Edit</th>
      <th>Delete</th>
    </tr>
  </thead>
  <tbody> 
  <c:forEach var="companyandcontact" items="${companyAndContactList}">			
	   <tr>
	   <td><c:out value="${companyandcontact.companyId}"/></td>
	   <td><c:out value="${companyandcontact.companyName}"/></td>
	   <td><c:out value="${companyandcontact.companyDesc}"/></td>
	   <td><c:out value="${companyandcontact.companyContact.contactPhone}"/></td>
	   <td><c:out value="${companyandcontact.companyContact.contactCity}"/></td>
	   <td><c:out value="${companyandcontact.companyContact.contactCountry}"/></td>
	   <td><c:out value="${companyandcontact.companyProduct}"/></td>
       <td>
       <button type="button" class="btn btn-warning btnOne">
       		<c:url var="editUrl" value="/edit-company-contact/${companyandcontact.companyId}"/>
       		<a href="${editUrl}">Edit</a>
       	</button>
       </td>
       <td>
       <button type="button" class="btn btn-danger btnTwo">
       		<c:url var="deleteUrl" value="/delete-company-contact/${companyandcontact.companyId}"/>
       		<a href="${deleteUrl}">Delete</a>
       	</button>
       </td>
    </tr>						
</c:forEach>
  </tbody>
</table>
<br/>
		</div>
	</div>
</div>
</body>
</html>