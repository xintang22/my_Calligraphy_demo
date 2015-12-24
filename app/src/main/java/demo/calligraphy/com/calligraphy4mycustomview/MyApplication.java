package demo.calligraphy.com.calligraphy4mycustomview;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by R9 on 2015/12/24
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath(null)
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }
}
