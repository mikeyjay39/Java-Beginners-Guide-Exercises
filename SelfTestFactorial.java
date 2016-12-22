interface NumericFunc {
	int func(int n);
}

public class SelfTestFactorial {

	public static void main(String[] args) {


		
		NumericFunc fact = (n) -> {
			int result = 1;
			
			for(int i = 1; i <= n; i++){
				result *= i;
			}
			
			return result;
			
		};
		
		
		System.out.println(fact.func(5));
	}

}
