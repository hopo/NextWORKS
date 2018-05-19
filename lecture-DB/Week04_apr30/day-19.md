DAY-19
======
- - -

* Meta-Table
* INICAP(), REPLACE() 
* Binds
* SQL Developer View Snippets
- - -

### Meta-Table
* user_tab_cols Table
```sql
SELECT * FROM user_tab_cols
WHERE table_name = 'DEPARTMENTS';
```
* Meta-Table을 이용해서 java에서 사용할 VO를 생성
* 컬럼이름을 그대로 사용 또는 CamelCase

```java
// * in java
private int department_id ;
private String department_name = "";

// * in java using type
// NUMBER -> int, VARCHAR2, CHAR -> String, DATE, TIMESTAMP -> String, java.util.Date -> String
```


### exA) using CASE
```sql
SELECT column_name, data_type,
    CASE data_type
        WHEN 'NUMBER' THEN 'int'
        ELSE 'String'
    END
    AS vo_data_type
FROM user_tab_cols
WHERE table_name = 'DEPARTMENTS';
```
    
### exA2)
* using decode()
```sql
SELECT column_name, data_type,
    DECODE(data_type,'NUMBER','int','String') AS vo_data_type
FROM user_tab_cols
WHERE table_name = 'DEPARTMENTS';
```

### exA3)
```sql
SELECT 'private '
    || DECODE(data_type,'NUMBER','int ','String ')
    || lower(column_name)
    || DECODE(data_type,'NUMBER','','= ""')
    || ';'
FROM user_tab_cols
WHERE table_name = 'DEPARTMENTS';
```
   
### INICAP(), REPLACE() 
### exA)
* 함수를 이용하여 원하는 문자열 만들기
```sql
SELECT substr(lower(column_name),1,1)
    || substr(replace(initcap(column_name),'_',''),2)
FROM user_tab_cols
WHERE table_name = 'DEPARTMENTS';
```

## Binds
### exD) 
```sql
SELECT 'private '
    || DECODE(data_type,'NUMBER','int ','String ')
    || lower(column_name)
    || DECODE(data_type,'NUMBER','','= ""')
    || ';'
FROM user_tab_cols
WHERE table_name = upper(:tb_name);
```
* Binds, Run시 입력 값을 받는다
    
    
## SQL Developer Snippets 이용하기
* 메뉴 View-Snippets
* 쿼리들을 저장 해둬서 사용할 수 있다


- - -
-- DAY-19 end line --

