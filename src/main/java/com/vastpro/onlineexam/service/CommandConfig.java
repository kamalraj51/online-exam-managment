package com.vastpro.onlineexam.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommandConfig {

	String className;
	String success;
	String failure;
	
	public CommandConfig() {}
	
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
	
	//load properties
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
