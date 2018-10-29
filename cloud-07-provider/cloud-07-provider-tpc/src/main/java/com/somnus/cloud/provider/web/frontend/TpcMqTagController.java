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
package com.somnus.cloud.provider.web.frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.somnus.cloud.common.base.dto.LoginAuthDto;
import com.somnus.cloud.common.base.dto.UpdateStatusDto;
import com.somnus.cloud.common.util.wrapper.WrapMapper;
import com.somnus.cloud.common.util.wrapper.Wrapper;
import com.somnus.cloud.comon.core.annotation.LogAnnotation;
import com.somnus.cloud.comon.core.support.BaseController;
import com.somnus.cloud.provider.model.domain.TpcMqTag;
import com.somnus.cloud.provider.model.vo.TpcMqTagVo;
import com.somnus.cloud.provider.service.TpcMqTagService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: TpcMqTagController
 * @Description: The class Tpc mq tag controller.
 * @author Somnus
 * @date 2018年10月17日
 */
@RestController
@RequestMapping(value = "/tag", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - TpcMqTagController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TpcMqTagController extends BaseController {

	@Autowired
	private TpcMqTagService tpcMqTagService;

	/**
	 * 查询MQ Tag列表.
	 *
	 * @param tpcMqTag the tpc mq tag
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/queryTagListWithPage")
	@ApiOperation(httpMethod = "POST", value = "查询MQ-Tag列表")
	public Wrapper<PageInfo<TpcMqTagVo>> queryTagListWithPage(@ApiParam(name = "tag", value = "角色信息") @RequestBody TpcMqTag tpcMqTag) {

		logger.info("查询角色列表tpcMqTagQuery={}", tpcMqTag);
		PageHelper.startPage(tpcMqTag.getPageNum(), tpcMqTag.getPageSize());
		tpcMqTag.setOrderBy("update_time desc");
		List<TpcMqTagVo> list = tpcMqTagService.listWithPage(tpcMqTag);
		return WrapMapper.success(new PageInfo<>(list));
	}

	/**
	 * 修改tag状态.
	 *
	 * @param updateStatusDto the update status dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/modifyStatusById")
	@ApiOperation(httpMethod = "POST", value = "修改MQ-Tag状态")
	@LogAnnotation
	public Wrapper<?> modifyProducerStatusById(@ApiParam(value = "修改tag状态") @RequestBody UpdateStatusDto updateStatusDto) {
		logger.info("修改tag状态 updateStatusDto={}", updateStatusDto);
		Long roleId = updateStatusDto.getId();

		LoginAuthDto loginAuthDto = getLoginAuthDto();

		TpcMqTag tag = new TpcMqTag();
		tag.setId(roleId);
		tag.setStatus(updateStatusDto.getStatus());
		tag.setUpdateInfo(loginAuthDto);

		int result = tpcMqTagService.update(tag);
		return super.handleResult(result);
	}

	/**
	 * 根据Tag ID删除TAG.
	 *
	 * @param id the id
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/deleteById/{id}")
	@ApiOperation(httpMethod = "POST", value = "根据ID删除TAG")
	@LogAnnotation
	public Wrapper<?> deleteTagById(@ApiParam(value = "Tag ID") @PathVariable Long id) {
		logger.info("删除tag id={}", id);
		int result = tpcMqTagService.deleteTagById(id);
		return super.handleResult(result);
	}
}
