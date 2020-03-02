package com.reactlibrary.appbuildconfigurations;

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

        constants.put("BuildType", flavor + '.' + buildType);

        return constants;
    }

    @Override
    public boolean hasConstants() {
        return true;
    }
}
