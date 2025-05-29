
DROP TABLE IF EXISTS tbl_travel;
CREATE TABLE tbl_travel
(
    no INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    district VARCHAR(50) NOT NULL ,
    title VARCHAR(512) NOT NULL ,
    description TEXT,
    address VARCHAR(512),
    phone VARCHAR(256)
);

select * from tbl_travel;

DROP TABLE IF EXISTS tbl_travel_image;
CREATE TABLE tbl_travel_image
(
    no INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    filename VARCHAR(512) NOT NULL,
    travel_no INT,
    CONSTRAINT FOREIGN KEY (travel_no) REFERENCES tbl_travel (no)
        ON DELETE CASCADE
);

select * from tbl_travel_image;


-- 레스토랑 모시기 실습
DROP TABLE IF EXISTS tbl_restaurant;
CREATE TABLE tbl_restaurant
(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(100),
    category VARCHAR(100),
    address VARCHAR(255),
    description TEXT
);

select * from tbl_restaurant;


select t.*, ti.no as tino, ti.filename, ti.travel_no
from tbl_travel t
    left outer join tbl_travel_image ti
    on t.no = ti.travel_no
where t.no = 1;


DROP TABLE IF EXISTS tbl_restaurant_review;

CREATE TABLE tbl_restaurant_review (
   no INT AUTO_INCREMENT PRIMARY KEY,
   restaurant_id INT,
   writer VARCHAR(100),
   content TEXT,
   score INT,
   FOREIGN KEY (restaurant_id) REFERENCES tbl_restaurant(id) ON DELETE CASCADE
);

select * from tbl_restaurant_review;


SELECT r.*, rr.writer, rr.content, rr.score
FROM tbl_restaurant r
         LEFT OUTER JOIN tbl_restaurant_review rr
                         ON r.id = rr.restaurant_id
WHERE r.id = 1;

SELECT r.id, r.name, AVG(rr.score), r.address
FROM tbl_restaurant r
         LEFT OUTER JOIN
     tbl_restaurant_review rr
     ON r.id = rr.restaurant_id
GROUP BY r.id
ORDER BY AVG(rr.score) DESC;