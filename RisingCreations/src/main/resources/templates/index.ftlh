<#import "master.ftlh" as m>
<@m.master>
     <div class="container-fluid">
         <div class="col-8 offset-2">
         <#list posts as post>
             <div class="row" style="margin-bottom: 10px;">
                 <div class="col-12">
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
     </div>
    <link rel="stylesheet" href="/css/index.css"/>
    <script defer src="/js/index.js"></script>
</@m.master>