package sls.grupo.globo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignatureImplVO {

	private HttpStatus httpStatus;

	private String httpText;

	private SignatureImplDTO signatureDTO;

}
