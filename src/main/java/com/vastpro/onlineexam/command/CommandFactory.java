package com.vastpro.onlineexam.command;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Class Name: CommandFactory
 *
 * Description:
 * This class is responsible for creating instances of command classes
 * based on the action requested by the user.
 *
 * It follows the Factory design pattern and loads command configurations
 * from a properties file only once when the class is loaded.
 *
 * The command configurations map action names to CommandConfig objects,
 * which store the fully qualified class name, success path, and failure path.
 */
public class CommandFactory {
	
	public static Properties commandProperties = new Properties();
	
    public static Map<String, CommandConfig> configMap = null;
    
    // Static block to load properties and initialize configuration map
    static {
    
		// Load properties only once when class is loaded
    	try (InputStream is = CommandFactory.class
                .getClassLoader()
                .getResourceAsStream("com/vastpro/onlineexam/resources/config.properties")) {

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

    /**
     * Returns an instance of the command class corresponding to the given action.
     *
     * @param action the action name requested by the user
     * @return an instance of the corresponding Command, or null if action is missing or invalid
     * @throws RuntimeException if the command class cannot be instantiated
     */
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
