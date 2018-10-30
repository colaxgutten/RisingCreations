<#import "master.ftlh" as m>
<@m.master>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-6 offset-sm-3">
            <h1>Create a post below</h1>
            <form id="createPostForm" name="createPostForm" action="/post" method="POST" enctype="multipart/form-data">
            <#if _csrf??>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  
                </#if>
                <div class="form-group">
                    <label for="title">Title:</label>
                    <input name="title" type="text" class="form-control" id="title" required>
                </div>
                <div class="form-group">
                    <label for="text">Description:</label>
                    <textarea name="desc" class="form-control" rows="5" id="text"></textarea>
                </div>
                <div class="form-group">
                    <label for="img">Image:</label>
                    <input name="img" type="file" class="form-control" id="img" required>
                </div>
                <button style="float: right;" type="submit" class="btn btn-primary">Post</button>
            </form>
        </div>
    </div>
</div>
</@m.master>