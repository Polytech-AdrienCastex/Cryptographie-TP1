package cryptographie.projet;

import cryptographie.systems.CryptoSystemPaillier;
import java.math.BigInteger;
import java.util.Random;

public class Bob
{
    public Bob(int questionToSelected)
    {
        this.questionToSelected = questionToSelected;
        this.csp = new CryptoSystemPaillier(512);
        this.csp.generateKeys();
    }
    
    private final CryptoSystemPaillier csp;
    private final int questionToSelected;
    private BigInteger alicePk;
    private BigInteger rs;
    
    public BigInteger getKey()
    {
        return csp.getPublicKey();
    }
    public void setAliceKey(BigInteger pk)
    {
        this.alicePk = pk;
    }
    
    public BigInteger selectQuestion(BigInteger[] questions)
    {
        rs = BigInteger.valueOf(Math.abs(new Random().nextLong()));
        
        BigInteger qsel = questions[questionToSelected % questions.length];
        return qsel.multiply(CryptoSystemPaillier.encrypt(rs, alicePk));
    }
    
    public void extractAnswer(BigInteger[] answers)
    {
        for(BigInteger ans : answers)
            System.out.println(csp.decrypt(ans).subtract(rs));
    }
}
