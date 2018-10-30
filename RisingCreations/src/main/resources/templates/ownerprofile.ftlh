<#import "master.ftlh" as m/>
<#import "commentsection.ftlh" as cs>
<#import "commentform.ftlh" as cf>
<@m.master>
<div class="container-fluid">
    <div class="row">
        <div class="col-10 offset-1">
            <div class="profile">
                <img src="/profile/${profileid}/img" onclick="editImg()" class="rounded float-left img-thumbnail profileimg"
                     alt="Profile Image"
                     style="width: 200px; height: 200px; margin-right: 20px;">
                <form id="changeProfilePictureForm" name="changeProfilePictureForm" action="/profile/changeimg"
                      method="POST" enctype="multipart/form-data">
                     <#if _csrf??>
               			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                     </#if>
                    <p>Change image</p>
                    <input type="file" name="img" id="get_file" style="display: none" onchange="form.submit()">
                </form>
                <div onclick="editName()">
                	<h3>${profilename}</h3>
                </div>
                <form id="changeProfilename" name="changeProfilename" action="/profile/changename" method="POST">
                     <#if _csrf??>
               			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                     </#if>
                    <p>Change name</p>
                    <input type="string" name="name" id="get_name" style="display:none" onchange="form.submit()">
                </form>
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
            <@cf.commentform><form id="commentForm" name="commentForm" action="/profile/${profileid}" method="POST"></@cf.commentform>
            <@cs.commentsection></@cs.commentsection>
        </div>
        </div>
    </div>
</div>
<link rel="stylesheet"
      href="/css/profile.css"/>
<script defer src="/js/ownerprofile.js"></script>
</@m.master>