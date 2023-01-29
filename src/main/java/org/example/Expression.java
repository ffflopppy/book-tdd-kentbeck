package org.example;

public interface Expression {
//    // 누산기..?
    Money reduce(Bank bank, String to);
    // 11-5 :: Money != Sum 호환 안되는 문제를 Expression 으로 올린것.
    // 공통의 Sum에서 부르던 Money에서 부르던 Money type casting 가능!
    Money reduce( String to);
}
