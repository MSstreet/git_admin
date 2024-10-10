/* Review.js */
import React from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const Review = ({reviewIdx,title,contents,createdBy}) => {
    const navigate = useNavigate();
    const moveToApprove = async () => {
        if (window.confirm('리뷰를 승인하시겠습니까?')) {
            await axios.patch(`//localhost:8082/review/approve/${reviewIdx}`).then((res) => {
                alert('승인되었습니다.');
            });
        }
    };
    const deleteReview = async () => {
        if (window.confirm('리뷰를 삭제하시겠습니까?')) {
            await axios.delete(`//localhost:8082/review/${reviewIdx}`).then((res) => {
                alert('삭제되었습니다.');
                navigate('/review');
            });
        }
    };
    const moveToList = () => {
        navigate('/review');
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
                <button onClick={moveToApprove}>승인</button>
                <button onClick={deleteReview}>삭제</button>
                <button onClick={moveToList}>목록</button>
            </div>
        </div>
    );
};

export default Review;