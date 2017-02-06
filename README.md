[![Build Status](https://travis-ci.org/javaor/HelloSSM.svg?branch=master)](https://travis-ci.org/javaor/HelloSSM)

   使用Spring +Spring MVC +Mybatis 构建的简单的框架的Demo，前端界面使用`vue.js+bootstrap`，后台使用`Spring MVC Restful`控制器实现前后端分离。
   后面会使用`webpack`打包实现前端资源的部署
   具体介绍页面请点击 [使用Maven搭建Spring+SpringMVC+Mybatis+ehcache项目](http://zeusjava.com/2015/10/17/build-an-maven-spring-mybatis-ehcache-web-project)
   
## 主要功能
   1. 实现Spring、SpringMVC、Mybatis三个框架的整合
   2. 使用ehcache缓存
   3. vue.js的简单使用
   4. Maven Profile的使用，方面环境切换
   5. Mybatis Generator的使用
   

## 一、配置开发环境

配置好以下开发工具

    JDK: 1.7
    Maven:3.1.1
    Tomcat：7.0.65
    Mysql：5.5.20
    vue.js: V1.0.26
    
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
####2.生成war包
依次执行maven Lifecyle的`clean->compile->package`命令
maven会在target目录生成war包
##### Tips：
maven的设置选项 `use Maven Output Directories` 要勾选上
####3.配置Tomcat
1. 点击`Run-Run Configurations`
2. 点击`+`选择`tomcat server->local`
3. 点击`Configure` 配置好Tomcat的解压目录，端口号8081
4. 点击`Deployment选项卡`，点击`+`号，选择一个artifact，就是第二部的war包，Application Context 配置为`HelloSSM`
5. 点击 Tomcat的右边的`运行`按钮,运行tomcat
在任务栏输入`http://localhost:8081/HelloSSM/user/userInfo/1`,回车出现结果，一个简单的SSM项目环境就搭建好了。



