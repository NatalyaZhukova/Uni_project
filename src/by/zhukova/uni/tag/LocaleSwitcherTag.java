
package by.zhukova.uni.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * The Class LocaleSwitcherTag is custom tag for locale switcher
 */
public class LocaleSwitcherTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Writes the html code of locale switcher on jsp page
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		String textTag = "<div class='locale'>" + "<a href='controller?command=lang&loc=ru_RU'>RU</a> | "
				+ "<a href='controller?command=lang&loc=en_US'>EN</a></div>";

		try {
			JspWriter out = pageContext.getOut();
			out.write(textTag);
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;

	}

	/**
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

}
