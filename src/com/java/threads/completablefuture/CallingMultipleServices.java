package com.java.threads.completablefuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CallingMultipleServices {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<CompletableFuture<String>> futures = new ArrayList<>();
        Arrays.asList("1", "2", "3", "4").forEach( task -> {
             CompletableFuture.supplyAsync(() -> executeTask(task), executorService);
        });

        CompletableFuture.allOf((CompletableFuture<?>) futures).join();
        executorService.shutdown();
        //System.out.println(response);
    }


    private static String executeTask(String task){
        System.out.println("Task : "+task);
        return task;
    }
}
