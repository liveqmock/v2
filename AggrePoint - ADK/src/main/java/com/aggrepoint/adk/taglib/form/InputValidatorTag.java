package com.aggrepoint.adk.taglib.form;

import java.util.Vector;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

import com.aggrepoint.adk.IAdkConst;
import com.aggrepoint.adk.form.InputImpl;

public class InputValidatorTag extends BodyTagSupport implements IAdkConst {
	private static final long serialVersionUID = 1L;

	protected String strId;

	protected String strMethod;

	protected String strPassSkip;

	protected String strFailSkip;

	protected String strError;

	protected Vector<String> vecArgs;

	InputImpl input;

	public void setId(String str) {
		strId = str;
	}

	public void setMethod(String str) {
		strMethod = str;
	}

	public void setPassskip(String str) {
		strPassSkip = str;
	}

	public void setFailskip(String str) {
		strFailSkip = str;
	}

	public void setError(String str) {
		strError = str;
	}

	public int doStartTag() throws JspException {
		FormTag form = (FormTag) TagSupport.findAncestorWithClass(this,
				FormTag.class);
		if (form == null || form.m_currentInput == null)
			return SKIP_BODY;
		input = form.m_currentInput;
		vecArgs = new Vector<String>();
		return (EVAL_BODY_BUFFERED);
	}

	public int doAfterBody() {
		input.addValidator(strId, strMethod, strPassSkip, strFailSkip,
				strError, vecArgs);
		bodyContent.clearBody();
		return SKIP_BODY;
	}
}