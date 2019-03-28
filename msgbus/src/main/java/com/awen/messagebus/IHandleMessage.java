package com.awen.messagebus;

import android.os.Message;

/**
 * Describe:
 * Created by AwenZeng on 2019/3/28
 */
public interface IHandleMessage {
    void handleMessage(Message msg);
}
