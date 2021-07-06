package br.com.zupacademy.autores.detalheautor

import br.com.zupacademy.autores.novoautor.Autor

class DetalhesDoAutorResponse(autor: Autor) {

    val id = autor.id
    val nome = autor.nome
    val email = autor.email
    val descricao = autor.descricao

}
