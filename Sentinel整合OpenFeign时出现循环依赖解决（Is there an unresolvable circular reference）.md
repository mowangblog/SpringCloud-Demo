​	

# Sentinel整合OpenFeign时出现循环依赖解决（Is there an unresolvable circular reference?）

## 错误信息

在OpenFeign整合Sentinel的时候出现循环依赖的报错

```java
Caused by: org.springframework.beans.factory.BeanCurrentlyInCreationException:Error creating bean with name 'top.mowang.cloud.service.PaymentService': Requested bean is currently in creation: Is there an unresolvable circular reference?
```

## 环境信息

Spring Cloud和Spring Cloud Alibaba版本信息：

```xml
<!--spring cloud Hoxton.SR12-->
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-dependencies</artifactId>
	<version>Hoxton.SR12</version>
	<type>pom</type>
	<scope>import</scope>
</dependency>
<!--spring cloud alibaba 2.1.0.RELEASE-->
<dependency>
	<groupId>com.alibaba.cloud</groupId>
	<artifactId>spring-cloud-alibaba-dependencies</artifactId>
	<version>2.2.1.RELEASE</version>
	<type>pom</type>
	<scope>import</scope>
</dependency>
```

我是在当前OpenFeign能成功整合Hystrix的前提下进行和Sentinel整合

在开启Sentinel对Feign的支持的配置后在启动时就出现了循环依赖的问题

开启Sentinel对Feign的支持：

```yaml
feign:
  sentinel:
    enabled: true
```

PaymentService类：

```java
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
```

PaymentService在注入到controller出现了循环依赖

## 问题原因和目前的解决方案

问题出在Spring Cloud和Spring Cloud Alibaba的版本上，具体就是Sentinel和OpenFeign版本兼容问题，目前的解决方案就是切换为兼容的版本，等待官方修复，在将spring cloud版本为Hoxton.SR3，spring cloud alibaba版本为2.1.0.RELEASE后正常启动，问题解决

```xml
<!--spring cloud Hoxton.SR3-->
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-dependencies</artifactId>
	<version>Hoxton.SR3</version>
	<type>pom</type>
	<scope>import</scope>
</dependency>
<!--spring cloud alibaba 2.1.0.RELEASE-->
<dependency>
	<groupId>com.alibaba.cloud</groupId>
	<artifactId>spring-cloud-alibaba-dependencies</artifactId>
	<version>2.2.1.RELEASE</version>
	<type>pom</type>
	<scope>import</scope>
</dependency>
```

