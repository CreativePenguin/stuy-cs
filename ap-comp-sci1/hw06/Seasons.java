public class Seasons {
    public static void main(String[] chicken) {
	switch(chicken[0]) {
	case "January": case "Febuary": case "December":
	    System.out.println("Winter");
	    break;
	case "March": case "April": case "May":
	    System.out.println("Spring");
	    break;
	case "June": case "July": case "August":
	    System.out.println("Summer");
	    break;
	case "September": case "October": case "November":
	    System.out.println("Autumn");
	}
    }
}
