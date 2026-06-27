class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> window = new ArrayList<>();
        int l = 0, r = 0;

        while(r < arr.length){
            window.add(arr[r]);

            if(r - l + 1 > k){
                int a = Math.abs(x - arr[l]);
                int b = Math.abs(x - arr[r]);
                int n = (a <= b) ? arr[r] : arr[l];
                window.remove(Integer.valueOf(n));
                l++;
            }

            r++;
        } 

        return window;
    }
}