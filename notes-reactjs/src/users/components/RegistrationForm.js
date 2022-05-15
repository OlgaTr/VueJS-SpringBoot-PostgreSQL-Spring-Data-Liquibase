import React, {useState} from "react";
import {registerNewUser} from "../api/UserAPI";
import {useNavigate} from "react-router-dom";

function RegistrationForm() {
    const[user, setUser] = useState({username:'', password:''})
    const navigate = useNavigate()

    const handleSubmit = (event) => {
        registerNewUser(user).then(navigate('/notes'))
        event.preventDefault()
    }

    return (
        <div>
            <h3>Register new user</h3>
            <form onSubmit={handleSubmit}>
                <input
                    onChange={event => setUser({...user, username: event.target.value})}
                    type="text"
                    placeholder="Username"
                />
                <input
                    onChange={event => setUser({...user, password: event.target.value})}
                    type="text"
                    placeholder="Title"
                />
                <input type="submit" value="Register"/>
            </form>
        </div>
    )
}

export default RegistrationForm;