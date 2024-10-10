import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import axios from 'axios';
import { registerUser } from "../../actions/user_action";
// import Auth from "../../hoc/auth";
import '../../style/Join.css';

function Join() {

    const dispatch = useDispatch();
    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        userId: '',
        userPw: '',
        userName: '',
        confirmPassword: '',
    });

    const [errors, setErrors] = useState({
        userId: '',
        userPw: '',
        userName: '',
        confirmPassword: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        const error = validate(name, value);

        setFormData({
            ...formData,
            [name]: value,
        });

        setErrors({
            ...errors,
            [name]: error,
        });
    };

    const validate = (name, value) => {
        switch (name) {
            case 'userName':
                if (value.length < 2) {
                    return '사용자 이름은 2자 이상이어야 합니다.';
                }
                return '';
            case 'userId':
                return '';
            case 'userPw':
                if (value.length < 6) {
                    return '비밀번호는 6자 이상이어야 합니다.';
                }
                return '';
            case 'confirmPassword':
                if (value !== formData.userPw) {
                    return '비밀번호와 비밀번호 확인이 같아야 합니다.';
                }
                return '';
            default:
                return '';
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        // 최종 유효성 검사
        if (!errors.userName && !errors.userId && !errors.userPw && !errors.confirmPassword) {
            try {
                const response = await axios.post('//localhost:8082/user/signup', formData);
                console.log('회원가입 성공:', response.data);

                alert('회원가입 성공')
                navigate('/login')
                // 성공 메시지 표시 또는 다른 페이지로 이동 등 처리
                //setFormData({ userName: '', userId: '', userPw: '' , confirmPassword: ''}); // 폼 초기화
            } catch (error) {
                console.error('회원가입 실패:', error);
            }
        } else {
            console.log('유효성 검사 실패:', errors);
        }
    };

    return (
        <div className="signup-container">
            <h2>회원가입</h2>
            <form className="signup-form" onSubmit={handleSubmit}>
                <input
                    type="text"
                    name="userId"
                    placeholder="user ID"
                    value={formData.userId}
                    onChange={handleChange}
                />
                {errors.userId && <span className="error">{errors.userId}</span>}
                <input type="text"
                       name="userName"
                       placeholder="user Name"
                       value={formData.userName}
                       onChange={handleChange}/>
                {errors.userName && <span className="error">{errors.userName}</span>}
                <input
                    type="password"
                    name="userPw"
                    placeholder="password"
                    value={formData.userPw}
                    onChange={handleChange}
                />
                {errors.userPw && <span className="error">{errors.userPw}</span>}
                <input
                    type="password"
                    name="confirmPassword"
                    placeholder="confirm Password"
                    value={formData.confirmPassword}
                    onChange={handleChange}
                />
                {errors.confirmPassword && <span className="error">{errors.confirmPassword}</span>}
                <br/>
                <button>회원가입</button>
            </form>
        </div>

    );
}

//export default Auth(Join, false);
export default Join;
