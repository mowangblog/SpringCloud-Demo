# 配置Hystrix Dashboard 时遇到的Unable to connect to Command Metric Stream.问题

在springCloud配置Hystrix Dashboard的时候我出现了`Unable to connect to Command Metric Stream.`问题。

![image-20211101134213626](https://res.mowangblog.top/img/11/01/image-20211101134213626.png)

查看报错发现如下信息

![image-20211101134143009](https://res.mowangblog.top/img/11/01/image-20211101134143009.png)

```toml
2021-11-01 13:39:43.859  WARN 17012 --- [nio-9001-exec-8] ashboardConfiguration$ProxyStreamServlet : Failed opening connection to http://localhost:8001/hystrix.stream : 404 : HTTP/1.1 404 
2021-11-01 13:39:43.896  INFO 17012 --- [nio-9001-exec-4] ashboardConfiguration$ProxyStreamServlet : 

Proxy opening connection to: http://localhost:8001/hystrix.stream
```

查找研究并经过周阳老师的讲解后发现原来是springcloud升级后的坑，ServletRegistrationBean因为springBoot的默认路径不是"/hystrix.stream"，所以直接打开http://localhost:8001/hystrix.stream也是报错的

![image-20211101134723714](https://res.mowangblog.top/img/11/01/image-20211101134723714.png)

那么只要在自己的项目里配置这个servlet就可以了，代码如下，放在SpringBoot的启动类上

```java
@Bean
public ServletRegistrationBean getServlet() {
    HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
    ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
    registrationBean.setLoadOnStartup(1);
    registrationBean.addUrlMappings("/hystrix.stream");
    registrationBean.setName("HystrixMetricsStreamServlet");
    return registrationBean;
}
```

配置之后再次尝试直接打开http://localhost:8001/hystrix.stream ，果然正确的访问到了数据

![image-20211101135141768](https://res.mowangblog.top/img/11/01/image-20211101135141768.png)

然而我再次尝试打开Hystrix Dashboard的时候我又出现了`Unable to connect to Command Metric Stream.`

![image-20211101134213626](https://res.mowangblog.top/img/11/01/image-20211101134213626.png)

再次查看报错信息

![image-20211101135406039](https://res.mowangblog.top/img/11/01/image-20211101135406039.png)

```toml
2021-11-01 13:52:31.705  WARN 16816 --- [nio-9001-exec-1] ashboardConfiguration$ProxyStreamServlet : Origin parameter: http://localhost:8001/hystrix.stream is not in the allowed list of proxy host names.  If it should be allowed add it to hystrix.dashboard.proxyStreamAllowList.
2021-11-01 13:52:31.705  WARN 16816 --- [io-9001-exec-10] ashboardConfiguration$ProxyStreamServlet : Origin parameter: http://localhost:8001/hystrix.stream is not in the allowed list of proxy host names.  If it should be allowed add it to hystrix.dashboard.proxyStreamAllowList.
```

这次很清晰，就是说http://localhost:8001/hystrix.stream 不在允许的代理主机列表中，最后甚至给了我们解决方案

```
If it should be allowed add it to hystrix.dashboard.proxyStreamAllowList.
```

既然如此，我们就加吧，在dashboard的工程yml文件下加入如下配置即可

```xml
hystrix:
  dashboard:
    proxy-stream-allow-list: "localhost"
```

再次尝试，成功！

![image-20211101140002621](https://res.mowangblog.top/img/11/01/image-20211101140002621.png)

