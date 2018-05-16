--제 1정규화

--학생 테이블을 작성하려고 한다.
--해당 데이터는 시트에 있는 1정규화와 같다.

create table test_1NF(
	student_id number,
    department varchar2(20),
    subject varchar2(20),
    constraints test1nf_2nf_pk primary key(student_id,subject)
);
--삽입 이상
insert into test_1NF(student_id,department,subject) values(20164,'수학과','영어','무기학');
insert into test_1NF(student_id,department,subject,subject) values(20164,'수학과','영어','무기학');

-- 위와같이 쿼리를 작성하게 되면 삽입 이상이 발생하게 된다.
-- 제 1정규화는 도메인이 원자값을 가져야 하는데, 한개의 도메인에 여러개의 값을 넣으려고 하기 때문에 삽입이상이다.
-- 따라서 아래와 같이 삽입을 진행해야 한다.
insert into test_1NF values(20161,'컴퓨터과','수학');
insert into test_1NF values(20163,'국문과','영어');
insert into test_1NF values(20164,'수학과','영어');
insert into test_1NF values(20164,'수학과','무기학');
commit;
select * from test_1NF;


--삭제이상.
delete test_1NF
where student_id='20161'
and subject='수학';

select * from test_1NF;

--해당 학생을 delete시 컴퓨터과도 같이 삭제
--학과는 학생에 종속되지만,
--과목과 학과는 서로 종속되지 않기 때문에 부분적 함수 종속으로 인한 문제 발생.

--함수 종속-> 어느 속성군(attribute ->column)의 값이 정해지면 다른 속성군의 값(attribute -> column)이 정해지는 것.


--제 2정규화

--제 2정규화는 수강신청 테이블을 작성하려고 한다.
--해당 데이터 값은 시트의 2정규화와 같다.
rollback;
create table test_2NF as select * from test_1NF;  -- 1정규화 테이블을 토대로 2정규화 테이블 생성

select * from test_2NF;

--새로 만든 테이블을 토대로 2정규화를 진행


create table test_2NF_student( --학생테이블
    student_id varchar2(20) ,
    department varchar2(20),
    constraints Pk_2NF_st_id primary key(student_id)
);

insert into test_2NF_student values(20161,'컴퓨터과');
insert into test_2NF_student values(20163,'국문과');
insert into test_2NF_student values(20164,'수학과');


create table test_2NF_subject( --과목테이블
    student_id varchar2(20),
    subject varchar2(20),
    constraints fk_2NF_st_id foreign key(student_id) references test_2NF_student(student_id)
);

insert into test_2NF_subject values(20161,'수학');
insert into test_2NF_subject values(20163,'영어');
insert into test_2NF_subject values(20164,'영어');
insert into test_2NF_subject values(20164,'무기학');

select * from test_2NF_student;
select * from test_2NF_subject;

select a.student_id
      ,a.department
      ,b.subject
from test_2NF_student a
    ,test_2NF_subject b
where a.student_id=b.student_id;


--제 3정규화.
create table test_3NF(
 championship varchar(20),
 chamsyear number,
 winner varchar2(20),
 birthdate varchar2(25),
 constraints test_3nf_pk primary key(championship,chamsyear)
);
insert into test_3NF values('탁구',1998,'홍길동','1978.3.14');
insert into test_3NF values('사격',1998,'이산','1979.5.14');
insert into test_3NF values('테니스',2009,'설현','1995.1.3');
insert into test_3NF values('탁구',1999,'이산','1978.5.14');
insert into test_3NF values('사격',1999,'홍길동','1978.3.14');

select * from test_3NF;

update test_3NF
set winner='지코'
where championship='테니스'
and chamsyear=2009;

select * from test_3NF
--지코의 생년월일이 95.1.3이 아니므로 갱신이상 발생
--이 경우는 championship과 chamsyear가 기본키로 설정되어있고,
--기본키는 winner를 결정하고 winner는 birth_date를 결정한다.
--이런 이행적 함수종속관계때문에 갱신이상이 발생하는 것이다.


create table test_3NF_winner(
 winner varchar2(20),
 birth_date varchar2(25),
 constraints test_3nf_winner_pk primary key(winner)
);


create table test_3NF_chams(
 championship varchar2(20),
 chamsyear number,
 winner varchar2(20),
 constraints test_3nf_chams_pk primary key(championship,chamsyear),
 constraints test_3nf_fk foreign key(winner) references test_3NF_winner(winner)
);



insert into test_3NF_winner values('홍길동','1978.3.14');
insert into test_3NF_winner values('이산','1979.5.14');
insert into test_3NF_winner values('설현','1995.1.3');
commit;
select * from test_3NF_winner;

insert into test_3NF_chams values('탁구',1998,'홍길동');
insert into test_3NF_chams values('사격',1998,'이산');
insert into test_3NF_chams values('테니스',2008,'설현');
insert into test_3NF_chams values('탁구',1999,'이산');
insert into test_3NF_chams values('사격',1999,'홍길동');

commit;
select * from test_3NF_chams;

select a.*
      ,b.birth_date
from test_3NF_chams a
    ,test_3NF_winner b
where a.winner=b.winner



select 'drop table '|| tname || ' cascade constraints' from tab
where tname like 'TEST%'\

drop table TEST_1NF cascade constraints