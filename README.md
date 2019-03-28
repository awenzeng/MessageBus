# MessageBus
[![JitPack](https://jitpack.io/v/awenzeng/MessageBus.svg)](https://jitpack.io/#awenzeng/MessageBus)
  MessageBus,easier for you to use Handler.(Welcome to Star and Fork)
  
  消息Bus,让你更加方便的使用Handler.
  
  在Android编程中，经常会遇到线程间消息传递，延迟操作，子线程与主线程切换等问题，利用handler，我们可以实现上述功能。然而在每一次使用中，总要考虑很多问题如：匿名内部类，内存泄漏等。为了解决这个问题，MessageBus来了，为了让我们更加方便的使用Handler而来.
  
# Download
You can download the latest version from GitHub's [releases page](https://github.com/awenzeng/MessageBus/releases).

Or use Gradle.
```java
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  ```java
  	dependencies {
	         implementation 'com.github.awenzeng:MessageBus:v1.0'
	}

```
Or Maven:
```java
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
  ```
  ```java
  <dependency>
	    <groupId>com.github.awenzeng</groupId>
	    <artifactId>MessageBus</artifactId>
	    <version>v1.0</version>
	</dependency>
```
For info on using the bleeding edge, see the [Snapshots](https://jitpack.io/#awenzeng/MessageBus/v1.0) wiki page.
  
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


