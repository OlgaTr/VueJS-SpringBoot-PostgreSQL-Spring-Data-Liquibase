import axios from 'axios';

const BASE_URL = "http://localhost:8090"

function addNote(note) {
    return axios.post(`${BASE_URL}/notebooks/1/notes`, note)
}

function deleteNote(noteId) {
    return axios.delete(`${BASE_URL}/notes/${noteId}`);
}

function listNotes() {
    return axios.get(`${BASE_URL}/notebooks/1/notes`);
}

export {
    BASE_URL, addNote, deleteNote, listNotes
};