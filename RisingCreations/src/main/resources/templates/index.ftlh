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
                            <img src="/post/${post.id}/img" onclick="imgclick('/post/${post.id}/img', '${post.title}')"
                                 class="gallery-img">
                        </a>
                    </div>
                    </#list>
                </#if>
                <!--
                <div class="gallery">
                    <a href="#">
                        <div class="desc">Example 1</div>
                    </a>
                    <img src="/example.jpeg" onclick="imgclick('/example.jpeg', 'Example 1')" class="gallery-img" width="1000px">
                </div>
                <div class="gallery">
                    <a href="#">
                        <div class="desc">Example 2</div>
                        <img src="/example2.jpg" onclick="imgclick('/example2.jpg', 'Example 2')" class="gallery-img" width="1000px">
                    </a>
                </div>
                <div class="gallery">
                    <a href="#">
                        <div class="desc">Example 3</div>
                        <img src="/example3.jpg" onclick="imgclick('/example3.jpg', 'Example 3')" class="gallery-img" width="1000px">
                    </a>
                </div>
                <div class="gallery">
                    <a href="#">
                        <div class="desc">Example 4</div>
                        <img src="/profile.png" onclick="imgclick('/profile.png', 'Example 4')" class="gallery-img" width="1000px">
                    </a>
                </div>
                -->
            </div>
            <div id="modal" class="custommodal">
                <span id="close" class="close-btn">&times;</span>
                <img id="modalimg" class="custommodal-content">
                <div id="caption" class="custommodal-caption"></div>
            </div>
        </div>
    </div>
  	<style>
        .headertext {
            padding: 20px;
        }

        .gallery-img {
            cursor: pointer;
            object-fit: cover;
            transition: 0.3s;
        }

        .gallery-img:hover {
            opacity: 0.7;
        }

        div.gallery {
            margin: 5px;
            border: 1px solid #ccc;
            float: left;
            /* width: 180px; */
        }

        div.gallery:hover {
            border: 1px solid #777;
        }

        div.gallery img {
            width: 100%;
            height: auto;
        }

        div.desc {
            padding: 15px;
            text-align: center;
        }

        .custommodal {
            display: none;
            position: fixed;
            z-index: 1;
            padding-top: 100px;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgb(0, 0, 0);
            background-color: rgba(0, 0, 0, 0.9);
        }

        .custommodal-content {
            margin: auto;
            display: block;
            max-width: 80%;
            /*max-width: 700px;*/
        }

        .custommodal-caption {
            margin: auto;
            display: block;
            /*width: 80%;*/
            /*max-width: 700px;*/
            text-align: center;
            color: #ccc;
            padding: 10px 0;
            height: 150px;
        }

        .custommodal-content, .custommodal-caption {
            -webkit-animation-name: zoom;
            -webkit-animation-duration: 0.6s;
            animation-name: zoom;
            animation-duration: 0.6s;
        }

        @-webkit-keyframes zoom {
            from {
                -webkit-transform: scale(0)
            }
            to {
                -webkit-transform: scale(1)
            }
        }

        @keyframes zoom {
            from {
                transform: scale(0)
            }
            to {
                transform: scale(1)
            }
        }

        .close-btn {
            position: absolute;
            top: 15px;
            right: 35px;
            color: #f1f1f1;
            font-size: 40px;
            font-weight: bold;
            transition: 0.3s;
        }

        .close-btn:hover,
        .close-btn:focus {
            color: #bbb;
            text-decoration: none;
            cursor: pointer;
        }

        @media only screen and (max-width: 700px) {
            .custommodal-content {
                width: 100%;
            }
        }
    </style>
    <script>
        var modal = document.getElementById('modal');
        var modalimage = document.getElementById('modalimg');
        var caption = document.getElementById('caption');

        function imgclick(url, title) {
            modal.style.display = "block";
            caption.textContent = title;
            modalimage.src = url;
        }

        var close = document.getElementById('close');

        close.onclick = function () {
            modal.style.display = "none";
        }

        $(document).keyup(function (e) {
            if (e.keyCode == 27) { // escape key maps to keycode `27`
                modal.style.display = "none";
            }
        });
    </script>
</@m.master>