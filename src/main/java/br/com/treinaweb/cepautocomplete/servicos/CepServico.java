package br.com.treinaweb.cepautocomplete.servicos;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.treinaweb.cepautocomplete.dto.WebmaniaResponse;

@Service
public class CepServico {

    private static final String URL_TEMPLATE = "https://webmaniabr.com/api/1/cep/%s/?app_key=kxElXziZEeTKXOMJsykkwAQy398NLtyy&app_secret=pB7tRy8NoJtwScOmXtHYTVfqOi7h8SCIZhg4mlj1GQTubQZn";

    public WebmaniaResponse consultar(String cep) {
        String url = String.format(URL_TEMPLATE, cep);

        RestTemplate restTemplate = new RestTemplate();
        WebmaniaResponse response = restTemplate.getForObject(url, WebmaniaResponse.class);

        return response;
    }

    public boolean validar(String cep) {
        WebmaniaResponse response = consultar(cep);

        return response.getCep() != null;
    }

}
