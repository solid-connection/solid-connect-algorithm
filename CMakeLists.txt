cmake_minimum_required(VERSION 3.10)

# 1. 프로젝트 이름 설정 (원하는 이름으로 변경 가능)
project(MyProject)

# 2. C++ 표준 설정 (C++11, 14, 17, 20 중 선택)
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# 3. 실행 파일 생성
# add_executable(실행파일명 소스파일.cpp)
# 예: main.cpp를 컴파일하여 my_program이라는 실행 파일을 만듦
add_executable(my_program /weekly/week02/BOJ_1965_상자넣기/Hexeong.cpp)