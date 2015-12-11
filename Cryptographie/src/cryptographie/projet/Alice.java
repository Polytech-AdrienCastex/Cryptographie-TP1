package cryptographie.projet;

import cryptographie.systems.CryptoSystemPaillier;
import java.math.BigInteger;
import java.util.Random;

public class Alice
{
    public Alice()
    {
        this.csp = new CryptoSystemPaillier(512);
        this.csp.generateKeys();
        
        A1 = new BigInteger("10");
        A2 = new BigInteger("20");
        A3 = new BigInteger("30");
    }
    
    private final CryptoSystemPaillier csp;
    private BigInteger bobPk;
    
    private BigInteger A1 = new BigInteger("10");
    private BigInteger A2 = new BigInteger("20");
    private BigInteger A3 = new BigInteger("30");

    private BigInteger Q1;
    private BigInteger Q2;
    private BigInteger Q3;

    
    public BigInteger[] getQuestions()
    {
        Q1 = BigInteger.valueOf(Math.abs(new Random().nextLong()));
        Q2 = BigInteger.valueOf(Math.abs(new Random().nextLong()));
        Q3 = BigInteger.valueOf(Math.abs(new Random().nextLong()));
        
        return new BigInteger[]
        {
            csp.encrypt(Q1),
            csp.encrypt(Q2),
            csp.encrypt(Q3)
        };
    }
    
    public BigInteger getKey()
    {
        return csp.getPublicKey();
    }
    public void setBobKey(BigInteger pk)
    {
        this.bobPk = pk;
    }
    
    public BigInteger[] getAnswers(BigInteger selectedQuestion)
    {
        BigInteger qselA = csp.decrypt(selectedQuestion);
        
        return new BigInteger[]
        {
            CryptoSystemPaillier.encrypt(bobPk.subtract(Q1).add(A1).add(qselA), bobPk),
            CryptoSystemPaillier.encrypt(bobPk.subtract(Q2).add(A2).add(qselA), bobPk),
            CryptoSystemPaillier.encrypt(bobPk.subtract(Q3).add(A3).add(qselA), bobPk)
        };
    }
}
