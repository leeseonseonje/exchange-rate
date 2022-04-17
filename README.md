# 환율 계산
환율API를 이용하여 각 나라별 환율 정보를 가져와 총 수취금액을 보여주는 앱

## 기술 스택
```
IDE: IntelliJ 
BackEnd: Java11, Spring Boot(2.6.6) Spring MVC, Spring Webflux(WebClient)
FrontEnd: thymeleaf, javascript, axios, bootstrap
```

## API
### 각 나라별 환율 조회
#### 요청
```
Method: get
url: /exchange-rate/{recipientCountry}
```
#### 응답
```
응답 url: http://localhost:8080/exchange-rate/KRW
{
    "recipientCountry": "KRW",
    "exchangeRate": 1229.09
}
```
### 환율에 따른 송금액 계산
#### 요청
```
Method: get
url: /exchange-rate/{recipientCountry}/{remittance}
```
#### 응답
```
응답 url: http://localhost:8080/exchange-rate/KRW/100
{
    "amountReceived": "122,909.00",
    "recipientCountry": "KRW"
}
```

## 화면
<img width="643" alt="스크린샷 2022-04-17 오후 11 32 35" src="https://user-images.githubusercontent.com/72899707/163719160-bdba8d57-8d4c-44a5-bb7e-a0d6ea775687.png">

## 결과
<img width="639" alt="스크린샷 2022-04-17 오후 11 34 53" src="https://user-images.githubusercontent.com/72899707/163719239-58971d6e-9f7f-449c-b6c6-c506f5564c21.png">

## 예외 처리

### 숫자가 아닌 송금액
<img width="620" alt="스크린샷 2022-04-17 오후 11 35 38" src="https://user-images.githubusercontent.com/72899707/163719376-2b76a0c2-8ecd-4dd8-9a27-563a16739cc6.png">

### 1달러 보다 낮은 금액 입력
<img width="611" alt="스크린샷 2022-04-17 오후 11 37 51" src="https://user-images.githubusercontent.com/72899707/163719388-256e6623-ea2f-4e90-a242-69b275afefda.png">

### 10000달러 보다 높은 금액 입력 
<img width="609" alt="스크린샷 2022-04-17 오후 11 36 00" src="https://user-images.githubusercontent.com/72899707/163719402-3ffa2e9b-9713-42f8-8a30-61f40ecd459a.png">





