/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptographie.projet;

import java.math.BigInteger;

/**
 *
 * @author Adrien
 */
public class Main implements Runnable
{
    @Override
    public void run()
    {
        Alice alice = new Alice();
        Bob bob = new Bob(2);
        
        alice.setBobKey(bob.getKey());
        bob.setAliceKey(alice.getKey());
        
        BigInteger[] questions = alice.getQuestions();
        BigInteger selectedQuestion = bob.selectQuestion(questions);
        BigInteger[] potentialAnswers = alice.getAnswers(selectedQuestion);
        bob.extractAnswer(potentialAnswers);
    }
}
