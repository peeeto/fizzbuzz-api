package org.pch.web.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: short description
 * <p/>
 * Created by petercho on 08/07/15.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

  @Bean
  public LocalValidatorFactoryBean validator() throws Exception {
    final LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
    bean.setProviderClass(HibernateValidator.class);
    return bean;
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer
        .favorPathExtension(false)
        .parameterName("format")
        .ignoreAcceptHeader(true)
        .useJaf(false)
        .favorParameter(true)
        .defaultContentType(MediaType.APPLICATION_JSON);
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
    converters.add(new FormHttpMessageConverter());
    MappingJackson2HttpMessageConverter jackson = new MappingJackson2HttpMessageConverter();
    jackson.setPrettyPrint(true);
    converters.add(jackson);

    List<MediaType> mediaType = new ArrayList<>();
    mediaType.add(MediaType.TEXT_XML);
    mediaType.add(MediaType.APPLICATION_XML);

    MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();
    xmlConverter.setSupportedMediaTypes(mediaType);

    XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
    xstreamMarshaller.setEncoding("UTF-8");
    xmlConverter.setMarshaller(xstreamMarshaller);
    xmlConverter.setUnmarshaller(xstreamMarshaller);

    converters.add(xmlConverter);
  }
}
