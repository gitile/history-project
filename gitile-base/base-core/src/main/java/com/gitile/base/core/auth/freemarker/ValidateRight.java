package com.gitile.base.core.auth.freemarker;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.gitile.base.core.auth.AuthUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 验证是否有权限
 * <@ValidateRight right="/index" />
 */
public abstract class ValidateRight implements TemplateDirectiveModel {

	@SuppressWarnings("rawtypes")
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		String right = String.valueOf(params.get("right"));
		List<String> rights = getRights();
		for (String path : rights) {
			if (AuthUtils.isPermission(right, path)) {
				env.getOut().write("true");
				return;
			}
		}
		env.getOut().write("false");
	}
	
	/**
	 * 获取用户的权限集合
	 */
	public abstract List<String> getRights();

}