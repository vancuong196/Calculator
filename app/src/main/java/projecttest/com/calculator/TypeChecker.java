package projecttest.com.calculator;

/**
 * Created by Cuong on 2/6/2018.
 */

public class TypeChecker {
    static boolean kiemTraNgoacDon(String mathString) {
        int sum = 0;
        for (int i = 0; i < mathString.length(); i++) {
            if (sum < 0) {
                return false;
            }
            if (mathString.charAt(i) == ')') {
                sum -= 1;
            }
            if (mathString.charAt(i) == '(') {
                sum += 1;
            }
        }
        if (sum!=0) {
            return false;
        }
        if (mathString.length()==1) {
            if (mathString.charAt(0) == ')') {
                return false;
            }
            if (mathString.charAt(0) == '(') {
                return false;
            }
        }
        for (int i = 1; i < mathString.length(); i++) {

            if (mathString.charAt(i) == ')') {
                //pre check
                if (mathString.charAt(i-1) == '(') {
                    return false;
                }

            }
        }
        return true;
    }

    static boolean kiemTraPhepToanNhanChia(String mathString, char phepToan) {
        if (mathString==null) return true;
        for (int i = 1; i < mathString.length() - 1; i++) {

            if (mathString.charAt(i) == phepToan) {
                //pre
                if ((mathString.charAt(i - 1) < '0' || mathString.charAt(i - 1) > '9' )&& (mathString.charAt(i - 1) != ')'|| mathString.charAt(i - 1) != '%'|| mathString.charAt(i - 1) != '.')) {
                    return false;
                }
                //after
                if (mathString.charAt(i + 1) == 'x' || mathString.charAt(i + 1) == '÷' || mathString.charAt(i + 1) == '%' || mathString.charAt(i + 1) == '^') {
                    return false;
                }

            }


        }
        if (mathString.charAt(0) == phepToan) return false;
        if (mathString.charAt(mathString.length() - 1) == phepToan) {
            return false;
        }

        return true;
    }

    static boolean kiemTraPhepCongTru(String mathString, char phepToan) {

        for (int i = 1; i < mathString.length() - 1; i++) {

            if (mathString.charAt(i) == phepToan) {
                //pre
                if (mathString.charAt(i - 1) == '(') {
                    return false;
                }
                //after
                if (mathString.charAt(i + 1) == 'x' || mathString.charAt(i + 1) == '÷' || mathString.charAt(i + 1) == '%' || mathString.charAt(i + 1) == '^') {
                    return false;
                }

            }
        }
        if (mathString.charAt(mathString.length() - 1) == phepToan) {
            return false;
        }
        if (mathString.charAt(0) == phepToan) {
            if (mathString.charAt(1) == 'x' || mathString.charAt(1) == '÷' || mathString.charAt(1) == '%' || mathString.charAt(1) == '^') {
                return false;
            }
        }
        return true;
    }

    static boolean kiemTraDauCan(String mathString) {
        for (int i = 0; i < mathString.length() - 1; i++) {

            if (mathString.charAt(i) == '√') {
                //after
                if ((mathString.charAt(i+1) != '.' || mathString.charAt(i+1) != '(' || mathString.charAt(i+1) != '√' || mathString.charAt(i+1) != '+' || mathString.charAt(i+1) != '-')&& (mathString.charAt(i + 1) < '0' || mathString.charAt(i + 1) > '9')) {
                    return false;
                }

            }
        }

        if (mathString.charAt(mathString.length() - 1) == '√') {
            return false;
        }
        return true;

    }
    static boolean kiemTraDauMu(String mathString) {
        // first check
        if (mathString.charAt(0) == '^') {
            return false;
        }
        for (int i = 1; i < mathString.length() - 1; i++) {

            if (mathString.charAt(i) == '^') {
                //after check
                if (mathString.charAt(i+1) != '.' && mathString.charAt(i+1) != '(' && mathString.charAt(i+1) != '√' && mathString.charAt(i+1) != '+' &&mathString.charAt(i+1) != '-' && (mathString.charAt(i + 1) < '0' || mathString.charAt(i + 1) > '9')) {
                    return false;
                }
                //pre check
                if (mathString.charAt(i-1) != '.' && mathString.charAt(i-1) != ')'&&(mathString.charAt(i - 1) < '0' || mathString.charAt(i - 1) > '9')) {
                    return false;
                }

            }
        }
        // last check
        if (mathString.charAt(mathString.length() - 1) == '√') {
            return false;
        }
        return true;

    }
    static boolean kiemTraDauPhanTram(String mathString){
        if (mathString.charAt(0) == '%') {
            return false;
        }
        for (int i = 1; i < mathString.length(); i++) {

            if (mathString.charAt(i) == '%') {
                //pre check
                if (mathString.charAt(i-1) != '%' && mathString.charAt(i-1) != ')'&&(mathString.charAt(i - 1) < '0' || mathString.charAt(i - 1) > '9')) {
                    return false;
                }

                }
            }
        return true;
    }
    static boolean kiemTraPi(String mathString){
        for (int i = 1; i < mathString.length()-1; i++) {

            if (mathString.charAt(i) == 'π') {
                //pre check
                if (((mathString.charAt(i + 1) >= '0' && mathString.charAt(i + 1) <= '9'))||mathString.charAt(i+1)=='.') {
                    return false;
                }

            }
        }
        return true;
    }
}
