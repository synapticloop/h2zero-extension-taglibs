package synapticloop.sample.h2zero.mysql.taglib.userPet;

// - - - - thoughtfully generated by synapticloop h2zero - - - - 
//    with the use of synapticloop templar templating language
//          (java-create-taglib-counter-count-all.templar)

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import synapticloop.sample.h2zero.mysql.counter.UserPetCounter;
import synapticloop.sample.h2zero.mysql.model.util.Constants;

import synapticloop.h2zero.extension.taglib.BaseVarTag;

@SuppressWarnings("serial")
public class CountAllTag extends BaseVarTag {
	// the binder is unused in code, but will generate compile problems if this 
	// class is no longer referenced in the h2zero file. Just a nicety for
	// removing dead code
	@SuppressWarnings("unused")
	private static final String BINDER = Constants.USER_PET_BINDER;

		private static final Logger LOGGER = LoggerFactory.getLogger(CountAllTag.class);


	@Override
	public int doStartTag() throws JspException {
		pageContext.setAttribute(var, UserPetCounter.countAllSilent());
		return(EVAL_BODY_INCLUDE);
}
}