import axios from "axios";

const BASE_URL = "http://localhost:8090"

function login(user) {
    return axios.post(`${BASE_URL}/login`, user)
}

function logout() {
    return axios.delete(`${BASE_URL}/logout`)
}

function registerNewUser(user) {
    return axios.post(`${BASE_URL}/users`, user);
}

function getCurrentUser() {
    return axios.get(`${BASE_URL}/login`)
}

export {
    BASE_URL, login, logout, registerNewUser, getCurrentUser
}