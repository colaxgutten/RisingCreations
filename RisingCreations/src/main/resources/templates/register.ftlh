<#import "master.ftlh" as m />
<@m.master>
<div class="container">
    <div class="row">
        <div class="col-sm-6 offset-sm-3">
            <h1>Please register below</h1>
            <form id="loginForm" name="loginForm" action="/register" method="POST">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input name="username" type="text" class="form-control" id="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input name="password" type="password" class="form-control" id="password" required>
                </div>
                <button style="float: right;" type="submit" class="btn btn-primary">Register</button>
            </form>
            <div>
                <a href="/login">Already have a user?</a>
            </div>
        </div>
    </div>
</div>
</@m.master>
