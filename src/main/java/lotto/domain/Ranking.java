package lotto.domain;

import java.util.Arrays;

public enum Ranking {

    NONE(0, 0, ""),
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private final int countOfMatch;
    private final int prize;
    private final String description;

    Ranking(final int countOfMatch, final int prize, final String description) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
        this.description = description;
    }

    public static Ranking from(final int countOfMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.isEqual(countOfMatch))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isEqual(final int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

    public String getDescription() {
        return description;
    }
}
