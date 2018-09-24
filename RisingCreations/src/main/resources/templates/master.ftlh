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

    <script defer src="/webjars/jquery/2.1.4/jquery.min.js"></script>
    <script defer src="/webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet"
          href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css" async/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">


</head>
<body>
<nav class="navbar navbar-inverse">
  <ul class="nav navbar-nav">
    <li><a href="/">Home</a></li>
    <li><a href="/profile">Profile</a></li>
  </ul>
</nav>
	 		<#nested/>

</body>
</html>
</#macro>