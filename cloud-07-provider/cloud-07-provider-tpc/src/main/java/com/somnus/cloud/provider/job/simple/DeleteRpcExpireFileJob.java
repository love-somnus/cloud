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
package com.somnus.cloud.provider.job.simple;

import javax.annotation.Resource;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.elasticjob.lite.annotation.ElasticSimpleJob;
import com.somnus.cloud.provider.service.OpcRpcService;

/**
 * @ClassName: DeleteRpcExpireFileJob
 * @Description: 定时清理无效OSS文件.
 * @author Somnus
 * @date 2018年10月17日
 */
@ElasticSimpleJob(cron = "0 0 0 1/1 * ?")
public class DeleteRpcExpireFileJob implements SimpleJob {

	@Resource
	private OpcRpcService opcRpcService;

	/**
	 * Execute.
	 *
	 * @param shardingContext the sharding context
	 */
	@Override
	public void execute(final ShardingContext shardingContext) {
		opcRpcService.deleteExpireFile();
	}
}
