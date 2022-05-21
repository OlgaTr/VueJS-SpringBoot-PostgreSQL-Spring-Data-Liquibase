import axios from "axios";

const BASE_URL = "http://localhost:8090";

function registerNewUser(user) {
    return axios.post(`${BASE_URL}/users`, user);
}

export {
    BASE_URL, registerNewUser
}