<#macro master>
<!DOCTYPE html>
<html>
<head>
    <!-- https://bootstrapious.com/p/bootstrap-sidebar -->
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
    <script defer src="/js/master.js"></script>
    <link rel="stylesheet"
          href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css"/>
    <link rel="stylesheet"
          href="/css/master.css"/>
    <link rel="stylesheet" href="/webjars/font-awesome/5.4.1/css/all.css"/>
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
            <li id="mypostsli">
                <a href="/profile/posts">My Posts</a>
            </li>
        </ul>
        <div style="margin: 0 10px 0 10px;">
            <a class="btn btn-primary btn-lg btn-block" href="/post">Create Post</a>
        </div>
    </nav>
    <div id="content-container" style="width: 100%;">
        <#nested/>
    </div>
</div>
</body>
</html>
</#macro>