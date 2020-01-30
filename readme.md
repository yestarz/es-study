学习笔记：

https://www.yuque.com/gaohanghang/vx5cb2/aa576g#HuZ1N

1. ES对比MySQL


MySQL | ES
---|---
Database | Index
Table | Type
Row | Document
Column | Field
Schema | Mapping


Mysql :

```sql
select * from user_.user_info where name = "张三"
```

ES:

```http request
GET /user/user_info/_search?q=name:张三
```


2. 下载es

https://www.elastic.co/cn/downloads/past-releases/elasticsearch-6-3-1

下载zip包，解压


linux安装：



```shell

adduser es
passwd es

wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-6.3.1.tar.gz

tar -zxvf elasticsearch-6.3.1.tar.gz

#修改conf目录下的elasticsearch.yml
#增加配置：
network.bind_host: 0.0.0.0

#切换到root用户

在  /etc/sysctl.conf文件最后添加一行

vm.max_map_count=262144

https://www.cnblogs.com/yidiandhappy/p/7714489.html

执行这个使得配置生效：
sysctl -p

常见的几种报错的解决方式：
https://www.jianshu.com/p/2285f1f8ec21


max number of threads [3818] for user [es] is too low, increase to at least [4096]
vim /etc/security/limits.conf

* soft nofile 65536
* hard nofile 65536

```

2. 安装kibana:

```

wget https://artifacts.elastic.co/downloads/kibana/kibana-6.3.1-linux-x86_64.tar.gz


然后解压


然后修改

server.host: "0.0.0.0" 

通过这个命令可以查询到kibana运行的pid：
ps -ef  | grep node

```

3. 安装logstash

```shell

wget https://artifacts.elastic.co/downloads/logstash/logstash-6.3.1.tar.gz

```

4. IK分词器安装：

https://github.com/medcl/elasticsearch-analysis-ik

wget https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v6.3.1/elasticsearch-analysis-ik-6.3.1.zip


切换到es的plugins目录

新建一个文件夹叫做ik

然后将下载后的文件内容，复制到ik目录下即可


mkdir elasticsearch-6.3.1/plugins/ik

unzip elasticsearch-analysis-ik-6.3.1.zip elasticsearch-6.3.1/plugins/ik/



然后重启es

使用IK分词器： ik_smart ik_max_word

```http request
POST _analyze
{
  "analyzer": "ik_smart",
 "text": "今天天气真好啊"
}
```
