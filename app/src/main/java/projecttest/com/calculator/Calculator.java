package projecttest.com.calculator;

/**
 * Created by Cuong on 2/6/2018.
 */

public class Calculator {
        String mathExpression;
    public Calculator (String mathString) throws MathExpressionErrorException{
        mathExpression =mathString;
        if (!TypeChecker.kiemTraDauCan(mathString)){
            throw new MathExpressionErrorException("sqrt error");
        }
        if (!TypeChecker.kiemTraNgoacDon(mathString)){
            throw new MathExpressionErrorException("() error");
        }
        if (!TypeChecker.kiemTraDauMu(mathString)){
            throw new MathExpressionErrorException("^ error");
        }
        if (!TypeChecker.kiemTraPhepToanNhanChia(mathString, 'x')){
            throw new MathExpressionErrorException("x error");
        }
        if (!TypeChecker.kiemTraPhepCongTru(mathString, '+')){
            throw new MathExpressionErrorException("+ error");
        }
        if (!TypeChecker.kiemTraPhepCongTru(mathString, '-')){
            throw new MathExpressionErrorException("- error");
        }
        if (!TypeChecker.kiemTraPhepToanNhanChia(mathString, '÷')){
            throw new MathExpressionErrorException("÷ error");
        }if (!TypeChecker.kiemTraPi(mathString)){
            throw new MathExpressionErrorException("pi error");
        }if (!TypeChecker.kiemTraDauPhanTram(mathString)){
            throw new MathExpressionErrorException("% error");
        }
    }
    private void completeMathExpresion(){
        for (int i=0; i<mathExpression.length();i++){
            // add x between number,.,%,),pi and '('
            if (i>0&&mathExpression.charAt(i)=='('){
                if ((mathExpression.charAt(i-1)>='0'&&mathExpression.charAt(i-1)<='9')){
                    insertCharToString(i-1,'x');
                } else if (mathExpression.charAt(i - 1) == '%'){
                    insertCharToString(i-1,'x');
                } else if (mathExpression.charAt(i - 1) == 'π'){
                    insertCharToString(i-1,'x');
                }else if (mathExpression.charAt(i - 1) == '.'){
                    insertCharToString(i-1,'x');
                }
            }
            // add x between pi and pi
            if (i>0&&mathExpression.charAt(i)=='π'){
                if (mathExpression.charAt(i-1)=='π'){
                    insertCharToString(i-1,'x');
                }
            }

        }
        
        for (int i=0; i<mathExpression.length();i++){
        // add x between number,.,%,),pi and '('
        if (i>0&&mathExpression.charAt(i)=='('){
            if ((mathExpression.charAt(i-1)>='0'&&mathExpression.charAt(i-1)<='9')){
                insertCharToString(i-1,'x');
            } else if (mathExpression.charAt(i - 1) == '%'){
                insertCharToString(i-1,'x');
            } else if (mathExpression.charAt(i - 1) == 'π'){
                insertCharToString(i-1,'x');
            }else if (mathExpression.charAt(i - 1) == '.'){
                insertCharToString(i-1,'x');
            }
        }
        // add x between pi and pi
        if (i>0&&mathExpression.charAt(i)=='π'){
            if (mathExpression.charAt(i-1)=='π'){
                insertCharToString(i-1,'x');
            }
        }

    }
    }

    private void insertCharToString(int postion,char expression){

    }
    float calculate(String mathString){
        return 2;
    }
}
