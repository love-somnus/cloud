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
package com.somnus.cloud.common.util.wrapper;

import com.somnus.cloud.common.util.page.PageUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The class Page wrapper.
 *
 * @param <T> the type parameter @author paascloud.net@gmail.com
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PageWrapper<T> extends Wrapper<T> {

	private static final long serialVersionUID = 666985064788933395L;

	private PageUtil pageUtil;


	/**
	 * Instantiates a new Page wrapper.
	 */
	PageWrapper() {
		super();
	}


	/**
	 * Instantiates a new Page wrapper.
	 *
	 * @param code    the code
	 * @param message the message
	 */
	public PageWrapper(int code, String message) {
		super(code, message);
	}

	/**
	 * Instantiates a new pageWrapper default code=200
	 *
	 * @param result   the result
	 * @param pageUtil the page util
	 */
	public PageWrapper(T result, PageUtil pageUtil) {
		super();
		this.setResult(result);
		this.setPageUtil(pageUtil);
	}

	/**
	 * Instantiates a new Page wrapper.
	 *
	 * @param code     the code
	 * @param message  the message
	 * @param result   the result
	 * @param pageUtil the page util
	 */
	PageWrapper(int code, String message, T result, PageUtil pageUtil) {
		super(code, message, result);
		this.pageUtil = pageUtil;
	}

	/**
	 * Sets the 分页数据 , 返回自身的引用.
	 *
	 * @param pageUtil the page util
	 *
	 * @return the page wrapper
	 */
	public PageWrapper<T> pageUtil(PageUtil pageUtil) {
		this.setPageUtil(pageUtil);
		return this;
	}

	/**
	 * Sets the 结果数据 , 返回自身的引用.
	 *
	 * @param result the result
	 *
	 * @return the page wrapper
	 */
	@Override
	public PageWrapper<T> result(T result) {
		super.setResult(result);
		return this;
	}
}
