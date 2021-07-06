package br.com.zupacademy.autores.buscacep

import br.com.zupacademy.autores.atualizaautor.Endereco

data class EnderecoResponse(
    val cep: String,
    val logradouro: String,
    val complemento: String,
    val bairro: String,
    val localidade: String,
    val uf: String,
    val ibge: String,
    val gia: String,
    val ddd: String,
    val siafi: String
){
    fun paraEndereco(): Endereco{
       return Endereco(cep, logradouro, complemento, bairro, uf, localidade)
    }
}
