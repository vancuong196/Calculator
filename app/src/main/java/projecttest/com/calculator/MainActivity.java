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

    // hàm để refresh các thông số hiển thị trên màn hình máy tính
    public void updateDisplay(){
        // hiển thị trạng thái m
        if (isMemOn) {
            statusBar.setText("M");
        } else {
            statusBar.setText("");
        }
        // hiển thị phép tính
        tvMathExpressionDisplay.setText(mathExpression);

        //hiển thị kết quả phép tính, số được nhập
        if (isEqButtonClicked) {
            // bỏ .0 nếu là số nguyên trước khi hiển thị
            if (String.valueOf(answer).endsWith(".0")) {
                tvResult.setText(String.valueOf(answer).substring(0, String.valueOf(answer).length() - 2));
            } else {
                tvResult.setText(String.valueOf(answer));
            }
        } else {
            tvResult.setText(inputNumber);
        }

    }

    // Xóa bộ nhớ M
    private void mcButtonClicked() {
        isMemOn=false;
        memory=0;
        updateDisplay();
    }

    // lưu kết quả vào M và hiển thị trên màn hình, cách thứ tính toán như khi bấm nút =, xem hàm eqButtonClicked() để xem giải thích thuật toán
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
            if (tmpNumber2 == 0) {
                tvResult.setText("divided by zero");
                return;
            }
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
        mathExpression = mathExpression + "Ms";
        memory = answer;
        isMemOn = true;
        currentExpression = '\0';
        isEqButtonClicked = true;
        updateDisplay();
    }

    // Hàm đọc bộ nhớ M và hiển thị lên màn hình
    private void mreadButtonClicked() {
        if (isMemOn) {
            mathExpression = "M=";
            answer = memory;
            isEqButtonClicked = true;
            updateDisplay();
        }
    }

    // Hàm tính toán khi nhấn dấu bằng
    private void eqButtonClicked() {
        // Nếu trước đó phép tính đã được thực hiện thì bỏ qua
        if (isEqButtonClicked) {
            return;
        }


        // nếu phép toán hiện thiếu toán hạng thứ 2 thì báo lỗi
        if (currentExpression != '\0' && inputNumber == "") {
            tvResult.setText("missing operand");
            return;
        }
        // nếu chỉ đơn thuần là số được nhập (currentExpression=null), thì kết quả bằng số được nhập
        if (currentExpression == '\0' && inputNumber != "") {
            mathExpression = mathExpression + "=";
            answer = tmpNumber1;
        }
        // nếu phép toán được nhập đúng thì tính
        //Phép chia
        if (currentExpression == '/' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber + "=";
            // Báo lỗi chia cho 0
            if (tmpNumber2 == 0) {
                tvResult.setText("divided by zero");
                return;
            }
            answer = tmpNumber1 / tmpNumber2;
        }
        // phép cộng
        if (currentExpression == '+' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber + "=";
            answer = tmpNumber1 + tmpNumber2;
        }
        // phép nhân
        if (currentExpression == 'x' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber + "=";
            answer = tmpNumber1 * tmpNumber2;
        }
        //phép chia
        if (currentExpression == '-' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber + "=";
            answer = tmpNumber1 - tmpNumber2;
        }
        // Đánh dấu là phép toán đã được thực hiện
        isEqButtonClicked = true;
        // câp nhập các thông số rồi hiển thị lên màn hình
        currentExpression = '\0';
        updateDisplay();
    }

    // Thưc hiện các thao tác khi nhấn M+, cộng đáp án vào M, tính toán như hàm eqButtonClicked
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
            tvResult.setText("missing operand");
            return;
        }
        if (currentExpression == '\0' && inputNumber != "") {
            answer = tmpNumber1;
        }
        if (currentExpression == '/' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            if (tmpNumber2 == 0) {
                tvResult.setText("divided by zero");
                return;
            }
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
        mathExpression = mathExpression + " M+";
        memory = memory + answer;
        isMemOn = true;
        isEqButtonClicked = true;
        currentExpression = '\0';
        updateDisplay();
    }

    // Hàm thực hiên khi nhấn nút M-, thực hiện tương tự như M+
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
            tvResult.setText("missing operand");
            return;
        }
        if (currentExpression == '\0' && inputNumber != "") {
            answer = tmpNumber1;
        }
        if (currentExpression == '/' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            if (tmpNumber2 == 0) {
                tvResult.setText("divided by zero");
                return;
            }
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
        mathExpression = mathExpression + "M-";
        memory = memory - answer;
        isMemOn = true;
        currentExpression = '\0';
        isEqButtonClicked = true;
        updateDisplay();
    }

    // Hàm thực hiện khi nhấn nut +
    private void plusButtonClicked() {
        //Nếu đã có toán tử thì bỏ qua
        if (currentExpression != '\0') {
            return;
        }
        // Nếu có kết quả của phép tính trước đó thì toán hạng đầu tiên sẽ được gán bằng answer
        if (isEqButtonClicked) {
            tmpNumber1 = answer;
            // cập nhập thông tin phép toán để hiển thị
            mathExpression = tvResult.getText() + "+";
            currentExpression = '+';
            inputNumber = "";
            // Đánh dấu là đã thực hiện phép toán khác
            isEqButtonClicked = false;
            updateDisplay();
            return;
        }

        // Phép toán mới

        // Nếu số hạng thứ nhất chưa được nhập  hoặc chỉ mới hập dấu - thì bỏ qua
        if (inputNumber.length() == 1 && inputNumber.charAt(0) == '-' || inputNumber.isEmpty()) {
            return;
        }
        // Lưu số hạng thứ nhất
        else {
            if (inputNumber.endsWith(".")) inputNumber = inputNumber + "0";
            tmpNumber1 = Double.parseDouble(inputNumber);
            mathExpression = mathExpression + "+";
            currentExpression = '+';
            inputNumber = "";
            updateDisplay();
        }

    }

    // Nhấn nút -, tương tự như nút + nhưng cho phép người dùng nhập dấu của số âm
    private void subButtonClicked() {
        if (currentExpression != '\0' && !inputNumber.isEmpty()) {
            return;
        }
        if (isEqButtonClicked) {
            tmpNumber1 = answer;
            mathExpression = tvResult.getText() + "-";
            currentExpression = '-';
            inputNumber = "";
            isEqButtonClicked = false;
            updateDisplay();
            return;
        }

        if (inputNumber.length() == 1 && inputNumber.charAt(0) == '-') {
            return;
        }
        // nhập dấu cho số âm
        if (inputNumber.isEmpty()) {
            inputNumber = "-";
        } else {
            if (inputNumber.endsWith(".")) inputNumber = inputNumber + "0";
            tmpNumber1 = Float.parseFloat(inputNumber);
            currentExpression = '-';
            mathExpression = mathExpression + "-";
            inputNumber = "";
        }
        updateDisplay();
    }

    // Nhấn nút x, tương tự như khi bấm nut +
    private void mulButtonClicked() {
        if (currentExpression != '\0') {
            return;
        }
        if (isEqButtonClicked) {
            tmpNumber1 = answer;
            mathExpression = tvResult.getText() + "x";
            currentExpression = 'x';
            inputNumber = "";
            isEqButtonClicked = false;
            updateDisplay();
            return;
        }

        if (inputNumber.length() == 1 && inputNumber.charAt(0) == '-' || inputNumber.isEmpty()) {
            return;
        } else {
            if (inputNumber.endsWith(".")) inputNumber = inputNumber + "0";
            tmpNumber1 = Float.parseFloat(inputNumber);
            currentExpression = 'x';
            mathExpression = mathExpression + "x";
            inputNumber = "";
            updateDisplay();
        }
    }

    // Nhấn nut /, tương tự như khi bấm nút nhân
    private void divButtonClicked() {
        if (currentExpression != '\0') {
            return;
        }
        if (isEqButtonClicked) {
            tmpNumber1 = answer;
            mathExpression = tvResult.getText() + "/";
            currentExpression = '/';
            inputNumber = "";
            isEqButtonClicked = false;
            updateDisplay();
            return;
        }
        if (inputNumber.length() == 1 && inputNumber.charAt(0) == '-' || inputNumber.isEmpty()) {
            return;
        } else {
            if (inputNumber.endsWith(".")) inputNumber = inputNumber + "0";
            tmpNumber1 = Float.parseFloat(inputNumber);
            currentExpression = '/';
            mathExpression = mathExpression + "/";
            inputNumber = "";
            updateDisplay();
        }
    }

    // Nhấn nut .
    private void commaButtonclicked() {
        // tự động thêm 0.
        if (inputNumber.length() == 1 && inputNumber.charAt(0) == '-') {
            inputNumber = "-0.";
            updateDisplay();
            return;
        }
        // Nếu số đã có dấu chấm thì bỏ qua
        if (inputNumber.contains(".")) {
            return;
        }
        // tự động thêm 0.
        if (inputNumber == "") {
            inputNumber = "0.";
        } else {
            inputNumber = inputNumber + ".";
        }
        isEqButtonClicked = false;
        updateDisplay();
    }

    // nhấn nut %, tính toán tương tự như khi nhấn dấu =
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
            tvResult.setText("missing operand");
            return;
        }
        if (currentExpression == '\0' && inputNumber != "") {
            answer = tmpNumber1;
        }
        if (currentExpression == '/' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            if (tmpNumber2 == 0) {
                tvResult.setText("divided by zero");
                return;
            }
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

    // Nhấn nút căn, tính toán tương tự như khi nhấn dấu bằng, bắt thêm lỗi kết quả <0 thì không thể tính căn
    private void sqrtButtonClicked() {

        if (isEqButtonClicked) {
            answer = Math.sqrt(answer);
            if (answer < 0) {
                tvResult.setText("lower than zero");
            }
            mathExpression = "sqrt(" + tvResult.getText() + ")";
            isEqButtonClicked = true;
            currentExpression = '\0';
            updateDisplay();
            return;
        }

        if (currentExpression != '\0' && inputNumber == "") {
            tvResult.setText("missing operand");
            return;
        }
        if (currentExpression == '\0' && inputNumber != "") {
            answer = tmpNumber1;
        }
        if (currentExpression == '/' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            if (tmpNumber2 == 0) {
                tvResult.setText("divided by zero");
            }
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
        currentExpression = '\0';
        updateDisplay();
    }

    // Nhấn nút ^2, tính toán tương tự khi nhấn nút =
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
            tvResult.setText("missing operand");
            return;
        }
        if (currentExpression == '\0' && inputNumber != "") {
            answer = tmpNumber1;
        }
        if (currentExpression == '/' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            if (tmpNumber2 == 0) {
                tvResult.setText("divided by zero");
            }
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
        mathExpression = "sqr(" + mathExpression + ")";
        isEqButtonClicked = true;
        currentExpression = '\0';
        answer = Math.pow(answer, 2);
        updateDisplay();
    }

    // hàm 1/x
    private void motChiaX() {
        if (isEqButtonClicked) {
            if (answer == 0) {
                tvResult.setText("divided by zero");
            }
            answer = 1 / answer;
            mathExpression = "1/" + tvResult.getText();
            isEqButtonClicked = true;
            currentExpression = '\0';
            updateDisplay();
            return;
        }

        if (currentExpression != '\0' && inputNumber == "") {
            tvResult.setText("missing operand");
            return;
        }
        if (currentExpression == '\0' && inputNumber != "") {
            answer = tmpNumber1;
        }
        if (currentExpression == '/' && inputNumber != "") {
            mathExpression = mathExpression + inputNumber;
            if (tmpNumber2 == 0) {
                tvResult.setText("divided by zero");
            }
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
        if (answer == 0) {
            tvResult.setText("divided by zero");
            return;
        }
        mathExpression = "1/" + mathExpression;
        isEqButtonClicked = true;
        currentExpression = '\0';
        answer = 1 / answer;
        updateDisplay();
    }

    // Hàm xử lý nhập số
    private void numberButtonClicked(String str) {
        // nếu đang hiển thị kế quả thì xóa màn hình với các giá trị phép toán trước
        if (isEqButtonClicked) clear();
        // nếu đang nhập số đơn thần thì lưu số tạm vào toán hạng 1
        if (currentExpression == '\0') {

            if (inputNumber != null) {
                inputNumber = inputNumber + str;
            } else inputNumber = str;

            tvResult.setText(inputNumber);
            mathExpression = inputNumber;
            tmpNumber1 = Double.parseDouble(inputNumber);
            isEqButtonClicked = false;

        }
        // Nếu đang nhập toán hạng 2 cho phép toán thì lưu số đang nhập vào toán hạng 2
        else {
            if (inputNumber != null) {
                inputNumber = inputNumber + str;
            } else inputNumber = str;

            tvResult.setText(inputNumber);
            //mathExpression=inputNumber;
            tmpNumber2 = Double.parseDouble(inputNumber);
            isEqButtonClicked = false;
        }
    }

    // Xóa tất cả các thứ trên màn hình
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

    // Xóa dòng đang nhập
    private void clearEnter() {
        tvResult.setText("");
        inputNumber = "";
    }

    // Nhấn backspace
    private void backspaceButtonClicked() {
        if (inputNumber.length() != 0) {
            inputNumber = inputNumber.substring(0, inputNumber.length() - 1);
        }
        updateDisplay();
    }

    // Bắt sự kiện
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
        } else if (v.getId() == R.id.btn_1x) {
            motChiaX();
        }
    }
}
