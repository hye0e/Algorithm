import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
 
public class Main {
	
	private static BigInteger factorial(int s, int e) {
		
		BigInteger mul = new BigInteger("1");
		
		for (int i = s; i <= e; i++) {
			mul = mul.multiply(new BigInteger(String.valueOf(i)));
		}
		
		return mul;
	}
 
	public static void main(String[] args) throws Exception {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		BigInteger result = factorial(m + 1, n).divide(factorial(1, n - m));
		
		System.out.println(result);
	}
 
}