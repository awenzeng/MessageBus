package com.awen.messagebussample;

import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.awen.messagebus.IHandleMessage;
import com.awen.messagebus.MessageBus;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MessageBus";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MessageBus.getDefault().handleMessage(new IHandleMessage() {
            @Override
            public void handleMessage(Message msg) {
                Log.i(TAG,"线程信息："+ Thread.currentThread().getName());
                Log.i(TAG,"打印日志："+ msg.obj);

            }
        });

        Message msg = MessageBus.getDefault().obtainMessage();
        msg.obj = "感悟生命的意思！";
        MessageBus.getDefault().sendMessage(msg);

        Message msg1 = MessageBus.getDefault().obtainMessage();
        msg1.obj = "感悟生命的意思，体验人生的美好，创造回忆，回忆人生。";
        MessageBus.getDefault().sendMessageDelayed(msg1,10000);

        MessageBus.getDefault().post(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG,"线程信息："+ Thread.currentThread().getName());
                Log.i(TAG,"创造回忆，回忆人生！");
            }
        });

        MessageBus.getDefault().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG,"线程信息："+ Thread.currentThread().getName());
                Log.i(TAG,"感悟生命的意思，体验人生的美好！");
            }
        },5000);


        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG,"线程信息："+ Thread.currentThread().getName());
                Message msg3 = new Message();
                msg3.obj = "体验人生的美好!";
                MessageBus.getDefault().sendMessage(msg3);
            }
        }).start();

        MessageBus.getDefault().sendEmptyMessageAtTime(0, SystemClock.uptimeMillis()+1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MessageBus.getDefault().removeCallbacksAndMessages(null);
    }
}
