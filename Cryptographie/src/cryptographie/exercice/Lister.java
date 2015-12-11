package cryptographie.exercice;

import java.math.BigInteger;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lister
{
    public static Collection<BigInteger> collect(int n, BiPredicate<BigInteger, BigInteger> pred)
    {
        Collection<BigInteger> list = new LinkedList<>();
        
        BigInteger bn = BigInteger.valueOf(n);
        
        for(BigInteger i = BigInteger.ZERO; bn.subtract(i).signum() == 1; i = i.add(BigInteger.ONE))
        {
            boolean valid = false;
            for(BigInteger j = BigInteger.ZERO; bn.subtract(j).signum() == 1 && !valid; j = j.add(BigInteger.ONE))
                valid = pred.test(i, j);
            
            if(valid)
                list.add(i);
        }       
        
        return list;
    }
    
    public static Collection<BigInteger> inversibles(int n)
    {
        BigInteger bn = BigInteger.valueOf(n);
        return IntStream.range(0, n)
                .mapToObj(BigInteger::valueOf)
                .map(i -> getInverse(bn, i))
                .filter(i -> !i.equals(NONE))
                .sorted()
                .collect(Collectors.toList());
    }
    
    public static BigInteger NONE = BigInteger.ZERO.subtract(BigInteger.ONE);
    
    public static boolean isInversible(BigInteger bn, BigInteger x, BigInteger y)
    {
        return x.multiply(y).mod(bn).equals(BigInteger.ONE);
    }
    
    public static BigInteger getInverse(BigInteger bn, BigInteger x)
    {
        for(BigInteger i = BigInteger.ZERO; bn.subtract(i).signum() == 1; i = i.add(BigInteger.ONE))
            if(isInversible(bn, x, i))
                return i;
        return NONE;
    }
    
    public static boolean arePrimal(BigInteger e, BigInteger y)
    {
        if(e.compareTo(y) == -1)
            return arePrimal(y, e);
        
        BigInteger bn = y;
        BigInteger bnmo = bn.subtract(BigInteger.ONE);
        
        return y.equals(e)
                || e
                        .modPow(bnmo, bn)
                        .equals(BigInteger.ONE);
    }
    
    public static boolean isPrimal1(int n)
    {
        return Lister.inversibles(n).size() == n - 1;
    }
    private static boolean _isPrimalFermat1(int n, int v)
    {
        return n == v || BigInteger.valueOf(v).modPow(BigInteger.valueOf(n - 1), BigInteger.valueOf(n)).equals(BigInteger.ONE);
    }
    public static boolean isPrimalFermat1(int n)
    {
        return _isPrimalFermat1(n, 2)
                && _isPrimalFermat1(n, 3)
                && _isPrimalFermat1(n, 5)
                && _isPrimalFermat1(n, 7);
    }
    public static boolean isPrimalFermat2(int n)
    {
        BigInteger bn = BigInteger.valueOf(n);
        BigInteger bnmo = bn.subtract(BigInteger.ONE);
        
        return n == 2
                || BigInteger.valueOf(2)
                        .modPow(bnmo, bn)
                        .equals(BigInteger.ONE);
    }
    
    public static BigInteger generatePrimal(int nbBits)
    {
        return BigInteger.probablePrime(nbBits, new Random());
    }
    public static BigInteger generatePrimal(int nbBits, BigInteger p)
    {
        BigInteger e;
        do
        {
            e = Lister.generatePrimal(nbBits);
        } while(!Lister.arePrimal(e, p));
        return e;
    }
    
    public static BigInteger getN(BigInteger p, BigInteger q)
    {
        return p.multiply(q);
    }
    public static BigInteger getPhiN(BigInteger p, BigInteger q)
    {
        return p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    }
}
