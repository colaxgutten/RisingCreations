<#import "master.ftlh" as m/>
<#import "commentsection.ftlh" as cs>
<#import "commentform.ftlh" as cf>
<@m.master>
<div class="container">
    <div class="row">
        <div class="col-12">
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
        <div class="col-12" style="display: inline-block; padding-bottom: 10px;">
            <hr/>
            <@cf.commentform><form id="commentForm" name="commentForm" action="/profile/${profileid}" method="POST"></@cf.commentform>
            <@cs.commentsection></@cs.commentsection>
        </div>
    </div>
</div>
<script>
function editName() {
	document.getElementById("get_name").style.display="block";
}
function editImg() {
	document.getElementById("get_file").style.display="block";
}
</script>
<style>
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

    .profileimg:hover {
        cursor: pointer;
    }

</style>
</@m.master>