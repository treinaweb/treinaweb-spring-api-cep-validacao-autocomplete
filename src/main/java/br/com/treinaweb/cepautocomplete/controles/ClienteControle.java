package br.com.treinaweb.cepautocomplete.controles;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.treinaweb.cepautocomplete.entidades.Cliente;
import br.com.treinaweb.cepautocomplete.servicos.CepServico;
import br.com.treinaweb.cepautocomplete.servicos.ClienteServico;

@Controller
@RequestMapping("/clientes")
public class ClienteControle {

    @Autowired
    private ClienteServico clienteServico;

    @Autowired
    private CepServico cepServico;

    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("cliente/listar.html");

        modelAndView.addObject("clientes", clienteServico.buscarTodos());

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("cliente/formulario.html");

        modelAndView.addObject("cliente", new Cliente());

        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid Cliente cliente, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "cliente/formulario.html";
        }

        System.out.println(cepServico.consultar(cliente.getCep()));

        clienteServico.cadastrar(cliente);

        return "redirect:/clientes";
    }

    @GetMapping("/{id}/detalhes")
    public ModelAndView detalhes(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("cliente/detalhes.html");

        modelAndView.addObject("cliente", clienteServico.buscarPorId(id));

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("cliente/formulario.html");

        modelAndView.addObject("cliente", clienteServico.buscarPorId(id));

        return modelAndView;
    }

    @PostMapping("/{id}/editar")
    public String editar(@PathVariable Long id, @Valid Cliente cliente, BindingResult resultado, ModelMap model) {
        if (resultado.hasErrors()) {
            model.addAttribute("cliente", clienteServico.buscarPorId(id));
            return "cliente/formulario.html";
        }

        clienteServico.editar(cliente, id);

        return "redirect:/clientes";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        clienteServico.excluirPorId(id);

        return "redirect:/clientes";
    }

}
