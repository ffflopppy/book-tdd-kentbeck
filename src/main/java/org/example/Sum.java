package org.example;

public class Sum
    // 11-2 :::: sum 은 expression의 일종이어야 한다.
        implements Expression
{
    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    Money augend;
    Money addend;


    // 공통 통화(Money)로 바꾸는
    public Money reduce(String to) {
        return new Money(augend.amount+ addend.amount , to);
//        int amount =  sum.augend.amount+ sum.addend.amount;
//        return new Money(amount, "to");
    }

//
//
//    public Money reduce(Bank bank, String to){
//        int amount = augend.amount + addend.amount;
//        return new Money(amount, to);
//    }
//
//    @Override
//    public Money reduce(String to) {
//        int amount = augend.amount + addend.amount;
//        return new Money(amount, to);
//
//    }


}
