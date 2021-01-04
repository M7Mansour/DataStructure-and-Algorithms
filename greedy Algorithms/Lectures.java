public class Lectures {
    public static void main(String[] args){
        int[][] arr = {{7,9},{6,8},{5,6},{4,9},{3,7},{2,5},{1,4},{1,3},{1,2}};
        System.out.println(lectures(arr));
        arr = mergeSort2D(arr,0,arr.length-1);

    }
    public static int lectures(int[][] arr){
        arr = mergeSort2D(arr,0,arr.length - 1);
        int lCount = 0;
        boolean found = false;
        int[] rooms = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            found = false;
            for(int j = 0 ; j <= lCount ; j++){
                if(arr[i][0] >= rooms[j]){
                    rooms[j] = arr[i][1];
                    found = true;
                    break;
                }
            }
            if(!found)
                rooms[++lCount] = arr[i][1];
        }
        return lCount + 1;
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
            if(left[i][0] == right[j][0])
                big[k++] = left[i][1] > right[j][1] ? right[j++] : left[i++];
            else big[k++] = left[i][0] > right[j][0] ? right[j++] : left[i++];
        }

        while(i < left.length)
            big[k++] = left[i++];
        while(j < right.length)
            big[k++] = right[j++];
        return big;
    }
}
