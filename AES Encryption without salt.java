import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

class Scratch {

    private static final int IV_LENGTH_BYTE = 16;
    private static final byte[] initVector = getRandomNonce(IV_LENGTH_BYTE);
    private static final String ENCRYPT_ALGO = "AES/CBC/PKCS5Padding";

    private static final String PASSWORD = "qwerty";

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        String originalString = "String to be encrypted";
        System.out.println("Original String to encrypt - " + originalString);
        byte[] encryptedString = encrypt(originalString, PASSWORD);
        writeFile(encryptedString);
        String decryptedString = decrypt(readFile(), PASSWORD);
        System.out.println("After decryption - " + decryptedString);

//        System.out.println(Arrays.toString(getKey(PASSWORD)));
    }

    private static byte[] readFile() {
        FileInputStream fin = null;
        File file = new File("C:\\Users\\manjap\\Downloads\\scanConfiguration.scanfile");
        try {
            // create FileInputStream object
            fin = new FileInputStream(file);
            byte fileContent[] = new byte[(int) file.length()];

            // Reads up to certain bytes of data from this input stream into an array of bytes.
            fin.read(fileContent);

//            create string from byte array
//            String s = new String(fileContent);
//            System.out.println("File content: " + s);

            return fileContent;
        }
        catch (Exception e) {
            System.out.println("File not found" + e);
        }
        return null;
    }

    private static void writeFile(byte[] encryptedString) throws IOException {
        Files.write(new File("C:\\Users\\manjap\\Downloads\\scanConfiguration.scanfile").toPath(), encryptedString);
    }

    public static byte[] encrypt(String value, String password) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(getKey(password), "AES");

            Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(initVector));

            byte[] cipherText = cipher.doFinal(value.getBytes());

            return ByteBuffer.allocate(initVector.length + cipherText.length)
                    .put(initVector)
                    .put(cipherText)
                    .array();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String decrypt(byte[] encrypted, String password) {

        ByteBuffer bb = ByteBuffer.wrap(encrypted);

        byte[] initVector = new byte[IV_LENGTH_BYTE];
        bb.get(initVector);

        byte[] cipherText = new byte[bb.remaining()];
        bb.get(cipherText);

        try {
            SecretKeySpec skeySpec = new SecretKeySpec(getKey(password), "AES");

            Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(initVector));
            byte[] original = cipher.doFinal(cipherText);

            return new String(original);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    private static byte[] getKey(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    public static byte[] getRandomNonce(int numBytes) {
        byte[] nonce = new byte[numBytes];
        new SecureRandom().nextBytes(nonce);
        return nonce;
    }
}
