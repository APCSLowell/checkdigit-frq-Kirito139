public class CheckDigit {
    /** Returns the check digit for num, as described in part (a).
     *  Precondition: The number of digits in num is between one and
     *  six, inclusive.
     *          num >= 0
     */
    public static int getCheck(int num) {
        /* to be implemented in part (a) */
        int baz = num;
        int digits = ("" + num).length();
        int [] foo = new int[digits];

        for (int i = 0; i < digits; i++) {
            foo[i] = (baz % 10) * (8 + i - digits);
            baz /= 10;
        }

        int sum = 0;
        for (int n : foo) {
            sum += n;
        }
        return sum % 10;
    }

    /** Returns true if numWithCheckDigit is valid, or false
     *  otherwise, as described in part (b).
     *  Precondition: The number of digits in numWithCheckDigit
     *  is between two and seven, inclusive.
     *                numWithCheckDigit >= 0
     */
    public static boolean isValid(int numWithCheckDigit) {
        /* to be implemented in part (b) */
        return getCheck(numWithCheckDigit / 10) == numWithCheckDigit % 10;
    }

    /** Returns the number of digits in num. */
    public static int getNumberOfDigits(int num) {
        if (num < 10) return 1;
        else return 1 + getNumberOfDigits(num / 10);
    }

    /** Returns the nthdigit of num.
     *  Precondition: n >= 1 and n <= the number of digits in num
     */
    public static int getDigit(int num, int n) {
        int pos = getNumberOfDigits(num) - n + 1;
        while (pos > 1) {
            num /= 10;
            pos--;
        }
        return num % 10;
    }

}
