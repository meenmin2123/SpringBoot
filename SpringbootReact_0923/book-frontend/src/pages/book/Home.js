import React, { useEffect, useState } from 'react'
import BookItem from './BookItem';

const Home = () => {
    
  const [books,setBooks] = useState([]);

  useEffect (()=>{
    // 1. 비동기 통신
    // - fetch(url) API 요청 보내는 함수, 기본적으로 get 요청
    // .then() : fetch() 서버에서 응답이 오면 실행
    // response = response.json() : 응답을 json 형식으로 변경
    fetch('http://localhost:9080/book').then(response => response.json())
    .then(data => {
      // 서버에서 받은 데이터를 콘솔에 출력
      console.log(data)
      setBooks(data);
    })
    .catch(error => {
      console.log("에러 발생 : " , error);
    });

  },[]);
  
  
  return (
      <div>
        <h1>책 리스트 보기</h1>
        {books.map((book) => (
          <BookItem key={book.id} id={book.id} title={book.title} author={book.author}/>
        ))}
      </div>
    );
  };
  
export default Home;

// 리액트에서는 여러개의 데이터를 출력할 때는 각각의 고유한 id값을 부여해서 구별해줘야된다.
// key속성을 이용해서 key={변수명.key} 추가하거나 삭제할 때 제대로 
// 구별해서 할 수있도록! (리스트) 