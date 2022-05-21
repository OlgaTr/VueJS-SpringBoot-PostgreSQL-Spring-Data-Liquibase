import React, {useEffect, useState} from 'react';
import Button from 'react-bootstrap/Button'
import {useNavigate} from "react-router-dom";
import {deleteNote, listNotes} from '../api/NoteAPI'
import {selectPassword, selectUsername} from "../../app/userSlice";
import {useSelector} from "react-redux";

function NotesList() {

    const navigate = useNavigate();
    const username = useSelector(selectUsername);
    const password = useSelector(selectPassword);
    const [notes, setNotes] = useState([]);
    const [render, performRerender] = useState({});

    useEffect(() => {
        listNotes(username, password).then(response => setNotes(response))
    }, [render])

    function handleDelete(noteId) {
        deleteNote(username, password, noteId)
            .then(() => performRerender({...render}))
    }

    const tableRows = notes.map((note) =>
        <tr key={note.noteId}>
            <td> {note.date} </td>
            <td> {note.title} </td>
            <td><Button onClick={() => navigate(`/notes/${note.noteId}`)}> Open </Button></td>
            <td><Button onClick={() => handleDelete(note.noteId)}> Delete </Button></td>
        </tr>
);

    return (
        <div>
            <h2> My Notes </h2>
            <div>
                <Button onClick = {() => navigate('/note')}> Add note</Button>
            </div>
            {notes.length
                ?
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
                        {
                            tableRows
                        }
                    </tbody>
                </table>
                :
                <h4>
                    Add your first note ☕
                </h4>
            }
        </div>
    )
}

export default NotesList