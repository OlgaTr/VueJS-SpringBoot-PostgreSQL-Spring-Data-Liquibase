import {Nav} from "react-bootstrap";
import React from 'react';
import {Link} from 'react-router-dom';

const NavigationBar =() => {
    return(
        <Nav>
            <Nav.Link as={Link} to="/register">Register</Nav.Link>
            <Nav.Link as={Link} to="/">Login Page</Nav.Link>
        </Nav>
    )
}

export default NavigationBar;