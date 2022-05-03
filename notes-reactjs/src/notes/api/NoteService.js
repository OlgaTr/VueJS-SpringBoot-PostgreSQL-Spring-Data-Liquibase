import axios from 'axios';

const BASE_URL = "http://localhost:8091/notes"

function listNotes() {
    return axios.get(BASE_URL);
}

export {
    BASE_URL, listNotes
};