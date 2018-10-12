/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.somnus.cloud.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName: SecurityProperties
 * @Description: The class Security properties.
 * @author Somnus
 * @date 2018年10月12日
 */
@ConfigurationProperties(prefix = "paascloud.security")
public class SecurityProperties {

	/**
	 * 浏览器环境配置
	 */
	private BrowserProperties browser = new BrowserProperties();
	/**
	 * 验证码配置
	 */
	private ValidateCodeProperties code = new ValidateCodeProperties();
	/**
	 * 社交登录配置
	 */
	private SocialProperties social = new SocialProperties();
	/**
	 * OAuth2认证服务器配置
	 */
	private OAuth2Properties oauth2 = new OAuth2Properties();

	/**
	 * Gets browser.
	 *
	 * @return the browser
	 */
	public BrowserProperties getBrowser() {
		return browser;
	}

	/**
	 * Sets browser.
	 *
	 * @param browser the browser
	 */
	public void setBrowser(BrowserProperties browser) {
		this.browser = browser;
	}

	/**
	 * Gets code.
	 *
	 * @return the code
	 */
	public ValidateCodeProperties getCode() {
		return code;
	}

	/**
	 * Sets code.
	 *
	 * @param code the code
	 */
	public void setCode(ValidateCodeProperties code) {
		this.code = code;
	}

	/**
	 * Gets social.
	 *
	 * @return the social
	 */
	public SocialProperties getSocial() {
		return social;
	}

	/**
	 * Sets social.
	 *
	 * @param social the social
	 */
	public void setSocial(SocialProperties social) {
		this.social = social;
	}

	/**
	 * Gets oauth 2.
	 *
	 * @return the oauth 2
	 */
	public OAuth2Properties getOauth2() {
		return oauth2;
	}

	/**
	 * Sets oauth 2.
	 *
	 * @param oauth2 the oauth 2
	 */
	public void setOauth2(OAuth2Properties oauth2) {
		this.oauth2 = oauth2;
	}

}

