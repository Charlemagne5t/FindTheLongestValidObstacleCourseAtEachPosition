class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] lis = new int[n];
        
        int[] res = new int[n];
        res[0] = 1;
        lis[0] = obstacles[0];
        int j = 1;
        for(int i = 1; i < n; i++){
            int val = obstacles[i];
            if(val >= lis[j - 1]){
                lis[j] = val;
                j++;
                res[i] = j;
            }else{
                int l = 0;
                int r = j - 1;
                int mid = l + (r - l) / 2;
                int idx = -1;
                while(l <= r){
                    mid = l + (r - l) / 2;
                    if(lis[mid] > val){
                        idx = mid;
                        r = mid - 1;
                    }else {
                        l = mid + 1;
                    }
                }
                lis[idx] = val;
                res[i] = idx + 1;
            }
           
        } 
        
        return res;
    }
}
