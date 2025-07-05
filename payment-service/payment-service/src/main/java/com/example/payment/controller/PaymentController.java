package com.example.payment.controller;

import com.example.payment.model.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final RestTemplate restTemplate;

    @Value("${user.service.url}")
    private String userServiceUrl;

    @PostMapping
    public ResponseEntity<String> makePayment(@RequestBody PaymentRequest request,
                                              @RequestHeader("Authorization") String authHeader) {
        if (!isAuthorized(authHeader)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
        }

        return ResponseEntity.ok("تم الدفع بنجاح للدورة: " + request.getCourseId());
    }

    private boolean isAuthorized(String authHeader) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authHeader);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                userServiceUrl + "/auth/validate", HttpMethod.GET, entity, String.class
            );
            return response.getStatusCode() == HttpStatus.OK;
        } catch (Exception e) {
            return false;
        }
    }
}
