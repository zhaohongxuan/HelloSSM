<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<head>
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.css" rel="stylesheet">
    <script src="//cdn.bootcss.com/jquery/3.1.0/core.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
    <script src="<%=basePath%>/static/js/vue.js" type="text/javascript"></script>

</head>
<body>
<div class="container" style="margin-top: 70px;">

    <div class="row">
        <div class="col-md-9">
            <div class="panel panel-primary">
                <!-- Default panel contents -->
                <div class="panel-heading">User List</div>
                <!-- Table -->
                <table id ="user_tb" class="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>用户名</th>
                        <th>密码</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="user in userList">
                        <td>{{user.id}}</td>
                        <td>{{user.userName}}</td>
                        <td>{{user.password}}</td>
                        <td><button class ="btn btn-sm btn-danger" v-on:click="delete(user.id)">删除</button></td>
                    <tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-6">
            <div id="userform">
                <div class="form-group">
                    <label for="userName">用户名：</label>
                    <input v-model="userName" type="text" class="form-control" id="userName">
                </div>
                <div class="form-group">
                    <label for="password">密码：</label>
                    <input v-model="password" type="password" class="form-control" id="password" placeholder="Password">
                </div>
                <button type="submit" class="btn btn-default" v-on:click="add">注册</button>
            </div>

        </div>
    </div>

</div>

<script src="<%=basePath%>/static/js/user.js" type="text/javascript"></script>
</body>
</html>
