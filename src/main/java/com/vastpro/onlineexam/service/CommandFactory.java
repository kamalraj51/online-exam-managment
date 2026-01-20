package com.vastpro.onlineexam.service;

import java.io.InputStream;

import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vastpro.onlineexam.controller.ControllerServlet;

public class CommandFactory {
	
	public static Properties commandProperties = new Properties();
	
    public static Map<String, CommandConfig> configMap = null;
    static {
    
		// Load properties only once when class is loaded
    	try (InputStream is = CommandFactory.class
                .getClassLoader()
                .getResourceAsStream("com/vastpro/resource/servlet.properties")) {

            if (is == null) {
                throw new RuntimeException("config.properties file not found in classpath");
            }

            commandProperties.load(is);
           // logger.debug("Porperty file loaded : "+is);
            if(commandProperties != null) {
            	configMap = CommandConfig.loadConfigurations(commandProperties);
            	
            }
          //  logger.debug("configuration maping created : "+configMap);
        } catch (Exception e) {
      //  	logger.error("Failed to load command mappings : "+e.getMessage());
            throw new RuntimeException("Failed to load command mappings", e);
        }
    }
   
    private CommandFactory() {
        // Prevent object creation
    }

    public static Command getCommand(String action) {

        try {
        	if(action == null) {
        		System.out.println("Missing action...");
        		return null;
        	}
        	
        	String commandClassName = configMap.get(action).getClassName();
        	System.out.println("commandClassName : "+commandClassName);
            if (commandClassName == null) {
                return null;
            }

            Class<?> clazz = Class.forName(commandClassName);
            System.out.println("clazz : "+(Command) clazz.getDeclaredConstructor().newInstance());
            return (Command) clazz.getDeclaredConstructor().newInstance();

        } catch (Exception e) {
      //  	logger.error("Unable to create command for action: " + action, e.getMessage());
            throw new RuntimeException("Unable to create command for action: " + action, e);
        }
    }
}
