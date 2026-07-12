# PvP Utils [Development]

_Please refer to the README in the `main` branch for the full details about this mod_

## 🗒️ Indev Work Details
*For older versions' features, go to the release notes for that version*

**Planned next version:** 0.3.0

### ✨ Features
Working on a new part of the mod
The item counter will receive updates to customization later on.

### 🪲 Bugfixes
`None`

---

### 🧩 Dependencies

- [Mod Menu](https://modrinth.com/mod/modmenu)
- [YetAnotherConfigLib (YACL)](https://modrinth.com/mod/yacl)
- [Fabric API](https://modrinth.com/mod/fabric-api)

>[!CAUTION]
This mod is only compatible with Minecraft: Java Edition **1.21.11** and Fabric Loader for **1.21.11**
It has not been tested with and will most likely not work with any other versions

---

## 🛠️ Building from sources

PvP Utils uses the [Gradle build tool](https://gradle.org/) and can be built with the `gradle build` command. The build
artifacts (production binaries and their source bundles) can be found in the `build/mods` directory.

The [Gradle wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html#sec:using_wrapper) is provided for ease of use and will automatically download and install the
appropriate version of Gradle for the project build. To use the Gradle wrapper, substitute `gradle` in build commands
with `./gradlew.bat` (Windows) or `./gradlew` (macOS and Linux).

### 📦 Build Requirements

- OpenJDK 21
    - I recommend using the [Eclipse Temurin](https://adoptium.net/) distribution as it's known
      to be of high quality and is widely used in the development community.
- Gradle 8.10.x
    - Typically, newer versions of Gradle will work without issues, but the build script is only tested against the
      version used by the [wrapper script](/gradle/wrapper/gradle-wrapper.properties).

---

## ℹ️ Other Information

### 📝 Credits

This mod was made using the **Fabric Mod Template** at https://fabricmc.net/develop/template/  

The example mod can also be found on GitHub at https://github.com/FabricMC/fabric-example-mod/

### 🔀 Branch information

This branch contains code that is in development (indev) and is most likely incomplete. Use this code with caution <br>
For the latest version's code, go to the `main` branch.
For older versions', go to that version's branch (like `1.21.11`). <br>

>[!WARNING]
>The indev features of this mod may have **errors, bugs and bugfixes** that may not work
>The features may also be **incomplete**
