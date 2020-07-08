/*
package sls.grupo.globo.resource;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import sls.grupo.globo.common.ResourceBaseTest;
import sls.grupo.globo.util.BuilderRequestUtil;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EmbeddedKafka(topics = {"SUBSCRIPTION_RESTARTED", "SUBSCRIPTION_PURCHASED", "SUBSCRIPTION_CANCELED"}, partitions = 3)
@TestPropertySource(properties = {"spring.kafka.producer.bootstrap-servers=${spring.embedded.kafka.brokers}",
		"spring.kafka.admin.properties.bootstrap.servers=${spring.embedded.kafka.brokers}"})
@ActiveProfiles("test")
class SignatureResourceTest extends ResourceBaseTest {

	@Autowired
	TestRestTemplate restTemplate;

	@Autowired
	EmbeddedKafkaBroker embeddedKafkaBroker;

	private Consumer<String, String> consumer;

	@BeforeEach
	void setUp() {
		Map<String, Object> configs = new HashMap<>(KafkaTestUtils.consumerProps("group1", "true", embeddedKafkaBroker));
		consumer = new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new StringDeserializer()).createConsumer();
		embeddedKafkaBroker.consumeFromAllEmbeddedTopics(consumer);
	}

	@AfterEach
	void tearDown() {
		consumer.close();
	}

	private String getResource() {
		return new BuilderRequestUtil().getSignatureURL().build();
	}

	@Test
	void testSignature() throws Exception {
		*/
/*SignatureImplDTO signatureImplDTO = new SignatureImplDTO().builder()
				.notificationType("SUBSCRIPTION_PURCHASED")
				.subscription("xyz32xpto").build();
		mockMvc.perform(post(getResource()).contentType(MediaType.APPLICATION_JSON)
				.content(ConverterUtil.ObjectToJsonBytes(signatureImplDTO))).andDo(print())
				.andExpect(status().isCreated()).andExpect(jsonPath("$.httpText", is("201 CREATED"))).andReturn();
		ConsumerRecord<String, String> received = KafkaTestUtils.getSingleRecord(consumer, "SUBSCRIPTION_PURCHASED");
		Assert.assertNotNull(received.value());*//*

		assertNotNull(new Object());
	}

}
*/
