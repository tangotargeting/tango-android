package com.tangotargeting.sample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @since 3/31/17.
 */

public class CustomActionReceiver extends BroadcastReceiver {
  private static final String KEY_CTA = "com.tangotargeting.intent.extra.CTA";

  @Override public void onReceive(Context context, Intent intent) {
    String action = intent.getStringExtra(KEY_CTA);
    if (action != null) {
      //DO What you need
      Toast.makeText(context, "Action received: " + action, Toast.LENGTH_LONG).show();
    }
  }
}
