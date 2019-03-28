# MessageBus
  MessageBus,easier for you to use Handler.(Welcome to Star and Fork)
  
  消息Bus,让你更加方便的使用Handler.
  
  线程间消息传递，延迟操作等，在Android编程中也都是经常使用的功能，利用handler，我们可以实现上述功能，然而每一次使用，总是觉得不是那么方便，匿名内部类，内存泄漏也都是经常需要考虑的问题，这就为我们在使用Handler时，造成了困难。而MessageBus就是为了解决这个问题，让我们更加轻松的使用handler。
  
# How do I use MessageBus?

Simple use cases with MessageBus's generated API will look something like this:

Handle message:
```java
    MessageBus.getDefault().handleMessage(new IHandleMessage() {
            @Override
            public void handleMessage(Message msg) {
                Log.i(TAG,"线程信息："+ Thread.currentThread().getName());
                Log.i(TAG,"打印日志："+ msg.obj);

            }
        });

```
Message:
```java
        Message msg = MessageBus.getDefault().obtainMessage();
        msg.obj = "感悟生命的意思！";
        MessageBus.getDefault().sendMessage(msg);

        Message msg1 = MessageBus.getDefault().obtainMessage();
        msg1.obj = "感悟生命的意思，体验人生的美好，创造回忆，回忆人生。";
        MessageBus.getDefault().sendMessageDelayed(msg1,10000);

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

```
Runnable:
```java

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

```
more info,you can run the sample.


# License
```java
Copyright 2019 AwenZeng

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


