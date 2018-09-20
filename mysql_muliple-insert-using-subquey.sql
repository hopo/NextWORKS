-- ========================
-- 0920
-- ========================
-- 
DESCRIBE flask_db.post;

-- 
SELECT * FROM django_db.blog_post;


-- 
INSERT INTO django_db.blog_post (title, date_posted, content, author_id)
SELECT title, date_posted, content, user_id
FROM flask_db.post;
