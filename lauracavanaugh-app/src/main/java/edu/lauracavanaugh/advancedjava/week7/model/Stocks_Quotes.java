package edu.lauracavanaugh.advancedjava.week7.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * This is my stocks.quotes ORM class.
 * Models the quotes table from the stocks database
 * So, I'm just using the same ORM as Person object; so, thank you for that.
 * @author Laura Cavanaugh
 */
@Entity
@Table(name="stocks.quotes")
public class Stocks_Quotes {

    private int id;
    private String symbol;
    private BigDecimal price;
    private Timestamp time;

    /**
     * Convert the String values to typed values
     * @param symbol
     * @param price
     * @param time
     */
    public Stocks_Quotes(String symbol, String price, String time) {
        this.symbol = symbol;
        this.price = new BigDecimal(price);
        this.time = Timestamp.valueOf(time);
    }

    /**
     * Primary Key - Unique ID for a particular row in the person table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the person table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return the person's first name
     */
    @Basic
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true, length = 4)
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol a String value
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * @return the person's last name
     */
    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true, length = 256)
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price a String value
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the quote's time.
     */
    @Basic
    @Column(name = "time", nullable = false, insertable = true, updatable = true)
    public Timestamp getTime() {
        return time;
    }

    /**
     * Specify the person's date of birth.
     * @param time  the time the person was born.
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stocks_Quotes quote = (Stocks_Quotes) o;

        if (id != quote.id) return false;
        if (time != null ? !time.equals(quote.time) : quote.time != null)
            return false;
        if (symbol != null ? !symbol.equals(quote.symbol) : quote.symbol != null)
            return false;
        if (price != null ? !price.equals(quote.price) : quote.price != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Stocs_Quote{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", price='" + price + '\'' +
                ", time=" + time +
                '}';
    }
}
