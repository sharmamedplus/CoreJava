package com.java.streams.parrallel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParrallelExecutionOfBigSizeList {
    public static void main(String[] args) {
        List<Long> gridList = new ArrayList<>();
        for(int i = 0; i< 1001; i++){
            gridList.add(Long.valueOf(i));
        }
        int gridListSize = gridList.size();
        int fullChunks = (gridListSize - 1) / 500;
        IntStream.range(0, fullChunks + 1)
                .mapToObj(n -> gridList.subList(n * 500, n == fullChunks ? gridListSize : (n + 1) * 500))
                .collect(Collectors.toList()).parallelStream().forEach(grids ->{
                    System.out.println(grids.size());
                    // Do your logic here with max 500 grids each time
                });



    }

    private void getAllCaseDetails(){
        List<Long> caseIds = new ArrayList<>();

    }
}
