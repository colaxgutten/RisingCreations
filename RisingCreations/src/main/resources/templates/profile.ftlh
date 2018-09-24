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
                                <img data-src="holder.js/100x100" class="rounded float-left img-thumbnail commentimg"
                                     alt="100x100" style="width: 100px; height: 100px;"
                                     src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22100%22%20height%3D%22100%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20200%20200%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_162f8788066%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A10pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_162f8788066%22%3E%3Crect%20width%3D%22200%22%20height%3D%22200%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2275.5%22%20y%3D%22104.2%22%3E100x100%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E">
                            </a>
                        </div>
                        <div class="media-body">
                            <h5 class="media-heading">
                                ${comment.commenter.id}
                                <small><i>Posted on <#if comment.date??>${comment.date}<#else>UNKNOWN DATE</#if></i>
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