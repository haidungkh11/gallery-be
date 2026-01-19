package vtb.itd.cba.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

//import com.vietinbank.stm.interceptor.AuthenInterceptor;
//import com.vietinbank.stm.interceptor.LogInterceptor;

/**
 * @author DuongNT Message resources and interceptors
 * 
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:i18n/business/messages",
								   "classpath:i18n/label/messages",	
								   "classpath:i18n/validation/messages");
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(5);
		return messageSource; // load to memory
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		// slr.setDefaultLocale(Locale.US);
		Locale locale;
		locale = new Locale("vi", "VN");
		sessionLocaleResolver.setDefaultLocale(locale);
		return sessionLocaleResolver;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}

	@Bean
	@Override
	public org.springframework.validation.Validator getValidator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		return localValidatorFactoryBean;
	}

	//register Intercept  >> Intercepter will be executed before call to controller , Very careful when override this method	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(localeChangeInterceptor());

		//registry.addInterceptor(new LogInterceptor());

		//registry.addInterceptor(new AuthenInterceptor()).excludePathPatterns("/","/login/**","/logout/**");
	}

}