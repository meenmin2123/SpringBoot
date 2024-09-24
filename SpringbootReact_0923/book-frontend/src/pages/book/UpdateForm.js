import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { Form } from "react-bootstrap";
import Button from 'react-bootstrap/Button';

const UpdateForm = () => {

  // id 가져오기
  const { id } = useParams();

  const navigate = useNavigate();

  // 책 정보를 저장할 수 있는 변수
  const [title,setTitle] = useState('');
  const [author,setAuthor] = useState('');

  useEffect(() => {
    fetch(`http://localhost:9080/book/${id}`).then(response => response.json())
                                             .then(data => { 
                                                console.log("response : ", data)
                                                setTitle(data.title);
                                                setAuthor(data.author);
                                                navigate("/"); 
                                              })
                                             .catch(error => {
                                                console.error("에러 : " , error);
                                             })
  }, [id, navigate]);
  // 비동기 처리로 데이터 요청

  // 응답받는 data를 form태그에 값으로 집어 넣어서 화면 출력

  // title, author 데이터 변경 후 submit해서 결과 저장
  // 저장 후 alert창 띄우기

  const handleSubmit = (event) => {
    event.preventDefault();

    const updateBook = {
      title : title,
      author : author
    };

    // 수정된 데이터를 서버로 전송 (PUT)
    fetch(`http://localhost:9080/book/${id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(updateBook),
    }).then((respone => {
      if(respone.ok) {
        alert("책 정보가 정상적으로 수정되었습니다.")
      }
    }))
    .catch(error => {console.error("수정 중 에러 : " , error)});
  }

  return (
    <div>
      <h1>책 수정</h1>
      <Form onSubmit={handleSubmit}>
        <Form.Group className="mb-3"
          controlId="formTitle">
          <Form.Label>제목</Form.Label>
          <Form.Control
            type="text"
            placeholder="책 제목을 입력하세요"
            id="title"
            value={title}
            onChange={(e) => { setTitle(e.target.value) }}
          />
        </Form.Group>

        <Form.Group className="mb-3"
          controlId="formAuthor">
          <Form.Label>저자</Form.Label>
          <Form.Control
            type="text"
            placeholder="저자를 입력하세요"
            id="author"
            value={author}
            onChange={(e) => { setAuthor(e.target.value) }}
          />

        </Form.Group>

        <Button variant="primary"
          type="submit">
          수정하기
        </Button>
      </Form>
    </div>
  );
};

export default UpdateForm;