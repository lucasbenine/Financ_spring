import axios from 'axios';
import React, { createContext, useState, useEffect } from 'react';
import { Redirect } from 'react-router-dom';
import api from '../api';
import history from '../history';
const Context = createContext();

function AuthProvider({ children }) {

    const [authenticated, setAuthenticated] = useState(false);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const token = localStorage.getItem('token');

        if(token) {
            api.defaults.headers.Authorization = `Bearer ${token}`;
            setAuthenticated(true);
        }

        setLoading(false);
    }, [])

    // const usuario = {
    //     username: 'fernando',
    //     password: 'financ'
    // }

    function redirect() {
        return <Redirect to="/inicio" />
    }

    async function handleLogin(userName, password, event) {
        const usuario = {
            username: userName,
            password: password
        }
        console.log("usuario: " + userName)
        console.log("senha: " + password)

        // event.preventDefault();

        await axios.post('http://localhost:8080/login', usuario)
            .then(res => {
                const token = res.data;
                console.log(token)
                localStorage.setItem('token', res.data);
                api.defaults.headers.Authorization = `Bearer ${token}`;
                setAuthenticated(true);
                window.location.href = '/inicio';
            })
    }

    function handleLogout() {
        setAuthenticated(false);
        localStorage.removeItem('token');
        api.defaults.headers.Authorization = undefined;
        history.push('/login');
    }

    if(loading) {
        return <h1>Loading</h1>
    }

    

    return (
        <Context.Provider value={{ authenticated, handleLogin, handleLogout }}>
            {children}
        </Context.Provider>
    );
}

export { Context, AuthProvider };