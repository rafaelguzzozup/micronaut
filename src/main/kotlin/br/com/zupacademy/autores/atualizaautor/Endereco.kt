package br.com.zupacademy.autores.atualizaautor

import javax.persistence.Embeddable

@Embeddable
class Endereco(
    val cep: String,
    val logradouro: String,
    val complemento: String,
    val bairro: String,
    val uf: String,
    val localidade: String
) {
}