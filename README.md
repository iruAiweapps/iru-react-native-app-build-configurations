# iru-react-native-app-build-configurations

## Getting started

`$ npm install iru-react-native-app-build-configurations --save`

### Mostly automatic installation

#### RN 60.X

`$ cd ios && pod install && && cd ..`

Other dependencies will be linked automatically.

#### RN <= 59.9

`$ react-native link iru-react-native-app-build-configurations`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `iru-react-native-app-build-configurations` and add `AppBuildConfigurations.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libAppBuildConfigurations.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.reactlibrary.AppBuildConfigurationsPackage;` to the imports at the top of the file
  - Add `new AppBuildConfigurationsPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':iru-react-native-app-build-configurations'
  	project(':iru-react-native-app-build-configurations').projectDir = new File(rootProject.projectDir, 	'../node_modules/iru-react-native-app-build-configurations/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':iru-react-native-app-build-configurations')
  	```


## Usage

### React native

```javascript
import AppConfiguration from 'iru-react-native-app-build-configurations';

// This module gets a BuildType string from the project's build configuration.
// BuildType format is '{configuration_type}.{configuration_name}', where
// configuration_type: dev|prod - switch API server
// configuration_name: debug|adhoc|release

const { BuildType } = AppConfiguration;

const devKey = 'dev';
const prodKey = 'prod';

const debugConfigurationKey = 'debug';
const adhocConfigurationKey = 'adhoc';
const releaseConfigurationKey = 'release';

const DEV = BuildType.includes(devKey);
const PROD = BuildType.includes(prodKey);

const DEBUG = BuildType.includes(debugConfigurationKey);
const ADHOC = BuildType.includes(adhocConfigurationKey);
const RELEASE = BuildType.includes(releaseConfigurationKey);

export {
    DEV,
    PROD,
    DEBUG,
    ADHOC,
    RELEASE,
};
```

### Android configuration

Need to create buildTypes and productFlavors. They are automatically will be send to react native app part.

For example:

```text
buildTypes {
        debug { }
        adhoc { }
        release { }
    }
    flavorDimensions "default"
    productFlavors {
        prod { }
        dev { }
    }
```

### Ios configuration

Need to add "ConfigurationName" property in info.plist file with String value in format {configuration_type}{configuration_name}. For setup this string need to create custom property in project and setup it value for any build configuration, in .plist file it can be used by "$(CONFIGURATION_NAME)".

For example:

```xml
<plist version="1.0">
    <dict>
        ...
        <key>ConfigurationName</key>
        <string>$(CONFIGURATION_NAME)</string>
        ...
    </dict>
</plist>
```
