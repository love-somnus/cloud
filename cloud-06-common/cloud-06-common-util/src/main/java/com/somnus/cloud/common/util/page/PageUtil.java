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
package com.somnus.cloud.common.util.page;

import lombok.Data;

/**
 * @ClassName: PageUtil
 * @Description: The class Page util.
 * @author Somnus
 * @date 2018年10月9日
 */
@Data
public class PageUtil {

	/**
	 * The cur page.当前页
	 */
	private int currentPage = 1;

	/**
	 * The next page.下一页
	 */
	private int nextPage;

	/**
	 * The pre page. 上一页
	 */
	private int prePage;

	/**
	 * The total row. 总条数
	 */
	private int totalRow;

	/**
	 * The page size.每页条数
	 */
	private int pageSize = 10;

	/**
	 * The total page.总页数
	 */
	private int totalPage;

	/**
	 * The start. 开始条数
	 */
	private int start;

	/**
	 * The buttons.
	 */
	private int[] buttons;

	/**
	 * 当前页条数
	 */
	private int curPageSize;

	/**
	 * Instantiates a new page util.
	 */
	public PageUtil() {

	}

	/**
	 * Instantiates a new page util.
	 *
	 * @param currentPage the current page
	 */
	public PageUtil(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * Instantiates a new page util.
	 *
	 * @param currentPage the current page
	 * @param pageSize    the page size
	 */
	public PageUtil(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

}
