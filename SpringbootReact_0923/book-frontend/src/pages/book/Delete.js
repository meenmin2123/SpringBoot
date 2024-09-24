import { useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const Delete = () => {

    // 페이지 이동
    const navigate = useNavigate();

    const { id } = useParams();
    
    // http 요청 시, DELETE 메서드 실행
    useEffect(() => {
        fetch(`http://localhost:9080/book/${id}`,{method: 'DELETE'})
                .then(resp => {
                    if(resp.ok) {
                        alert("정상적으로 삭제 되었습니다.");
                        navigate("/");
                    }
                })
                .catch(error => {
                    alert("정상적으로 삭제되지 않았습니다.");
                    console.error("에러 : " , error);
                });
      }, [id, navigate]);

  return (
    // 만약에 굳이 페이지가 필요없는 컴포넌트이면 'return null' 작성
    null
    // <div>
    //     <h1>삭제페이지</h1>
    // </div>
  )
}

export default Delete;
