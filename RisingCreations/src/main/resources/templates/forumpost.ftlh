<#import "master.ftlh" as m>
<@m.master>
<div class="container">
    <div class="row">
        <div class="col-sm-8 offset-sm-2">
            <#if post??>
                <h2>
                    ${post.title}
                </h2>
                <div style="float: left; clear: both; width: 100%;">
                    <small>
                        <i>Posted by <a href="/profile/${post.profile.id}">${post.profile.name}</a>
                            on ${post.getFormattedDate()}</i>
                    </small>
                </div>
                <a href="/post/${post.id}/img" target="_blank" class="img-link">
                    <img src="/post/${post.id}/img" class="rounded float-left img-thumbnail profileimg"
                         alt="${post.title}"
                         style="clear: both;">
                </a>
                <div style="padding-top: 10px; float: left; clear: both; width: 100%;">
                    ${post.description}
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
                                <img src="/profile/${comment.profile.id}/img"
                                     class="rounded float-left img-thumbnail commentimg"
                                     alt="No Image" style="width: 100px; height: 100px;">
                            </a>
                        </div>
                        <div class="media-body">
                            <h5 class="media-heading">
                                ${comment.profile.name}
                                <small><i>Posted on <#if comment.date??>${comment.getFormattedDate()}<#else>UNKNOWN
                                    DATE</#if></i>
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

    .img-link:hover .profileimg {
        opacity: 0.7;
    }

    .profileimg {
        opacity: 1;
        display: block;
        height: auto;
        transition: .5s ease;
        backface-visibility: hidden;
    }
</style>
</@m.master>