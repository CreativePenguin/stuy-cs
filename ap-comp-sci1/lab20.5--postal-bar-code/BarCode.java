public final class BarCode{

    // instance variables
    private final int CHECKDIGIT;  // a nonnegative digit
    private final String ZIP;      // a string of digits (excludes check digit)
    private final String BARCODE;  // a string of full and half bars

    // table for conversion : digit -> string
    final static String [] CODES = { "||:::", ":::||", "::|:|",
				     "::||:",":|::|",":|:|:",":||::",
				     "|:::|", "|::|:", "|:|::"};
    // constructors
    //precondtion: zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit               
    public BarCode(String zip) {
        if(zip.length() != 5) throw new RuntimeException("bad len");
        int checkDigit = 0;
        for(int i = 0; i < zip.length(); i++) {
            try {
                int val = Integer.parseInt(zip.substring(i, i + 1));
                checkDigit += val;
            } catch(NumberFormatException ex) {
                throw new RuntimeException("incompatible input");
            }
        }
        ZIP = zip + Integer.toString(checkDigit);
        CHECKDIGIT = checkDigit;
        BARCODE = toBarcode();
    }

    // postcondition: Creates a copy of a bar code.
    public BarCode(BarCode x){
        ZIP = x.getZip();
        CHECKDIGIT = x.getCHECKDIGIT();
        BARCODE = x.getBarcode();
    }

    //post: computes and returns the sum for ZIP
    private int zipSum() {
        return CHECKDIGIT * 2;
    }


     // post: returns a string representing a barcode
     // if ZIP = "08451" and CHECKDIGIT = 8" then
     // toBarCode() returns "|||:::|::|::|::|:|:|::::|||::|:|"      
    private String toBarcode(){
        String barcode = "";
        for(int i = 0; i < ZIP.length(); i++) {
            int index = Integer.parseInt(ZIP.substring(i, i + 1));
            barcode += CODES[index];
        }
        return barcode;
    }


     //postcondition: format zip + check digit + barcode 
     //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString() {
        return ZIP + "   " + BARCODE;
    }


     @Override
     // Two BarCodes are equivalent if they have the same ZIP.
    public boolean equals(Object other) {
        if(!(other instanceof BarCode)) return false;
        BarCode that = (BarCode) other;
        return that.getZip().equals(this.ZIP);
    }

    public String getZip() {
        return ZIP;
    }

    public String getBarcode() {
        return BARCODE;
    }

    public int getCHECKDIGIT() {
        return CHECKDIGIT;
    }

    @Override
    public int hashCode(){
        return Integer.parseInt(ZIP);
    }

}
