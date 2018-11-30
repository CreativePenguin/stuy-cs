public class FormatDemo{

    public static void main(String [] args){
	new FormatDemo().run();
    }

    public void run(){
	printEquation(5,3);
	printFactorial();
	printGraduateTable();
	System.out.printf("%nFoating-point format (%%f) : %n%n");
	showConstants("f");
	System.out.printf("%nExponential format (%%E) : %n%n");
	showConstants("E");
	System.out.printf("%nGeneral format (%%G) : %n%n");
	showConstants("G");
    }


    private void printEquation(int x, int y){
	System.out.printf("%d + %d = %d%n", x ,y, x + y);
    }

    private void printFactorial(){
	int fact = 1;
	for (int i = 0; i < 12; i++){
	    if (i > 1) fact *= i;
	    System.out.printf("%2d! = %,12d%n",i,fact);
	}
    }
    /*      Prints the following
     *      Alabama        189,259       31.5%
     *      Alaska          31,967       32.9%
     *      Arizona        283,867       33.0%
     *      Arkansas       105,468       28.6%
     *      California   1,999,766       37.9%
     */
    private void printGraduateTable(){
	System.out.printf("%-16s%,12d%7.1f%%%n","Alabama", 189259,31.5);
	System.out.printf("%-16s%,12d%7.1f%%%n","Alaska", 319679,32.9);
	System.out.printf("%-16s%,12d%7.1f%%%n","Arizona", 283867,33.0);
	System.out.printf("%-16s%,12d%7.1f%%%n","Arkansas", 105468,28.6);
	System.out.printf("%-16s%,12d%7.1f%%%n","California", 1999766,37.6);
    }

    private void showConstants(String format){
	System.out.println(" d |     pi     | speed of light | fine structure");
	System.out.println("---+------------+----------------+----------------");
	for (int d = 1; d <= 4; d++){
	    System.out.printf("%2d |", d);
	    System.out.printf("%11." +  d + format + " |", PI);
	    System.out.printf("%15." +  d + format + " |", SPEED_OF_LIGHT);
	    System.out.printf("%14." +  d + format + " |", FINE_STRUCTURE);
	    System.out.println();
	}
    }


    
    /* Constants */
    private static final double PI = 3.14159265358979323846;
    private static final double SPEED_OF_LIGHT = 2.99792458E+8;
    private static final double FINE_STRUCTURE = 7.2573525E-3;

    
}
