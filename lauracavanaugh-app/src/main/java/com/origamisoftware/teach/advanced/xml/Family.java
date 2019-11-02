
package com.origamisoftware.teach.advanced.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}father"/>
 *         &lt;element ref="{}mother"/>
 *         &lt;element ref="{}kids"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "father",
    "mother",
    "kids"
})
@XmlRootElement(name = "family")
public class Family implements XMLDomainObject {

    @XmlElement(required = true)
    protected Father father;
    @XmlElement(required = true)
    protected Mother mother;
    @XmlElement(required = true)
    protected Kids kids;

    /**
     * Gets the value of the father property.
     * 
     * @return
     *     possible object is
     *     {@link Father }
     *     
     */
    public Father getFather() {
        return father;
    }

    /**
     * Sets the value of the father property.
     * 
     * @param value
     *     allowed object is
     *     {@link Father }
     *     
     */
    public void setFather(Father value) {
        this.father = value;
    }

    /**
     * Gets the value of the mother property.
     * 
     * @return
     *     possible object is
     *     {@link Mother }
     *     
     */
    public Mother getMother() {
        return mother;
    }

    /**
     * Sets the value of the mother property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mother }
     *     
     */
    public void setMother(Mother value) {
        this.mother = value;
    }

    /**
     * Gets the value of the kids property.
     * 
     * @return
     *     possible object is
     *     {@link Kids }
     *     
     */
    public Kids getKids() {
        return kids;
    }

    /**
     * Sets the value of the kids property.
     * 
     * @param value
     *     allowed object is
     *     {@link Kids }
     *     
     */
    public void setKids(Kids value) {
        this.kids = value;
    }


    @Override
    public String toString() {
        return "Family{" +
                "father=" + father +
                ", mother=" + mother +
                ", kids=" + kids +
                '}';
    }
}
