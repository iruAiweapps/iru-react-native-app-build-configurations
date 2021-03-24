package com.reactlibrary.appbuildconfigurations;

import android.util.Log;
import android.os.Build;
import android.os.Bundle;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class AppBuildConfigurationsModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private String buildType;
    private String flavor;

    public AppBuildConfigurationsModule(ReactApplicationContext reactContext, String buildType, String flavor) {
        super(reactContext);
        this.reactContext = reactContext;
        this.buildType = buildType;
        this.flavor = flavor;
    }

    @Override
    public String getName() {
        return "AppBuildConfigurations";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();

        constants.put("BuildType", flavor + buildType);
        constants.put("isSimulator", isEmulator());

        return constants;
    }

    @Override
    public boolean hasConstants() {
        return true;
    }

    public boolean isEmulator() {
        return Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || "google_sdk".equals(Build.PRODUCT);
    }
}
