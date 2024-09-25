import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function JoinPage() {
  // 후크는 컴포넌트의 최상위에서 선언
  const [formData, setFormData] = useState({
    email: '',
    name: '',
    password: ''
  });
  const [message, setMessage] = useState('');
  const navigate = useNavigate(); // useNavigate 훅 초기화

  // 입력 필드가 변경될 때마다 실행되는 함수
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value
    }));
  };

  // 회원가입 버튼을 클릭했을 때 실행되는 함수
  const handleSubmit = (e) => {
    e.preventDefault();
  
    fetch('http://localhost:9080/products/register', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData), // formData 객체 전송
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
      <h1>회원가입</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Email:</label>
          <input 
            type="email" 
            name="email" // name 속성 추가
            value={formData.email} 
            onChange={handleChange} 
            required 
          />
        </div>
        <div>
          <label>Name:</label>
          <input 
            type="text" 
            name="name" // name 속성 추가
            value={formData.name} 
            onChange={handleChange} 
            required 
          />
        </div>
        <div>
          <label>Password:</label>
          <input 
            type="password" 
            name="password" // name 속성 추가
            value={formData.password} 
            onChange={handleChange} 
            required 
          />
        </div>
        <button type="submit">회원가입</button>
      </form>
      <p>{message}</p>
    </div>
  )
}

export default JoinPage;
