public class FunctionEval{

    private String output = "";

    // Side effect: concatenates "A" to the end of output
    private int f1(){
	    output += "A";
	    return 1;
    }
    // Side effect: concatenates "B" to the end of output
    private int f2(){
	    output += "B";
	    return 2;
    }

   // Side effect: concatenates "C" to the end of output
    private int f3(){
	    output += "C";
	    return 3;
    }

   // Side effect: concatenates "D" to the end of output
    private int f4(){
	    output += "D";
	    return 4;
    }

   // Side effect: concatenates "E" to the end of output
    private int f5(int x){
	    output += "E";
	    return 2 * x;
    }
    


    public void run(){
	    System.out.println("output before : " + output);
	    int n = f1() + f2() * f5(f3() + f4());
	    System.out.println("returned value: " + n);
	    System.out.println("output after : " + output);
    }




    public static void main(String [] args){
    	new FunctionEval().run();
    }
    

}

/* PART III:
 * output after run(): ABCDE
 * n after run(): 49
 * f1() + f2() * f5(f3() + f4())
   1 + 2 * 2(3 + 4)
   1 + 2 * 14
   1 + 28
   29
 * f5(f3() + f4()) * f2() + f1()
 */
