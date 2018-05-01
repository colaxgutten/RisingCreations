<#import "master.ftlh" as m/>
<@m.master>
<div class="container">
    <div class="row">
        <div class="col-sm-6 offset-sm-3">
            <h1>Please log in</h1>
            <form id="loginForm" name="loginForm" action="/login" method="POST">
				<#if _csrf??>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  
                </#if>                 <div class="form-group">
                    <label for="username">Username:</label>
                    <input name="username" type="text" class="form-control" id="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input name="password" type="password" class="form-control" id="password" required>
                </div>
                <button style="float: right;" type="submit" class="btn btn-primary">Login</button>
            </form>
            <div>
                <a href="/register">Don't have a user?</a>
            </div>
        </div>
    </div>
</div>
</@m.master>