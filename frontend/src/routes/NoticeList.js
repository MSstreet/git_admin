import React, {useEffect, useState} from 'react';
import axios from "axios";
import {Link, useNavigate } from "react-router-dom";
import '../style/NoticeList.css'

const NoticeList = () => {
    const navigate = useNavigate();
    const [noticeList, setNoticeList] = useState([]);

    const getNoticeList = async () => {
        const resp = await (await axios.get('//localhost:8082/notice/list')).data; // 2) 게시글 목록 데이터에 할당
        setNoticeList(resp.data); // 3) boardList 변수에 할당

        const pngn = resp.pagination;
        console.log(pngn);
    }

    const moveToWrite = () => {
        navigate('/write');
    };

    useEffect(() => {
        getNoticeList(); // 1) 게시글 목록 조회 함수 호출
    }, []);

    return (
        <div className="container">
            <h1>공지사항</h1>
            <div className="button-container">
                <button onClick={moveToWrite}>글쓰기</button>
            </div>
            <table className="board-table">
                <thead>
                <tr>
                    <th>Number</th>
                    <th>Title</th>
                </tr>
                </thead>
                <tbody>
                {noticeList.map((notice) => (
                    <tr key={notice.noticeIdx}>
                        <td>{notice.noticeIdx}</td>
                        <td>
                            <Link to={`/notice/${notice.noticeIdx}`}>{notice.title}</Link>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>

        </div>
    );
};

export default NoticeList;