package com.king.collection;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ConcurrentHashMapTest {
    private static int THREAD_COUNT = 10;
    private static int ITEM_COUNT = 1000;
    private ConcurrentHashMap<String, Long> getData(int count) {
//        LongStream.rangeClosed(1,count)
//                .boxed()
//                .collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(),(o1, o2) -> o1, ConcurrentHashMap::new));
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        forkJoinPool.execute(() ->{});
        return null;
    }


}
