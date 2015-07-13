package by.zhukova.uni.resource;

import java.util.ResourceBundle;
/** 
* The Class MessageManager is designed to work with locale resources
*
* @author Natallya Zhukova
* @since 1.0
*/
public class MessageManager {
	private final static ResourceBundle resourceBundle = ResourceBundle
			.getBundle("message");

	private MessageManager() {
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