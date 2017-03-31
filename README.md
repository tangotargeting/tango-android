# Tango targeting

Mobile Engagement Automation

For more information please see [the website][1].


## Installation

Tango Targeting SDK requires at minimum Android 4.0.1.

**1. Add maven repository to your root** ```build.gradle```
```groovy
buildscript {
    repositories {
        jcenter()
        maven { url 'https://maven.tangotargeting.com/repository/maven-public' }
    }
}

allprojects {
    repositories {
        jcenter()
        maven { url 'https://maven.tangotargeting.com/repository/maven-public' }
    }
}
```

**2. Downdload via Gradle:**
``` groovy
compile ('com.tangotargeting:tango:1.0.4') {
	transitive = true;
}
```

**3. Add the following lines to your** ``` AndroidManifest.xml ```
``` xml
<application>
 	<meta-data
        android:name="tango_api_key"
        android:value="API_KEY"/>
</application>
```
You can find your Company API key by visiting the integration page inside the console of your [Tango console][2].

**3. Add Firebase (FCM) to your project**

Tango uses FCM to send real-time campaigns to devices. You have to add FCM to your project by following the instructions [here][3].

Add **Server key** and **Sender Id** to our console after integration.

**4. Our SDK relies on the following permissions.**

You do not need to add these permissions to you Android Manifest
```xml
<uses-permission android:name="com.android.browser.permission.READ_HISTORY_BOOKMARKS"/>
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED”/>
```
However if your ``` targetSdkVersion>22 ``` you will need to request runtime permissions for Location permission when you think is most suitable for the user.


### You are ready to go with the basics!

**5. Add a BroadcastReceiver for custom call to actions**

```xml
    <receiver android:name=".CustomActionReceiver">
      <intent-filter>
        <action android:name="com.tangotargeting.intent.action.CUSTOM_CTA"/>
      </intent-filter>
    </receiver>
```
and
```groovy
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

## Advanced - Snapshot releases

If you want to use the latest development snapshot:

**1. Add snapshot repository to your root build.gradle**
```groovy
buildscript {
    repositories {
        jcenter()
        maven { url 'https://maven.tangotargeting.com/repository/maven-public' }
        maven { url 'https://maven.tangotargeting.com/repository/maven-snapshots' }
    }
}

allprojects {
    repositories {
        jcenter()
        maven { url 'https://maven.tangotargeting.com/repository/maven-public' }
        maven { url 'https://maven.tangotargeting.com/repository/maven-snapshots' }
    }
}
```

**2. Add snapshot dependency to your module build.gradle**
```groovy
  compile ('com.tangotargeting:tango:1.1.6-SNAPSHOT'){
    transitive = true;
  }
```

## Troubleshooting

1. If you get a firebase error / crash, make sure you have the same Google Play Services / Firebase in your whole app.

## License

    Copyright 2016-2017 Tango Targeting, Inc.


 [1]: http://tangotargeting.com
 [2]: https://app.tangotargeting.com/integration/android
 [3]: https://firebase.google.com/docs/android/setup