import React from 'react';
import {
    BrowserRouter as Router,
    Routes,
    Route
} from 'react-router-dom';
import './App.css';
import NotesList from './notes/components/NotesList'
import AddNote from "./notes/components/AddNote";
import LoginForm from "./users/components/LoginForm";
import RegistrationForm from "./users/components/RegistrationForm";
import NavigationBar from "./NavigationBar";
import Note from "./notes/components/Note";
import NotFound from "./utils/components/NotFound";

function App() {
  return (
    <div>
        <Router>
            <NavigationBar/>
            <Routes>
                <Route path="/" element = {<LoginForm/>}/>
                <Route path="/login" element = {<LoginForm/>}/>
                <Route path="/notes" element = {<NotesList/>}/>
                <Route path="/notes/:noteId" element = {<Note/>}/>
                <Route path="/note" element = {<AddNote/>}/>
                <Route path="/register" element = {<RegistrationForm/>}/>
                <Route path="*" element = {<NotFound/>}></Route>
            </Routes>
        </Router>
     </div>
  );
}

export default App;
