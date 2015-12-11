package cryptographie;

import java.math.BigInteger;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        new cryptographie.projet.Main().run();
        
        /*for(int i = 0; i < 1000; i++)
        {*//*
        CryptoSystemPaillier csp = new CryptoSystemPaillier(512);
        csp.generateKeys();
        
        CryptoSystemPaillier csp2 = new CryptoSystemPaillier(512);
        csp2.generateKeys();
        
        // Alice
        BigInteger A1 = new BigInteger("10");
        BigInteger A2 = new BigInteger("20");
        BigInteger A3 = new BigInteger("30");
        
        BigInteger Q1 = BigInteger.valueOf(Math.abs(new Random().nextLong()));
        BigInteger Q2 = BigInteger.valueOf(Math.abs(new Random().nextLong()));
        BigInteger Q3 = BigInteger.valueOf(Math.abs(new Random().nextLong()));
        
        BigInteger q1 = csp2.encrypt(Q1);
        BigInteger q2 = csp2.encrypt(Q2);
        BigInteger q3 = csp2.encrypt(Q3);
        
        // Bob
        BigInteger rs = BigInteger.valueOf(Math.abs(new Random().nextLong()));
        
        BigInteger qsel = q3;
        BigInteger cqsel = qsel.multiply(csp2.encrypt(rs));
        
        // Alice
        BigInteger qselA = csp2.decrypt(cqsel);
        BigInteger a1 = csp.encrypt(csp.n.subtract(Q1).add(A1).add(qselA));
        BigInteger a2 = csp.encrypt(csp.n.subtract(Q2).add(A2).add(qselA));
        BigInteger a3 = csp.encrypt(csp.n.subtract(Q3).add(A3).add(qselA));
        
        // a1 = A1 + n - Q1 + rs + Qx
        // A1 = a1 + Q1 - rs - Qx
        
        // Bob
        System.out.println(csp.decrypt(a1).subtract(rs));
        System.out.println(csp.decrypt(a2).subtract(rs));
        System.out.println(csp.decrypt(a3).subtract(rs));*/
        
        
        /*
        CryptoSystemPaillier csp2 = new CryptoSystemPaillier(512);
        csp2.generateKeys();
        
        BigInteger v1 = BigInteger.valueOf(Math.abs(new Random().nextLong()));
        BigInteger v2 = BigInteger.valueOf(Math.abs(new Random().nextLong()));
        BigInteger v3 = BigInteger.valueOf(Math.abs(new Random().nextLong()));
        
        BigInteger ans1 = new BigInteger("10");
        BigInteger ans2 = new BigInteger("20");
        BigInteger ans3 = new BigInteger("30");
        
        BigInteger A1 = csp.encrypt(v2);
        
        BigInteger v1c = csp.encrypt(ans1).multiply(csp2.encrypt(v1));
        BigInteger v2c = csp.encrypt(ans2).multiply(csp2.encrypt(v2));
        BigInteger v3c = csp.encrypt(ans3).multiply(csp2.encrypt(v3));
        
        BigInteger Bv1 = csp.decrypt(v1c).subtract(v1);
        BigInteger Bv2 = csp.decrypt(v2c).subtract(v2);
        BigInteger Bv3 = csp.decrypt(v3c).subtract(v3);
        
        System.out.println(Bv1);
        System.out.println(Bv2);
        System.out.println(Bv3);
        
        System.out.println(csp.decrypt(v1c).subtract(v1));
        System.out.println(csp.decrypt(v1c).subtract(v2));
        System.out.println(csp.decrypt(v1c).subtract(v3));*/
        
        
        /*
        proceed(csp, new BigInteger("70"), csp.encrypt(v1), v1);
        proceed(csp, new BigInteger("70"), csp.encrypt(v2), v2);
        proceed(csp, new BigInteger("70"), csp.encrypt(v3), v3);
        */
        
        /*
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
