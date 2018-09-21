import java.util.Scanner;
public class CelsiusToFahrenheit {

    private double celsiusToFahrenheit(double celsius) {
	return 9/5 * celsius + 32;
    }
    
    public static void main(String[] args) {
	CelsiusToFahrenheit ctf = new CelsiusToFahrenheit();
	Scanner sys = new Scanner(System.in);
	System.out.println("Enter Temperature in Celsius");
	double userInput = sys.nextDouble();
	double fahrenheit = ctf.celsiusToFahrenheit(userInput);
	System.out.println("Temp in Fahrenheit: " + fahrenheit);
    }
}
