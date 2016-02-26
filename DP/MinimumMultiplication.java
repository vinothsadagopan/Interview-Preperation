class MinimumMultiplication {
	public static int minMultiply(int a, int b) {
		int smaller = a<b?a:b;
		int bigger = a<b? b:a;
		return minMultiplyHelper(smaller,bigger);
	}
	public static int minMultiplyHelper(int smaller, int bigger) {
		if(smaller==0) return 0;
		else if(smaller==1) return bigger;
		int s = smaller >>1;
		int halfProduct = minMultiplyHelper(s,bigger);
		if(smaller%2==0) {
			return halfProduct+halfProduct;
		}
		else {
			return halfProduct+halfProduct+bigger;
		}
 	}
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(minMultiply(7,8));
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
	}
}