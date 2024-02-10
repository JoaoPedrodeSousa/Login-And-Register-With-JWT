const btn = document.querySelector("button");
const inputUsername = document.querySelector(".input-username");
const inputPassword = document.querySelector(".input-password");
const inputRole = document.querySelector(".input-role");
const url = "http://localhost:8080/auth/register";

const form = document.querySelector(".form-div");

function clearPassword() {
  const inputs = form.querySelectorAll("input");

  inputs.forEach((input) => {
    const password = input.getAttribute("type");

    if (password === "password") {
      input.value = "";
    }
  });
}

function handleUsernameExists() {
  const inputUsername = document.querySelector(".input-username");
  inputUsername.classList.add("usernameError");

  const span = document.createElement("span");
  span.innerText = "Usuário já existe";
}

form.addEventListener("submit", async (event) => {
  event.preventDefault();

  const formData = new FormData(form);
  const data = Object.fromEntries(formData);

  const response = await fetch(url, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  })
    .then((response) => {
      if (response.status === 400) {
        throw new Error(`User with name ${formData.get("username")}`);
      }

      return response.ok;
    })
    .then((data) => {
      console.log("Dados recebidos:", data);
    })
    .catch((error) => {
      clearPassword();
      handleUsernameExists();
      console.error(error);
    });
});
