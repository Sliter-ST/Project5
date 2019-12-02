package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    public  static final int UPDATE_TEXT=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        Button changeText=(Button) findViewById(R.id.change);
        changeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        new Thread(new Runnable() {
                            @Override
                            public void run () {
                                Message message = new Message();
                                message.what=UPDATE_TEXT;
                                handler.sendMessage(message);
                            }
                        }).start();
                }
        });
    }

    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case  UPDATE_TEXT:
                    text.setText("nice to meet you");
                    break;
                default:
                    break;
            }
        }
    };
}
