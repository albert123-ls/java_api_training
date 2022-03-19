package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Launcher {
    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        HttpServer server = null;
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
            System.out.println("server started at " + port);
            server.createContext("/ping", new PingHandler());
            server.setExecutor(executorService);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
