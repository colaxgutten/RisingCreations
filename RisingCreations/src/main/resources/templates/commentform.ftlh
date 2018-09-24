<#macro commentform>
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
    <#nested/>
</#macro>