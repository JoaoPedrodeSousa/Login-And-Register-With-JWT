import handleError from "./handleError.js";
import flipCard from "./flipCard.js";

const form = document.querySelector(".form-container");
const btn = document.querySelector(".btn");
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
    } else if (response.ok) {
      flipCard();
    }
  } catch (error) {
    handleError(form, error);
  }
}
