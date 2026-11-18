class Pair{
    int start;
    int speed;
    Pair(int start, int speed){
        this.start = start;
        this.speed = speed;
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Stack<Double> st = new Stack<>();
        int fleet = 0;

        Pair[] cars = new Pair[n];
        for(int i=0; i<n; i++){
            cars[i] = new Pair(position[i], speed[i]);
        }

        Arrays.sort(cars, (a,b) -> b.start - a.start);

        for(int i=0; i<n; i++){
            double currTime = (double)(target - cars[i].start)/ cars[i].speed;
            if(st.isEmpty() || currTime > st.peek()){
                st.push(currTime);
                fleet++;
            }
        }
        return fleet;
    }
}