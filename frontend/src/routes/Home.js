/* Home.js */
import React, {useEffect, useState} from 'react';
import {Link} from "react-router-dom";
import axios from "axios";
import "../style/Home.css"

const Home = () => {
    const [noticeList, setNoticeList] = useState([]);

    const getNoticeList = async () => {
        const resp = await (await axios.get('//localhost:8082/notice/list')).data; // 2) 게시글 목록 데이터에 할당
        setNoticeList(resp.data); // 3) boardList 변수에 할당

        const pngn = resp.pagination;
        console.log(pngn);
    }

    useEffect(() => {
        getNoticeList(); // 1) 게시글 목록 조회 함수 호출
    }, []);

    return (
        <div className="home-container">
            <div className="home-container">
            <div className="home-notice">
                <h3 className="notice-header">공지사항</h3>
                <table className="home-table">
                    <tbody>
                    {noticeList.map((notice) => (
                        <tr key={notice.noticeIdx}>
                            <td style={{width: "10%",}}>
                                <Link to={`/notice/${notice.noticeIdx}`}>{notice.title}</Link>
                            </td>
                            <td style={{width: "2%",}}>{notice.createdBy}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
            <div className="home-notice">
                <h3 className="notice-header">공지사항</h3>
                <table className="home-table">
                    <tbody>
                    {noticeList.map((notice) => (
                        <tr key={notice.noticeIdx}>
                            <td style={{width: "10%",}}>
                                <Link to={`/notice/${notice.noticeIdx}`}>{notice.title}</Link>
                            </td>
                            <td style={{width: "2%",}}>{notice.createdBy}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
            </div>
        </div>
    );
};

export default Home;