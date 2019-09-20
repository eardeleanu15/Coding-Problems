package edu.algorithms.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {

    public static void main(String[] args) {
        ArrayList<String> expresion = new ArrayList<>();
        expresion.add("4");
        expresion.add("13");
        expresion.add("5");
        expresion.add("/");
        expresion.add("+");
        System.out.println("Expression value: " + new EvaluateExpression().evalRPN(expresion));
    }

    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();
        for(String s : A) {
            if(!isOperand(s)) {
                stack.push(Integer.valueOf(s));
            } else {
                int rightOperator, leftOperator;
                switch(s) {
                case "*":
                    rightOperator = stack.pop();
                    leftOperator = stack.pop();
                    stack.push(leftOperator * rightOperator);
                    break;
                case "/":
                    rightOperator = stack.pop();
                    leftOperator = stack.pop();
                    stack.push(leftOperator / rightOperator);
                    break;
                case "+":
                    rightOperator = stack.pop();
                    leftOperator = stack.pop();
                    stack.push(leftOperator + rightOperator);
                    break;
                case "-":
                    rightOperator = stack.pop();
                    leftOperator = stack.pop();
                    stack.push(leftOperator - rightOperator);
                    break;
                }
            }
        }
        return stack.pop();
    }

    public boolean isOperand(String s) {
        if ((s == "*") || (s == "/") || (s == "+") || (s== "-")) {
            return true;
        } else return false;
    }
}
