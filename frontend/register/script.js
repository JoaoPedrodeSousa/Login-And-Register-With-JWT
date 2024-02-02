const btn = document.querySelector(".btn");
const inputs = document.querySelectorAll("input");

const array = [];

function redirect(url) {
  window.location.href = url;
}

function isUnique(username) {
  if (array.includes(username)) {
    inputs[0].classList.add("usernameError");
    inputs[0].setAttribute(
      "placeholder",
      "Username exists, please, replace Username and try again"
    );
    return false;
  }
}

function handleBtnClick(event) {
  event.preventDefault();

  const objeto = {
    username: null,
    password: null,
  };

  const username = inputs[0].value;
  const password = inputs[1].value;

  if (isUnique(username)) {
    objeto.username = username;
    objeto.password = password;
    array.array.push(objeto);
  }
}

btn.addEventListener("click", handleBtnClick);
