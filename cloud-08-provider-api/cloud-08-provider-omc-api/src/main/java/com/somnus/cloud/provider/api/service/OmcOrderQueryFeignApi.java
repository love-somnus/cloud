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
package com.somnus.cloud.provider.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.somnus.cloud.common.util.wrapper.Wrapper;
import com.somnus.cloud.provider.api.model.dto.OrderDto;
import com.somnus.cloud.provider.api.service.hystrix.OmcOrderQueryFeignHystrix;
import com.somnus.cloud.security.feign.OAuth2FeignAutoConfiguration;

/**
 * @ClassName: OmcOrderQueryFeignApi
 * @Description: The interface Omc order query feign api.
 * @author Somnus
 * @date 2018年10月16日
 */
@FeignClient(value = "cloud-provider-omc", configuration = OAuth2FeignAutoConfiguration.class, fallback = OmcOrderQueryFeignHystrix.class)
public interface OmcOrderQueryFeignApi {
	/**
	 * Query by order no wrapper.
	 *
	 * @param orderNo the order no
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/order/queryByOrderNo/{orderNo}")
	Wrapper<OrderDto> queryByOrderNo(@PathVariable("orderNo") String orderNo);

	/**
	 * Query by user id and order no wrapper.
	 *
	 * @param userId  the user id
	 * @param orderNo the order no
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/order/queryByUserIdAndOrderNo/{userId}/{orderNo}")
	Wrapper<OrderDto> queryByUserIdAndOrderNo(@PathVariable("userId") Long userId, @PathVariable("orderNo") String orderNo);
}