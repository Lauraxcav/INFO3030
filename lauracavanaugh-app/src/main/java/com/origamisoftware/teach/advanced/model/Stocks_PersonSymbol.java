package com.origamisoftware.teach.advanced.model;

import javax.persistence.*;

/**
 * Models a table the combines stocks_person and a symbol
 * @author Laura Cavanaugh
 */
@Entity
@Table(name = "person_symbol", catalog = "stocks")
public class Stocks_PersonSymbol {
    private int id;
    private Stocks_Person stocksPerson;
    private String symbol;

    /**
     * Create a PersonSymbol that needs to be initialized - Hibernate requires an empty constructor
     */
    public Stocks_PersonSymbol() {
        // this empty constructor is required by hibernate framework
    }

    /**PersonSymbol
     * Create a valid PersonHobby
     *
     * @param stocksPerson the stocksPerson to assign the symbol to
     * @param symbol  the symbol to associate the stocksPerson with
     */
    public Stocks_PersonSymbol(Stocks_Person stocksPerson, String symbol) {
        setSymbol(symbol);
        setStocksPerson(stocksPerson);
    }

    /**
     * Primary Key - Unique ID for a particular row in the person_hobby table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the person_hobby table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return get the Person associated with this symbol
     */
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "ID", nullable = false)
    public Stocks_Person getStocksPerson() {
        return stocksPerson;
    }

    /**
     * Specify the Person associated with the hobby.
     *
     * @param stocksPerson a person instance
     */
    public void setStocksPerson(Stocks_Person stocksPerson) {
        this.stocksPerson = stocksPerson;
    }

       
    /**
     *
     * @return the person's symbol
     */
    @Basic
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true, length = 10)
    public String getSymbol() {
        return symbol;
    }

    /**
     * Specify the symbol associated with the Person.
     *
     * @param symbol a stock symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stocks_PersonSymbol that = (Stocks_PersonSymbol) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + stocksPerson.hashCode();
        result = 31 * result + symbol.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PersonSymbol{" +
                "id=" + id +
                ", stocks_person=" + stocksPerson +
                ", symbol=" + symbol +
                '}';
    }
}
