import React, {useEffect, useState} from 'react';
import axios from "axios";
import {Link, useNavigate } from "react-router-dom";

const ReviewList = () => {

    const [reviewList, setReviewList] = useState([]);

    const getReviewList = async () => {
        const resp = await (await axios.get('//localhost:8082/review/list')).data; // 2) 리뷰 목록 데이터에 할당
        setReviewList(resp.data); // 3) reviewList 변수에 할당

        const pngn = resp.pagination;
        console.log(pngn);
    }

    useEffect(() => {
        getReviewList(); // 1) 리뷰 목록 조회 함수 호출
    }, []);

    return (
        <div className="container">
            <h1>리뷰목록</h1>
            <table className="board-table">
                <thead>
                <tr>
                    <th style={{width: "5%",}}>No</th>
                    <th style={{width: "39%",}}>Contents</th>
                    <th style={{width: "5%",}}>Score</th>
                    <th style={{width: "5%",}}>CreateAt</th>
                    <th style={{width: "5%",}}>UpdatedAt</th>
                    <th style={{width: "2%",}}>Views</th>
                </tr>
                </thead>
                <tbody>
                {reviewList.map((review) => (
                    <tr key={review.reviewIdx}>
                        <td>{review.reviewIdx}</td>
                        <td>
                            <Link to={`/review/${review.reviewIdx}`}>{review.content}</Link>
                        </td>
                        <td>{review.createdBy}</td>
                        <td>{review.createdAt}</td>
                        <td>{review.updatedAt}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default ReviewList;