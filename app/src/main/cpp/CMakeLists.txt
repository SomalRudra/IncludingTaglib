# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.
add_library(
        # Sets the name of the library.
        native-lib
        # Sets the library as a shared library.
        SHARED
        # Provides a relative path to your source file(s).
        native-lib.cpp)
find_library(
        # Sets the name of the path variable.
        log-lib
        # Specifies the name of the NDK library that you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        native-lib
        ${log-lib})
#Adding taglib as a imported library
add_library(
        taglib
       SHARED
       IMPORTED )
#Defining proporties to include the library from the machine
set_target_properties(taglib PROPERTIES IMPORTED_LOCATION taglib/$(ANDROID_ABI)/libtaglib.dll )

#Linking taglib to the native library where I'll write all my codes and use the predefined functions,classes
target_link_libraries(native-lib ${taglib})
