package com.raze.controller.system;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;

/**
 * BaseAction基礎方法
 * 
 * @陈斌委
 * @Aug 1, 2013 3:33:36 PM
 * @version 1.0.0
 */
public abstract class BaseAction {
	/**
	 * 输出javascript
	 * 
	 * @param _req
	 * @param _resp
	 * @param model
	 * @param tpl
	 * @throws IOException
	 */
	public final static void javascript(HttpServletResponse _resp) {
		_resp.setContentType("application/x-javascript;charset=utf-8");
		_resp.setCharacterEncoding("utf-8");
	}

	public final static void echoJavascript(HttpServletResponse _resp, String tpl) throws IOException {
		javascript(_resp);
		if (null != tpl) {
			_resp.getWriter().write(tpl);
		}
		_resp.flushBuffer();
	}

	/**
	 * 输出字符串
	 * 
	 * @param _req
	 * @param _resp
	 * @param model
	 * @param tpl
	 * @throws IOException
	 */
	public final static void echoString(HttpServletResponse _resp, String con) throws IOException {
		PrintWriter out = _resp.getWriter();
		out.write(con);
		out.flush();
		out.close();
		return;
	}

	/**
	 * 获取客户端IP
	 * 
	 * @param request
	 * @return
	 */
	public final static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public final static int getPortAddr(HttpServletRequest request) {
		int port = request.getRemotePort();
		return port;
	}

	/**
	 * 输出JSON
	 * 
	 * @param _req
	 * @param _resp
	 * @param model
	 * @param tpl
	 * @throws IOException
	 */
	public final static void json(HttpServletResponse _resp) {
		_resp.setContentType("application/json;charset=utf-8");
		_resp.setCharacterEncoding("utf-8");
	}

	public final static void echoJson(HttpServletResponse _resp, String tpl) throws IOException {
		json(_resp);
		if (null != tpl) {
			_resp.getWriter().write(tpl);
		}
		_resp.flushBuffer();
	}

	public final static Map<String, Object> getParams() {
		return ActionContext.getContext().getParameters();
	}
}
