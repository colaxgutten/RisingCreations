<#import "master.ftlh" as m/>
<#import "commentsection.ftlh" as cs>
<#import "commentform.ftlh" as cf>
<@m.master>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="profile">
                <img src="/profile/${profileid}/img" class="rounded float-left img-thumbnail profileimg"
                     alt="Profile Image"
                     style="width: 200px; height: 200px; margin-right: 20px;">
                <h3>${profilename}</h3>
                <hr/>
            </div>
            <div class="profiledescription">
                ${profiledesc}
            </div>
        </div>
    </div>
    <div class="row">
        <div style="display: inline-block; padding-bottom: 10px;">
            <hr/>
            <@cf.commentform><form id="commentForm" name="commentForm" action="/profile/${profileid}" method="POST"></@cf.commentform>
            <@cs.commentsection></@cs.commentsection>
        </div>
    </div>
</div>
<style>
    .comment-desc {
        margin-left: 10px;
    }

    .profile {
        margin-top: 10px;
    }

    .settings {
        float: right;
    }

    .profiledescription {
    }

    .form-group > label {
        font-weight: 700;
    }

    .profileimg {
        margin-top: 4px;
        margin-right: 5px;
    }

</style>
</@m.master>