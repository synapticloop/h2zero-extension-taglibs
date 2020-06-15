package synapticloop.sample.h2zero.mysql.taglib.userUserType;

// - - - - thoughtfully generated by synapticloop h2zero - - - - 
//    with the use of synapticloop templar templating language
//           (java-create-taglib-finder.templar)

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import synapticloop.sample.h2zero.mysql.model.util.Constants;
import synapticloop.sample.h2zero.mysql.view.UserUserType;
import synapticloop.sample.h2zero.mysql.finder.UserUserTypeViewFinder;
import synapticloop.h2zero.extension.taglib.BaseVarTag;


@SuppressWarnings("serial")
public class FindByNmUserTag extends BaseVarTag {
	// the binder is unused in code, but will generate compile problems if this 
	// class is no longer referenced in the h2zero file. Just a nicety for
	// removing dead code
	@SuppressWarnings("unused")
	private static final String BINDER = Constants.USER_USER_TYPE_BINDER;
	private static final Logger LOGGER = LoggerFactory.getLogger(FindByNmUserTag.class);

	private String nmUser = null;

	@Override
	public int doStartTag() throws JspException {
		if(limit != null) {
			pageContext.setAttribute(var, UserUserTypeViewFinder.findByNmUserSilent(nmUser, limit, offset));
		} else {
			pageContext.setAttribute(var, UserUserTypeViewFinder.findByNmUserSilent(nmUser));
		}
		return(EVAL_BODY_INCLUDE);
	}

	public void setNmUser(String nmUser) {
		this.nmUser = nmUser;
	}

}