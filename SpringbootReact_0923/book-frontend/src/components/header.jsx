import React from 'react';
import Container from 'react-bootstrap/esm/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import './header.css';

export default function header() {
  return (
    <div>
      <Navbar bg="dark" data-bs-theme="dark" className='navbar'>
        <Container>
          <Navbar.Brand href="/">
          <img
              src="logo192.png"
              width="30"
              height="30"
              className="d-inline-block align-top"
              alt="logo"
            /></Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link to="/" href="/" className='nav-link'>Home</Nav.Link>
            <Nav.Link to="/saveForm" href="/saveForm" className='nav-link'>글쓰기</Nav.Link>
            <Nav.Link to="/LoginForm" href="/LoginForm" className='nav-link'>Login</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </div>
  )
}
