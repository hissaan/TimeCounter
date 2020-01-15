# TimeCounter
A simple timecounter/stopwatch that removes the complexity and limitations of standard android chronometer. 

# Introduction
A stop-watch at it's simplest definition is a textview that keeks on updating to reflect the elapsed time. TimeCounter allows you to show elapse time like a stopwatch.

# DOWNLOAD
Step 1. Add the JitPack repository to your root build.gradle at the end of repositories:

```
  allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2 : Add the dependency in your app level build.gradle
```
	dependencies {
	        implementation 'com.github.hissaan:TimeCounter:1.2'
	}
```
 
# USAGE:
 Step1. Create StopWatch instance by:
```java
 StopWatch stopwatch = new StopWatch(textView); // pass the textView you want to use as stop-watch, stop-watch you would update the textView to reflect elapsed time.
 
 // to start stopwatch
 stopwatch.start();
 
 // to pause stopwatch
 stopwatch.pause();
 
 //to resume stopwatch
 stopwatch.resume()
 
 // to stop stopwatch
 stopwatch.stop()
 
// To avoid losing stop-watch count, during activity rotations or un-expected activity dismissals
// save value of elapsed time during onSavedInstanceState(){} in a variable by calling 
int timeToSave = stopWatch.getTime();
// and put that into bundle 

// when restoring the activity , create a new stopwatch, set the time of stopwatch and call stopwatch.resume();
StopWatch stopwatch = new StopWatch(textView);
stopwatch.setTime(timeToSave);// obtain timeToSave from your bundle
stopwatch.resume();

// any improvements would be appreciated
```
