# staffboard
<h2>Staff Board - Project #2021-03</h2>

사원의 정보를 등록하고, 수정, 삭제 및 검색 기능을 제공하는 간단한 관리 도구입니다. 작성 된 사원 정보를 엑셀로 다운로드 받고,
자바 메일을 통해 저장된 직원 정보 리스트 엑셀 파일을 전송하는 기능과,
크론 표현식과 Quartz를 통해 일정한 시간마다 이벤트를 발생시키는 기능을 결합시켜 정기적으로 이메일을 전송하는 기능도 구현해봤습니다.

<h3>DESCRIPTION</h3>
1. 사원 리스트
<img width="1417" alt="1" src="https://user-images.githubusercontent.com/81766957/146170729-59f2ce8b-7e2e-42b4-92ab-a854b56f0d22.png">
사원의 정보를 데이터베이스에 입력되어 있는 내용대로 불러와 화면에 뿌려줍니다.<br><br>

2. 사원 등록 및 검색
<img width="1424" alt="2" src="https://user-images.githubusercontent.com/81766957/146170975-124c4ae9-2b68-4b8b-8e51-c9cac1844d3d.png">
사원의 정보를 이름, 직급, 이메일 등에 포함되어 있는 키워드로 검색할 수 있습니다. 사원의 정보를 입력할 경우에는 정규 표현식을 통해서 적절한 이메일 형식을 충족하는지
(-@-.-)를 검사하고, 전화번호 또한 000-0000-0000 형태 또는 0000000000 로만 입력할 수 있도록 설정합니다.<br><br>

3. 사원 리스트를 엑셀로 다운로드
<img width="924" alt="4" src="https://user-images.githubusercontent.com/81766957/146172060-f7724d5c-0837-4ebc-bdc8-dd7b9ea30225.png">
데이터베이스에 저장된 사원 리스트를 엑셀 파일로 다운로드 합니다.<br><br>

4. Quartz 스케줄링
<img width="1481" alt="5" src="https://user-images.githubusercontent.com/81766957/146172178-fee99bc0-4fbc-4a98-b808-027693ebce64.png">
Quartz 스케줄링을 통해서 정기적인 이벤트 - 배치 프로그램을 실행할 수 있습니다. 해당 프로젝트에서는 이메일이 정해진 시간마다 자동으로 이메일이 전송되도록 합니다.<br><br>

5. JavaMail 이메일 전송
![6](https://user-images.githubusercontent.com/81766957/146172363-2ea3a03b-be11-49c4-b2ac-c321201a9c0c.png)
자바 메일을 통해 이메일을 보낼 수 있습니다. 별도의 버튼을 생성하여 이메일을 전송하도록 하거나, 스케줄링에 포함하여 자동으로 이메일이 지정된 스케줄에 따라 전송될 수
있습니다. 크론 표현식으로 원하는 시간 간격으로 이메일 전송을 받아봤습니다.
