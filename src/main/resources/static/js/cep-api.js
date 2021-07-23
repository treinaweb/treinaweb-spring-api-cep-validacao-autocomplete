$("#cep").mask("00000-000");

let cep = document.getElementById("cep");

cep.addEventListener("keyup", function (event) {
  if (cep.value.length == 9) {
    autoComplete(cep.value);
  }
});

function autoComplete(cep) {
  let url = `http://localhost:8080/cep/${cep}`;

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
