package hw.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JumpingLeprechauns{
    public static void main(String[]args){
        System.out.println("How many leprechauns would you like to use?");
        Scanner sys = new Scanner(System.in);
        int n = sys.nextInt();
        System.out.println("How many simulations (iterations) do you want?");
        int numOfSimulations = sys.nextInt();
        Map <Integer, Integer> goldMap = new HashMap <Integer, Integer>();
        Map <Integer, Float> distanceMap = new HashMap <Integer, Float>();
        for(int i = 1; i<=n; ++i){ //Each leprechaun starts with 1000000 gold
            goldMap.put(i,1000000);
        }
        for (int j = 1; j<=n; ++j){  //Each leprechaun starts from the origin (0)
            distanceMap.put(j,(float)0);
        }
        for (int k = 0; k<numOfSimulations; ++k) /*Every simulation run*/{
            for (int l = 1; l<=n; ++l)/*Adjusts every leprechaun*/{
                float r = (float) (-1 + Math.random() * 2);     //Creates random float r, from -1 to 1
                float newDistance = distanceMap.get(l) + (r * goldMap.get(l));  //x_i + rg_i = x_i
                distanceMap.put(l, newDistance);  //Adjusts new distance
                float minimumDistance = newDistance;
                for(int m = 1; m<=n; ++m) /*Find the minimum possible distance between leprechaun l and the other leprechauns*/{
                    if (m==l){   //To avoid a leprechaun from comparing its distance from itself
                        if (m==n) break;
                        else ++m;
                    }
                    float distanceBetweenLeprechauns = Math.abs(distanceMap.get(l)-distanceMap.get(m));
                    if (distanceBetweenLeprechauns<=minimumDistance) minimumDistance = distanceBetweenLeprechauns;
                }
                ArrayList<Integer> closestLeprechauns = new ArrayList<Integer>(); //create list of closest leprechauns
                for(int o = 1; o<=n; ++o){
                    if (Math.abs(distanceMap.get(l) - distanceMap.get(o))==minimumDistance) closestLeprechauns.add(o);
                }
                for(int p = 0; p<closestLeprechauns.size(); ++p) /*Gold stealing*/{
                    int closestLeprechaunNum = closestLeprechauns.get(p);
                    int currentGoldOfLeprechaunL = goldMap.get(l);
                    int currentGoldOfCloseLeprechaun = goldMap.get(closestLeprechaunNum);
                    int newGold = currentGoldOfCloseLeprechaun / 2;
                    goldMap.put(l, currentGoldOfLeprechaunL + newGold);
                    goldMap.put(closestLeprechaunNum, newGold);
                }
            }
        }
        System.out.println("Would you like to see the results of your simulation? Type either Yes or No");
        Scanner src = new Scanner(System.in);
        String response = src.nextLine();
        if (response.equals("Yes")){
            for(int q = 1; q<=n; ++q){
                System.out.println("Leprechaun Number:  " + q);
                System.out.println("Distance:   " + distanceMap.get(q));
                System.out.println("Gold:       " + goldMap.get(q));
                System.out.println();
            }
        }
    }
}
