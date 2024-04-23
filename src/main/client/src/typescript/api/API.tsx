import axios from "axios";
const ENVIRONMENT = (process.env.NODE_ENV || "development")
const DOMAIN = (ENVIRONMENT !== "production") ? "http://localhost:8081/" : "production"; // TODO: add production endpoint.

const API = {
  get: (path: string) => {
    return axios.get(DOMAIN + path);
  },
  post: (path: string, data: any = {}) => {
    return axios.post(DOMAIN + path, data);
  },
  put: (path: string, data: any = {}) => {
    return axios.put(DOMAIN + path, data);
  },
  delete: (path: string) => {
    return axios.delete(DOMAIN + path);
  }
}

export default API;
