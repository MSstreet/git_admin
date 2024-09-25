import React, { useEffect,useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import Notice from '../components/Notice';
const NoticeDetail = () => {
    const { noticeIdx } = useParams();

    const [loading, setLoading] = useState(true);
    const [notice, setNotice] = useState({});
    const getNotice = async () => {
        const resp = await (await axios.get(`//localhost:8082/notice/${noticeIdx}`)).data;
        setNotice(resp.data);
        setLoading(false);
    };

    useEffect(() => {
        getNotice();
    }, []);

    return (
        <div>
            {loading ? (
                <h2>loading...</h2>
            ) : (
                <Notice
                    noticeIdx={notice.noticeIdx}
                    title={notice.title}
                    contents={notice.contents}
                    createdBy={notice.createdBy}
                />
            )}
        </div>
    );
};

export default NoticeDetail;