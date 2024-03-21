# Git & Github 연습 레파지토리

아직 미숙한 Git 과 Github 명령어 연습과 README.md 작성 연습 공간입니다.

혹시나 아 저거 아닌데 하는 게 있으시다면 죄송합니다.

계속해서 수정해 나가겠습니다.

현재 테스트한 항목

- git init
  - workspace 에 깃 생성 (차후 수정)
- git log
  - commit, push 등 기록 확인 
- git checkout -b '브랜치 이름'
  - 로컬 브랜치 생성 후 해당 브랜치로 이동
- git checkout '브랜치 이름'
  - 해당 브랜치 이동
- git remote add origin '깃허브 주소'
  - 로컬 저장소와 원격 저장소 연동
- git add <파일명>
  - 해당 파일 저장
- git add .
  - 현재 디렉토리 모든 변경 내용을 스테이징으로 넘김
- git commit -m '메시지'
  - 로컬 저장소로 변경 내용 보내기
- git push origin <브랜치 이름>
  - 원격 저장소로 변경 내용 보내기
- git pull
  - 원격 저장소로부터 변경 내용 내려받기
- git fetch
  - 원격 저장소의 최신 내용을 확인하지만, 로컬 저장소로 가져오진 않는다


- git log --decorate --all --online
  - 모든 브랜치의 로그 확인
- git diff HEAD origin/main
  - 로컬 브랜치와 원격 저장소의 최신 내용 중 다른 점 확인
