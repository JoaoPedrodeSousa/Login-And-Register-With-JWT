function clearForm(form) {
  const inputs = form.querySelectorAll("input");

  inputs.forEach((input) => {
    input.value = "";
  });
}

export default function handleError(form, error) {
  clearForm(form);

  const inputUsername = form.querySelector(".input-username");
  inputUsername.classList.add("usernameError");

  window.alert(error);
}
