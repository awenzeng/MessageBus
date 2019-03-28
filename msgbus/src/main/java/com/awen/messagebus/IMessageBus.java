package com.awen.messagebus;

import android.os.Message;

/**
 * Describe:消息bus功能
 * Created by AwenZeng on 2019/3/28
 */
public interface IMessageBus {
    /**
     * 处理消息
     * @param handlerMessage
     */
    void handleMessage(IHandleMessage handlerMessage);

    //是否有消息判断
    boolean hasMessages(int what);
    boolean hasMessages(int what, Object object);

    //Message获取
    Message obtainMessage();
    Message obtainMessage(int what);
    Message obtainMessage(int what, Object obj);
    Message obtainMessage(int what, int arg1, int arg2);
    Message obtainMessage(int what, int arg1, int arg2, Object obj);


    //发送消息
    boolean sendMessage(Message msg);
    boolean sendEmptyMessage(int what);
    boolean sendEmptyMessageDelayed(int what, long delayMillis);
    boolean sendEmptyMessageAtTime(int what, long uptimeMillis);
    boolean sendMessageDelayed(Message msg, long delayMillis);
    boolean sendMessageAtTime(Message msg, long uptimeMillis);
    boolean sendMessageAtFrontOfQueue(Message msg);//发送一个消息在队列之前


    //发送一个Runnable方法
    boolean post(Runnable r);
    boolean postAtTime(Runnable r, long uptimeMillis);
    boolean postAtTime(Runnable r, Object token, long uptimeMillis);
    boolean postDelayed(Runnable r, long delayMillis);
    boolean postAtFrontOfQueue(Runnable r);//发送一个Runnable在消息队列之前


    //Remove相关消息或runnable
    void removeCallbacks(Runnable r);
    void removeCallbacks(Runnable r, Object token);
    void removeMessages(int what);
    void removeMessages(int what, Object object);
    void removeCallbacksAndMessages(Object token);

}
