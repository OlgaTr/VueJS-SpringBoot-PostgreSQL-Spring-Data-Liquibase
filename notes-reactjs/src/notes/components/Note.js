import React, {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {useSelector} from "react-redux";
import {getNote} from "../api/NoteAPI";
import {selectPassword, selectUsername} from "../../app/userSlice";

function Note() {
    const [note, setNote] = useState({title: '', content: ''});
    const noteId = useParams().noteId;
    const username = useSelector(selectUsername);
    const password = useSelector(selectPassword);

    useEffect(() => {
        getNote(username, password, noteId)
            .then(response  => setNote(response.data));
    }, [])

    return (
        <div>
            <h3>{note.title}</h3>
            <p>{note.content}</p>
        </div>
    )
}

export default Note;