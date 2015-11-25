package cryptographie;

import java.math.BigInteger;
import java.util.Random;

public class CryptoSystemPaillier
{
    public CryptoSystemPaillier(int nbBitPKey, int nbBitGen)
    {
        this.nbBitPKey = nbBitPKey;
        this.nbBitGen = nbBitGen;
    }
    
    private final int nbBitPKey;
    private final int nbBitGen;
    private BigInteger pk;
    private BigInteger sk;
    private BigInteger n;
    private BigInteger n2;
    private BigInteger phin;
    
    public void generateKeys()
    {
        BigInteger p = Lister.generatePrimal(nbBitGen);
        BigInteger q = Lister.generatePrimal(nbBitGen);
        n = Lister.getN(p, q);
        n2 = n.pow(2);
        phin = Lister.getPhiN(p, q);
        
        pk = Lister.generatePrimal(nbBitPKey, phin);
        sk = pk.modInverse(phin);
    }
    
    public BigInteger getPublicKey()
    {
        return new BigInteger(n.toString() + pk.toString());
    }
    public BigInteger getPrivateKey()
    {
        return sk;
    }
    
    public BigInteger encrypt(BigInteger msg)
    {
        Random rnd = new Random();
        BigInteger r;
        do
        {
            r = new BigInteger(n.bitLength(), rnd);
        } while(r.compareTo(BigInteger.ZERO) == 1 && r.compareTo(n) == -1);
        
        return n.add(BigInteger.ONE).modPow(msg, n2).multiply(r.modPow(n, n2)).mod(n2);
    }
    
    public BigInteger decrypt(BigInteger c)
    {
        return c.modPow(phin, n2).multiply(c)
        /*
        BigInteger r = c.modPow(n.not().mod(phin), n);
        return c.multiply(r.modPow(n.negate(), n2)).mod(n2).subtract(BigInteger.ONE).divide(n);
                */
    }
}
