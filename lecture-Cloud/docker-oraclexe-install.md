# Docker Oracle-xe Install
***

## 01. 도커 설치

### docker install

```
$ curl -fsSL https://get.docker.com/ | sudo sh
```


### 권한주기 

```
$ sudo usermod -aG docker $USER # 현재 접속중인 사용자에게 권한주기
```

또는..

```
$ sudo usermod -aG docker your-user # your-user 사용자에게 권한주기
```

### show docker version

```
$ docker version
```


## 02. 도커 이미지 설치 및 실행

### search oracl-xe

```
$ docker search oracle-xe
...
```

설치할 이미지
<https://hub.docker.com/r/alexeiled/docker-oracle-xe-11g/>


### pull image

```
$ docker pull alexeiled/docker-oracle-xe-11g
```

### run

```
$ docker run -d --shm-size=2g -p 1521:1521 -p 8080:8080 alexeiled/docker-oracle-xe-11g
```

또는..

```
$ sudo mkdir -p /myDocker/usr/lib/oracle/xe/oradata/XE # 연결시킬 볼륨 만들기
```

```
$ docker run -dit --restart unless-stopped \
> --shm-size=2g -p 51521:1521 -p 58080:8080 \
> -v /myDocker/usr/lib/oracle/xe/oradata/XE:/usr/lib/oracle/xe/oradata/XE \
> --name docker-oracle-xe \
> alexeiled/docker-oracle-xe-11g
```

// desc
run : 컨테이너 실행
-dit : 디태치, 인터렉티브, 티티와이
--restart unless-stopped : 호스트 재부팅 시 자동 컨테이너 스타트
--shm-size=2g : 2g 메모리 할당
-p : 포트 바인딩 호스트-도커
-v : 볼륨 바인딩 호스트-도커
--name : 컨테이너 이름

### check docker run

```
$ docker ps
```

## 03. 오라클에 유저 만들기

### into docker-oracle-xe container

```
$ docker exec -it docker-oracle-xe /bin/bash
```

// descr
exec : 컨테이너 안으로 접근하기

### create oracle user

on docker-oracle-xe container shell
```
# sqlplus system/oracle
```

on sqlplus shell
```
SQL> CREATE USER java IDENTIFIED BY oracle;
SQL> GRANT connect, resource TO java;
SQL> exit;
```
