# SpawnTeleport
A simple Spigot plugin to easily let players teleport to home and spawn.

## Commands
```Powershell
/home   Teleports player to their set spawnpoint
/spawn  Teleports player to spawn, can be configured.
```

## Config
To set the coordinates of the spawn, along with the world it is in, you have to make chagnes to the `config.yaml` file.

Example:
```yaml
spawn:
  x: 5000
  y: 105
  z: 5000
  world: world
```

## Building
```bash
cd SpawnTeleport
mvn clean package
```

