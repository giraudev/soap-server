package com.giraudev.soapserver.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

//todo: 1 colocar anotações Spring
@Configuration
@EnableWs
public class WSConfig extends WsConfigurerAdapter {

   //todo: 2 criar os 3 métodos obrigatórios
    @Bean
    public ServletRegistrationBean messageDispatcherServlet (ApplicationContext applicationContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/soapws/*");
    }

    @Bean(name = "articles")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema articlesSchema) {
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("ArticlePort");
        defaultWsdl11Definition.setLocationUri("/soapes");
        defaultWsdl11Definition.setTargetNamespace("http://giraudev.com/soap-server");
        defaultWsdl11Definition.setSchema(articlesSchema);
        return defaultWsdl11Definition;
    }

    @Bean
    public XsdSchema articlesSchema(){
        return new SimpleXsdSchema(new ClassPathResource("./articles.xsd"));
    }
}
