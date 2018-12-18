### Spring Boot下非web后台长运行应用的实现

测试环境：Spring Boot 2.1.1.RELEASE

`Spring Boot`下非web应用只需在`application.properties`里加上:

``` properties
spring.main.web-application-type=none
```

添加之后，应用将不再启动web容器，在`CommandLineRunner`执行完毕后会自动退出，若我们需要长时间运行在后台的应用需在最后加上:`new Scanner(System.in).nextLine()`,如：

``` java
@SpringBootApplication
public class Netty4ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Netty4ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner novaServerRunner(NovaDecoder decoder, NovaEncoder encoder){

		return p -> {
               //...业务逻辑
			new Scanner(System.in).nextLine(); 

		};
	}



}

```

这时候应用即可在后台运行，在控制台随便输入一行字按回车即可关闭应用。

源码地址:[https://github.com/wiselyman/netty4-server.git](https://github.com/wiselyman/netty4-server.git)