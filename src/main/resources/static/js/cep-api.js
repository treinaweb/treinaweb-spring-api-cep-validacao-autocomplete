$("#cep").mask("00000-000");

let cep = document.getElementById("cep");

cep.addEventListener("keyup", function (event) {
  if (cep.value.length == 9) {
    autoComplete(cep.value);
  }
});

function autoComplete(cep) {
  let url = `https://webmaniabr.com/api/1/cep/${cep}/?app_key=kxElXziZEeTKXOMJsykkwAQy398NLtyy&app_secret=pB7tRy8NoJtwScOmXtHYTVfqOi7h8SCIZhg4mlj1GQTubQZn`;

  fetch(url).then(function (response) {
    if (response.ok) {
      response.json().then(function (endereco) {
        document.getElementById("logradouro").value = endereco.endereco;
        document.getElementById("bairro").value = endereco.bairro;
        document.getElementById("cidade").value = endereco.cidade;
        document.getElementById("estado").value = endereco.uf;
      });
    }
  });
}
