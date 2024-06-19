package com.event_manager.eventsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The main entry point for the Events Project Application.
 * <p>
 * This is a Spring Boot application that manages events. The main class
 * contains the {@code main} method which is the starting point of the
 * application. It also contains a nested configuration class for setting
 * up additional web configurations.
 * </p>
 */
@SpringBootApplication
public class EventsProjectApplication {

	/**
	 * The main method which serves as the entry point of the Spring Boot application.
	 * <p>
	 * This method uses {@link SpringApplication#run(Class, String...)} to launch
	 * the application.
	 * </p>
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(EventsProjectApplication.class, args);
	}

	/**
	 * Configuration class for additional web settings.
	 * <p>
	 * This class implements {@link WebMvcConfigurer} to add custom resource handlers
	 * for serving static files. It specifically maps requests to the /uploads/ URL
	 * path to files located in the file system at the uploads directory.
	 * </p>
	 */
	@Configuration
	public static class WebConfig implements WebMvcConfigurer {

		/**
		 * Configures resource handlers to serve static resources.
		 * <p>
		 * This method maps the /uploads/** URL path to the physical directory
		 * where uploaded files are stored. By doing so, it allows clients to
		 * access files uploaded to the server via the /uploads/ URL path.
		 * </p>
		 *
		 * @param registry a {@link ResourceHandlerRegistry} object to configure the resource handlers
		 */
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/uploads/**")
					.addResourceLocations("file:uploads/");
		}
	}
}
