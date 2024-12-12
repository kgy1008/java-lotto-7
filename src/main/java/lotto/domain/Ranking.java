package lotto.domain;

public enum Ranking {

    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int countOfMatch;
    private final int prize;

    Ranking(final int countOfMatch, final int prize) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
    }
}
