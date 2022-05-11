import React from 'react';
import {
    BrowserRouter as Router,
    Routes,
    Route
} from 'react-router-dom';
import './App.css';
import NotesList from './notes/components/NotesList'
import AddNote from "./notes/components/AddNote";

function App() {
  return (
    <div>
        <Router>
            <Routes>
                <Route path="/" element={<NotesList/>}></Route>
                <Route path="/:notebookId/note" element={<AddNote/>}></Route>
            </Routes>
        </Router>
     </div>
  );
}

export default App;
