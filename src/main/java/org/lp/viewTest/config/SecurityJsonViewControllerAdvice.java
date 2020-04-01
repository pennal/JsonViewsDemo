package org.lp.viewTest.config;

import org.lp.viewTest.views.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice;

import java.util.Map;
import java.util.stream.Stream;

@RestControllerAdvice
class SecurityJsonViewControllerAdvice extends AbstractMappingJacksonResponseBodyAdvice {
    private static final Logger logger = LoggerFactory.getLogger(SecurityJsonViewControllerAdvice.class);

    @Override
    protected void beforeBodyWriteInternal(MappingJacksonValue bodyContainer, MediaType contentType, MethodParameter returnType, ServerHttpRequest request, ServerHttpResponse response) {
        // Start by setting the default
        bodyContainer.setSerializationView(View.GuestUser.class);


        // This is extracting the role from the url param
        // as we do not have spring security and everything else set up
        Map<String, String[]> params = ((ServletServerHttpRequest) request).getServletRequest().getParameterMap();
        String[] roleArray = params.get("view");

        if (roleArray == null || roleArray.length == 0) {
            logger.warn("No valid role found. Setting GuestUser as view");
            return;
        }

        String role = roleArray[0];
        if (Stream.of("user", "admin").noneMatch(r -> r.equals(role))) {
            logger.warn("Role provided does not match any. Setting GuestUser as view");
            return;
        }

        // Set the correct role
        Class<?> view = role.equals("user") ? View.AuthenticatedUser.class : View.Admin.class;
        bodyContainer.setSerializationView(view);
        logger.info("Setting " + view + " as serialization view");
    }
}
