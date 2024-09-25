import React from 'react';
import ReactDOM from 'react-dom/client';
import './styles/index.css';
import App from './App';
import { BrowserRouter } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import { createBrowserRouter } from 'react-router-dom';
import MainPage from './pages/main/MainPage';
import NotFound from './pages/NotFound';
import ProductListPage from './pages/main/ProductListPage';
import ProductDetaillPage from './pages/main/ProductDetaillPage';
import NewProduct from './pages/main/NewProduct';
import LoginPage from './pages/user/LoginPage';
import JoinPage from './pages/user/JoinPage';
import Cart from './pages/user/Cart';
import News from './pages/main/News';

// 경로 설정 
// createBrowserRouter()
//  React Router 에서 브라우저 경로를 설정하는 함수 ! url의 요청으로 페이지 관리를 할 때  

const router = createBrowserRouter([
  { 
    path : '/',
    element : <App />,
    errorElement : <NotFound />, // 404페이지
    children :[
      { index : true , element:<MainPage />},
      { path : "/products/list" , element : <ProductListPage />},
      { path : '/products/new',element : <NewProduct />},
      { path : '/products/:id',element : <ProductDetaillPage />},
      { path : '/cart',element : <Cart />},
      { path : "/news" , element : <News />},
      { path : '/login',element : <LoginPage />},
      { path : '/join',element : <JoinPage />}
    ],
  },
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </React.StrictMode>
);
