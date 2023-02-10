package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.json.JSONObject;

import com.github.javafaker.Faker;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class PostSteps {

	@SuppressWarnings("unused")
	private Scenario scenario;
	private Response response;
	private final String BASE_URL = "https://reqres.in";
	ValidatableResponse validatableResponse;

	Faker faker = new Faker();

	String name = faker.name().firstName();
	String job = faker.job().title();

	@Before
	public void before(Scenario scenarioVal) {
		this.scenario = scenarioVal;
	}

	@Dado("que a requisicao de criacao foi feita")
	public void que_a_requisicao_de_criacao_foi_feita() {
		RestAssured.baseURI = BASE_URL + "/api/users";
		JSONObject jsonObj = new JSONObject().put("name", name)
											 .put("job", job);

		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		request.body(jsonObj.toString());

		response = request.post();
	}

	@Entao("validar a criacao")
	public void validar_a_criacao() {
		String userName = response.path("name");
		String userJob = response.path("job");
		String createdAt = response.path("createdAt");
		String userId = response.path("ud");

		assertEquals(userName, name);
		assertEquals(userJob, job);
		assertNotNull(createdAt, true);
		assertNotNull(userId, true);
	}
}
