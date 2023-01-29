package org.example;

public class Money
        implements Expression
{

    //  5 :::: 중복 제거 - amount
    // protected scope 을 생각하게됨.
    protected int amount;
    protected String currency;

    //12-2
    @Override
    public Money reduce(Bank bank, String to) {

        // 12-2 :: 역시 환율은 은행이 아는것. 은행에 물어보도록 하자.
        int rate = bank.rate(currency,to);
//        int rate = (currency.equals("CHF") && to.equals("USD")) ? 2: 1;
        // 정수만 표현.
        return new Money(amount/rate, to);
    }

    // 11-5 :: 상속받고 있는 Expression 에 reduce를 추가
    @Override
    public Money reduce(String to) {
//        return this;
        // 12-1 :::
        // 프랑을 달러로 바꾼다면
        int rate = (currency.equals("CHF") && to.equals("USD")) ? 2: 1;
        return new Money(amount/rate, to);
    }

    @Override
    public String toString() {
        return "Money{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    // 7-2
    public Money times(int multiplier){
        return new Money(amount * multiplier, currency) ;
    };

    public String currency() {
        return this.currency;
    }

    // 10 :::: 하위 클래스에는 생성자만 남았다.
    // 코드의 의미를 변경하지 않으면서, 하위 클래스에 대한 참조를 상위 클래스에 대한 참조로 변경 해보자.
    // 이 의미가 하위 클래스의 생성자를 지울수 있다는 의미는 아니다. 해당 코드는 머니를 반환하지만 프랑이나, 달러객체를 사용할대는 생성자가 사용되기때문에 지울수 없다.
    // fixme (fixed) :: 만약 프랑이나 달러를 직접 호출하지 않는다면?? -> 지울수 있음.
    public static Money franc(int amount){
        return new Money(amount, "CHF");
    }
    public static Money dollar(int amount){
        return new Money(amount, "USD");
    }
//    public static Franc franc(int amount){
//        return new Franc(amount, "CHF");
//    }
//    public static Dollar dollar(int amount){
//        return new Dollar(amount, "USD");
//    }

    public boolean equals(Object obj){
        Money money = (Money) obj;
        return  this.amount == money.amount
//                 9 :::: Money Franc 비교 하기. class 가 아니라 currency를 비교 해야 한다.
                && currency().equals(money.currency);
//                 6 :::: Franc과 Dollar 비교하기
//                 && this.getClass().equals(money.getClass());
    }



    // 11 :::: 두 머니의 합은 expression 이어야 한다.
    //      >> Money 가 Expression을 구현해야 한다.
    public Expression plus(Money addend) {
        // 11-2 ::::
        return new Sum(this, addend);
//        return new Money(this.amount + addend.amount, this.currency());
//    public Money plus(Money addend) {
    }




//    public Money(int amount, String currency) {
//        this.amount = amount;
//        this.currency = currency;
//    }
//
//
//    @Override
//    public Money reduce(Bank bank, String to) {
//        int rate = bank.rate(currency, to);
////        int rate = (currency.equals("CHF") && to.equals("USD"))? 2:1;
//        return new Money(amount/rate, to);
//    }
//
//    @Override
//    public Money reduce(String to) {
////        int rate = (currency.equals("CHF") && to.equals("USD"))? 2:1;
////        return new Money(amount/rate, to);
//
//        return this;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Money{" +
//                "currency='" + currency + '\'' +
//                ", amount=" + amount +
//                '}';
//    }
//
//     Money times(int multiplier){
//         return new Money(amount* multiplier, currency);
//     };
//
//    protected String currency;
//    public String currency() {
//        return currency;
//    }
//

////
////    static Franc franc(int amount){
////        return new Franc(amount,"CHF");
////    }

//
//
////    public Expression plus(Money addend) {
////        return new Money(amount+ addend.amount, currency);
////    }
//    public Expression plus(Money addend) {
//        return new Sum(this, addend);
//    }


}
