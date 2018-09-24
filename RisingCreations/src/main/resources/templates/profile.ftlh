<#import "master.ftlh" as m/>
<@m.master>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="profile">
                <img src="/profile/${profileid}/img" class="rounded float-left img-thumbnail profileimg" alt="Profile Image"
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
        <div class="col-12" style="display: inline-block; padding-bottom: 10px;">
            <hr/>
            <div class="comment-form">
                <form id="commentForm" name="commentForm" action="/profile/${profileid}" method="POST">
                            <#if _csrf??>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </#if>
                    <div class="form-group">
                        <label for="comment">Comment:</label>
                        <textarea name="description" class="form-control" rows="5" id="comment" required></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary float-right">Post</button>
                </form>
            </div>
                    <#list comments as comment>
                    <div class="media">
                        <div class="media-left">
                            <a href="/profile/${comment.commenter.id}">
                                <img src="/profile/${comment.profile.id}/img" class="rounded float-left img-thumbnail commentimg"
                                     alt="No Image" style="width: 100px; height: 100px;">
                            </a>
                        </div>
                        <div class="media-body">
                            <h5 class="media-heading">
                                ${comment.commenter.id}
                                <small><i>Posted on <#if comment.date??>${comment.getFormattedDate()}<#else>UNKNOWN DATE</#if></i>
                                </small>
                            </h5>
                            <p>${comment.description}</p>
                        </div>
                    </div>
                    </#list>
        </div>
    </div>
</div>
<style>
    .profile {
        margin-top: 10px;
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