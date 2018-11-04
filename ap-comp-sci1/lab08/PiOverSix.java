public class PiOverSix {
    
    private static double calc() {
        double val = 0.5;
        double tempval = val;
        double counter = 3;
        
        while(true) {
            tempval = val;
            val += multiplyConsecutive(counter) *
                Math.pow(0.5, counter) * 
                (1 / counter);
            counter += 2;
            System.out.println(Math.PI / 6);
            if(val == tempval) break;
        }
        return val;
    }
            
    private static double multiplyConsecutive(double counter) {
        double val = 1;
        for(double i = 1; i < counter; i += 2) {
            val *= i / (i + 1);
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(calc());
    }
}
