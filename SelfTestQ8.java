/*
interface MyFunc<T> {
	T func(T n);
}
public class SelfTestQ8 {

	public static void main(String[] args) {

		MyFunc<Integer> fact = (n) -> {

				int result = 1;
				
				for(int i = 1; i <= n; i++){
					result *= i;
				}
				
				return result;
				
			};
			
			
			System.out.println(fact.func(5));
	}

}
*/