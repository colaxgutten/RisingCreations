<#import "master.ftlh" as m>
<@m.master>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-6 offset-sm-3">
            <h1>Create a post below</h1>
            <form id="createPostForm" name="createPostForm" action="/post" autocomplete="off" method="POST" enctype="multipart/form-data">
            <#if _csrf??>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  
                </#if>
                <div class="form-group">
                    <label for="title">Title:</label>
                    <input name="title" type="text" class="form-control" id="title" required>
                </div>
                <div class="form-group">
                    <label for="text">Description:</label>
                    <textarea name="desc" class="form-control" rows="5" id="text"></textarea>
                </div>
                <div class="form-group">
                    <label for="img">Image:</label>
                    <input name="img" type="file" class="form-control" id="img" required>
                </div>
                <div class="form-group">
                    <label for="tag">Tags:</label>
                    <div class="autocomplete">
                    	<input name="tag" type="text" class="form-control" id="tag">
                    </div>
                </div>
                <button style="float: right;" type="submit" class="btn btn-primary">Post</button>
            </form>
        </div>
    </div>
</div>
<script defer src="/js/autocomplete.js"></script>
<style>
    * {
        box-sizing: border-box;
    }

    body {
        font: 16px Arial;
    }

    .autocomplete {
        /*the container must be positioned relative:*/
        position: relative;
        display: inline-block;
    }

    input {
        border: 1px solid transparent;
        background-color: #f1f1f1;
        padding: 10px;
        font-size: 16px;
    }

    .autocomplete-items {
        position: absolute;
        border: 1px solid #d4d4d4;
        border-bottom: none;
        border-top: none;
        z-index: 99;
        overflow-y: scroll;
        max-height: 500px;
        /*position the autocomplete items to be the same width as the container:*/
        top: 100%;
        left: 0;
        right: 0;
    }

    .autocomplete-items div {
        padding: 10px;
        cursor: pointer;
        background-color: #fff;
        border-bottom: 1px solid #d4d4d4;
    }

    .autocomplete-items div:hover {
        /*when hovering an item:*/
        background-color: #e9e9e9;
    }

</style>
</@m.master>