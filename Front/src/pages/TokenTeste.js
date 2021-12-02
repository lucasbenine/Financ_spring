import React, { useState, useEffect } from 'react';
import api from '../api.js';
import axios from 'axios';


function TokenTeste() {


    useEffect(() => {

        
        const data = {
            username: 'fernando',
            password: 'financ'
        }

        axios.post('http://localhost:8080/login', data)
            .then(res => {
                localStorage.setItem('token', res.data);
        })

    }, [])

  return <h3>Teste do token desgraçado</h3>;
}

export default TokenTeste;