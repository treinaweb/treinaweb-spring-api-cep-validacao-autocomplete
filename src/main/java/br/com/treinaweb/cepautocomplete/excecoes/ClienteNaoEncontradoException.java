package br.com.treinaweb.cepautocomplete.excecoes;

import javax.persistence.EntityNotFoundException;

public class ClienteNaoEncontradoException extends EntityNotFoundException {

    public ClienteNaoEncontradoException(Long id) {
        super(String.format("Cliente com o ID %d não foi encontrado.", id));
    }

}
