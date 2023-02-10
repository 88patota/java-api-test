package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.json.JSONObject;

import com.github.javafaker.Faker;

import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PatchSteps {

	@SuppressWarnings("unused")
	private Scenario scenario;
	private Response response;
	private final String BASE_URL = "https://reqres.in";
	ValidatableResponse validatableResponse;

	Faker faker = new Faker();

	String name = faker.name().firstName();
	String job = faker.job().title();

	@Dado("que a chamada para atualizar usuario foi realizada")
	public void que_a_chamada_para_atualizar_usuario_foi_realizada() {
		RestAssured.baseURI = BASE_URL + "/api/users/1";
		JSONObject jsonObj = new JSONObject().put("name", name).put("job", job);

		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		request.body(jsonObj.toString());

		response = request.patch();
	}

	@Entao("validar a atualizacao")
	public void validar_a_atualizacao() {
		String userName = response.path("name");
		String userJob = response.path("job");
		String updateAt = response.path("upodateAt");

		assertEquals(userName, name);
		assertEquals(userJob, job);
		assertNotNull(updateAt, true);
	}

}
