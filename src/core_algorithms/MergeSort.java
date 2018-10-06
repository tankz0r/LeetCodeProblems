package core_algorithms; /**
        * Merges two given sorted arrays into one
        *
        * @param a1 first sorted array
        * @param a2 second sorted array
        * @return new array containing all elements from a1 and a2, sorted
        */
import java.util.Arrays;

public class MergeSort {
    public static int [] insert_binary_search(int [] arr1, int [] arr2) {
        for(int i:arr2){
            int pos = binary_search(arr1, i, 0, arr1.length-1);
            arr1 = Arrays.copyOf(arr1, arr1.length + 1);
            if (pos != arr1.length)
                System.arraycopy(arr1, pos, arr1, pos+1, (arr1.length-pos-1));
            arr1[pos] = i;
        }
        return arr1;
    }

    public static int binary_search(int [] arr, int element, int begin, int end){
        int middle = (begin + end)/2;
        if (begin == end) {
            if (arr[begin] > element)
                return middle;
            else
                return middle+1;
        }
        if (element < arr[middle])
            return binary_search(arr, element, begin, middle-1);
        else if (element > arr[middle])
            return binary_search(arr, element, middle+1, end);
        else return middle;
    }

    public static int [] alternative_solution(int [] arr1, int [] arr2){
        int i=0, j=0, n=arr1.length+arr2.length;
        int [] result = new int[n];
        for (int k=0; k < n; k++){
            if (i == arr1.length) {
                System.arraycopy(arr2, j, result, k, n-k);
                break;
            }

            if (j == arr2.length) {
                System.arraycopy(arr1, i, result, k, n-k);
                break;
            }

            if (arr1[i] <= arr2[j]){
                result[k] = arr1[i];
                i++;
                continue;
            }

            if (arr1[i] > arr2[j]){
                result[k] = arr2[j];
                j++;
                continue;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr1 = {0, 2, 2, 10,10,20};
        int [] arr2 = {1, 3, 5, 7, 8,10,10};

        long startTime = System.currentTimeMillis();
        int [] myList = insert_binary_search(arr1, arr2);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Elapsed Time:" + elapsedTime);

        System.out.println("Final result:");
        for (int element: myList) {
            System.out.print(element);
            System.out.print(" ");
        }
        System.out.println(" ");
        startTime = System.currentTimeMillis();
        int [] myList_2 = alternative_solution(arr1, arr2);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        System.out.println("Elapsed Time:" + elapsedTime);

        System.out.println("Alternative result:");
        for (int element: myList_2) {
            System.out.print(element);
            System.out.print(" ");
        }
    }
}