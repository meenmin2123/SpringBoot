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
            />
          </Navbar.Brand>

          <Nav className="me-auto">
              <Nav.Link to="/product/list" href="/product/list" className='nav-link'>Product</Nav.Link>
              <Nav.Link to="/news" href="/news" className='nav-link'>News</Nav.Link> 
          </Nav>
          <Nav className="menubar">
            <Nav.Link to="/cart" href="/cart" className='nav-link'>Cart</Nav.Link>
            <Nav.Link to="/login" href="/login" className='nav-link'>Login</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </div>
  )
}
