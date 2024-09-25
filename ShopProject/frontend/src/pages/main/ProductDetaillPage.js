import React from 'react'
import PropTypes from 'prop-types'

function ProductDetaillPage() {

  const { id } = useParams();  // URL의 :id 부분을 가져옴


  return (
    <div>
      <div>ProdectDetaillPage</div>
      <p>Showing details for product ID: {id}</p>
    </div>
  );
}


export default ProductDetaillPage

