package sls.grupo.globo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import sls.grupo.globo.entity.SignatureImplDTO;

@FeignClient(url="desafio-globo:8080/", name = "signature")
public interface SignatureClient {

    @PostMapping("/signature")
    ResponseEntity<?> createSignature(SignatureImplDTO signature);
}
