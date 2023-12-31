# ChestCrafter Basics

This is a simple plugin to spawn in chests anytime, anywhere.

You can find chest ids in the GM Handbook, look for SceneObj_Chest.

Fair Warning!! Many chests do not have proper handlers and won't open! Please feel free to experiment, but know that any chests that don't open are not an issue with the plugin!

Any chests without a handler can be added by you to the reward file, and then it will open with your own custom rewards you have set. Refer to [Custom Chest Rewards](https://github.com/NotThorny/ChestCrafter#custom-chest-rewards) further down this README for more information.

![20231130153855](https://github.com/NotThorny/ChestCrafter/assets/107363768/41afc6a4-a129-42af-b3d4-54f1fbafb953)

## Installation

Get latest release from [releases](https://github.com/NotThorny/ChestCrafter/releases)

Place ChestCrafter.jar into your `\grasscutter\plugins` folder and restart the server if it was already running

## Usage

All chests will spawn where you stand and in the direction you are facing.

`/ch rare`

- Spawns a rare chest

`/ch gift`

- Spawns a nice gift (luxurious)

`/ch <chest id>`

- Spawns the given chest id

## Custom Chest Rewards

You can add custom chest rewards for any chest, including ones that currently don't open (they should open after!) by editing your `ChestReward.json` in `\Grasscutter\data\`.

There will already by content in there you can use as reference for adding new chests. The basics are that any given chest uses it's object name (ie. SceneObj_Chest_Default_Lv1) and then what is contained inside it is split into a few categories such as advExp, mora, and content which is any drop items it contains.

## Version

Made for old Grasscutter versions but should work on any beyond 1.6.x

## Issues

None yet.

## Background

This is a plugin I made a long time ago for proof-of-concept. There may be some issues with it, and it currently doesn't do actual custom chest content, only spawning in chests from the game anywhere you want.
Due to the nature of many chests not having drop data, or being locked (no way to open locked ones when spawning like this), this plugin just sat in my folders for a long time. Since there has been more interest lately and people asking for the plugin, I'm providing it now open source so maybe it can be improved or maybe help inspire better custom chest content.
