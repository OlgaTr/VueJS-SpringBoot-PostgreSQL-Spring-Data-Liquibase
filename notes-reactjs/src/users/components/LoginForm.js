import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import {login, logout} from "../api/UserAPI";

function LoginForm() {
    const[user, setUser] = useState({username:'', password:''})
    const navigate = useNavigate()

    const handleSubmit = (event) => {
        login(user)
            .then(navigate('/notes'))
        event.preventDefault()
    }

    return (
        <div>
            <h3>Login</h3>
            <form onSubmit={handleSubmit}>
                <input
                    onChange={event => setUser({...user, username: event.target.value})}
                    type="text"
                    placeholder="Username"
                />
                <input
                    onChange={event => setUser({...user, password: event.target.value})}
                    type="text"
                    placeholder="Password"
                />
                <input type="submit" value="Login"/>
                <button onClick={() => logout()}>Logout</button>
            </form>
        </div>
    )
}

export default LoginForm;