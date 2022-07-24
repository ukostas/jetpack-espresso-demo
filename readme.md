# Problem
Jetpack compose layouts do not (yet) have resource-ids.
You do not want to use xpath etc. location strategies.
So uiautomator2 can not handle this yet:
```json
{
  "platformName": "android",
  "appium:automationName": "uiautomator2",
  "appium:app": "https://github.com/ukostas/jetpack-espresso-demo/releases/download/v0.0.1/app-debug.apk",
  "appium:fullReset": true
}
```
# Solution 1
Jetpack compose layouts can set `testTag` (visible to appium via `-android viewtag` location strategy).
Use espresso driver and switch it to new "compose mode".
Espresso driver can not be built with current stable appium@1.22.3, but can be built built with appium@beta.
```json
{
  "platformName": "android",
  "appium:automationName": "espresso",
  "appium:forceEspressoRebuild": true,
  "appium:showGradleLog": true,
  "appium:espressoBuildConfig": "{   \"toolsVersions\": {     \"compileSdk\": \"32\",     \"kotlin\": \"1.6.10\"   },   \"additionalAppDependencies\": [     \"androidx.compose.ui:ui-tooling:1.1.1\"   ] }",
  "appium:app": "https://github.com/ukostas/jetpack-espresso-demo/releases/download/v0.0.1/app-debug.apk",
  "appium:settings[driver]": "compose",
  "appium:fullReset": true
}
```