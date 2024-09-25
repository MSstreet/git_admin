/* Notice.js */
import React from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const Notice = ({ noticeIdx, title, contents, createdBy }) => {
    const navigate = useNavigate();

    const moveToUpdate = () => {
        navigate('/update/'+noticeIdx);
    };
    const deleteNotice = async () => {
        if (window.confirm('공지글을 삭제하시겠습니까?')) {
            await axios.delete(`//localhost:8082/notice/${noticeIdx}`).then((res) => {
                alert('삭제되었습니다.');
                navigate('/notice');
            });
        }
    };
    const moveToList = () => {
        navigate('/notice');
    };

    return (
        <div>
            <div>
                <h2>{title}</h2>
                <h5>{createdBy}</h5>
                <hr/>
                <p>{contents}</p>
            </div>
            <div>
                <button onClick={moveToUpdate}>수정</button>
                <button onClick={deleteNotice}>삭제</button>
                <button onClick={moveToList}>목록</button>
            </div>
        </div>
    );
};

export default Notice;