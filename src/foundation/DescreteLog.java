package foundation;

import java.math.BigInteger;
import java.util.Random;

public class DescreteLog {
	public static BigInteger log(BigInteger p,BigInteger a,BigInteger x){
	    boolean logFound = false;
	    Random r = new Random();
	    BigInteger k = BigInteger.ONE;

	    while(!logFound){
	        if(a.modPow(k, p).equals(x)){
	            logFound = true;
	        }else{
	            k = k.add(BigInteger.ONE);

	        }
	    }
	    return k;
	}
	
	public static void main(String[] args) {

	    BigInteger p = new BigInteger("101");
	    BigInteger a = new BigInteger("3");
	    BigInteger x = new BigInteger("34");

	    System.out.println(log(p,a,x));
	}
}
