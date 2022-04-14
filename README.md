# Discription
---
### Chartgame이란 
가상으로 코인을 거래하고 결괏값을 랭크 시스템으로 반영하는 시뮬레이션 게임입니다.

프로젝트 목표는 실제 거래소에서 지원하는 기능을 구현하되 독립적인 게임 생태계를 구축하는 것입니다.

앞으로 꾸준히 업데이트해 나갈 예정입니다.

#### 완성도를 갖춰가는 프로젝트를 지켜봐 주세요! 😎✌

### 22/04/14) chartgame - ver 1.0

# Update
---
22/04/14) 프로젝트 업로드

chartgame - ver 1.0

# Oracle SQL
---
22/04/14) chartgame - ver 1.0

[GoogleDrive] https://drive.google.com/file/d/1-xDdzdYY4jCxWvUKYLTYoXYdYbX3-98Y/view?usp=sharing

# Usage
---
1) 프로젝트를 실행한 후 'cmd'나 프로젝트의 'Terminal' 창에서 chartgame 폴더의 static 경로 이동 -> node kline 명령어 입력

ex)![kline](https://user-images.githubusercontent.com/88640259/163420891-1bfc351f-dcad-4e41-9e19-265da0802966.png)


2) 프로젝트를 실행한 후 'cmd'나 프로젝트의 'Terminal' 창에서 chartgame 폴더의 static -> RESTGETAPIProxy -> node restproxy 명령어 입력

ex)![rest](https://user-images.githubusercontent.com/88640259/163420907-ebb24eca-b4a0-4b1e-9da0-71428b5c9a02.png)


# LOG
---
22/04/14) 임시 비밀번호 발송 기능을 주석 처리해 두었습니다.  

사용을 원하시면 아래의 과정을 순서대로 진행하시면 됩니다.

1) application.yml -> gmail Transfer 주석해제 -> username에 gmail작성 ex) 1234@gmail.com -> password에서 gmail 앱 비밀번호 입력

2) controller -> FindController.java로 이동 -> 주석 처리된 import 주석 해제  및 findPwResult 메소드 주석 해제

3) src -> webapp -> WEB-INF -> view -> findPw.jsp로 이동 -> h2태그 중 '임시 비밀번호 발급' 뒤의 문자열 삭제 

