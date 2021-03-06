package sls.grupo.globo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sls.grupo.globo.entity.Messageria;
import sls.grupo.globo.entity.Signature;
import sls.grupo.globo.entity.SignatureDTO;
import sls.grupo.globo.entity.Subscription;
import sls.grupo.globo.repository.SignatureRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SignatureService {

    @Autowired
    private Messageria messageria;

    @Autowired
    private SignatureRepository signatureRepository;

    public void sendSignature(Signature signature) {
        log.info("Signature {}", signature);
        messageria.send(signature);
    }

    public List <SignatureDTO> findAll() {
        List<SignatureDTO> list = new ArrayList();
        Iterable<Subscription> iterable = this.signatureRepository.findAll();
        for (SignatureDTO signatureDTO : iterable){
            list.add(signatureDTO);
        }
        log.info("List Find All {}", list);
        return list;
    }
}
