package by.zhukova.uni.logic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.log4j.Logger;

public class MD5Digest {
	static Logger logger = Logger.getLogger(MD5Digest.class);

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
