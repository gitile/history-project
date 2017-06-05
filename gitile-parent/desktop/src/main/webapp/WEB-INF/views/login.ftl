<#assign contextPath=springMacroRequestContext.getContextPath() />
<!DOCTYPE html>
<!--[if IE 8]><html class="no-js lt-ie9" lang="zh-cn"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="zh-cn">
<!--<![endif]-->
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <title>登录页面 - 后台管理系统</title>
    <link rel="shortcut icon" href="${contextPath}/static/images/logo.png">
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/simple-line-icons.min.css?version=20150429" media="screen" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/common.css?version=20150429" media="screen" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/login.css?version=20150429" media="screen" />
</head>
<body>
    <div id="ui-preloader">
		<div id="ui-preloader-panel" class="ui-preloader-panel">
			<div class="ui-preload-title">
				<img src="${contextPath}/static/images/logo.png" height="30px" style="margin-top:-5px;margin-right: 10px;"><small>与众不同的Web体验</small>
			</div>
			<div class="ui-preload-progress">
				<img class="ui-preloader-icon" src="${contextPath}/static/images/loading.gif"> <span id="ui-preloader-text" class="ui-preloader-text">正在加载中...</span>
			</div>
		</div>
	</div>
	<div id="header">
		<div class="container">
        	<div class="left">欢迎使用XXXXXXX！</div>
            <div class="right">服务电话：0571-000000</div>
        </div>
	</div>
	<div id="ui-login">
		<div class="container">
			<a class="login-banner"></a>
			<div class='login-box'>
				<form method="post">
		        	<header>管理员请登录<a></a></header>
		            <section>
		            	<dl>
		                	<dd>
		                    	<label for="username"></label>
		                        <input id="username" name="username" type="text" placeholder="用户名" >
		                    </dd>
		                	<dd>
		                    	<label for="password"></label>
		                        <input id="password" name="password" type="password" placeholder="密码" >
		                	</dd>
		                	<#if refurl?exists>
			            		<input type="hidden" id="refurl" value="${refurl!''}">
			            	<#else>
			            		<input type="hidden" id="refurl" value="${contextPath}/index">
			            	</#if>
		                    <dd id="checkCodeDiv" data-target="0">
				            	<input id='checkCode' name='checkCode' class="check_code" type="text" placeholder="验证码" /> <img id="checkCodeImage" />
		                	</dd>
		                </dl>
		                <button type="button" id="submit" />
		            </section>
				</form>
			</div>
		</div>
	</div>
    <script src="${contextPath}/static/js/libs/jquery-2.1.3.min.js?version=20150429"></script>
    <script src="${contextPath}/static/js/libs/jquery.backstretch.min.js?version=20150429"></script>
    <script src="${contextPath}/static/js/common.js?version=20150429"></script>
    <script src="${contextPath}/static/js/login.js?version=20150429"></script>
</body>
</html>