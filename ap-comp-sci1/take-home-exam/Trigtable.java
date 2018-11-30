public class Trigtable{

    /**
       @author Jarair Tahsin
    */
    
 public static void main(String[]args){
    System.out.println("theta   | sin(theta) | cos(theta) |");
    System.out.println("--------+------------+------------+");
    System.out.printf("   %d  | %.7f | %.7f  |",-90,Math.sin(Math.toRadians(-90)), Math.cos(Math.toRadians(-90)));
    for (int i = -75; i<=90; i+=15){
     if (i<=-15){
     System.out.printf("\n" + "   %d  | %.7f | %.7f  |",i,Math.sin(Math.toRadians(i)), Math.cos(Math.toRadians(i)));
     }
     if (i==0){
     System.out.printf("\n" + "     %d  |  %.7f | %.7f  |",i,Math.sin(Math.toRadians(i)), Math.cos(Math.toRadians(i)));
     }
     if (i>0 && i<=90){
      System.out.printf("\n" + "    %d  |  %.7f | %.7f  |",i,Math.sin(Math.toRadians(i)), Math.cos(Math.toRadians(i)));
     }
    }
 }
}

