
-- 메뉴구조를 생성해 보아요~~
create table menus (
  mnu_id  char(5) not null,
  mnu_name varchar2(60) not null,
  mnu_link varchar2(300) ,
  mnu_parent char(5), 
  primary key (mnu_id)
);

INSERT INTO menus values ('MN001','고객지원', null, null);
INSERT INTO menus values ('MN002','서비스지원', null, 'MN001');
INSERT INTO menus values ('MN003','사용자등록', null, 'MN001');
INSERT INTO menus values ('MN004','업무안내', '/myc/businessinfo.do', 'MN002');
INSERT INTO menus values ('MN005','수출신고지원센터안내', '/myc/support.do', 'MN002');
INSERT INTO menus values ('MN006','마이페이지', null, null);
INSERT INTO menus values ('MN007','개인정보관리', null, 'MN006');
INSERT INTO menus values ('MN008','개인화관리', null, 'MN006');
INSERT INTO menus values ('MN009','개인정보수정', '/myc/myinfo.do', 'MN007');
INSERT INTO menus values ('MN010','비밀번호변경', '/myc/password.do', 'MN007');



