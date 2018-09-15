
## SSM + Redis 项目

### 搭建结构

1 创建普通的Maven工程，删掉src、pom，只留下.idea 和 .iml的工程配置即可

2 创建parent 父模块 （工程名_模块名）

  在其中集中定义第三方jar包、插件的版本
    
      <modules> </modules>子模块，IDEA会自动填充，可以看一下
      
      <properties> </properties>集中定义版本问题
      
      <dependencyManagement> <denpendencies> </denpendencies> </denpendencyManagement> 添加jar包依赖
      
      <bulid> <plugins> </plugins> </build> 添加插件依赖
  
  重要： 声明自身工程类型 pom
 ` <packaging>pom</packaging>`
  
  3 在parent模块下生成其他业务类子模块
  

#### 其他模块
以Common模块为例：
公共模块，工具类，通用类等
在Common下创建
POJO：存放实体类，Jar类型

mapper：Mybatis、SQL映射文件，Jar类，依赖POJO（依赖就直接在dependency中写）

pojo：提供接口，Jar类，依赖mapper

web：面向用户、业务展示，需要上传到服务器的war包，依赖Service

#### parent下的pom文件概述

junit 单元测试
spring：spring-context，spring-beans,spring-webmvc,spring-jdbc,spring-aspects
mybatis,mybatis-spring,mybatis-paginator,pagehelper
mysql
jedis Redis客户端
solrj solr客户端
log4j 日志处理
fastjson Json处理
httpclient 模块间通信web pojo
druid 连接池
jstl servlet-api jsp-api Jsp相关
joda-time 时间操作
commons-langs commons-io commons-net apache处理包
commmons-fileupload 文件上传

