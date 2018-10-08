package org.stepic.java.core_algorithms;

import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {

    private byte [] byte_sequence;

    private AsciiCharSequence(byte [] byte_sequence){
        this.byte_sequence = byte_sequence.clone();
    }

    public static void main(String [] args){
        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer.toString());//Hello!
        System.out.println("Размер её - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello
        //проверка на нарушение инкапсуляции private поля
        System.out.println(answer.toString());//Hello!
        example[0] = 74;
        System.out.println(answer.toString());//Hello
    }

    @Override
    public int length() {
        return byte_sequence.length;
    }

    @Override
    public char charAt(int index) {
        return (char) byte_sequence[index];
    }

    @Override
    public String toString(){
        return new String(byte_sequence);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte [] new_sequence = Arrays.copyOfRange(byte_sequence, start, end);
        return new AsciiCharSequence(new_sequence);
    }
}
