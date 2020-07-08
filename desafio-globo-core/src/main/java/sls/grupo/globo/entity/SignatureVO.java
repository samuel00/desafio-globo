package sls.grupo.globo.entity;

import org.springframework.http.HttpStatus;

import java.util.List;

public interface SignatureVO {
	
	HttpStatus getHttpStatus();
	
	String getHttpText();

	List<SignatureDTO> getList();

}
