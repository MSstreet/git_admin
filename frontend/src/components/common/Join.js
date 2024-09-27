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
        email: '',
        name: '',
        password: '',
        confirmPassword: '',
    });

    const [errors, setErrors] = useState({
        email: '',
        name: '',
        password: '',
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
            case 'name':
                if (value.length < 2) {
                    return '사용자 이름은 2자 이상이어야 합니다.';
                }
                return '';
            case 'email':
                const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                if (!emailPattern.test(value)) {
                    return '유효한 이메일 주소를 입력하세요.';
                }
                return '';
            case 'password':
                if (value.length < 6) {
                    return '비밀번호는 6자 이상이어야 합니다.';
                }
                return '';
            case 'confirmPassword':
                if (value !== formData.password) {
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
        if (!errors.name && !errors.email && !errors.password && !errors.confirmPassword) {
            try {
                const response = await axios.post('/api/signup', formData);
                console.log('회원가입 성공:', response.data);
                // 성공 메시지 표시 또는 다른 페이지로 이동 등 처리
                setFormData({ name: '', email: '', password: '' , confirmPassword: ''}); // 폼 초기화
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
                    type="email"
                    name="email"
                    placeholder="email"
                    value={formData.email}
                    onChange={handleChange}
                />
                {errors.email && <span className="error">{errors.email}</span>}
                <input type="text" name="name" value={formData.name} onChange={handleChange}/>
                {errors.name && <span className="error">{errors.name}</span>}
                <input
                    type="password"
                    name="password"
                    placeholder="password"
                    value={formData.password}
                    onChange={handleChange}
                />
                {errors.password && <span className="error">{errors.password}</span>}
                <input
                    type="password"
                    name="confirmPassword"
                    placeholder="confirmPassword"
                    value={formData.confirmPassword}
                    onChange={handleChange}
                />
                {errors.confirmPassword && <span className="error">{errors.confirmPassword}</span>}
                <br/>
                <button>회원가입</button>
            </form>
            <form className="signup-form" onSubmit={handleSubmit}>
                <input
                    type="email"
                    name="email"
                    placeholder="email"
                    value={formData.email}
                    onChange={handleChange}
                />
                {errors.email && <span className="error">{errors.email}</span>}
                <input type="text" name="name" value={formData.name} onChange={handleChange}/>
                {errors.name && <span className="error">{errors.name}</span>}
                <input
                    type="password"
                    name="password"
                    placeholder="password"
                    value={formData.password}
                    onChange={handleChange}
                />
                {errors.password && <span className="error">{errors.password}</span>}
                <input
                    type="password"
                    name="confirmPassword"
                    placeholder="confirmPassword"
                    value={formData.confirmPassword}
                    onChange={handleChange}
                />
                {errors.confirmPassword && <span className="error">{errors.confirmPassword}</span>}
                <br/>
                <button>회원가입</button>
                <form className="signup-form" onSubmit={handleSubmit}>
                    <input
                        type="email"
                        name="email"
                        placeholder="email"
                        value={formData.email}
                        onChange={handleChange}
                    />
                    {errors.email && <span className="error">{errors.email}</span>}
                    <input type="text" name="name" value={formData.name} onChange={handleChange}/>
                    {errors.name && <span className="error">{errors.name}</span>}
                    <input
                        type="password"
                        name="password"
                        placeholder="password"
                        value={formData.password}
                        onChange={handleChange}
                    />
                    {errors.password && <span className="error">{errors.password}</span>}
                    <input
                        type="password"
                        name="confirmPassword"
                        placeholder="confirmPassword"
                        value={formData.confirmPassword}
                        onChange={handleChange}
                    />
                    {errors.confirmPassword && <span className="error">{errors.confirmPassword}</span>}
                    <br/>
                    <button>회원가입</button>
                </form>
            </form>
        </div>

    );
}

//export default Auth(Join, false);
export default Join;