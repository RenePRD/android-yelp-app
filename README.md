# android-yelp-app

An Android application built using Java that allows users to search for and browse restaurants using the **Yelp API**. The app displays a list of restaurants with support for navigation, custom list adapters, and fragment management.

---

## Technologies Used

- **Language**: Java
- **Framework**: Android SDK
- **API**: Yelp Fusion API
- **Architecture**: Activity + Fragment based navigation
- **IDE**: Android Studio / IntelliJ IDEA
- **Build Tool**: Gradle

---

## Features

- Search and display restaurants from the Yelp API
- Custom `RecyclerView` with images and text
- Uses Fragments to manage different views
- Loads content dynamically via HTTP requests
- Clean UI layout using XML and `ConstraintLayout`

---

## Project Structure
```
MyYelp/                          # Android Studio project root

├── app/
│   ├── build.gradle             # App module's Gradle config
│   ├── proguard-rules.pro
│   └── src/
│       ├── androidTest/
│       │   └── java/com/hfad/myyelp/
│       │       └── ExampleInstrumentedTest.java

│       ├── main/
│       │   ├── AndroidManifest.xml
│       │   ├── java/com/hfad/myyelp/
│       │   │   ├── MainActivity.java            # Launch activity
│       │   │   ├── ListFragment.java            # Displays Yelp restaurant list
│       │   │   ├── RestaurantListAdapter.java   # RecyclerView adapter
│       │   │   ├── YelpAPI.java                 # API request helper or config
│       │   │   ├── YelpClient.java              # Makes network requests
│       │   │   └── YelpResponse.java            # Data model for API responses
│       │   └── res/
│       │       ├── layout/
│       │       │   ├── activity_main.xml
│       │       │   ├── fragment_list.xml
│       │       │   ├── list_item.xml
│       │       │   └── header_layout.xml
│       │       ├── drawable/
│       │       ├── drawable-v24/
│       │       ├── menu/
│       │       │   └── drawer_menus.xml
│       │       ├── mipmap-anydpi-v26/
│       │       ├── mipmap-hdpi/
│       │       ├── mipmap-mdpi/
│       │       ├── mipmap-xhdpi/
│       │       ├── mipmap-xxhdpi/
│       │       └── mipmap-xxxhdpi/

├── build.gradle                 # Project-level Gradle config
├── gradle.properties
├── settings.gradle
├── gradlew
├── gradlew.bat
```

---

## How to Run

1. Clone the repo and open it in **Android Studio**
2. Add your **Yelp API Key** to the appropriate place in `YelpClient.java`
3. Build and run the app on an emulator or Android device

---

## Testing

Unit and integration tests can be added in the `androidTest` or `test` directories using JUnit or Espresso for UI testing.

---






