/* index.js */
import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import {BrowserRouter} from "react-router-dom";
import Footer from "./layout/Footer";
import { Provider } from "react-redux";
import { applyMiddleware, createStore } from "redux";
import promiseMiddleware from "redux-promise"; // promise를 사용하기 위한 미들웨어
import {thunk} from "redux-thunk";// 비동기를 사용하기 위한 미들웨어
import Reducer from "./reducers/index.js";
import './index.css';
// import LoginContextProvider from './contexts/LoginContextProvider';
// import Header from "./components/Header/Header";
const createStoreWithMiddleware = applyMiddleware(
    promiseMiddleware,
    thunk
)(createStore);



const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(

    <Provider
        store={createStoreWithMiddleware(
            Reducer,
            window.__REDUX_DEVTOOLS_EXTENSION__ &&
            window.__REDUX_DEVTOOLS_EXTENSION__()
        )}
    >
    <BrowserRouter>
            <App/>
            <Footer/>
    </BrowserRouter>
    </Provider>

);
