import React, {useState} from "react";
import Button from "react-bootstrap/Button";
import {useNavigate} from "react-router-dom";
import {addNote} from "../api/NoteService";

const AddNote = () => {
    const [note, setNote] = useState({title:'', content: ''});
    const navigate = useNavigate()

    // const handleTitleInput = (event) => {
    //     setNote({...note, [event.title]: event.target.value})
    // }

    const handleInput = (event) => {
        setNote({...note, [event.target.name]: event.target.value})
    }

    const handleSubmit = (event) => {
        addNote(note).then(navigate('/'))
        event.preventDefault();
    }

    // return (
    //     // <form onSubmit={handleSubmit}>
    //     //     <label>Title</label>
    //         <input
    //             type="text"
    //             name="title"
    //             // onChange={inputChanged}
    //             value={title}/>
    //         // <label>Text</label>
    //         <input type="text" name="content" onChange={inputChanged}
    //             value={note.content}/>
    //         <input type="submit" value="Save note"/>
    //         <button> Cancel </button>
    //     // </form>
    // )
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
            <Button onClick={() => navigate('/')}> Cancel </Button>
            <input type="submit" value="Save"/>
        </form>
    )
}

export default AddNote;