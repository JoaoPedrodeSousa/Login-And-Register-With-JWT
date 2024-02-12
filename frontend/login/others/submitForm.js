import handleError from "./handleError.js";
import flipCard from "./flipCard.js";

const form = document.querySelector(".form-container");
const url = "http://localhost:8080/auth/login";

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

    if (response.status === 403) {
      throw new Error(`User with name ${formData.get("username")} not exists`);
    } else if (response.ok) {
      flipCard();
      console.log(document.cookie);
    }
  } catch (error) {
    handleError(form, error);
  }
}
