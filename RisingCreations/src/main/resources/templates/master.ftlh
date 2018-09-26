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
    <script defer src="js/master.js"></script>
    <link rel="stylesheet"
          href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css" async/>
    <link rel="stylesheet"
          href="css/master.css" async/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">


</head>
<body>
<div class="wrapper">
    <nav id="sidebar">
        <div class="sidebar-header">
            <h3>Rising Creations</h3>
        </div>

        <ul class="list-unstyled components">
            <li id="homeli">
                <a href="/">Home</a>
            </li>
            <li id="profileli">
                <a href="/profile">Profile</a>
            </li>
        </ul>
        <div style="margin: 0 10px 0 10px;">
            <a class="btn btn-primary btn-lg btn-block" href="/post">Create Post</a>
        </div>
    </nav>
</div>
        <#nested/>

</body>
</html>
</#macro>