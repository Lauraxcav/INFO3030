package edu.lauracavanaugh.advancedjava.week7;

import com.origamisoftware.teach.advanced.xml.XMLDomainObject;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "symbol","price","time"
})
@XmlRootElement(name = "stock")
public class Stock implements XMLDomainObject {

    @XmlValue
    protected String content;

    @XmlAttribute(name = "symbol", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String symbol;

    @XmlAttribute(name = "price", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String price;

    @XmlAttribute(name = "time", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String time;

    /**
     * Gets the value of the content property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the age property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets the value of the age property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSymbol(String value) {
        this.symbol = value;
    }

    /**
     * Gets the value of the price property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPrice(String value) {
        this.price = value;
    }


    public String getTime() {
        return time;
    }
    public void setTime(String value) {
        this.time = value;
    }


    @Override
    public String toString() {
        return "Stock{" +
                "content='" + content + '\'' +
                ", symbol='" + symbol + '\'' +
                ", price='" + price + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
