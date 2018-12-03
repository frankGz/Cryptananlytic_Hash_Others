package foundation;

import java.math.BigInteger;

public class D3 {
	public static void main(String[] args) {
		/*
		 Alice and Bob use the ElGamal cryptosystem with p=17 and g=3. Bob chooses his private key b=6 and 
		 publishes his public key as B=15. Alice sends him the ciphertext (r,t)=(7,6). What message did Alice send?
		 */
		int p = 17;
        int g = 3;
        int b = 6;
        int B = 15;
        int r = 7;
        int t = 6;
        // m = t * r ^ -b mod p
        // fermet: a^(p-1) = 1 mod p ==>  a^(p-1-b) = a^(-b) mod p
        BigInteger m = BigInteger.valueOf(t).multiply(BigInteger.valueOf(r).pow(p-1-b)).mod(BigInteger.valueOf(p));
        System.out.println(m);
	}
}
