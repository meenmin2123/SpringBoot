import Header from './components/header';
// import {createBrowserRouter, Route, Routes} from 'react-router-dom';
// import ReactDOM from 'react-dom/client';
// import { Container } from 'react-bootstrap';
// import MainPage from './pages/main/MainPage';
// import ProductListPage from './pages/main/ProductListPage';
// import ProductDetaillPage from './pages/main/ProductDetaillPage';
// import NewProduct from './pages/main/NewProduct';
// import LoginPage from './pages/user/LoginPage';
// import JoinPage from './pages/user/JoinPage';
// import Cart from './pages/user/Cart';
// import News from './pages/main/News';
import { Link, Outlet } from "react-router-dom"

function App() {
  return (
    <div>
       <Header />

       <nav>
        <ul>
          <li><Link to="/">Home</Link></li>
          <li><Link to="/products">All</Link></li>
          <li><Link to="/products/new">New</Link></li>
          <li><Link to="/cart">Cart</Link></li>
          <li><Link to="/login">Login</Link></li>
          <li><Link to="/join">Join</Link></li>
         
        </ul>        
      </nav>

      {/* 라우팅 설정한 element의 컴포넌트를 표시 */}
      <Outlet />
      
    </div>
    // <div className="App">
    //   <Header />

    //   <Container>
    //     <Routes>
    //       <Route path="/" element={<MainPage />}/>
    //       <Route path="/product/list" element={<ProductListPage />}/>
    //       <Route path="/product/new" element={<NewProduct />}/>
    //       <Route path="/product/:id" element={<ProductDetaillPage />}/>

    //       <Route path="/news" element={<News />}/>
    //       <Route path="/cart" element={<Cart />}/>
    //       <Route path="/login" element={<LoginPage />}/>
    //       <Route path="/join" element={<JoinPage />}/>
    //     </Routes>
    //   </Container>
    // </div>
  );
}

export default App;
