import React, {useState} from 'react';
import Button from 'react-bootstrap/Button'
import {useNavigate} from "react-router-dom";
import {listNotes} from '../api/NoteAPI'
import {deleteNote} from "../api/NoteAPI";
import {getCurrentUser} from "../../users/api/UserAPI";

function NotesList() {

    const navigate = useNavigate()
    const [notes, setNotes] = useState([])

    const [user, setUser] = useState({username: '', password: ''})
    getCurrentUser().then(result => {
        setUser({...user, username: result.data.username, password: result.data.password})
    })

    listNotes(user).then(result => {
            setNotes(result.data)
        });

    const tableRows = notes.map((note) =>
        <tr key={note.noteId}>
            <td> {note.date} </td>
            <td> {note.title} </td>
            <td><Button> Open </Button></td>
            <td><Button onClick={() => deleteNote(user, note.noteId)}> Delete </Button></td>
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
                        {tableRows}
                    </tbody>
                </table>
                :
                <h4>
                    Add your first note :)
                </h4>
            }
        </div>
    )
}

export default NotesList