# BaseBall Game

## 기능 요구사항
### BaseBall
- createRandomNumber()
  - 랜덤하게 3자리 숫자를 생성
  - 각 자리별 숫자는 겹치지 않게 생성

- clearRandomNumbers()
  - 새 게임을 진행할 시 이미 뽑혀있는 숫자 list를 초기화

### BaseBallGameController
- run()
  - 전체적인 야구 게임을 실행

- startGame()
  - View에서 입력받은 숫자를 가지고 게임 진행
  - 스트라이크와 볼 판단

- judge()
  - 스트라이크와 볼을 판단
  - 3스트라이크인지 판단하여 게임 진행 여부를 판단

- clearToZeroStrikeAndBall()
  - 스트라이크와 볼을 초기화

- countBall()
  - 볼의 갯수를 리턴

- countStrike()
  - 스트라이크의 갯수를 리턴

### BaseBallGameView
- inputNumber()
  - 게임 진행중 사용자의 숫자를 입력받고 리턴

- printStrikeAndBall()
  - 스트라이크가 몇개고, 볼이 몇개인지 console에 출력

- restartOREndGame()
  - 게임 재시작 또는 종료를 입력 받고 리턴

### Main
- main()
  - BaseBallGameController를 구동