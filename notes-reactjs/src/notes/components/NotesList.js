import React, {useState} from 'react';
import {listNotes} from '../api/NoteService'

function NotesList() {

    const [state, setState] = useState([])
    listNotes().then(result => {
            setState(result.data)
        });

    const tableRows = state.map((note, index) =>
        <tr key={index}>
            <td> {note.title} </td>
            <td> {note.date} </td>
            <td> Modify </td>
            <td> Delete </td>
        </tr>
);

    return (
        <div>
            <h2> My Notes </h2>
            <table>
                <thead>
                    <tr>
                        <th> Title </th>
                        <th> Date </th>
                        <th></th>
                        <th></th>
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