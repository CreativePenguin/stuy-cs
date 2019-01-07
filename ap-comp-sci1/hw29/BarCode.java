/*Create an immutable data type to represent Postal Bar Codes.

A bar code is generated from a 5 digit zip code by representing each digit with
a combination of 3 half bars and 2 full bars. Note that leading 0's are allowed
for zip codes. 

Represent a full bar with "|" and a half bar with ":".

To represent each of the 10 digits uniquely, the codes use a 7-4-2-1-0 
positional placement scheme. A full bar turns on the value associated with
the position. 

1  :::||   
2  ::|:|
3  ::||:
4  :|::|
5  :|:|:
6  :||::
7  |:::|
8  |::|:
9  |:|::
0  ||:::   (special case)

A check digit is added to the right of a zip code. The check digit is equal
to the sum of the digits of the zip code modulo 10.

For example,
   if the zip code is : 08451
   then the check digit is : 8
   thus the zip + check digit is : 084518

A bar code has a 2 guard rails (full bars) that lead and end the code.

So the bar code of 084518 is:

 |||:::|::|::|::|:|:|::::|||::|:|      



Implement the following constructors and methods.
*/

public final class BarCode{

    // instance variables
    private final int CHECKDIGIT;  // a nonnegative digit
    private final String ZIP;      // a string of digits
    private final String BARCODE;  // a string of full and half bars

    // table for conversion : digit -> string
    final static String [] CODES = { "||:::", ":::||", "::|:|",
				     "::||:",":|::|",":|:|:",":||::",
				     "|:::|", "|::|:", "|:|::"};

    // constructors
    //precondtion: zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               
    public BarCode(String zip) {
	if (zip.length() != 5) throw new RuntimeException();
        CHECKDIGIT = zipSum(zip) % 10;
	ZIP = zip;
	BARCODE = toBarcode();
    }

    // postcondition: Creates a copy of a bar code.
    public BarCode(BarCode x){
	this(x.ZIP);
    }


    //post: computes and returns the sum of the  ZIP
    private int zipSum(String zip){
	int ans = 0;
	for (int i = 0; i < zip.length(); i++)
	    ans += Integer.parseInt(zip.substring(i,i+1));
	return ans;
    }

    // post: returns a string representing a barcode
    // if ZIP = "08451" and CHECKDIGIT = 8" then
    // toBarCode() returns "|||:::|::|::|::|:|:|::::|||::|:|"      
    private String toBarcode(){
	String ans = "";
	for (int i = 0; i < ZIP.length(); i++){
	    int digit = (Integer.parseInt(ZIP.substring(i,i+1)));
	    ans += CODES[digit];
	}
	ans += CODES[CHECKDIGIT];
	ans = "|" + ans + "|";
	return ans;
    }


    //postcondition: format zip + check digit + barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	return ZIP +  CHECKDIGIT + "  " + BARCODE;
    }


    @Override
    public boolean equals(Object other){
	if (!(other instanceof BarCode)) return false;
	BarCode b = (BarCode) other;
	return ZIP.equals(b.ZIP);
    }


    @Override
    public int hashCode(){
	return ZIP.hashCode();
    }

}
