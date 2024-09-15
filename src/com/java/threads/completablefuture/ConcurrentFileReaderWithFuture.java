package com.java.threads.completablefuture;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentFileReaderWithFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<String> filesList = Arrays.asList("E:\\Workspaces\\Intellij\\CoreJava\\src\\com\\java\\threads\\completablefuture\\file1", "E:\\Workspaces\\Intellij\\CoreJava\\src\\com\\java\\threads\\completablefuture\\file2","E:\\Workspaces\\Intellij\\CoreJava\\src\\com\\java\\threads\\completablefuture\\file3" );
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(String file : filesList){
            Future<String> future = executorService.submit(() -> readFile(file));
            if(future.isDone()){
                System.out.println(future.isDone());
            }
            futures.add(future);
        }
        for(Future<String> future : futures){
            String content = future.get();
            System.out.println(content);
        }
    }

    public static String readFile(String fileName) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = reader.readLine()) != null){
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }
}
