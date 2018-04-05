package com.seezoon.framework.modules.system.web;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.seezoon.framework.common.context.beans.ResponeModel;
import com.seezoon.framework.common.web.BaseController;
import com.seezoon.framework.modules.system.entity.SysParam;
import com.seezoon.framework.modules.system.service.SysParamService;

@RestController
@RequestMapping("${admin.path}/sys/param")
public class SysParamController extends BaseController {

	@Autowired
	private SysParamService sysParamService;

	@PostMapping("/qryPage.do")
	public ResponeModel qryPage(SysParam sysParam) {
		PageInfo<SysParam> page = sysParamService.findByPage(sysParam, sysParam.getPage(), sysParam.getPageSize());
		return ResponeModel.ok(page);
	}

	@RequestMapping("/get.do")
	public ResponeModel get(@RequestParam Serializable id) {
		System.out.println(id);
		SysParam sysParam = sysParamService.findById(id);
		return ResponeModel.ok(sysParam);
	}

	@PostMapping("/save.do")
	public ResponeModel save(@Validated SysParam sysParam, BindingResult bindingResult) {
		int cnt = sysParamService.save(sysParam);
		return ResponeModel.ok(cnt);
	}

	@PostMapping("/update.do")
	public ResponeModel update(SysParam sysParam) {
		int cnt = sysParamService.updateSelective(sysParam);
		return ResponeModel.ok(cnt);
	}

	@PostMapping("/delete.do")
	public ResponeModel delete(@RequestParam Serializable id) {
		int cnt = sysParamService.deleteById(id);
		return ResponeModel.ok(cnt);
	}
	
}
