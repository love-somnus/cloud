
/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：QQAutoConfig.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.somnus.cloud.security.core.social.qq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

import com.somnus.cloud.security.core.properties.QQProperties;
import com.somnus.cloud.security.core.properties.SecurityProperties;
import com.somnus.cloud.security.core.social.SocialAutoConfigurerAdapter;
import com.somnus.cloud.security.core.social.qq.connect.QQConnectionFactory;

/**
 * @ClassName: QQAutoConfig
 * @Description: The class Qq auto config.
 * @author Somnus
 * @date 2018年10月12日
 */
@Configuration
@ConditionalOnProperty(prefix = "paascloud.security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

	private final SecurityProperties securityProperties;

	@Autowired
	public QQAutoConfig(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}

	/**
	 * Create connection factory connection factory.
	 *
	 * @return the connection factory
	 */
	@Override
	protected ConnectionFactory<?> createConnectionFactory() {
		QQProperties qqConfig = securityProperties.getSocial().getQq();
		return new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
	}

}
