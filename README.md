# compose_keyboard_adjustresize

## Description
This is a sample project to show an issue with adjustResize and the keyboard in Jetpack Compose 1.5.
The issue didn't happen prior to Jetpack Compose 1.5.

## Steps to reproduce
1. Run the app on the Nexus 5 emulator (Android 6 arm64-v8a)
2. Click on the "Click me!" button
3. The app navigates to the second screen and it becomes blank. The screen should show some text.

The issue also reproduces on the physical Pixel 4a with Android 13.

The issue to be related to the keyboard and screen sliding animations.
Workarounds are:
1. Not calling clearFocus on the first screen.
2. Adjusting NAVIGATION_ANIMATION_TIME to 500 in MyNavHost.kt
