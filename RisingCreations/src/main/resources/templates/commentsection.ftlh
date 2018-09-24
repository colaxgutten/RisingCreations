<#macro commentsection>
    <#list comments as comment>
        <div class="media" style="margin-bottom: 16px;">
            <div class="media-left">
                <a href="/profile/${comment.profile.id}">
                    <img src="/profile/${comment.profile.id}/img"
                         class="rounded float-left img-thumbnail"
                         alt="No Image" style="width: 100px; height: 100px; margin-right: 7px;">
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
    <#nested/>
</#macro>