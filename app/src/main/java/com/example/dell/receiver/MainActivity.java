package com.example.dell.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView box1TV,box2TV;
    private static String SAMPLE_ACTION="com.example.dell.receiver.SAMPLE_ACTION";
   // private static String GLOBAL_ACTION="com.example.dell.receiver.GLOBAL";

    private GlobalBCR1 receiver1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        box1TV = (TextView) findViewById(R.id.textBox1);
        box2TV = (TextView) findViewById(R.id.textBox2);
        receiver1 = new GlobalBCR1();
        registerReceiver(receiver1,new IntentFilter(SAMPLE_ACTION));
    }


    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver1);
        super.onDestroy();
    }

    public class GlobalBCR1 extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("broadcast","receiver 1 called");

            String msg = intent.getStringExtra("broadcastOne");
            box1TV.setText(msg);
        }
    }
    public class GlobalBCR2 extends BroadcastReceiver{


        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("broadcast","receiver 2 called");
            String msg = intent.getStringExtra("broadcastTwo");
            box2TV.setText(msg);
        }
    }
}
