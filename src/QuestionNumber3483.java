
import java.util.HashSet;
import java.util.Set;

public class QuestionNumber3483 {
    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0, k = 0;
        int num;

        while (i < digits.length) {
            if (digits[i] == 0) {i++;continue;}
            if (i == j) {j++;continue;}
            if (j == k) {k++; continue;}
            if (k == i) {k++; continue;}

            if (k >= digits.length) {k = 0;j++;continue;}
            if (j >= digits.length) {j = 0;i++;continue;}
            if (digits[k] != 0 && digits[k] % 2 != 0) {k++;continue;}
            if (i >= digits.length) {break;}

            if (i+1 < digits.length) {
                if (digits[i] == digits[i+1]) {
                    i++;j=0;k=0;
                    continue;
                }
            }
            num = 100 * digits[i] + 10 * digits[j] + digits[k];
            set.add(num);
            k++;
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] digits = { 8,1,8 };
        int res = new QuestionNumber3483().totalNumbers(digits);
        System.out.println(res);
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
// sol -> last digit of the number is divisable by 2 or number(or digit) % 2 ==
// 0
