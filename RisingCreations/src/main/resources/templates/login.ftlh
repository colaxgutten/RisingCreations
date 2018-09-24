<#import "master.ftlh" as m/>
<@m.master>
<div class="container">
    <div class="row">
        <div class="col-sm-6 offset-sm-3">
            <div class="login-box">
                <h1>Please log in</h1>
                <form id="loginForm" name="loginForm" action="/login" method="POST">
				<#if _csrf??>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </#if>
                    <div class="form-group">
                        <label for="username">Username:</label>
                        <input name="username" type="text" class="form-control input-opaque" id="username" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input name="password" type="password" class="form-control input-opaque" id="password"
                               required>
                    </div>
                    <button style="float: right;" type="submit" class="btn btn-primary">Login</button>
                </form>
                <div>
                    <a href="/register">Don't have a user?</a>
                </div>
            </div>
        </div>
    </div>
</div>
<style>
    .login-box {
        padding: 10px 20px 25px 20px;
        border-radius: 10px;
        background: white;
        opacity: 0.9;
    }

    .input-opaque {
        opacity: 0.9;
    }

    body {
        background-image: url("risingWorldBackground.jpg");
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>
</@m.master>