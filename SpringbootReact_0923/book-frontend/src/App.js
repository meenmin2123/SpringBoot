
import Header from './components/header';
import {Route, Routes} from 'react-router-dom';
import { Container } from 'react-bootstrap';
import Home from './pages/book/Home';
import SaveForm from './pages/book/SaveForm';
import JoinForm from './pages/user/JoinForm';
import LoginForm from './pages/user/LoginForm';
import UpdateForm from './pages/book/UpdateForm';
import Detail from './pages/book/Detail';
import Delete from './pages/book/Delete';
import './components/header.css';

function App() {
  return (
    <div className="App">
     <Header />
     <Container>

        <Routes>
          {/* 홈 경로로 이동할 때, 어떤 컴포넌트가 실행이 될 지 설정
              - path="경로"
              - element={컴포넌트}

              - 현재 설정은 6버전 최신 버전에 맞춰서 설정을 한 것! 
                만약 5버전으로 하게 되면 속성값이 변경된다. 

                component={} 해당 컴포넌트로 랜더링
                exact={true} 경로가 정확하게 일치할 때만
                            해당 컴포넌트로 이동해서 랜더링
          */}
          <Route path="/" element={<Home />}/>
          <Route path="/saveForm" element={<SaveForm />}/>

          {/* url 에서 /book/1, /book/2 */}
          <Route path="/book/:id" element={<Detail />}/>
          <Route path="/loginForm" element={<LoginForm />}/>
          <Route path="/joinForm" element={<JoinForm />}/>
          <Route path="/updateForm/:id" element={<UpdateForm />}/>
          <Route path="/delete/:id" element={<Delete />}/>
        
        </Routes>
      </Container>
    </div>

    // 1. 삭제하는 경로 Rotue
    // 2. 삭제할 때 컴포넌트 생성
    // 3. url로  /delete/1 , /delete/2
    // 4. alert()창으로 결과 출력
    // 5. 컨트롤러 작성! 서비스작성 후 
    // 6. 결과응답!

  );
}

export default App;
