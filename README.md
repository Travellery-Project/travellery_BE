
<img width="400" alt="Travellery-logo-removebg-preview" src="https://github.com/user-attachments/assets/afc93c12-1c80-4ec7-aac7-12b253e175e3" />

# Travellery 📸🗺️

여행 중에 찍은 수많은 사진들을 언제 어디서 찍었는지 한눈에 확인할 수 있는 모바일 앱입니다. 스마트폰으로 찍은 사진들을 앱에 등록하기만 한다면 언제, 어디서 찍었던 사진인지 장소별로 그룹핑하여 지도위에 순서대로 보여줍니다. 이렇게 등록한 나만의 여행기록들을 다른 사람과 함께 공유해 보세요!

## 🎯 프로젝트 개요

- **프로젝트명**: 트레블러리 (Travellery)
- **개발 기간**: 2023.12.18 - 2024.01.28 (7주)
- **개발 인원**: 1명 (FE, BE, Infra)
- **플랫폼**: React Native 모바일 애플리케이션

## 🔗 관련 저장소

- **Backend**: [travellery_BE](https://github.com/Travellery-Project/travellery_BE)
- **Frontend**: [travellery_FE](https://github.com/Travellery-Project/travellery_FE)

## 기능 둘러보기

### 📷 여행 사진 기록하기
- **자동 메타데이터 분석**: 업로드된 여행 사진의 GPS 메타데이터를 자동으로 추출
- **장소별 그룹핑**: 사진을 찍었던 장소별로 자동 그룹핑 및 타임라인 생성
- **도로명 주소 변환**: 네이버 Maps API를 통한 정확한 위치 정보 제공
- **상세 위치 및 설명 추가**: 사용자 정의 장소명 및 여행 기록 설명 작성


<div align="center" style="display: flex; justify-content: center; gap: 15px;">
  <img src="https://github.com/user-attachments/assets/9c65f5fd-49b7-47a0-bfe0-36ceabfd610c" style="width: 22%; max-width: 300px;" alt="Screenshot 6" />
  <img src="https://github.com/user-attachments/assets/dabac0f9-aae3-41b0-ac27-9ab1aa2b1a26" style="width: 22%; max-width: 300px;" alt="Screenshot 5" />
  <img src="https://github.com/user-attachments/assets/2842727d-9ba2-4a19-be30-f9353bd0d6e8" style="width: 22%; max-width: 300px;" alt="Screenshot 4" />
  <img src="https://github.com/user-attachments/assets/5ea39c0f-a677-49d7-ad43-8cf0d0675301" style="width: 22%; max-width: 300px;" alt="Screenshot 3" />
</div>

### 🗺️ 지도 기반 여행 시각화

- 촬영 장소별로 지도 위에 사진 오버레이 표시
- 여행 경로를 연결선으로 시각화하여 동선 확인
- 장소 순서대로 행선지 표시 및 네비게이션 기능
- 하단 슬라이드 패널을 통한 장소별 상세 정보 확인


<div align="center" style="display: flex; justify-content: center; gap: 15px;">
        <img src="https://github.com/user-attachments/assets/4486613b-d4d4-47d9-8f09-75be23f0cb30" style="width: 22%; max-width: 300px;"/>
        <img src="https://github.com/user-attachments/assets/65170f05-59d8-4a3c-a4db-c759e004d716" style="width: 22%; max-width: 300px;"/>
</div>

### 🌐 여행 기록 공유 (SNS)
- **실시간 피드**: 메인 피드를 통해 다른 사람들의 여행기록 실시간 공유
- **소셜 상호작용**: 여행 기록에 대한 찜(좋아요) 기능
- **찜 목록 관리**: 관심 있는 여행 기록 저장 및 관리
- **소셜 로그인**: 소셜 로그인을 통한 쉬운 접근성 및 프로필 관리

<div align="center" style="display: flex; justify-content: center; gap: 15px;">
  <img src="https://github.com/user-attachments/assets/feab8ec7-4bbb-44c0-ad20-a28e420d5b1d" style="width: 22%; max-width: 300px;" alt="Screenshot 6" />
  <img src="https://github.com/user-attachments/assets/4d8144cd-863b-4559-91df-ff4796734b66" style="width: 22%; max-width: 300px;" alt="Screenshot 5" />
</div>

### 🔍 여행 기록 검색
- **통합 검색**: 사용자, 태그, 여행지별로 키워드 검색 가능
- **실시간 자동완성**: 0.6초 디바운스 적용으로 빠른 검색 경험
- **카테고리별 필터링**: 다중 카테고리 검색으로 정확한 결과 제공
- **인기 컨텐츠**: 최근 1주일간 많은 찜을 받은 컨텐츠 우선 노출

### 📍 상세 위치 관리
- 네이버 지역정보 API를 통한 장소명 추천 (5개)
- 사용자 정의 장소명 설정
- 썸네일 이미지 선택 기능

## 🛠️ 기술 스택

### Frontend
- **React Native**: 크로스 플랫폼 모바일 개발
- **ContextAPI**: 상태 관리

### Backend
- **Spring Boot**: RESTful API 서버
- **Spring Data JPA**: 데이터베이스 ORM
- **Spring Security**: 인증 및 보안

### Database & Storage
- **MySQL**: 메인 데이터베이스
- **Amazon S3**: 이미지 파일 저장
- **Redis**: 캐싱 및 세션 관리

### Authentication
- **Firebase Authentication**: 소셜 로그인 (Google)

### External APIs
- **Naver Maps API**: 지도 서비스 및 위치 표시
- **Naver 지역정보 API**: 장소 정보 및 추천

## 🏗️ 시스템 아키텍처

```
┌─────────────────┐    ┌──────────────────┐    ┌─────────────────┐
│   React Native  │◄──►│   Spring Boot    │◄──►│     MySQL       │
│                 │    │     Server       │    │   Database      │
└─────────────────┘    └──────────────────┘    └─────────────────┘
         │                       │                       │
         ▼                       ▼                       ▼
┌─────────────────┐    ┌──────────────────┐    ┌─────────────────┐
│ Firebase Auth   │    │    Amazon S3     │    │     Redis       │
│ (Google Login)  │    │ (Image Storage)  │    │   (Caching)     │
└─────────────────┘    └──────────────────┘    └─────────────────┘
```

## 🎨 주요 화면

### 인증
- 소셜 로그인 (Google) 지원
- Spring Security 기반 JWT 토큰 인증

### 메인 피드
- 타임라인 형태의 여행 기록 표시
- 찜 기능 및 사용자 상호작용

### 여행 기록 등록
- 사진 업로드 및 GPS 메타데이터 자동 추출
- 장소 정보 입력 및 상세 설정
- 썸네일 선택 및 여행 경로 생성

### 지도 뷰
- 여행 경로 시각화
- 사진 오버레이 및 상세 정보 패널
- 인터랙티브 네비게이션

### 검색
- 실시간 검색 및 자동완성
- 카테고리별 필터링
- 인기 컨텐츠 추천

## 🚀 핵심 특징

1. **자동화된 여행 기록**: GPS 메타데이터를 활용한 자동 타임라인 생성
2. **직관적인 지도 인터페이스**: 시각적 여행 경로 표시 및 네비게이션
3. **소셜 네트워킹**: 찜 기능과 인기도 기반 컨텐츠 추천
4. **실시간 검색**: 빠른 응답성을 위한 디바운스 적용
5. **외부 API 통합**: 네이버 서비스와의 원활한 연동

## 📱 사용 시나리오

1. **사진 업로드**: 여행 중 촬영한 사진들을 앱에 업로드
2. **자동 분석**: 앱이 자동으로 GPS 메타데이터를 추출하여 촬영 위치 파악
3. **타임라인 생성**: 시간순으로 정렬된 여행 타임라인 자동 생성 및 장소별 그룹핑
4. **지도 시각화**: 지도 위에 여행 경로와 사진 위치를 순서대로 표시
5. **상세 정보 추가**: 각 장소별 설명 및 상세 위치 정보 추가
6. **소셜 공유**: 완성된 여행 기록을 다른 사용자들과 공유
7. **상호작용**: 다른 사용자의 여행 기록에 찜하기, 검색을 통한 여행 영감 획득

## 🎨 주요 특징

- **완전 자동화**: 사진만 업로드하면 자동으로 여행 기록 생성
- **직관적 인터페이스**: 지도 기반 시각적 여행 경로 표시
- **소셜 네트워킹**: 실시간 피드와 찜 기능으로 여행 경험 공유
- **스마트 검색**: 빠른 응답성과 정확한 결과를 위한 다중 카테고리 검색
- **외부 서비스 통합**: 네이버 Maps 및 지역정보 API 활용
