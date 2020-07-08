package sls.grupo.globo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import sls.grupo.globo.entity.AuditSignatureDTO;
import sls.grupo.globo.entity.AuditSignatureVO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditSignatureImplVO implements AuditSignatureVO {

    private HttpStatus httpStatus;

    private String httpText;

    List<AuditSignatureDTO> list;
}
