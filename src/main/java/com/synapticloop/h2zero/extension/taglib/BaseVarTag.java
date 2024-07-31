package com.synapticloop.h2zero.extension.taglib;

/*
 * Copyright (c) 2012-2018 synapticloop.
 * All rights reserved.
 *
 * This source code and any derived binaries are covered by the terms and
 * conditions of the Licence agreement ("the Licence").  You may not use this
 * source code or any derived binaries except in compliance with the Licence.
 * A copy of the Licence is available in the file named LICENCE shipped with
 * this source code or binaries.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * Licence for the specific language governing permissions and limitations
 * under the Licence.
 */

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.BodyTagSupport;

import java.io.Serial;

/**
 * <p>Base variable tag.</p>
 *
 * @author Synapticloop
 */
public class BaseVarTag extends BodyTagSupport {
	@Serial private static final long serialVersionUID = 4908196758573941815L;

	 /** <p>The variable to set</p> */
	protected String var = null;
	/** <p>The offset</p> */
	protected Integer offset = 0;
	/** <p>The limit</p> */
	protected Integer limit = null;

	/** <p>Whether to remove the variable from the page.</p> */
	protected boolean removeVar = false;

	@Override
	public int doEndTag() throws JspException {
		if(removeVar) {
			pageContext.removeAttribute(var, PageContext.PAGE_SCOPE);
		}

		this.limit = null;
		this.offset = 0;

		return(EVAL_PAGE);
	}

	/**
	 * <p>Get the name of the variable that will be placed in the PageContext.PAGE_SCOPE</p>
	 * 
	 * @return the name of the variable
	 */
	public String getVar() { return var; }
	
	/**
	 * <p>Set the name of the variable that will be placed in the PageContext.PAGE_SCOPE</p>
	 *
	 * @param var the name of the variable to set
	 */
	public void setVar(String var) { this.var = var; }
	
	/**
	 * <p>Set whether to remove the variable after the end tag (otherwise it will
	 * remain in the PageContext.PAGE_SCOPE)</p>
	 * 
	 * @param removeVar whether to remove the variable at the end of the scope
	 */
	public void setRemoveVar(boolean removeVar) { this.removeVar = removeVar; }
	
	/**
	 * <p>Get whether to remove the variable from the PageContext.PAGE_SCOPE.</p>
	 * 
	 * @return whether to remove the variable from the PageContext.PAGE_SCOPE at the end of the tag
	 */
	public boolean getRemoveVar() { return removeVar; }

	/**
	 * <p>Set the offset for the results from the SQL query</p>
	 * 
	 * @return the offset for results for the SQL query
	 */
	public String getOffset() { if(null != this.offset) { return(this.offset.toString()); } else { return(null); } }
	
	/**
	 * <p>set the offset for the results of the SQL query</p>
	 * 
	 * @param offset the offset for results for the SQL query
	 */
	public void setOffset(String offset) {
		try {
			this.offset = Integer.valueOf(offset);
		} catch(NumberFormatException ex) {
			// TODO
			// throw new Exception("Could not convert " + offset + " to an integer.");
		}
	}

	/**
	 * <p>Get the limit (i.e. the number of results to be returned from the SQL query)</p>
	 * 
	 * @return the limit of results for the end of the query
	 */
	public String getLimit() { if(null != this.limit) { return(this.limit.toString()); } else { return(null); } }

	/**
	 * <p>Set the limit for the number of queries</p>
	 * 
	 * @param limit the limit of the number of results for the query
	 */
	public void setLimit(String limit) {
		try {
			this.limit = Integer.valueOf(limit);
		} catch(NumberFormatException ex) {
			// do nothing
		}
	}

}
