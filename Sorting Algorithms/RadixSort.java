public class RadixSort {
    public static void main(String[] args){
        int[] arr = {935345,84564,734,6567,5686,4662,446,9489,55674,323,2645,7345,355678,355,4345,3646,1767,3878,5672,16856};
        arr = radixSort(arr);
        for(int i = 0 ; i < arr.length ; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static int[] radixSort(int[] arr){
        long max = 0;
        // search for the max number in the array
        for(int i = 0 ; i < arr.length ; i++)
            if(max < arr[i])
                max = arr[i];
        int indexCount = 0;
        while(max > 0){
            max /= 10;
            indexCount++;
        }
        // loop to sort the array according to the specific index
        // for example if we have the number 6354 we will sort according to 4 then 5 then 3 then 6
        for(int i = 0 ; i < indexCount ; i++)
            arr = countSort(arr,i);
        return arr;
    }

    public static int[] countSort(int[]arr , int index){
        // initialize the count array and its length is 10 cus we just sort according to a specific index in the number which
        // won't be less than 0 or larger than 9
        int[] count = new int[10];
        int[] sortedArr = new int[arr.length];
        // store the number of counts to count array
        for(int i = 0 ; i < arr.length ; i++)
            count[(arr[i] / (int)(Math.pow(10,index))) % 10]++;
        // sum every array element to the next element
        for(int i = 1 ; i < 10 ; i++)
            count[i] += count[i - 1];
        // start from the end of the array and store every element in its proper position
        for(int i = arr.length - 1 ; i >= 0 ; i--)
            sortedArr[--count[arr[i] / (int)(Math.pow(10,index)) % 10]] = arr[i];
        return sortedArr;
    }
}
