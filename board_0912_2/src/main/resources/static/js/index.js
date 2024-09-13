$(document).ready(function () {
    console.log("제이쿼리 연결됨");

    // 전체 게시글 가져오는 함수 실행
    loadBoardList(0);

    // 검색 폼을 눌렀을 때, 함수 실행
    $('searchForm').submit(function (event) {
        // 기본적으로 서버로 전송되는 걸 중지시킴.
        event.preventDefault();

        let searchOption = $('#searchOption').val();
        let keyword = $('#searchKeyword').val();
        console.log("searchOption:",searchOption);
        console.log("keyword:",keyword);

        // 검색했을 때 실행하는 함수
        searchBoard(searchOption,keyword,0);
        renderPagination(response.totalPages, page);
    });

})

// 게시글 목록 (전체) 함수
// page 매개변수를 이용해서 처음부터 전체 가져올 수 있도록
// 처음 실행할 때는 무조건 0부터
function loadBoardList(page) {
    // ajax으로 호출 - 비동기 통신
    $.ajax({
        type: "GET",
        url: `/board/rest/list?page=${page}`,
        dataType: "json",
        success: function (response) {
            console.log(response);
            renderBoardList(response.content);
            renderPagination(response.totalPages, page);
        }, error: function (xhr, status, error) {
            console.log(xhr, status, error);
        }
    })
}

// 게시글 검색 함수
function searchBoard(searchOption, keyword, page) {


}

// 게시글 목록을 매개변수로 받으면 화면에 출력하는 함수
function renderBoardList(boards) {
    console.log("renderBoardList",boards);

    let tbody = $('.table tbody');

    // 기존 내용을 초기화
    tbody.empty();

    // boards 반복
    // - tbody.append(``)
    boards.forEach(board => {
        tbody.append(`
            <tr>
                <td>${board.boardNo}</td>
                <td><a href="/board/detail/${board.boardNo}">${board.title}</a></td>
                <td>${board.content}</td>
                <td>${new Date(board.create_date).toLocaleString()}</td>
                <td>${new Date(board.modify_date).toLocaleString()}</td>
            </tr>
        `);
    })
}
// new Date(board.create_date).toLocaleString() : 자바 스트립트 날짜 시간의 객체 생성
// - 게시글의 값을 이용해서 생성함.
// - 사용자 언어 및 지역설정에 맞게 문자열로 변환
// toLocalString() 사용함.
// 한국 : YYYY.MM.DD HH:MM:SS
// 미국: MM/DD/YYYY HH:MM:SS


// 검색된 게시글의 개수만큼 페이지네이션 만들어서 출력하는 함수
function renderPagination(totalPages,currentPage) {

    // 1. 요소 가져옴
    let pageination = $('#pagination');

    // 2. 기존 페이지네이션 삭제(초기화)
    pageination.empty();

    // 3. 이전버튼
    if(currentPage > 0){
        pagination.append(`<button onclick="loadBoardList(0)">First</button>`);
        pagination.append(`<button onclick="loadBoardList(${currentPage -1})">Prev</button>`);
    }

    // 4. 페이지번호
    for(let i = 0; i < totalPages; i++){
        let activeClass= (i === currentPage) ? 'active': '';
        pagination.append(`<button class="${activeClass}" onclick="loadBoardList(${i})">${i +1}</button>`);
    }

    // 5. 다음버튼
    if(currentPage < totalPages -1){
        pagination.append(`<button onclick="loadBoardList(${currentPage +1})">Next</button>`);
        pagination.append(`<button onclick="loadBoardList(${totalPages -1})">Last</button>`);
    }
}