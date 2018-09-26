<#import "master.ftlh" as m>
<@m.master>
	<div class="container">
        <div class="row">
            <div class="col-sm-8 offset-sm-2">
                <#if posts??>
                    <#list posts as post>
                    <div class="gallery">
                        <a href="/post/${post.id}">
                            <div class="desc">
                                ${post.title}
                            </div>
                        </a>
                        <img src="/post/${post.id}/img" onclick="imgclick('/post/${post.id}/img', '${post.title}')"
                             class="gallery-img">
                    </div>
                    </#list>
                </#if>
            </div>
            <div id="modal" class="custommodal">
                <span id="close" class="close-btn">&times;</span>
                <img id="modalimg" class="custommodal-content">
                <div id="caption" class="custommodal-caption"></div>
            </div>
        </div>
    </div>
    <link rel="stylesheet"
      href="css/index.css" async/>
    <script defer src="js/index.js"></script>
</@m.master>