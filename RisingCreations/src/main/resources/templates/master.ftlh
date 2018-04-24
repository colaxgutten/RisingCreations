<#macro master>
<!DOCTYPE html>
<html>
<head>
    <title>RisingCreations</title>
    <meta name="description" content="Forum for sharing Rising World creations">
    <meta charset="UTF-8">
    <meta name="keywords" content="Rising World, creativity, creations, gaming, forum">

    <#if _csrf??>
        <meta name="csrf_name" content="<#if _csrf.parameterName??>${_csrf.parameterName}</#if>">
        <meta name="csrf_value" content="<#if _csrf.token??>${_csrf.token}</#if>">
    </#if>

    <script src="/webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="/webjars/jquery/2.1.4/jquery.min.js"></script>
    <link rel="stylesheet"
          href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css"/>

</head>
<body>
	<div class="container-fluid">  
		<div class="row content">
			<div class="col-sm-3 sidenav">
			<div class="card" style="width: 20rem;">
  <img class="card-img-top" src="/profile.png" alt="Card image cap">
  <div class="card-body">
    <h4 class="card-title">Mikkey Mouse</h4>
    <p class="card-text">Beskrivelse og sånt</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>
			</div>
			<div class="col-sm-9">
	 		<#nested/>
	 		</div>

		</div>

</body>
</html>
</#macro>