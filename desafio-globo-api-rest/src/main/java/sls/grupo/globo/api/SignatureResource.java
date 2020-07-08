package sls.grupo.globo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sls.grupo.globo.anotation.AuditExecutionTime;
import sls.grupo.globo.dto.SignatureImplDTO;
import sls.grupo.globo.dto.SignatureImplVO;
import sls.grupo.globo.entity.Signature;
import sls.grupo.globo.service.SignatureService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;

@RestController
@RequestMapping("/signature")
public class SignatureResource {

    @Autowired
    private SignatureService service;

    @PostMapping
    @AuditExecutionTime
    public ResponseEntity<?> createSignature(@Valid @RequestBody SignatureImplDTO signature,
                                             HttpServletRequest request) {
        this.service.sendSignature(new Signature().builder()
                .notificationType(signature.getNotificationType())
                .subscription(signature.getSubscription())
                .build());
        return new ResponseEntity<>(new SignatureImplVO().builder().httpStatus(HttpStatus.CREATED)
        		.httpText(HttpStatus.CREATED.toString()).list(Arrays.asList(signature)).build(), HttpStatus.CREATED);
    }
    
    @PutMapping
    @AuditExecutionTime
    public ResponseEntity<?> updateSignature(@Valid @RequestBody SignatureImplDTO signature,
                                             HttpServletRequest request) {
        this.service.sendSignature(new Signature().builder()
                .notificationType(signature.getNotificationType())
                .subscription(signature.getSubscription())
                .build());
        return new ResponseEntity<>(new SignatureImplVO().builder().httpStatus(HttpStatus.OK)
        		.httpText(HttpStatus.OK.toString()).list(Arrays.asList(signature)).build(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAll(HttpServletRequest request) {
        return new ResponseEntity<>(new SignatureImplVO().builder().httpStatus(HttpStatus.OK)
                .httpText(HttpStatus.OK.toString()).list(this.service.findAll()).build(), HttpStatus.OK);
    }


}
