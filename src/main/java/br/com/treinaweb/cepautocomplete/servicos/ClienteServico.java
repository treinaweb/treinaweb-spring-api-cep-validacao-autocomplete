package br.com.treinaweb.cepautocomplete.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinaweb.cepautocomplete.entidades.Cliente;
import br.com.treinaweb.cepautocomplete.excecoes.ClienteNaoEncontradoException;
import br.com.treinaweb.cepautocomplete.repositorios.ClienteRepositorio;

@Service
public class ClienteServico {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> buscarTodos() {
        return clienteRepositorio.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepositorio.findById(id)
            .orElseThrow(() -> new ClienteNaoEncontradoException(id));
    }

    public Cliente cadastrar(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    public Cliente editar(Cliente cliente, Long id) {
        buscarPorId(id);

        cliente.setId(id);
        return clienteRepositorio.save(cliente);
    }

    public void excluirPorId(Long id) {
        Cliente cliente = buscarPorId(id);

        clienteRepositorio.delete(cliente);
    }

}
