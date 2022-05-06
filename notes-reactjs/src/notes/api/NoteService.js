import axios from 'axios';

const BASE_URL = "http://localhost:8091/notebooks/notes/1"

function listNotes() {
    return axios.get(BASE_URL);
}

export {
    BASE_URL, listNotes
};