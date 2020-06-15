package synapticloop.sample.h2zero.mysql.taglib.user;

// - - - - thoughtfully generated by synapticloop h2zero - - - - 
//    with the use of synapticloop templar templating language
//           (java-create-taglib-question.templar)

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import synapticloop.sample.h2zero.mysql.model.util.Constants;
import synapticloop.sample.h2zero.mysql.model.User;
import synapticloop.sample.h2zero.mysql.finder.UserFinder;
import synapticloop.h2zero.extension.taglib.BaseVarTag;


import synapticloop.sample.h2zero.mysql.question.UserQuestion;

@SuppressWarnings("serial")
public class DoWeHaveUsersBetweenAgeExclusiveTag extends BaseVarTag {
	// the binder is unused in code, but will generate compile problems if this 
	// class is no longer referenced in the h2zero file. Just a nicety for
	// removing dead code
	@SuppressWarnings("unused")
	private static final String BINDER = Constants.USER_BINDER;
	private static final Logger LOGGER = LoggerFactory.getLogger(DoWeHaveUsersBetweenAgeExclusiveTag.class);

	private Integer numAgeFrom = null;
	private Integer numAgeTo = null;

	@Override
	public int doStartTag() throws JspException {
		pageContext.setAttribute(var, UserQuestion.doWeHaveUsersBetweenAgeExclusiveSilent(numAgeFrom, numAgeTo));
		return(EVAL_BODY_INCLUDE);
	}

	public void setNumAgeFrom(Integer numAgeFrom) {
		this.numAgeFrom = numAgeFrom;
	}

	public void setNumAgeTo(Integer numAgeTo) {
		this.numAgeTo = numAgeTo;
	}

}