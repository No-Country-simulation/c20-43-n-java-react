import axios from "axios";

const api = axios.create({
  baseURL: "https://linguish.up.railway.app",
  // timeout: 1000,
});

export const getExercisesTrueFalse = async () => {
  const response = await api.get("exercise/find/all");
  return response.data;
};

// export const progress = async () => {
//   const response = await api.get("/progress/find/all");
//   return response.data
// };
