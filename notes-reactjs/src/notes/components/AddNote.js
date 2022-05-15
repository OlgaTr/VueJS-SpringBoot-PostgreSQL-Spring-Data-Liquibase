import React, {useState} from "react";
import Button from "react-bootstrap/Button";
import {useNavigate} from "react-router-dom";
import {addNote} from "../api/NoteAPI";
import {getCurrentUser} from "../../users/api/UserAPI";

function AddNote() {
    const [note, setNote] = useState({title:'', content: ''});

    const [user, setUser] = useState({username: '', password: ''})
    getCurrentUser().then(result => {
        setUser({...user, username: result.data.username, password: result.data.password})
    })

    const navigate = useNavigate()

    const handleInput = (event) => {
        setNote({...note, [event.target.name]: event.target.value})
    }

    const handleSubmit = (event) => {
        addNote(user, note).then(navigate('/notes'))
        event.preventDefault();
    }

    return (
        <form onSubmit={handleSubmit}>
            <input
                name="title"
                onChange={handleInput}
                type="text"
                placeholder="Title"
            />
            <input
                name="content"
                onChange = {handleInput}
                type="text"
                placeholder="Your note"
            />
            <Button onClick={() => navigate('/notes')}> Cancel </Button>
            <input type="submit" value="Save"/>
        </form>
    )
}

export default AddNote;