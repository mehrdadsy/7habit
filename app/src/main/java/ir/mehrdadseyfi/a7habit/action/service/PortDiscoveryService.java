package ir.mehrdadseyfi.a7habit.action.service;

import android.util.Log;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 * @author Nancy
 * @version 1.0
 */
public final class PortDiscoveryService {
    private static final int DEFAULT_START_PORT = 8765;
    private static final int MAXIMUM_PORT = 12000;
    private static int discoveredOpenPort;

    private static void discoverOpenPort() {
        discoveredOpenPort = discoverOpenPort(DEFAULT_START_PORT);
        Log.d("PortDiscovery", "Discovered open port: " + discoveredOpenPort);
    }

    private static int discoverOpenPort(int startPort) {
        if(startPort > MAXIMUM_PORT) {
            throw new IllegalStateException("Could not discover any open port.");
        }
        int result;
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", startPort));
            serverSocket.close();
            result = startPort;
            Log.d("PortDiscovery", "Bound to port: " + startPort + " successfully.");
        } catch (IOException e) {
            Log.d("PortDiscovery", "Cannot bind to Port: " + startPort + ", trying next one.");
            result = discoverOpenPort(startPort + 1);
        }
        return result;
    }

    public static int getOpenPort() {
        return discoveredOpenPort;
    }

    public static void discoverOpenPortInBackground() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                discoverOpenPort();
            }
        }).start();
    }
}
