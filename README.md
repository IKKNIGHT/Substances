# Template Plugin for Spigot and CraftBukkit Servers

## Version: 1.20.X

### Description:
This is a template plugin feel free to use this however you like. This plugin allows for easy customization of plugin message prefixes by modifying a config file. Additionally, it provides commands for reloading the plugin configuration and responding to custom commands.

### Features:
- **Prefix Customization**: Change the prefix of all plugin messages to customize the server's communication style.
- **Config Reload Command**: Reload the plugin's configuration without restarting the server.
- **TellMe Command**: Respond to custom commands from players with specific messages.

### Usage:
1. **Configuring Plugin Message Prefix**:
   - Open the `config.yml` file located in the plugin's source code.
   - Modify the `prefix` value to customize the prefix of all plugin messages.

2. **Reloading Plugin Configuration**:
   - Use the `/reloadtp` command to reload the plugin's configuration.

3. **Using Custom Command**:
   - Utilize the `/tellme <message>` command to have the server respond with a specific message.

### Example Configuration (PluginName / config.yml):
```yaml
prefix: "&a[Server]&r " #< keep the space
```
### Issues
Having an error or question? go to the issues page and create an issue [here](https://github.com/IKKNIGHT/TemplatePluginSpigot/issues)
