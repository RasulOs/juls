package juls.crypto;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Optional;

public class AES {

    private final IvParameterSpec ivParameterSpec;

    private final KeyGenerator keyGenerator;

    private final SecretKey secretKey;

    public AES() {
        ivParameterSpec = generateIv();
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            secretKey = keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public String encryptString(String input) {

        String ret = null;

        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

            byte[] encrypted = cipher.doFinal(input.getBytes());

            ret = Base64.getEncoder().encodeToString(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not encrypt the string: " + input);
        }

        return ret;
    }

    public String decryptString(String encodedInput) {

        String ret = null;

        try {

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

            byte[] decoded = cipher.doFinal(Base64.getDecoder().decode(encodedInput));

            ret = new String(decoded);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not decrypt the string: " + encodedInput);
        }

        return ret;
    }

    private IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public KeyGenerator getKeyGenerator() {
        return keyGenerator;
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }

    public IvParameterSpec getIvParameterSpec() {
        return ivParameterSpec;
    }
}
