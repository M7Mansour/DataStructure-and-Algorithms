public class LateNess {
    public static void main(String[] args){
        int[][] arr = {{3,6},{2,8},{4,9},{1,9},{2,15},{3,14}};
        System.out.println(lateNess(arr));
        int x = 1;
        int u = x = x+1;
        System.out.println(u);
    }
    public static int lateNess(int[][] arr){
        arr = mergeSort2D(arr,0,arr.length-1);
        int currentTime = 0;
        int lateNess = 0;
        for(int i = 0 ; i < arr.length ; i++){
            currentTime += arr[i][0];
            if(currentTime - arr[i][1] > 0)
                lateNess += currentTime - arr[i][1];
        }
        return lateNess;
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
        while(i < left.length && j < right.length){
            if(left[i][1] == right[j][1])
                big[k++] = left[i][0] > right[j][0] ? right[j++] : left[i++];
            else big[k++] = left[i][1] > right[j][1] ? right[j++] : left[i++];
        }

        while(i < left.length)
            big[k++] = left[i++];
        while(j < right.length)
            big[k++] = right[j++];
        return big;
    }
}
