package com.whm.First_SpringBoot_M3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*特别主要，这里需要配置一下，不然报Service自动植入时报错*/
@MapperScan(value = "com.whm.First_SpringBoot_M3.Dao")
@SpringBootApplication
public class FirstSpringBootM2Application {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootM2Application.class, args);
	}
}
