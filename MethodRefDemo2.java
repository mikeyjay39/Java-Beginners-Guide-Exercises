/*
// Use a method reference to an instance method

// A functional interface for numeric predicates that operate
// on integer values.
interface MyIntPredicate {
	boolean test(MyIntNum mv, int n);
}

// This class store an int value and defines the instance
// method isFactor(), which returns true if its argument
// is a factor of the stored value.
class MyIntNum {
	private int v;
	private int fact;
	
	MyIntNum(int x) { v = x; }
	int getNum() { return v; }
	
	// Return true if n is a factor of v.
	boolean isFactor(int n) {
		return (v % n) == 0;
	}
	
	boolean hasCommonFactor(int n) {
		fact = 0;
		for(int i = 2; i <= n; i++) {
			if(n % i == 0)
				fact = i;
			for(int z = 2; z <= v; z++) {
				if(v % z == 0)
					if(fact == z)
						return true;
			}
		}
		return false;
	}
}
public class MethodRefDemo2 {

	public static void main(String[] args) {

		boolean result;
		
		MyIntNum myNum = new MyIntNum(12);
		MyIntNum myNum2 = new MyIntNum(16);
		
		// Here, a method reference to isFactor on myNum is created.
		MyIntPredicate inp = MyIntNum::isFactor;
		
		// Now, it is used to call isFactor() via test().
		result = inp.test(myNum, 3);
		if(result) System.out.println("3 is a factor of " + myNum.getNum());
		
		// This time, a method reference to isFactor on myNum2 is created.
		// and used to call isFactor() via test().
		
		// inp = MyIntNum::isFactor;
		result = inp.test(myNum2, 3);
		if(!result) System.out.println("3 is not a factor of " + myNum2.getNum());
		
		/*
		if(myNum.hasCommonFactor(9))
			System.out.println("9 and " + myNum.getNum() + " have a common factor.");
		
		if(!myNum2.hasCommonFactor(9))
			System.out.println("9 and " + myNum2.getNum() + " have no common factors.");
			*/
/*		
		inp = MyIntNum::hasCommonFactor;
		result = inp.test(myNum, 9);
		if(result) System.out.println("9 and " + myNum.getNum() + " have a common factor.");
		
	}

}


*/


