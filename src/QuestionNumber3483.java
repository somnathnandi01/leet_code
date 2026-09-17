import java.util.HashSet;
import java.util.Set;

public class QuestionNumber3483 {
    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) {
                continue;
            }
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i == j || j == k || k == i) {
                        continue;
                    }
                    if (digits[k] % 2 == 0) {
                        int number = 100 * digits[i] + 10 * digits[j] + digits[k];
                        set.add(number);
                        System.out.printf("%d, ", number);
                    }
                   
                }
            }
        }
        

        return set.size();
    }

    public static void main(String[] args) {
        int[] digits = {1,2,3,4};
        new QuestionNumber3483().totalNumbers(digits);
    }

}


// conditions for solving
// 1. numbers can repeat if they have it in digits arr
// sol -> count store digits somewhere and pull one by one to form a number
// like stack
// 2. 0 cannot place in first position 
// sol -> number > 100 if not then first_digit is 0
// 3. a number cannot repeated
// check digits to confirm that
// 4. need to even 
// sol -> last digit of the number is divisable by 2 or number(or digit) % 2 == 0
