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
 * @ClassName: ZtreeAuthTypeEnum
 * @Description: The enum Ztree auth type enum.
 * @author Somnus
 * @date 2018年10月17日
 */
public enum ZtreeAuthTypeEnum {
	/**
	 * 菜单
	 */
	MENU("MENU", "菜单"),
	/**
	 * 按钮
	 */
	BUTTON("BUTTON", "按钮");

	/**
	 * The Type.
	 */
	String type;
	/**
	 * The Name.
	 */
	String name;

	ZtreeAuthTypeEnum(String type, String name) {
		this.type = type;
		this.name = name;
	}

	/**
	 * Gets type.
	 *
	 * @return the type
	 */
	public String getType() {
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
	public static String getName(String type) {
		for (ZtreeAuthTypeEnum ele : ZtreeAuthTypeEnum.values()) {
			if (type.equals(ele.getType())) {
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
	public static ZtreeAuthTypeEnum getEnum(String type) {
		for (ZtreeAuthTypeEnum ele : ZtreeAuthTypeEnum.values()) {
			if (type.equals(ele.getType())) {
				return ele;
			}
		}
		return ZtreeAuthTypeEnum.MENU;
	}
}
