public class Rumors {

    private double rumorAlice(int numOfPpl, int trialNum, boolean getProbability) {
        boolean[] people = new boolean[numOfPpl];
        double aliceHearsRumor = 0;
        double peopleHeard = 0;
        for(int i : new int[trialNum]) {
            while(true) {
                if(people[0]) {
                    aliceHearsRumor++;
                    break;
                }
                int person = (int) (Math.random() * numOfPpl);
                if(people[person]) {
                    break;
                }
                people[person] = true;
                peopleHeard++;
            }
        }
        return (getProbability) ? aliceHearsRumor / trialNum : peopleHeard;
    }

}
