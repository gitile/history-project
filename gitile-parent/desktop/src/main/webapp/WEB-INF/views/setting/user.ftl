<#assign contextPath=springMacroRequestContext.getContextPath() />
<#import "/layout/setting.ftl" as dk>
<@dk.head "账号管理">
</@dk.head>

<@dk.defaultFrame 1>
<div class='main'>
	<a class="create button">添加账号</a>
	<div class='h1'><i class="font-icon icon-user"></i>账号管理</div>
	<div id="userDiv" class="section"></div>
</div>
</@dk.defaultFrame>

<@dk.end>
	<script src="${contextPath}/static/js/common/common.js"></script>
	<script src="${contextPath}/static/js/setting/user.js"></script>
</@dk.end>