<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
 
<html>
<head>
    <title>UserDemo管理</title>
     
    <script>
        $(document).ready(function() {
            //聚焦第一个输入框
            $("#userDemo_loginName").focus();
            //为inputForm注册validate函数
            $("#inputForm").validate();
        });
    </script>
</head>
 
<body>
    <form id="inputForm" action="${ctx}/userDemo/save/${userDemo.id}"  method="POST" class="form-horizontal">
        <input type="hidden" name="id" value="${userDemo.id}"/>
        <fieldset>
            <legend><small>管理UserDemo任务</small></legend>
            <div class="control-group">
                <label for="userDemo_loginName" class="control-label">LoginName:</label>
                <div class="controls">
                    <input type="text" id="userDemo_loginName" name="loginName"  value="${userDemo.loginName}" class="input-large required" minlength="3"/>
                </div>
            </div>    
            <div class="control-group">
                <label for="userDemo_password" class="control-label">Password:</label>
                <div class="controls">
                    <textarea id="userDemo_password" name="password" class="input-large">${userDemo.password}</textarea>
                </div>
            </div>    
            <div class="control-group">
                <label for="userDemo_name" class="control-label">Name:</label>
                <div class="controls">
                    <textarea id="userDemo_name" name="name" class="input-large">${userDemo.name}</textarea>
                </div>
            </div>    
            <div class="control-group">
                <label for="userDemo_email" class="control-label">Email:</label>
                <div class="controls">
                    <textarea id="userDemo_email" name="email" class="input-large">${userDemo.email}</textarea>
                </div>
            </div>    
            <div class="form-actions">
                <input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;   
                <input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
            </div>
        </fieldset>
    </form>
</body>
</html>