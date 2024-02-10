const btn = document.querySelector("button");
const inputUsername = document.querySelector(".input-username");
const inputPassword = document.querySelector(".input-password");
const inputRole = document.querySelector(".input-role");
const url = "http://localhost:8080/auth/register";

const form = document.querySelector(".form-div");

btn.addEventListener("click", async (event) => {
  event.preventDefault();

  const formData = new FormData(form);

  const data = {};
  formData.forEach((value, key) => {
    data[key] = value;
  });

  await fetch(url, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  })
    .then((response) => {
      return response.status;
    })
    .then((data) => {
      console.log("Dados recebidos:", data);
    })
    .catch((error) => {
      console.error("Erro:", error);
    });
});
