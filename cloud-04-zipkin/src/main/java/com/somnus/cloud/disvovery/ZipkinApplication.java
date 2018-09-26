package com.somnus.cloud.disvovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import zipkin.server.internal.EnableZipkinServer;

/**
 * @ClassName: ZipkinApplication
 * @Description: The class Paas cloud zipkin application.
 * @author pc
 * @date 2018年9月26日
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class ZipkinApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ZipkinApplication.class, args);
	}
}
