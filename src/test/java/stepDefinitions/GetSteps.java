package stepDefinitions;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetSteps {

	@SuppressWarnings("unused")
	private Scenario scenario;
	private Response response;
	private ResponseBody<?> resBody;
	private final String BASE_URL = "https://reqres.in";

	@Before
	public void before(Scenario scenarioVal) {
		this.scenario = scenarioVal;
	}

	@Dado("que a chamada foi realizada")
	public void que_a_chamada_foi_realizada() {
		RestAssured.baseURI = BASE_URL + "/api/users/2";
		RequestSpecification req = RestAssured.given();
		response = req.when().get();
	}

	@Entao("validar o retorno de somente um {string}")
	public void validar_o_retorno_de_somente_um(String usuario) {
		int responseCode = response.then().extract().statusCode();

		resBody = response.body();
		String bodyAsString = resBody.asString();

		assertEquals(responseCode, 200);
		assertEquals(bodyAsString.contains(usuario), true);
	}
	
	@Dado("que a chamada da listagem foi realizada")
	public void que_a_chamada_da_listagem_foi_realizada() {
		RestAssured.baseURI = BASE_URL + "/api/users?page=1";
		RequestSpecification req = RestAssured.given();
		response = req.when().get();
	}
	
	@Entao("validar quantidade {int} de usuarios por pagina {int}")
	public void validar_quantidade_de_usuarios_por_pagina(int quantidade, int pagina) {
		
		int page = response.path("page");
		int qtdPorPagina = response.path("per_page");
		int httpCode = response.getStatusCode();

		assertEquals(httpCode, 200);
		assertEquals(page, pagina);
		assertEquals(qtdPorPagina, quantidade);
	}
}
