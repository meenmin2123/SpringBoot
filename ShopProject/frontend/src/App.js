import Header from './components/header';
import {Route, Routes} from 'react-router-dom';
import { Container } from 'react-bootstrap';
import MainPage from './pages/main/MainPage';
import ProductListPage from './pages/main/ProductListPage';
import ProductDetaillPage from './pages/main/ProductDetaillPage';
import NewProduct from './pages/main/NewProduct';
import LoginPage from './pages/user/LoginPage';
import JoinPage from './pages/user/JoinPage';
import Cart from './pages/user/Cart';
import News from './pages/main/News';

function App() {
  return (
    <div className="App">
      <Header />

      <Container>
        <Routes>
          <Route path="/" element={<MainPage />}/>
          <Route path="/product/list" element={<ProductListPage />}/>
          <Route path="/product/new" element={<NewProduct />}/>
          <Route path="/product/:id" element={<ProductDetaillPage />}/>

          <Route path="/news" element={<News />}/>
          <Route path="/cart" element={<Cart />}/>
          <Route path="/login" element={<LoginPage />}/>
          <Route path="/join" element={<JoinPage />}/>
        </Routes>
      </Container>
    </div>
  );
}

export default App;
