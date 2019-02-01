<%@ include file="taglib.jsp"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="links.jsp"%>
<title>AddCompanyAndContact.Jsp</title>
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
  <li class="active">
  	<c:url var="addCCUrl" value="/welcome-company-contact"/>
  	<a href="${addCCUrl}">Add Company And Contact</a>
  </li>
  <li>
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
			<h1 class="idx">Add Company And Contact</h1>
<br/>
<c:url var="addUrl" value="/add-company-contact"/>
<form action="${addUrl}" method="post">

  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong>CompanyName&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="companyName" class="form-control" id="inputEmail3" placeholder="Enter Company Name">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong>CompanyDesc&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="companyDesc" class="form-control" id="inputEmail3" placeholder="Enter Company Desc">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong>ContactPhone&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="contactPhone" class="form-control" id="inputEmail3" placeholder="Enter Contact Phone">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong>ContactCity&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="contactCity" class="form-control" id="inputEmail3" placeholder="Enter Contact City">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong>ContactCountry&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="contactCountry" class="form-control" id="inputEmail3" placeholder="Enter Contact Country">
    </div>
  </div>
      
  <div class="form-group row">
  	<label for="inputPassword3" class="col-sm-2 col-form-label"></label>
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary btn3d btn-lg"><span class="glyphicon glyphicon-cloud"></span> CompanyContact</button>
    </div>
  </div>
</form>
		</div>
	</div>
</div>
</body>
</html>