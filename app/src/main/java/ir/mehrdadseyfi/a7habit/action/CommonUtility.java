package ir.mehrdadseyfi.a7habit.action;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author Sam
 * @version 1.0
 * @since 1.0-MVP
 */
@SuppressWarnings("UnusedDeclaration")
public final class CommonUtility {

//    private static final String TAG = "CommonUtility";
    //TODO @Sam needs to be MD5-sum of another complex key and possibly hard to break.
    private static final byte[] KEY = "0AESKeyCoaches21".getBytes();

    public static String readStream(InputStream inputStream) {
        try {
            return IOUtils.toString(inputStream, "UTF-8");
        } catch (IOException e) {
//            Log.e(TAG, "Failed to read input stream \"" + inputStream + "\"");
//            Log.d(TAG, "Caused by:", e);
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
//            Log.d(TAG, "Could not decrypt/encrypt file: " + sourceFile.getName(), t);
            throw new RuntimeException("Could not decrypt/encrypt file: " + sourceFile.getName(), t);
        }
    }

    //    TODO @Sam needs to be moved to a maven plugin
    public static void main(String[] args) {
//        File source = new File("/home/conscript/Projects/android-scorm-player/assets_raw");
//        File destination = new File("/home/conscript/Projects/android-scorm-player/assets_enc");
        File source = new File("assets_raw");
        File destination = new File("assets_enc");
        encryptDirectory(source, destination);
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


    public static boolean isDataEncryptionEnabled() {
        return true;
    }

    public static InputStream transformInputStream(InputStream inputStream, int cipherMode) {
        if (isDataEncryptionEnabled()) {
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

                SecretKeySpec secretKeySpec = new SecretKeySpec(KEY, "AES");
                AlgorithmParameterSpec algorithmParameterSpec = new IvParameterSpec("seed123456789021".getBytes());
                cipher.init(cipherMode, secretKeySpec, algorithmParameterSpec);
                return new CipherInputStream(inputStream, cipher);
            } catch (Throwable t) {
//                Log.d(TAG, "Could not decrypt/encrypt input stream");
                throw new RuntimeException("Could not decrypt/encrypt input stream", t);
            }
        } else {
            return inputStream;
        }
    }

    public static OutputStream transformOutputStream(OutputStream outputStream, int cipherMode) {
        if (isDataEncryptionEnabled()) {
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

                SecretKeySpec secretKeySpec = new SecretKeySpec(KEY, "AES");
                AlgorithmParameterSpec algorithmParameterSpec = new IvParameterSpec("seed123456789021".getBytes());
                cipher.init(cipherMode, secretKeySpec, algorithmParameterSpec);
                return new CipherOutputStream(outputStream, cipher);
            } catch (Throwable t) {
//                Log.d(TAG, "Could not decrypt/encrypt output stream");
                throw new RuntimeException("Could not decrypt/encrypt output stream", t);
            }
        } else {
            return outputStream;
        }
    }

    public static InputStream decryptInputStream(InputStream inputStream) {
        return transformInputStream(inputStream, Cipher.DECRYPT_MODE);
    }

}
