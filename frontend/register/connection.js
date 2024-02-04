import axios from "axios";

function axiosC(userData) {
  axios
    .post("http://localhost:8080/auth/register", userData, {
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
    })
    .then((response) => {
      console.log("User created successfully:", response.data);
      // Aqui você pode adicionar qualquer outra lógica de manipulação de resposta, redirecionamento, etc.
    })
    .catch((error) => {
      console.error("Error creating user:", error);
      // Lidar com erros de criação de usuário aqui
    });
}

export default axiosC;
