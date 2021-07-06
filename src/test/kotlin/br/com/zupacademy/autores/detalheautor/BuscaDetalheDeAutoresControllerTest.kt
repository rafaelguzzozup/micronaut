package br.com.zupacademy.autores.detalheautor

import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
internal class BuscaDetalheDeAutoresControllerTest {

    @field:Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    internal fun `deve retornar os detalhes de um autor`() {
        val response = client.toBlocking().exchange("autores?email=teste@teste", DetalhesDoAutorResponse::class.java)
        assertEquals(HttpStatus.OK, response.status)
        assertNotNull(response.body)
    }
}