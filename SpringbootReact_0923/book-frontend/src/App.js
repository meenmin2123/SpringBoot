
import Header from './components/header';
import {Route, Routes} from 'react-router-dom';
import { Container } from 'react-bootstrap';
import Home from './pages/book/Home';
import SaveForm from './pages/book/SaveForm';
import JoinForm from './pages/user/JoinForm';
import LoginForm from './pages/user/LoginForm';
import UpdateForm from './pages/book/UpdateForm';
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
          <Route path="/book/:id" element={<div>글 상세페이지</div>}/>
          <Route path="/loginForm" element={<LoginForm />}/>
          <Route path="/joinForm" element={<JoinForm />}/>
          <Route path="/updateForm/:id" element={<UpdateForm />}/>
        
        </Routes>
      </Container>

    </div>
  );
}

export default App;
