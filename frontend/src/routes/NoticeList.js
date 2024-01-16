import React, {useEffect, useState} from 'react';
import axios from "axios";
import {Link} from "react-router-dom";

const NoticeList = () => {
    const [noticeList, setNoticeList] = useState([]);

    const getNoticeList = async () => {
        const resp = await (await axios.get('//localhost:8080/notice/noticeList')).data; // 2) 게시글 목록 데이터에 할당
        setNoticeList(resp.data); // 3) boardList 변수에 할당

        const pngn = resp.pagination;
        console.log(pngn);
    }

    useEffect(() => {
        getNoticeList(); // 1) 게시글 목록 조회 함수 호출
    }, []);

    return (
        <div>
            <ul>
                {noticeList.map((notice) => (

                    <li  key={notice.noticeIdx}>
                        <Link to={`/notice/${notice.noticeIdx}`}>{notice.title}</Link>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default NoticeList;