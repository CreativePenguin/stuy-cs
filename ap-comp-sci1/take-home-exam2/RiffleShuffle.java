//By Kevin Cai and Winston Peng
//How to run: just compile and run this program.
//What it does: Prints out shuffled deck after each shuffle, done 7 times.
public class RiffleShuffle{
	static int[] Pile = new int[52];
	public static void main(String[] args){
        	for(int i=0; i< Pile.length; i++) Pile[i] = i;
        	for(int i = 0;i< 7;i++){
            	shuffle(Pile);
            	for(int j: Pile)System.out.print(j+ ",");
            	System.out.println();
        	}
       	 
    
	}
	public static void shuffle(int[] deck){
            	int[] res = new int[deck.length];
            	final int s = deck.length;
            	int R = 0;
            	for(int i = 0; i < deck.length;i++) R+= (Math.random()* 2);
            	int L = s - R;
            	System.out.println(L+":"+R);
            	for(int i = 0; L+R != 0 ;i++){
                	int k = ((Math.random() < (L / (double) (L + R)))? -1 + L-- :s - R--);
                	res[i] = deck[k];
            	}
            	for(int i=0; i< res.length; i++) deck[i] = res[i];

    
	}
}