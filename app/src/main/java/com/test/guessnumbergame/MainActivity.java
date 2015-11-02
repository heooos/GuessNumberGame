package com.test.guessnumbergame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView,tv_minNum,tv_maxNum;
    EditText editText;
    static int inNum;
    static int nowNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_minNum = (TextView)findViewById(R.id.tv_minNum);
        tv_maxNum = (TextView)findViewById(R.id.tv_MaxNum);
        textView = (TextView)findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editText);
        nowNum = ((int)(Math.random()*100));
        findViewById(R.id.btn_change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nowNum = (int)(Math.random()*100);
                tv_maxNum.setText("");
                tv_minNum.setText("");
                textView.setText("");
                editText.setText("");
            }
        });
        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   try{
                       inNum = Integer.parseInt(editText.getText().toString());
                       if (inNum >=100){
                           textView.setText("输入不合法");
                           editText.setText("");
                       }
                       else {
                           if (inNum > nowNum) {
                               textView.setText("猜大了");
                               tv_maxNum.setText(inNum + "");
                               editText.setText("");
                           }

                           if (inNum < nowNum) {
                               textView.setText("猜小了");
                               tv_minNum.setText(inNum + "");
                               editText.setText("");
                           }

                           if (inNum == nowNum) {
                               textView.setText("恭喜，猜对了");
                           }
                       }
                   }catch (Exception e){
                       textView.setText("输入不合法");
                   }
            }
        });
    }
}
