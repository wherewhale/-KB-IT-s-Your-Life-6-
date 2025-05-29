-- show tables;
-- 연결정보는 저장이 안되기 때문에, 파일을 열때마다 다시 설정해주어야 한다.

use jdbc_ex; -- 이건 굳이 안해도 됨

CREATE TABLE USERS (
    ID VARCHAR(12) NOT NULL PRIMARY KEY,
    PASSWORD VARCHAR(12) NOT NULL,
    NAME VARCHAR(30) NOT NULL,
    ROLE VARCHAR(6) NOT NULL
);

INSERT INTO USERS(ID, PASSWORD, NAME, ROLE) VALUES
('guest', 'guest123', '방문자', 'USER'),
('admin', 'admin123', '관리자', 'ADMIN'),
('member', 'member123', '일반회원', 'USER');

SELECT * FROM USERS;