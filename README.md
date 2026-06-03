# Mace Utils HUD

## 📓 Mod Info

This is a mod made for the Mace PvP gamemode in Minecraft. It is meant to give useful information to assist in the intensive gameplay of this gamemode. **This mod does not provide any unfair advantage during gameplay.**

While this mod is mainly developed for Mace PvP, it can also be utilised in other gamemodes like Vanilla (Crystal) PvP. 

---

### ✨ Features
*For older versions' features, go to the release notes for that version*

**Latest Version:** v0.2.0

>[!WARNING]
>This section is incomplete

### 🧩 Dependencies

- [Mod Menu](https://modrinth.com/mod/modmenu)
- [YetAnotherConfigLib (YACL)](https://modrinth.com/mod/yacl)
- [Fabric API](https://modrinth.com/mod/fabric-api)

>[!CAUTION]
This mod is only compatible with Minecraft: Java Edition **1.21.11** and Fabric Loader for **1.21.11**
It has not been tested with and will most likely not work with any other versions

### 📥 Downloads

Latest releases can be found in this repository under Releases

![Total Downloads](https://img.shields.io/github/downloads/Shad0wHunt3r200/minecraft-mods-maceutilshud/total.svg?style=for-the-badge&label=Total%20Downloads&labelColor=25292e&color=8a2be2&cacheSeconds=300)
![Latest Release Downloads](https://img.shields.io/github/downloads/Shad0wHunt3r200/minecraft-mods-maceutilshud/latest/total.svg?style=for-the-badge&label=Latest%20Release%20Downloads&labelColor=25292e&color=44cc11&cacheSeconds=300)

You can also find the download count for each release [here](https://tooomm.github.io/github-release-stats/?username=Shad0wHunt3r200&repository=minecraft-mods-maceutilshud)

>[!NOTE]
>**Version Format**<br>
>major.minor.patch

---

## 🛠️ Building from sources

Mace Utils uses the [Gradle build tool](https://gradle.org/) and can be built with the `gradle build` command. The build
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

This branch is the latest stable release across all versions. <br>
For the latest release for older versions, go to that version's branch (like 1.21.11). <br>

*For the latest/indev releases, go to the development branch.*
>[!WARNING]
>The indev features of this mod may have **errors, bugs and bugfixes** that may not work
>The features may also be **incomplete**
