class Solution {
    class Pair{
        int pos;
        double time;

        Pair(int pos, double time){
            this.pos = pos;
            this.time = time;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if(n== 0) return 0;
        
        ArrayList<Pair> pp = new ArrayList<Pair>();
        
        for(int i = 0; i< position.length; i++){
            double timeTaken = (double)(target - position[i]) / speed[i];
            pp.add(new Pair(position[i], timeTaken));
        }

        pp.sort((a,b) -> Integer.compare(a.pos, b.pos));

        int fleets = 0;
        double maxTime = 0.0;

        // FIXED: Loop backward from the car closest to the target to the furthest back
        for (int i = n - 1; i >= 0; i--) {
            Pair cur = pp.get(i);

            // If the current car takes MORE time than the fleet ahead, 
            // it can never catch up. It forms a brand new independent fleet.
            if (cur.time > maxTime) {
                fleets++;
                maxTime = cur.time; // This car becomes the slow leader of the new fleet
            }
        }

        return fleets;
    }
}
