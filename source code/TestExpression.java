/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

/**
 *
 * @author hai
 */
public class TestExpression {
    public static void main(String[] args) {
        VarExp a = new VarExp();
        VarExp b = new VarExp();
        a.setValue(3);
        b.setValue(7);
        SeqExp sum = new SeqExp(a, b, 0);
        SeqExp diff = new SeqExp(a, b, 1);
        SeqExp mul = sum.operate(diff,2);
        
        System.out.println(mul.eval());
    }
    
}
