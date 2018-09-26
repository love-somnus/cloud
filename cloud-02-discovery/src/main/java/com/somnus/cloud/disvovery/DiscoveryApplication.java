package com.somnus.cloud.disvovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @ClassName: DiscoveryApplication
 * @Description: 微服务配置中心
 * @author Somnus
 * @date 2018年9月25日
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class DiscoveryApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(DiscoveryApplication.class, args);
	}
}
