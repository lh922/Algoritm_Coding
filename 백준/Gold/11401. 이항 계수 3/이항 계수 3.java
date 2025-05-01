import java.util.Scanner;

public class Main {
	
	final static int MAX = 4000000;
	static long fact[] = new long[MAX + 1];
	static long mod = 1000000007;
	
	public static long fast_pow(long base, long exponent) {
		long result = 1;
		
		while(exponent >= 1) {
			if(exponent % 2 == 1) {
				result = (result * base) % mod; //지수가 홀수인 경우에만 밑을 한 번 더 곱함.
			}
			base = (base * base) % mod;
			exponent /= 2;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		
		fact[0] = 1;
		for(int i = 1; i < fact.length; i++) {
			fact[i] = (fact[i - 1] * i) % mod;
		}
		long temp = (fact[K] * fact[N - K]) % mod;
		long result = (fact[N] * fast_pow(temp, mod - 2)) % mod;
		System.out.println(result);
	}

}
