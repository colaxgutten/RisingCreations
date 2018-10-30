<#import "loginmaster.ftlh" as m />
<@m.loginmaster>
<div class="parent">
    <div class="child">
        <div class="login-box">
            <h1>Please register below</h1>
            <form id="loginForm" name="loginForm" action="/register" method="POST">
                <#if _csrf??>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </#if>
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input name="username" type="text" class="form-control input-opaque" id="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input name="password" type="password" class="form-control input-opaque" id="password" required>
                </div>
                <button style="float: right;" type="submit" class="btn btn-primary">Register</button>
            </form>
            <div>
                <a href="/login">Already have a user?</a>
            </div>
        </div>
    </div>
</div>
<link rel="stylesheet"
      href="/css/login.css"/>
</@m.loginmaster>