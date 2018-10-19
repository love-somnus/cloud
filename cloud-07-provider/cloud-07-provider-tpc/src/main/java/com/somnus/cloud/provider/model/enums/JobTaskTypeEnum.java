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
 * @ClassName: JobTaskTypeEnum
 * @Description: The enum Job task type enum.
 * @author Somnus
 * @date 2018年10月17日
 */
public enum JobTaskTypeEnum {

	/**
	 * Mq send message job task type enum.
	 */
	MQ_SEND_MESSAGE("MQ_SEND_MESSAGE", "发送可靠消息"),;
	/**
	 * The Type.
	 */
	String type;

	/**
	 * The Value.
	 */
	String value;

	JobTaskTypeEnum(String type, String value) {
		this.type = type;
		this.value = value;
	}

	public String type() {
		return type;
	}

	public String value() {
		return value;
	}

}
