package com.somnus.cloud.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName: ValidateCodeGenerator
 * @Description: 校验码生成器
 * @author Somnus
 * @date 2018年10月12日
 */
public interface ValidateCodeGenerator {

	/**
	 * 生成校验码
	 *
	 * @param request the request
	 *
	 * @return validate code
	 */
	ValidateCode generate(ServletWebRequest request);

}
