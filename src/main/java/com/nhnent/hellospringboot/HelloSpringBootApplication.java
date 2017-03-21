package com.nhnent.hellospringboot;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestAttributes;

import com.nhnent.hellospringboot.dao.MemberRepository;

@SpringBootApplication
public class HelloSpringBootApplication {
    
    @Autowired
    MemberRepository memberRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootApplication.class, args);
	}
	/*
	@Bean
	public DefaultErrorAttributes errorAttributes() {
	    
	    return new DefaultErrorAttributes() {
	        
	        @Override
	        public Map<String, Object> getErrorAttributes(
	                RequestAttributes requestAttributes, boolean includeStackTrace) {
	            
	            includeStackTrace = true;
	            Map<String, Object> errorAttributes =
                    super.getErrorAttributes(requestAttributes, includeStackTrace);
	            errorAttributes.put("custom_data", 
	                    requestAttributes.getAttribute("custom_data", RequestAttributes.SCOPE_REQUEST));
	            
	            return errorAttributes;
	        }
	    };
	}*/
	
    @Bean
    public BasicErrorController errorController(
            ErrorAttributes errorAttributes, ServerProperties serverProperties) {
        
        return new BasicErrorController(errorAttributes, serverProperties.getError()) {
            
            protected Map<String, Object> getErrorAttributes(
                    HttpServletRequest request, boolean includeStackTrace) {
                
                Map<String, Object> errorAttr = super.getErrorAttributes(request, includeStackTrace);
                
                //custom code
                
                return errorAttr;
            }
        };
    }
}
