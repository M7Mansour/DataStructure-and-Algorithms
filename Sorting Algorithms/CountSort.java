public class CountSort {
    public static void main(String[] args){
        int[] arr = {9,8,7,6,5,20,4,9,4,3,2,7,8,5,4,3,1,3,2,1};
        int[] sortedArr = countSort(arr);
        for(int i = 0 ; i < sortedArr.length ; i++)
            System.out.print(sortedArr[i] + " ");
        System.out.println();
    }

    public static int[] countSort(int[] arr){
        int max = 0;
        for(int i = 0 ; i < arr.length ; i++)
            if(max < arr[i])
                max = arr[i];

        int[] count = new int[max + 1];
        int[] sortedArr = new int[arr.length];

        for(int i = 0 ; i < arr.length ; i++)
            count[arr[i]]++;

        for(int i = 1 ; i <= max ; i++)
            count[i] += count[i - 1];

        for(int i = arr.length - 1 ; i >= 0 ; i--)
            sortedArr[--count[arr[i]]] = arr[i];

        return sortedArr;
    }
}
