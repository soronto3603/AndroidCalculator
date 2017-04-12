package com.example.soronto.calculator;

/**
 * Created by soronto on 2017-04-12.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimpleCalculator {
    private String exp;
    public SimpleCalculator(String exp){
        this.exp=exp;
    }
    public double eval(){
        List<String> list=toAfterExp(this.exp+"#");
        return doEval(list);
    }
    private double doEval(List<String> list){
        Stack<String> stack=new Stack<String>();
        String element;
        double n1,n2,result;
        try{
            for(int i=0;i<list.size();i++){
                element=list.get(i);
                if(isOperator(element)){
                    n1=Double.parseDouble(stack.pop());
                    n2=Double.parseDouble(stack.pop());
                    result=doOperate(n2,n1,element);
                    stack.push(new Double(result).toString());
                }else{
                    stack.push(element);
                }
            }
            return Double.parseDouble(stack.pop());
        }catch(RuntimeException e){
            throw new IllegalExpressionException(e.getMessage());
        }

    }
    private double doOperate(double n1, double n2, String operator) {
        if (operator.equals("+"))
            return n1 + n2;
        else if (operator.equals("-"))
            return n1 - n2;
        else if (operator.equals("*"))
            return n1 * n2;
        else
            return n1 / n2;
    }

    private boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*")
                || str.equals("/");
    }

    private List<String> toAfterExp(String exp) {
        List<String> afterExp = new ArrayList<String>();
        StringBuffer num = new StringBuffer();
        Stack<Character> stack = new Stack<Character>();
        char ch;
        int i = 0;
        String str = "";
        ch = exp.charAt(i);
        stack.push('#');
        while(ch != '#'){
            if(ch == ' ')
                ch = exp.charAt(++i);
            else if(ch == '('){
                stack.push(ch);
                ch = exp.charAt(++i);
            }
            else if(ch == ')'){
                while(stack.peek() != '('){
                    afterExp.add(stack.pop().toString());
                }
                stack.pop();
                ch = exp.charAt(++i);
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(priority(stack.peek()) >= priority(ch)){
                    afterExp.add(stack.pop().toString());
                }
                stack.push(ch);
                ch = exp.charAt(++i);
            }
            else{
                while(ch == '.' || Character.isDigit(ch)){
                    //	num.append(ch);
                    str += ch;
                    ch = exp.charAt(++i);

                }
                //	afterExp.add(num.toString());
                afterExp.add(str);
                //	num.delete(0, num.length());
                str = "";
            }
        }
        while(stack.peek() != '#'){
            afterExp.add(stack.pop().toString());
        }

        return afterExp;
    }
    private int priority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '(':
            case '#':
                return 0;
        }
        throw new IllegalExpressionException("Illegal operator");
    }
    class IllegalExpressionException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public IllegalExpressionException() {

        }
        public IllegalExpressionException(String info) {
            super(info);
        }
    }
    public static void main(String[] args){
       // SimpleCalculator Self=new SimpleCalculator("1+2*2");
        //double result=Self.eval();
        //System.out.println(result);
    }

}
