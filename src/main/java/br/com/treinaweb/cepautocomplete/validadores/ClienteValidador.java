package br.com.treinaweb.cepautocomplete.validadores;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.treinaweb.cepautocomplete.entidades.Cliente;
import br.com.treinaweb.cepautocomplete.servicos.CepServico;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClienteValidador implements Validator {

    private CepServico cepServico;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Cliente.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Cliente cliente = (Cliente) target;

        if (cliente.getCep() != null && !cliente.getCep().isEmpty()) {
            if (!cepServico.validar(cliente.getCep())) {
                errors.rejectValue("cep", "cliente.cep.invalido");
            }
        }
    }

}
