package com.traviswyatt.pi.adxl345;

import java.io.IOException;

import com.pi4j.io.i2c.I2CBus;

public class Main {

	public static void main(String[] args) throws IOException {
		// http://developer-blog.net/wp-content/uploads/2013/09/raspberry-pi-rev2-gpio-pinout.jpg
		// http://pi4j.com/example/control.html
		ADXL345 adxl345 = new ADXL345(I2CBus.BUS_1);
		
		adxl345.setup();
		if (!adxl345.verifyDeviceID()) {
			throw new IOException("Failed to verify ADXL345 device ID");
		}
		
		adxl345.writeRange(ADXL345.ADXL345_RANGE_16G);
		adxl345.writeFullResolution(true);
		adxl345.writeRate(ADXL345.ADXL345_RATE_400);
		float scalingFactor = adxl345.getScalingFactor();
		
		short[] raw = new short[3];
		float[] a = new float[3];
		
		while (true) {
			adxl345.readRawAcceleration(raw);
			for (int i = 0; i < raw.length; i++) {
				a[i] = (float) raw[i] * scalingFactor * 9.8f;
			}
			System.out.println("x=" + a[0] + ",\ty=" + a[1] + ",\tz=" + a[2] + "\tm/s^2");
		}
	}

}
