import submitForm from "./others/submitForm.js";

// const form = document.querySelector(".form-container");
// form.addEventListener("submit", submitForm);

const btn = document.querySelector(".btn");
btn.addEventListener("click", teste);

const flip = document.querySelector(".flip-inner");

function teste(event) {
  event.preventDefault();
  flip.style.transform = "rotateY(180deg)";
}

// Colocar a classe outer em ambos e quando o usuário clicar no botão alterar o display de none para block
