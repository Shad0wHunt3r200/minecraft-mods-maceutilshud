# Mace Utils HUD 
The code and notes for Mace Utils HUD.

>[!IMPORTANT]
>This branch is for **version 1.21.11 of Minecraft**

---

## 🏷️ Versions

### v0.1.0
**Type:** Normal

#### Features:
 - Windcharge, Pearl, Elytra durability counters with icons
 - Fixed HUD position
 - Toggle mod
 - Adjust counter text color

### v0.1.1
**Type:** Bug fix

**Bug:** 
`loader_version` specified in gradle.properties and fabric.mod.json is inaccurate (Minecraft `1.21.11` requires Fabric Loader `18.1` and above; Mod specified `19.2`)

**Fix:** 
Changed version value to `18.5`

>[!NOTE]
>Did not change to 18.1 due to bug fixes in 18.5
