package com.ofppt.myuiautomator;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;


import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MyPhoneTest {

    private static final long TIMEOUT = 3000;

    @Test
    public void openGoogle() throws Exception {


        UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
      if(mDevice.isScreenOn())
         {
             mDevice.setOrientationLeft();

             mDevice.openNotification();
             mDevice.openQuickSettings();
             mDevice.pressBack();
             mDevice.pressHome();
         }
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.android.chrome");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setData(Uri.parse("https://www.google.com/"));
        context.startActivity(intent);
        mDevice.wait(Until.hasObject(By.pkg("com.android.chrome").depth(0)), TIMEOUT);
        Thread.sleep(4000);

        mDevice.pressRecentApps();
        mDevice.pressBack();


    }
}
