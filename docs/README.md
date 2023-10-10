# 📌 자동차 경주 게임 구현
## 필요한 행동들(기능 목록)
- OutputView: 출력과 관련된 유틸성 메서드를 제공하는 객체
  - [x] 자동차 이름 입력을 위한 가이드를 출력한다: `printNameInputGuide`
  - [x] 게임 시도 횟수 입력을 위한 가이드를 출력한다: `printNumberOfAttemptsGuide`
  - [ ] 게임 실행 결과를 출력한다: `printExecutionResult`
  - [ ] 게임 우승자를 알려준다: `printChampionNames`
- InputView: 사용자의 입력을 받는 메서드를 제공하는 객체
  - [x] 자동차 이름들을 입력 받는다: `readCarNames`
  - [x] 시도할 횟수를 입력 받는다: `readNumberOfAttempts`
  - [x] 공백을 검사한다: `isEmptyOrWhitespaces`
    - 입력을 받는 계층에서 간단한 검증을 한다
- RandomNumberGenerator: 랜덤 값 생성 유틸성 메서드를 제공하는 객체
  - [x] 0에서 9사이의 값을 생성한다: `createRandomNumber`
- GameOperator: 게임 운영과 관련된 메서드를 제공하는 객체
  - [ ] 입력받은 자동차 이름을 구분해 알려준다: `splitCarNames`  
  - [x] 생성한 random 값이 4보다 큰지 알려준다: `isGreaterThanOrEqualThanFour`
- Car:
  - [x] 게임 운영 객체에게 자신이 움직여도 되는지 물어본다: `canMove`
  - [x] 움직인 후 본인의 위치를 갱신한다: `updatePosition`
- Validator: 입력을 검증하는 메서드를 제공하는 객체
  - [x] 자동차 이름이 5자 이하인지 검증한다: `isLessThanOrEqualFive`
  - [x] 자동차가 2대 이상인지 검증한다: `isCarCountGreaterThanOrEqualTwo`
  - [x] 1에서 9사이의 자리 숫자를 입력했는지 검증한다: `isBetweenOneAndNine`
    - 너무 큰 숫자를 받으면 게임이 길어지기 때문에 제약을 둔다
- GameController
  - [ ] 자동차 이름을 입력 받고 검증한다:
  - [ ] 게임 시도 횟수를 입력 받고 검증한다:
  - [ ] 게임을 진행하고, 각 라운드 결과를 출력한다: 
  - [ ] 최종 우승자를 출력한다:
- GameService
  - [ ] 라운드를 진행(자동차 전진)한다: 
  - [ ] 최종 우승자를 알려준다:

## 기능 요구사항
- 각 자동차에 이름을 부여할 수 있다. 단 자동차 이름은 5자를 초과할 수 없음
- 자동차는 자동차 이름과 위치 정보를 가지는 Car 객체를 추가해 구현한다
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다
- 자동차 이름은 쉼표(`,`)를 기준으로 구분한다
- 전진하는 조건은 0에서 9사이에서 random 값을 구한 후 random 값이 4이상일 경우이다
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
<br>
## 실행 결과
```text
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.
```
## 프로그래밍 요구사항
- 자바 코드 컨벤션을 지킨다
- indent depth를 3이 넘지 않도록 구현, 2까지만 허용한다
  - while문 안에 if문이 있는 것은 depth가 2이다 (가능)
- else 예약어를 쓰지 않는다
  - switch/case도 허용하지 않는다
- 3항 연산자를 쓰지 않는다
- 메소드가 한 가지 일만 하도록 최대한 작게 만든다
- **모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다**. 단 UI(System.out, System.in) 로직은 제외
  - 핵심 로직 코드와 UI 담당 로직을 구분한다
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리
- **모든 원시 값과 문자열을 포장한다**
- **일급 컬렉션을 쓴다**
