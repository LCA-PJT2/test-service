package com.lca2.testservice;

import com.lca2.testservice.web.context.GatewayRequestHeaderUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<String> testGatewayHeaders() {
        String userId = GatewayRequestHeaderUtils.getUserId();

        if (userId == null) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(userId);
    }
}
