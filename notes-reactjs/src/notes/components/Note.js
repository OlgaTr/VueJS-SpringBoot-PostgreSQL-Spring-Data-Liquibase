import React, {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {getNote} from "../api/NoteAPI";
import {getCurrentUser} from "../../users/api/UserAPI";

function Note() {
    const [note, setNote] = useState({title: '', content: ''})
    const noteId = useParams().noteId

    useEffect(() => {
        getCurrentUser()
            .then(result => {
                getNote(result.data, noteId)
                    .then(response => setNote(response.data))
        })
    }, [])

    return (
        <div>
            <h3>{note.title}</h3>
            <p>{note.content}</p>
        </div>
    )
}

export default Note