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
package com.somnus.cloud.provider.service.impl;

import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.somnus.cloud.common.base.constant.GlobalConstant;
import com.somnus.cloud.common.base.enums.ErrorCodeEnum;
import com.somnus.cloud.common.util.PublicUtil;
import com.somnus.cloud.comon.core.support.BaseService;
import com.somnus.cloud.provider.api.exceptions.UacBizException;
import com.somnus.cloud.provider.mapper.UacRoleUserMapper;
import com.somnus.cloud.provider.model.domain.UacRoleUser;
import com.somnus.cloud.provider.service.UacRoleUserService;

/**
 * @ClassName: UacRoleUserServiceImpl
 * @Description: The class Uac role user service.
 * @author Somnus
 * @date 2018年10月18日
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UacRoleUserServiceImpl extends BaseService<UacRoleUser> implements UacRoleUserService {
	@Resource
	private UacRoleUserMapper uacRoleUserMapper;

	@Override
	public int deleteByUserId(Long userId) {
		if (null == userId) {
			throw new UacBizException(ErrorCodeEnum.UAC10011001);
		}

		UacRoleUser param = new UacRoleUser();
		param.setUserId(userId);
		return uacRoleUserMapper.delete(param);
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<UacRoleUser> queryByUserId(Long userId) {
		if (null == userId) {
			throw new UacBizException(ErrorCodeEnum.UAC10011001);
		}

		return uacRoleUserMapper.listByUserId(userId);
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public UacRoleUser getByUserIdAndRoleId(Long userId, Long roleId) {

		if (null == userId) {
			throw new UacBizException(ErrorCodeEnum.UAC10011001);
		}

		if (null == roleId) {
			throw new UacBizException(ErrorCodeEnum.UAC10012001);
		}

		return uacRoleUserMapper.getByUserIdAndRoleId(userId, roleId);
	}

	@Override
	public int saveRoleUser(Long userId, Long roleId) {
		if (userId == null) {
			throw new UacBizException(ErrorCodeEnum.UAC10011001);
		}
		if (roleId == null) {
			throw new UacBizException(ErrorCodeEnum.UAC10012001);
		}

		UacRoleUser roleUser = new UacRoleUser();
		roleUser.setUserId(userId);
		roleUser.setRoleId(roleId);
		return uacRoleUserMapper.insertSelective(roleUser);
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<UacRoleUser> listByRoleId(Long roleId) {
		if (roleId == null) {
			throw new UacBizException(ErrorCodeEnum.UAC10012001);
		}
		return uacRoleUserMapper.listByRoleId(roleId);
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<UacRoleUser> listByRoleIdList(List<Long> idList) {
		if (PublicUtil.isEmpty(idList)) {
			throw new UacBizException(ErrorCodeEnum.UAC10012001);
		}
		return uacRoleUserMapper.listByRoleIdList(idList);
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<Long> listSuperUser(Long superManagerRoleId) {
		if (superManagerRoleId == null) {
			throw new UacBizException(ErrorCodeEnum.UAC10012001);
		}
		return uacRoleUserMapper.listSuperUser(superManagerRoleId);
	}

	@Override
	public void deleteExcludeSuperMng(Long roleId, Long superManagerRoleId) {
		if (roleId == null) {
			throw new UacBizException(ErrorCodeEnum.UAC10012001);
		}
		if (superManagerRoleId == null) {
			throw new UacBizException(ErrorCodeEnum.UAC10012004);
		}
		uacRoleUserMapper.deleteExcludeSuperMng(roleId, superManagerRoleId);

	}

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<UacRoleUser> listByUserId(Long userId) {
		if (userId == null) {
			throw new UacBizException(ErrorCodeEnum.UAC10011001);
		}
		return uacRoleUserMapper.listByUserId(userId);
	}

	@Override
	public void deleteByRoleIdList(List<Long> roleIdList) {
		Preconditions.checkArgument(PublicUtil.isNotEmpty(roleIdList), ErrorCodeEnum.UAC10012001.getMsg());
		Preconditions.checkArgument(!roleIdList.contains(GlobalConstant.Sys.SUPER_MANAGER_ROLE_ID), "超级管理员角色不能删除");
		int result = uacRoleUserMapper.deleteByRoleIdList(roleIdList);
		if (result < roleIdList.size()) {
			throw new UacBizException(ErrorCodeEnum.UAC10012007, Joiner.on(GlobalConstant.Symbol.COMMA).join(roleIdList));
		}
	}

	@Override
	public void deleteByRoleId(Long roleId) {
		Preconditions.checkArgument(roleId != null, ErrorCodeEnum.UAC10012001.getMsg());
		Preconditions.checkArgument(!Objects.equals(roleId, GlobalConstant.Sys.SUPER_MANAGER_ROLE_ID), "超级管理员角色不能删除");

		int result = uacRoleUserMapper.deleteByRoleId(roleId);
		if (result < 1) {
			throw new UacBizException(ErrorCodeEnum.UAC10012006, roleId);
		}
	}
}