# pet 관리자

##  임명수
## 2024-01-09

- pet 관리자 환경셋팅
- 관리자 공지사항 게시판 CRUD 개발
  
#### ⚠️ 발생한 이슈 및 해결

1. can not resolve error

⚒️ 해결 방법  

- File > Project Structure > sdk 설정

2. access denied 에러 / unkown db 에러

⚒️ 해결 방법

- root 계정 접속 > db 생성 > 유저 생성 및 권한 설정

- ## 2024-01-14

- (react 사용) 공지사항 데이터 axios를 이용해 화면에 출력해보기
  
#### ⚠️ 발생한 이슈 및 해결

1. api 요청 시 cors 에러

⚒️ 해결 방법  

서버 쪽 Controller에 CrossOrigin 어노테이션 설정 

2. Objects are not valid as a React child 에러 발생

⚒️ 해결 방법

- 랜더링 할 때 오브젝트 타입을 그대로 화면에 출력하려 했기에 나타난 에러이기 때문에 랜더링 할 때 오브젝트 데이터를 처리해서 데이터 타입을 정확히 설정
  
- ### before
const NoticeList = () => {
    const [noticeList, setNoticeList] = useState([]);

    const getNoticeList = async () => {
        const resp = await (await axios.get('//localhost:8080/notice/noticeList')).data; 
        setNoticeList(resp.data); 

        const pngn = resp.pagination;
        console.log(pngn);
    }

    useEffect(() => {
        getNoticeList(); 
    }, []);

    return (
        <div>
           {noticeList}
        </div>
    );


- ### after
const NoticeList = () => {
    const [noticeList, setNoticeList] = useState([]);

    const getNoticeList = async () => {
        const resp = await (await axios.get('//localhost:8080/notice/noticeList')).data; 
        setNoticeList(resp.data); 

        const pngn = resp.pagination;
        console.log(pngn);
    }

    useEffect(() => {
        getNoticeList(); 
    }, []);

    return (
        <div>
            <ul>
                {noticeList.map((notice) => (
                    <li  key={notice.idx}>{notice.title}</li>
                ))}
            </ul>
        </div>
    );
};

#### 🖊️ 0114 느낀점 
- 리액트를 모르는 상태에서 맨 땅에 헤딩하니까 object를 어떻게 처리해서 랜더링 해야하는지도 몰랐다.. 개인프로젝트를 하면서 리액트에 대한 기본적인 학습 정도는 병행해야할 듯 싶었다. 
