package sqch11ex2.proxy;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import sqch11ex2.dto.Payment;

@Component
public class PaymentsProxy {
	private final RestTemplate template;
	
	public PaymentsProxy(RestTemplate template) {
		super();
		this.template = template;
	}

	public Payment createPayment(Payment payment) {
		String uri = paymentServiceUrl + "/payment";
		
		var headers = new HttpHeaders();
		headers.add("requestId", UUID.randomUUID().toString());
		
		var httpEntity = new HttpEntity<>(payment, headers);
		var response = template.exchange(
				uri, HttpMethod.POST, httpEntity, Payment.class);
		
		return response.getBody();
	}
	
	@Value("${name.service.url}")
	private String paymentServiceUrl;

}
