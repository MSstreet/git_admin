/* App.js */
import {Route, Routes} from "react-router-dom";
import NoticeList from "./routes/NoticeList";
import Home from "./routes/Home";
import React from "react";
import NoticeDetail from "./routes/NoticeDetail";

function App() {
    return (
        <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="/notice" element={<NoticeList/>}/>
            <Route path="/notice/:noticeIdx" element={<NoticeDetail/>}/>
        </Routes>
    );
}

export default App;