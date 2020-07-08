package sls.grupo.globo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import sls.grupo.globo.entity.SignatureImplDTO;
import sls.grupo.globo.service.SignatureClient;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
@EnableFeignClients
public class App implements CommandLineRunner {

    @Autowired
    SignatureClient client;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        sendRequest();
    }

    private void sendRequest() {
        try {
            createListJson().forEach(signatureJson -> {
                try {
                    SignatureImplDTO signatureImplDTO = createSignature(signatureJson);
                    this.client.createSignature(signatureImplDTO);
                } catch (JsonProcessingException e) {
                    log.error("IOException", e);
                }
            });
        } catch (IOException e) {
            log.error("IOException", e);
        }
    }

    private List<String> createListJson() throws IOException {
        Resource resource = new ClassPathResource("data.txt");
        InputStream inputStream = resource.getInputStream();
        byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
        String data = new String(bdata, StandardCharsets.UTF_8);
        String[] textoSeparado = data.split(";");
        return Arrays.asList(textoSeparado);
    }

    private SignatureImplDTO createSignature(String signatureJson) throws JsonProcessingException {
        return new ObjectMapper().readValue(signatureJson, SignatureImplDTO.class);
    }
}
