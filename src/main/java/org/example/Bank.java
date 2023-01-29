package org.example;

import java.util.HashMap;
import java.util.Hashtable;

public class Bank {

    // FIXME(fixed) :: 인터페이스를 인자로 받는것!!! ==> 함수를 받는것!!! 찢엇다..
    public Money reduce(Expression source, String to) {
        // 11 -4 :::: 만약 인자로 들어온 source가 이미 Money 라면 바로 return
        // Money != Sum 호환이 안된다.
        // 11-5 :::: Money로 인자가 들어오면 reduce를 할수가 없다. Money 에서도 reduce를 구현해주자.
        // Expression 인터페이스에 reduce 를 추가하고 Money에서 this를 리턴.
        // FIXME(fixed) :: 인터페이스를 인자로 받는것!!! ==> 함수를 받는것!!! 찢엇다..
        // Expression.reduce() source 가 Sum이면 Sum.reduce() Money면 Money.reduce()
        return source.reduce(to);
        // if (source instanceof Money) return (Money) source;

        // 11-3 ::: sum 이 가지고 있는 Money의 통화가 모두 동일하고,
        // reduce를 통해 얻어내고자 하는 Money의 통화 역시 같다면,
        // 결과는 Sum 내에 있는 Money들의 amount를 합친 Money 객체 이다.
//        Sum sum = (Sum) source;
//        // 11-4 ::: 이코드는 모든 Expression 에 대해 작동해야 하고, public 필드와 그 필드에 대해 두단계에 걸친 레퍼런스가 맘에 안든다.
//        // >> sum에게 행위를 넘기도록한다.
//        return sum.reduce(to);
//        int amount =  sum.augend.amount+ sum.addend.amount;
//        return new Money(amount, "to");
        // 11 :::: 스텁(목객체 같은 가짜 값)이 필요하다.
//        return Money.dollar(10);
    }
// ========================
//    private Hashtable rates = new Hashtable();
//
//
//    public Money reduce(Expression source, String to) {
//        if (source instanceof Money) return (Money)source.reduce(to);
//        return source.reduce(to);
////        return  Money.dollar(10);
////        return source.reduce(this, to);
//
//    }
//
//    public void addRate(String from, String to, int rate) {
//        rates.put(new Pair(from,to), rate);
//    }
//
//    public int rate(String from, String to) {
//        if (from.equals(to)) return 1;
//        int rate = (Integer)rates.get(new Pair(from, to));
//
//        return rate;
//    }
}
