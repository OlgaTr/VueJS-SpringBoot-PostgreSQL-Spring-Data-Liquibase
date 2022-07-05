import axios from "axios";

const BASE_URL = 'http://localhost:8090/notes';

class NotesApi {
    getNotes() {
        return axios.get(BASE_URL);
    }
}

export default new NotesApi();