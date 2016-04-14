
[![Apache 2](http://img.shields.io/badge/license-Apache%202-red.svg)](http://www.apache.org/licenses/LICENSE-2.0)

   使用构建的简单的框架的Demo，界面是简单jsp页面，没有使用样式，开发过程中，使用最多的还是作为后台和前端或者APP客户端进行交互，最主要的还是后台功能，所以页面上没有去在意，
   后期会逐渐使用`vue.js+bootstrap`和`Spring MVC Restful`控制器实现前后端分离。
   
## 主要功能
   1. 实现Spring、SpringMVC、Mybatis三个框架的整合
   2. 使用ehcache缓存
   3. Mybatis Generator的使用
   

## 一、配置开发环境

配置好以下开发工具

    JDK: 1.7
    Maven:3.1.1
    Tomcat：7.0.65
    Mysql：5.5.20
    
Fork项目Clone到本地

## 二.创建数据库表

### 1.本地安装好mysql数据库，使用自带的`test`数据库，或者新建数据库

    jdbc.driverClassName=com.mysql.jdbc.Driver
    jdbc.url=jdbc:mysql://localhost:3307/test
    jdbc.username=root
    jdbc.password=root


### 2.在数据库中创建表

```sql

  CREATE TABLE `user` (  
  `id` int(11) NOT NULL AUTO_INCREMENT,  
  `user_name` varchar(40) NOT NULL,  
  `password` varchar(255) NOT NULL,  
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;  
  
insert  into `user`(`user_name`,`password`) values ('赵宏轩','123456');  
insert  into `user`(`user_name`,`password`) values ('赵小轩','123456');  
```




## 三.添加tomcat服务器并部署war包
####1.`File-Project Structure`点击`Artifacts`一栏
点击`+`，选择`Web-Application-Exploded`然后选择from maven选中本项目
Web Application Exploded是没有压缩的war包，相当于文件夹
Web Application Achieved是压缩后的war包
![tomcat](http://i13.tietuku.com/39c29f83a1e66eda.png)

####2.生成war包
依次执行maven Lifecyle的`clean->compile->package`命令
maven会在target目录生成war包
Tips：
maven的设置选项 `use Maven Output Directories` 要勾选上
####3.点击`Run-Run Configurations`
点击`+`选择`tomcat server->local`
![tomcat](http://i13.tietuku.com/703c0105327e168d.png)
![tomcat](http://i13.tietuku.com/9277871664046bc8.png)
####4.点击`Configure`
![tomcat](http://i13.tietuku.com/41644246a4f5a562.png)

###5.点击`Deployment选项卡`，点击`+`号，选择一个artifact，就是第二部的war包
![tomcat](http://i13.tietuku.com/6eaacb039997ba33.png)

###6.OK启动服务器
在任务栏输入`http://localhost:8081/HelloSSM/user/userInfo/1`,回车，结果如下：
一个简单的SSM项目环境就搭建好了。
![tomcat运行结果](http://i11.tietuku.com/51e0b1e59d159108.png)
