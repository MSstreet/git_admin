import React from 'react'
import Header from '../components/Header/Header'
import LoginContextConsumer from '../contexts/LoginContextConsumer'
import JoinForm from "../components/Join/Join";

const Join = () => {
    return (
        <>
            <Header />
            <div className='container'>
                <JoinForm/>
            </div>
        </>
    )
}

export default Join