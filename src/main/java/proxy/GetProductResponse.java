package proxy;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Classe Java pour getProductResponse complex type.</p>
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 *
 * <pre>{@code
 * <complexType name="getProductResponse">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="return" type="{http://webservice.example.org/}product" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProductResponse", propOrder = {
        "productReturn"
})
public class GetProductResponse {

    @XmlElement(name = "return")
    protected Product productReturn;

    /**
     * Obtient la valeur de la propriété productReturn.
     *
     * @return
     *     possible object is
     *     {@link Product }
     *
     */
    public Product getProductReturn() {
        return productReturn;
    }

    /**
     * Définit la valeur de la propriété productReturn.
     *
     * @param value
     *     allowed object is
     *     {@link Product }
     *
     */
    public void setProductReturn(Product value) {
        this.productReturn = value;
    }
}
