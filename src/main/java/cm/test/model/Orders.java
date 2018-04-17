package cm.test.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;


@Entity
@Table(name = "orders")
/*@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
*/
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer OrderId;
    private Integer CustId;
    private Integer ProdId;
    private Integer Qty;
    private Integer Rate;
    private Integer ReturnDate;
	public Integer getOrderId() {
		return OrderId;
	}
	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}
	public Integer getCustId() {
		return CustId;
	}
	public void setCustId(Integer custId) {
		CustId = custId;
	}
	public Integer getProdId() {
		return ProdId;
	}
	public void setProdId(Integer prodId) {
		ProdId = prodId;
	}
	public Integer getQty() {
		return Qty;
	}
	public void setQty(Integer qty) {
		Qty = qty;
	}
	public Integer getRate() {
		return Rate;
	}
	public void setRate(Integer rate) {
		Rate = rate;
	}
	public Integer getReturnDate() {
		return ReturnDate;
	}
	public void setReturnDate(Integer returnDate) {
		ReturnDate = returnDate;
	}
	  

}
