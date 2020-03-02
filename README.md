# iru-react-native-app-build-configurations

## Getting started

`$ npm install iru-react-native-app-build-configurations --save`

### Mostly automatic installation

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
```javascript
import AppBuildConfigurations from 'iru-react-native-app-build-configurations';

// TODO: What to do with the module?
AppBuildConfigurations;
```
