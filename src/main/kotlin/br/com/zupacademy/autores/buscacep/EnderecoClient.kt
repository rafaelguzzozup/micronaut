package br.com.zupacademy.autores.buscacep

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client


@Client("https://viacep.com.br/ws")
interface EnderecoClient {

    @Get("/{cep}/json/")
    fun consulta(cep: String): HttpResponse<EnderecoResponse>

    @Get(value = "/{cep}/xml/", consumes = [MediaType.APPLICATION_XML])
    fun consultaXml(cep: String): HttpResponse<EnderecoResponse>
}