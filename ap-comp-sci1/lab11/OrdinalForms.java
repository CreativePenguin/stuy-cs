public class OrdinalForms {
    private String createOrdinalForm(int input) {
        if(input == 1) return input + "st";
        if(input == 2) return input + "nd";
        if(input == 3) return input + "rd";
        else return input + "th";
    }
}
