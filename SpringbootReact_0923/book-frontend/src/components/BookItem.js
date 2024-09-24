// 책의 내용을 출력할 때 카드 레이아웃의 컴포넌트를 만들어서 반복 사용.
import {Card} from 'react-bootstrap';
import { Link } from 'react-router-dom';

const BookItem = ({id,title,author}) => {
    
    return (
        <Card className="mb-3">
        <Card.Body>
            <Card.Title>{title}</Card.Title>
            <p>{author}</p>
            <Link to={`/book/${id}` } variant="primary" className="btn btn-primary">상세보기</Link>
            <Link to={`/updateForm/${id}` } variant="primary" className="btn btn-primary">수정하기</Link>
            <Link to={`/delete/${id}` } variant="danger" className="btn btn-danger">삭제하기</Link>
        </Card.Body>
        </Card>
    );
};

export default BookItem;