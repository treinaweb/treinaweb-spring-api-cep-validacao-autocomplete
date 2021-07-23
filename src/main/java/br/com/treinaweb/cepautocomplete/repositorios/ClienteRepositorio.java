package br.com.treinaweb.cepautocomplete.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.cepautocomplete.entidades.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
