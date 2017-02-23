<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<title>用户管理</title>
<head>
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.css" rel="stylesheet">
    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
    <script src="//cdn.bootcss.com/vue/1.0.26/vue.js"></script>

</head>
<body>
<div class="container" style="margin-top: 70px;">


    <div class="row">
        <div class="col-md-9">
            <div class="panel panel-primary">
                <!-- Default panel contents -->
                <div class="panel-heading">用户列表</div>
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
                        <td><button class ="btn btn-sm btn-danger" v-on:click="deleteUser(user.id)">删除</button></td>
                    <tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="col-md-3">
            <div class="panel panel-primary">
                <div class="panel-heading">用户注册</div>
                <div class="panel-body">
                    <div id="userform">
                        <div class="form-group">
                            <label for="userName">用户名：</label>
                            <input v-model="userName" type="text" class="form-control" id="userName">
                        </div>
                        <div class="form-group">
                            <label for="password">密码：</label>
                            <input v-model="password" type="password" class="form-control" id="password"
                                   placeholder="Password">
                        </div>
                        <button type="submit" class="btn btn-default" v-on:click="addUser">注册</button>
                    </div>
                </div>
            </div>
        </div>

    </div>

</div>

</div>

<script src="<%=basePath%>/static/js/user.js" type="text/javascript"></script>
</body>
</html>
