package sls.grupo.globo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sls.grupo.globo.dto.AuditSignatureImplVO;
import sls.grupo.globo.service.AuditService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/audit")
public class AuditResource {

    @Autowired
    private AuditService service;

    @GetMapping
    public ResponseEntity<?> findAll(HttpServletRequest request) {
        return new ResponseEntity<>(new AuditSignatureImplVO().builder().httpStatus(HttpStatus.OK)
                .httpText(HttpStatus.OK.toString()).list(this.service.findAll()).build(), HttpStatus.OK);
    }
}
