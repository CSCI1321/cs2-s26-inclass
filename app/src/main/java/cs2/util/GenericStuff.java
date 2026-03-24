package cs2.util;

import java.util.ArrayList;

public class GenericStuff {
    
    public static ArrayList<Integer> arrayToArrayList(int[] arr) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i : arr) { al.add(i); }
        return al;
    }
    public static ArrayList<Double> arrayToArrayList(double[] arr) {
        ArrayList<Double> al = new ArrayList<>();
        for(double i : arr) { al.add(i); }
        return al;
    }
    public static <T> ArrayList<T> arrayToListGeneric(T[] arr) {
        ArrayList<T> al = new ArrayList<>();
        for(T item : arr) { al.add(item); }
        return al;
    }

    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,5};
        System.out.println(a);
        //System.out.println(arrayToArrayList(a));
        String[] s = {"Hello","there","you"};
        System.out.println(s);
        //System.out.println(arrayToArrayList(s));
        System.out.println(arrayToListGeneric(s));
        System.out.println(arrayToListGeneric(a));
    }

    public static void bubbleSort(int[] a) {
        for(int j=0; j<a.length; j++) {
            for(int i=0; i<a.length-1-j; i++) {
                if(a[i] > a[i+1]) {
                    int tmp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = tmp;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void bubbleSortGeneric(T[] a) {
        for(int j=0; j<a.length; j++) {
            for(int i=0; i<a.length-1-j; i++) {
                if(a[i].compareTo(a[i+1]) > 0) {
                    T tmp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = tmp;
                }
            }
        }
    }





}
