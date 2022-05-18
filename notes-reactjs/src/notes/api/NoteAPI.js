import axios from 'axios';
import React from "react";

const BASE_URL = "http://localhost:8090"

function addNote(user, note) {
    return axios.post(`${BASE_URL}/notebooks/notes`, note,
        {auth: {
                username: user.username,
                password: user.password
            }});
}

function deleteNote(user, noteId) {
    return axios.delete(`${BASE_URL}/notes/${noteId}`,
        {auth: {
                username: user.username,
                password: user.password}});
}

function getNote(user, noteId) {
    return axios.get(`${BASE_URL}/notes/${noteId}`,
        {auth: {
                username: user.username,
                password: user.password}});
}

function listNotes(user) {
    return axios.get(`${BASE_URL}/notebooks/notes`,
        {auth: {
                username: user.username,
                password: user.password}});
}

export {
    BASE_URL, addNote, getNote, deleteNote, listNotes
};