/*
 * Li Qian Student --> Student ID: 2340667
 *
 * Ehsan KH. Motlagh --> student ID: 2340457
 *
 * */
public class Validator {

    public static void main(String[] args) {


        System.out.println("isAlphanum() test result");
        System.out.println(isAlphaNum('h'));
        System.out.println(isAlphaNum('D'));
        System.out.println(isAlphaNum('3'));
        System.out.println(isAlphaNum('!'));
        System.out.println(isAlphaNum('*'));
        System.out.println();

        System.out.println("isSpecieChar() test result");
        System.out.println(isSpecialChar('_', true));
        System.out.println(isSpecialChar('-', true));
        System.out.println(isSpecialChar('-', false));
        System.out.println(isSpecialChar('_', false));
        System.out.println(isSpecialChar('@', false));
        System.out.println(isSpecialChar('!', false));
        System.out.println();

        System.out.println("isPrefixChar() test result");
        System.out.println(isPrefixChar('-'));
        System.out.println(isPrefixChar('F'));
        System.out.println(isPrefixChar('8'));
        System.out.println(isPrefixChar('&'));
        System.out.println(isPrefixChar(' '));
        System.out.println();

        System.out.println("isDomainChar() test result");
        System.out.println(isDomainChar('-'));
        System.out.println(isDomainChar('s'));
        System.out.println(isDomainChar('9'));
        System.out.println(isDomainChar('_'));
        System.out.println();

        System.out.println("singleAtSign() test result");
        System.out.println(singleAtSign("username@domain.com"));
        System.out.println(singleAtSign("@gmail.com"));
        System.out.println(singleAtSign("A@b@c@d"));
        System.out.println();

        System.out.println("fetchbeforeAt() test result");
        System.out.println(fetchBeforeAt("username@domain.com"));
        System.out.println(fetchBeforeAt("you@regreat"));
        System.out.println(fetchBeforeAt("@gmail.com"));
        System.out.println();

        System.out.println("fetchAfterAt() test result");
        System.out.println(fetchAfterAt("username@domain.com"));
        System.out.println(fetchAfterAt("you@regreat"));
        System.out.println(fetchAfterAt("@gmail.com"));
        System.out.println();

        System.out.println("isPrefix() test result");
        String[] str = {"", "e_9999.9909009i", "7777777", "_lklkl",
                "e.motlag", "e.motla_g", "e.motlag_", "e.motla..g", "g21$_k", "you_me", "to.bcc", "and..so", "thebest!"};
        for (String s : str)
            System.out.println(isPrefix(s) + " " + s);
        System.out.println();

        System.out.println("isEmail() test result");
        String[] strEmail = {"user..name@fakemail.com", "user#name@fakemail.com", "user.name@fakemail", "user.name@fakemail..com",
                "user_n@fakemail.com", "user.nm@fakemail.com", "user@fakemail.com", "user.name@fake-mail.com", "user-name.yul@yaoo.com"};
        for (String t : strEmail)
            System.out.println(isEmail(t) + " " + t);
        System.out.println();

        System.out.println("isUsername() test result");
        String[] strUsername = {"-User2", ".cc123", "userName", "#sd99", "...9..", "-98!&j", "-WW@342", ".k-8-", "-K98-9-0"};
        for (String u : strUsername)
            System.out.println(isUsername(u) + "  test value -->  " + u);
        System.out.println();
        System.out.println("isDomain() test result");
        String[] strD = {"et_fdr.jhon", ".hsan.mot", "ee.t1", ".domain", "ehs.com", "ac-133.yul", "and..com"};
        for (String s : strD)
            System.out.println(s + " " + isDomain(s));

        System.out.println("safePassword() test result");
        String[] strS = {"W0w.Pr0ject", "ehsan_.mot", "H3ll0-WoRld", "W0w.Pr0ject", "A1.b2-", "D1nn3r-T1m3", "Pa55w0RDis0k", "__", "Eo", ".-.-.-.-"};
        for (String s : strS)
            System.out.println(s + " " + safePassword(s));
    }

    // true if char is alphanumeric(english letters and 0-9)
    public static boolean isAlphaNum(char c) {
        return isAlphabetic(c) || (c >= '0' && c <= '9');
    }

