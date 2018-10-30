<#import "master.ftlh" as m>
<#import "commentsection.ftlh" as cs>
<#import "commentform.ftlh" as cf>
<@m.master>
<div class="container-fluid">
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
                         style="clear: left; margin-right: 10px;">
                </a>
                <div style="margin-top: 10px; margin-left: 10px;">
                    ${post.description}
                </div>
                <div style="display: inline-block; width: 100%; margin-top: 6px;">
                    <span class="icon-container" onclick="loveOrLike('/post/${post.id}/love', 'loveCounter', 'lovebtn', 'fa-heart fa-lg')">
                        <span id="loveCounter">${loves}</span>
                        <#if loved>
                            <i id="lovebtn" class="fas fa-heart fa-lg"></i>
                        <#else>
                            <i id="lovebtn" class="far fa-heart fa-lg"></i>
                        </#if>
                    </span>
                    <span class="icon-container" onclick="loveOrLike('/post/${post.id}/like', 'likeCounter', 'likebtn', 'fa-thumbs-up fa-lg')">
                        <span id="likeCounter">${likes}</span>
                        <#if liked>
                            <i id="likebtn" class="fas fa-thumbs-up fa-lg"></i>
                        <#else>
                            <i id="likebtn" class="far fa-thumbs-up fa-lg"></i>
                        </#if>
                    </span>
                </div>
                <div style="display: inline-block; padding-bottom: 10px;">
                    <hr/>
                    <@cf.commentform>
                    <form id="commentForm" name="commentForm" action="/post/${post.id}" method="POST"></@cf.commentform>
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

    .icon-container {
        border: #a0a0a0 solid 2px;
        padding: 4px;
        border-radius: 6px;
        margin-right: 2px;
    }

    .icon-container:hover {
        background: #969696;
        cursor: pointer;
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
<script defer src="/js/forumpost.js"></script>
</@m.master>