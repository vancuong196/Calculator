package projecttest.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static double memory;
    static double answer;
    private boolean isMemOn = false;
    private double tmpNumber1;
    private double tmpNumber2;
    private char currentExpression;
    private String inputNumber;
    private String mathExpression;
    private TextView tvResult;
    private TextView tvMathExpressionDisplay;
    private TextView statusBar;
    private boolean isEqButtonClicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMathExpressionDisplay = findViewById(R.id.tv_calculation);
        tvResult =findViewById(R.id.tv_result);
        statusBar = findViewById(R.id.tv_status);
        updateDisplay();
    }
    public void updateDisplay(){
        if (isMemOn) {
            statusBar.setText("M");
        } else {
            statusBar.setText("");
        }
        tvMathExpressionDisplay.setText(mathExpression);
        if (isEqButtonClicked) {
            if (String.valueOf(answer).endsWith(".0")) {
                tvResult.setText(String.valueOf(answer).substring(0, String.valueOf(answer).length() - 2));
            } else {
                tvResult.setText(String.valueOf(answer));
            }
        } else {
            tvResult.setText(inputNumber);
        }

    }

    private void mcButtonClicked() {
        isMemOn=false;
        memory=0;
        updateDisplay();
    }

    private void msButtonClicked() {
        if (isEqButtonClicked) {
            memory = answer;
            mathExpression = tvResult.getText() + "Ms";
            isEqButtonClicked = true;
            currentExpression = '\0';
            isMemOn = true;
            updateDisplay();
            return;
        }
        if (currentExpression != '\0' && inputNumber == "") {
            tvResult.setText("Error");
            return;
        }
        if (currentExpression == '\0' && inputNumber != "") {
            answer = tmpNumber1;
        }
        if (currentExpression == '/' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 / tmpNumber2;
        }
        if (currentExpression == '+' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 + tmpNumber2;
        }
        if (currentExpression == 'x' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 * tmpNumber2;
        }
        if (currentExpression == '-' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 - tmpNumber2;
        }
        if (answer < 0) {
            tvResult.setText("lower than zero");
            return;
        }
        mathExpression = mathExpression + " Ms";
        memory = answer;
        isMemOn = true;
        isEqButtonClicked = true;
        updateDisplay();
    }

    private void mreadButtonClicked() {
        if (isMemOn) {
            mathExpression = "M=";
            answer = memory;
            isEqButtonClicked = true;
            updateDisplay();
        }
    }

    private void eqButtonClicked() {
        if (isEqButtonClicked) {
            return;
        }
        isEqButtonClicked = true;


        if (currentExpression != '\0' && inputNumber == "") {
            tvResult.setText("Error");
            return;
        }
        if (currentExpression == '\0' && inputNumber != "") {
            mathExpression = mathExpression + "=";
            answer = tmpNumber1;
        }
        if (currentExpression == '/' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber + "=";
            answer = tmpNumber1 / tmpNumber2;
        }
        if (currentExpression == '+' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber + "=";
            answer = tmpNumber1 + tmpNumber2;
        }
        if (currentExpression == 'x' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber + "=";
            answer = tmpNumber1 * tmpNumber2;
        }
        if (currentExpression == '-' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber + "=";
            answer = tmpNumber1 - tmpNumber2;
        }
        updateDisplay();
    }

    private void mplusButtonClicked() {
        if (isEqButtonClicked) {
            memory = memory + answer;
            mathExpression = tvResult.getText() + "M+";
            isEqButtonClicked = true;
            currentExpression = '\0';
            isMemOn = true;
            updateDisplay();
            return;
        }
        if (currentExpression != '\0' && inputNumber == "") {
            tvResult.setText("Error");
            return;
        }
        if (currentExpression == '\0' && inputNumber != "") {
            answer = tmpNumber1;
        }
        if (currentExpression == '/' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 / tmpNumber2;
        }
        if (currentExpression == '+' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 + tmpNumber2;
        }
        if (currentExpression == 'x' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 * tmpNumber2;
        }
        if (currentExpression == '-' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 - tmpNumber2;
        }
        if (answer < 0) {
            tvResult.setText("lower than zero");
            return;
        }
        mathExpression = mathExpression + " M+";
        memory = memory + answer;
        isMemOn = true;
        isEqButtonClicked = true;
        updateDisplay();
    }

    private void msubButtonClicked() {
        if (isEqButtonClicked) {
            memory = memory - answer;
            mathExpression = tvResult.getText() + "M-";
            isEqButtonClicked = true;
            currentExpression = '\0';
            isMemOn = true;
            updateDisplay();
            return;
        }
        if (currentExpression != '\0' && inputNumber == "") {
            tvResult.setText("Error");
            return;
        }
        if (currentExpression == '\0' && inputNumber != "") {
            answer = tmpNumber1;
        }
        if (currentExpression == '/' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 / tmpNumber2;
        }
        if (currentExpression == '+' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 + tmpNumber2;
        }
        if (currentExpression == 'x' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 * tmpNumber2;
        }
        if (currentExpression == '-' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 - tmpNumber2;
        }
        if (answer < 0) {
            tvResult.setText("lower than zero");
            return;
        }
        mathExpression = mathExpression + " M-";
        memory = memory - answer;
        isMemOn = true;
        isEqButtonClicked = true;
        updateDisplay();
    }

    private void msaveButtonClicked() {

    }

    private void plusButtonClicked() {
        if (isEqButtonClicked) {
            tmpNumber1 = answer;
            mathExpression = tvResult.getText() + "+";
            currentExpression = '+';
            inputNumber = "";
            isEqButtonClicked = false;
            updateDisplay();
            return;
        }
        if (inputNumber.endsWith(".")) inputNumber = inputNumber + "0";
        if (inputNumber.length() == 1 && inputNumber.charAt(0) == '-') {
            return;
        }
        if (inputNumber.isEmpty()) {
            tmpNumber1 = 0;
        }
        else {
            tmpNumber1 = Double.parseDouble(inputNumber);
        }
        mathExpression = mathExpression + "+";
        currentExpression = '+';
        inputNumber = "";
        updateDisplay();

    }

    private void subButtonClicked() {
        if (isEqButtonClicked) {
            tmpNumber1 = answer;
            mathExpression = tvResult.getText() + "-";
            currentExpression = '-';
            inputNumber = "";
            isEqButtonClicked = false;
            updateDisplay();
            return;
        }
        if (inputNumber.endsWith(".")) inputNumber = inputNumber + "0";
        if (inputNumber.length() == 1 && inputNumber.charAt(0) == '-') {
            return;
        }
        if (inputNumber.isEmpty()) {
            inputNumber = "-";
        } else {
            tmpNumber1 = Float.parseFloat(inputNumber);
            currentExpression = '-';
            mathExpression = mathExpression + "-";
            inputNumber = "";
        }
        updateDisplay();
    }

    private void mulButtonClicked() {
        if (isEqButtonClicked) {
            tmpNumber1 = answer;
            mathExpression = tvResult.getText() + "x";
            currentExpression = 'x';
            inputNumber = "";
            isEqButtonClicked = false;
            updateDisplay();
            return;
        }
        if (inputNumber.endsWith(".")) inputNumber = inputNumber + "0";
        if (inputNumber.length() == 1 && inputNumber.charAt(0) == '-') {
            return;
        }
        if (inputNumber.isEmpty()) {
            tmpNumber1 = 0;
        } else {
            tmpNumber1 = Float.parseFloat(inputNumber);
        }
        currentExpression = 'x';
        mathExpression = mathExpression + "x";
        inputNumber = "";
        updateDisplay();
    }

    private void divButtonClicked() {
        if (isEqButtonClicked) {
            tmpNumber1 = answer;
            mathExpression = tvResult.getText() + "/";
            currentExpression = '/';
            inputNumber = "";
            isEqButtonClicked = false;
            updateDisplay();
            return;
        }
        if (inputNumber.endsWith(".")) inputNumber = inputNumber + "0";
        if (inputNumber.length() == 1 && inputNumber.charAt(0) == '-') {
            return;
        }
        if (inputNumber.isEmpty()) {
            tmpNumber1 = 0;
        } else {
            tmpNumber1 = Float.parseFloat(inputNumber);
        }
        currentExpression = '/';
        mathExpression = mathExpression + "/";
        inputNumber = "";
        updateDisplay();
    }

    private void commaButtonclicked() {
        if (inputNumber.length() == 1 && inputNumber.charAt(0) == '-') {
            inputNumber = "-0.";
            updateDisplay();
            return;
        }
        if (inputNumber.contains(".")) {
            return;
        }
        if (inputNumber == "") {
            inputNumber = "0.";
        } else {
            inputNumber = inputNumber + ".";
        }
        isEqButtonClicked = false;
        updateDisplay();
    }

    private void percentButtonClicked() {
        if (isEqButtonClicked) {
            answer = answer / 100;
            mathExpression = tvResult.getText() + "%=";
            isEqButtonClicked = true;
            currentExpression = '\0';
            updateDisplay();
            return;
        }

        if (currentExpression != '\0' && inputNumber == "") {
            tvResult.setText("Error");
            return;
        }
        if (currentExpression == '\0' && inputNumber != "") {
            answer = tmpNumber1;
        }
        if (currentExpression == '/' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 / tmpNumber2;
        }
        if (currentExpression == '+' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 + tmpNumber2;
        }
        if (currentExpression == 'x' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 * tmpNumber2;
        }
        if (currentExpression == '-' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 - tmpNumber2;
        }
        mathExpression = mathExpression + "%=";
        answer = answer / 100;
        currentExpression = '\0';
        isEqButtonClicked = true;
        updateDisplay();
    }

    private void sqrtButtonClicked() {

        if (isEqButtonClicked) {
            answer = Math.sqrt(answer);
            mathExpression = "sqrt(" + tvResult.getText() + ")";
            isEqButtonClicked = true;
            currentExpression = '\0';
            updateDisplay();
            return;
        }

        if (currentExpression != '\0' && inputNumber == "") {
            tvResult.setText("Error");
            return;
        }
        if (currentExpression == '\0' && inputNumber != "") {
            answer = tmpNumber1;
        }
        if (currentExpression == '/' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 / tmpNumber2;
        }
        if (currentExpression == '+' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 + tmpNumber2;
        }
        if (currentExpression == 'x' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 * tmpNumber2;
        }
        if (currentExpression == '-' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 - tmpNumber2;
        }
        if (answer < 0) {
            tvResult.setText("lower than zero");
            return;
        }
        mathExpression = "sqrt(" + mathExpression + ")";
        answer = Math.sqrt(answer);
        updateDisplay();
    }

    private void powerButtonClicked() {
        if (isEqButtonClicked) {
            answer = Math.pow(answer, 2);
            mathExpression = "sqr(" + tvResult.getText() + ")";
            isEqButtonClicked = true;
            currentExpression = '\0';
            updateDisplay();
            return;
        }

        if (currentExpression != '\0' && inputNumber == "") {
            tvResult.setText("Error");
            return;
        }
        if (currentExpression == '\0' && inputNumber != "") {
            answer = tmpNumber1;
        }
        if (currentExpression == '/' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            try {
                answer = tmpNumber1 / tmpNumber2;
            } catch (Exception e) {
                tvResult.setText("divide by zero");
            }

        }
        if (currentExpression == '+' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 + tmpNumber2;
        }
        if (currentExpression == 'x' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 * tmpNumber2;
        }
        if (currentExpression == '-' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            answer = tmpNumber1 - tmpNumber2;
        }
        mathExpression = "sqr(" + mathExpression + ")";
        isEqButtonClicked = true;
        answer = Math.pow(answer, 2);
        updateDisplay();
    }

    private void numberButtonClicked(String str) {
        if (isEqButtonClicked) clear();
        if (currentExpression == '\0') {
            if (isEqButtonClicked) {
                tvResult.setText("");
                inputNumber = str;
                isEqButtonClicked = false;
            } else {
                if (inputNumber != null) {
                    inputNumber = inputNumber + str;
                } else inputNumber = str;
            }
            tvResult.setText(inputNumber);
            mathExpression = inputNumber;
            tmpNumber1 = Double.parseDouble(inputNumber);
            isEqButtonClicked = false;
        } else {
            if (inputNumber != null) {
                inputNumber = inputNumber + str;
            } else inputNumber = str;

            tvResult.setText(inputNumber);
            //mathExpression=inputNumber;
            tmpNumber2 = Double.parseDouble(inputNumber);
            isEqButtonClicked = false;
        }
    }

    private void clear() {
        tmpNumber1 = 0;
        tmpNumber2 = 0;
        inputNumber = "";
        isEqButtonClicked = false;
        tvResult.setText("");
        tvMathExpressionDisplay.setText("");
        currentExpression = '\0';
        mathExpression = "";
    }

    private void clearEnter() {
        tvResult.setText("");
        inputNumber = "";
    }

    private void backspaceButtonClicked() {
        if (inputNumber.length() != 0) {
            inputNumber = inputNumber.substring(0, inputNumber.length() - 1);
        }
        updateDisplay();
    }
    public void onClick(View v) {
        if (v.getId()==R.id.btn_0) {
            numberButtonClicked("0");
        } else if (v.getId()==R.id.btn_1) {
            numberButtonClicked("1");
        } else if (v.getId()==R.id.btn_2) {
            numberButtonClicked("2");
        } else if (v.getId()==R.id.btn_3) {
            numberButtonClicked("3");
        } else if (v.getId()==R.id.btn_4) {
            numberButtonClicked("4");
        } else if (v.getId()==R.id.btn_5) {
            numberButtonClicked("5");
        } else if (v.getId()==R.id.btn_6) {
            numberButtonClicked("6");
        } else if (v.getId()==R.id.btn_7) {
            numberButtonClicked("7");
        } else if (v.getId()==R.id.btn_8) {
            numberButtonClicked("8");
        } else if (v.getId()==R.id.btn_9) {
            numberButtonClicked("9");
        } else if (v.getId()==R.id.btn_div) {
            divButtonClicked();
        } else if (v.getId()==R.id.btn_mul) {
            mulButtonClicked();
        } else if (v.getId()==R.id.btn_sub) {
            subButtonClicked();
        } else if (v.getId()==R.id.btn_plus) {
            plusButtonClicked();
        } else if (v.getId()==R.id.btn_perc) {
            percentButtonClicked();
        } else if (v.getId()==R.id.btn_power) {
            powerButtonClicked();
        } else if (v.getId() == R.id.btn_c) {
            clear();
        } else if (v.getId() == R.id.btn_ce) {
            clearEnter();
        } else if (v.getId()==R.id.btn_comma) {
            commaButtonclicked();
        } else if (v.getId()==R.id.btn_sqrt) {
            sqrtButtonClicked();
        } else if (v.getId() == R.id.btn_equa) {
            eqButtonClicked();
        } else if (v.getId()==R.id.btn_mplus) {
            mplusButtonClicked();
        } else if (v.getId() == R.id.btn_mr) {
            mreadButtonClicked();
        } else if (v.getId()==R.id.btn_msub) {
            msubButtonClicked();
        } else if (v.getId() == R.id.btn_bks) {
            backspaceButtonClicked();
        } else if (v.getId() == R.id.btn_ms) {
            msButtonClicked();
        } else if (v.getId() == R.id.btn_mc) {
            mcButtonClicked();
        }
    }
}
