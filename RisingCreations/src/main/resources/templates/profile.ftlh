<#import "master.ftlh" as m/>
<#import "commentsection.ftlh" as cs>
<#import "commentform.ftlh" as cf>
<@m.master>
<div class="container-fluid">
    <div class="row">
        <div class="col-10 offset-1">
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
        <div class="col-10 offset-1">
            <div style="display: inline-block; padding-bottom: 10px;">
                <hr/>
                <@cf.commentform>
                <form id="commentForm" name="commentForm" action="/profile/${profileid}" method="POST"></@cf.commentform>
                    <@cs.commentsection></@cs.commentsection>
            </div>
        </div>
    </div>
</div>
<link rel="stylesheet"
      href="/css/profile.css"/>
</@m.master>