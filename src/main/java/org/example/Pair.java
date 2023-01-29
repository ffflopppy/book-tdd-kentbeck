package org.example;

import java.util.Objects;

public class Pair {
    private String from;
    private String to;
    //12-2 :: 환율표의 키값
    public Pair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    // Pair를 키값으로 쓰려면 비교를 해야지..
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return from.equals(pair.from) && to.equals(pair.to);
//        return Objects.equals(from, pair.from) && Objects.equals(to, pair.to);
    }

    @Override
    public int hashCode() {
//        return Objects.hash(from, to);
        return 0;
    }
}
