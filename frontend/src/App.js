/* App.js */
import {Route, Routes} from "react-router-dom";
import NoticeList from "./routes/NoticeList";
import Home from "./routes/Home";
import React from "react";
import NoticeDetail from "./routes/NoticeDetail";
import NoticeWrite from './routes/NoticeWrite';
import NoticeUpdate from './routes/NoticeUpdate';

function App() {
    return (
        <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="/notice" element={<NoticeList/>}/>
            <Route path="/notice/:noticeIdx" element={<NoticeDetail/>}/>
            <Route path="/write" element={<NoticeWrite />} />
            <Route path="/update/:noticeIdx" element={<NoticeUpdate />} />
        </Routes>
    );
}

export default App;