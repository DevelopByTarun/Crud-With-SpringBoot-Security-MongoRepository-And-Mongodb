<%@ include file="taglib.jsp"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="links.jsp"%>
<title>Index.Jsp</title>
</head>
<body>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" id="fonty" href="#">Hello&nbsp;${pageContext.request.userPrincipal.name}</a>
	</div>
<ul class="nav navbar-nav">
  <li class="active">
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
			<h1 class="myidx">
				Welcome To My Mongodb Crud With Mongo Repository And Also Some Interesting Features
			</h1>
			<br/><br/>
			<section>
			<ul class="myListType">
			<li>
			<h3 class="notice notice-danger">
				Spring Boot Module With Auto Configuration
			</h3>
			</li>
			<br/>
			<li>
			<h3 class="notice notice-warning">
				Spring Mvc Module With Interceptors Feature
			</h3>
			</li>
			<br/>
			<li>
			<h3 class="notice notice-info">
				Spring Aop Module With Pointcut Feature, After And Before Advices
			</h3>
			</li>
			<br/>
			<li>
			<h3 class="notice notice-dark">
				Spring Security Module With Login Logout Feature And Method Level Security
			</h3>
			</li>
			<br/>
			<li>
			<h3 class="notice notice-primary">
				Spring With Mongodb And Mongo Repository Feature
			</h3>
			</li>
			<br/>
			<li>
			<h3 class="notice notice-success">
				Some Additional Feature Logging With Log4j
			</h3>
			</li>
			</ul>
			</section>
			<br/>
		</div>
	</div>
</div>
</body>
</html>