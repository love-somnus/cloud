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
package com.somnus.cloud.provider.model.enums;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @ClassName: UacGroupStatusEnum
 * @Description: The enum Uac group status enum.
 * @author Somnus
 * @date 2018年10月17日
 */
public enum UacGroupStatusEnum {
	/**
	 * 启用
	 */
	ENABLE(0, "启用"),
	/**
	 * 禁用
	 */
	DISABLE(1, "禁用");

	/**
	 * The Status.
	 */
	int status;
	/**
	 * The Value.
	 */
	String value;

	/**
	 * Gets name.
	 *
	 * @param status the status
	 *
	 * @return the name
	 */
	public static String getName(int status) {
		for (UacGroupStatusEnum ele : UacGroupStatusEnum.values()) {
			if (status == ele.getStatus()) {
				return ele.getValue();
			}
		}
		return null;
	}

	UacGroupStatusEnum(int status, String value) {
		this.status = status;
		this.value = value;
	}

	/**
	 * Gets status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Gets value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	private static List<Integer> getStatusList() {
		List<Integer> list = Lists.newArrayList();
		for (UacGroupStatusEnum ele : UacGroupStatusEnum.values()) {
			list.add(ele.getStatus());
		}
		return list;
	}

	/**
	 * Contains boolean.
	 *
	 * @param status the status
	 *
	 * @return the boolean
	 */
	public static boolean contains(Integer status) {
		List<Integer> statusList = getStatusList();
		return statusList.contains(status);
	}
}