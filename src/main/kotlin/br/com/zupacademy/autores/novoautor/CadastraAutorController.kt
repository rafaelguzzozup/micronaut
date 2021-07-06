package br.com.zupacademy.autores.novoautor

import br.com.zupacademy.autores.buscacep.EnderecoClient
import br.com.zupacademy.autores.buscacep.EnderecoResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/autores")
class CadastraAutorController(val autorRepository: AutorRepository, val enderecoClient: EnderecoClient) {

    @Post
    fun cadastra(@Body @Valid request: NovoAutorRequest): HttpResponse<Any> {
        println(request)

        val enderecoResponse: HttpResponse<EnderecoResponse> = enderecoClient.consulta(request.cep)

        val autor = request.paraAutor(enderecoResponse.body()!!)

        autorRepository.save(autor)

        val uri = UriBuilder.of("/autores/{id}").expand(mutableMapOf(Pair("id", autor.id)))
        println("Autor nome ${autor.nome}")

        return HttpResponse.created(uri)
    }

}