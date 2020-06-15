package synapticloop.sample.h2zero.mysql.taglib.user;

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
import synapticloop.sample.h2zero.mysql.model.User;
import synapticloop.sample.h2zero.mysql.finder.UserFinder;
import synapticloop.h2zero.extension.taglib.BaseVarTag;


@SuppressWarnings("serial")
public class FindByNumAgeBetweenTag extends BaseVarTag {
	// the binder is unused in code, but will generate compile problems if this 
	// class is no longer referenced in the h2zero file. Just a nicety for
	// removing dead code
	@SuppressWarnings("unused")
	private static final String BINDER = Constants.USER_BINDER;
	private static final Logger LOGGER = LoggerFactory.getLogger(FindByNumAgeBetweenTag.class);

	private Integer numAgeMin = null;
	private Integer numAgeMax = null;

	@Override
	public int doStartTag() throws JspException {
		if(limit != null) {
			pageContext.setAttribute(var, UserFinder.findByNumAgeBetweenSilent(numAgeMin, numAgeMax, limit, offset));
		} else {
			pageContext.setAttribute(var, UserFinder.findByNumAgeBetweenSilent(numAgeMin, numAgeMax));
		}
		return(EVAL_BODY_INCLUDE);
	}

	public void setNumAgeMin(Integer numAgeMin) {
		this.numAgeMin = numAgeMin;
	}

	public void setNumAgeMax(Integer numAgeMax) {
		this.numAgeMax = numAgeMax;
	}

}