use jpaJoin;

CREATE TABLE Article (
                         id INT AUTO_INCREMENT PRIMARY KEY,  -- 고유 ID, 자동 증가
                         title VARCHAR(255) NOT NULL,        -- 제목, NULL 허용 안됨
                         content VARCHAR(500) NOT NULL,      -- 내용, 500자까지 허용, NULL 허용 안됨
                         create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- 생성 시간, 기본값 현재 시간
);

CREATE TABLE Comment (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nickname VARCHAR(255),
                          body varchar(1000),
                          article_id INT,
                          FOREIGN KEY (article_id) REFERENCES Article(id) ON DELETE CASCADE
);

-- 게시글 1
INSERT INTO Article (title, content) VALUES ('첫 번째 게시글', '이것은 첫 번째 게시글의 내용입니다.');

-- 게시글 2
INSERT INTO Article (title, content) VALUES ('두 번째 게시글', '이것은 두 번째 게시글의 내용입니다.');

-- 게시글 3
INSERT INTO Article (title, content) VALUES ('세 번째 게시글', '이것은 세 번째 게시글의 내용입니다.');

INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자1', '첫 번째 게시글에 대한 첫 번째 댓글', 1);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자2', '첫 번째 게시글에 대한 두 번째 댓글', 1);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자3', '첫 번째 게시글에 대한 세 번째 댓글', 1);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자4', '첫 번째 게시글에 대한 네 번째 댓글', 1);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자5', '첫 번째 게시글에 대한 다섯 번째 댓글', 1);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자6', '첫 번째 게시글에 대한 여섯 번째 댓글', 1);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자7', '첫 번째 게시글에 대한 일곱 번째 댓글', 1);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자8', '첫 번째 게시글에 대한 여덟 번째 댓글', 1);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자9', '첫 번째 게시글에 대한 아홉 번째 댓글', 1);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자10', '첫 번째 게시글에 대한 열 번째 댓글', 1);

INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자1', '두 번째 게시글에 대한 첫 번째 댓글', 2);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자2', '두 번째 게시글에 대한 두 번째 댓글', 2);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자3', '두 번째 게시글에 대한 세 번째 댓글', 2);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자4', '두 번째 게시글에 대한 네 번째 댓글', 2);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자5', '두 번째 게시글에 대한 다섯 번째 댓글', 2);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자6', '두 번째 게시글에 대한 여섯 번째 댓글', 2);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자7', '두 번째 게시글에 대한 일곱 번째 댓글', 2);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자8', '두 번째 게시글에 대한 여덟 번째 댓글', 2);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자9', '두 번째 게시글에 대한 아홉 번째 댓글', 2);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자10', '두 번째 게시글에 대한 열 번째 댓글', 2);

INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자1', '세 번째 게시글에 대한 첫 번째 댓글', 3);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자2', '세 번째 게시글에 대한 두 번째 댓글', 3);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자3', '세 번째 게시글에 대한 세 번째 댓글', 3);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자4', '세 번째 게시글에 대한 네 번째 댓글', 3);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자5', '세 번째 게시글에 대한 다섯 번째 댓글', 3);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자6', '세 번째 게시글에 대한 여섯 번째 댓글', 3);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자7', '세 번째 게시글에 대한 일곱 번째 댓글', 3);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자8', '세 번째 게시글에 대한 여덟 번째 댓글', 3);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자9', '세 번째 게시글에 대한 아홉 번째 댓글', 3);
INSERT INTO Comment (nickname, body, article_id) VALUES ('사용자10', '세 번째 게시글에 대한 열 번째 댓글', 3);