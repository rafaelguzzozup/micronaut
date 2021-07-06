package br.com.zupacademy.autores.novoautor

import br.com.zupacademy.autores.buscacep.EnderecoResponse
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class NovoAutorRequest(
    @field:NotBlank val nome: String,
    @field:NotBlank @field:Email @field:EmailUnico val email: String,
    @field:NotBlank @field:Size(max = 400) val descricao: String,
    @field:NotBlank val cep: String
) {
    fun paraAutor(enderecoResponse: EnderecoResponse): Autor {

        return Autor(nome, email, descricao, enderecoResponse.paraEndereco())
    }
}


