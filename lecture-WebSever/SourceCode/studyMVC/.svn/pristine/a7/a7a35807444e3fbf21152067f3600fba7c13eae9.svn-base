package kr.or.nextit.properties;

import java.util.Locale;
import java.util.Properties;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PropertiesController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "messageSource") // ;;messageSource-context.xml refer
	private MessageSource messageSource;

	@Resource(name="propertyService")
	private Properties propertiesService;

	@RequestMapping(value = "/properties/propertiesTest")
	public String propertiesTest() {
		// ;다국어 처리 사용 방법

		String[] locale = Locale.getISOLanguages();

		log.debug("Locale Languages Length : {}", locale.length);
		for (String string : locale) {
			String display = Locale.forLanguageTag(string).getDisplayLanguage();
			log.debug("Each Language Info : {} = {}", string, display);
		}

		System.out.printf(">>> ===================================================================\n");

		locale = Locale.getISOCountries();
		log.debug("Locale Countries Length : {}", locale.length);
		for (String string : locale) {
			String display = Locale.forLanguageTag(string).getDisplayLanguage();
			log.debug("Each Country Info : {} = {}", string, display);
		}

		System.out.printf(">>> ===================================================================\n");

		// ;from properties file on java
		// ;;exA)
		String msg01 = messageSource.getMessage("TITLE", null, Locale.getDefault());
		messageSource.getMessage("TITLE", null, Locale.getDefault());
		log.debug("msg01 : {}", msg01);

		// ;;exB)
		Object[] args = { "GDragon", "Gunbary" };
		String msg02 = messageSource.getMessage("VISITOR", args, Locale.getDefault());
		log.debug("msg02 : {}", msg02);

		// ;;exC)
		String msg03 = messageSource.getMessage("TITLE", null, Locale.KOREA);
		messageSource.getMessage("TITLE", null, Locale.getDefault());
		log.debug("msg03 : {}", msg03);

		// ;;exD)
		Object[] args02 = { "지드래곤", "군바리" };
		String msg04 = messageSource.getMessage("VISITOR", args, Locale.KOREA);
		log.debug("msg04 : {}", msg04);
		

		System.out.printf(">>> ===================================================================\n");

		return "properties/propertiesTest";
	}

	@RequestMapping(value = "/properties/propertiesTest2")
	public String propertiesTest2() {
		// ; 프로퍼티스 공통 사용 방법
		
		log.debug("file.upload.path : {}", propertiesService.getProperty("file.upload.path"));
		log.debug("dev.driver : {}", propertiesService.getProperty("dev.driver"));
		log.debug("dev.url : {}", propertiesService.getProperty("dev.url"));
		log.debug("dev.username : {}", propertiesService.getProperty("dev.username"));
		log.debug("admin : {}", propertiesService.getProperty("admin"));

		return "properties/propertiesTest2";
	}

}
