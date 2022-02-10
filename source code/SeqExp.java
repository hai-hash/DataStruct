/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

import com.sun.corba.se.impl.oa.poa.AOMEntry;

/**
 *
 * @author hai
 */
public class SeqExp implements Expression{
    private int op;
    private Expression exp1;
    private Expression exp2;
    
    public SeqExp(Expression e1, Expression e2, int a_op) {
        exp1 = e1;
        exp2 = e2;
        op = a_op;
    } 
    @Override
    public int eval() {
        switch (op) {
            case 0:
            return exp1.eval() + exp2.eval();
            case 1:
            return exp1.eval() - exp2.eval();
            case 2:
            return exp1.eval() * exp2.eval();
            case 3:
            return exp1.eval() / exp2.eval();
           }
        return 0; 
    }
    public SeqExp operate(Expression e1, int a_op) {
        VarExp e=new VarExp();
        e.setValue(this.eval());
        exp1=e;
        exp2=e1;
        op=a_op;
        return this;
    } 
}
