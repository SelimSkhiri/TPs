package com.example.calculatrice;

public class Operation {

    double apply(double a, int b, char c){
        switch(c) {
            case '+':
                return a+b;

            case '-':
               return a-b;

            case '*':
                return a*b;

            case '/':
                return a/b;
        }
        return 0;
    };
}
