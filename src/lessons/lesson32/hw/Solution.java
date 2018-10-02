package lessons.lesson32.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public void readNumbers() throws IOException {
        int errors = 3;
        int sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++){

            String inputData = br.readLine();

            if(!checkInput(inputData)){
                errors--;
                if(errors == 0){
                    System.out.println("Your numbers are wrong. Number of attempts exceeded");
                    System.exit(0);
                }
                System.out.println("Your numbers are wrong. You have " + errors + " attempts to try again");
                continue;
            }
        }
        System.out.println(sum);
        br.close();

    }

    private boolean checkInput (String data){
        try{
            int numb = Integer.parseInt(data);
            if(numb > 100){
                return false;
            }
        }catch (NumberFormatException numberFormatEx){
            return false;
        }
        return true;
    }
}