    /*
    return true if
     dash or period
    OR underscore is true
    */
    public static boolean isSpecialChar(char c, boolean underscore) {

        if (c != '.' && c != '-' && c != '_') return false;

        if (c == '-' || c == '.') return true;

        return underscore;
    }


    //true if char is alpha_num or underscore,dash,period
    public static boolean isPrefixChar(char c) {
        if (isAlphaNum(c)) {
            return true;
        }
        return isSpecialChar(c, true);
    }


    // true if char is alpha_num or dash,period
    public static boolean isDomainChar(char c) {
        if (isAlphaNum(c)) {
            return true;
        }
        return isSpecialChar(c, false);
    }

    //true if there is only one @ in the string
    public static boolean singleAtSign(String str) {
        return onlyOneChar('@', str);
    }

    //return string BEFORE @
    public static String fetchBeforeAt(String str) {
        return str.split("@")[0];
    }

    //return string AFTER @
    public static String fetchAfterAt(String str) {
        return str.split("@")[1];
    }

    /*
        true if
          * 1 char is in string Not empty
          * first char is alphanumeric
          * only alphanumeric and underscore,period,dash is allowed
          * underscore,period,dash must be followed by 1 alphanumeric char
     */
    public static boolean isPrefix(String str) {
        int i = 0;
        //return false if string is empty
        if (str.length() == 0)
            return false;
        //current character in string
        char ch = str.charAt(i);

        //false if first character is not alpha_num char
        if (!isAlphaNum(ch)) return false;

        i++; // move to next char since it's been validated
        while (i < str.length()) {

            ch = str.charAt(i);

            //false if underscore,period,dash is the last character
            if (isSpecialChar(ch, true) && (i + 1) == str.length()) return false;

            //false if underscore,period,dash is not followed by alpha_num
            if (isSpecialChar(ch, true) && !isAlphaNum(str.charAt(i + 1))) return false;

            //false if char is not special char(Including underscore) nor alpha_num
            if (!isPrefixChar(ch)) return false;

            i++;
        }
        //if the code reaches here
        //means all the conditions are met
        return true;
    }

    /*
        true if
          * there is only 1 period
          * Before Period
                ** contains at least 1 Char
                ** first char should be alpha_num
                ** only alpha_num and period and dash
                ** period and dash must be followed by alpha_num
          * After period
                ** contains at least two char
                ** contains only english alphabet
          *
     */

    public static boolean isDomain(String str) {
        int i = 0;
        char ch;
        char regex = '.';
        //false if no period found
        if ((splitByChar(regex, str)[0].equals(""))) return false;

        String firstPart = splitByChar(regex, str)[0];
        String secondPart = splitByChar(regex, str)[1];

        //false if first character is not alpha_num char
        if (!isAlphaNum(firstPart.charAt(0))) return false;

        //false if more than 1 period
        if (!onlyOneChar('.', str)) return false;

        // validation first portion

        // false if first portion is empty
        if (firstPart.length() == 0) return false;
        while (i < firstPart.length()) {

            ch = firstPart.charAt(i);

            //false if period,dash is the last character
            if (isSpecialChar(ch, false) && (i + 1) == str.length()) return false;

            //false if period,dash is not followed by alpha_num
            if (isSpecialChar(ch, false) && !isAlphaNum(str.charAt(i + 1))) return false;

            //false if char is not special char(Excluding underscore) nor alpha_num
            if (!isDomainChar(ch)) return false;

            i++;
        }

        //validation second portion

        //false if less than 3 length

        if (secondPart.length() < 3)
            return false;
        i = 0;
        ch = secondPart.charAt(i);
        while (i < secondPart.length()) {
            //false if contains non-alphabet
            if (!isAlphabetic(ch)) return false;
            i++;
        }
        return true;
    }

    /* A valid email address consists of a prefix, '@' symbol, and domain.
      Both the prefix and the domain must be written in acceptable formats.  */
    public static boolean isEmail(String str) {
        //check if email address is a valid email address. If not, return false
        if (!singleAtSign(str)) {
            return false;
        }
        // If email address is in acceptable formats, split it into 2 parts, prefix and suffix
        String prefix = fetchBeforeAt(str);
        String suffix = fetchAfterAt(str);
        // check if prefix and suffix is written in acceptable formats. If not, return false
        if (!isPrefix(prefix) || !isDomain(suffix)) {
            return false;
        }
        // if both prefix and suffix follow rules, return true
        return true;
    }


