package org.example;

import java.util.Objects;

public class Franc
//        extends Money
{
//  money로 올렸기 때문에 제거 가능
//    private int amount;

//    5 :::: money로 올렸기 때문에 제거 가능
//    public boolean equals(Object object) {
//        Money money = (Money) object;
//        return money.amount == this.amount;
//    //    Money franc = (Franc) object;
//    //    return franc.amount == this.amount;
//    }

//    8 ::::
    // 8-3 :::: Dollar 와 같은 메서드다 Money로 올려보자
//    private String currency;
//    @Override
//    String currency() {
//        return this.currency;
//    }

//    10 :: 만약 프랑이나 달러를 직접 호출하지 않는다면??
    // 8-4 ::: Dollar와 같다.
//    public Franc(int amount, String currency) {
//        super(amount, currency);
////        this.amount = amount;
////        this.currency = currency;
//    }
//    4 ::::
//    public Franc(int amount) {
//        this.amount = amount;
//        this.currency = "CHF";
//
//    }

//    public Money times(int multiplier){
//        return new Franc(amount * multiplier, currency);
////        return new Money(amount * multiplier, currency);
////        return Money.franc(amount* multiplier);
//    }



//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Franc)) return false;
//        Franc franc = (Franc) o;
//        return amount == franc.amount;
//    }




}
