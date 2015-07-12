package by.zhukova.uni.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


/**
 * The Class FooterTag is custom tag for footer of page.
 */
public class FooterTag extends TagSupport {
	
	/**
	 *  Writes the html code of page footer on jsp page 
	 *  
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {

	String footerText = "<div class='footer'><hr/>(c) Zhukova, 2015</div>";
	
	try {
		JspWriter out = pageContext.getOut();
		out.write(footerText); 
		}
	catch (IOException e) {
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
