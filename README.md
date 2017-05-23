# Tango targeting

Mobile Engagement Automation

For more information please visit [Tango Targeting][1].


## Installation

Tango Targeting SDK requires at minimum Android 4.0.1.

### 1. Add maven repository to your root ```build.gradle```
```groovy
buildscript {
    repositories {
        ...
        maven { url 'https://maven.tangotargeting.com/repository/maven-public' }
        ...
    }
}

allprojects {
    repositories {
        ...
        maven { url 'https://maven.tangotargeting.com/repository/maven-public' }
        ...
    }
}
```

### 2. Downdload via Gradle:

In your app's ``build.gradle`` file add the following dependency.

``` groovy
compile ('com.tangotargeting:tango:2.0.0') {
	transitive = true;
}
```

### 3. In `AndroidManifest.xml`, add the `meta-data` containing your Tango API key:
``` xml
<application>
    ...
 	<meta-data
        android:name="tango_api_key"
        android:value="<YOUR_TANGO_API_KEY>"/>
    ...
</application>
```
<span class="tango_hide">
You can find your Company API key by visiting the integration page inside the console of your [Tango console][2].
</span>

### 3. Add Firebase (FCM) to your project

Tango uses FCM to send real-time campaigns to devices. You have to add FCM to your project by following the instructions [here][3].

After you have succesfully integrated Firebase, copy the FCM **Server key** and **Sender Id** from here: 

![FCM Server Key and Sender Id location](https://github.com/tangotargeting/tango-documentation/blob/master/fcm-server-key-location.png?raw=true)

Then go to Tango Console and add them to your app.

![Tango Server Key and Sender Id location](https://github.com/tangotargeting/tango-documentation/blob/master/tango-server-key-location.png?raw=true)

Hit the **Update** button.

### 4. Permissions

Tango SDK relies on the following permissions:

```xml
<uses-permission android:name="com.android.browser.permission.READ_HISTORY_BOOKMARKS"/>
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED"/>
```

You do not need to add these permissions to your Android Manifest file. However, if your ` targetSdkVersion` is higher than **22** you will need to request the `android.permission.ACCESS_FINE_LOCATION` permission at runtime, whenever you think is most suitable for the user. [Here][4] is how to request a persmission at runtime.

## You are ready to go!

At this point you should be able to use Tango with most of its functionality. The following step is for enabling handling custom triggered campaigns actions.

### 5. Handle custom campaign actions 

Create a BroadcastReceiver that will intercept the actions:

```Java
public class CustomActionReceiver extends BroadcastReceiver {
  private static final String KEY_CTA = "com.tangotargeting.intent.extra.CTA";

  @Override public void onReceive(Context context, Intent intent) {
    String action = intent.getStringExtra(KEY_CTA);
    if (action != null) {
      //DO What you nee
    }
  }
}
```
and declare it in the `AndroidManifest.xml` file:
```xml
	<application>
    	...
        <receiver android:name=".CustomActionReceiver">
          <intent-filter>
            <action android:name="com.tangotargeting.intent.action.CUSTOM_CTA"/>
          </intent-filter>
        </receiver>
    	...
    </application>
```

## Troubleshooting

1. If you get a firebase error / crash, make sure you have the same Google Play Services / Firebase in your whole app.

## License

    Copyright 2016-2017 Tango Targeting, Inc.


 [1]: http://tangotargeting.com
 [2]: https://app.tangotargeting.com/integration/android
 [3]: https://firebase.google.com/docs/android/setup
 [4]: https://developer.android.com/training/permissions/requesting.html#perm-check
