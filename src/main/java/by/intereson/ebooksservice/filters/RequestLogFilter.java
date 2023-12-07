package by.intereson.ebooksservice.filters;

import org.apache.log4j.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
@WebFilter(urlPatterns = {"/users/*","/books/*"})
public class RequestLogFilter extends HttpFilter {
    private Logger log;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        Map<String, List<String>> headers = getHeaders(req);
        log.info(req.getRequestURL() + " : " + headers);
        chain.doFilter(req,res);
    }

    private Map<String, List<String>> getHeaders(HttpServletRequest req) {
        return Collections.list(req.getHeaderNames()).stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        header -> Collections.list(req.getHeaders(header))));
    }

    @Override
    public void init() {
        log = Logger.getLogger(RequestLogFilter.class);

    }
}
