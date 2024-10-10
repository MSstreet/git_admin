import React, { useEffect,useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import Review from "../../components/Review";

const ReviewDetail = () => {
    const { reviewIdx } = useParams();

    const [loading, setLoading] = useState(true);
    const [review, setReview] = useState({});
    const getReview = async () => {
        const resp = await (await axios.get(`//localhost:8082/review/${reviewIdx}`)).data;
        setReview(resp.data);
        setLoading(false);
    };

    useEffect(() => {
        getReview();
    }, []);

    return (
        <div>
            {loading ? (
                <h2>loading...</h2>
            ) : (
                <Review
                    reviewIdx={review.reviewIdx}
                    title={review.title}
                    contents={review.content}
                    createdBy={review.createdBy}
                />
            )}
        </div>
    );
};

export default ReviewDetail;