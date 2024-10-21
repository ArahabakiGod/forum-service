package ait.cohort46.security.filter;

import ait.cohort46.accounting.dao.AccountingRepository;
import ait.cohort46.accounting.model.Role;
import ait.cohort46.accounting.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Order(20)
public class AdminManagingRollsFilter implements Filter {
    private final AccountingRepository accountingRepository;
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if (checkEndpoint(request.getMethod(), request.getServletPath())) {
            User user = accountingRepository.findById(request.getUserPrincipal().getName()).get();
            if (!user.getRoles().contains(Role.ADMINISTRATOR)) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                return;
            }
        }
        //TODO
        chain.doFilter(request, response);
    }

    private boolean checkEndpoint(String method, String path) {
        return path.matches("/account/user/\\w+/role/\\w+");
    }
}
