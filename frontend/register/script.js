const btn = document.querySelector(".btn");
const inputs = document.querySelectorAll("input");

const users = [];

function redirect(url) {
  window.location.href = url;
}

function isUnique(username) {
  console.log("oi");
  if (users.includes(username)) {
    inputs[0].classList.add("usernameError");

    inputs[0].setAttribute(
      "placeholder",
      "Username exists, please, replace Username and try again"
    );
    return;
  }
  return true;
}

function newUser(username, password) {
  return {
    username: username,
    password: password,
  };
}

function handleBtnClick(event) {
  event.preventDefault();

  const username = inputs[0].value;
  const password = inputs[1].value;

  if (isUnique(username)) {
    const user = newUser(username, password);
    users.push(user);
  }
  console.log(users);
}

btn.addEventListener("click", handleBtnClick);
