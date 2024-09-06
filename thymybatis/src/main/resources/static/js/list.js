/*
* list.js
*/

/* 댓글 수정을 하면 ajax를 이용해서 수정하기(Restcontroller)
*   - service.commentUpdate(), mapper, xml*/


function commtentUpdate() {
    $.ajax({
        url:'articles/commentUpdate',
        type:'POST',
        dataType:'json',
        success:function(response){
            console.log(response);
        },
        error:function(jqXHR, textStatus, errorThrown){
            console.error('Error:', textStatus, errorThrown);
        }
    })
}

// th:attr 속성이용해서 값들을 변경
// src,href @{}
// img 경로설정을 할때는 @{경로/${파일명}.확장자명}
// form th:action -> th:attr="@{/articles/save}"
// 버튼 활성화 비활성화
// th:attr="disabled=${not 변수명}"

// value
// th:attr="value=${객체명.변수명}"

// $(document).ready(function() {
//     $('#comment-edit-modal').on('show.bs.modal', function(event) {
//         var button = $(event.relatedTarget); // 버튼에서 데이터를 가져옵니다.
//
//         var commentId = button.data('bs-id');
//         var commentNickname = button.data('bs-nickname');
//         var commentBody = button.data('bs-body');
//         var articleId = button.data('bs-article-id');
//
//         // 모달 내부의 필드에 값을 설정합니다.
//         $('#edit-comment-nickname').val(commentNickname);
//         $('#edit-comment-body').val(commentBody);
//         $('#edit-comment-id').val(commentId);
//         $('#edit-comment-article-id').val(articleId);
//     });