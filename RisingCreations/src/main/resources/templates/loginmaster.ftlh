<#macro loginmaster>
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
</head>
<body>
<div class="wrapper">
    <#nested/>
</div>
</body>
</html>
</#macro>