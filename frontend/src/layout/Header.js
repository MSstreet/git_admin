/* Header.js */
import React from 'react';
import {Link} from "react-router-dom";
import "../style/Nav.css"

const Header = () => {
    return (
        <header>
            <nav id="nav2">
                <a><Link to="/">logo</Link></a>
                <ul>
                    <li><Link to="/">홈</Link></li>
                    &nbsp;&nbsp; | &nbsp;&nbsp;
                    <li><Link to="/notice">공지사항</Link></li>
                    &nbsp;&nbsp; | &nbsp;&nbsp;
                    <li><Link to="/review">리뷰</Link></li>
                    &nbsp;&nbsp; | &nbsp;&nbsp;
                    <li><Link to="/login">로그인</Link></li>
                </ul>
            </nav>
            <hr></hr>
        </header>
    );
};

export default Header;