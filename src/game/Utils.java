package game;
import java.util.Random;

public class Utils {
    public static boolean probReturn(double odds){
        Random rand = new Random();
        return rand.nextDouble() < odds;

    }

    public static void main(String[] args) {
//        testy
//        int trues = 0;
//        int falses = 0;
//        for(int i =0; i < 1000; i++){
//            if(probReturn(0.1)){
//                trues++;
//            }
//            else{
//                falses++;
//            }
//        }
//        System.out.println(trues);
//        System.out.println(falses);
    }
}
