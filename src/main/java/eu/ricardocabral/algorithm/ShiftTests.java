package eu.ricardocabral.algorithm;

public class ShiftTests {


	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(2 << 11));
		//10 -> 2 binary goes 11 times to left -> 00000000000
		System.out.println(Integer.toBinaryString(2 << 32));
		
		System.out.println(Integer.parseInt("1000000000000", 2));
		System.out.println(Math.pow(2, 12));
	}
}
