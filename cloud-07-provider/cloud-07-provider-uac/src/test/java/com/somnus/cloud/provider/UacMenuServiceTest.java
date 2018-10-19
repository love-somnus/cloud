package com.somnus.cloud.provider;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.somnus.cloud.provider.api.vo.MenuVo;
import com.somnus.cloud.provider.service.UacMenuService;

public class UacMenuServiceTest extends CloudUacApplicationTests {
	@Resource
	private UacMenuService uacMenuService;

	@Test
	public void findMenuListByUserIdTest() {
		List<MenuVo> menuVoListByUserId = uacMenuService.getMenuVoList(1L, 1L);
		logger.info("findByLoginNameTest = {}", menuVoListByUserId);
	}
}
