package br.com.bb.cotacaodolar.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.WebRequest;

/**
 * The Class PropertiesUtil.
 */
public class LogUtil {
	/** The Constant BUNDLE_NAME. */
	private static final String APP_LOG = "true";

	private static final String[] HEADERS_TO_TRY = { "X-Forwarded-For", "Client-Ip", "Proxy-Client-IP", "WL-Proxy-Client-IP",
			"HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP", "HTTP_CLIENT_IP",
			"HTTP_FORWARDED_FOR", "HTTP_FORWARDED", "HTTP_VIA", "REMOTE_ADDR" };

	public static String buildMessage(final String application, final WebRequest request,
			final String message) {
		StringBuilder str = new StringBuilder();

		str.append("UAID=").append(application).append(" | ");
		str.append("user=").append(buscaUsuario(request)).append(" | ");
		str.append("src_ip=").append(buscaRemoteAddr(request)).append(" | ");
		str.append("applog=").append(APP_LOG).append(" | ");
		str.append("message=").append(message);

		return str.toString();
	}

	public static String buildMessage(final String application, final String message) {
		StringBuilder str = new StringBuilder();

		str.append("UAID=").append(application).append(" | ");
		str.append("message=").append(message);

		return str.toString();
	}

	public static String buscaUsuario(WebRequest request) {
		for (String header : HEADERS_TO_TRY) {
			String ip = request.getHeader(header);
			if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
				return ip;
			}
		}

		return request.getRemoteUser();
	}

	public static String buscaUsuario(HttpServletRequest request) {
		for (String header : HEADERS_TO_TRY) {
			String ip = request.getHeader(header);
			if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
				return ip;
			}
		}

		return request.getRemoteAddr();
	}

	public static String buscaRemoteAddr(HttpServletRequest request) {
		for (String header : HEADERS_TO_TRY) {
			String ip = request.getHeader(header);
			if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
				return ip;
			}
		}

		return request.getRemoteAddr();
	}

	public static String buscaRemoteAddr(WebRequest request) {
		for (String header : HEADERS_TO_TRY) {
			String ip = request.getHeader(header);
			if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
				return ip;
			}
		}

		return request.getRemoteUser();
	}
}
