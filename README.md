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

## 브랜치 전략

각 참여자는 **자신의 GitHub 닉네임으로 개인 브랜치**를 만들어서 작업합니다.

```
main (보호 브랜치)
├── sukangpunch
├── Hexeong
├── whqtker
├── JAEHEE25
└── Gyuhyeok99
```

## 참여 방법

### 0. 최초 1회 설정 (저장소 클론 및 브랜치 생성)

```bash
# 저장소 클론
git clone https://github.com/solid-connection/solid-connect-algorithm.git
cd solid-connect-algorithm

# 자신의 브랜치 생성 및 이동 (닉네임으로 변경)
git checkout -b {본인닉네임}

# 예시: gyuhyeok99 브랜치 생성
git checkout -b Gyuhyeok99
```

### 1. 주차별 공통 문제 풀이

1. 자신의 브랜치로 이동
2. 최신 main 브랜치 내용 가져오기
3. 문제 풀이 작성
4. 커밋 & 푸시
5. Pull Request 생성

```bash
# 1. 자신의 브랜치로 이동
git checkout Gyuhyeok99

# 2. main 브랜치 최신 내용 가져오기
git pull origin main

# 3. 문제 풀이 작성
# weekly/week01/BOJ_1234_문제명/Gyuhyeok99.py 파일 작성

# 4. 커밋 & 푸시
git add .
git commit -m "[Week01] BOJ 1234: 두 수의 합"
git push origin Gyuhyeok99

# 5. GitHub에서 Pull Request 생성
# Gyuhyeok99 → main
```

### 2. 개인 자유 문제 풀이

개인 문제는 자신의 브랜치에서 자유롭게 작업합니다.

```bash
# 자신의 브랜치에서 작업
git checkout Gyuhyeok99

# personal 폴더에 풀이 작성
# personal/Gyuhyeok99/BOJ/1000_A+B.py

git add .
git commit -m "[Personal] BOJ 1000: A+B"
git push origin Gyuhyeok99

# PR 생성 또는 주기적으로 머지
```

### 3. Pull Request 머지 후

```bash
# main 브랜치로 이동
git checkout main

# 최신 내용 가져오기
git pull origin main

# 자신의 브랜치로 이동
git checkout Gyuhyeok99

# main 내용을 자신의 브랜치에 반영
git merge main
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
| 임수연 | [@lsy1307](https://github.com/lsy1307) |
| 조성혁 | [@whqtker](https://github.com/whqtker) |
| 정재희 | [@JAEHEE25](https://github.com/JAEHEE25) |
| 황규혁 | [@Gyuhyeok99](https://github.com/Gyuhyeok99) |


**Happy Coding!** 🚀
