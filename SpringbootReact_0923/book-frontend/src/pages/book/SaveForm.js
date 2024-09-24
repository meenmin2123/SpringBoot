import React, { useState} from 'react'
import { Form, Button, Container } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

const SaveForm = () => {

  const navigate = useNavigate();

  // 입력 값을 저장하는 변수들
  const [title, setTitle] = useState('');
  const [author, setAuthor] = useState('');

  // submit 버튼 실행 시, 실행되는 함수
  const handleSubmit = async (event) => {
    // 기본 동작을 막음
    event.preventDefault();

    console.log('제목:',title);
    console.log('저자:',author);

    // 입력받은 데이터를 개체로 생성
    const book = {
      title: title,
      author: author
    };

    try {
      // API 통신 날리기, POST
      const response = await fetch('http://localhost:9080/book', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(book),
      });

      if (response.ok) {
        alert("성공적으로 저장되었습니다.");
        
        // 폼 초기화
        setTitle('');
        setAuthor('');
        navigate("/");
      } else {
        alert('저장에 실패했습니다.');
        console.log('Error response:', await response.text()); // 상세 에러 메시지 로그
      }

    } catch (error) {
      console.log('error : ', error);
      alert("서버와의 통신에서 에러가 발생했습니다.");
    }
  };

  return (
    <Container>
      <h1>글쓰기</h1>
      <Form onSubmit={handleSubmit}>
        <Form.Group className="mb-3" controlId="formTitle">
          <Form.Label>제목</Form.Label>
          <Form.Control type="text" placeholder="책 제목을 입력하세요"
            value={title} onChange={(e) => { setTitle(e.target.value) }} />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label>저자</Form.Label>
          <Form.Control type="text" placeholder="저자를 입력하세요"
            value={author} onChange={(e) => { setAuthor(e.target.value) }} />
        </Form.Group>
        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>

    </Container>
  );
};

export default SaveForm;
