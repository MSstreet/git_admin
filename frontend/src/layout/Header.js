/* Header.js */
import React from 'react';
import {Link} from "react-router-dom";
import "../style/Nav.css"

const Header = () => {
    return (
        <header>
            <div className="navbar">
                <Link className="navbarMenu" to="/">홈</Link>
                &nbsp;&nbsp; | &nbsp;&nbsp;
                <Link className="navbarMenu" to="/notice">게시판</Link>
                &nbsp;&nbsp; | &nbsp;&nbsp;
                <Link className="navbarMenu" to="/login">로그인</Link>
            </div>
        <hr></hr>
        </header>
    );
};

export default Header;