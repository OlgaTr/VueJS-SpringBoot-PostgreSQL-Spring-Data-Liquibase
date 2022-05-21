import React, {useState} from "react";
import Button from "react-bootstrap/Button";
import {useNavigate} from "react-router-dom";
import {useSelector} from "react-redux";
import {addNote} from "../api/NoteAPI";
import {selectUsername, selectPassword} from "../../app/userSlice";

function AddNote() {
    const navigate = useNavigate();
    const [note, setNote] = useState({title:'', content: ''});
    const username = useSelector(selectUsername);
    const password = useSelector(selectPassword);

    const handleInput = (event) => {
        setNote({...note, [event.target.name]: event.target.value})
    }

    const handleSubmit = (event) => {
        addNote(username, password, note).then(navigate('/notes'))
        event.preventDefault()
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