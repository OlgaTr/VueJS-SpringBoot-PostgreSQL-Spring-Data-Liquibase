import React, {useState} from 'react';
import Button from 'react-bootstrap/Button'
import {useNavigate} from "react-router-dom";
import {listNotes} from '../api/NoteService'
import {deleteNote} from "../api/NoteService";

function NotesList() {

    const navigate = useNavigate()
    const [notebook, setNotebook] = useState(1)
    const [notes, setNotes] = useState([])
    listNotes().then(result => {
            setNotes(result.data)
        });

    const tableRows = notes.map((note) =>
        <tr key={note.noteId}>
            <td> {note.date} </td>
            <td> {note.title} </td>
            <td><Button> Open </Button></td>
            <td><Button onClick={() => deleteNote(note.noteId)}> Delete </Button></td>
        </tr>
);

    return (
        <div>
            <h2> My Notes </h2>
            <div>
                <Button onClick = {() => navigate('/1/note')}> Add note</Button>
            </div>
            <table>
                <thead>
                    <tr>
                        <th> Date </th>
                        <th> Title </th>
                        <th/>
                        <th/>
                    </tr>
                </thead>
                <tbody>
                    {tableRows}
                </tbody>
            </table>
        </div>
    )
}

export default NotesList