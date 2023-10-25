package sqch11ex2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sqch11ex2.dto.Payment;
import sqch11ex2.proxy.PaymentsProxy;

@RestController
@AllArgsConstructor
public class PaymentsController {
	
	private final PaymentsProxy proxy;
	
	@PostMapping("/payment")
	public Payment processPayment(@RequestBody Payment payment) {
		return proxy.createPayment(payment);
	}

}
