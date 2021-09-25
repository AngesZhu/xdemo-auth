# xdemo-auth
> 一个简单的用户管理服务，提供给大家接口测试练习用

## 使用方法
在 resources 目录下，找到 application.yml 文件
修改mysql连接地址与账号
修改redis连接地址与密码

## 打包
项目使用 maven 打包
打包可使用idea中maven工具，使用 clean -> install 的顺序打包

## 数据库
本项目数据库使用mysql和redis两个，mysql数据初始化sql为：xdemo-auth.sql

## 启动
使用 java -jar test.jar 启动
test.jar，替换为实际jar包名称

## 接口
共包含13个接口，项目中未做token拦截，可直接使用
接口文档地址：http://127.0.0.1:9000/swagger-ui/index.html#/
若在服务器上启动，则替换 127.0.0.1 为服务器IP

# 联系方式
QQ：1372526521