    /* check if a string is a valid username, return lowercase valid username if all conditions are met
       empty String "" otherwise          */
    public static String isUsername(String str) {
        // Contains seven or fewer characters, if more than 7, return ""
        if (str.length() > 7 || str.length() == 0) {
            return "";
        }

        //Must start with a period or dash, if not, return ""
        char[] c = str.toCharArray();
        if (!isSpecialChar(c[0], false)) {
            return "";
        }

    	/* Contains at least one alphanumeric character and
    	   Contains only alphanumeric characters, periods, dashes, or an exclamation point (!)     	 */
        int count = 0;
        int countAlphaNum = 0;
        for (int i = 0; i < str.length(); i++) {
            char d = str.charAt(i);
            if (isAlphaNum(d) || isSpecialChar((d), false) || d == '!') {
                count++;
            }
            if (isAlphaNum(d)) {
                countAlphaNum++;
            }
            //A period, or dash must always be followed by at least one alphanumeric characters, if not, return ""
            if ((isSpecialChar((str.charAt(str.length() - 1)), false)) ||
                    ((isSpecialChar((d), false) && !isAlphaNum(str.charAt(i + 1))))) {
                return "";
            }
        }
   		 /*if count number is as same as length of string, it means all chars are meet conditions.
    		  countAlphaNum >1 means the string contains at least 1 alphanumeric character    	 */
        if (count != str.length() || countAlphaNum < 1) {
            return "";
        }

        // return lowerCase string value
        return str.toLowerCase();
    }

    /*
     *    * Contains at least one alphanumeric characters.
     *    * Contains a minimum 7 characters and maximum 15 characters.
     *    * Contain at least one uppercase letter, one lowercase letter, one number, and one period, dash or underscore
     *    * The same character must never be repeated more than twice
     */
    public static boolean safePassword(String str) {
        int length = str.length();

        //return false if string is empty or the length is less than 7 and more than 15
        if (length < 7 || length > 15) return false;

        if (!isAlphaNum(str)) return false;

        if (!hasMinRequirements(str)) return false;

        if (hasConsecutiveLetters(str)) return false;

        return true;

    }

    //returns true if char is english alphabet
    private static boolean isAlphabetic(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    // searches string for the given character
    // true if the occurrence is only one
    private static boolean onlyOneChar(char ch, String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (count > 1) return false;
            if (str.charAt(i) == ch)
                count++;
        }
        return count == 1;
    }

    /*
     * ch: split by char for which str contains only one ch
     * str: to split
     */
    private static String[] splitByChar(char ch, String str) {
        String[] p = {""};
        if (!hasCharInString(ch, str)) return p;
        String reg = "\\".concat(Character.toString(ch));
        String[] portions = str.split(reg);
        return portions;
    }

    private static boolean hasCharInString(char ch, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) return true;
        }
        return false;
    }

    /*
          true if there is at least ONE
          * uppercase letter
          * lowercase letter
          * number
          * period, dash or underscore
     */
    private static boolean hasMinRequirements(String str) {

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasNum = false;
        boolean hasSpecial = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 65 && str.charAt(i) <= 90)
                hasUpper = true;
            if (str.charAt(i) >= 97 && str.charAt(i) <= 122)
                hasLower = true;
            if (str.charAt(i) >= 48 && str.charAt(i) <= 57)
                hasNum = true;
            if (isSpecialChar(str.charAt(i), true))
                hasSpecial = true;

            if (hasUpper && hasLower && hasNum && hasSpecial) return true;
        }
        return false;
    }

    //true if there is no repeating letters
    private static boolean hasConsecutiveLetters(String str) {
        char current;
        char next;
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 == str.length()) return false;
            current = str.charAt(i);
            next = str.charAt(i + 1);
            if (current == next) return true;
        }
        return false;
    }

    private static boolean isAlphaNum(String str) {

        for (int i = 0; i < str.length(); i++) {
            if (isAlphaNum(str.charAt(i))) return true;
        }
        return false;
    }

}
