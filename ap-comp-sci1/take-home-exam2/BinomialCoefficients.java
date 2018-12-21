//Made by Kevin Cai and Winston Peng
//To run: compile and run by typing java BinomialCoefficients <insert number of rows>
//output: returns a table to binomial coefficients
public class BinomialCoefficients{
    public static void main(String[] args){
	    double[][] m = new double[Integer.parseInt(args[0])][];
	    m[0] = new double[1];
	    m[0][0] = 1.0;
	    System.out.println("1");
	    for(int i = 1; i< m.length;i++){
	        m[i] = new double[i+1];
	        for(int j = 0;j < m[i].length;j++){
		        if(j == 0 || j == i){
		            m[i][j] = m[i-1][0]/2.0;
		            System.out.print(m[i][j]+ "\t");
		            continue;
		        }
		        m[i][j] = (m[i-1][j] + m[i-1][j-1]) / 2.0;
		        System.out.print(m[i][j]+ "\t");
	        }
	        System.out.println();
    	}
    }
}
