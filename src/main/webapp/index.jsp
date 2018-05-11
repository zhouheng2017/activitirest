<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>

<head>
    <title>Activiti实战</title>
    <%@ include file="/common/global.jsp"%>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
</head>
<body>
<h2>Hello World!</h2>
<a href="/activitirest/model2/create2">model/create</a>
<a href="/activitirest/diagram-viewer/index.html?processDefinitionId=Leave:1:70004&processInstanceId=105001">diagram</a>
<br/><br/>
<a href="/activitirest/login.jsp">login</a>

<ul>
    <li><a href="${ctx}/rest/management/properties" target="_blank">引擎属性</a></li>
    <li><a href="${ctx}/rest/runtime/tasks" target="_blank">我的任务</a></li>
    <li><a href="${ctx}/rest/runtime/executions" target="_blank">我参与的流程</a></li>
    <li><a href="${ctx}/rest/management/tables" target="_blank">数据库表</a></li>
    <li><a href="${ctx}/rest/identity/users" target="_blank">用户</a></li>
    <li><a href="${ctx}/rest/identity/groups" target="_blank">组</a></li>
</ul>

<li><a target="_blank" title="不支持IE" href="${ctx}/chapter20/model/list">模型列表（在线设计流程）</a></li>
<li><a target="_blank" title="查看已经部署的流程定义" href="${ctx}/chapter5/processes">流程定义列表</a></li>
<li><a href="${ctx}/model2/create2">创建模型</a></li>

</body>
</html>
