/* Author: Brett Dawson
* Data model class for the 'units' table in the atVenu database
*/
package model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "units")
public class Unit {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Prod_Id", nullable = false)
    private Integer Prod_Id;

    @Column(name = "Units_Sold", nullable = false)
    private Integer unitsSold;

    @Column(name = "Unit_Price", nullable = false, precision = 10)
    private BigDecimal unitPrice;

    @Column(name = "Prod_Desc", nullable = false, length = 100)
    private String prodDesc;

    @Column(name = "Total_Sales", nullable = false, precision = 10)
    private BigDecimal totalSales;

    @Column(name = "Qty_Avail", nullable = false)
    private Integer qtyAvail;

    public Integer getId() {
        return Prod_Id;
    }

    public void setId(Integer id) {
        this.Prod_Id = id;
    }

    public Integer getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(Integer unitsSold) {
        this.unitsSold = unitsSold;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    public Integer getQtyAvail() {
        return qtyAvail;
    }

    public void setQtyAvail(Integer qtyAvail) {
        this.qtyAvail = qtyAvail;
    }
}