//파일명: Detail.js
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

const Detail = () => {

  // URL - '/book/3' 값을 가져오는 명령문
  // /book/:id
  const { id } = useParams();

  // 책 정보를 저장할 수 있는 변수
  const [book,setBook] = useState('');

  // 페이지를 실행할 때 해당 책의 상세 정보를 가져오는 'useEffect' 사용
  // 컨포넌트가 페이지 실행할 때 특정 작업을 추가할 때, 'Hook' 사용
  // const res = 
  useEffect(() => {
    fetch(`http://localhost:9080/book/${id}`).then(response => response.json())
                                             .then(data => { 
                                                console.log("response : ", data)
                                                setBook(data)})
                                             .catch(error => {
                                                console.error("에러 : " , error);
                                             });
  }, [id]);
  // id가 변경될 때 마다 'useEffect()'를 실행하여 서버에서 데이터를 받아옴.

  // 만약에 데이터가 오지 않았다면 안내메시지 추가
  // if(res.ok) {
  //   alert("성공적으로 데이터를 불러왔습니다.");
  // } else {
  //   alert("성공적으로 데이터를 불러오지 못 하였습니다.");
  //   console.log('Error response:', res.text());
  // }

  if(!book) {
    return <p> 데이터 안 옴</p>
  }

    return (
      <div>
        <h1>책 상세페이지</h1>

        <div>
          <h2>{book.title}</h2>
          <p>{book.author}</p>
        </div>
      </div>
    );
  };
  
export default Detail;

// 실행순서
// 1. 책 상세페이지 이동하면 Detail 컴포넌트 실행!
// 2. URL에서 id값을 가져온다.
// 3. 책 정보 요청(fectch)
// 4. 컨트롤러가 요청을 받아서 응답이 온다.
// 5. 서버에서 응답이오면 then 메서드 실행된다.
// 6. 응답받은 JSON으로 변환한다. data에 저장한다.
// 7. 화면에 데이터를 출력!(랜더링)
// 8. 만약에 데이터가 못옴 catch() 콘솔에 출력한다.

