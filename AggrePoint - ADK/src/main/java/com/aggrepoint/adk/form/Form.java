package com.aggrepoint.adk.form;


/**
 * 表单
 * 
 * @author Jim
 */
public interface Form {
	/**
	 * 表单校验过程中是否遇到错误
	 * 
	 * @return true 有错误
	 */
	public boolean hasError();

	/**
	 * 根据Input的name获取Input实例
	 * 
	 * @param name
	 * @return
	 */
	public Input getInputByName(String name);

	public boolean isValidateField();

	public Input getValidateField();

	public Input disable(String name);

	public Input enable(String name);

	public Input setDisabled(String name, boolean disabled);

	public Form reset();
}
