package by.zhukova.uni.logic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.log4j.Logger;
/** 
* The Class StringUtils contains the methods which work with {@code String} objects for this project
*
* @author Natallya Zhukova
* @since 1.0
*/
public class StringUtils {
	static Logger logger = Logger.getLogger(StringUtils.class);
/** 
* The method returns the string encrypted by MD5
* @param password
* @return string
*/
	public static String getMD5String(String password) {

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}

			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			logger.error(e);
			return password;
		}

	}

}
