public class MeterConversion {
    private double meterToInch(double meter) {
	return meter * (1 / 0.0254);
    }
    
    private double inchToFeet(double inch) {
	return inch * (1.0 / 12);
    }

    public static void main(String[] args) {
	double val = Double.parseDouble(args[0]);
	double inches = new MeterConversion().meterToInch(val);
	double feet = new MeterConversion().inchToFeet(inches);
	System.out.println(inches);
	System.out.println(feet);
    }
}
