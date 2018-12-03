package foundation;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Fenbi {

	public static void main(String[] args) {
		System.out.println(calculate(100, 10000));
		BigInteger alpha = new BigInteger("1189764068877937363846146167338638286425739196572993692965682569366341097141069998263395570909274633255291948889699631666011157726138016295598882944190605");
        BigInteger p = new BigInteger("1325381145334539358629448518279679008904176563248846688977280754468055426387578974281147797624669024229219594573053241551724763638929327015294360424366549");
        BigInteger q = new BigInteger("760221963115420466361881663545019104442925559693");
        BigInteger beta = new BigInteger("238798031115639984887276107391389446213082107084695411039149128034604179189303382254769606917989223743615871451102658150814951925710110771527560977845711");
        String msg = "On Dec 1st, sell all RBC shares in the portfolio and buy 5,750 BMO shares.";
        BigInteger r = new BigInteger("657085232116258040181430472141362000021747681660");
        BigInteger s = new BigInteger("490067537914838692497407674888646687207464807296");
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(msg.getBytes());
            BigInteger m = new BigInteger(digest);
            BigInteger u1 = m.multiply(s.modInverse(q));
            BigInteger u2 = r.multiply(s.modInverse(q));
            BigInteger v = alpha.modPow(u1, p).multiply(beta.modPow(u2, p)).mod(p).mod(q);
            System.out.println(v.equals(r));
        } catch (Exception e) {
            System.out.println("no such hash");
        }
	}
	
	public static double calculate(int count, int size) {
        double result = 1;
        for (int i = 0; i < count; i++) {
            result *= (1 - (double) i / size);
        }
        return 1 - result;
    }


}
