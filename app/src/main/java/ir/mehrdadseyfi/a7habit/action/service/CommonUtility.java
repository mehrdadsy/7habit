package  ir.mehrdadseyfi.a7habit.action.service;


import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;



public final class CommonUtility {

    private static final int ENCRYPTION_DEPTH = 3;

    public static String deepEncryptString(String plainText) {
        String result = plainText;
        for (int i = 0; i < ENCRYPTION_DEPTH; i++) {
//            result = encryptString(result);
        }
        return result;
    }

    public static String deepDecryptString(String encryptedText) {
        String result = encryptedText;
        for (int i = 0; i < ENCRYPTION_DEPTH; i++) {
            result = decryptString(result);
        }
        return result;
    }

//    public static String encryptString(String plainText) {
//        try {
//            InputStream inputStream = encryptInputStream(new ByteArrayInputStream(plainText.getBytes("UTF-8")));
//            return Hex.encodeHexString(IOUtils.toByteArray(inputStream));
//        } catch (IOException e) {
//            return null;
//        }
//    }

    public static String encryptBytes(byte[] bytes) {

            InputStream inputStream = encryptInputStream(new ByteArrayInputStream(bytes));
           String i= "ddffaasass";
            return i;

    }

    public static String decryptString(String encryptedText) {
        try {
            InputStream inputStream = decryptInputStream(new ByteArrayInputStream(Hex.decodeHex(encryptedText.toCharArray())));
            return IOUtils.toString(inputStream, "UTF-8");
        } catch (IOException | DecoderException e) {
            return null;
        }
    }

    public static void decryptFile(File sourceFile, File targetFile) {
        transformFile(sourceFile, targetFile, Cipher.DECRYPT_MODE);
    }

    public static void transformFile(File sourceFile, File targetFile, int cipherMode) {
        try {
            FileInputStream inputStream = new FileInputStream(sourceFile);

            int length = (int) sourceFile.length();
            byte[] buffer = new byte[1024];

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(length);

            int count;
            while ((count = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, count);
            }

            byte[] encryptedBytes = outputStream.toByteArray();

            OutputStream decryptingOutputStream = transformOutputStream(new FileOutputStream(targetFile), cipherMode);

            decryptingOutputStream.write(encryptedBytes);
            decryptingOutputStream.close();
        } catch (Throwable t) {
            throw new RuntimeException("Could not decrypt/encrypt file: " + sourceFile.getName(), t);
        }
    }

    public static void encryptDirectory(File source, File destination) {
        if (!destination.isDirectory()) {
            boolean success = destination.mkdirs();
            if (!success) {
                throw new RuntimeException("Cannot create directory:" + destination.getAbsolutePath());
            }
        }

        File[] files = source.listFiles();
        if (files != null) {
            for (File file : files) {
                if (!file.getName().startsWith(".")) {
                    if (file.isDirectory()) {
                        encryptDirectory(file, new File(destination, file.getName()));
                    } else {
                        encryptFile(file, new File(destination, file.getName()));
                    }
                }
            }
        }
    }

    public static void encryptFile(File sourceFile, File targetFile) {
        transformFile(sourceFile, targetFile, Cipher.ENCRYPT_MODE);
    }

    public static InputStream transformInputStream(InputStream inputStream, int cipherMode) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            SecretKeySpec secretKeySpec = new SecretKeySpec(KEY, "AES");
            AlgorithmParameterSpec algorithmParameterSpec = new IvParameterSpec("seed123456789021".getBytes());
            cipher.init(cipherMode, secretKeySpec, algorithmParameterSpec);
            return new CipherInputStream(inputStream, cipher);
        } catch (Throwable t) {
            throw new RuntimeException("Could not decrypt/encrypt input stream", t);
        }
    }

    private static final byte[] KEY = "0AESKeyCoaches21".getBytes();

    public static OutputStream transformOutputStream(OutputStream outputStream, int cipherMode) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            SecretKeySpec secretKeySpec = new SecretKeySpec(KEY, "AES");
            AlgorithmParameterSpec algorithmParameterSpec = new IvParameterSpec("seed123456789021".getBytes());
            cipher.init(cipherMode, secretKeySpec, algorithmParameterSpec);
            return new CipherOutputStream(outputStream, cipher);
        } catch (Throwable t) {
            throw new RuntimeException("Could not decrypt/encrypt output stream", t);
        }
    }

    public static InputStream decryptInputStream(InputStream inputStream) {
        return transformInputStream(inputStream, Cipher.DECRYPT_MODE);
    }

    public static InputStream encryptInputStream(InputStream inputStream) {
        return transformInputStream(inputStream, Cipher.ENCRYPT_MODE);
    }

    public static int getWeekNumber() {
        Calendar nowCalendar = Calendar.getInstance();
        nowCalendar.setTime(new Date());
        return nowCalendar.get(Calendar.WEEK_OF_YEAR);
    }
}
