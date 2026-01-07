# 🧮 FlowChart ATM System

**FlowChart로 ATM 입/출금 로직을 설계하고 Java로 구현한 연습**

---

## ✅ 시나리오: 최댓값 출력 시스템
- 사용자는 ATM 메뉴를 통해 입금 / 출금 / 종료를 선택할 수 있다.  
- 현재 잔액을 기준으로 금액이 처리된다.  
- 출금 시 잔액이 부족하면 출금이 제한된다.

---

## 🧩 FlowChart

![25](https://github.com/user-attachments/assets/34847e90-85ae-43c4-a5be-2d4348ce2397)

---

## 📌 입력 / 출력 정리

### 입력(Input)
- balance : 초기 잔액
- menu : 메뉴 선택 번호
- money : 입금/출금 금액

### 출력(Output)
- balance == 0
- menu == 0

### 상태(State)
- balance : 현재 잔액
- menu : 사용자 메뉴 선택값 (1:입금 / 2:출금 / 0:종료)
- money : 입금/출금 금액

---

## 🔎 조건 정리

### 종료 조건
- balance == 0
- menu == 0

### 분기 조건
- menu == 1 : 입금 처리
- menu == 2 : 출금 처리
- menu == 0 : 종료
- default : "잘못된 입력입니다." 출력 후 재입력

### 예외 / 에러 조건
- 출금 시 money >= balance : "잔액이 부족합니다."

---

## 🔁 로직 흐름 설계

1. 시작 시 한 번만 실행
   - 초기 잔액 balance를 입력받아 저장한다.

2. 반복
   1) 현재 잔액을 출력한다.  
   2) 메뉴를 출력한다.  
      - 1: 입금  
      - 2: 출금  
      - 0: 종료  
   3) 메뉴 번호 menu를 입력받는다.  
      - menu == 1: 입금할 금액 money 입력 → balance = balance + money  
      - menu == 2: 출금할 금액 money 입력 → 잔액 검사 후 balance = balance - money  
      - menu == 0: "이용해주셔서 감사합니다" 출력 후 프로그램 종료  

3. 종료 시
- 프로그램을 종료한다.

---

## 🛠️ 실행 방법

```bash
# 컴파일
javac Main.java

# 실행
java Main
