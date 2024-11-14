# (Develop)일정관리 앱 API 명세서

## 유저 CRUD
|기능|Method|URL|Request|Response|Status Code|
|:---:|:---:|:---:|:---:|:---:|:---|
|유저 등록|POST|/api/apps|요청body|등록정보|- 성공: 201 Created|
|유저 조회|GET|/api/apps/{id}||단건응답 정보|- 성공: - Status Code 200 OK|
|유저 삭제|DELETE|/api/apps/{id}|||- 성공: Status Code 200 OK<br>- 유저 x: 404 NotFound|

### ■ 유저 생성(회원가입)
#### □ 요청
|이름|타입|설명|필수여부|
|:---:|:---:|:---:|:---:|
|username|String|유저 이름|필수|
|password|String|유저 비밀번호|필수|
|age|Integer|유저 나이|필수|

<pre>
  <code>
    {
    "username": "000", 
    "password": "1234",
    "age": "50"
    }
  </code>
</pre>


#### □ 응답
|이름|타입|설명|
|:---:|:---:|:---:|
|id|string|아이디|
|username|String|유저 이름|
|age|Integer|유저 나이|

<pre>
  <code>
    {
    "id": 1,
    "username": "000", 
    "age": "50"
    }
  </code>
</pre>

### ■ 유저 조회(특정 회원 조회)
#### □ 응답
|이름|타입|설명|
|:---:|:---:|:---:|
|username|String|유저 이름|
|age|Integer|유저 나이|

<pre>
  <code>
    {
    "username": "000", 
    "age": "50"
    }
  </code>
</pre>

### ■ 유저 삭제
#### □ 요청
|이름|타입|설명|필수여부|
|:---:|:---:|:---:|:---:|
|password|String|비밀번호|필수|

<pre>
  <code>
    {
    "password": "1234"
    }
    </code>
</pre>

#### □ 응답
<pre>
  <code>
   
  </code>
</pre>

## 일정 CRUD
|기능|Method|URL|Request|Response|Status Code|
|:---:|:---:|:---:|:---:|:---:|:---|
|일정 생성하기(저장)|POST|/api/apps|요청body|등록정보|- 성공: 201 Created|
|일정 전체 조회하기|GET|/api/apps||다건응답 정보|- 성공: - Status Code 200 OK<br>- 전체 일정x: 200 OK & []|
|일정 단건 조회하기|GET|/api/apps/{id}||단건응답 정보|- 성공: 200 OK<br>- 전체 일정x: 404 NotFound|
|일정 수정<br>(덮어쓰기)|PUT|/api/apps/{id}|요청body|수정 정보|- 성공: 200 OK<br>- 해당하는 일정x: 404 NotFound<br>- 입력할 값을 누락: 400 BadRequest|
|일정 삭제하기|DELETE|/api/apps/{id}|||- 성공: Status Code 200 OK<br>- 삭제하려는 일정x: 404 NotFound|


### ■ 일정 생성
#### □ 요청
|이름|타입|설명|필수여부|
|:---:|:---:|:---:|:---:|
|title|String|일정명|필수|
|content|String|일정 내용|필수|
|username|String|작성자 이름|필수|

<pre>
  <code>
    {
    "title": "제목", 
    "contents": "다음 주 월요일까지",
    "username": "000"
    }
  </code>
</pre>


#### □ 응답
|이름|타입|설명|
|:---:|:---:|:---:|
|id|string|아이디|
|title|String|일정명|
|content|String|일정 내용|


<pre>
  <code>
    {
    "id": "1"
    "title": "강의 듣기", 
    "contents": "다음 주 월요일까지",
    }
  </code>
</pre>

### 일정 전체 조회하기 
#### □ 응답
|이름|타입|설명|
|:---:|:---:|:---:|
|id|string|아이디|
|title|String|일정명|


<pre>
  <code>
    {[
    {
    "id": "1",
    "title": "강의 듣기",
    }
    {
    "id": "2",
    "title": "치과 진료",
        ..
    }
    ]}
  </code>
</pre>

### 일정 단건 조회하기
#### □ 응답
|이름|타입|설명|
|:---:|:---:|:---:|
|id|string|아이디|
|title|String|일정명|
|content|String|일정 내용|

<pre>
  <code>
    {
    "id": "1",
    "title": "강의 듣기",
    "contents": "다음 주 월요일 마감"
    }
    </code>
</pre>

### 일정 수정(덮어쓰기)
#### □ 요청
|이름|타입|설명|필수여부|
|:---:|:---:|:---:|:---:|
|title|String|일정명|필수|
|content|String|일정 내용|필수|

<pre>
  <code>
    {
    "title": "졸업논문 마감일", 
    "contents": "토익으로 대체가능"
    }
  </code>
</pre>

#### □ 응답
|이름|타입|설명|
|:---:|:---:|:---:|
|id|string|아이디|
|title|String|일정명|
|content|String|일정 내용|

<pre>
  <code>
    {
    "id": "1",
    "title": "졸업논문 마감일",
    "contents": "토익으로 대체가능"
    }
    </code>
</pre>

### 일정 삭제하기
#### □ 요청
|이름|타입|설명|필수여부|
|:---:|:---:|:---:|:---:|
|password|String|비밀번호|필수|

<pre>
  <code>
    {
    "password": "1234"
    }
    </code>
</pre>

#### □ 응답
<pre>
  <code>
   
  </code>
</pre>



# (Develop)일정관리 앱 ERD
![image](https://github.com/user-attachments/assets/cae5cbc3-360f-4a02-b3d8-ef9c9ad25cc3)




# 일정관리앱 SQL
### 1.스케줄 및 유저 테이블 생성 query(Create)
<pre>
  <code>
  //schedule 테이블 생성
  CREATE TABLE schedule (
  id int NOT NULL PRIMARY KEY,
  title varchar(45) NOT NULL,
  content varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  create_date datetime(6),
  update_date datetime(6));

 //user 테이블 생성
  create table user (
        age integer,
        created_at datetime(6),
        id bigint not null auto_increment,
        modified_at datetime(6),
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    ) 
  
  </code>
</pre>

### 2. 일정 및 유저 생성 query(Insert)
<pre>
  <code>
//schedule 생성
INSERT INTO schedule
(id, title, content, password, creat_date, update_date)
VALUES
(id: '1', '강의 듣기', '다음주 월요일 마감', '1234', '24-10-13', '24-10-15');

//user 생성
INSERT INTO user
(id, password, name, age)
VALUES
('1', '1234' , '000', '50');
  </code>
</pre>

### 3. 전체 일정 조회 query(Select)
<pre>
  <code>
SELECT id, title, content, password, create_date, update_date
FROM schedule;
    </code>
</pre>

### 4. 선택 일정 조회 query(Select) (일정명 조회)
<pre>
  <code>
SELECT title 
FROM schedule;
  </code>
</pre>   

### 5. 선택 일정 수정 및 유저 정보 수정 query(Update)
<pre>
  <code>
//schedule 정보 수정
UPDATE schedule
SET 
title='바뀐 제목',
contents='바뀐 내용'
WHERE id = 1;
    
//user 정보 수정
UPDATE user
SET
password= '바뀐 비밀번호'
name= '이름'
WHERE id = '1';
  </code>
</pre>

### 6. 선택 일정/유저 삭제 query(Delete)
<pre>
  <code>
DELETE FROM schedule
WHERE id=1
   </code>
</pre>

<pre>
  <code>
DELETE FROM user
WHERE id=1
   </code>
</pre>
