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

function App() {
  return (
    <div>
        <Router>
            <NavigationBar/>
            <Routes>
                <Route path="/" element = {<LoginForm/>}></Route>
                <Route path="/login" element = {<LoginForm/>}></Route>
                <Route path="/notes" element = {<NotesList/>}></Route>
                <Route path="/note" element = {<AddNote/>}></Route>
                <Route path="/register" element = {<RegistrationForm/>}></Route>
            </Routes>
        </Router>
     </div>
  );
}

export default App;
