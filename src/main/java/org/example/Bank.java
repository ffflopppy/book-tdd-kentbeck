package org.example;

import java.util.HashMap;
import java.util.Hashtable;

public class Bank {



    // HashTable은 HashMap과 반대로 동기화가 이루어진다. 즉 Thread-safe 하다
    // 그렇기에 멀티스레드 환경이 아니라면 Hashtable은 HashMap 보다 성능이 떨어진다는 단점
    // FIXME: 2023/01/29 :: HashMap을 사용해야 하는 이유를 알아와라.
    private HashMap rates = new HashMap();

    
    // 12-2 :: 환율표에서 키는 pair<from, to> 로 쓰고, 값은 int 로 저장 하자.
    void addRate(String from, String to, int rate){
        rates.put(new Pair(from,to), rate);
        
    }
    
    //12-2
    public int rate(String from, String to) {
        // 12-3 :: 같은 통화를 비교하면 rate는 1 이어야 한다.
        if (from.equals(to)) return  1;

        // 은행은 어떻게 아는가! 환율표가 필요하다.
        // 12-2 환율표에서 get pair로 get 해보자.
        return (int) rates.get(new Pair(from, to));
    }

    // 다형성.
    public Money reduce(Expression source, String to, Bank bank) {

        return source.reduce(bank, to);

    }


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
