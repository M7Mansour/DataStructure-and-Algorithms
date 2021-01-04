public class PlayStation {
    public static void main(String[] args){
        int[][] arr = {{0,6},{1,4},{3,5},{3,8},{4,7},{5,9},{6,10},{8,11}};
        int[][] print = playStation(arr);
        for(int i = 0 ; i < print.length ; i++){
            for(int j = 0 ; j < print[i].length ; j++)
                System.out.print(print[i][j] + " ");
            System.out.println();
        }
    }
    public static int[][] playStation(int[][] arr){
        if(arr.length == 0)
            return new int[][] {};
        arr = mergeSort2D(arr,0,arr.length - 1);
        int[][] optimal = new int[arr.length][arr[0].length];
        int count = 1;
        int[] current = arr[0];
        optimal[0] = current;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i][0] >= current[1]){
                optimal[count++] = arr[i];
                current = arr[i];
            }
        }
        int[][] lastOptimal = new int[count][optimal[0].length];
        for(int i = 0 ; i < count ; i++)
            lastOptimal[i] = optimal[i];
        return lastOptimal;
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
            big[k++] = left[i][1] > right[j][1] ? right[j++] : left[i++];

        while(i < left.length)
            big[k++] = left[i++];
        while(j < right.length)
            big[k++] = right[j++];
        return big;
    }
}
