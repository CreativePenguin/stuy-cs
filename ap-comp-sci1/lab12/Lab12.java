public class Lab12 {
    
    public String trim(String str) {
        while(str.startsWith(" ")) str = str.substring(1); 
        while(str.endsWith(" ")) str = str.substring(0, str.length() - 2);
        return str;
    }

    public String capitalize(String str) {
        return str.substring(0,1).toUpperCase() + 
            str.substring(1).toLowerCase();
    }

    public int scrabble(String str) {
        int val = 0;
        String[] strArray = str.split("(?!^)");
        for(String i : strArray) {
            val += calcPoint(i);
        }
        return val;
    }

    public int calcPoint(String input) {
        for(String onePoint : "AEILNORSTU".split("(?!^")) 
            if(input == onePoint) return 1;
	    for(String twoPoint : "DG".split("(?!^)"))
            if(input == twoPoint) return 2;
        for(String threePoint : "BCMP".split("(?!^)"))
            if(input == threePoint) return 3;
        for(String fourPoint : "FHVWY".split("(?!^)"))
            if(input == fourPoint) return 4;
        for(String fivePoint : "K".split("(?!^)"))
            if(input == fivePoint) return 5;
        for(String eightPoint : "JX".split("(?!^)"))
            if(input == eightPoint) return 8;
        for(String tenPoint : "QZ".split("(?!^)"))
            if(input == tenPoint) return 10;
        return 0;
    }

    public int count(String input, String sub) {
        int val = 0;
        while(input.contains(sub)) {
            input.substring(0, input.lastIndexOf(sub));
            val++;
        }
        return val;
    }

    public String acronym(String input) {
        String noDashesInput = input.replace("-", " ");
        String[] inputArray = new String[count(input, " ")];
        String val = "";

        for(String i : inputArray) val += i.substring(0,1);
        return val;
    }

    public static void main(String[] args) {
        Lab12 lab = new Lab12();
        
        System.out.print(lab.trim("  test"));
        System.out.print(lab.trim("test      "));
        System.out.println(lab.trim("     test      "));

        System.out.println();
                            
        System.out.println(lab.capitalize("lactose"));
        System.out.println(lab.capitalize("LACTOSE"));
        System.out.println(lab.capitalize("DeStRuCtIoN"));

        System.out.println();

        System.out.println(lab.acronym("Attention Deficit Disorder"));
        System.out.println(lab.acronym("Acquired Immune Deficiency Syndrome"));
        System.out.println(lab.acronym("Attention Deficit Disorder"));
    }
}
