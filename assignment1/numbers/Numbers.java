//
// 1) Print all n-digit strictly increasing numbers
// Given number of digits n in a number, print all n-digit numbers whose digits are strictly increasing from left to right.
// Examples:
// Input: n = 1
// Output: 0 1 2 3 4 5 6 7 8 9
// Input: n = 2
// Output:
// 01 02 03 04 05 06 07 08 09 12 13 14 15 16 17 18 19 23 24 25 26 27 28 29 34 35 36 37 38 39 45 46 47 48 49 56 57 58 59 67 68 69 78 79 89
// 2) Generate all binary strings without consecutive 1’s
// Given number n print all binary string of size n where all the binary strings do not have consecutive ones. Examples:
// Input : K = 3
// Output : 000 , 001 , 010 , 100 , 101
// Input : K = 4
// Output :0000 0001 0010 0100 0101 1000 1001 1010
package numbers;

class Numbers{

	public static void incTest(int n){
		Increase test = new Increase(n);
		test.calc();
		test.show();
	}

	public static void binTest(int k){
		Binary test = new Binary(k);
		test.calc();
		test.show();
	}

	public static void main(String[] args){
		//incTest(Integer.parseInt(args[0]));
		binTest(Integer.parseInt(args[0]));
	}
}
