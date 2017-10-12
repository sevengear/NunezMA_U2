package org.manc.nunezma_u2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Miguel Á. Núñez Casado on 03/10/2017.
 */

public class Calc extends Fragment implements View.OnClickListener{

    private TextView entrada;
    private String firstOp = "";
    private boolean sumPres, finOp;
    private static double CONVERSION = 166.386;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.calc, container, false);
        entrada = view.findViewById(R.id.textResult);

        Button btn0 = view.findViewById(R.id.button0);
        Button btn1 = view.findViewById(R.id.button1);
        Button btn2 = view.findViewById(R.id.button2);
        Button btn3 = view.findViewById(R.id.button3);
        Button btn4 = view.findViewById(R.id.button4);
        Button btn5 = view.findViewById(R.id.button5);
        Button btn6 = view.findViewById(R.id.button6);
        Button btn7 = view.findViewById(R.id.button7);
        Button btn8 = view.findViewById(R.id.button8);
        Button btn9 = view.findViewById(R.id.button9);
        Button btnPlus = view.findViewById(R.id.buttonPlus);
        Button btnZero = view.findViewById(R.id.buttonZero);
        Button btnEquals = view.findViewById(R.id.buttonEquals);
        Button btnPts = view.findViewById(R.id.buttonPts);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnPts.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button0:
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:
                numberClick(v);
                break;
            case R.id.buttonPlus:
                sumClick();
                break;
            case R.id.buttonZero:
                zeroClick();
                break;
            case R.id.buttonEquals:
                equalsClick();
                break;
            case R.id.buttonPts:
                convertClick();
                break;
        }
    }

    public void numberClick(View view){

        if(entrada.getText().equals("0") || sumPres || finOp) {
            entrada.setText((String) view.getTag());
            sumPres = false;
            finOp = false;
        } else
            entrada.setText(new StringBuilder().append(entrada.getText()).append((String) view.getTag()));
    }

    public void sumClick() {
        if(firstOp.isEmpty()) {
            firstOp = (String) entrada.getText();
            sumPres = true;
        } else {
            int res = Integer.parseInt(firstOp) + Integer.parseInt(entrada.getText().toString());
            entrada.setText(String.valueOf(res));
            firstOp = String.valueOf(res);
            sumPres = true;
        }
    }

    public void equalsClick() {
        if(!firstOp.equals("")) {
            int res = Integer.parseInt(firstOp) + Integer.parseInt(entrada.getText().toString());
            entrada.setText(String.valueOf(res));
            firstOp = "";
            sumPres = false;
            finOp = true;
        }
    }

    public void zeroClick() {
        entrada.setText("0");
        firstOp = "";
        sumPres = false;
    }

    public void convertClick() {
        double conv = Integer.parseInt(entrada.getText().toString()) * CONVERSION;
        Long L = Math.round(conv);
        int res = L.intValue();
        entrada.setText(String.valueOf(res));
    }
}
