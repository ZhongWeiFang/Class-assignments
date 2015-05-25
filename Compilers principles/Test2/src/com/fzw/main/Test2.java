package com.fzw.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.attribute.AclEntry.Builder;

public class Test2 {

	private static int state = 0;
	static boolean flag = true;

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		// StringBuilder build = new StringBuilder();
		String line = "";
		try {
			line = br.readLine();
			for (int i = 0; i < line.length() && flag; i++) {

				if (state == 0) {
					switch (line.charAt(i)) {
					case '0':
						state = 1;
						break;
					case '1':
						state = 2;
						break;
					default:
						flag = false;
						break;
					}
				} else if (state == 1) {
					switch (line.charAt(i)) {
					case '0':
						state = 4;
						break;

					case '1':
						state = 1;
						break;
					default:
						flag = false;
						break;
					}
				} else if (state == 2) {
					switch (line.charAt(i)) {
					case '0':
						state = 4;
						break;

					case '1':
						state = 2;
						break;
					default:
						flag = false;
						break;
					}
				} else if (state == 4) {
					switch (line.charAt(i)) {
					case '0':
					case '1':
						state = 4;
						break;

					default:
						flag = false;
						break;
					}
				}

			}

			if (state == 4 && flag) {
				System.out.println("合法");
			} else {
				System.out.println("不合法");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
