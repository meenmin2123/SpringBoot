import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function LoginPage() {

  const [email, setEmail] = useState('');
  const [message, setMessage] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate(); // useNavigate 훅 초기화

  const handleSubmit = (e) => {
    e.preventDefault();

    const loginData = {
      email : email,
      password : password
  };
  
    fetch('http://localhost:9080/products/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(loginData), // formData 객체 전송
    })
    .then(response => {
      if (response.ok) {
        return response.text();
      } else {
        throw new Error('회원가입 실패');
      }
    })
    .then(data => {
      alert('회원가입 성공!'); // 회원가입 성공 알림
      navigate('/login'); // 회원가입 후 login 페이지로 이동
    })
    .catch(error => setMessage(error.message));
  };

  return (
    <div>
      <h1>Login</h1>
        <form onSubmit={handleSubmit}>
          <div>
            <label>Email:</label>
            <input
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          <div>
            <label>Password:</label>
            <input
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <button type="submit">Login</button>
        </form>
        <p>{message}</p>
    </div>
  )
}

export default LoginPage;
