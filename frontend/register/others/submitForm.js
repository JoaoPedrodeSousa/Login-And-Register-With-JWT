import handleError from "./handleError.js";

const form = document.querySelector(".form-div");
const url = "http://localhost:8080/auth/register";

export default async function submitForm(event) {
  event.preventDefault();

  const formData = new FormData(form);
  const data = Object.fromEntries(formData);

  try {
    const response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });

    if (response.status === 400) {
      throw new Error(
        `User with name ${formData.get("username")} already exists`
      );
    } else if (response.status !== response.ok) {
      throw new Error(`It's not possible init`);
    }
  } catch (error) {
    handleError(form, error);
  }
}
