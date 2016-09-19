package com.fzw.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity {

	public static void main(String[] args) {
		String temp = null;
		StringBuilder build = new StringBuilder();
		StringBuilder biaoshi = new StringBuilder();
		StringBuilder changshu = new StringBuilder();
		FileReader fr = null;
		int start = 0;
		int end = 0;
		int j = 0;
		String sub = null;
		try {
			fr = new FileReader(new File("e:\\", "test.txt"));
			BufferedReader br = new BufferedReader(fr);
			while ((temp = br.readLine()) != null) {
				build.append(" " + temp);
			}

			String str = build.toString();
			System.out.println(str);

			for (start = 0; start < str.length();) {

				if (isNum(str.charAt(start)) || isabc(str.charAt(start))
						|| isABC(str.charAt(start))) {
					end = start + 1;
					for (; end <= str.length(); ++end) {
						if (!isNum(str.charAt(end)) && !isabc(str.charAt(end))
								&& !isABC(str.charAt(end))) {
							break;

						}
					}
					sub = (String) str.subSequence(start, end);
					if (containsAora(sub) && !biaoshi.toString().contains(sub)) {
						biaoshi.append(" " + sub);
					}else if(!containsAora(sub) && !changshu.toString().contains(sub)){
						changshu.append(" " + sub);
					}
					//System.out.println(sub);
					start = end + 1;
				} else {
					++start;
				}
			}

			System.out.println("标识符: " + biaoshi.toString());
			System.out.println("常熟: " + changshu.toString());
			
		} catch (FileNotFoundException e1) {
			System.out.println("找不到文件");
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static boolean isNum(int asc) {
		if (asc >= 48 && asc <= 57 || asc == 46) {
			return true;
		}
		return false;
	}

	private static boolean isabc(int asc) {
		if (asc >= 97 && asc <= 122 || asc == 95) {
			return true;
		}
		return false;
	}

	private static boolean isABC(int asc) {
		if (asc >= 65 && asc <= 90 || asc == 95) {
			return true;
		}
		return false;
	}

private static boolean containsAora(String sub) {
		if (sub.contains("a") || sub.contains("b") || sub.contains("c")
				|| sub.contains("d") || sub.contains("e") || sub.contains("f")
				|| sub.contains("g") || sub.contains("h") || sub.contains("i")
				|| sub.contains("j") || sub.contains("k") || sub.contains("l")
				|| sub.contains("m") || sub.contains("n") || sub.contains("o")
				|| sub.contains("p") || sub.contains("q") || sub.contains("r")
				|| sub.contains("s") || sub.contains("t") || sub.contains("u")
				|| sub.contains("v") || sub.contains("w") || sub.contains("x")
				|| sub.contains("y") || sub.contains("z") || sub.contains("A")
				|| sub.contains("B") || sub.contains("C") || sub.contains("D")
				|| sub.contains("E") || sub.contains("F") || sub.contains("G")
				|| sub.contains("H") || sub.contains("I") || sub.contains("J")
				|| sub.contains("K") || sub.contains("L") || sub.contains("M")
				|| sub.contains("N") || sub.contains("O") || sub.contains("P")
				|| sub.contains("Q") || sub.contains("R") || sub.contains("S")
				|| sub.contains("T") || sub.contains("U") || sub.contains("V")
				|| sub.contains("W") || sub.contains("X") || sub.contains("y")
				|| sub.contains("Z")) {
			return true;

		}
		return false;
	}
}
