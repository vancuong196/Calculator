package projecttest.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private float memory;
    private float answer;
    private boolean isMemOn;
    private String mathString;
    private TextView tvResult;
    private TextView tvMathDisplay;
    private TextView statusBar;
    private boolean isDisplayingAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMathDisplay =findViewById(R.id.tv_calculation);
        tvResult =findViewById(R.id.tv_result);
        statusBar = findViewById(R.id.tv_status);
        updateDisplay();
    }
    public void updateDisplay(){
        if(isMemOn) statusBar.setText("M");
        tvMathDisplay.setText(mathString);
        if (isDisplayingAnswer){
            tvResult.setText(String.valueOf(answer));
        } else {
            tvResult.setText("");
        }

    }
    public void calculate(){

    }
    public void reset(){
        answer=0;
        isMemOn=false;
        mathString="";
        tvResult.setText("");
        tvMathDisplay.setText("");
        statusBar.setText("");
        memory=0;
        isDisplayingAnswer=false;
    }
    private void nonFuntionButtonPressed(String str){
        if (isDisplayingAnswer){
            mathString=str;
            isDisplayingAnswer=false;
        }
        else {
            if (mathString!=null) {
                mathString=mathString+str;
            }
            else mathString=str;
        }
        updateDisplay();
    }
    public void onClick(View v) {
        if (v.getId()==R.id.btn_0) {
           nonFuntionButtonPressed("0");
        } else if (v.getId()==R.id.btn_1) {
            nonFuntionButtonPressed("1");
        } else if (v.getId()==R.id.btn_2) {
            nonFuntionButtonPressed("2");
        } else if (v.getId()==R.id.btn_3) {
            nonFuntionButtonPressed("3");
        } else if (v.getId()==R.id.btn_4) {
            nonFuntionButtonPressed("4");
        } else if (v.getId()==R.id.btn_5) {
            nonFuntionButtonPressed("5");
        } else if (v.getId()==R.id.btn_6) {
            nonFuntionButtonPressed("6");
        } else if (v.getId()==R.id.btn_7) {
            nonFuntionButtonPressed("7");
        } else if (v.getId()==R.id.btn_8) {
            nonFuntionButtonPressed("8");
        } else if (v.getId()==R.id.btn_9) {
            nonFuntionButtonPressed("9");
        } else if (v.getId()==R.id.btn_div) {
            nonFuntionButtonPressed("÷");
        } else if (v.getId()==R.id.btn_mul) {
            nonFuntionButtonPressed("x");
        } else if (v.getId()==R.id.btn_sub) {
            nonFuntionButtonPressed("-");
        } else if (v.getId()==R.id.btn_plus) {
            nonFuntionButtonPressed("+");
        } else if (v.getId()==R.id.btn_pi) {
            nonFuntionButtonPressed("π");
        } else if (v.getId()==R.id.btn_perc) {
            nonFuntionButtonPressed("%");
        } else if (v.getId()==R.id.btn_power) {
            nonFuntionButtonPressed("^");
        } else if (v.getId()==R.id.btn_closec) {
            nonFuntionButtonPressed(")");
        } else if (v.getId()==R.id.btn_openc) {
            nonFuntionButtonPressed("(");
        } else if (v.getId()==R.id.btn_comma) {
            nonFuntionButtonPressed(".");
        } else if (v.getId()==R.id.btn_sqrt) {
            nonFuntionButtonPressed("√");
        }  else if (v.getId()==R.id.btn_ans) {
            nonFuntionButtonPressed("ANS");
        } else if (v.getId()==R.id.btn_mplus) {
            calculate();
        } else if (v.getId()==R.id.btn_mread) {

        } else if (v.getId()==R.id.btn_msub) {

        } else if (v.getId()==R.id.btn_backspace) {
            if (mathString.length()!=0) {
                mathString=mathString.substring(0,mathString.length()-1);
            }
            updateDisplay();
        } else if (v.getId()==R.id.btn_allcls) {
            reset();
        } else if (v.getId()==R.id.btn_equa) {
            try {
                new Calculator(mathString);
            } catch (MathExpressionErrorException e) {
                tvResult.setText(e.getMessage());
            }
        }
    }
}
