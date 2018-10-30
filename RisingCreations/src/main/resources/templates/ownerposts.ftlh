<#import "master.ftlh" as m/>
<@m.master>
<div class="container-fluid">
    <#list posts as post>
        <div class="row" style="margin-bottom: 10px">
            <div class="col-6 offset-3">
                <div class="card">
                    <div class="card-header"><a href="/post/${post.id}">${post.title}</a></div>
                    <div class="card-body">
                        <img src="/post/${post.id}/img" class="rounded mx-auto d-block" width="100%" height="100%"
                             alt="${post.title}">
                    </div>
                </div>
            </div>
        </div>
    </#list>
</div>
<script defer src="/js/ownerposts.js"></script>
</@m.master>