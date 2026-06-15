class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int boat = 0;

        while(i <= j){
            int w = people[i] + people[j];

            if(w <= limit){
                i++; 
                j--;
            } else{
                
                j--;
            }
            boat++;
        }

        return boat;
    }
}