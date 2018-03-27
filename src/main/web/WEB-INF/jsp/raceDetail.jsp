<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/statics/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="${pageContext.request.contextPath}/statics/gentelella-master/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<!-- NProgress -->
<link href="${pageContext.request.contextPath}/statics/gentelella-master/vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- Animate.css -->
<link href="${pageContext.request.contextPath}/statics/gentelella-master/documentation/css/animate.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="${pageContext.request.contextPath}/statics/gentelella-master/build/css/custom.min.css" rel="stylesheet">
<html lang="zh-CN"><head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title>北京梦之兴文化发展有限公司</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="/statics/css/lib.css">
    <link rel="stylesheet" href="/statics/css/style.css">
    <link rel="stylesheet" href="/statics/css/less.css">
    <script type="text/javascript" src="/statics/js/jquery.js"></script>
    <script type="text/javascript" src="/statics/js/lib.js"></script>
    <script type="text/javascript" src="/statics/js/slick1.min.js"></script>
    <script src="/statics/js/jquery-1.js" type="text/javascript"></script>

    <link rel="stylesheet" href="/statics/css/ft-carousel.css" />
    <style>
        body{margin: 0;font-family: "微软雅黑";}
        .example {width: 100%;height: 767px;font-size: 40px;text-align: center;background-color: #FF8400;}
        .carousel-item{line-height: 336px;color: #fff;font-family:  Arial Black}
    </style>
    <%@include file="basic.jsp"%>
</head>


<body><link href="/statics/css/jiathis_share.css" rel="stylesheet" type="text/css">

<!-- 头部 -->
<div class="header">
    <div class="wp">
        <div class="logo">
            <a href="http://www.dreamculture.cn/">
                <img src="/fileImages/201710181346121.png" alt="">
            </a>
        </div>
        <div class="info">全国咨询热线<span>010-25872587 / 25252525</span></div>
        <div class="c"></div>
        <!-- 手机导航触发按钮 -->
        <span class="menuBtn">
            <em class="em1"></em>
            <em class="em2"></em>
            <em class="em3"></em>
        </span>
        <!-- 手机导航触发按钮 end -->
    </div>


    <!-- 导航 -->
    <%@include file="topTitle.jsp"%>
    <!-- 导航 end -->
</div>
<!-- 头部 end -->
<div>
    <h1>${news.title}</h1>
</div>
<div>
    ${news.newsContent}
</div>
<div>
    <button class="btn btn-info"  id="membersLogin">会员报名</button>
    <button class="btn btn-info"  id="noMembersLogin">游客报名</button>
    <button class="btn btn-info"  id="downLoad">下载文件</button>
</div>












<!-- 底部 -->
<div class="footer">
    <div class="wp">
        <div class="fd-logo">
            <a href="http://www.dreamculture.cn/">
                <img src="/fileImages/201710181346121.png" alt="">
            </a>
        </div>
        <div class="qr">
            <div class="q1"><img src="/fileImages/201710181346131.png" alt="">
                <p>微信公众号</p>
            </div>
            <div class="q2"><img src="/fileImages/201710181346131.png" alt="">
                <p>官方网站</p>
            </div>
        </div>
        <dl class="dl-nv">
            <dt>免责声明</dt>
            <dd>
                <a href="">&gt; 法律法规</a>
                <a href="">&gt; 人才招聘</a>
                <a href="">&gt; 广告服务</a>
            </dd>
        </dl>
        <dl class="dl-info">
            <dt>联系我们</dt>
            <dd>
                <p>电话：010-58554852 / 65403834</p>
                <p>邮箱：1635941948@qq.com</p>
                <p>地址：北京市朝阳区建国路乙10号（茶家屯南1号院）</p>
            </dd>
        </dl>
        <div class="fd-share">
            <!-- <span>分享</span> -->
            <!-- JiaThis Button BEGIN -->
            <!-- <div class="jiathis_style_32x32">
                <a class="jiathis_button_tsina"></a>
                <a class="jiathis_button_weixin"></a>
                <a class="jiathis_button_cqq"></a>
            </div> -->
            <!-- JiaThis Button END -->
        </div>
        <div class="c"></div>
    </div>
    <div class="copy">
        <div class="wp">
            Copyright©2018 北京赢创技术科技有限公司 版权所有
        </div>
    </div>
</div>
<input type="hidden" name="raceId" value="${raceId}"/>
<!-- 底部 end -->



<div class="modal fade" tabindex="-1" role="dialog" id="membersLoginModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">会员登录</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="loginForm">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户名:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="userName" placeholder="用户名"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">密码:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="password" placeholder="密码"/>
                        </div>
                    </div>


                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" name="loginButton">登录</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




<div class="modal fade" tabindex="-1" role="dialog" id="addApply">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">报名确认</h4>
            </div>
            请确定报名信息!
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" name="addApplyButton">报名</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->



<div class="modal fade" tabindex="-1" role="dialog" id="noMembersAddApply">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">填写报名信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="informationForm">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">姓名</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="playerName" placeholder="姓名"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">性别</label>
                        <div class="col-sm-9">
                            <select name="sex" class="form-control">
                                <option value="0">男</option>
                                <option value="1">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">电话号码</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="phoneNumber" placeholder="电话号码"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">邮箱</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="Email" placeholder="邮箱"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">身份证</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="idNumber" placeholder="身份证"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">病史</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="sick" placeholder="病史"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">紧急联系人</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="dangerName" placeholder="紧急联系人"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">紧急联系电话</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="dangerPhone" placeholder="紧急联系电话"/>

                        </div>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" name="addInformationButton">报名</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




</body>
<script type="text/javascript">
    $(function () {
        $("#alipay").click(function () {
            var informationId="${informationId}";
            location.href="/wappay/pay.jsp";
            $.post("${pageContext.request.contextPath}/alipay/toPay",{"informationId":informationId},function (data) {
                
            })
        });

        $("#membersLogin").click(function () {
            $("#membersLoginModal").modal("show");
        });


        $("button[name='loginButton']").click(function () {
            var members = $("#loginForm").serialize();
            $.post("${pageContext.request.contextPath}/members/login",members,function (data) {
                var msgCode = data.code;
                if(msgCode=="0000"){
                    alert("登录成功")
                    $("#membersLoginModal").modal("hide");
                    $("#addApply").modal("show");
                }else{
                    alert("登录失败");
                    $("#membersLoginModal").modal("hide");
                    location.href = location.href;
                }

            });

        })
        $("button[name='addApplyButton']").click(function () {
            var raceId = $("input[name='raceId']").val();
            $.post("${pageContext.request.contextPath}/apply/addApplyByMember",{"raceId":raceId},function (data) {
                var applyCode = data.applyCode;
                var msg = data.msg;
                alert(msg);
                $("#addApply").modal("hide");
                if(msg=="该用户已经报名,无法重复报名"){
                    location.href = location.href;
                }else{
                    location.href = "${pageContext.request.contextPath}/alipay/toPay?applyCode="+applyCode;
                }

            });
        })

        $("#noMembersLogin").click(function () {
            $("#noMembersAddApply").modal("show");
        })
        $("button[name='addInformationButton']").click(function () {
            var playerName = $("input[name='playerName']").val();
            var sex = $("select[name='sex']").val();
            var phoneNumber = $("input[name='phoneNumber']").val();
            var Email = $("input[name='Email']").val();
            var sick = $("input[name='sick']").val();
            var dangerName = $("input[name='dangerName']").val();
            var idNumber = $("input[name='idNumber']").val();
            var dangerPhone = $("input[name='dangerPhone']").val();
            var raceId = $("input[name='raceId']").val();


            $.post("${pageContext.request.contextPath}/apply/addApplyByNoMember",
                {"playerName":playerName,"sex":sex,"phoneNumber":phoneNumber,"Email":Email,"sick":sick,"dangerName":dangerName,"idNumber":idNumber,"dangerPhone":dangerPhone,"raceId":raceId},
                function (data) {
                    alert(data);
                    $("#noMembersAddApply").modal("hide");
                    location.href = location.href;
                })
        })


        $("#downLoad").click(function () {
            var raceId = $("input[name='raceId']").val();
            location.href="${pageContext.request.contextPath}/race/downLoadRaceFile?id="+raceId;
        });



    })
</script>
</html>