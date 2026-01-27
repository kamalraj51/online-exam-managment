package com.vastpro.onlineexam.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Class Name: CommandConfig
 *
 * Description:
 * This class represents the configuration details of a command.
 *
 * It stores the fully qualified command class name and the
 * navigation paths for success and failure outcomes.
 *
 * This class is also responsible for loading command configurations
 * from a properties file and converting them into a usable map.
 */
public class CommandConfig {

	String className;
	String success;
	String failure;
	
	public CommandConfig() {}
	
	 /**
     * Parameterized constructor to initialize command configuration.
     *
     * @param className fully qualified command class name
     * @param success navigation path on successful execution
     * @param failure navigation path on failed execution
 	 */
	public CommandConfig(String className, String success, String failure) {
		super();
		this.className = className;
		this.success = success;
		this.failure = failure;
	}
	
	@Override
	public String toString() {
		return "CommandConfig [className=" + className + ", success=" + success + ", failure=" + failure + "]";
	}
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getFailure() {
		return failure;
	}
	public void setFailure(String failure) {
		this.failure = failure;
	}
	
    /**
     * Loads command configurations from a properties object.
     *
     * Each entry in the properties file contains the command class
     * name along with success and failure navigation paths.
     *
     * @param commandMappings Properties object containing command mappings
     * @return a map of command names to their corresponding CommandConfig objects
     */
    public static Map<String, CommandConfig> loadConfigurations(Properties commandMappings) {
    	Map<String, CommandConfig> configMap = new HashMap<String, CommandConfig>();
    	if(commandMappings != null) {
    		
    		for (String key : commandMappings.stringPropertyNames()) {
    		    String value = commandMappings.getProperty(key);

    		    String[] tokens = value.split(",");
    		    String commandClass = tokens[0];
    		    String success = "";
    		    String failure = "";
    		    for(int i=0;i<tokens.length;i++) {
    		    	if(tokens[i].equals("/controller?action=authorize")) {
    		    		continue;
    		    	}
    		    	String[] pair = tokens[i].split("=");
    		    	if ("success".equals(pair[0])) {
    		    		success = pair[1];
    		        } else if ("failure".equals(pair[0])) {
    		        	failure = pair[1];
    		        }
    		    }
    		    
    		    CommandConfig cmdConfig = new CommandConfig(commandClass,success,failure);
    		    configMap.put(key, cmdConfig);
    		}
    	}
    	return configMap;
    }

}
