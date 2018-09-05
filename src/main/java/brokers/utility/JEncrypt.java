package brokers.utility;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.MessageDigest;

public class JEncrypt {

	private static String charsetName = "UTF8";
	private static String algorithm = "DES";
	private static String key = "ECO654RDS033FGV1";
	final static Logger LOGGER = LoggerFactory.getLogger(BasicUtil.class);

	public static String encrypt(String data) {
		if (key == null || data == null)
			return null;
		try {
			DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(charsetName));
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(algorithm);
			SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
			byte[] dataBytes = data.getBytes(charsetName);
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			String s = new String(Base64.encodeBase64(cipher.doFinal(dataBytes)));

			LOGGER.debug("Data-Enc:::" + s);
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("********Oops Something went wrong **********" + e);
			return null;
		}
	}

	public static String decrypt(String data) {

		if (key == null || data == null)
			return null;
		try {
			byte[] dataBytes = Base64.decodeBase64((data.getBytes()));
			DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(charsetName));
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(algorithm);
			SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] dataBytesDecrypted = (cipher.doFinal(dataBytes));
			String s = new String(dataBytesDecrypted);
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("********Oops Something went wrong **********" + e);
			return null;
		}
	}

	// encrypted key + Sourcecode + request ID
	public static String GenerateTokenSourcePassReq(String scode, String encryptedKey, String requestID) {
		StringBuffer sb = null;
		try {
			String spwd = JEncrypt.decrypt(encryptedKey);
			LOGGER.debug("decrypted======" + spwd);
			LOGGER.debug("encrypted======" + JEncrypt.encrypt("eco123456"));
			String data = requestID + scode + spwd;
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			// ** NOTE all bytes that are retrieved from the data string must be
			// done so using UTF-8 Character Set.
			byte[] hashBytes = data.getBytes("UTF-8");
			// Create the hash bytes from the data
			byte[] messageDigest = digest.digest(hashBytes);
			// Create a HEX string from the hashed data
			sb = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++) {
				String h = Integer.toHexString(0xFF & messageDigest[i]);
				while (h.length() < 2)
					h = "0" + h;
				sb.append(h);
			} 
		} catch (Exception e) {
			LOGGER.error("********Oops Something went wrong **********" + e);
		} 
		return sb.toString();

	}

	public static void main(String[] args) {
		String dmodule = JEncrypt.encrypt("123eco456RAPIDTRANSFERC4846LLJHHCL19");
		LOGGER.debug("+++++ dmodule ==> " + dmodule + " +++++");
		// String spwd = JEncrypt.decrypt("oWkX/PjkYZjHD11ANtdCOQ==");
		String gt = GenerateTokenSourcePassReq("CALYPSO", "WDdLEOXxrGU9/9n3Z93jFg==", "CAL7JJ88RXR");
		// System.out.println("gt====="+gt); 
	}
}
