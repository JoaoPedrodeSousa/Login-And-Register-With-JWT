const btn = document.querySelector("button");
const inputUsername = document.querySelector(".input-username");
const inputPassword = document.querySelector(".input-password");
const inputRole = document.querySelector(".input-role");
const url = "http://localhost:8080/auth/register";

const formEl = document.querySelector(".form-div");

formEl.addEventListener("submit", async (event) => {
  event.preventDefault();

  const formData = new FormData(formEl);

  const data = Object.fromEntries(formData);

  // Enviar os dados para o backend
  await fetch(url, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error(
          "Erro ao enviar os dados para o backend: " + response.status
        );
      }
      return response.json();
    })
    .then((data) => {
      console.log("Dados recebidos do backend:", data);
    })
    .catch((error) => {
      console.error("Erro:", error);
    });
});
