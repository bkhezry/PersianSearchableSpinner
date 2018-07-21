# PersianSearchableSpinner
[![](https://jitpack.io/v/bkhezry/PersianSearchableSpinner.svg)](https://jitpack.io/#bkhezry/PersianSearchableSpinner)

Custom Spinner element with searchable.

**Project Setup and Dependencies**
- JDK 8
- Android SDK Build tools 27.0.3
- Supports API Level +17
- AppCompat & Design libraries 27.1.1

## A quick overview
- compatible with **API Level +17**
- **RTL** support
- **Custom Font** support

# Preview
## Demo APK
You can download the latest demo APK from here: https://github.com/bkhezry/PersianSearchableSpinner/blob/master/assets/PersianSearchableSpinner.apk

## Demo
<img src="assets/demo.gif" width="300px" />

# Setup
## 1. Provide the gradle dependency
Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```
Add the dependency:
```gradle
dependencies {
implementation 'com.github.bkhezry:PersianSearchableSpinner:1.4.2'
}
```
Using the Spinner
--------------------------------
```xml
<com.github.bkhezry.searchablespinner.SearchableSpinner
        android:id="@+id/searchable_spinner1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="24dp"
        android:layout_marginLeft="24dp"
        android:layout_marginRight="24dp"
        android:layout_marginStart="24dp"
        android:layout_marginTop="24dp"
        android:gravity="center_horizontal"
        app:boarder_color="@android:color/holo_blue_light"
        app:borders_size="1dp"
        app:done_search_tint_color="@android:color/white"
        app:font_name="DroidNaskh-Regular.ttf"
        app:reveal_empty_text="انتخاب کنید"
        app:reveal_view_background_color="@android:color/holo_blue_light"
        app:search_view_background_color="@android:color/holo_blue_light"
        app:show_borders="false"
        app:spinner_expand_height="0dp"
        app:start_search_tint_color="@android:color/white" />
```
create custom Adapter with data and set it to the searchable spinner:
```java
	searchableSpinner.setAdapter(mStringListAdapter);
```
## Public attrs

| Name | Description |
|:----:|:----:|
|reveal_view_background_color| background color of reveal view|
|start_search_tint_color| color of first text showing in Spinner|
|search_view_background_color| background color of search view|
|search_view_text_color| color of search view text|
|done_search_tint_color| color of search icon|
|anim_duration| duration of animation|
|show_borders| show border of search box
|borders_size| size of border|
|boarder_color| color of boarder|
|spinner_expand_height| height of spinner in expand mode|
|keep_last_search| keep last search value in edit text|
|reveal_empty_text| text of spinner in first showing|
|search_hint_text| hint of edit text in search mode|
|no_items_found_text| when searching did not fount item, this text will be showing|
|items_divider| divider of items|
|divider_height| height of divider items|
|font_name| name of font that placed in assets/fonts folder|

## More info 
[demo codes](https://github.com/bkhezry/PersianSearchableSpinner/tree/master/app/src/main/java/com/github/bkhezry/persiansearchablespinnerdemo)

# Credits

- searchablespinner- [GitHub](https://github.com/michaelprimez/searchablespinner)

# Developed By

* Behrouz Khezry
 * [@bkhezry](https://twitter.com/bkhezry) 


# License

    Copyright 2018 Behrouz Khezry

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
