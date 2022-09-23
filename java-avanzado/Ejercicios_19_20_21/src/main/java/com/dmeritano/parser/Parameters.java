package com.dmeritano.parser;

/**  
 * Enum Parameters Class
 * List of parameters defined in the context of this application. 
        Two types of parameters are accepted (key value style) and flag type. 
        Examples:
        --minval 100    (key value parameter)
        --compress      (flag type parameter)       
 */
public enum Parameters
{
        /* Enum second's parameter (true or false) indicates if a parameter
           is a "key value" type ( true ) or "flag type" (false)
        */    
    
        PARAM_MAX_VALUE("--maxvalue",true), 
        PARAM_MIN_VALUE("--minvalue",true),
        PARAM_HASHCODE("--hashcode", true),
        PARAM_COMPRESS("--compress", false),
        PARAM_SERVICE_URL("--compress", true),
        PARAM_SERVICE_USER("--user", true),
        PARAM_SERVICE_USER_ROLE("--role", true);

	
	private final String paramName;
	private final boolean keyValueParam;
	
	private Parameters (String paramName, boolean keyValueParam){
		this.paramName = paramName;
		this.keyValueParam = keyValueParam;
	}

	public boolean isKeyValueParam() {
		return keyValueParam;
	}	
         
	public String getParamName() {
		return paramName;
	}        	
}