package com.hitech.skeleton.modules.demo.controller;

import com.hitech.skeleton.modules.demo.service.IDictDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 数据字典详情表 前端控制器
 * </p>
 *
 * @author Steven
 * @since 2019-04-28
 */
@RestController
@Slf4j
@RequestMapping("/api/demo/dict-detail")
public class DictDetailController {

	@Autowired
	private IDictDetailService dictDetailServiceImpl;

}
