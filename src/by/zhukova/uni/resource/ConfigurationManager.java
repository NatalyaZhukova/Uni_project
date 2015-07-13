package by.zhukova.uni.resource;

import java.util.ResourceBundle;
/** 
* The Class ConfigurationManager is designed to work with config resource
*
* @author Natallya Zhukova
* @since 1.0
*/
public class ConfigurationManager {
	private final static ResourceBundle resourceBundle = ResourceBundle
			.getBundle("config");

	private ConfigurationManager() {
	}
	/** 
	* The method gets property value by given key
	* @param key
	* @return string
	*/
	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
