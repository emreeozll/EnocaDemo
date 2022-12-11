package Enoca.demo.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {

	

	private String createDate;

	private double totalPrice;
	
	private int customer_Id;
	
}
