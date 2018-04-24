<#import "master.ftlh" as m/>
<@m.master>
<div class="container">
    <div class="row">
        <div class="col-xs-10 offset-xs-1 col-sm-8 offset-sm-2">
            <div class="profile">
                <img data-src="holder.js/200x200" class="rounded float-left img-thumbnail profileimg" alt="200x200"
                     style="width: 200px; height: 200px;"
                     src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22200%22%20height%3D%22200%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20200%20200%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_162f8788066%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A10pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_162f8788066%22%3E%3Crect%20width%3D%22200%22%20height%3D%22200%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2275.5%22%20y%3D%22104.2%22%3E200x200%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E"
                     data-holder-rendered="true">
                <h3>${profilename}</h3>
                <hr/>
            </div>
            <div class="profiledescription">
            ${profiledesc}
            </div>
            <hr/>
            <div class="comment-form">
                <form id="commentForm" name="commentForm" action="/comment" method="POST">
                    <div class="form-group">
                        <label for="comment">Comment:</label>
                        <textarea class="form-control" rows="5" id="comment" required></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary float-right">Post</button>
                </form>
            </div>
            <div class="commentsection">
                <div class="comment">
                    <img data-src="holder.js/100x100" class="rounded float-left img-thumbnail commentimg" alt="100x100" style="width: 100px; height: 100px;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22100%22%20height%3D%22100%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20200%20200%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_162f8788066%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A10pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_162f8788066%22%3E%3Crect%20width%3D%22200%22%20height%3D%22200%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2275.5%22%20y%3D%22104.2%22%3E100x100%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E"
                    <h6>
                    <b>Kari Nordmann</b>
                    </h6>
                    <div>
                    ${profilecomment}
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<style>
    .profile {
        margin-top: 10px;
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

    .comment {

    }

    .commentsection {
        border: 2px solid #9f9f9f;
        border-radius: 5px;
        padding: 10px 10px 10px 10px;
    }

    .comment-form {
        display: flow-root;
        margin-bottom: 10px;
    }

    .commentimg {
        margin-right: 7px;
    }

</style>
</@m.master>