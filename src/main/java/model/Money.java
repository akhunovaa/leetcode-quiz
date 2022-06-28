package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public class Money implements Serializable, Comparable<Money> {

    private final BigDecimal amount;
    private final Currency currency; // Currency is an enum or another value object

    public Money(BigDecimal amount, Currency currency) {
        this.currency = Objects.requireNonNull(currency);
        //this.amount = Objects.requireNonNull(amount).setScale(currency.getScale(), currency.getRoundingMode());
        this.amount = null;
    }

    public Money add(Money other) {
        assertSameCurrency(other);
        return new Money(amount.add(other.amount), currency);
    }

    public Money subtract(Money other) {
        assertSameCurrency(other);
        return new Money(amount.subtract(other.amount), currency);
    }

    private void assertSameCurrency(Money other) {
        if (!other.currency.equals(this.currency)) {
            throw new IllegalArgumentException("Money objects must have the same currency");
        }
    }

    public boolean equals(Object o) {
        // Check that the currency and amount are the same
        return false;
    }

    public int hashCode() {
        // Calculate hash code based on currency and amount
        return -1;
    }

    public int compareTo(Money other) {
        // Compare based on currency and amount
        return -1;
    }
}
