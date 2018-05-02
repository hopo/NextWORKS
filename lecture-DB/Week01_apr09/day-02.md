2일차
=====
- - -

* CREATE TABLE `table`
* INSERT INTO `table` VALUES (val1, val2, val3)
* SELECT * FROM `table`
- - -

## 테이블 ex2_2 CREATE
```sql
create table ex2_2(
    col1 char(5),
    col2 varchar2(5),
    col3 varchar2(5 char)
) ;
```
* 데이터타입 char를 사용하는 경우 : 데이터사이즈가 정해진 경우
    - ex)우편번호 코드 데이블
* 나머지는 varchar2

## 테이블 ex2_2에 INSERT
```sql
insert into ex2_2 values ('ab', 'ab', 'ab');
```

## 테이블 ex2_2를 조회
```sql
select * from ex2_2;
```

## 테이블 ex2_2에 INSERT
```sql
insert into ex2_2 values ('c', '동', '홍길동');
```

## 테이블 ex2_2를 조회
```sql
select col1, length(col1), lengthb(col1),
       col2, length(col2), lengthb(col2),
       col3, length(col3), lengthb(col3)
from ex2_2;
```
* DB에서는 큰따옴표(")는 거의 사용하지 않음

