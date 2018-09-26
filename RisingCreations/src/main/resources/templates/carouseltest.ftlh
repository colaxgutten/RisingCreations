<#import "master.ftlh" as m>
<@m.master>
<div>
    <#if posts??>
        <div id="carousel" class="carousel slide" data-ride="carousel">
            <ul class="carousel-indicators">
            <#list posts as post>
                <#if post?index == 0>
                    <li data-target="#carousel" data-slide-to="${post?index}" class="active"></li>
                <#else>
                    <li data-target="#carousel" data-slide-to="${post?index}"></li>
                </#if>
            </#list>
            </ul>
            <div class="carousel-inner">
            <#list posts as post>
                <#if post.id == posts[0].id>
                    <div class="carousel-item active">
                        <img src="/post/${post.id}/img" alt="${post.title}">
                        <div class="carousel-caption">
                            <h4>${post.title}</h4>
                        </div>
                    </div>
                <#else>
                    <div class="carousel-item">
                        <img src="/post/${post.id}/img" alt="${post.title}">
                        <div class="carousel-caption">
                            <h4>${post.title}</h4>
                        </div>
                    </div>
                </#if>
            </#list>
            </div>
            <a class="carousel-control-prev" href="#carousel" data-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </a>
            <a class="carousel-control-next" href="#carousel" data-slide="next">
                <span class="carousel-control-next-icon"></span>
            </a>
        </div>
    </#if>
</div>
    <link rel="stylesheet" href="/css/index.css" async/>
    <script defer src="/js/index.js"></script>
</@m.master>
<style>
    .carousel-item {
        margin: 0 10px 0 10px;
    }
</style>