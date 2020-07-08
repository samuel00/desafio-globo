package sls.grupo.globo.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sls.grupo.globo.entity.SignatureDTO;
import sls.grupo.globo.entity.SignatureVO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignatureImplVO implements SignatureVO {

	private HttpStatus httpStatus;

	private String httpText;

	private List<SignatureDTO> list;
}
