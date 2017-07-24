<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>

    <meta charset="utf-8">
    <title>实验室登陆界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS -->
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
    <link rel="stylesheet" href="/static/assets/css/reset.css">
    <link rel="stylesheet" href="/static/assets/css/supersized.css">
    <link rel="stylesheet" href="/static/assets/css/style.css">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<body>

<div class="page-container">
    <h1 style="color: black">实验室登陆</h1>
    <form action="/user/login" method="post">
        <input type="number" name="userName" class="username" placeholder="输入学号">
        <input type="password" name="password" class="password" placeholder="输入密码">
        <div>${msg}</div>
        <button type="submit">登录</button>
        <div class="error"><span>+</span></div>
    </form>
</div>

<!-- Javascript -->
<script src="/static/assets/js/jquery-1.8.2.min.js"></script>
<script src="/static/assets/js/supersized.3.2.7.min.js"></script>
<script src="/static/assets/js/supersized-init.js"></script>
<script src="/static/assets/js/scripts.js"></script>

</body>
<script>

</script>
</html>
