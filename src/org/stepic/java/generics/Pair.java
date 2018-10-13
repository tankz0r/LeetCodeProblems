package org.stepic.java.generics;

import java.util.Objects;

public class Pair<T1,T2> {
    private T1 pair1;
    private T2 pair2;

    private Pair(T1 pair1, T2 pair2){
        this.pair1 = pair1;
        this.pair2 = pair2;
    }

    public T1 getFirst() {
        return pair1;
    }

    public T2 getSecond() {
        return pair2;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Pair))
            return false;
        Pair<?,?> other = (Pair<?,?>) obj;
        if (this.getFirst() != null? !(this.getFirst().equals(other.getFirst())): (other.getFirst() !=null))
            return false;
        return (this.getSecond() !=null? (this.getSecond().equals(other.getSecond())): (other.getSecond() ==null));
        }

    @Override
    public int hashCode() {
        int prost = 17;
        int result = 1;
        result = prost*result + Objects.hash(this.getFirst());
        result = prost*result + Objects.hash(this.getSecond());
        return result;
    }

    public static <T1, T2> Pair<T1, T2>  of(T1 pair1, T2 pair2){
        return new Pair<>(pair1, pair2);
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        System.out.println(s);

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);

        Pair<Integer, String> pair3 = Pair.of(null, "sd");
        Pair<Integer, String> pair4 = Pair.of(1, null);
        boolean mustBeTrue2 = pair3.equals(pair4); // false!
        boolean mustAlsoBeTrue2 = pair3.hashCode() == pair4.hashCode(); // false!
        System.out.println(mustBeTrue2);
        System.out.println(mustAlsoBeTrue2);
    }
}
