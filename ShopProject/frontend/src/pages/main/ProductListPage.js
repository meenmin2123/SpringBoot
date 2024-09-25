import React from 'react'
import '../../styles/productlist.css';
import PropTypes from 'prop-types'
import { Link, Outlet } from "react-router-dom";

function ProductListPage() {

  const products = [
    { id: 1, name: 'Product 1', src : '1.webp'},
    { id: 2, name: 'Product 2', src : '2.webp'},
    { id: 3, name: 'Product 3', src : '3.webp'},
  ];


  return (
    
    <div>
      <div className='productpagehead'>
        <div class='head'>
          <h2>Shop With Us</h2>
          <p>Best Products, High Quality</p>
        </div>

      <ul className="product-list">
        {products.map(product => (
          
          <li key={product.id}>
            <img src={`/img/${product.src}`} alt={product.name} className="image"/>
            <Link to={`/products/${product.id}`}>{product.name}</Link>
          </li>
        ))}
      </ul>
      </div>

    </div>
  )
}


export default ProductListPage
