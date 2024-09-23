import React from 'react';
import Container from 'react-bootstrap/esm/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

export default function header() {
  return (
    <div>
      <Navbar bg="dark" data-bs-theme="dark">
        <Container>
          <Navbar.Brand href="/">Navbar</Navbar.Brand>
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
