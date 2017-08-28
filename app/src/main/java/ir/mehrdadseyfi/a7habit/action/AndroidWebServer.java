package  ir.mehrdadseyfi.a7habit.action;

import android.content.Context;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.Map;
import java.util.Random;

import javax.crypto.Cipher;

import fi.iki.elonen.NanoHTTPD;
import ir.mehrdadseyfi.a7habit.action.service.PortDiscoveryService;

import static fi.iki.elonen.NanoHTTPD.Response.Status.INTERNAL_ERROR;
import static fi.iki.elonen.NanoHTTPD.Response.Status.OK;

/**
 * @author <a href="mailto:siavash.mehrabi@gmail.com">Conscript</a>
 * @version 1.0
 * @since 1.0-MVP
 */
@SuppressWarnings("UnusedDeclaration")
public class AndroidWebServer {
    private static final String TAG = "AndroidWebServer";
    private static final String MIME_MP3 = "audio/mpeg3";
    private static final String MIME_MP4 = "video/mp4";
    private static final String MIME_PDF = "application/pdf";
    private static final String MIME_XML = "application/xml";

    private static final String MIME_JS = "application/x-javascript";
    private static final String MIME_CSS = "text/css";
    private static final String MIME_PNG = "image/png";
    private static final String MIME_JPG = "image/jpeg";
    private static NanoHTTPD server;
    private static Context applicationContext;

    public static void setContext(Context context) {
        applicationContext = context;
    }

    public static void start() {
        try {
            server = new DefaultHttpDaemon(PortDiscoveryService.getOpenPort());
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        if (server != null) {
            server.stop();
        }
    }

    public static boolean isAlive() {
        return server != null && server.isAlive();
    }

    private static class DefaultHttpDaemon extends NanoHTTPD {
        private final Response.IStatus HTTP_OK = OK;
        private final Response.IStatus HTTP_ERROR = INTERNAL_ERROR;

        private DefaultHttpDaemon(int port) {
            super(null, port);
        }

        @SuppressWarnings("deprecation")
        @Override
        public Response serve(String uri, Method method, Map<String, String> headers, Map<String, String> parms, Map<String, String> files) {
            Log.d(TAG, "SERVE ::  URI " + uri);
            InputStream resourceInputStream;

            try {
                if (uri != null) {
                    if (uri.contains(".js")) {
                        InputStream data = getUriAsStream(uri);
                        return new NanoHTTPD.Response(HTTP_OK, MIME_JS, data);
                    } else if (uri.contains(".css")) {
                        InputStream data = getUriAsStream(uri);
                        return new NanoHTTPD.Response(HTTP_OK, MIME_CSS, data);
                    } else if (uri.contains(".png")) {
                        InputStream data = getUriAsStream(uri);
                        return new NanoHTTPD.Response(HTTP_OK, MIME_PNG, data);
                    } else if (uri.contains(".jpg")) {
                        InputStream data = getUriAsStream(uri);
                        return new NanoHTTPD.Response(HTTP_OK, MIME_JPG, data);
                    } else if (uri.contains(".mp3")) {
                        InputStream data = getUriAsStream(uri);
                        return new Response(HTTP_OK, MIME_MP3, data);
                    } else if (uri.contains(".mp4") || uri.contains(".m4v")) {
                        InputStream data = getUriAsStream(uri);
                        return new Response(HTTP_OK, MIME_MP4, data);
                    } else if (uri.contains(".pdf")) {
                        InputStream data = getUriAsStream(uri);
                        return new Response(HTTP_OK, MIME_PDF, data);
                    } else if (uri.contains(".xml")) {
                        InputStream data = getUriAsStream(uri);
                        return new Response(HTTP_OK, MIME_XML, data);
                    } else if (uri.contains("/mnt/sdcard")) {
                        Log.d(TAG, "request for media on sdCard " + uri);
                        File request = new File(uri);
                        resourceInputStream = new FileInputStream(request);
                        FileNameMap fileNameMap = URLConnection.getFileNameMap();
                        String mimeType = fileNameMap.getContentTypeFor(uri);

                        Response streamResponse = new Response(HTTP_OK, mimeType, resourceInputStream);
                        Random rnd = new Random();
                        String etag = Integer.toHexString(rnd.nextInt());
                        streamResponse.addHeader("ETag", etag);
                        streamResponse.addHeader("Connection", "Keep-alive");
                        return streamResponse;
                    } else {
                        InputStream data = getUriAsStream(uri);
                        return new NanoHTTPD.Response(HTTP_OK, MIME_HTML, data);
                    }
                }
            } catch (IOException e) {
                Log.d(TAG, "Error opening file: " + uri.substring(1));
                e.printStackTrace();
            }
            return new NanoHTTPD.Response(HTTP_ERROR, MIME_HTML, "<html><body>Could not process request.</body></html>");
        }
    }

    private static InputStream getUriAsStream(String uri) throws IOException {
        InputStream resourceInputStream;
        resourceInputStream = CommonUtility.transformInputStream(applicationContext.getAssets().open(uri.substring(1)), Cipher.DECRYPT_MODE);
        byte[] buffer = new byte[1024];
        int readCount;
        ByteArrayOutputStream temporaryStorage = new ByteArrayOutputStream();
        while ((readCount = resourceInputStream.read(buffer)) != -1) {
            temporaryStorage.write(buffer, 0, readCount);
        }
        return new ByteArrayInputStream(temporaryStorage.toByteArray());
    }
}
