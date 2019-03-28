# MessageBus
消息Bus,更加方便的使用Handler(Welcome to Star and Fork)

# Download
You can download the latest version from GitHub's [releases page](https://github.com/awenzeng/camera/releases).

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
	        compile 'com.github.awenzeng:camera:1.0.1'
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
	    <artifactId>camera</artifactId>
	    <version>1.0.1</version>
	</dependency>
```
For info on using the bleeding edge, see the [Snapshots](https://jitpack.io/#awenzeng/camera) wiki page.

# How do I use MessageBus?

Simple use cases with MessageBus's generated API will look something like this:

In your Activity:
```java
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

```


# License
```java
Copyright 2017 AwenZeng

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


