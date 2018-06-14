
-- ERD script
-- ==========


-- ## 회원 테이블
-- * PK : mem_seq_no
CREATE TABLE tb_member (
    mem_seq_no		NUMBER,
    mem_id          VARCHAR2(20),
    mem_pw			VARCHAR2(20),
    mem_name		VARCHAR2(50),
    mem_nickname	VARCHAR2(50),
    mem_zipcode		VARCHAR2(6),
    mem_addr		VARCHAR2(200),
    CONSTRAINT pk_tb_member PRIMARY KEY (mem_seq_no)
);


-- ## 권한 테이블
-- * PK : auth_cd
-- * FK : auth_grp
CREATE TABLE tb_auth (
	auth_cd		VARCHAR2(10),
	auth_grp	VARCHAR2(10),
	auth_nm		VARCHAR2(100),
    CONSTRAINT pk_tb_auth PRIMARY KEY (auth_cd),
    CONSTRAINT fk_tb_auth
        FOREIGN KEY (auth_grp)
        REFERENCES tb_auth(auth_cd)
);


-- ## 회원별 권한 테이블 
-- * PK : mem_seq_no, auth_cd
-- * FK : mem_seq_no, auth_cd
CREATE TABLE tb_mem_auth (
	mem_seq_no 	NUMBER,
	auth_cd 	VARCHAR2(10),
    CONSTRAINT pk_tb_mem_auth PRIMARY KEY (mem_seq_no, auth_cd),
	CONSTRAINT fk_tb_mem_auth_tb_member
		FOREIGN KEY (mem_seq_no)
		REFERENCES tb_member(mem_seq_no),
    CONSTRAINT fk_tb_mem_auth_tb_auth
		FOREIGN KEY (auth_cd)
		REFERENCES tb_auth(auth_cd)
);


-- ## 게시판 테이블
-- * PK : seq_no
-- * FK : mem_seq_no
CREATE TABLE tb_board (
	seq_no		NUMBER,
	title		VARCHAR2(100),
	content		CLOB,
	reg_date	DATE,
	mem_seq_no	NUMBER,
    CONSTRAINT pk_tb_board PRIMARY KEY (seq_no),
	CONSTRAINT fk_tb_board_tb_member
		FOREIGN KEY (mem_seq_no)
		REFERENCES tb_member(mem_seq_no)
);


-- ## 댓글 테이블
-- * PK : rep_seq_no
-- * FK : seq_no, mem_seq_no
CREATE TABLE tb_reply (
	rep_seq_no		NUMBER,
	rep_content		VARCHAR(200),
	rep_reg_date	DATE,
	seq_no			NUMBER,
	mem_seq_no		NUMBER,
    CONSTRAINT pk_tb_reply PRIMARY KEY (rep_seq_no),
	CONSTRAINT fk_tb_reply_tb_board
		FOREIGN KEY (seq_no)
		REFERENCES tb_board(seq_no),
	CONSTRAINT fk_tb_reply_tb_member
		FOREIGN KEY (mem_seq_no)
		REFERENCES tb_member(mem_seq_no)
);

