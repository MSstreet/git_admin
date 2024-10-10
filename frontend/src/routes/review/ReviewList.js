import React, {useEffect, useState} from 'react';
import axios from "axios";
import {Link } from "react-router-dom";

const ReviewList = () => {
    const [reviewList, setReviewList] = useState([]);
    const [selectedApprove, setSelectedApprove] = useState('all');

    const handleChange = (event) => {
        setSelectedApprove(event.target.value);
        console.log(event.target.value)
    };

    const filteredData = selectedApprove === 'all'
        ? reviewList
        : reviewList.filter(item => item.approveYn === selectedApprove);



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
            <select onChange={handleChange} value={selectedApprove}>
                <option value="all">All</option>
                <option value={1}>승인</option>
                <option value={0}>미승인</option>
            </select>
            <table className="board-table">
                <thead>
                <tr>
                    <th style={{width: "5%",}}>no</th>
                    <th style={{width: "39%",}}>title</th>
                    <th style={{width: "39%",}}>contents</th>
                    <th style={{width: "39%",}}>hospital name</th>
                    <th style={{width: "5%",}}>score</th>
                    <th style={{width: "5%",}}>approve state</th>
                    <th style={{width: "5%",}}>createBy</th>
                    <th style={{width: "5%",}}>createAt</th>

                </tr>
                </thead>
                <tbody>
                {filteredData.map((review) => (
                    <tr key={review.reviewIdx}>
                        <td>{review.reviewIdx}</td>
                        <td>{review.title}</td>
                        <td>
                            <Link to={`/review/${review.reviewIdx}`}>{review.content}</Link>
                        </td>
                        <td>{review.hospitalName}</td>
                        <td>{review.score}</td>
                        <td>{review.approveYn}</td>
                        <td>{review.createdBy}</td>
                        <td>{review.createdAt}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default ReviewList;