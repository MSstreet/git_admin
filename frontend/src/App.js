/* App.js */
import {Route, Routes} from "react-router-dom";
import NoticeList from "./routes/NoticeList";
import Home from "./routes/Home";
import React from "react";
import NoticeDetail from "./routes/NoticeDetail";
import NoticeWrite from './routes/NoticeWrite';
import NoticeUpdate from './routes/NoticeUpdate';
import Login from './components/common/Login';
import Join from './components/common/Join';
import ReviewList from "./routes/review/ReviewList";
import ReviewDetail from "./routes/review/ReviewDetail";


function App() {
    return (
        <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="/notice" element={<NoticeList/>}/>
            <Route path="/notice/:noticeIdx" element={<NoticeDetail/>}/>
            <Route path="/write" element={<NoticeWrite />} />
            <Route path="/update/:noticeIdx" element={<NoticeUpdate />} />
            <Route path="/login" element={<Login />} />
            <Route path="/join" element={<Join />} />
            <Route path="/review" element={<ReviewList />} />
            <Route path="/review/:reviewIdx" element={<ReviewDetail/>}/>
        </Routes>
    );
}

export default App;