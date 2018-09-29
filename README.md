
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

### update2——商品管理/商品查询

1 分页插件查询

2 分页查询基于EasyUI中的数据表格datagrid控件，要求格式一个JsonObject
      //{"total":xx,"rows":[{},{},{}]}
      
3 树形表，商品类别展开基于EasyUI异步树控件，一个JsonArray

#### update3——商品管理/新增商品

使用FTP服务器作为图片服务器，新增产品操作

商品描述的保存(tb_item_desc)

商品信息和商品描述分开存储，因为商品在展示的时候可以不显示商品的描述

#### update4——商品管理/规格参数

功能板块A 规格参数这里是对参数模板的管理

功能板块B 商品参数的添加是在新增商品中管理

商品規格的添加以及使用

规格下面分为不同的分组，每一组有一堆规格型项及其规格值

规格参数：

——————>规格组1

————————————>规格项：规格值

————————————>规格项：规格值

————————————>规格项：规格值

——————>规格组2

————————————>规格项：规格值

————————————>规格项：规格值

————————————>规格项：规格值

......

同一类商品的规格项分组相同，但是每个规格组下的规格项和商品本身关联，不同商品之间也是不同的


1.a 多个表实现商品规格

每一类商品有多个分组

每个分组下有多个项目

每个商品有多个规格值

数据库一对多的关系，要分多个表

多个互相维护，查询时同样需要关联多个表查询，十分复杂

而且如果系统更新对某一类的商品规格结构修改，那么之前已经添加的商品也必须人力改变，改变整个数据库结构

十分繁琐 

1.b 使用模板实现商品规格

推荐这一种方案，使用模板的思路来解决这种需要多表关联的项目

1 每一个类别对应一个模板，这个模板中记录中group:规格组及规格组下params的多个规格项

2 利用这个模板一个一个读取生成Json格式，将Json字符串保存到数据库中。

那么我们需要一个模板表(tb_item_param)，一个类别一个模板，外键cid与商品类别表对应

一个商品规格参数表(tb_item_param_item)，存储具体的商品规格参数Json格式只和具体商品挂钩，通过商品id关联

这么存储，模板表和具体的商品规格参数表没有任何关联，不需要做多表关联查询