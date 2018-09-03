# Docker Oracle-xe Install
***

## 01 도커 설치

### docker install

```
$ curl -fsSL https://get.docker.com/ | sudo sh
```


### 권한주기 

```
$ sudo usermod -aG docker $USER # 현재 접속중인 사용자에게 권한주기
```

or
```
$ sudo usermod -aG docker your-user # your-user 사용자에게 권한주기
```

### show docker version

```
$ docker version
```


## 02 도커 이미지 설치 및 실행

### search oracl-xe
```
$ docker search oracle-xe
...
```
<https://hub.docker.com/r/alexeiled/docker-oracle-xe-11g/>


### run

```
$ docker run -d --shm-size=2g -p 1521:1521 -p 8080:8080 alexeiled/docker-oracle-xe-11g
```

or

make volume
```
$ mkdir -p /myDocker/usr/lib/oracle/xe/oradata/XE
```

```
$ docker run -d --shm-size=2g -p 51521:1521 -p 58080:8080 \
> -v /myDocker/usr/lib/oracle/xe/oradata/XE:/usr/lib/oracle/xe/oradata/XE \
> --name docker-oracle-xe \
> alexeiled/docker-oracle-xe-11g
```

### check docker run
```
$ docker ps
```


## 03 오라클에 유저 만들기

### into docker-oracle-xe container
```
$ docker exec -it docker-oracle-xe /bin/bash
```

### create oracle user
on docker-oracle-xe container shell
```
# sqlplus system/oracle
```

on sqlplus shell
```
SQL> CREATE USER java INDENTIFIED BY oracle;
SQL> GRANT connect, resource TO java;
SQL> exit;
```
