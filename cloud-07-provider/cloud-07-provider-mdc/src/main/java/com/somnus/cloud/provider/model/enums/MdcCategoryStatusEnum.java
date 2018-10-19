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

/**
 * @ClassName: MdcCategoryStatusEnum
 * @Description: The enum Mdc category status enum.
 * @author Somnus
 * @date 2018年10月17日
 */
public enum MdcCategoryStatusEnum {
	/**
	 * 启用
	 */
	ENABLE(1, "启用"),
	/**
	 * 禁用
	 */
	DISABLE(2, "禁用");

	/**
	 * The Type.
	 */
	int type;
	/**
	 * The Name.
	 */
	String name;

	MdcCategoryStatusEnum(int type, String name) {
		this.type = type;
		this.name = name;
	}

	/**
	 * Gets type.
	 *
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * Gets name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Gets name.
	 *
	 * @param type the type
	 *
	 * @return the name
	 */
	public static String getName(int type) {
		for (MdcCategoryStatusEnum ele : MdcCategoryStatusEnum.values()) {
			if (type == ele.getType()) {
				return ele.getName();
			}
		}
		return null;
	}

	/**
	 * Gets enum.
	 *
	 * @param type the type
	 *
	 * @return the enum
	 */
	public static MdcCategoryStatusEnum getEnum(int type) {
		for (MdcCategoryStatusEnum ele : MdcCategoryStatusEnum.values()) {
			if (type == ele.getType()) {
				return ele;
			}
		}
		return MdcCategoryStatusEnum.ENABLE;
	}
}
