/*
 * 
 */
package by.zhukova.uni.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * The Class EncodingFilter is designed to change encoding of requests and
 * responses to "UTF-8".
 */

@WebFilter(urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding Param") })
public class EncodingFilter implements Filter {

	private String code;

	/**
	 * Initiate filter with parameter
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		code = fConfig.getInitParameter("encoding");
	}

	/**
	 * Change encoding of request and response
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String codeRequest = request.getCharacterEncoding();

		if (code != null && !code.equalsIgnoreCase(codeRequest)) {
			request.setCharacterEncoding(code);
			response.setCharacterEncoding(code);
		}
		chain.doFilter(request, response);
	}

	/**
	 * Delete filter parameter
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		code = null;
	}
}