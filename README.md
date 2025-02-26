# Substance Plugin for Spigot/CraftBukkit Servers.

## Version: 1.20.6+

### Description:
This is a substance plugin. It adds various substances to the game, as of right now it only adds a "powder"

### Features:
- **Prefix Customization**: Change the prefix of all plugin messages to customize the server's communication style.
- **Config Reload Command**: Reload the plugin's configuration without restarting the server.
- **Powder Command**: gives "powder" to a player
- **Crafting Recipe**: ![image](https://github.com/user-attachments/assets/52cd7ba6-0cf4-4b98-8b4d-0ccbcf716b82)


### Usage:
1. **Configuring Plugin Message Prefix**:
   - Open the `config.yml` file located in the plugin's source code.
   - Modify the `prefix` value to customize the prefix of all plugin messages.

2. **Reloading Plugin Configuration**:
   - Use the `/reloadsubstance` command to reload the plugin's configuration.

3. **Give-Powder Command**:
   - Utilize the `/givepowder <player>` to give the specified player "powder" if not specified gives the command sender the "powder" (op)

### Example Configuration (PluginName / config.yml):
```yaml
prefix: "&a[Server]&r " #< keep the space
```
### Issues
Having an error or question? go to the issues page and create an issue [here](https://github.com/IKKNIGHT/Substances/issues)
