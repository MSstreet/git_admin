import React from "react";
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import NoticeList from "./routes/NoticeList";
import NoticeDetail from "./routes/NoticeDetail";
import NoticeWrite from './routes/NoticeWrite';
import NoticeUpdate from './routes/NoticeUpdate';
import ReviewList from "./routes/review/ReviewList";
import ReviewDetail from "./routes/review/ReviewDetail";
import Home from "./pages/Home";
import Login from './pages/Login';
import Join from './pages/Join';
import User from './pages/User';
import About from './pages/About';
import LoginContextProvider from './contexts/LoginContextProvider';
import './App.css';
import Admin from "./pages/Admin";

function App() {
    return (

        <LoginContextProvider>
            <Routes>
                <Route path="/" element={<Home/>}></Route>
                <Route path="/login" element={<Login/>}></Route>
                <Route path="/join" element={<Join/>}></Route>
                <Route path="/user" element={<User/>}></Route>
                <Route path="/about" element={<About/>}></Route>
                <Route path="/admin" element={<Admin/>}></Route>
                <Route path="/notice" element={<NoticeList/>}/>
                <Route path="/notice/:noticeIdx" element={<NoticeDetail/>}/>
                <Route path="/write" element={<NoticeWrite />} />
                <Route path="/update/:noticeIdx" element={<NoticeUpdate />} />
                <Route path="/review" element={<ReviewList />} />
                <Route path="/review/:reviewIdx" element={<ReviewDetail/>}/>
            </Routes>
        </LoginContextProvider>

    );
}

export default App;