package Enoca.demo.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {

	
	private int id;

	private String createDate;

	private double totalPrice;
	
	private int customer_Id;
}
