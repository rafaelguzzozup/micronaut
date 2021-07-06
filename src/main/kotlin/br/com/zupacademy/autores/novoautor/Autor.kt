package br.com.zupacademy.autores.novoautor

import br.com.zupacademy.autores.atualizaautor.Endereco
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Autor(
    val nome: String,
    val email: String,
    var descricao: String,
    val paraEndereco: Endereco
) {

    @Id
    @GeneratedValue
    var id: Long? = null

    val criadoEm: LocalDateTime = LocalDateTime.now()
}