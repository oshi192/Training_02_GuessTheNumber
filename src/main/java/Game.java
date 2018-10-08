import util.ConsoleColors;
import util.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game implements ConsoleColors {
    private final static int RAND_MAX = 100;
    private final static int LENGTH_MAX = 80;
    private final static String INVALID = "-";
    private final static String ERROR = "X";
    private final static String BIGGER = "^";
    private final static String LOWER = "v";
    private static Random random = new Random();

    private static int askNumer;
    private int min;
    private int max;
    private  int range;
    List<String> inputs = new ArrayList();

    Game(){
        min = 0;
        max = 100;
        range =max - min;
    }
    public int rand(int min, int max) {
        int answer = 0;
        if (max >= min) {
            answer = random.nextInt(max - min) + min;
        } else {
            answer = random.nextInt(min - max) + max;
        }
        return answer;
    }

    public int rand() {
        return random.nextInt(RAND_MAX);
    }

    public void start() {

        askNumer = rand(min, max);
        System.out.println("I think a number? will you try to guess?");
        System.out.println("The number before " + min + " and " + max);
        System.out.println("you enter the number and I response: my number it smaller or bigger than yours");
        int answer = 0;
        if (answer == askNumer) {
            answer++;
        }
        while (answer != askNumer) {
            printStatusBar();
            answer = getNumber("input number : ",min, max);
            if (answer > askNumer) {
                System.out.println(" -- smaller -- ");
                max = answer;
                inputs.add(Integer.toString(answer)+LOWER);
            } else if (answer < askNumer) {
                System.out.println(" -- bigger --- ");
                min = answer;
                inputs.add(Integer.toString(answer)+BIGGER);
            }else{
                inputs.add(Integer.toString(answer));
            }
        }
        System.out.println(" Right! it is my number! Congratulations!!");
        printStatistics();
    }

    private  void printStatistics(){
        System.out.println("Your statistics: ");
        for(String s:inputs){
            if(s.charAt(0)!=INVALID.charAt(0)){
                System.out.println(GREEN+s);
            }else{
                System.out.println(RED+"\t"+s);
            }
            System.out.println(RESET);
        }
    }

    private void printStatusBar(){
        for(int i =0;i< min*LENGTH_MAX/range;i++){
            System.out.print(" ");
        }
        System.out.print("V");
        for(int i= min*LENGTH_MAX/range+1;i < max*LENGTH_MAX/range;i++){
            System.out.print(" ");
        }
        System.out.println("V");
        for(int i = 0;i<=LENGTH_MAX;i++){
           if(i<=min*LENGTH_MAX/range | i>=max*LENGTH_MAX/range) {
               System.out.print(GREEN + "#");
           }else{
               System.out.print(RED+"#");
           }
        }
        System.out.println(RESET);
    }

    public int getNumber(String s, int min, int max) {
        String input;
        System.out.print(s);
        while (true) {
            input = Reader.getString();
            if (input.matches("\\d+")) {
                if (Integer.parseInt(input) >= min && Integer.parseInt(input) <= max) {
                    return Integer.parseInt(input);
                }
            }
            inputs.add(INVALID+input+ERROR);
            System.out.println("invalid input , try again. Only numbers: " + min + "-" + max);
        }
    }
}
