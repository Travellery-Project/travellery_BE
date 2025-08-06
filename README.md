
<img width="400" alt="Travellery-logo-removebg-preview" src="https://github.com/user-attachments/assets/afc93c12-1c80-4ec7-aac7-12b253e175e3" />

# 🗺️ Travellery 📸

여행 중에 찍은 수많은 사진들을 언제 어디서 찍었는지 한눈에 확인할 수 있는 모바일 앱입니다. 스마트폰으로 찍은 사진들을 앱에 등록하기만 한다면 언제, 어디서 찍었던 사진인지 장소별로 그룹핑하여 지도위에 순서대로 보여줍니다. 이렇게 등록한 나만의 여행기록들을 다른 사람과 함께 공유해 보세요!

## 🎯 프로젝트 개요

- **프로젝트명**: 트레블러리 (Travellery)
- **개발 기간**: 2023.12.18 - 2024.01.28 (7주)
- **개발 인원**: 1명 (FE, BE, Infra)
- **플랫폼**: React Native 모바일 애플리케이션

## 🛠️ 기술 스택

### Frontend
![React Native](https://img.shields.io/badge/React_Native-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)

### Backend
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

### Database & Storage
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Amazon S3](https://img.shields.io/badge/Amazon_S3-569A31?style=for-the-badge&logo=amazons3&logoColor=white)
![Redis](https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white)

### Authentication
![Firebase](https://img.shields.io/badge/Firebase-FFCA28?style=for-the-badge&logo=firebase&logoColor=black)

### External APIs
![Naver](https://img.shields.io/badge/Naver_Maps-03C75A?style=for-the-badge&logo=naver&logoColor=white)
![Naver](https://img.shields.io/badge/Naver_Places-03C75A?style=for-the-badge&logo=naver&logoColor=white)


## 🏗️ 시스템 아키텍처

<img width="1166" height="511" alt="스크린샷 2025-08-05 오후 10 16 44" src="https://github.com/user-attachments/assets/99cdda26-70bb-4003-ae73-056f9c1115c7" />

## 기능 둘러보기

### 📷 여행 사진 기록하기
- **자동 메타데이터 분석**: 업로드된 여행 사진의 GPS 메타데이터를 자동으로 추출
- **장소별 그룹핑**: 사진을 찍었던 장소별로 자동 그룹핑 및 타임라인 생성
- **도로명 주소 변환**: 네이버 Maps API를 통한 정확한 위치 정보 제공
- **상세 위치 및 설명 추가**: 사용자 정의 장소명 및 여행 기록 설명 작성
- **위치 기반 장소 추천**: 네이버 지역정보 API를 통한 장소명 추천 (5개)


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
  <img src="https://github.com/user-attachments/assets/6f57f817-5249-49a1-825e-b9b54bcddab0" style="width: 22%; max-width: 300px;" alt="Screenshot 5" />
  <img src="https://github.com/user-attachments/assets/4d7d14fb-9934-48a2-a250-a81f2557d4f3" style="width: 22%; max-width: 300px;" alt="Screenshot 5" />
</div>

### 🔍 여행 기록 검색
- **통합 검색**: 사용자, 태그, 여행지별로 키워드 검색 가능
- **카테고리별 필터링**: 다중 카테고리 검색기능 제공
- **인기 컨텐츠**: 최근 1주일간 많은 찜을 받은 컨텐츠 우선 노출

<div align="center" style="display: flex; justify-content: center; gap: 15px;">
  <img src="https://github.com/user-attachments/assets/eb6dee70-cd4f-4353-8845-6529f069bfbf" style="width: 22%; max-width: 300px;" alt="Screenshot 6" />
  <img src="https://github.com/user-attachments/assets/c5da9bb9-591a-48a7-8874-c6bdec7edeb6" style="width: 22%; max-width: 300px;" alt="Screenshot 5" />
</div>

## Travellery 프로젝트를 하면서...

- [N + 1 과 페이지네이션 (feat. batch_fetch_size)](https://www.notion.so/N-1-feat-batch_fetch_size-44c5226f26ab4196b6f4803299bc9beb?pvs=21)

- [서버 성능 개선 맛보기(feat. Jmeter)](https://www.notion.so/feat-Jmeter-0335ab28dee84d599d4ccc94593b9598?pvs=21)

- [이미지 업로드 작업과 서버 가용성](https://www.notion.so/6556adc996974a8a8ef9a94736d3142e?pvs=21)

