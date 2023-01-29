package org.example;

import java.util.Objects;

public class Dollar
//        extends Money
{
//    public int amount;
    /*
    8-2 ::::
    currency를 생성자 인스턴스에 넣어두면 따로 부르지 않아도 되겠다.
    */

    // 8-3 :::: Franc 과 같은 메서드다 Money로 올려보자
//    protected String currency;
//    @Override
//    String currency() {
//        return this.currency;
//    }
    // 8 ::::
//    @Override
//    String currency() {
//        return "USD";
//    }

    // 8-7 생성자 내용을 Money 로 올리자.
    // Money 추상 객체가 생성자가 생겼다. super를 써야만 한다.
//    public Dollar(int amount, String currency){
//        super(amount, currency);
//    }

    // 8-4 ::: Franc 과 같다.
//    public Dollar(int amount, String currency) {
//        this.amount = amount;
//        // 8-5 Money 에서 주입받자.
//        //  그러면..  amount 만 인자로 받고 있는 직접 클래스를 콜한 몇 개의 테스트는 삭제되어야 한다.
//        // times 안에 생성자도 인자를 하나만 받고 있다.
//        // 객체를 직접 new 하면 안된다는 뜻이다.
//        this.currency = currency;
//    }

    // 9-1 :::: 다시 클래스를 직접 호출하자,  이제 Money로 올려보자.
//        return new Dollar(amount * multiplier, "USD");
//        return new Franc(amount * multiplier, "CHF");
//    public Money times(int multiplier){
//        return new Dollar(amount * multiplier, currency) ;
//    }
    // 9 :::: times 도 똑같이 생겼지만 팩터리 메서드를 부른다. 어떻게 똑같이 만들지..
//         return Money.franc(amount * multiplier);
//         return Money.dollar(amount * multiplier);
    // 8-6 times 안에 생성자도 인자를 하나만 받고 있다.
    // 객체를 직접 new 하면 안된다는 뜻이다.
    //    7 :::: Money 를 반환한다면 공통화 해서 Money 로 올릴수 있다.
//    public Money times(int multiplier){
//        return Money.dollar(amount * multiplier);
//    }

//    public Dollar(int amount) {
//        this.amount = amount;
//        this.currency = "USD";
//    }

//  5 :::: 공통화를 한후에 중복을 제거할수 있다.
//     상속받은 Money 객체의 amount를 비교하자. 그렇다면 공통화 할수 있다.
//    public boolean equals(Object object){
//        Money money = (Money) object;
//        return this.amount == money.amount;
////        Money dollar = (Dollar) object;
////        return amount == dollar.amount;
//    }

//    3 ::::
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Dollar)) return false;
//        Dollar dollar = (Dollar) o;
//        return amount == dollar.amount;
//    }





    //    2 ::::
//    public Dollar times(int muliplier){
//        return new Dollar(amount* muliplier);
//    }

//    1 ::::
//    public void times(int multiplier){
//        this.amount = amount*multiplier;
//    }







}