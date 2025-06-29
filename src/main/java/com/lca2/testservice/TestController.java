package com.lca2.testservice;

import com.lca2.testservice.web.context.GatewayRequestHeaderUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    @GetMapping("/healthy")
    public ResponseEntity<String> testGatewayHeaders() {
        log.info("test gateway routing");

        String userId = GatewayRequestHeaderUtils.getUserId();

        if (userId == null) {
            return ResponseEntity.ok("null");
        }
        return ResponseEntity.ok(userId);
    }
}
