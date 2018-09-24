<#import "master.ftlh" as m>
<#import "commentsection.ftlh" as cs>
<#import "commentform.ftlh" as cf>
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
                <div class="col-12" style="display: inline-block; padding-bottom: 10px;">
                    <hr/>
                    <@cf.commentform></@cf.commentform>
                    <@cs.commentsection></@cs.commentsection>
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