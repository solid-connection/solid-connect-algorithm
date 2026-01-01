# solid-connect-algorithm

Solid Connection 팀의 알고리즘 스터디 저장소입니다.

## 스터디 방식

### 주차별 공통 문제
- 매주 **3개의 공통 문제**를 풀고 인증합니다
- 문제는 GitHub Issue로 관리됩니다
- `weekly/weekXX/` 디렉토리에 각자의 풀이를 올립니다

### 개인 자유 문제
- 추가로 개인이 푼 문제는 `personal/{닉네임}/` 에 자유롭게 업로드합니다
- 플랫폼별로 폴더를 나눠서 관리합니다 (BOJ, Programmers, LeetCode 등)

## 디렉토리 구조

```
solid-connect-algorithm/
├── weekly/                      # 주차별 공통 문제
│   ├── week01/
│   │   ├── README.md           # 이번 주 문제 목록
│   │   ├── BOJ_1234_문제명/
│   │   │   ├── gyuhyeok99.py
│   │   │   └── member2.java
│   │   └── PGS_12345_문제명/
│   └── week02/
└── personal/                    # 개인별 자유 문제
    ├── gyuhyeok99/
    │   ├── BOJ/
    │   ├── Programmers/
    │   └── LeetCode/
    └── member2/
```

## 참여 방법

### 1. 주차별 공통 문제 풀이

1. 해당 주차의 Issue를 확인합니다
2. `weekly/weekXX/문제폴더/` 안에 `{본인닉네임}.{확장자}` 파일로 풀이를 작성합니다
3. 커밋 후 Push 합니다

```bash
# 예시
git add .
git commit -m "[Week01] BOJ 1234: 두 수의 합"
git push origin main
```

### 2. 개인 자유 문제 풀이

1. `personal/{닉네임}/{플랫폼}/` 에 파일을 작성합니다
2. 커밋 후 Push 합니다

```bash
git add .
git commit -m "[Personal] BOJ 5678: 문제이름"
git push origin main
```

## 커밋 컨벤션

```
[Week01] 플랫폼 문제번호: 문제명
[Personal] 플랫폼 문제번호: 문제명

# 예시
[Week01] BOJ 1234: 두 수의 합
[Week02] PGS 12345: 타겟 넘버
[Personal] LeetCode 1: Two Sum
```

## 플랫폼 약어

- `BOJ`: 백준 (Baekjoon Online Judge)
- `PGS`: 프로그래머스 (Programmers)
- `LTC`: 리트코드 (LeetCode)
- `CFS`: 코드포스 (Codeforces)
- `SWEA`: SW Expert Academy

## 스터디원

| 이름 | GitHub |
|------|--------|
| 강형준 | [@sukangpunch](https://github.com/sukangpunch) |
| 박인성 | [@Hexeong](https://github.com/Hexeong) |
| 조성혁 | [@whqtker](https://github.com/whqtker) |
| 정재희 | [@JAEHEE25](https://github.com/JAEHEE25) |
| 황규혁 | [@Gyuhyeok99](https://github.com/Gyuhyeok99) |


**Happy Coding!** 🚀
