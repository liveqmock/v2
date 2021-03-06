package com.aggrepoint.adk.form;

import java.util.Vector;

import net.sf.json.JSONNull;
import net.sf.json.JSONSerializer;

import com.aggrepoint.adk.Winlet;

/**
 * 输入表单
 * 
 * @author Jim
 */
public class FormImpl implements Form {
	/** 表单的ID */
	String id;
	/** 表单对应的操作 */
	String strAction;
	/** 表单中的输入项 */
	Vector<InputImpl> vecInputs = new Vector<InputImpl>();
	/** 进行单项校验的输入项 */
	InputImpl validateField;
	/** 是否存在校验错误 */
	protected boolean bHasError;
	/** 对应的Winlet */
	Winlet winlet;
	/** 重置依赖对象。如果对象实例变化了，则需要重置表单内容 */
	Object objResetRef;
	/** 在一次校验请求处理过程中表单的变化 */
	Vector<Change> vecChanges;

	public FormImpl(String id, Winlet winlet) {
		this.id = id;
		this.winlet = winlet;
	}

	public void startRecordChanges() {
		vecChanges = new Vector<Change>();
	}

	public void recordChange(Change change) {
		if (vecChanges != null)
			vecChanges.add(change);
	}

	public String getId() {
		return id;
	}

	public void setAction(String a) {
		strAction = a;
	}

	public String getAction() {
		return strAction;
	}

	public void setResetRef(Object a) {
		objResetRef = a;
	}

	public Object getResetRef() {
		return objResetRef;
	}

	@Override
	public boolean hasError() {
		return bHasError;
	}

	public void clearError() {
		bHasError = false;
	}

	@Override
	public Form reset() {
		vecInputs = new Vector<InputImpl>();
		validateField = null;
		bHasError = false;
		return this;
	}

	public Vector<InputImpl> getInputs() {
		return vecInputs;
	}

	public InputImpl getInput(String type, String name) {
		for (InputImpl inp : vecInputs)
			if (inp.getName().equalsIgnoreCase(name)) {
				if (inp.winlet == winlet && inp.getType().equals(type))
					return inp;
				vecInputs.remove(inp);
				break;
			}
		InputImpl inp = InputImpl.getInstance(this, type, winlet, name);
		vecInputs.add(inp);
		return inp;
	}

	@Override
	public InputImpl getInputByName(String name) {
		for (InputImpl inp : vecInputs)
			if (inp.getName().equalsIgnoreCase(name))
				return inp;
		return null;
	}

	@Override
	public boolean isValidateField() {
		return validateField != null;
	}

	@Override
	public InputImpl getValidateField() {
		return validateField;
	}

	public void setValidateField(InputImpl input) {
		validateField = input;
	}

	@Override
	public Input disable(String name) {
		InputImpl input = getInputByName(name);
		if (input != null) {
			input.setDisabled(true);
			recordChange(new ChangeDisable(name));
		}
		return input;
	}

	@Override
	public Input enable(String name) {
		InputImpl input = getInputByName(name);
		if (input != null) {
			input.setDisabled(false);
			recordChange(new ChangeEnable(name));
		}
		return input;
	}

	@Override
	public Input setDisabled(String name, boolean disabled) {
		if (disabled)
			return disable(name);
		return enable(name);
	}

	public String getJsonChanges() {
		if (vecChanges == null)
			return JSONSerializer.toJSON(JSONNull.getInstance()).toString();

		return JSONSerializer.toJSON(
				vecChanges.toArray(new Change[vecChanges.size()])).toString();
	}
}
