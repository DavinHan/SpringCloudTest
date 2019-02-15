package com.test.utils;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class MyFilter extends ZuulFilter{
	
	private static final Logger LOG = LoggerFactory.getLogger(MyFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		LOG.info(String.format("%s >>> %s", request.getMethod(),request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		if(accessToken == null) {
			LOG.warn("woken is empty");
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
			try {
				context.getResponse().getWriter().write("token is empty");
			}catch (Exception e) {
				LOG.error("context write error", e);
			}
			return null;
		}
		LOG.info(">>>>> OK >>>>>");
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
