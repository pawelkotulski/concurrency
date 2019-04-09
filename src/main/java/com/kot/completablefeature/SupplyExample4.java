package com.kot.completablefeature;

import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class SupplyExample4 {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            try {
                URL url = new URL("https://www.example.com/");
                try (InputStream is = url.openStream()) {
                    return new String(is.read());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).thenAccept(System.out::println)
                .thenRun(() -> System.out.println("Task finished"))
                .join();
    }
}
