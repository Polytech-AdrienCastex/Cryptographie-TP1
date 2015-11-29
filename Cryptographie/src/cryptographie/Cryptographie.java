package cryptographie;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author p1002239
 */
public class Cryptographie
{
    public static void main(String[] args)
    {
        /*for(int i = 0; i < 1000; i++)
        {*/
        BigInteger m = new BigInteger("55555");
        CryptoSystemPaillier csp = new CryptoSystemPaillier(512, 512);
        csp.generateKeys();
        System.out.println(csp.decrypt(csp.encrypt(m)));/*
        if(csp.decrypt(csp.encrypt(m)).equals(m))
        {
            System.out.println(i);
            return;
        }
            System.out.println(i);
        }*/
        
        /*
        BigInteger p = Lister.generatePrimal(512);
        BigInteger q = Lister.generatePrimal(512);
        BigInteger n = Lister.getN(p, q);
        BigInteger phin = Lister.getPhiN(p, q);
        System.out.println("p = " + p);
        System.out.println("q = " + q);
        System.out.println("n = " + n);
        System.out.println("PhiN = " + phin);
        
        BigInteger e = Lister.generatePrimal(16, phin);
        System.out.println("e = " + e);
        
        BigInteger d = e.modInverse(phin);
        System.out.println("d = e %-1 PhiN = " + d);
        
        System.out.println("e prim d = " + Lister.arePrimal(e, d));
        
        Random rnd = new Random();
        for(int i = 0; i < 10; i++)
        {
            BigInteger x;
            do
            {
                x = new BigInteger(n.bitLength(), rnd);
            } while(x.compareTo(n) >= 0);
            
            BigInteger X = x.modPow(e, n);
            System.out.println("******************************");
            System.out.println("x = " + x);
            System.out.println("X = x^e % n = " + X);
            System.out.println("X^d % n = " + (X.modPow(d, n)));
            System.out.println("X^d % n == x : " + (((X.modPow(d, n)).equals(x)) ? "YES" : "NO"));
        }
        System.out.println("******************************");
        
        
        CryptoSystem cs = new CryptoSystem(16, 512);
        cs.generateKeys();
        for(int i = 0; i < 10; i++)
        {
            BigInteger x;
            do
            {
                x = new BigInteger(n.bitLength(), rnd);
            } while(!cs.isMessageValid(x));
            
            BigInteger em = cs.encrypt(x);
            BigInteger dm = cs.decrypt(em);
            
            System.out.println("******************************");
            System.out.println("x = " + x);
            System.out.println("E(x) = " + em);
            System.out.println("D(E(x)) = " + dm);
            System.out.println("D(E(x)) == x = " + dm.equals(x));
        }
        System.out.println("******************************");
        
        {
            BigInteger x = BigInteger.ONE;
            BigInteger em = cs.encrypt(x);
            BigInteger dm = cs.decrypt(em);
            
            System.out.println("******************************");
            System.out.println("x = " + x);
            System.out.println("E(x) = " + em);
            System.out.println("D(E(x)) = " + dm);
            System.out.println("D(E(x)) == x = " + dm.equals(x));
        }
        {
            BigInteger x = BigInteger.ZERO;
            BigInteger em = cs.encrypt(x);
            BigInteger dm = cs.decrypt(em);
            
            System.out.println("******************************");
            System.out.println("x = " + x);
            System.out.println("E(x) = " + em);
            System.out.println("D(E(x)) = " + dm);
            System.out.println("D(E(x)) == x = " + dm.equals(x));
        }*/
        /*
        System.out.println(Lister.arePrimal(BigInteger.valueOf(19), BigInteger.valueOf(3672)));
        
        CryptoSystemRSA cs = new CryptoSystemRSA(1024, 1024);
        cs.generateKeys();
        System.out.println("pk = " + cs.getPublicKey());
        System.out.println("sk = " + cs.getPrivateKey());
        {
            BigInteger em = cs.encrypt(true);
            
            System.out.println("******************************");
            System.out.println("E(x) = " + em);
            System.out.println("D(E(x)) = " + cs.decrypt(em));
            System.out.println("D(E(x)) = " + cs.decryptBool(em));
        }
        {
            BigInteger em = cs.encrypt(false);
            
            System.out.println("******************************");
            System.out.println("E(x) = " + em);
            System.out.println("D(E(x)) = " + cs.decrypt(em));
            System.out.println("D(E(x)) = " + cs.decryptBool(em));
        }
        
        /*
        System.out.println("*********** 48 ***********");
        BigInteger bn48 = BigInteger.valueOf(48);
        System.out.println(Lister.collect(48, (x,y) -> y.multiply(y).mod(bn48).equals(x.mod(bn48))).size());
        
        System.out.println("");
        System.out.println("*********** 53 ***********");
        BigInteger bn53 = BigInteger.valueOf(53);
        System.out.println(Lister.collect(53, (x,y) -> y.multiply(y).mod(bn53).equals(x.mod(bn53))).size());
    */
    }
    
}
