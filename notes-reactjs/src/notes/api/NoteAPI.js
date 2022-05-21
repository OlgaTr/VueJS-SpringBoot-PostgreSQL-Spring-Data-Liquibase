import axios from 'axios';
import React from 'react';

const BASE_URL = "http://localhost:8090"

function addNote(cusername, cpassword, note) {
    return axios.post(`${BASE_URL}/notes`, note,
        {auth: {
                username: cusername,
                password: cpassword
            }});
}

function deleteNote(cusername, cpassword, noteId) {
    return axios.delete(`${BASE_URL}/notes/${noteId}`,
        {auth: {
                username: cusername,
                password: cpassword}});
}

function getNote(cusername, cpassword, noteId) {
    return axios.get(`${BASE_URL}/notes/${noteId}`,
        {auth: {
                username: cusername,
                password: cpassword}});
}

function listNotes(cusername, cpassword) {
    return axios.get(`${BASE_URL}/notes`,
        {auth: {
                username: cusername,
                password: cpassword}})
        .then(response => response.data);
}

export {
    BASE_URL, addNote, getNote, deleteNote, listNotes
};