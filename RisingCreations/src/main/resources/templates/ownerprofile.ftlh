<#import "master.ftlh" as m/>
<#import "commentsection.ftlh" as cs>
<#import "commentform.ftlh" as cf>
<@m.master>
<div class="container-fluid">
    <div class="row">
        <div class="col-10 offset-1">
            <div class="profile">
                <img src="/profile/${profileid}/img" onclick="editImg()"
                     class="rounded float-left img-thumbnail profileimg ownerimg"
                     alt="Profile Image"
                     style="width: 200px; height: 200px; margin-right: 20px;">
                <form id="changeProfilePictureForm" name="changeProfilePictureForm" action="/profile/changeimg"
                      method="POST" enctype="multipart/form-data">
                     <#if _csrf??>
               			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                     </#if>
                    <input type="file" name="img" id="get_file" style="display: none" onchange="form.submit()">
                </form>
                <div id="namecontainer" onclick="editName()">
                    <h3 id="name">${profilename}</h3>
                </div>
                <form id="changeProfilename" name="changeProfilename" action="/profile/changename" method="POST">
                     <#if _csrf??>
               			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                     </#if>
                    <input type="text" name="name" id="get_name" style="display:none" onchange="form.submit()"
                           onfocusout="cancelName()">
                </form>
                <hr/>
            </div>
            <div id="desccontainer" class="profiledescription" onclick="editDesc()">
                <span id="desc">${profiledesc}</span>
            </div>
            <form id="changeProfileDescription" name="changeProfileDescription" action="/profile/changedesc"
                  method="POST" style="overflow: hidden;">
                <#if _csrf??>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </#if>
                <div class="form-group">
                    <textarea class="form-control" rows="4" type="text" name="desc" id="get_desc"
                                  style="display:none" onchange="form.submit()" onfocusout="cancelDesc()"></textarea>
                </div>
            </form>
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
<script defer src="/js/ownerprofile.js"></script>
</@m.master>