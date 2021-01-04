public class FractionalKnapsack {
    public static void main(String[] args){
        int[][] arr = {{12,4},{10,6},{8,5},{11,7},{14,3},{7,1},{9,6}};
        System.out.println(fKnapsack(arr,18));
    }
    public static double fKnapsack(int[][] arr , int capacity){
        arr = mergeSort2D(arr,0,arr.length - 1);
        int currentCapacity = 0;
        double value = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i][1] + currentCapacity <= capacity){
                value += arr[i][0];
                currentCapacity += arr[i][1];
            }
            else{
                value += (double)(capacity - currentCapacity) / arr[i][1] * arr[i][0];
                currentCapacity += (capacity - currentCapacity);
                break;
            }
        }
        return value;
    }

    public static int[][] mergeSort2D(int[][] arr , int start , int end){
        if(arr.length == 0)
            return new int[][]{};
        if(start == end)
            return new int[][] {arr[start]};
        int mid = (end + start) / 2;
        int[][] left = mergeSort2D(arr,start,mid);
        int[][] right = mergeSort2D(arr,mid+1,end);
        int[][] big = new int[left.length + right.length][2];
        int i = 0 , j = 0 , k = 0;
        while(i < left.length && j < right.length)
            big[k++] = (double)left[i][0] / left[i][1] < (double)right[j][0] / right[j][1] ? right[j++] : left[i++];

        while(i < left.length)
            big[k++] = left[i++];
        while(j < right.length)
            big[k++] = right[j++];
        return big;
    }
}
