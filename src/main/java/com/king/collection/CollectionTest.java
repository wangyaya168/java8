package com.king.collection;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class CollectionTest {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        simpleDateFormat.format(new Date());
        System.out.println("13".hashCode());
        System.out.println("22".hashCode());
    }
}
