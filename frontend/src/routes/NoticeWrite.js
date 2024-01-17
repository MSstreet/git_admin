import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const NoticeWrite = () => {
    const navigate = useNavigate();

    const [notice, setNotice] = useState({
        title: '',
        createdBy: '',
        contents: '',
    });

    const { title, createdBy, contents } = notice; //비구조화 할당

    const onChange = (event) => {
        const { value, name } = event.target; //event.target에서 name과 value만 가져오기
        setNotice({
            ...notice,
            [name]: value,
        });
    };

    const saveNotice = async () => {
        await axios.post(`//localhost:8080/notice/insert`, notice).then((res) => {
            alert('등록되었습니다.');
            navigate('/notice');
        });
    };

    const backToList = () => {
        navigate('/notice');
    };

    return (
        <div>
            <div>
                <span>제목</span>
                <input type="text" name="title" value={title} onChange={onChange}/>
            </div>
            <br/>
            <div>
                <span>작성자</span>
                <input
                    type="text"
                    name="createdBy"
                    value={createdBy}
                    onChange={onChange}
                />
            </div>
            <br/>
            <div>
                <span>내용</span>
                <textarea
                    name="contents"
                    cols="30"
                    rows="10"
                    value={contents}
                    onChange={onChange}
                ></textarea>
            </div>
            <br/>
            <div>
                <button onClick={saveNotice}>저장</button>
                <button onClick={backToList}>취소</button>
            </div>
        </div>
    );
};

export default NoticeWrite;