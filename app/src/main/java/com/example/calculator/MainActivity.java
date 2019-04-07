package com.example.calculator;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.calculator.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private static final char ADDN = '+';
    private static final char SUBN = '-';
    private static final char MULN = '*';
    private static final char DIVN = '/';

    private char CURRENT_ACTION;

    private double valueOne = Double.NaN;
    private double valueTwo;

    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        decimalFormat = new DecimalFormat("#.##########");

        //setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.calc.setText(binding.calc.getText() + ".");
            }
        });

        binding.button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.calc.setText(binding.calc.getText() + "0");
            }
        });

        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.calc.setText(binding.calc.getText() + "1");
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.calc.setText(binding.calc.getText() + "2");
            }
        });

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.calc.setText(binding.calc.getText() + "3");
            }
        });

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.calc.setText(binding.calc.getText() + "4");
            }
        });

        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.calc.setText(binding.calc.getText() + "5");
            }
        });

        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.calc.setText(binding.calc.getText() + "6");
            }
        });
        binding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.calc.setText(binding.calc.getText() + "7");
            }
        });
        binding.button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.calc.setText(binding.calc.getText() + "8");
            }
        });
        binding.button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.calc.setText(binding.calc.getText() + "9");
            }
        });

        binding.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalcultion();
                CURRENT_ACTION = ADDN;
                binding.result.setText(decimalFormat.format(valueOne) + "+");
                binding.calc.setText(null);
            }
        });

        binding.buttonMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalcultion();
                CURRENT_ACTION = SUBN;
                binding.result.setText(decimalFormat.format(valueOne) + "-");
                binding.calc.setText(null);
            }
        });

        binding.buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalcultion();
                CURRENT_ACTION = MULN;
                binding.result.setText(decimalFormat.format(valueOne) + "*");
                binding.calc.setText(null);
            }
        });

        binding.buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalcultion();
                CURRENT_ACTION = DIVN;
                binding.result.setText(decimalFormat.format(valueOne) + "/");
                binding.calc.setText(null);
            }
        });

        binding.buttonEqualto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalcultion();
                binding.result.setText(binding.result.getText().toString() +
                        decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                System.out.println(binding.result.getText());
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });

        binding.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.calc.getText().length() > 0){
                    CharSequence currentText = binding.calc.getText();
                    binding.calc.setText(currentText.subSequence(0, currentText.length() - 1));
                }
                else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    binding.calc.setText("");
                    binding.result.setText("");
                }
            }
        });


    }

    private void computeCalcultion() {

        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(binding.calc.getText().toString());
            binding.calc.setText(null);

            if (CURRENT_ACTION == ADDN)
                valueOne = this.valueOne + valueTwo;
            else if (CURRENT_ACTION == SUBN)
                valueOne = this.valueOne - valueTwo;
            else if (CURRENT_ACTION == MULN)
                valueOne = this.valueOne * valueTwo;
            else if (CURRENT_ACTION == DIVN)
                valueOne = this.valueOne / valueTwo;

        } else {
            try {
                valueOne = Double.parseDouble(binding.calc.getText().toString());
            } catch (Exception e) {

            }
        }


    }
}
