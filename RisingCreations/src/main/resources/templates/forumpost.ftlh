<#import "master.ftlh" as m>
<@m.master>
<div class="container">
    <div class="row">
        <div class="col-sm-8 offset-sm-2">
            <#if post??>
                <h3>
                    ${post.title}
                </h3>
                <img src="/post/${post.id}/img" class="rounded float-left img-thumbnail profileimg" alt="${post.title}"
                     style="clear: both;">
                <div style="padding-top: 10px; float: left; clear: both; width: 100%;">
                    ${post.description}
                </div>
                <div style="padding-top: 10px; float: left; clear: both; width: 100%;">
                    ${post.profile.name}
                </div>
                <div style="display: inline-block; padding-bottom: 10px; width: 100%;">
                    <hr/>
                    <div class="comment-form">
                        <form id="commentForm" name="commentForm" action="/post/${post.id}" method="POST">
                            <#if _csrf??>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </#if>
                            <div class="form-group">
                                <label for="comment">Comment:</label>
                                <textarea name="description" class="form-control" rows="5" id="comment"
                                          required></textarea>
                            </div>description
                            <button type="submit" class="btn btn-primary float-right">Post</button>
                        </form>
                    </div>
                    <#list post.comments as comment>
                    <div class="media">
                        <div class="media-left">
                            <a href="/profile/${comment.profile.id}">
                                <img src="/profile/${comment.profile.id}/img" class="rounded float-left img-thumbnail commentimg"
                                     alt="No Image" style="width: 100px; height: 100px;">
                            </a>
                        </div>
                        <div class="media-body">
                            <h5 class="media-heading">
                                ${comment.profile.id}
                                <small><i>Posted on <#if comment.date??>${comment.getFormattedDate()}<#else>UNKNOWN DATE</#if></i>
                                </small>
                            </h5>
                            <p>${comment.description}</p>
                        </div>
                    </div>
                    </#list>
                </div>
            <#else>
                <div>
                    NO CONTENT HERE
                </div>
            </#if>
        </div>
    </div>
</div>
<style>
    .commentsection {
        border: 2px solid #9f9f9f;
        border-radius: 5px;
        padding: 10px 10px 10px 10px;
    }

    h5 > small {
        font-weight: 400;
        line-height: 1;
        color: #777;
        font-size: 75%;
    }

    .comment-form {
        display: flow-root;
        margin-bottom: 10px;
    }

    .commentimg {
        margin-right: 7px;
    }
</style>
</@m.master>