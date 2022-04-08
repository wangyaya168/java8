package com.king.shangxuegu;

public class Test {

    public static void main(String[] args) {
        int[] testArray = {-200,-150,-123,-100,-50,0,1,2,3,50,100};
        int testInt = 100;
        int searchResult = binarySearch(0,testArray.length,testArray,testInt);
        System.out.println("searchResult = " + searchResult);
    }
    private static int binarySearch(int leftPos, int rightPos,int[] testArray, int testInt){
        int midPos = (leftPos + rightPos) / 2;
        if (leftPos > rightPos) {
            return -1;
        }
        if (testInt == testArray[midPos]) {
            return midPos;
        } else if (testInt > testArray[midPos]) {
            leftPos = midPos + 1;
        } else {
            rightPos = midPos - 1;
        }
        return binarySearch(leftPos,rightPos,testArray,testInt);
    }
}
