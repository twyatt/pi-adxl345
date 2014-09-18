![Breakout Board](breakout.jpg)

# Screenshot
![Screenshot](screenshot.png)

# Instructions
## Schematic
![Schematic](schematic.jpg)

## Wiring
![Wiring](wiring.jpg)

## Computer
* Compile project
  * OS X/Linux: `$ ./gradlew distZip`
  * Windows `gradlew.bat distZip`
* ZIP file will be located in build/distributions
* Copy pi-adxl345.zip to your Raspberry Pi

## Raspberry Pi
```bash
$ unzip pi-adxl345.zip
$ cd pi-adxl345
$ sudo bin/pi-adxl345
```
