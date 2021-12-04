import styled from 'styled-components';
import Logo from '../img/logo.png';
import {Link} from 'react-router-dom';
import { useHistory } from "react-router-dom";
import axios from 'axios';
import Carousel1 from '../img/carousel1.png';
import { useState } from 'react';

const LoginWrapper = styled.div`
    width: 100vw;
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
`

const LoginContainer = styled.div `
    width: 70%;
    height: 80%;
    display: flex;
    box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;

    .form-wrapper {
        width: 45%;
        height: 100%;
        display: flex;
        flex-flow: column nowrap;
        align-items: center;
        justify-content: center;

        .logo-financ {
            width: 50%;
            height: auto;
        }

        .login-form {
            margin-top: 10%;
            display: flex;
            flex-flow: column nowrap;
            align-items: center;
            justify-content: center;
            width: 65%;

            .form-input {
                width: 100%;
                padding: 1rem;
                margin-top: 10%;
                border-radius: 3px;
                outline: none;
                border: 2px solid transparent;
                font-size: 1rem;
                background-color: #e6e6e6;
                color: black;
                transition: .3s;
            }

            .form-input:focus{
                border: 2px solid #00DC88;
            }

            .checkbox {
                margin-top: 7%;
                width: 80%;
                display: flex;
                align-items: center;
                justify-content: center;

                input {
                    margin-right: 2%;
                }

                span {
                    margin-left: 2%;
                }
            }

            .logar-button {
                margin-top: 10%;
                width: 70%;
                padding: 1rem;
                font-size: 1.4rem;
                outline: none;
                border: none;
                background-color: #00DC88;
                border-radius: 3px;
                font-weight: bold;
                transition: .5s;
            }

            .logar-button:hover {
                background-color: #00346F;
                color: white;
            }

        }

        .link-cadastro {
            font-size: 1.2rem;
            margin-top: 10%;
            text-align: center;
        }

    }

    //CAROUSELL 

    .green {
        width: 55%;
        background-color: #00DC88;
        display: flex;
        align-items: center;
        justify-content: center;

        img {
            min-width: 450px;
            max-width: 34%;
            height: auto;
            position: absolute;
            bottom: 10%;
        }
    }

    @media(max-width: 1025px) {
        width: 90%;
    }

    @media (max-width: 767px) {
        .green {
            display: none;
        }

        .form-wrapper {
            width: 100%;
        }
    }

    @media(max-width: 451px) {
        
        .logo-financ {
            width: 70%;
        }
    }

`;

function Login () {
    
    const [senha, setSenha] = useState(false);   

    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');
    const history = useHistory();

    function handleSubmit(e) {
        const usuario = {
            username: userName,
            password: password
        }
        e.preventDefault()

        console.log(usuario);
        console.log(senha);

        axios.post('http://localhost:8080/login', usuario)

        .then(res => {
            localStorage.setItem('token', res.usuario);
            history.push('/inicio');
        })
    }

    return(
        <LoginWrapper>
            <LoginContainer>
                <div className="form-wrapper">
                    <img src={Logo} className="logo-financ" alt="Logo Financ" />
                    <form className="login-form" onSubmit={handleSubmit}>
                        <input className="form-input" required="required" type="text" placeholder="Nome de usuario" value={userName} onChange={(e) => setUserName(e.target.value)} name="email"/>
                        <input className="form-input" required="required" type={senha ? "text" : "password"} placeholder="Senha" value={password} onChange={(e) => setPassword(e.target.value)} name="senha"/>
                        <div className="checkbox">
                            <input type="checkbox" onChange={() => setSenha(!senha)}/>
                            <span>Mostrar senha?</span>
                        </div>
                        <button className="logar-button" type="submit">Entrar</button>
                        <p className="link-cadastro">Não fez seu cadastro ainda? <Link to="/cadastro"> Cadastre-se!</Link></p>
                    </form>
                </div>
                <div className="green">
                    <img src={Carousel1} alt="Moça com um pote de dinheiro" />
                </div>
            </LoginContainer>
        </LoginWrapper>
    )
}

export default Login;