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
public class VarExp implements Expression{
    private int var;
    public VarExp() {};
    public void setValue(int n) {
        var = n;
    } 

    @Override
    public int eval() {
       return var;
    }
}
