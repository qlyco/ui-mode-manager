# UIModeManager

UIModeManager is an Android plugin for Godot Engine 3.5.1. The plugin can query the current state of
an Android device's UI mode, allowing you to change your app's UI into dark or light mode version.

![Banner](#)

[![Android](https://img.shields.io/badge/Platform-Android-brightgreen.svg)](https://developer.android.com)
[![Godot](https://img.shields.io/badge/Godot%20Engine-3.5.1-blue.svg)](https://github.com/godotengine/godot/)
[![MIT license](https://img.shields.io/badge/License-MIT-yellowgreen.svg)](https://lbesson.mit-license.org/)

## Getting Started

### Setup

1. Download the ```UIMode.gdap``` and ```UIMode.release.aar``` files from the releases page
2. Go into your Godot project and install the Android build template (```Project > Install Android Build Template...```)
3. Move both ```UIMode.gdap``` and ```UIMode.release.aar``` files into the ```android/plugins``` directory inside your project
4. Enable the plugin inside the export menu (```Project > Export...``), on the Plugins section. You may need to add an export template for Android

### Compiling from source

If there is no plugin releases for the Godot version being used, you need to compile the ```.aar``` file for the plugin yourself.
Follow the instructions on [Creating Android plugins](https://docs.godotengine.org/en/stable/tutorials/platform/android/android_plugin.html) from the Godot Docs.
  
Detailed instructions:
1. Clone the project and open the project in [Android Studio](https://developer.android.com/studio)
2. Download the [AAR Library for Android Plugins](https://godotengine.org/download/windows) for your chosen Godot version
3. Move the downloaded ```.aar``` file into ```app/libs``` folder
4. Add the ```.aar``` file as a dependency for the project and remove the dependency on the previous ```.aar``` file
5. Select the ```release``` build variant
6. Build the project (```Build > Make Project```)
7. The newly generated ```.aar``` file for the plugin will be available in the build folder (```app/build/outputs/aar/UIMode.release.aar```)

## Usage

The plugin can be accessed as a Singleton from the ```Engine``` class:

```
var uiModeManager

if Engine.has_singleton("UIModeManager"):
    uiModeManager = Engine.get_singleton("UIModeManager")
```

In order to check the current UI mode of an Android device, use the following code:

```
# To avoid any issues, check if the app is running on an Android device before executing this line of code 
var UI_MODE_FLAG = uiModeManager.get_mode()
```

The method ```Manager.get_mode()``` will return a ```String``` representing the current UI mode of the Android device.
The available flags are:

- ```DARK_MODE```: The device is currently in dark mode
- ```LIGHT_MODE```: The device is currently in light mode
- ```UNDEFINED_MODE```: No UI mode is currently set
- ```UNKNOWN_MODE_ERROR```: Error encountered

You can then use the flags in order to change the UI of the app inside Godot, such as changing the theme used for the ```Control``` nodes.