-- create database thymybatis;
use thymybatis;

CREATE TABLE article (
                         id INT AUTO_INCREMENT PRIMARY KEY,  -- 고유 ID, 자동 증가
                         title VARCHAR(255) NOT NULL,        -- 제목, NULL 허용 안됨
                         content VARCHAR(500) NOT NULL,      -- 내용, 500자까지 허용, NULL 허용 안됨
                         create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- 생성 시간, 기본값 현재 시간
);

CREATE TABLE comments (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nickname VARCHAR(255),
                          body varchar(1000),
                          articleId INT,
                          FOREIGN KEY (articleId) REFERENCES article(id) ON DELETE CASCADE
);

-- 기본 데이터 삽입
INSERT INTO article(id, title, content) values (1, '홍길동', '천재');
INSERT INTO article(id, title, content) values (2, '임꺽정', '처언재');
INSERT INTO article(id, title, content) values (3, '장길산', '처어언재');
INSERT INTO article(id, title, content) values (4, '일지매', '처어어언재');
INSERT INTO article(id, title, content) values (5, '강만두', '처어어어언재');

-- 추가 더미 데이터 삽입
INSERT INTO article (title, content)
VALUES
    ('손오공', '좋아하는 드라마는?'),
    ('저팔계', '먹고싶은 음식은?'),
    ('사오정', '취미는?');

select * from article;