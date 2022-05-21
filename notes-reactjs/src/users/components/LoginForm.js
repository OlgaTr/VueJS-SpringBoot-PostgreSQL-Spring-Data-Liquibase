import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import {useDispatch} from "react-redux";
import {setCurrentUser, removeCurrentUser} from "../../app/userSlice";

function LoginForm() {
    const[user, setUser] = useState({username:'', password:''});
    const navigate = useNavigate();
    const dispatch = useDispatch();

    const handleSubmit = (event) => {
        dispatch(setCurrentUser(user))
        navigate('/notes')
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
                <button onClick={() => dispatch(removeCurrentUser)}>Logout</button>
            </form>
        </div>
    )
}

export default LoginForm;