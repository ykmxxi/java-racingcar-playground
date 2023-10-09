# 📌 문자열 덧셈 계산기
- 문자열 덧셈 계산기를 통해 TDD/리팩토링 실습 진행
<br>
## 기능 요구사항
- 쉼표(`,`) 또는 콜론(`:`)을 구분자로 가지는 문자열을 전달한 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
  - 예시: `""` -> `0`, `"1,2"` -> `3`, `"1,2,3"` -> `6`, `"1,2:3"` -> `6`
- 앞의 기본 구분자(쉼표, 콜론)외에 구분자를 지정할 수 있다
- 커스텀 구분자는 문자열 앞부분의 `"//"`와 `"\n"` 사이에 위치하는 문자를 커스텀 구분자로 사용한다
  - 예시: `"//;\n1;2;3"` 같이 입력할 경우 커스텀 구분자는 세미콜론(`;`)이고, 결과는 `6`
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 `RuntimeException` 예외를 throw
<br>
## 프로그래밍 요구사항
- indent depth를 2단계에서 1단계로 줄인다
  - if문을 사용하는 경우 1단계 depth가 증가
  - if문 안에 while문을 사용하면 depth가 2
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다
  - 메소드가 한 가지 일만 하도록 최대한 작게 만든다
- else 예약어를 사용하지 않는다
<br>
## 필요한 행동들(기능 목록)
- 사용자의 입력을 받고, 결과를 출력한다: `View`
  - [ ] 입력을 받는다: `readString()`
- 사용자의 입력을 검증한다: `Validator`
  - [ ] 전체 검증을 진행한다: `validate()`
  - [ ] 구분자를 제외하고 숫자 이외의 값이 있는지 검사한다: `isNumber()`
  - [ ] 음수인지 검사한다: `isNegative()`
- 구분자(쉼표, 콜론, 커스텀 구분자)를 기준으로 입력을 구분한다: `Splitter`
  - [ ] 입력을 구분한다: `split()`
- 분리된 입력을 계산한다: `Calculator`
  - [ ] 값을 더한다: `add()`
- 각 역할들의 중간 매개체: `StringAddCalculator`
  - [ ] 입력을 구분자로 나누고 계산한다: `splitAndSum()`