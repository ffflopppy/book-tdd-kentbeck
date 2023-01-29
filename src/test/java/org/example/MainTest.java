package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    /**
    * T2.
     *  $5 + 10CHF = $10(환율이 2:1일 경우)
     *  11 :::: $5 + $5 = $10
     *      bank.reduce(Money)
     *  12 :::: Money에 대한 통화 변환을 수행하는 Reduce
    * */


    // 12-1 :::: 2프랑을 달러로 바꾸고싶다. 공식은 2/franc
    // franc 을 기축 통화로 바꿀때 공식이 대입되길 바란다.
    // 12-2 :::: 환율은 은행이 알지, Money가 알지 못한다.
    // FIXME: 2023/01/29 :: 은행마다.. 환율이.. 다를수도?  그럼 Money에 은행도 넘겨야 겠다.

    @Test
    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
//        bank.addRate("CHF", "USD", 2);
        // FIXME: 2023/01/29 달러랑 머니랑 떻게 비교되더라.?
    // 12-1 :: Money.reduce() 로 ==> Money.reduce에 공식을 넣자.
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testReduce(){
        Bank bank = new Bank();
        // Money cannot be cast to Sum
        bank.reduce(Money.dollar(1), "USD");
    }

    // 11-5
    @Test
    public void testReduceMoney(){
        Bank bank = new Bank();
        // dollar 를 Money(기축 통화) 로!!
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);

    }

    // 11-3
    // Bank.reduce(공통 통화로 바꾸는) 는 Sum을 인자로 받는다. Money들의 amount를 합친 Money 객체.
    @Test
    public void testReduceSum(){
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        // Sum.reduce() 로
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    // 11-2 :: Money.plus()는 Money가 아닌 Expression(Sum)을 반환해야 한다.
    // 통화가 추가되었을때 최적화를 위해
    //
    @Test
    public void testPlusReturnsSum(){
        Money five = Money.dollar(5);

        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }



    // 11 :::: 설계상 가장 어려운 제약은 다중 통화 사용에 대한 내용을 시스템의 나머지 코드에게 숨기고싶다.
    // 한가지 가능한 전략은 모든 내부 값을 참조통화(ex: USD) 로 전환하는것.
    // 하지만 이 방식으로는 여러 환율을 쓰기가 쉽지 않다.
    // 대신, 편하게 여러 환율을 표현 할 수 있으면서도 [산술 연산 비슷한 표현]들을 여전히 [산술 연산 처럼] 다룰 수 있는 해법이 있으면 좋겠다.
    //  객체가 우리를 구해줄 것이다. 가지고 있는 객체가 우리가 원하는 방식으로 동작하지 않을 경우
    //  그 객체와 외부 프로토콜이 같으면서, 내부 구현은 다른 새로운 객체를 만들수 있다.
    //  >> 머니와 비슷하게 동작하지만 사실은 두 머니의 합을 나타내는 객체를 만드는것.
    //      >> 1. 지갑? xxx
    //      >> 2. (2+3)*5 같은 수식? -> ($2 + 3CHF)*5 라면?
    //          >> 연산의 결과로 Expression들이 생기는데 그 중 [하나는 Sum] 이 될것이다.
    //          >> 연산이 와료 되면 환을을 이용해 결과 Expression을 단일 통화로 [축약]할수 있다???
    // [축약 : reduced -> 환전??] : Expression에 환율을 적용함으로써 얻어진것..? 환전은 은행에서해야지.
    //

    @Test
    public void testSimpleAddition(){

//        Money sum = Money.dollar(5).plus(Money.dollar(5));
//        assertEquals(Money.dollar(10), sum);

        // 11 :::: 은행에서 환율을 적용하면(환전을 하면) 10달러 와 같다!!!
        Money five = Money.dollar(5);
        // 11 :::: 두 머니의 합은 expression 이어야 한다.
        // :: 머니의 합은 어떤 통화가 될지 모른다. 일단 합계 인것이다.
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        // 11 :::: 은행에서 공통 통화(Money)로 환율을 적용하면
        Money reduced = bank.reduce(sum,"USD");
        assertEquals(Money.dollar(10), reduced);

    }

/*
* Expression 은 우리가 하려고 하는 일의 핵심에 해당한다.
* 핵심이 되는 객체가 다른 부분에 대해서 될 수 있는 한 모르도록 노력하나. 그렇게 하면 핵심 객체가 가능한 오랫동안 유연할수 있다.
* */

/**
*     T1.
*       $5+10CHF = $10
*       1 :::: $5 * 2 = $10
*       amount 를 pirvate로 만들기
*       2 :::: Dollar 부작용
*       Money 반올림
*       3 :::: equals()
*       hashCode()
*       Equal null
*       Equal object
 *       4 :::: 5CHF * 2 = 10 CHF
 *       5 :::: 공용 equals
 *      9 :::: 공용 times
 *      6 :::: Franc과 Dollar 비교하기
 *      8 :::: 통화?
 *
 *      10 :: 7 :::: Dollar/ Franc 중복(times..)
 *      testFrancMultiplication 제거.
 * */


// 10
// 9 ::::
@Test
public void testDifferentClassEquality(){

    assertTrue(Money.dollar(5).equals(Money.dollar(5)));
//    Money money = new Money(10, "CHF");
//    Franc franc = new Franc(10, "CHF");
//    // todo:: toString 어떻게 로그에 찍히는가..... 제길
//    money.toString();
//    franc.toString();
//
//    assertTrue(money.equals(franc));
//        // todo :: Franc으로 Dollar를 만들수 있음. 얼마나 좋은가. 씨부레..
//         -> 8-7 에서 생성자를 지웠기때문에 더이상 만들수 없다ㅋㅋㅋ
//        assertTrue(new Money(10, "USD").equals(new Franc(10,"USD")));
//        assertFalse(new Money(10, "CHF").equals(new Franc(10,"USD")));
    }

/*
    8-1:::
    통화 테스트.
    테스트 코드부터 작성하자.
    어떻게 테스트 하길 바라는가!
*/

@Test
public void testCurrency(){
    assertEquals("USD", Money.dollar(1).currency());
}

/*
  7 ::::
  최소한 선언부만이라도 공통 상위 클래스(Money)로 옮겼다.
  팩터리 메서드를 도입하여 테스트 코드에서 콘크리트 하위 클래스의 존재를 숨겼다(분리했다).
  하위 클래스가 사라지면 몇몇 테스트는 불필요한 여분의 것이 된다는 것을 알지만 일단 뒀다.

*/
    /*
    * 1. 테스트 작성
    * 2. 컴파일 되게 하기.
    * 3. 실패하는지 확인하기위해 실행.
    * 4. 실행하게 만들고
    * 5. 중복을 제거하자.
    * */


//  4 ::::
    @Test
    public void testFranceMultiplication(){
//        Franc five = new Franc(5);
//        // equal 재정의 필요.
//        assertEquals(new Franc(10), five.times(2));
    }

//  7 ::::
//     Money.dollar(5) 로 Dollar 라는 클래스가 존재할거란걸 알수 없게되었다.

//  5 ::::
//  3 :::: 5$ 라는 객체는 항상 다른 5$와 같다. ($5 == $5)
    @Test
    public void testEquality(){
        assertFalse(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
//
//        assertTrue(new Dollar(5).equals(new Dollar(5)));
//        assertFalse(new Dollar(5).equals(new Franc(5)));
    }

//  7 ::::
//  2 ::::
    @Test
    public void testMultiplication(){

        // 7-2 :::: Money 클래스에는 times가 없다
        // abstract Money times(int multiplier); 선언으로 해결할수 있다.
        Money five = Money.dollar(5);
        assertEquals(five.times(2), Money.dollar(10));


        // 7-1 :::: 팩터리 메서드를 사용해보자!!!!!
        // 하위 클래스에 대한 직접적인 참조가 적어진다면 하위 클래스를 제거하기 위해 한 발짝 더 다가섰다고 할수 있겠다.
        // Money에 Dollar를 반환하는 팩터리 메서드를 도입하자. -> Money에서 Dollar를 생성하도록
//        Dollar five = Money.dollar(5);
//        assertEquals(new Dollar(10), five.times(2));
//        assertEquals(new Dollar(15), five.times(3));


//          :::: five의 의미로 유지가 되려면 times를 호출했을때, new Dollar로 항상 새로운 객체를 돌려준다.
//        Dollar product = five.times(2);
//        assertEquals(10, product.amount);
//        product = five.times(3);
//        assertEquals(15, product.amount);
//          XXXX : expected: <15> but was: <30>
//        five.times(2);
//        assertEquals(10, five.amount);
//        five.times(3);
//        assertEquals(15, five.amount);
    }

//    1 ::::
//    @Test
//    public void testMultiplication(){
//        Dollar five = new Dollar(5);
//        five.times(2);
//        assertEquals(10, five.amount);
//    }

}