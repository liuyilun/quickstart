<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
 
<html>
<head>
    <title>UserDemo管理</title>
</head>
 
<body>
    <c:if test="${not empty message}">
        <div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
    </c:if>
    <!--  
    <div class="row">
        <div class="span4 offset7">
            <form class="form-search" action="#">
                <label>查询条件（id）：</label> <input type="text" name="search_LIKE_id" class="input-medium" value="${param.search_LIKE_id}"> 
                <button type="submit" class="btn">Search</button>
            </form>
        </div>
        <tags:sort/>
    </div>
    -->
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead><tr><th>登录名</th><th>密码</th><th>姓名</th><th>邮箱</th><th>操作</th></tr></thead>
        <tbody>
        <c:forEach items="${userDemos}" var="userDemo">
            <tr>
                <td><a href="${ctx}/userDemo/update/${userDemo.id}">${userDemo.loginName}</a></td>
                <td>${userDemo.password}</td>
                <td>${userDemo.name}</td>
                <td>${userDemo.email}</td>
                <td><a href="${ctx}/userDemo/delete/${userDemo.id}">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
 
    <div><a class="btn" href="${ctx}/userDemo/create">创建用户</a></div>
</body>
</html>