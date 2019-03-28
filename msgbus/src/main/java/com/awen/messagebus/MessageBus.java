package com.awen.messagebus;

import android.os.Message;


/**
 * Describe:消息Bus
 * Created by AwenZeng on 2019/3/28
 */
public class MessageBus implements IMessageBus {

    private static volatile MessageBus instance;
    private MsgHandler mHandler;

    public static MessageBus getDefault(){
        if(instance == null){
            synchronized (MessageBus.class){
                if(instance == null){
                    instance = new MessageBus();
                }
            }
        }
        return instance;
    }

    public MessageBus() {
        mHandler = new MsgHandler();
    }

    public MsgHandler getHandler() {
        return mHandler;
    }

    @Override
    public void handleMessage(IHandleMessage handlerMessage) {
        mHandler.handleMessage(handlerMessage);
    }

    @Override
    public boolean hasMessages(int what) {
        return mHandler.hasMessages(what);
    }

    @Override
    public boolean hasMessages(int what, Object object) {
        return mHandler.hasMessages(what,object);
    }

    @Override
    public Message obtainMessage() {
        return mHandler.obtainMessage();
    }

    @Override
    public Message obtainMessage(int what) {
        return mHandler.obtainMessage(what);
    }

    @Override
    public Message obtainMessage(int what, Object obj) {
        return mHandler.obtainMessage(what,obj);
    }

    @Override
    public Message obtainMessage(int what, int arg1, int arg2) {
        return mHandler.obtainMessage(what,arg1,arg2);
    }

    @Override
    public Message obtainMessage(int what, int arg1, int arg2, Object obj) {
        return mHandler.obtainMessage(what,arg1,arg2,obj);
    }

    @Override
    public boolean sendMessage(Message msg) {
        return mHandler.sendMessage(msg);
    }

    @Override
    public boolean sendEmptyMessage(int what) {
        return mHandler.sendEmptyMessage(what);
    }

    @Override
    public boolean sendEmptyMessageDelayed(int what, long delayMillis) {
        return mHandler.sendEmptyMessageDelayed(what,delayMillis);
    }

    @Override
    public boolean sendEmptyMessageAtTime(int what, long uptimeMillis) {
        return mHandler.sendEmptyMessageAtTime(what,uptimeMillis);
    }

    @Override
    public boolean sendMessageDelayed(Message msg, long delayMillis) {
        return mHandler.sendMessageDelayed(msg,delayMillis);
    }

    @Override
    public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
        return mHandler.sendMessageAtTime(msg,uptimeMillis);
    }

    @Override
    public boolean sendMessageAtFrontOfQueue(Message msg) {
        return mHandler.sendMessageAtFrontOfQueue(msg);
    }

    @Override
    public boolean post(Runnable r) {
        return mHandler.post(r);
    }

    @Override
    public boolean postAtTime(Runnable r, long uptimeMillis) {
        return mHandler.postAtTime(r,uptimeMillis);
    }

    @Override
    public boolean postAtTime(Runnable r, Object token, long uptimeMillis) {
        return mHandler.postAtTime(r,token,uptimeMillis);
    }

    @Override
    public boolean postDelayed(Runnable r, long delayMillis) {
        return mHandler.postDelayed(r,delayMillis);
    }

    @Override
    public boolean postAtFrontOfQueue(Runnable r) {
        return mHandler.postAtFrontOfQueue(r);
    }

    @Override
    public void removeCallbacks(Runnable r) {
        mHandler.removeCallbacks(r);
    }

    @Override
    public void removeCallbacks(Runnable r, Object token) {
        mHandler.removeCallbacks(r,token);
    }

    @Override
    public void removeMessages(int what) {
        mHandler.removeMessages(what);
    }

    @Override
    public void removeMessages(int what, Object object) {
       mHandler.removeMessages(what,object);
    }

    @Override
    public void removeCallbacksAndMessages(Object token) {
       mHandler.removeCallbacksAndMessages(token);
    }

    private static class MsgHandler extends android.os.Handler {

        private IHandleMessage mIHandlerMessage;

        public void handleMessage(IHandleMessage mIHandlerMessage) {
            this.mIHandlerMessage = mIHandlerMessage;
        }

        @Override
        public void handleMessage(Message msg) {
            if(mIHandlerMessage!=null){
                mIHandlerMessage.handleMessage(msg);
            }
        }
    }
}
